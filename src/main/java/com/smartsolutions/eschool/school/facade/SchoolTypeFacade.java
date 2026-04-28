package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.service.SchoolTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class SchoolTypeFacade {

    private final SchoolTypeService nSchoolTypeService;

    public SchoolTypeFacade(SchoolTypeService nSchoolTypeService) {
        this.nSchoolTypeService = nSchoolTypeService;
    }

    public List<SchoolTypeResponseDTO> getAll() {
        log.info("[Facade:SchoolTypeFacade] getAll() called");
        return nSchoolTypeService.getAll();
    }

    public List<SchoolTypeResponseDTO> getAllActive() {
        log.info("[Facade:SchoolTypeFacade] getAllActive() called");
        return nSchoolTypeService.getAllActive();
    }

    public SchoolTypeResponseDTO getById(Long id) {
        log.info("[Facade:SchoolTypeFacade] getById() called - id: {}", id);
        return nSchoolTypeService.getById(id);
    }

    public SchoolTypeResponseDTO create(SchoolTypeCreateRequestDTO requestDTO) {
        log.info("[Facade:SchoolTypeFacade] create() called");
        return nSchoolTypeService.create(requestDTO);
    }

    public SchoolTypeResponseDTO update(Long id, SchoolTypeCreateRequestDTO requestDTO) {
        log.info("[Facade:SchoolTypeFacade] update() called - id: {}", id);
        return nSchoolTypeService.update(id, requestDTO);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:SchoolTypeFacade] softDeleteById() called - id: {}", id);
        nSchoolTypeService.softDeleteById(id);
    }

    public List<SchoolTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:SchoolTypeFacade] searchByKeyword() called - keyword: {}", keyword);
        return nSchoolTypeService.searchByKeyword(keyword);
    }

    public SchoolTypeResponseDTO activate(Long id) {
        log.info("[Facade:SchoolTypeFacade] activate() called - id: {}", id);
        return nSchoolTypeService.activate(id);
    }

    public SchoolTypeResponseDTO deactivate(Long id) {
        log.info("[Facade:SchoolTypeFacade] deactivate() called - id: {}", id);
        return nSchoolTypeService.deactivate(id);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:SchoolTypeFacade] getStatistics() called");
        return nSchoolTypeService.getStatistics();
    }
}

