package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.request.EmployeeSalaryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryFullResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterSalary;
import com.smartsolutions.eschool.employee.model.SalaryStructureEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterSalaryRepository;
import com.smartsolutions.eschool.employee.repository.SalaryStructureRepository;
import com.smartsolutions.eschool.global.enums.SalaryStatus;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
public class EmployeeMasterSalaryService {

    private final EmployeeMasterSalaryRepository salaryRepository;
    private final EmployeeMasterRepository employeeMasterRepository;
    private final SalaryStructureRepository salaryStructureRepository;

    public EmployeeMasterSalaryService(EmployeeMasterSalaryRepository salaryRepository, EmployeeMasterRepository employeeMasterRepository, SalaryStructureRepository salaryStructureRepository) {
        this.salaryRepository = salaryRepository;
        this.employeeMasterRepository = employeeMasterRepository;
        this.salaryStructureRepository = salaryStructureRepository;
    }

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

    public List<EmployeeSalaryFullResponseDTO> getEmployeeSalaryList() {
        log.info("Fetching employee salary list (entity approach)");
        try {
            // Fetch all salaries with employee loaded
            List<EmployeeMasterSalary> salaries = salaryRepository.findEmployeeSalaryList();

            // Map entity → DTO
            return salaries.stream()
                    .map(this::mapToFullResponse)
                    .collect(Collectors.toList());

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
}