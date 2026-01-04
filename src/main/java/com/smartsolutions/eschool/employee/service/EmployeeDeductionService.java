package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeDeduction.request.EmployeeDeductionRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeDeduction.response.EmployeeDeductionDTO;
import com.smartsolutions.eschool.employee.dtos.employeeDeduction.response.EmployeeDeductionResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeDeduction.response.EmployeeWithDeductionsDTO;
import com.smartsolutions.eschool.employee.model.EmployeeDeductionEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeDeductionRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeDeductionService {
    private final EmployeeDeductionRepository deductionRepository;
    private final EmployeeMasterRepository employeeRepository;

    public EmployeeDeductionService(EmployeeDeductionRepository deductionRepository, EmployeeMasterRepository employeeRepository) {
        this.deductionRepository = deductionRepository;
        this.employeeRepository = employeeRepository;
    }

    /* =========================
       CREATE
       ========================= */
    @Transactional
    public EmployeeDeductionResponseDTO createDeduction(EmployeeDeductionRequestDTO requestDTO) {
        log.info("Creating new deduction for employeeId={}", requestDTO.getEmployeeId());
        try {
            EmployeeMasterEntity employee = employeeRepository.findById(requestDTO.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + requestDTO.getEmployeeId()));

            EmployeeDeductionEntity entity = MapperUtil.mapObject(requestDTO, EmployeeDeductionEntity.class);
            entity.setEmployee(employee);

            deductionRepository.save(entity);
            log.info("Deduction saved with id={}", entity.getId());

            return MapperUtil.mapObject(entity, EmployeeDeductionResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating deduction", dae);
            throw new CustomServiceException("Failed to create deduction due to database error");
        }
    }

    /* =========================
       UPDATE
       ========================= */
    @Transactional
    public EmployeeDeductionResponseDTO updateDeduction(Long id, EmployeeDeductionRequestDTO requestDTO) {
        log.info("Updating deduction id={}", id);
        try {
            EmployeeDeductionEntity existing = deductionRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Deduction not found with id: " + id));

            existing.setDeductionType(requestDTO.getDeductionType());
            existing.setAmount(requestDTO.getAmount());
            existing.setMonth(requestDTO.getMonth());

            deductionRepository.save(existing);
            log.info("Deduction updated successfully with id={}", id);

            return MapperUtil.mapObject(existing, EmployeeDeductionResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while updating deduction id={}", id, dae);
            throw new CustomServiceException("Failed to update deduction due to database error");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public EmployeeDeductionResponseDTO getDeductionById(Long id) {
        log.info("Fetching deduction by id={}", id);
        EmployeeDeductionEntity entity = deductionRepository.findByIdActive(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deduction not found with id: " + id));
        return MapperUtil.mapObject(entity, EmployeeDeductionResponseDTO.class);
    }

    /* =========================
       GET ALL
       ========================= */
    public List<EmployeeDeductionResponseDTO> getAllDeductions() {
        log.info("Fetching all deductions");
        List<EmployeeDeductionEntity> entities = deductionRepository.findAllActive();
        return entities.stream().map(e -> MapperUtil.mapObject(e, EmployeeDeductionResponseDTO.class)).collect(Collectors.toList());
    }

    /* =========================
       GET FOR EMPLOYEE
       ========================= */
    public List<EmployeeDeductionResponseDTO> getDeductionsForEmployee(Long employeeId) {
        log.info("Fetching deductions for employeeId={}", employeeId);
        List<EmployeeDeductionEntity> entities = deductionRepository.findAllByEmployeeIdActive(employeeId);
        return entities.stream().map(e -> MapperUtil.mapObject(e, EmployeeDeductionResponseDTO.class)).collect(Collectors.toList());
    }

    /* =========================
       SOFT DELETE
       ========================= */
    @Transactional
    public void softDeleteDeduction(Long id) {
        log.info("Soft deleting deduction id={}", id);
        deductionRepository.softDeleteById(id);
        log.info("Deduction soft deleted successfully id={}", id);
    }

    public EmployeeWithDeductionsDTO getEmployeeWithDeductions(Long employeeId) {
        log.info("Fetching employee with deductions for employeeId={}", employeeId);

        EmployeeMasterEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        // Fetch active deductions only
        List<EmployeeDeductionEntity> deductions = deductionRepository.findAllByEmployeeIdActive(employeeId);

        // Map deductions to DTO
        List<EmployeeDeductionDTO> deductionDTOs = deductions.stream()
                .map(d -> EmployeeDeductionDTO.builder()
                        .id(d.getId())
                        .deductionType(d.getDeductionType())
                        .amount(d.getAmount())
                        .month(d.getMonth())
                        .build())
                .collect(Collectors.toList());

        // Map employee + deductions to DTO
        return EmployeeWithDeductionsDTO.builder()
                .employeeId(employee.getId())
                .employeeCode(employee.getEmployeeCode())
                .fullName(employee.getFullName())
                .deductions(deductionDTOs)
                .build();
    }
}