package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.departmentTypes.requestDto.DepartmentTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departmentTypes.response.DepartmentTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DepartmentTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class DepartmentTypeFacade {

    private final DepartmentTypeService departmentTypeService;

    public DepartmentTypeFacade(DepartmentTypeService departmentTypeService) {
        this.departmentTypeService = departmentTypeService;
    }

    public List<DepartmentTypeResponseDTO> getAll() {
        log.info("[Facade:DepartmentTypeFacade] getAll() called");
        return departmentTypeService.getAll();
    }

    public DepartmentTypeResponseDTO getById(Long id) {
        log.info("[Facade:DepartmentTypeFacade] getById() called - id: {}", id);
        return departmentTypeService.getById(id);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:DepartmentTypeFacade] softDeleteById() called - id: {}", id);
        departmentTypeService.softDeleteById(id);
    }

    public DepartmentTypeResponseDTO createDepartmentType(DepartmentTypeCreateRequestDTO dto) {
        log.info("[Facade:DepartmentTypeFacade] createDepartmentType() called");
        return departmentTypeService.createDepartmentType(dto);
    }

    public DepartmentTypeResponseDTO updateDepartmentType(Long id, DepartmentTypeCreateRequestDTO dto) {
        log.info("[Facade:DepartmentTypeFacade] updateDepartmentType() called - id: {}", id);
        return departmentTypeService.updateDepartmentType(id, dto);
    }

    public List<DepartmentTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:DepartmentTypeFacade] searchByKeyword() called - keyword: {}", keyword);
        return departmentTypeService.searchByKeyword(keyword);
    }

    public java.util.Map<String, Long> getStatistics() {
        log.info("[Facade:DepartmentTypeFacade] getStatistics() called");
        return departmentTypeService.getStatistics();
    }
}
