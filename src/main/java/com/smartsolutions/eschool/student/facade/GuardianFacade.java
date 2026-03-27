package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.guardian.responseDto.GuardianResponseDTO;
import com.smartsolutions.eschool.student.dtos.guardian.requestDto.GuardianCreateRequestDTO;
import com.smartsolutions.eschool.student.service.GuardianService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class GuardianFacade {

    private final GuardianService guardianService;

    public GuardianFacade(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    public List<GuardianResponseDTO> getAll() {
        log.info("[Facade:GuardianFacade] getAll() called");
        return guardianService.getAll();
    }

    public List<GuardianResponseDTO> getActive() {
        log.info("[Facade:GuardianFacade] getActive() called");
        return guardianService.getActive();
    }

    public List<GuardianResponseDTO> getInactive() {
        log.info("[Facade:GuardianFacade] getInactive() called");
        return guardianService.getInactive();
    }

    public GuardianResponseDTO getById(Long id) {
        log.info("[Facade:GuardianFacade] getById() called - id: {}", id);
        return guardianService.getById(id);
    }

    public List<GuardianResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:GuardianFacade] searchByKeyword() called - keyword: {}", keyword);
        return guardianService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:GuardianFacade] softDeleteById() called - id: {}", id);
        guardianService.softDeleteById(id);
    }

    public GuardianResponseDTO createGuardian(GuardianCreateRequestDTO dto) {
        log.info("[Facade:GuardianFacade] createGuardian() called");
        return guardianService.createGuardian(dto);
    }

    public GuardianResponseDTO updateGuardian(Long id, GuardianCreateRequestDTO dto) {
        log.info("[Facade:GuardianFacade] updateGuardian() called - id: {}", id);
        return guardianService.updateGuardian(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:GuardianFacade] getStatistics() called");
        return guardianService.getStatistics();
    }

    public List<GuardianResponseDTO> getGuardiansByStudentId(Long studentId) {
        log.info("[Facade:GuardianFacade] getGuardiansByStudentId() called - studentId: {}", studentId);
        return guardianService.getGuardiansByStudentId(studentId);
    }
}
