package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.salaryPayment.request.SalaryPaymentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryPayment.response.SalaryPaymentResponseDTO;
import com.smartsolutions.eschool.employee.service.SalaryPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SalaryPaymentFacade {

    private final SalaryPaymentService paymentService;

    public SalaryPaymentFacade(SalaryPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public SalaryPaymentResponseDTO createPayment(SalaryPaymentRequestDTO requestDTO) {
        return paymentService.createPayment(requestDTO);
    }

    public SalaryPaymentResponseDTO updatePayment(Long id, SalaryPaymentRequestDTO requestDTO) {
        return paymentService.updatePayment(id, requestDTO);
    }

    public SalaryPaymentResponseDTO getPaymentById(Long id) {
        return paymentService.getPaymentById(id);
    }

    public List<SalaryPaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    public List<SalaryPaymentResponseDTO> getPaymentsByEmployeeSalary(Long employeeSalaryId) {
        return paymentService.getPaymentsByEmployeeSalary(employeeSalaryId);
    }

    public void softDeletePayment(Long id) {
        paymentService.softDeletePayment(id);
    }

    public List<SalaryPaymentResponseDTO> getPaymentsByEmployeeId(Long employeeId) {
        log.info("Facade: fetching salary payments for employeeId={}", employeeId);
        return paymentService.getPaymentsByEmployeeId(employeeId);
    }

}
