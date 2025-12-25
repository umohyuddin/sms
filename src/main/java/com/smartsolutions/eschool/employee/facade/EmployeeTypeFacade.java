
package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.EmployeeTypeService;
import jakarta.validation.Valid;
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
public class EmployeeTypeFacade {

    private final EmployeeTypeService employeeTypeService;

    public EmployeeTypeFacade(EmployeeTypeService employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    // -------------------------
    // Create
    // -------------------------
    public EmployeeTypeResponseDTO create(@Valid EmployeeTypeRequestDTO requestDTO) {
        return employeeTypeService.create(requestDTO);
    }

    // -------------------------
    // Read
    // -------------------------
    public EmployeeTypeResponseDTO getById(Long id) {
        return employeeTypeService.getById(id);
    }

    public List<EmployeeTypeResponseDTO> getAll() {
        return employeeTypeService.getAll();
    }

    public List<EmployeeTypeResponseDTO> getAllActive() {
        return employeeTypeService.getAllActive();
    }

    public List<EmployeeTypeResponseDTO> getAllInactive() {
        return employeeTypeService.getAllInactive();
    }

    // -------------------------
    // Update
    // -------------------------
    public EmployeeTypeResponseDTO update(Long id, @Valid EmployeeTypeRequestDTO requestDTO) {
        return employeeTypeService.update(id, requestDTO);
    }

    // -------------------------
    // Delete (Soft Delete)
    // -------------------------
//    public int softDelete(Long id) {
//        return employeeTypeService.softDeleteById(id);
//    }

    // -------------------------
    // Search
    // -------------------------
//    public List<EmployeeTypeResponseDTO> searchByKeyword(String keyword) {
//        return employeeTypeService.searchByKeyword(keyword);
//    }

    // -------------------------
    // Metrics
    // -------------------------
    public long countAll() {
        return employeeTypeService.countAll();
    }

    public long countActive() {
        return employeeTypeService.countActive();
    }

    public long countInactive() {
        return employeeTypeService.countInactive();
    }
}