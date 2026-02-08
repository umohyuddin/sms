package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureDetailDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureResponseDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.service.SalaryStructureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SalaryStructureFacade {

    private final SalaryStructureService salaryStructureService;

    public SalaryStructureFacade(SalaryStructureService salaryStructureService) {
        this.salaryStructureService = salaryStructureService;
    }

    public SalaryStructureResponseDTO create(SalaryStructureRequestDTO requestDTO) {
        log.info("Facade: Request to create SalaryStructure for employeeType ID: {}", requestDTO.getEmployeeTypeId());
        SalaryStructureResponseDTO result = salaryStructureService.create(requestDTO);
        log.info("Facade: Successfully created SalaryStructure: id={}", result.getId());
        return result;
    }

    public SalaryStructureResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch SalaryStructure by id: {}", id);
        SalaryStructureResponseDTO result = salaryStructureService.getById(id);
        log.info("Facade: Successfully fetched SalaryStructure: id={}", id);
        return result;
    }

    public List<SalaryStructureResponseDTO> getAllNonDeleted() {
        log.info("Facade: Request to fetch all non-deleted SalaryStructures");
        List<SalaryStructureResponseDTO> result = salaryStructureService.getAllNonDeleted();
        log.info("Facade: Successfully fetched {} SalaryStructures", result.size());
        return result;
    }

    public SalaryStructureResponseDTO update(Long id, SalaryStructureRequestDTO requestDTO) {
        log.info("Facade: Request to update SalaryStructure ID: {}", id);
        SalaryStructureResponseDTO result = salaryStructureService.update(id, requestDTO);
        log.info("Facade: Successfully updated SalaryStructure: id={}", result.getId());
        return result;
    }

    public void delete(Long id) {
        log.info("Facade: Request to delete SalaryStructure by id: {}", id);
        salaryStructureService.delete(id);
        log.info("Facade: Successfully deleted SalaryStructure: id={}", id);
    }

    public SalaryStructureResponseDTO closeSalaryStructure(Long id) {
        log.info("Facade: Request to close SalaryStructure ID: {}", id);
        SalaryStructureResponseDTO result = salaryStructureService.closeSalaryStructure(id);
        log.info("Facade: Successfully closed SalaryStructure ID: {}", id);
        return result;
    }

    public List<SalaryStructureResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search SalaryStructures by keyword: '{}'", keyword);
        List<SalaryStructureResponseDTO> result = salaryStructureService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} SalaryStructures", result.size());
        return result;
    }

    public List<SalaryStructureResponseDTO> searchComplex(Long employeeTypeId, String employeeTypeName, BigDecimal minSalary, BigDecimal maxSalary, LocalDate fromDate, LocalDate toDate, Boolean isCurrent) {
        log.info("Facade: Request for complex search for SalaryStructures");
        List<SalaryStructureResponseDTO> result = salaryStructureService.searchComplex(employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);
        log.info("Facade: Complex search completed, found {} SalaryStructures", result.size());
        return result;
    }

    public List<SalaryStructureDetailDTO> getAllSalaryStructuresWithDetails() {
        log.info("Facade: Request to fetch all SalaryStructures with details");
        List<SalaryStructureDetailDTO> result = salaryStructureService.getAllSalaryStructures();
        log.info("Facade: Successfully fetched {} SalaryStructures with details", result.size());
        return result;
    }

    public SalaryStructureDetailDTO getSalaryStructureByEmployeeType(Long employeeTypeId) {
        log.info("Facade: Request to fetch current SalaryStructure details for employeeTypeID: {}", employeeTypeId);
        SalaryStructureDetailDTO result = salaryStructureService.getSalaryStructureByEmployeeType(employeeTypeId);
        log.info("Facade: Successfully fetched SalaryStructure details for employeeTypeID: {}", employeeTypeId);
        return result;
    }

    public Long getTotalCount() {
        log.info("Facade: Request to fetch total SalaryStructure count");
        return salaryStructureService.getTotalCount();
    }
}
