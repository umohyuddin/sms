package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.request.PayrollPeriodRequestDTO;
import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.response.PayrollPeriodResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.PayRollPeriodService;
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
public class PayRollPeriodFacade {

    private final PayRollPeriodService payrollService;

    public PayRollPeriodFacade(PayRollPeriodService payrollService) {
        this.payrollService = payrollService;
    }

    public PayrollPeriodResponseDTO createPayrollPeriod(PayrollPeriodRequestDTO requestDTO) {
        log.info("Facade: Request to create PayrollPeriod: {} to {}", requestDTO.getStartDate(), requestDTO.getEndDate());
        PayrollPeriodResponseDTO result = payrollService.createPayrollPeriod(requestDTO);
        log.info("Facade: Successfully created PayrollPeriod: id={}", result.getId());
        return result;
    }

    public PayrollPeriodResponseDTO updatePayrollPeriod(Long id, PayrollPeriodRequestDTO requestDTO) {
        log.info("Facade: Request to update PayrollPeriod ID: {}", id);
        PayrollPeriodResponseDTO result = payrollService.updatePayrollPeriod(id, requestDTO);
        log.info("Facade: Successfully updated PayrollPeriod: id={}", result.getId());
        return result;
    }

    public PayrollPeriodResponseDTO getPayrollPeriodById(Long id) {
        log.info("Facade: Request to fetch PayrollPeriod by id: {}", id);
        PayrollPeriodResponseDTO result = payrollService.getPayrollPeriodById(id);
        log.info("Facade: Successfully fetched PayrollPeriod: id={}", id);
        return result;
    }

    public List<PayrollPeriodResponseDTO> getAllPayrollPeriods() {
        log.info("Facade: Request to fetch all PayrollPeriods");
        List<PayrollPeriodResponseDTO> result = payrollService.getAllPayrollPeriods();
        log.info("Facade: Successfully fetched {} PayrollPeriods", result.size());
        return result;
    }

    public List<PayrollPeriodResponseDTO> getPayrollPeriodsByStatus(PayrollPeriodEntity.PayrollStatus status) {
        log.info("Facade: Request to fetch PayrollPeriods by status: {}", status);
        List<PayrollPeriodResponseDTO> result = payrollService.getPayrollPeriodsByStatus(status);
        log.info("Facade: Successfully fetched {} PayrollPeriods", result.size());
        return result;
    }

    public List<PayrollPeriodResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search PayrollPeriods by keyword: '{}'", keyword);
        List<PayrollPeriodResponseDTO> result = payrollService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} PayrollPeriods", result.size());
        return result;
    }

    public void delete(Long id) {
        log.info("Facade: Request to delete PayrollPeriod by id: {}", id);
        payrollService.delete(id);
        log.info("Facade: Successfully deleted PayrollPeriod: id={}", id);
    }
}

