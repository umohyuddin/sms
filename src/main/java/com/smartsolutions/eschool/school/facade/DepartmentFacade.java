package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.departments.requestDto.DepartmentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.service.DepartmentService;
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

    public List<DepartmentResponseDTO> getAll() {
        log.info("[Facade:DepartmentFacade] getAll() called");
        return departmentService.getAll();
    }

    public List<DepartmentResponseDTO> getByCampusId(Long campusId) {
        log.info("[Facade:DepartmentFacade] getByCampusId() called - campus: {}", campusId);
        return departmentService.getByCampusId(campusId);
    }

    public DepartmentResponseDTO getById(Long id) {
        log.info("[Facade:DepartmentFacade] getById() called - id: {}", id);
        return departmentService.getById(id);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:DepartmentFacade] softDeleteById() called - id: {}", id);
        departmentService.softDeleteById(id);
    }

    public DepartmentResponseDTO createDepartment(DepartmentCreateRequestDTO dto) {
        log.info("[Facade:DepartmentFacade] createDepartment() called");
        return departmentService.createDepartment(dto);
    }

    public DepartmentResponseDTO updateDepartment(Long id, DepartmentCreateRequestDTO dto) {
        log.info("[Facade:DepartmentFacade] updateDepartment() called - id: {}", id);
        return departmentService.updateDepartment(id, dto);
    }

    public List<DepartmentResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:DepartmentFacade] searchByKeyword() called - keyword: {}", keyword);
        return departmentService.searchByKeyword(keyword);
    }

    public java.util.Map<String, Long> getStatistics() {
        log.info("[Facade:DepartmentFacade] getStatistics() called");
        return departmentService.getStatistics();
    }
}
