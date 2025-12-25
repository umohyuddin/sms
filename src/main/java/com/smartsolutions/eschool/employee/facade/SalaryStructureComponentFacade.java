package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request.SalaryStructureComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.SalaryStructureComponentService;
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
public class SalaryStructureComponentFacade {

    private final SalaryStructureComponentService componentService;

    public SalaryStructureComponentFacade(SalaryStructureComponentService componentService) {
        this.componentService = componentService;
    }

    // -------------------------
    // Create
    // -------------------------
    public SalaryStructureComponentResponseDTO createComponent(SalaryStructureComponentRequestDTO requestDTO) {
        return componentService.createComponent(requestDTO);
    }

    // -------------------------
    // Get by ID
    // -------------------------
    public SalaryStructureComponentResponseDTO getComponentById(Long id) {
        return componentService.getById(id);
    }

    // -------------------------
    // Get all active components
    // -------------------------
    public List<SalaryStructureComponentResponseDTO> getAllActiveComponents() {
        return componentService.getAllActive();
    }

    // -------------------------
    // Get components by salary structure
    // -------------------------
    public List<SalaryStructureComponentResponseDTO> getComponentsBySalaryStructure(Long salaryStructureId) {
        return componentService.getBySalaryStructureId(salaryStructureId);
    }

    // -------------------------
    // Search components by name
    // -------------------------
    public List<SalaryStructureComponentResponseDTO> searchComponents(Long salaryStructureId, String keyword) {
        return componentService.searchByName(salaryStructureId, keyword);
    }

    // -------------------------
    // Update component
    // -------------------------
    public SalaryStructureComponentResponseDTO updateComponent(Long id, SalaryStructureComponentRequestDTO requestDTO) {
        return componentService.updateComponent(id, requestDTO);
    }

    // -------------------------
    // Soft delete
    // -------------------------
    public void softDeleteComponent(Long id) {
        componentService.softDelete(id);
    }

    // -------------------------
    // Count active components by salary structure
    // -------------------------
    public Long countActiveComponents(Long salaryStructureId) {
        return componentService.countActiveBySalaryStructureId(salaryStructureId);
    }
}