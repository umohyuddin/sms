package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.enums.AcademicYearStatus;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

@Service
@Slf4j
public class AcademicYearService {
    private final AcademicYearRepository academicYearRepository;

    public AcademicYearService(AcademicYearRepository academicYearRepository) {
        this.academicYearRepository = academicYearRepository;
    }

    public List<AcademicYearResponseDTO> searchByKeyword(String keyword) {
        try {
            log.info("Searching Academic Years by keyword: {}", keyword);

            List<AcademicYearEntity> result;
            if (keyword == null || keyword.isBlank()) {
                result = academicYearRepository.findAll();
            } else {
                result = academicYearRepository.searchByName(keyword); // <-- you'll add this query in repository
            }

            List<AcademicYearResponseDTO> responseDTOS = MapperUtil.mapList(result, AcademicYearResponseDTO.class);
            log.info("Found {} academic years matching keyword", responseDTOS.size());
            return responseDTOS;

        } catch (DataAccessException dae) {
            log.error("Database error while searching academic years: {}", dae.getMessage());
            throw new CustomServiceException("Unable to fetch Academic Years from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping AcademicYear entity to DTO: {}", me.getMessage());
            throw new CustomServiceException("Error converting Academic Years data", me);
        } catch (Exception e) {
            log.error("Unexpected error while searching academic years: {}", e.getMessage());
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public AcademicYearResponseDTO getCurrentAcademicYear() {
        try {
            log.info("Fetching current Academic Year...");
            AcademicYearEntity current = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> new RuntimeException("No active academic year found"));
            return MapperUtil.mapObject(current, AcademicYearResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching current academic year", dae);
            throw new RuntimeException("Failed to fetch current academic year due to database issue");
        } catch (Exception e) {
            log.error("Unexpected error while fetching current academic year", e);
            throw new RuntimeException("Failed to fetch current academic year");
        }
    }

    public AcademicYearResponseDTO getAcademicYearById(Long id) {
        try {
            log.info("Fetching Academic Year by id: {}", id);
            AcademicYearEntity academicYear = academicYearRepository.findActiveById(id).orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + id));
            return MapperUtil.mapObject(academicYear, AcademicYearResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching academic year with id: {}", id, dae);
            throw new RuntimeException("Failed to fetch academic year due to database issue");
        } catch (Exception e) {
            log.error("Unexpected error while fetching academic year with id: {}", id, e);
            throw new RuntimeException("Failed to fetch academic year");
        }
    }


    public AcademicYearResponseDTO createAcademicYear(@Valid AcademicYearRequestDTO requestDTO) {
        log.info("Creating new Academic Year: {}", requestDTO.getName());

        try {
            // Validate date logic
            if (requestDTO.getStartDate().isAfter(requestDTO.getEndDate())) {
                throw new IllegalArgumentException("Start date cannot be after end date.");
            }
            validateNameFormat(requestDTO.getName());

            if (Boolean.TRUE.equals(requestDTO.getIsCurrent())) {
                log.info("Deactivating previous academic years...");
                academicYearRepository.deactivateAllAcademicYears();
            }
            // ---- Optional: Check for overlapping years ----
            boolean overlaps = academicYearRepository.existsByDateRange(requestDTO.getStartDate(), requestDTO.getEndDate());
            if (overlaps) {
                throw new IllegalArgumentException("Academic Year overlaps with an existing academic year.");
            }

            // ---- Handle current year logic ----
//            if (Boolean.TRUE.equals(requestDTO.getIsCurrent())) {
//                log.info("Deactivating previous current academic years...");
//                academicYearRepository.deactivateAllAcademicYears();
//            }


            AcademicYearEntity academicYearEntity = MapperUtil.mapObject(requestDTO, AcademicYearEntity.class);
            academicYearEntity.setIsCurrent(false);
            academicYearEntity.setStatus(AcademicYearStatus.DRAFT); // default for new year
            academicYearEntity.setIsLocked(false);
            // Calculate total months
            //requestDTO.getStartDate() → the start date (e.g., 2025-01-15)
            //.withDayOfMonth(1) → normalize to the first day of the month (2025-01-01)
            //Same for requestDTO.getEndDate() (e.g., 2025-03-10 → 2025-03-01)
            //ChronoUnit.MONTHS.between(start, end) → counts full months between the two normalized dates:

            long monthsBetween = ChronoUnit.MONTHS.between(requestDTO.getStartDate().withDayOfMonth(1), requestDTO.getEndDate().withDayOfMonth(1)) + 1;
            academicYearEntity.setTotalMonths(monthsBetween);

            // Save entity
            academicYearEntity = academicYearRepository.save(academicYearEntity);
            log.info("Academic Year saved with id: {}", academicYearEntity.getId());

            // Map back to DTO
            return MapperUtil.mapObject(academicYearEntity, AcademicYearResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while creating Academic Year", dae);
            throw new RuntimeException("Failed to create Academic Year due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Academic Year", e);
            throw new RuntimeException("Failed to create Academic Year");
        }
    }


    @Transactional
    public void makeAcademicYearCurrent(Long academicYearId) {

        log.info("Request to activate Academic Year with id: {}", academicYearId);

        AcademicYearEntity year = academicYearRepository.findById(academicYearId)
                .orElseThrow(() -> new IllegalArgumentException("Academic Year not found"));

        //Locked year cannot be activated
        if (Boolean.TRUE.equals(year.getIsLocked())) {
            throw new IllegalStateException("Locked Academic Year cannot be activated");
        }

        //Invalid status check
        if (year.getStatus() == AcademicYearStatus.CLOSED ||
                year.getStatus() == AcademicYearStatus.ARCHIVED) {
            throw new IllegalStateException("Closed or archived Academic Year cannot be activated");
        }

        // Prevent activating future year
        if (year.getStartDate().isAfter(LocalDate.now())) {
            throw new IllegalStateException("Cannot activate an Academic Year that has not started yet");
        }

        // Prevent activating expired year
        if (year.getEndDate().isBefore(LocalDate.now())) {
            throw new IllegalStateException("Cannot activate an Academic Year that has already ended");
        }

        // If already current, skip
        if (Boolean.TRUE.equals(year.getIsCurrent())) {
            log.info("Academic Year is already current: {}", year.getName());
            return;
        }

        // Check overlapping with existing active year
        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElse(null);


        if (currentYear != null && !currentYear.getId().equals(year.getId())) {

            // Optional: prevent switching if current year still running
            if (currentYear.getEndDate().isAfter(LocalDate.now())) {
                throw new IllegalStateException(
                        "Another Academic Year is already active and still running"
                );
            }
            currentYear.setIsCurrent(false);
            academicYearRepository.save(currentYear);
        }

        // Required setup validations (optional but recommended)
//        if (!classService.existsForAcademicYear(year.getId())) {
//            throw new IllegalStateException("Classes are not configured for this Academic Year");
//        }

//        if (!sectionService.existsForAcademicYear(year.getId())) {
//            throw new IllegalStateException("Sections are not configured for this Academic Year");
//        }
//
//        if (!feeService.isFeeConfigured(year.getId())) {
//            throw new IllegalStateException("Fee structure is not configured for this Academic Year");
//        }
//
//        if (!subjectService.isSubjectAssigned(year.getId())) {
//            throw new IllegalStateException("Subjects are not assigned for this Academic Year");
//        }

        // Deactivate previous current academic year
        academicYearRepository.deactivateAllAcademicYears();

        // Activate this academic year
        year.setIsCurrent(true);
        year.setStatus(AcademicYearStatus.ACTIVE);

        academicYearRepository.save(year);

        //Audit logging (highly recommended)
//        auditLogService.logAcademicYearActivation(
//                year.getId(),
//                year.getName(),
//                SecurityUtil.getCurrentUser()
//        );

        log.info("Academic Year '{}' successfully activated", year.getName());
    }

    @Transactional
    public void deleteAcademicYear(Long academicYearId) {

        AcademicYearEntity year = academicYearRepository.findById(academicYearId)
                .orElseThrow(() -> new IllegalArgumentException("Academic Year not found"));

        // Prevent deleting current year
        if (Boolean.TRUE.equals(year.getIsCurrent())) {
            throw new IllegalStateException("Current Academic Year cannot be deleted");
        }

        // Prevent deleting locked year
        if (Boolean.TRUE.equals(year.getIsLocked())) {
            throw new IllegalStateException("Locked Academic Year cannot be deleted");
        }

        // Already deleted check
        if (year.getStatus() == AcademicYearStatus.DELETED) {
            return;
        }

        // Soft delete
        year.setStatus(AcademicYearStatus.DELETED);
        year.setIsCurrent(false);
        year.setDeletedAt(LocalDateTime.now());
        year.setDeletedBy(1L);

        academicYearRepository.save(year);

        log.info("Academic Year soft deleted successfully: {}", year.getName());
    }


//    public AcademicYearResponseDTO updateAcademicYear(Long id, @Valid AcademicYearRequestDTO requestDTO) {
//        log.info("Updating Academic Year with id: {}", id);
//
//        try {
//            AcademicYearEntity existingEntity = academicYearRepository.findById(id)
//                    .orElseThrow(() -> new RuntimeException("Academic Year not found with id: " + id));
//
//            // Validate dates
//            if (requestDTO.getStartDate().isAfter(requestDTO.getEndDate())) {
//                throw new IllegalArgumentException("Start date cannot be after end date.");
//            }
//
//            // Validate name format
//            validateNameFormat(requestDTO.getName());
//
//            // If setting current = true, deactivate others
//            if (Boolean.TRUE.equals(requestDTO.getIsCurrent())) {
//                log.info("Deactivating other academic years...");
//                academicYearRepository.deactivateAllAcademicYears();
//            }
//
//            // Update fields
//            existingEntity.setName(requestDTO.getName());
//            existingEntity.setStartDate(requestDTO.getStartDate());
//            existingEntity.setEndDate(requestDTO.getEndDate());
//            existingEntity.setIsCurrent(requestDTO.getIsCurrent());
//
//            // Recalculate total months
//            long totalMonths = ChronoUnit.MONTHS.between(
//                    requestDTO.getStartDate().withDayOfMonth(1),
//                    requestDTO.getEndDate().withDayOfMonth(1)
//            ) + 1;
//
//            existingEntity.setTotalMonths(totalMonths);
//
//            AcademicYearEntity updatedEntity = academicYearRepository.save(existingEntity);
//            log.info("Academic Year updated successfully with id: {}", updatedEntity.getId());
//
//            return MapperUtil.mapObject(updatedEntity, AcademicYearResponseDTO.class);
//
//        } catch (DataAccessException dae) {
//            log.error("Database error while updating Academic Year with id: {}", id, dae);
//            throw new RuntimeException("Failed to update Academic Year due to database error");
//        } catch (Exception e) {
//            log.error("Unexpected error while updating Academic Year with id: {}", id, e);
//            throw new RuntimeException("Failed to update Academic Year");
//        }
//    }

    @Transactional
    public AcademicYearResponseDTO updateAcademicYear(
            Long id,
            @Valid AcademicYearRequestDTO requestDTO) {

        log.info("Updating Academic Year with id: {}", id);

        try {
            AcademicYearEntity existingEntity = academicYearRepository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Academic Year not found with id: " + id));

            // Prevent update if year is locked
            if (Boolean.TRUE.equals(existingEntity.getIsLocked())) {
                throw new IllegalStateException("Locked Academic Year cannot be updated.");
            }

            // Validate date logic
            if (requestDTO.getStartDate().isAfter(requestDTO.getEndDate())) {
                throw new IllegalArgumentException("Start date cannot be after end date.");
            }

            // Validate name format
            validateNameFormat(requestDTO.getName());

            // Check overlapping academic years (exclude current record)
            boolean overlaps = academicYearRepository.existsByDateRangeExcludingId(
                    requestDTO.getStartDate(),
                    requestDTO.getEndDate(),
                    id
            );
            if (overlaps) {
                throw new IllegalArgumentException(
                        "Academic Year overlaps with an existing academic year."
                );
            }



            //Update fields
            existingEntity.setName(requestDTO.getName());
            existingEntity.setStartDate(requestDTO.getStartDate());
            existingEntity.setEndDate(requestDTO.getEndDate());
            existingEntity.setIsCurrent(requestDTO.getIsCurrent());
            existingEntity.setRemarks(requestDTO.getRemarks());
            // Recalculate total months
            long totalMonths = ChronoUnit.MONTHS.between(
                    requestDTO.getStartDate().withDayOfMonth(1),
                    requestDTO.getEndDate().withDayOfMonth(1)
            ) + 1;
            existingEntity.setTotalMonths(totalMonths);

            // Save updated entity
            AcademicYearEntity updatedEntity =
                    academicYearRepository.save(existingEntity);

            log.info("Academic Year updated successfully with id: {}", updatedEntity.getId());

            return MapperUtil.mapObject(updatedEntity, AcademicYearResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while updating Academic Year with id: {}", id, dae);
            throw new RuntimeException(
                    "Failed to update Academic Year due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while updating Academic Year with id: {}", id, e);
            throw new RuntimeException("Failed to update Academic Year");
        }
    }

    public List<AcademicYearResponseDTO> getAll() {
        try {
            log.info("Fetching all active Academic Years from database...");

            // Fetch active (not deleted) academic years
            List<AcademicYearEntity> result = academicYearRepository.findAllActiveAcademicYears();
            log.info("Fetched {} active Academic Years from database.", result.size());

            // Map entities to DTOs
            List<AcademicYearResponseDTO> responseDTOS = MapperUtil.mapList(result, AcademicYearResponseDTO.class);
            log.info("Mapped {} Academic Year entities to DTOs successfully.", responseDTOS.size());

            return responseDTOS;

        } catch (DataAccessException dae) {
            log.error("Database error while fetching Academic Years.", dae);
            // Optional: throw new CustomServiceException("Unable to fetch Academic Years from database.", dae);

        } catch (MappingException me) {
            log.error("Error mapping AcademicYearEntity to AcademicYearResponseDTO.", me);
            // Optional: throw new CustomServiceException("Error converting Academic Year data.", me);

        } catch (Exception e) {
            log.error("Unexpected error while fetching Academic Years.", e);
            // Optional: throw new CustomServiceException("Unexpected error occurred while fetching Academic Years.", e);
        }

        // Return empty list in case of error
        return Collections.emptyList();
    }

    @Transactional
    public void lockAcademicYear(Long id, AcademicYearRequestDTO request) {

        AcademicYearEntity year = academicYearRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Academic Year not found"));

        if (Boolean.TRUE.equals(year.getIsLocked())) {
            throw new IllegalStateException("Academic Year is already locked");
        }

        if (Boolean.TRUE.equals(year.getIsCurrent())) {
            throw new IllegalStateException("Current Academic Year cannot be locked");
        }

        if (LocalDate.now().isBefore(year.getEndDate())) {
            throw new IllegalStateException("Academic Year cannot be locked before end date");
        }

        if (!EnumSet.of(AcademicYearStatus.CLOSED, AcademicYearStatus.ARCHIVED)
                .contains(year.getStatus())) {
            throw new IllegalStateException("Academic Year status does not allow locking");
        }

        // Optional validations
        // validateNoPendingFees(year.getId());
        // validateNoPendingPayroll(year.getId());

        year.setIsLocked(true);
        year.setLockedAt(LocalDateTime.now());
        year.setLockedBy(1L);
        year.setStatus(AcademicYearStatus.LOCKED);
        if (request.getRemarks() == null || request.getRemarks().isBlank()) {
            throw new IllegalStateException("Remarks are required to lock Academic Year");
        }
        academicYearRepository.save(year);
    }


    @Transactional
    public void archiveAcademicYear(Long id, AcademicYearRequestDTO request) {

        AcademicYearEntity year = academicYearRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Academic Year not found"));

        // Rule 1: Already archived
        if (AcademicYearStatus.ARCHIVED.equals(year.getStatus())) {
            throw new IllegalStateException("Academic Year is already archived");
        }

        // Rule 2: Cannot archive current year
        if (Boolean.TRUE.equals(year.getIsCurrent())) {
            throw new IllegalStateException("Current Academic Year cannot be archived");
        }

        // Rule 3: End date must be passed
        if (LocalDate.now().isBefore(year.getEndDate())) {
            throw new IllegalStateException("Academic Year cannot be archived before end date");
        }

        // Rule 4: Only locked years can be archived (recommended)
        if (!Boolean.TRUE.equals(year.getIsLocked())) {
            throw new IllegalStateException("Only locked Academic Years can be archived");
        }

        // Optional: remarks validation
        if (request.getRemarks() == null || request.getRemarks().isBlank()) {
            throw new IllegalStateException("Remarks are required to archive Academic Year");
        }

        // State update
        year.setStatus(AcademicYearStatus.ARCHIVED);
        year.setIsCurrent(false);
        year.setRemarks(request.getRemarks());

        academicYearRepository.save(year);
    }
    @Transactional
    public void closeAcademicYear(Long id, AcademicYearRequestDTO request) {

        // Fetch academic year
        AcademicYearEntity year = academicYearRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Academic Year not found with ID: " + id));

        // Rule 1: Cannot close already closed
        if (AcademicYearStatus.CLOSED.equals(year.getStatus())) {
            throw new IllegalStateException("Academic Year is already closed");
        }

        // Rule 2: Cannot close current year
        if (Boolean.TRUE.equals(year.getIsCurrent())) {
            throw new IllegalStateException("Current Academic Year cannot be closed");
        }

        // Rule 3: End date must have passed
        if (LocalDate.now().isBefore(year.getEndDate())) {
            throw new IllegalStateException("Academic Year cannot be closed before its end date");
        }

        // Optional: All results finalized
        // if (!resultsService.areResultsFinalized(year.getId())) {
        //     throw new IllegalStateException("Cannot close Academic Year before results are finalized");
        // }

        // Optional: No pending financials
        // validateNoPendingFees(year.getId());
        // validateNoPendingPayroll(year.getId());

        // Optional: Validate remarks
        if (request.getRemarks() == null || request.getRemarks().isBlank()) {
            year.setRemarks("Closed by system"); // default remark
        } else {
            year.setRemarks(request.getRemarks());
        }

        // Update status
        year.setStatus(AcademicYearStatus.CLOSED);

        academicYearRepository.save(year);
    }


    @Transactional
    public AcademicYearResponseDTO createDefaultAcademicYear() {

        // Check if any academic year exists
        List<AcademicYearEntity> existingYears = academicYearRepository.findAll();
        if (!existingYears.isEmpty()) {
            // Do nothing if years already exist
            return null;
        }

        // Create default year dynamically
        int currentYear = LocalDate.now().getYear();
        int nextYear = currentYear + 1;

        AcademicYearRequestDTO defaultYear = new AcademicYearRequestDTO();
        defaultYear.setName(currentYear + "-" + nextYear);
        defaultYear.setCode("AY-" + currentYear + "-" + nextYear);
        defaultYear.setStartDate(LocalDate.of(currentYear, 1, 1));
        defaultYear.setEndDate(LocalDate.of(currentYear, 12, 31));
        defaultYear.setStatus(AcademicYearStatus.DRAFT); // or ACTIVE
        defaultYear.setRemarks("Default Academic Year created automatically");

        // Save using existing create method
        return createAcademicYear(defaultYear);
    }

    private void validateNameFormat(String name) {
        if (!name.matches("\\d{4}-\\d{4}")) {
            throw new IllegalArgumentException("Academic year name must be in 'YYYY-YYYY' format.");
        }
    }

    private long calculateMonths(LocalDate start, LocalDate end) {
        return java.time.temporal.ChronoUnit.MONTHS.between(start, end) + 1;
    }


}



