package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DesignationService;
import com.smartsolutions.eschool.school.service.DiscountTypeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class DesignationFacade {
    private final DesignationService designationService;

    public DesignationFacade(DesignationService designationService) {
        this.designationService = designationService;
    }

    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        log.info("Facade: Request to create Designation: {}", requestDTO.getDesignationName());
        DesignationResponseDTO result = designationService.createDesignation(requestDTO);
        log.info("Facade: Designation created successfully with ID: {}", result.getId());
        return result;
    }

    public DesignationResponseDTO getById(Long designationId) {
        log.info("Facade: Request to fetch Designation ID: {}", designationId);
        DesignationResponseDTO result = designationService.getById(designationId);
        log.info("Facade: Successfully fetched Designation ID: {}", designationId);
        return result;
    }

    public List<DesignationResponseDTO> getAll() {
        log.info("Facade: Request to fetch all Designations");
        List<DesignationResponseDTO> result = designationService.getAll();
        log.info("Facade: Successfully fetched {} Designations", result.size());
        return result;
    }

    public List<DesignationResponseDTO> getAllActive() {
        log.info("Facade: Request to fetch all active Designations");
        List<DesignationResponseDTO> result = designationService.getAllActive();
        log.info("Facade: Successfully fetched {} active Designations", result.size());
        return result;
    }

    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Designations with keyword: '{}'", keyword);
        List<DesignationResponseDTO> result = designationService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Designations", result.size());
        return result;
    }

    public List<DesignationResponseDTO> getByDepartmentId(Long departmentId) {
        log.info("Facade: Request to fetch Designations for Department ID: {}", departmentId);
        List<DesignationResponseDTO> result = designationService.getByDepartmentId(departmentId);
        log.info("Facade: Successfully fetched {} Designations for Department ID: {}", result.size(), departmentId);
        return result;
    }

    public DesignationResponseDTO updateDesignation(Long designationId, @Valid DesignationRequestDTO requestDTO) {
        log.info("Facade: Request to update Designation ID: {}", designationId);
        DesignationResponseDTO result = designationService.updateDesignation(designationId, requestDTO);
        log.info("Facade: Successfully updated Designation ID: {}", designationId);
        return result;
    }
}
