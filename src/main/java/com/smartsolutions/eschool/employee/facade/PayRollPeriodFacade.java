package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.request.PayrollPeriodRequestDTO;
import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.response.PayrollPeriodResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.PayRollPeriodService;
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
public class PayRollPeriodFacade {

    private final PayRollPeriodService payrollService;

    public PayRollPeriodFacade(PayRollPeriodService payrollService) {
        this.payrollService = payrollService;
    }

    public PayrollPeriodResponseDTO createPayrollPeriod(PayrollPeriodRequestDTO requestDTO) {
        return payrollService.createPayrollPeriod(requestDTO);
    }

    public PayrollPeriodResponseDTO updatePayrollPeriod(Long id, PayrollPeriodRequestDTO requestDTO) {
        return payrollService.updatePayrollPeriod(id, requestDTO);
    }

    public PayrollPeriodResponseDTO getPayrollPeriodById(Long id) {
        return payrollService.getPayrollPeriodById(id);
    }

    public List<PayrollPeriodResponseDTO> getAllPayrollPeriods() {
        return payrollService.getAllPayrollPeriods();
    }

    public List<PayrollPeriodResponseDTO> getPayrollPeriodsByStatus(PayrollPeriodEntity.PayrollStatus status) {
        return payrollService.getPayrollPeriodsByStatus(status);
    }

    public void softDeletePayrollPeriod(Long id) {
        payrollService.softDeletePayrollPeriod(id);
    }
}

