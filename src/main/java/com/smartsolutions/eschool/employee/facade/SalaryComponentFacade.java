package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.SalaryComponentSearchDto;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.SalaryComponentService;
import com.smartsolutions.eschool.global.enums.ComponentType;
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
public class SalaryComponentFacade {

    private final SalaryComponentService salaryComponentService;

    public SalaryComponentFacade(SalaryComponentService salaryComponentService) {
        this.salaryComponentService = salaryComponentService;
    }

    // -------------------------
    // Create a new component
    // -------------------------
    public SalaryComponentResponseDTO createComponent(SalaryComponentRequestDTO requestDTO) {
        return salaryComponentService.createComponent(requestDTO);
    }

    // -------------------------
    // Get component by ID
    // -------------------------
    public SalaryComponentResponseDTO getById(Long id) {
        return salaryComponentService.getById(id);
    }

    // -------------------------
    // Get all active / inactive components
    // -------------------------
    public List<SalaryComponentResponseDTO> getAllActive() {
        return salaryComponentService.getAllActive();
    }

    public List<SalaryComponentResponseDTO> getAllInactive() {
        return salaryComponentService.getAllInactive();
    }

    // -------------------------
    // Search by name
    // -------------------------
    public List<SalaryComponentResponseDTO> searchByName(String keyword) {
        return salaryComponentService.searchByName(keyword);
    }

    // -------------------------
    // Get by type (EARNING / DEDUCTION)
    // -------------------------
//    public List<SalaryComponentResponseDTO> getByType(ComponentType type) {
//        return salaryComponentService.getByType(type);
//    }

    // -------------------------
    // Update component
    // -------------------------
    public SalaryComponentResponseDTO updateComponent(Long id, SalaryComponentRequestDTO requestDTO) {
        return salaryComponentService.updateComponent(id, requestDTO);
    }

    // -------------------------
    // Soft delete component
    // -------------------------
    public void softDelete(Long id) {
        salaryComponentService.softDelete(id);
    }

    // -------------------------
    // Metrics / counts
    // -------------------------
    public Long countActive() {
        return salaryComponentService.countActive();
    }

    public Long countInactive() {
        return salaryComponentService.countInactive();
    }

//    public List<SalaryComponentResponseDTO> searchComponents(SalaryComponentSearchDto salaryComponentSearchDto) {
//        return salaryComponentService.searchComponents(salaryComponentSearchDto.getName(),salaryComponentSearchDto.getType(),salaryComponentSearchDto.getIsPercentage());
//    }
}