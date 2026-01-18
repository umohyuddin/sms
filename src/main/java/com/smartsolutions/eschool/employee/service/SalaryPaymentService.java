package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.salaryPayment.request.SalaryPaymentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryPayment.response.SalaryPaymentResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterSalary;
import com.smartsolutions.eschool.employee.model.SalaryPaymentEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterSalaryRepository;
import com.smartsolutions.eschool.employee.repository.SalaryPaymentRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalaryPaymentService {

    private final SalaryPaymentRepository paymentRepository;
    private final EmployeeMasterSalaryRepository salaryRepository;
    private final EmployeeMasterRepository employeeMasterRepository;


    /* =========================
       CREATE PAYMENT
       ========================= */
    @Transactional
    public SalaryPaymentResponseDTO createPayment(SalaryPaymentRequestDTO requestDTO) {
        log.info("Creating salary payment for employeeSalaryId={}", requestDTO.getEmployeeId());

        // 1️⃣ Validate mandatory business rules
        if (requestDTO.getPaymentDate().isAfter(LocalDate.now())) {
            throw new CustomServiceException("Payment date cannot be in the future");
        }

        if (requestDTO.getAmountPaid().compareTo(BigDecimal.ZERO) <= 0) {
            throw new CustomServiceException("Amount paid must be greater than zero");
        }
        try {

            EmployeeMasterEntity employee = employeeMasterRepository.findById(requestDTO.getEmployeeId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Employee not found with id: " + requestDTO.getEmployeeId()
                            )
                    );
            EmployeeMasterSalary salary = salaryRepository.findLatestByEmployeeId(employee.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee salary not found with id: " + requestDTO.getEmployeeId()));

            SalaryPaymentEntity entity = new SalaryPaymentEntity();
            entity.setEmployeeSalary(salary); // resolved active salary
            entity.setPaymentDate(requestDTO.getPaymentDate());
            entity.setPaymentMode(requestDTO.getPaymentMode());
            entity.setTransactionReference(requestDTO.getTransactionReference());
            entity.setAmountPaid(requestDTO.getAmountPaid());
            entity.setRemarks(requestDTO.getRemarks());

            paymentRepository.save(entity);
            log.info("Salary payment saved with id={}", entity.getId());

            return MapperUtil.mapObject(entity, SalaryPaymentResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating salary payment", dae);
            throw new CustomServiceException("Failed to create salary payment due to database error");
        }
    }

    /* =========================
       UPDATE PAYMENT
       ========================= */
    @Transactional
    public SalaryPaymentResponseDTO updatePayment(Long id, SalaryPaymentRequestDTO requestDTO) {
        log.info("Updating salary payment id={}", id);
        try {
            SalaryPaymentEntity existing = paymentRepository.findByIdActive(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary payment not found with id: " + id));

            existing.setPaymentDate(requestDTO.getPaymentDate());
            existing.setPaymentMode(requestDTO.getPaymentMode());
            existing.setTransactionReference(requestDTO.getTransactionReference());
            existing.setAmountPaid(requestDTO.getAmountPaid());
            existing.setRemarks(requestDTO.getRemarks());

            paymentRepository.save(existing);
            log.info("Salary payment updated successfully with id={}", id);

            return MapperUtil.mapObject(existing, SalaryPaymentResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while updating salary payment id={}", id, dae);
            throw new CustomServiceException("Failed to update salary payment due to database error");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public SalaryPaymentResponseDTO getPaymentById(Long id) {
        log.info("Fetching salary payment by id={}", id);
        SalaryPaymentEntity entity = paymentRepository.findByIdActive(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salary payment not found with id: " + id));
        return MapperUtil.mapObject(entity, SalaryPaymentResponseDTO.class);
    }

    /* =========================
       GET ALL
       ========================= */
    public List<SalaryPaymentResponseDTO> getAllPayments() {
        log.info("Fetching all salary payments");
        List<SalaryPaymentEntity> entities = paymentRepository.findAllActive();
        return entities.stream()
                .map(e -> MapperUtil.mapObject(e, SalaryPaymentResponseDTO.class))
                .collect(Collectors.toList());
    }

    /* =========================
       GET BY EMPLOYEE SALARY
       ========================= */
    public List<SalaryPaymentResponseDTO> getPaymentsByEmployeeSalary(Long employeeSalaryId) {
        log.info("Fetching salary payments for employeeSalaryId={}", employeeSalaryId);
        List<SalaryPaymentEntity> entities = paymentRepository.findAllByEmployeeSalaryIdActive(employeeSalaryId);
        return entities.stream()
                .map(e -> MapperUtil.mapObject(e, SalaryPaymentResponseDTO.class))
                .collect(Collectors.toList());
    }

    /* =========================
       SOFT DELETE
       ========================= */
    @Transactional
    public void softDeletePayment(Long id) {
        log.info("Soft deleting salary payment id={}", id);
        paymentRepository.softDeleteById(id);
        log.info("Salary payment soft deleted successfully id={}", id);
    }


    public List<SalaryPaymentResponseDTO> getPaymentsByEmployeeId(Long employeeId) {
        log.info("Fetching all salary payments for employeeId={}", employeeId);

        //  Validate employee exists
        EmployeeMasterEntity employee = employeeMasterRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        //  Get all active salaries for employee
        EmployeeMasterSalary salary = salaryRepository.findLatestByEmployeeId(employee.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee salary not found with id: " + employeeId));

        List<SalaryPaymentEntity> payments = paymentRepository.findAllByEmployeeSalaryIdActive(salary.getId());
        return payments.stream()
                .map(payment -> {
                    SalaryPaymentResponseDTO dto = new SalaryPaymentResponseDTO();
                    dto.setId(payment.getId());
                    dto.setEmployeeName(employee.getFullName());
                    dto.setEmployeeSalaryId(payment.getEmployeeSalary().getId());
                    dto.setEmployeeId(payment.getEmployeeSalary().getEmployee().getId());
                    dto.setPaymentDate(payment.getPaymentDate());
                    dto.setPaymentMode(payment.getPaymentMode());
                    dto.setTransactionReference(payment.getTransactionReference());
                    dto.setAmountPaid(payment.getAmountPaid());
                    dto.setRemarks(payment.getRemarks());
                    //dto.setCreatedAt(payment.getCreatedAt());
                    //dto.setUpdatedAt(payment.getUpdatedAt());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}