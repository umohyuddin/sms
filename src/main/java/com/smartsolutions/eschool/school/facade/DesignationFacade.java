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
    private final DesignationService designationService;

    public DesignationFacade(DesignationService designationService) {
        this.designationService = designationService;
    }

    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        log.info("[Facade:DesignationFacade] createDesignation() called - name: {}", requestDTO.getDesignationName());
        DesignationResponseDTO result = designationService.createDesignation(requestDTO);
        log.info("[Facade:DesignationFacade] createDesignation() succeeded - created ID: {}", result.getId());
        return result;
    }

    public DesignationResponseDTO getById(Long designationId) {
        log.info("[Facade:DesignationFacade] getById() called - id: {}", designationId);
        DesignationResponseDTO result = designationService.getById(designationId);
        log.info("[Facade:DesignationFacade] getById() succeeded - id: {}", designationId);
        return result;
    }

    public List<DesignationResponseDTO> getAll() {
        log.info("[Facade:DesignationFacade] getAll() called");
        List<DesignationResponseDTO> result = designationService.getAll();
        log.info("[Facade:DesignationFacade] getAll() succeeded - found {} resources", result.size());
        return result;
    }

    public List<DesignationResponseDTO> getAllActive() {
        log.info("[Facade:DesignationFacade] getAllActive() called");
        List<DesignationResponseDTO> result = designationService.getAllActive();
        log.info("[Facade:DesignationFacade] getAllActive() succeeded - found {} active resources", result.size());
        return result;
    }

    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:DesignationFacade] searchByKeyword() called - keyword: '{}'", keyword);
        List<DesignationResponseDTO> result = designationService.searchByKeyword(keyword);
        log.info("[Facade:DesignationFacade] searchByKeyword() succeeded - found {} resources", result.size());
        return result;
    }

    public DesignationResponseDTO updateDesignation(Long designationId, @Valid DesignationRequestDTO requestDTO) {
        log.info("[Facade:DesignationFacade] updateDesignation() called - id: {}", designationId);
        DesignationResponseDTO result = designationService.updateDesignation(designationId, requestDTO);
        log.info("[Facade:DesignationFacade] updateDesignation() succeeded - id: {}", designationId);
        return result;
    }

    public void softDeleteById(Long designationId) {
        log.info("[Facade:DesignationFacade] softDeleteById() called - id: {}", designationId);
        designationService.softDeleteById(designationId);
        log.info("[Facade:DesignationFacade] softDeleteById() succeeded - id: {}", designationId);
    }

    public List<DesignationCountDTO> getStaffCountReport() {
        log.info("[Facade:DesignationFacade] getStaffCountReport() called");
        return designationService.getStaffCountReport();
    }
}
