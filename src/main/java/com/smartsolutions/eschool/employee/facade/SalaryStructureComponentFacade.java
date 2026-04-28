package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request.SalaryStructureComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.service.SalaryStructureComponentService;
import jakarta.validation.constraints.DecimalMin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SalaryStructureComponentFacade {

    private final SalaryStructureComponentService componentService;

    public SalaryStructureComponentFacade(SalaryStructureComponentService componentService) {
        this.componentService = componentService;
    }

    public List<SalaryStructureComponentResponseDTO> create(SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Facade: Request to create SalaryStructureComponents for salaryStructureId: {}", requestDTO.getSalaryStructureId());
        List<SalaryStructureComponentResponseDTO> result = componentService.create(requestDTO);
        log.info("Facade: Successfully created {} components", result.size());
        return result;
    }

    public SalaryStructureComponentResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch SalaryStructureComponent by id: {}", id);
        SalaryStructureComponentResponseDTO result = componentService.getById(id);
        log.info("Facade: Successfully fetched SalaryStructureComponent: id={}", id);
        return result;
    }

    public List<SalaryStructureComponentResponseDTO> getAllNonDeleted() {
        log.info("Facade: Request to fetch all non-deleted SalaryStructureComponents");
        List<SalaryStructureComponentResponseDTO> result = componentService.getAllNonDeleted();
        log.info("Facade: Successfully fetched {} SalaryStructureComponents", result.size());
        return result;
    }

    public List<SalaryStructureComponentResponseDTO> getBySalaryStructure(Long salaryStructureId) {
        log.info("Facade: Request to fetch components for salaryStructureId: {}", salaryStructureId);
        List<SalaryStructureComponentResponseDTO> result = componentService.getBySalaryStructureId(salaryStructureId);
        log.info("Facade: Successfully fetched {} components for salaryStructureId: {}", result.size(), salaryStructureId);
        return result;
    }

    public List<SalaryStructureComponentResponseDTO> searchByKeyword(Long salaryStructureId, String keyword) {
        log.info("Facade: Request to search components in salaryStructureId: {} with keyword: '{}'", salaryStructureId, keyword);
        List<SalaryStructureComponentResponseDTO> result = componentService.searchByKeyword(salaryStructureId, keyword);
        log.info("Facade: Search completed, found {} components", result.size());
        return result;
    }

    public void delete(Long id) {
        log.info("Facade: Request to delete SalaryStructureComponent by id: {}", id);
        componentService.delete(id);
        log.info("Facade: Successfully deleted SalaryStructureComponent: id={}", id);
    }

    public List<SalaryStructureComponentResponseDTO> updateComponentsByEmployeeType(Long employeeTypeId, SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Facade: Request to update components for employeeTypeId: {}", employeeTypeId);
        List<SalaryStructureComponentResponseDTO> result = componentService.updateComponentsByEmployeeType(employeeTypeId, requestDTO);
        log.info("Facade: Successfully updated components for employeeTypeId: {}", employeeTypeId);
        return result;
    }

    public Long countBySalaryStructureId(Long salaryStructureId) {
        log.info("Facade: Request to count components for salaryStructureId: {}", salaryStructureId);
        return componentService.countBySalaryStructureId(salaryStructureId);
    }

    public Long getTotalCount() {
        log.info("Facade: Request to fetch total SalaryStructureComponent count");
        return componentService.getTotalCount();
    }
}
