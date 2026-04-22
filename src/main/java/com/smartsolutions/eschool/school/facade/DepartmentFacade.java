package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentCountDTO;
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
        log.info("[Facade:DepartmentFacade] createDepartment() called - name: {}", requestDTO.getDepartmentName());
        DepartmentResponseDTO result = departmentService.createDepartment(requestDTO);
        log.info("[Facade:DepartmentFacade] createDepartment() succeeded - ID: {}", result.getId());
        return result;
    }

    public DepartmentResponseDTO getById(Long id) {
        log.info("[Facade:DepartmentFacade] getById() called - id: {}", id);
        DepartmentResponseDTO result = departmentService.getById(id);
        log.info("[Facade:DepartmentFacade] getById() succeeded - id: {}", id);
        return result;
    }

    public List<DepartmentResponseDTO> getAll() {
        log.info("[Facade:DepartmentFacade] getAll() called");
        List<DepartmentResponseDTO> result = departmentService.getAll();
        log.info("[Facade:DepartmentFacade] getAll() succeeded - Found {} departments", result.size());
        return result;
    }

    public List<DepartmentResponseDTO> getAllActive() {
        log.info("[Facade:DepartmentFacade] getAllActive() called");
        List<DepartmentResponseDTO> result = departmentService.getAllActive();
        log.info("[Facade:DepartmentFacade] getAllActive() succeeded - Found {} active departments", result.size());
        return result;
    }

    public DepartmentResponseDTO updateDepartment(Long id, @Valid DepartmentRequestDTO requestDTO) {
        log.info("[Facade:DepartmentFacade] updateDepartment() called - id: {}", id);
        DepartmentResponseDTO result = departmentService.updateDepartment(id, requestDTO);
        log.info("[Facade:DepartmentFacade] updateDepartment() succeeded - id: {}", id);
        return result;
    }

    public List<DepartmentResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:DepartmentFacade] searchByKeyword() called - keyword: '{}'", keyword);
        List<DepartmentResponseDTO> result = departmentService.searchByKeyword(keyword);
        log.info("[Facade:DepartmentFacade] searchByKeyword() succeeded - Found {} departments", result.size());
        return result;
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:DepartmentFacade] softDeleteById() called - id: {}", id);
        departmentService.softDeleteById(id);
        log.info("[Facade:DepartmentFacade] softDeleteById() succeeded - id: {}", id);
    }

    public List<DepartmentCountDTO> getStaffCountReport() {
        log.info("[Facade:DepartmentFacade] getStaffCountReport() called");
        return departmentService.getStaffCountReport();
    }
}
