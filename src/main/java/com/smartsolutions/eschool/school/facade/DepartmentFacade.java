package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class DepartmentFacade {

    private final DepartmentService departmentService;

    public DepartmentFacade(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO requestDTO) {
        log.info("[Facade:DepartmentFacade] createDepartment() called");
        return departmentService.createDepartment(requestDTO);
    }

    public List<DepartmentResponseDTO> getAll() {
        log.info("[Facade:DepartmentFacade] getAll() called");
        return departmentService.getAllDepartments();
    }

    public DepartmentResponseDTO getById(Long departmentId) {
        log.info("[Facade:DepartmentFacade] getById() called - id: {}", departmentId);
        return departmentService.getDepartmentById(departmentId);
    }

    public List<DepartmentResponseDTO> getAllActive() {
        log.info("[Facade:DepartmentFacade] getAllActive() called");
        return departmentService.getAllActiveDepartments();
    }

    public DepartmentResponseDTO updateDepartment(Long departmentId, @Valid DepartmentRequestDTO requestDTO) {
        log.info("[Facade:DepartmentFacade] updateDepartment() called - id: {}", departmentId);
        return departmentService.updateDepartment(departmentId, requestDTO);
    }

    public List<DepartmentResponseDTO> searchDepartments(String keyword) {
        log.info("[Facade:DepartmentFacade] searchDepartments() called - keyword: '{}'", keyword);
        return departmentService.searchDepartments(keyword);
    }

    public void deleteById(Long departmentId) {
        log.info("[Facade:DepartmentFacade] deleteById() called - id: {}", departmentId);
        departmentService.deleteDepartment(departmentId);
    }
}
