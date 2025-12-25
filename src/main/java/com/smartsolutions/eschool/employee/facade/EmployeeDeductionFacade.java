package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeDeduction.request.EmployeeDeductionRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeDeduction.response.EmployeeDeductionResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeDeductionService;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
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
public class EmployeeDeductionFacade {

    private final EmployeeDeductionService deductionService;

    public EmployeeDeductionFacade(EmployeeDeductionService deductionService) {
        this.deductionService = deductionService;
    }

    public EmployeeDeductionResponseDTO createDeduction(EmployeeDeductionRequestDTO requestDTO) {
        return deductionService.createDeduction(requestDTO);
    }

    public EmployeeDeductionResponseDTO updateDeduction(Long id, EmployeeDeductionRequestDTO requestDTO) {
        return deductionService.updateDeduction(id, requestDTO);
    }

    public EmployeeDeductionResponseDTO getDeductionById(Long id) {
        return deductionService.getDeductionById(id);
    }

    public List<EmployeeDeductionResponseDTO> getAllDeductions() {
        return deductionService.getAllDeductions();
    }

    public List<EmployeeDeductionResponseDTO> getDeductionsForEmployee(Long employeeId) {
        return deductionService.getDeductionsForEmployee(employeeId);
    }

    public void softDeleteDeduction(Long id) {
        deductionService.softDeleteDeduction(id);
    }
}