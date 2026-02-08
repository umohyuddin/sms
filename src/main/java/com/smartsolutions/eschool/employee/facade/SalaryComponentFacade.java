package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.SalaryComponentSearchDto;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.SalaryComponentService;
import com.smartsolutions.eschool.global.enums.ComponentType;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SalaryComponentFacade {

    private final SalaryComponentService salaryComponentService;

    public SalaryComponentFacade(SalaryComponentService salaryComponentService) {
        this.salaryComponentService = salaryComponentService;
    }

    public SalaryComponentResponseDTO createComponent(SalaryComponentRequestDTO requestDTO) {
        log.info("Facade: Request to create SalaryComponent: {}", requestDTO.getName());
        SalaryComponentResponseDTO result = salaryComponentService.createComponent(requestDTO);
        log.info("Facade: Successfully created SalaryComponent: id={}", result.getId());
        return result;
    }

    public SalaryComponentResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch SalaryComponent by id: {}", id);
        SalaryComponentResponseDTO result = salaryComponentService.getById(id);
        log.info("Facade: Successfully fetched SalaryComponent: id={}", id);
        return result;
    }

    public List<SalaryComponentResponseDTO> getAllNonDeleted() {
        log.info("Facade: Request to fetch all non-deleted SalaryComponents");
        List<SalaryComponentResponseDTO> result = salaryComponentService.getAllNonDeleted();
        log.info("Facade: Successfully fetched {} SalaryComponents", result.size());
        return result;
    }

    public List<SalaryComponentResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search SalaryComponents by keyword: '{}'", keyword);
        List<SalaryComponentResponseDTO> result = salaryComponentService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} SalaryComponents", result.size());
        return result;
    }

    public List<SalaryComponentResponseDTO> searchComplex(SalaryComponentSearchDto searchDto) {
        log.info("Facade: Request for complex search for SalaryComponents");
        List<SalaryComponentResponseDTO> result = salaryComponentService.searchComplex(
                searchDto.getName(), searchDto.getType(), searchDto.getIsPercentage());
        log.info("Facade: Complex search completed, found {} SalaryComponents", result.size());
        return result;
    }

    public SalaryComponentResponseDTO updateComponent(Long id, SalaryComponentRequestDTO requestDTO) {
        log.info("Facade: Request to update SalaryComponent ID: {}", id);
        SalaryComponentResponseDTO result = salaryComponentService.updateComponent(id, requestDTO);
        log.info("Facade: Successfully updated SalaryComponent: id={}", result.getId());
        return result;
    }

    public void delete(Long id) {
        log.info("Facade: Request to delete SalaryComponent by id: {}", id);
        salaryComponentService.delete(id);
        log.info("Facade: Successfully deleted SalaryComponent: id={}", id);
    }

    public Long getTotalCount() {
        log.info("Facade: Request to fetch total SalaryComponent count");
        return salaryComponentService.getTotalCount();
    }
}
