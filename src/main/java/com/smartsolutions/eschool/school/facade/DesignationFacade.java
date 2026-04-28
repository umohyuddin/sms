package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationCountDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.service.DesignationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class DesignationFacade {
    private final DesignationService nDesignationService;

    public DesignationFacade(DesignationService nDesignationService) {
        this.nDesignationService = nDesignationService;
    }

    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        log.info("[Facade:DesignationFacade] createDesignation() called - Request to create designation: {}", requestDTO.getDesignationName());
        return nDesignationService.createDesignation(requestDTO);
    }

    public DesignationResponseDTO getById(Long designationId) {
        log.info("[Facade:DesignationFacade] getById() called - id: {}", designationId);
        return nDesignationService.getById(designationId);
    }

    public List<DesignationResponseDTO> getAll() {
        log.info("[Facade:DesignationFacade] getAll() called");
        return nDesignationService.getAll();
    }

    public List<DesignationResponseDTO> getAllActive() {
        log.info("[Facade:DesignationFacade] getAllActive() called");
        return nDesignationService.getAllActive();
    }

    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:DesignationFacade] searchByKeyword() called - keyword: {}", keyword);
        return nDesignationService.searchByKeyword(keyword);
    }

    public DesignationResponseDTO updateDesignation(Long designationId, @Valid DesignationRequestDTO requestDTO) {
        log.info("[Facade:DesignationFacade] updateDesignation() called - id: {}", designationId);
        return nDesignationService.updateDesignation(designationId, requestDTO);
    }

    public void softDeleteById(Long designationId) {
        log.info("[Facade:DesignationFacade] softDeleteById() called - id: {}", designationId);
        nDesignationService.softDeleteById(designationId);
    }

    public List<DesignationCountDTO> getStaffCountReport() {
        log.info("[Facade:DesignationFacade] getStaffCountReport() called");
        return nDesignationService.getStaffCountReport();
    }
}
