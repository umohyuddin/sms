package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.service.EmployeeTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class EmployeeTypeFacade {
    private final EmployeeTypeService employeeTypeService;

    public EmployeeTypeFacade(EmployeeTypeService employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public List<EmployeeTypeResponseDTO> getAll() {
        log.info("[Facade:EmployeeTypeFacade] getAll() called");
        return employeeTypeService.getAll();
    }

    public List<EmployeeTypeResponseDTO> getAllActive() {
        log.info("[Facade:EmployeeTypeFacade] getAllActive() called");
        return employeeTypeService.getAllActive();
    }

    public EmployeeTypeResponseDTO getById(Long id) {
        log.info("[Facade:EmployeeTypeFacade] getById() called - id: {}", id);
        return employeeTypeService.getById(id);
    }

    public List<EmployeeTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:EmployeeTypeFacade] searchByKeyword() called - keyword: {}", keyword);
        return employeeTypeService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:EmployeeTypeFacade] softDeleteById() called - id: {}", id);
        employeeTypeService.softDeleteById(id);
    }

    public EmployeeTypeResponseDTO create(EmployeeTypeRequestDTO dto) {
        log.info("[Facade:EmployeeTypeFacade] create() called");
        return employeeTypeService.create(dto);
    }

    public EmployeeTypeResponseDTO update(Long id, EmployeeTypeRequestDTO dto) {
        log.info("[Facade:EmployeeTypeFacade] update() called - id: {}", id);
        return employeeTypeService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:EmployeeTypeFacade] getStatistics() called");
        return employeeTypeService.getStatistics();
    }
}
