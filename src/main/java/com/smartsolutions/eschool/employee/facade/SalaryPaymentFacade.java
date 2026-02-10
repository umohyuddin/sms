package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.salaryPayment.request.SalaryPaymentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryPayment.response.SalaryPaymentResponseDTO;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.SalaryPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
