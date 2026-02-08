package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.enums.AcademicYearStatus;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
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
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Academic Years based on search from database with keyword: '{}'", searchKey);

            List<AcademicYearEntity> result = academicYearRepository.searchByName(searchKey);
            log.info("Successfully fetched {} Academic Years based on search", result.size());

            return MapperUtil.mapList(result, AcademicYearResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while searching Academic Years", e);
            throw new CustomServiceException("Unexpected error occurred while searching academic years", e);
        }
    }

    public AcademicYearResponseDTO getCurrentAcademicYear() {
        log.info("Fetching current Academic Year from database");
        try {
            AcademicYearEntity current = academicYearRepository.findByIsCurrentTrue()
                    .orElseThrow(() -> {
                        log.warn("No active academic year found in database");
                        return new ResourceNotFoundException("No active academic year found");
                    });
            log.info("Successfully fetched current Academic Year: id={}", current.getId());
            return MapperUtil.mapObject(current, AcademicYearResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching current Academic Year", e);
            throw new CustomServiceException("Failed to fetch current academic year", e);
        }
    }

    public AcademicYearResponseDTO getAcademicYearById(Long id) {
        log.info("Fetching Academic Year with ID: {} from database", id);
        try {
            AcademicYearEntity academicYear = academicYearRepository.findActiveById(id)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for ID: {}", id);
                        return new ResourceNotFoundException("Academic Year not found with id: " + id);
                    });
            log.info("Successfully fetched Academic Year: id={}", academicYear.getId());
            return MapperUtil.mapObject(academicYear, AcademicYearResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Academic Year ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch academic year", e);
        }
    }


    public AcademicYearResponseDTO createAcademicYear(@Valid AcademicYearRequestDTO requestDTO) {
        log.info("Creating new Academic Year in database: {}", requestDTO.getName());

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

            AcademicYearEntity academicYearEntity = MapperUtil.mapObject(requestDTO, AcademicYearEntity.class);
            academicYearEntity.setIsCurrent(false);
            academicYearEntity.setStatus(AcademicYearStatus.DRAFT); // default for new year
            academicYearEntity.setIsLocked(false);

            long monthsBetween = ChronoUnit.MONTHS.between(requestDTO.getStartDate().withDayOfMonth(1), requestDTO.getEndDate().withDayOfMonth(1)) + 1;
            academicYearEntity.setTotalMonths(monthsBetween);

            // Save entity
            AcademicYearEntity saved = academicYearRepository.save(academicYearEntity);
            log.info("Academic Year saved successfully with ID: {}", saved.getId());

            // Map back to DTO
            return MapperUtil.mapObject(saved, AcademicYearResponseDTO.class);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while creating Academic Year", e);
            throw new CustomServiceException("Failed to create Academic Year");
        }
    }


    @Transactional
    public void makeAcademicYearCurrent(Long academicYearId) {
        log.info("Request to activate Academic Year ID: {} in database", academicYearId);
        try {
            AcademicYearEntity year = academicYearRepository.findById(academicYearId)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for activation with ID: {}", academicYearId);
                        return new ResourceNotFoundException("Academic Year not found");
                    });

            if (Boolean.TRUE.equals(year.getIsLocked())) {
                throw new IllegalStateException("Locked Academic Year cannot be activated");
            }

            if (year.getStatus() == AcademicYearStatus.CLOSED ||
                    year.getStatus() == AcademicYearStatus.ARCHIVED) {
                throw new IllegalStateException("Closed or archived Academic Year cannot be activated");
            }

            if (year.getStartDate().isAfter(LocalDate.now())) {
                throw new IllegalStateException("Cannot activate an Academic Year that has not started yet");
            }

            if (year.getEndDate().isBefore(LocalDate.now())) {
                throw new IllegalStateException("Cannot activate an Academic Year that has already ended");
            }

            if (Boolean.TRUE.equals(year.getIsCurrent())) {
                log.info("Academic Year is already current: {}", year.getName());
                return;
            }

            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElse(null);

            if (currentYear != null && !currentYear.getId().equals(year.getId())) {
                if (currentYear.getEndDate().isAfter(LocalDate.now())) {
                    throw new IllegalStateException("Another Academic Year is already active and still running");
                }
                currentYear.setIsCurrent(false);
                academicYearRepository.save(currentYear);
            }

            academicYearRepository.deactivateAllAcademicYears();

            year.setIsCurrent(true);
            year.setStatus(AcademicYearStatus.ACTIVE);

            academicYearRepository.save(year);
            log.info("Academic Year successfully activated with ID: {}", year.getId());
        } catch (ResourceNotFoundException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while activating Academic Year ID: {}", academicYearId, e);
            throw new CustomServiceException("Failed to activate academic year", e);
        }
    }

    @Transactional
    public void deleteAcademicYear(Long academicYearId) {
        log.info("Soft delete request received for Academic Year ID: {}", academicYearId);
        try {
            AcademicYearEntity year = academicYearRepository.findById(academicYearId)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for deletion with ID: {}", academicYearId);
                        return new ResourceNotFoundException("Academic Year not found");
                    });

            if (Boolean.TRUE.equals(year.getIsCurrent())) {
                throw new IllegalStateException("Current Academic Year cannot be deleted");
            }

            if (Boolean.TRUE.equals(year.getIsLocked())) {
                throw new IllegalStateException("Locked Academic Year cannot be deleted");
            }

            if (year.getStatus() == AcademicYearStatus.DELETED) {
                return;
            }

            year.setStatus(AcademicYearStatus.DELETED);
            year.setIsCurrent(false);
            year.setDeletedAt(LocalDateTime.now());
            year.setDeletedBy(1L);

            academicYearRepository.save(year);
            log.info("Academic Year ID: {} soft deleted successfully", academicYearId);
        } catch (ResourceNotFoundException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting Academic Year ID: {}", academicYearId, e);
            throw new CustomServiceException("Failed to delete academic year", e);
        }
    }

    @Transactional
    public AcademicYearResponseDTO updateAcademicYear(
            Long id,
            @Valid AcademicYearRequestDTO requestDTO) {

        log.info("Updating Academic Year with ID: {} in database", id);

        try {
            AcademicYearEntity existingEntity = academicYearRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Academic Year not found with id: " + id);
                    });

            if (Boolean.TRUE.equals(existingEntity.getIsLocked())) {
                throw new IllegalStateException("Locked Academic Year cannot be updated.");
            }

            if (requestDTO.getStartDate().isAfter(requestDTO.getEndDate())) {
                throw new IllegalArgumentException("Start date cannot be after end date.");
            }

            validateNameFormat(requestDTO.getName());

            boolean overlaps = academicYearRepository.existsByDateRangeExcludingId(
                    requestDTO.getStartDate(),
                    requestDTO.getEndDate(),
                    id
            );
            if (overlaps) {
                throw new IllegalArgumentException("Academic Year overlaps with an existing academic year.");
            }

            existingEntity.setName(requestDTO.getName());
            existingEntity.setStartDate(requestDTO.getStartDate());
            existingEntity.setEndDate(requestDTO.getEndDate());
            existingEntity.setIsCurrent(requestDTO.getIsCurrent());
            existingEntity.setRemarks(requestDTO.getRemarks());
            
            long totalMonths = ChronoUnit.MONTHS.between(
                    requestDTO.getStartDate().withDayOfMonth(1),
                    requestDTO.getEndDate().withDayOfMonth(1)
            ) + 1;
            existingEntity.setTotalMonths(totalMonths);

            AcademicYearEntity saved = academicYearRepository.save(existingEntity);
            log.info("Academic Year updated successfully with ID: {}", saved.getId());

            return MapperUtil.mapObject(saved, AcademicYearResponseDTO.class);

        } catch (ResourceNotFoundException | IllegalArgumentException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating Academic Year ID: {}", id, e);
            throw new CustomServiceException("Failed to update Academic Year", e);
        }
    }

    public List<AcademicYearResponseDTO> getAll() {
        log.info("Fetching all active Academic Years from database");
        try {
            List<AcademicYearEntity> result = academicYearRepository.findAllActiveAcademicYears();
            log.info("Successfully fetched {} active Academic Years", result.size());

            return MapperUtil.mapList(result, AcademicYearResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Academic Years", e);
            throw new CustomServiceException("Unexpected error occurred while fetching Academic Years", e);
        }
    }

    @Transactional
    public void lockAcademicYear(Long id, AcademicYearRequestDTO request) {
        log.info("Locking Academic Year ID: {} in database", id);
        try {
            AcademicYearEntity year = academicYearRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for lock with ID: {}", id);
                        return new ResourceNotFoundException("Academic Year not found");
                    });

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

            year.setIsLocked(true);
            year.setLockedAt(LocalDateTime.now());
            year.setLockedBy(1L);
            year.setStatus(AcademicYearStatus.LOCKED);
            if (request.getRemarks() == null || request.getRemarks().isBlank()) {
                throw new IllegalStateException("Remarks are required to lock Academic Year");
            }
            academicYearRepository.save(year);
            log.info("Academic Year ID: {} locked successfully", id);
        } catch (ResourceNotFoundException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while locking Academic Year ID: {}", id, e);
            throw new CustomServiceException("Failed to lock academic year", e);
        }
    }


    @Transactional
    public void archiveAcademicYear(Long id, AcademicYearRequestDTO request) {
        log.info("Archiving Academic Year ID: {} in database", id);
        try {
            AcademicYearEntity year = academicYearRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for archive with ID: {}", id);
                        return new ResourceNotFoundException("Academic Year not found");
                    });

            if (AcademicYearStatus.ARCHIVED.equals(year.getStatus())) {
                throw new IllegalStateException("Academic Year is already archived");
            }

            if (Boolean.TRUE.equals(year.getIsCurrent())) {
                throw new IllegalStateException("Current Academic Year cannot be archived");
            }

            if (LocalDate.now().isBefore(year.getEndDate())) {
                throw new IllegalStateException("Academic Year cannot be archived before end date");
            }

            if (!Boolean.TRUE.equals(year.getIsLocked())) {
                throw new IllegalStateException("Only locked Academic Years can be archived");
            }

            if (request.getRemarks() == null || request.getRemarks().isBlank()) {
                throw new IllegalStateException("Remarks are required to archive Academic Year");
            }

            year.setStatus(AcademicYearStatus.ARCHIVED);
            year.setIsCurrent(false);
            year.setRemarks(request.getRemarks());

            academicYearRepository.save(year);
            log.info("Academic Year ID: {} archived successfully", id);
        } catch (ResourceNotFoundException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while archiving Academic Year ID: {}", id, e);
            throw new CustomServiceException("Failed to archive academic year", e);
        }
    }
    
    @Transactional
    public void closeAcademicYear(Long id, AcademicYearRequestDTO request) {
        log.info("Closing Academic Year ID: {} in database", id);
        try {
            AcademicYearEntity year = academicYearRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Academic Year not found for close with ID: {}", id);
                        return new ResourceNotFoundException("Academic Year not found");
                    });

            if (AcademicYearStatus.CLOSED.equals(year.getStatus())) {
                throw new IllegalStateException("Academic Year is already closed");
            }

            if (Boolean.TRUE.equals(year.getIsCurrent())) {
                throw new IllegalStateException("Current Academic Year cannot be closed");
            }

            if (LocalDate.now().isBefore(year.getEndDate())) {
                throw new IllegalStateException("Academic Year cannot be closed before its end date");
            }

            if (request.getRemarks() == null || request.getRemarks().isBlank()) {
                year.setRemarks("Closed by system"); // default remark
            } else {
                year.setRemarks(request.getRemarks());
            }

            year.setStatus(AcademicYearStatus.CLOSED);

            academicYearRepository.save(year);
            log.info("Academic Year ID: {} closed successfully", id);
        } catch (ResourceNotFoundException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while closing Academic Year ID: {}", id, e);
            throw new CustomServiceException("Failed to close academic year", e);
        }
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



