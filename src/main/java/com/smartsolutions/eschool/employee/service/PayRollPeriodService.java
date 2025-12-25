package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.request.PayrollPeriodRequestDTO;
import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.response.PayrollPeriodResponseDTO;
import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import com.smartsolutions.eschool.employee.repository.PayRollPeriodRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PayRollPeriodService {
    private final PayRollPeriodRepository payrollRepository;

    public PayRollPeriodService(PayRollPeriodRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    /* =========================
       CREATE
       ========================= */
    @Transactional
    public PayrollPeriodResponseDTO createPayrollPeriod(PayrollPeriodRequestDTO requestDTO) {
        log.info("Creating new payroll period from {} to {}", requestDTO.getStartDate(), requestDTO.getEndDate());
        try {
            PayrollPeriodEntity entity = MapperUtil.mapObject(requestDTO, PayrollPeriodEntity.class);
            payrollRepository.save(entity);
            return MapperUtil.mapObject(entity, PayrollPeriodResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating payroll period", dae);
            throw new CustomServiceException("Failed to create payroll period due to database error");
        }
    }

    /* =========================
       UPDATE
       ========================= */
    @Transactional
    public PayrollPeriodResponseDTO updatePayrollPeriod(Long id, PayrollPeriodRequestDTO requestDTO) {
        log.info("Updating payroll period id={}", id);
        try {
            PayrollPeriodEntity existing = payrollRepository.findByIdActive(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Payroll period not found with id: " + id));

            existing.setStartDate(requestDTO.getStartDate());
            existing.setEndDate(requestDTO.getEndDate());
            existing.setStatus(requestDTO.getStatus());
            existing.setDescription(requestDTO.getDescription());

            payrollRepository.save(existing);
            return MapperUtil.mapObject(existing, PayrollPeriodResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while updating payroll period id={}", id, dae);
            throw new CustomServiceException("Failed to update payroll period due to database error");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public PayrollPeriodResponseDTO getPayrollPeriodById(Long id) {
        log.info("Fetching payroll period by id={}", id);
        PayrollPeriodEntity entity = payrollRepository.findByIdActive(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll period not found with id: " + id));
        return MapperUtil.mapObject(entity, PayrollPeriodResponseDTO.class);
    }

    /* =========================
       GET ALL
       ========================= */
    public List<PayrollPeriodResponseDTO> getAllPayrollPeriods() {
        log.info("Fetching all payroll periods");
        List<PayrollPeriodEntity> entities = payrollRepository.findAllActive();
        return entities.stream().map(e -> MapperUtil.mapObject(e, PayrollPeriodResponseDTO.class)).collect(Collectors.toList());
    }

    /* =========================
       GET BY STATUS
       ========================= */
    public List<PayrollPeriodResponseDTO> getPayrollPeriodsByStatus(PayrollPeriodEntity.PayrollStatus status) {
        log.info("Fetching payroll periods with status={}", status);
        List<PayrollPeriodEntity> entities = payrollRepository.findAllByStatus(status);
        return entities.stream().map(e -> MapperUtil.mapObject(e, PayrollPeriodResponseDTO.class)).collect(Collectors.toList());
    }

    /* =========================
       SOFT DELETE
       ========================= */
    @Transactional
    public void softDeletePayrollPeriod(Long id) {
        log.info("Soft deleting payroll period id={}", id);
        payrollRepository.softDeleteById(id);
    }
}