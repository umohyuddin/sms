package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.guardianRelation.responseDto.GuardianRelationResponseDTO;
import com.smartsolutions.eschool.student.dtos.guardianRelation.requestDto.GuardianRelationCreateRequestDTO;
import com.smartsolutions.eschool.student.service.GuardianRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class GuardianRelationFacade {

    private final GuardianRelationService guardianRelationService;

    public GuardianRelationFacade(GuardianRelationService guardianRelationService) {
        this.guardianRelationService = guardianRelationService;
    }

    public List<GuardianRelationResponseDTO> getAll() {
        log.info("[Facade:GuardianRelationFacade] getAll() called");
        return guardianRelationService.getAll();
    }

    public List<GuardianRelationResponseDTO> getActive() {
        log.info("[Facade:GuardianRelationFacade] getActive() called");
        return guardianRelationService.getActive();
    }

    public List<GuardianRelationResponseDTO> getInactive() {
        log.info("[Facade:GuardianRelationFacade] getInactive() called");
        return guardianRelationService.getInactive();
    }

    public GuardianRelationResponseDTO getById(Long id) {
        log.info("[Facade:GuardianRelationFacade] getById() called - id: {}", id);
        return guardianRelationService.getById(id);
    }

    public List<GuardianRelationResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:GuardianRelationFacade] searchByKeyword() called - keyword: {}", keyword);
        return guardianRelationService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:GuardianRelationFacade] softDeleteById() called - id: {}", id);
        guardianRelationService.softDeleteById(id);
    }

    public GuardianRelationResponseDTO createGuardianRelation(GuardianRelationCreateRequestDTO dto) {
        log.info("[Facade:GuardianRelationFacade] createGuardianRelation() called");
        return guardianRelationService.createGuardianRelation(dto);
    }

    public GuardianRelationResponseDTO updateGuardianRelation(Long id, GuardianRelationCreateRequestDTO dto) {
        log.info("[Facade:GuardianRelationFacade] updateGuardianRelation() called - id: {}", id);
        return guardianRelationService.updateGuardianRelation(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:GuardianRelationFacade] getStatistics() called");
        return guardianRelationService.getStatistics();
    }
}
