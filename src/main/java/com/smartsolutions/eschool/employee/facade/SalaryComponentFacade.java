package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.service.SalaryComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class SalaryComponentFacade {
    private final SalaryComponentService salaryComponentService;

    public SalaryComponentFacade(SalaryComponentService salaryComponentService) {
        this.salaryComponentService = salaryComponentService;
    }

    public List<SalaryComponentResponseDTO> getAll() {
        log.info("[Facade:SalaryComponentFacade] getAll() called");
        return salaryComponentService.getAll();
    }

    public List<SalaryComponentResponseDTO> getByOrganizationId(Long organizationId) {
        log.info("[Facade:SalaryComponentFacade] getByOrganizationId() called - organizationId: {}", organizationId);
        return salaryComponentService.getByOrganizationId(organizationId);
    }

    public SalaryComponentResponseDTO getById(Long id) {
        log.info("[Facade:SalaryComponentFacade] getById() called - id: {}", id);
        return salaryComponentService.getById(id);
    }

    public List<SalaryComponentResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:SalaryComponentFacade] searchByKeyword() called - keyword: {}", keyword);
        return salaryComponentService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:SalaryComponentFacade] softDeleteById() called - id: {}", id);
        salaryComponentService.softDeleteById(id);
    }

    public SalaryComponentResponseDTO create(SalaryComponentRequestDTO dto) {
        log.info("[Facade:SalaryComponentFacade] create() called");
        return salaryComponentService.create(dto);
    }

    public SalaryComponentResponseDTO update(Long id, SalaryComponentRequestDTO dto) {
        log.info("[Facade:SalaryComponentFacade] update() called - id: {}", id);
        return salaryComponentService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:SalaryComponentFacade] getStatistics() called");
        return salaryComponentService.getStatistics();
    }
}
