package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.departments.requestDto.DepartmentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class DepartmentFacade {

    private final DepartmentService nDepartmentService;

    public DepartmentFacade(DepartmentService nDepartmentService) {
        this.nDepartmentService = nDepartmentService;
    }

    public List<DepartmentResponseDTO> getAll() {
        log.info("[Facade:DepartmentFacade] getAll() called");
        return nDepartmentService.getAll();
    }

    public List<DepartmentResponseDTO> getByCampusId(Long campusId) {
        log.info("[Facade:DepartmentFacade] getByCampusId() called - campus: {}", campusId);
        return nDepartmentService.getByCampusId(campusId);
    }

    public DepartmentResponseDTO getById(Long id) {
        log.info("[Facade:DepartmentFacade] getById() called - id: {}", id);
        return nDepartmentService.getById(id);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:DepartmentFacade] softDeleteById() called - id: {}", id);
        nDepartmentService.softDeleteById(id);
    }

    public DepartmentResponseDTO createDepartment(DepartmentCreateRequestDTO dto) {
        log.info("[Facade:DepartmentFacade] createDepartment() called - name: {}", dto.getDepartmentName());
        return nDepartmentService.createDepartment(dto);
    }

    public DepartmentResponseDTO updateDepartment(Long id, DepartmentCreateRequestDTO dto) {
        log.info("[Facade:DepartmentFacade] updateDepartment() called - id: {}", id);
        return nDepartmentService.updateDepartment(id, dto);
    }

    public List<DepartmentResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:DepartmentFacade] searchByKeyword() called - keyword: {}", keyword);
        return nDepartmentService.searchByKeyword(keyword);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:DepartmentFacade] getStatistics() called");
        return nDepartmentService.getStatistics();
    }
}
