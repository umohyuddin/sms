package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.request.EmployeeSalaryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeMasterSalary;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterSalaryRepository;
import com.smartsolutions.eschool.global.enums.SalaryStatus;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeMasterSalaryService {

    private final EmployeeMasterSalaryRepository salaryRepository;

    public EmployeeMasterSalaryService(EmployeeMasterSalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    /* =========================
       CREATE
       ========================= */
    public EmployeeSalaryResponseDTO createSalary(@Valid EmployeeSalaryRequestDTO requestDTO) {
//        log.info("Creating salary for employeeId={} for month={} year={}",
//                requestDTO.getEmployeeId(), requestDTO.getMonth(), requestDTO.getYear());
        try {
            EmployeeMasterSalary entity = MapperUtil.mapObject(requestDTO, EmployeeMasterSalary.class);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setDeleted(false);
            salaryRepository.save(entity);
            log.info("Salary saved with id={}", entity.getId());
            return MapperUtil.mapObject(entity, EmployeeSalaryResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating salary", dae);
            throw new CustomServiceException("Failed to create salary due to database error");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public EmployeeSalaryResponseDTO getSalaryById(Long id) {
        log.info("Fetching salary by id={}", id);
        try {
            EmployeeMasterSalary entity = salaryRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary not found with id=" + id));
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
            return entities.stream()
                    .map(e -> MapperUtil.mapObject(e, EmployeeSalaryResponseDTO.class))
                    .collect(Collectors.toList());
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
            EmployeeMasterSalary existing = salaryRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary not found with id=" + id));

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
            EmployeeMasterSalary existing = salaryRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary not found with id=" + id));
            existing.setDeleted(true);
            existing.setUpdatedAt(LocalDateTime.now());
            salaryRepository.save(existing);
            log.info("Salary soft deleted with id={}", id);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting salary", dae);
            throw new CustomServiceException("Failed to delete salary due to database error", dae);
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
}