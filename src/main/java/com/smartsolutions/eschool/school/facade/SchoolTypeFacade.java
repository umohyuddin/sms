package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.service.SchoolTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SchoolTypeFacade {

    private final SchoolTypeService schoolTypeService;

    public SchoolTypeFacade(SchoolTypeService schoolTypeService) {
        this.schoolTypeService = schoolTypeService;
    }

    public SchoolTypeResponseDTO createSchoolType(SchoolTypeCreateRequestDTO requestDTO) {
        log.info("Facade: Request to create SchoolType: {}", requestDTO.getCode());
        SchoolTypeResponseDTO result = schoolTypeService.createSchoolType(requestDTO);
        log.info("Facade: Successfully created SchoolType with id: {}", result.getId());
        return result;
    }

    public List<SchoolTypeResponseDTO> getAll() {
        log.info("Facade: Request to fetch all SchoolTypes");
        List<SchoolTypeResponseDTO> result = schoolTypeService.getAll();
        log.info("Facade: Successfully fetched {} SchoolTypes", result.size());
        return result;
    }

    public List<SchoolTypeResponseDTO> getAllActive() {
        log.info("Facade: Request to fetch all active SchoolTypes");
        List<SchoolTypeResponseDTO> result = schoolTypeService.getAllActive();
        log.info("Facade: Successfully fetched {} active SchoolTypes", result.size());
        return result;
    }

    public SchoolTypeResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch SchoolType by id: {}", id);
        SchoolTypeResponseDTO result = schoolTypeService.getById(id);
        log.info("Facade: Successfully fetched SchoolType: id={}", id);
        return result;
    }

    public SchoolTypeResponseDTO updateSchoolType(Long id, SchoolTypeUpdateRequestDTO requestDTO) {
        log.info("Facade: Request to update SchoolType id: {}", id);
        SchoolTypeResponseDTO result = schoolTypeService.updateSchoolType(id, requestDTO);
        log.info("Facade: Successfully updated SchoolType: id={}", result.getId());
        return result;
    }

    public void deleteById(Long id) {
        log.info("Facade: Request to delete SchoolType by id: {}", id);
        schoolTypeService.deleteById(id);
        log.info("Facade: Successfully deleted SchoolType: id={}", id);
    }

    public List<SchoolTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search SchoolTypes with keyword: '{}'", keyword);
        List<SchoolTypeResponseDTO> result = schoolTypeService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} SchoolTypes", result.size());
        return result;
    }

    public SchoolTypeResponseDTO activate(Long id) {
        log.info("Facade: Request to activate SchoolType id: {}", id);
        SchoolTypeResponseDTO result = schoolTypeService.activate(id);
        log.info("Facade: Successfully activated SchoolType: id={}", id);
        return result;
    }

    public SchoolTypeResponseDTO deactivate(Long id) {
        log.info("Facade: Request to deactivate SchoolType id: {}", id);
        SchoolTypeResponseDTO result = schoolTypeService.deactivate(id);
        log.info("Facade: Successfully deactivated SchoolType: id={}", id);
        return result;
    }
}
