package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.request.EmployeeSalaryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryFullResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryResponseDTO;
import com.smartsolutions.eschool.employee.model.*;
import com.smartsolutions.eschool.employee.repository.*;
import com.smartsolutions.eschool.global.enums.SalaryStatus;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.school.repository.DesignationRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeMasterSalaryService {

    private final EmployeeMasterSalaryRepository salaryRepository;
    private final EmployeeMasterRepository employeeMasterRepository;
    private final SalaryStructureRepository salaryStructureRepository;
    private final EmployeeDepartmentHistoryRepository employeeDepartmentHistoryRepository;
    private final EmployeeDesignationHistoryRepository designationHistoryRepository;
    private final EmployeeTypeHistoryRepository employeeTypeHistoryRepository;


    /* =========================
       CREATE
       ========================= */
    @Transactional
    public EmployeeSalaryResponseDTO createSalary(@Valid EmployeeSalaryRequestDTO requestDTO) {

        log.info("Applying salary for employeeId={} with structureId={} effectiveDate={}",
                requestDTO.getEmployeeId(),
                requestDTO.getSalaryStructureId(),
                requestDTO.getEffectiveDate());

        try {
            //  Validate Employee
            EmployeeMasterEntity employee = employeeMasterRepository
                    .findById(requestDTO.getEmployeeId())
                    .orElseThrow(() ->
                            new CustomServiceException("Employee not found with ID: " + requestDTO.getEmployeeId()));

            // Validate Salary Structure
            SalaryStructureEntity structure = salaryStructureRepository
                    .findById(requestDTO.getSalaryStructureId())
                    .orElseThrow(() ->
                            new CustomServiceException("Salary Structure not found with ID: " + requestDTO.getSalaryStructureId()));

            //  Check if salary already applied for this effective date
//            boolean exists = salaryRepository
//                    .existsByEmployeeIdAndEffectiveDateAndDeletedFalse(
//                            requestDTO.getEmployeeId(),
//                            requestDTO.getEffectiveDate());

//            if (exists) {
//                throw new CustomServiceException(
//                        "Salary already applied for this employee on effective date: "
//                                + requestDTO.getEffectiveDate());
//            }

            // Validate salary calculation
            BigDecimal calculatedNet =
                    requestDTO.getGrossSalary().subtract(requestDTO.getTotalDeductions());

            if (calculatedNet.compareTo(requestDTO.getNetSalary()) != 0) {
                throw new CustomServiceException("Net salary mismatch. Gross - Deductions is invalid.");
            }

            // Map DTO → Entity
            EmployeeMasterSalary entity = MapperUtil.mapObject(requestDTO, EmployeeMasterSalary.class);
            entity.setId(requestDTO.getEmployeeId());
            entity.setEmployee(employee);
            entity.setSalaryStructure(structure);
            entity.setEffectiveDate(LocalDate.now());
            entity.setCreatedAt(LocalDateTime.now());
            entity.setDeleted(false);

            // Save
            salaryRepository.save(entity);

            log.info("Salary successfully applied with id={}", entity.getId());

            return MapperUtil.mapObject(entity, EmployeeSalaryResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while applying salary", dae);
            throw new CustomServiceException("Failed to apply salary due to database error");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public EmployeeSalaryResponseDTO getSalaryById(Long id) {
        log.info("Fetching salary by id={}", id);
        try {
            EmployeeMasterSalary entity = salaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary not found with id=" + id));
            return MapperUtil.mapObject(entity, EmployeeSalaryResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching salary", dae);
            throw new CustomServiceException("Unable to fetch salary from database", dae);
        }
    }

    /* =========================
       GET ALL SALARIES FOR EMPLOYEE
       ========================= */
    public List<EmployeeSalaryResponseDTO> getAllSalariesForEmployee(Long employeeId) {
        log.info("Fetching all salaries for employeeId={}", employeeId);
        try {
            List<EmployeeMasterSalary> entities = salaryRepository.findAllByEmployeeId(employeeId);
            return entities.stream().map(e -> MapperUtil.mapObject(e, EmployeeSalaryResponseDTO.class)).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching salaries", dae);
            throw new CustomServiceException("Unable to fetch salaries", dae);
        }
    }

    /* =========================
       UPDATE
       ========================= */
    public EmployeeSalaryResponseDTO updateSalary(Long id, @Valid EmployeeSalaryRequestDTO requestDTO) {
        log.info("Updating salary with id={}", id);
        try {
            EmployeeMasterSalary existing = salaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary not found with id=" + id));

            //existing.setEmpId(requestDTO.getEmployeeId());
            existing.setGrossSalary(requestDTO.getGrossSalary());
            existing.setTotalDeductions(requestDTO.getTotalDeductions());
            existing.setNetSalary(requestDTO.getNetSalary());
            existing.setEffectiveDate(requestDTO.getEffectiveDate());
            //existing.setStatus(requestDTO.getStatus());
            existing.setUpdatedAt(LocalDateTime.now());

            salaryRepository.save(existing);
            log.info("Salary updated successfully with id={}", existing.getId());
            return MapperUtil.mapObject(existing, EmployeeSalaryResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while updating salary", dae);
            throw new CustomServiceException("Failed to update salary due to database error", dae);
        }
    }

    /* =========================
       SOFT DELETE
       ========================= */
    @Transactional
    public void softDeleteSalary(Long id) {
        log.info("Soft delete requested for salary id={}", id);
        try {
            EmployeeMasterSalary existing = salaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary not found with id=" + id));
            existing.setDeleted(true);
            existing.setUpdatedAt(LocalDateTime.now());
            salaryRepository.save(existing);
            log.info("Salary soft deleted with id={}", id);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting salary", dae);
            throw new CustomServiceException("Failed to delete salary due to database error", dae);
        }
    }

    @Transactional
    public List<EmployeeSalaryFullResponseDTO> getEmployeeSalaryList() {
        log.info("Fetching employee salary list (entity approach)");
        try {
            // Fetch all salaries with employee loaded
            List<EmployeeMasterSalary> salaries = salaryRepository.findEmployeeSalaryDetails();

            return salaries.stream()
                    .map(this::toDTO) // call private mapper
                    .toList();

        } catch (DataAccessException dae) {
            log.error("Database error while fetching employee salary list", dae);
            throw new CustomServiceException("Unable to fetch employee salary list", dae);
        }
    }



    /* =========================
       SEARCH BY STATUS
       ========================= */
//    public List<EmployeeSalaryResponseDTO> getSalariesByStatus(SalaryStatus status) {
//        log.info("Fetching salaries with status={}", status);
//        try {
//            List<EmployeeMasterSalary> entities = salaryRepository.findByStatus(status);
//            return entities.stream()
//                    .map(e -> MapperUtil.mapObject(e, EmployeeSalaryResponseDTO.class))
//                    .collect(Collectors.toList());
//        } catch (DataAccessException dae) {
//            log.error("Database error while fetching salaries by status", dae);
//            throw new CustomServiceException("Unable to fetch salaries by status", dae);
//        }
//    }

    /* =========================
       SEARCH BY MONTH/YEAR
       ========================= */
//    public Optional<EmployeeSalaryResponseDTO> getSalaryByEmployeeAndMonth(Long employeeId, Integer year, Integer month) {
//        log.info("Fetching salary for employeeId={} for month={} year={}", employeeId, month, year);
//        try {
//            return salaryRepository.findByEmployeeAndMonth(employeeId, year, month)
//                    .map(e -> MapperUtil.mapObject(e, EmployeeSalaryResponseDTO.class));
//        } catch (DataAccessException dae) {
//            log.error("Database error while fetching salary by month/year", dae);
//            throw new CustomServiceException("Unable to fetch salary by month/year", dae);
//        }
//    }

    private EmployeeSalaryFullResponseDTO mapToFullResponse(EmployeeMasterSalary s) {
        EmployeeMasterEntity e = s.getEmployee();

        return EmployeeSalaryFullResponseDTO.builder()
                .salaryId(s.getId())
                .employeeId(e.getId())
                .employeeCode(e.getEmployeeCode())
                .employeeName(e.getFullName())
                .grossSalary(s.getGrossSalary())
                .totalDeductions(s.getTotalDeductions())
                .netSalary(s.getNetSalary())
                .effectiveDate(s.getEffectiveDate())
                .build();
    }

    EmployeeSalaryFullResponseDTO toDTO(EmployeeMasterSalary salaryEntity) {
        if (salaryEntity == null) return null;

        var employee = salaryEntity.getEmployee();

        // Extract current histories from the fetched joins
        EmployeeDepartmentHistoryEntity currentDept = null;
        EmployeeDesignationHistoryEntity currentDesig = null;
        EmployeeTypeHistoryEntity currentType = null;

        // LEFT JOIN FETCH results will be available in memory
        if (salaryEntity instanceof org.hibernate.proxy.HibernateProxy) {
            // If using lazy proxies, ensure initialization
            org.hibernate.Hibernate.initialize(employee);
        }

        if (employee.getDepartmentHistories() != null) {
            currentDept = employee.getDepartmentHistories()
                    .stream().filter(EmployeeDepartmentHistoryEntity::getIsCurrent)
                    .findFirst().orElse(null);
        }

        if (employee.getDesignationHistories() != null) {
            currentDesig = employee.getDesignationHistories()
                    .stream().filter(EmployeeDesignationHistoryEntity::getIsCurrent)
                    .findFirst().orElse(null);
        }

        if (employee.getTypeHistories() != null) {
            currentType = employee.getTypeHistories()
                    .stream().filter(EmployeeTypeHistoryEntity::getIsCurrent)
                    .findFirst().orElse(null);
        }

        String employeeTypeName = null;
        if (employee.getEmployeeType() != null) {
            employeeTypeName = employee.getEmployeeType().getName();
        }

        return EmployeeSalaryFullResponseDTO.builder()
                .id(salaryEntity.getId())
                .salaryId(salaryEntity.getId())
                .employeeId(employee.getId())
                .employeeCode(employee.getEmployeeCode())
                .employeeName(employee.getFullName())
                .employeeType(employeeTypeName)
                .grossSalary(salaryEntity.getGrossSalary())
                .totalDeductions(salaryEntity.getTotalDeductions())
                .netSalary(salaryEntity.getNetSalary())
                .effectiveDate(salaryEntity.getEffectiveDate())
                .salaryStructureId(salaryEntity.getSalaryStructure() != null ? salaryEntity.getSalaryStructure().getId() : null)
                //.status(SalaryStatus.ACTIVE) // replace if you have status in entity
                .createdAt(salaryEntity.getCreatedAt())
                .updatedAt(salaryEntity.getUpdatedAt())
                // Nested DTOs
                .employee(EmployeeMasterResponseDto.fromEntity(employee))
                .designation(currentDesig != null ? DesignationResponseDTO.fromEntity(currentDesig.getDesignation()) : null)
                .department(currentDept != null ? DepartmentResponseDTO.fromEntity(currentDept.getDepartment()) : null)
                .build();
    }


    @Transactional
    public EmployeeSalaryFullResponseDTO getEmployeeSalaryDetail(Long employeeId) {

        // 1. Fetch employee
        EmployeeMasterEntity employee = employeeMasterRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + employeeId));

        // 2. Fetch current salary structure using employee type
        SalaryStructureEntity salaryStructure =
                salaryStructureRepository.findCurrentSalaryByEmployeeType(
                        employee.getEmployeeType().getId());

        if (salaryStructure == null) {
            throw new ResourceNotFoundException(
                    "No salary structure found for employee type: "
                            + employee.getEmployeeType().getName());
        }

        BigDecimal baseSalary = salaryStructure.getBaseSalary();
        BigDecimal totalEarnings = baseSalary;
        BigDecimal totalDeductions = BigDecimal.ZERO;


        List<SalaryStructureComponentResponseDTO> componentDTOs = new ArrayList<>();

        // 3. Calculate components
        for (SalaryStructureComponentEntity comp : salaryStructure.getComponents()) {

            if (Boolean.TRUE.equals(comp.getDeleted())) continue;

            BigDecimal calculatedAmount;

            if (Boolean.TRUE.equals(comp.getComponent().getIsPercentage())) {
                calculatedAmount = baseSalary
                        .multiply(comp.getValue())
                        .divide(BigDecimal.valueOf(100));
            } else {
                calculatedAmount = comp.getValue();
            }

            if ("EARNING".equalsIgnoreCase(comp.getComponent().getType().name())) {
                totalEarnings = totalEarnings.add(calculatedAmount);
            } else if ("DEDUCTION".equalsIgnoreCase(comp.getComponent().getType().name())) {
                totalDeductions = totalDeductions.add(calculatedAmount);
            }

            componentDTOs.add(
                    SalaryStructureComponentResponseDTO.builder()
                            .componentId(comp.getComponent().getId())
                            .componentName(comp.getComponent().getName())
                            .componentType(comp.getComponent().getType().name())
                            .isPercentage(comp.getComponent().getIsPercentage())
                            .value(comp.getValue())
                            .calculatedAmount(calculatedAmount)
                            .build()
            );
        }

        BigDecimal netSalary = totalEarnings.subtract(totalDeductions);


        final BigDecimal finalTotalEarnings = totalEarnings;
        final BigDecimal finalTotalDeductions = totalDeductions;
        final BigDecimal finalNetSalary = netSalary;
        //ONLY ADDITION: CROSS VALIDATION
        salaryRepository.findLatestByEmployeeId(employeeId)
                .ifPresent(saved -> {

                    if (saved.getGrossSalary().compareTo(finalTotalEarnings) != 0
                            || saved.getTotalDeductions().compareTo(finalTotalDeductions) != 0
                            || saved.getNetSalary().compareTo(finalNetSalary) != 0) {

                        throw new IllegalStateException(
                                "Salary mismatch with stored data for employee id: " + employeeId);
                    }
                });
        // 4. Build response
        return EmployeeSalaryFullResponseDTO.builder()
                .employeeId(employee.getId())
                .employeeName(employee.getFullName())
                .employeeCode(employee.getEmployeeCode())
                .employeeType(employee.getEmployeeType().getName())
                .baseSalary(baseSalary)
                .components(componentDTOs)
                .grossSalary(totalEarnings)
                .totalDeductions(totalDeductions)
                .netSalary(netSalary)
                .effectiveFrom(salaryStructure.getEffectiveFrom())
                //.effectiveTo(salaryStructure.getEffectiveTo())
                .build();
    }


}
