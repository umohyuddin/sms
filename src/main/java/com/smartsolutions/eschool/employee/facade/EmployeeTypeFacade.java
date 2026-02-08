
package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.EmployeeTypeService;
import jakarta.validation.Valid;
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
public class EmployeeTypeFacade {

    private final EmployeeTypeService employeeTypeService;

    public EmployeeTypeFacade(EmployeeTypeService employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeTypeResponseDTO create(@Valid EmployeeTypeRequestDTO requestDTO) {
        log.info("Facade: Request to create EmployeeType: {}", requestDTO.getName());
        EmployeeTypeResponseDTO result = employeeTypeService.create(requestDTO);
        log.info("Facade: Successfully created EmployeeType: id={}", result.getId());
        return result;
    }

    public EmployeeTypeResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch EmployeeType by id: {}", id);
        EmployeeTypeResponseDTO result = employeeTypeService.getById(id);
        log.info("Facade: Successfully fetched EmployeeType: id={}", id);
        return result;
    }

    public List<EmployeeTypeResponseDTO> getAll() {
        log.info("Facade: Request to fetch all EmployeeTypes");
        List<EmployeeTypeResponseDTO> result = employeeTypeService.getAll();
        log.info("Facade: Successfully fetched {} EmployeeTypes", result.size());
        return result;
    }

    public List<EmployeeTypeResponseDTO> getAllActive() {
        log.info("Facade: Request to fetch all active EmployeeTypes");
        List<EmployeeTypeResponseDTO> result = employeeTypeService.getAllActive();
        log.info("Facade: Successfully fetched {} active EmployeeTypes", result.size());
        return result;
    }

    public List<EmployeeTypeResponseDTO> getAllInactive() {
        log.info("Facade: Request to fetch all inactive EmployeeTypes");
        List<EmployeeTypeResponseDTO> result = employeeTypeService.getAllInactive();
        log.info("Facade: Successfully fetched {} inactive EmployeeTypes", result.size());
        return result;
    }

    public EmployeeTypeResponseDTO update(Long id, @Valid EmployeeTypeRequestDTO requestDTO) {
        log.info("Facade: Request to update EmployeeType id: {}", id);
        EmployeeTypeResponseDTO result = employeeTypeService.update(id, requestDTO);
        log.info("Facade: Successfully updated EmployeeType: id={}", id);
        return result;
    }

    public void delete(Long id) {
        log.info("Facade: Request to delete EmployeeType by id: {}", id);
        employeeTypeService.delete(id);
        log.info("Facade: Successfully deleted EmployeeType: id={}", id);
    }

    public List<EmployeeTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search EmployeeTypes by keyword: '{}'", keyword);
        List<EmployeeTypeResponseDTO> result = employeeTypeService.search(keyword);
        log.info("Facade: Search completed, found {} EmployeeTypes", result.size());
        return result;
    }

    public long countAll() {
        return employeeTypeService.countAll();
    }

    public long countActive() {
        return employeeTypeService.countActive();
    }

    public long countInactive() {
        return employeeTypeService.countInactive();
    }
}
