package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.dtos.admissionType.requestDto.AdmissionTypeCreateRequestDTO;
import com.smartsolutions.eschool.student.service.AdmissionTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class AdmissionTypeFacade {

    private final AdmissionTypeService admissionTypeService;

    public AdmissionTypeFacade(AdmissionTypeService admissionTypeService) {
        this.admissionTypeService = admissionTypeService;
    }

    public List<AdmissionTypeResponseDTO> getAll() {
        log.info("[Facade:AdmissionTypeFacade] getAll() called");
        return admissionTypeService.getAll();
    }

    public AdmissionTypeResponseDTO getById(Long id) {
        log.info("[Facade:AdmissionTypeFacade] getById() called - id: {}", id);
        return admissionTypeService.getById(id);
    }

    public List<AdmissionTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:AdmissionTypeFacade] searchByKeyword() called - keyword: {}", keyword);
        return admissionTypeService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:AdmissionTypeFacade] softDeleteById() called - id: {}", id);
        admissionTypeService.softDeleteById(id);
    }

    public AdmissionTypeResponseDTO createAdmissionType(AdmissionTypeCreateRequestDTO dto) {
        log.info("[Facade:AdmissionTypeFacade] createAdmissionType() called");
        return admissionTypeService.createAdmissionType(dto);
    }

    public AdmissionTypeResponseDTO updateAdmissionType(Long id, AdmissionTypeCreateRequestDTO dto) {
        log.info("[Facade:AdmissionTypeFacade] updateAdmissionType() called - id: {}", id);
        return admissionTypeService.updateAdmissionType(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:AdmissionTypeFacade] getStatistics() called");
        return admissionTypeService.getStatistics();
    }
}
