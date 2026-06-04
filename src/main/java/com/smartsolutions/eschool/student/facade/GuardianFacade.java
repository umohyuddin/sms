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
        List<GuardianResponseDTO> response = guardianService.getAll();
        log.info("[Facade:GuardianFacade] getAll() succeeded - Found {} guardians", response.size());
        return response;
    }

    public List<GuardianResponseDTO> getActive() {
        log.info("[Facade:GuardianFacade] getActive() called");
        List<GuardianResponseDTO> response = guardianService.getActive();
        log.info("[Facade:GuardianFacade] getActive() succeeded - Found {} active guardians", response.size());
        return response;
    }

    public List<GuardianResponseDTO> getInactive() {
        log.info("[Facade:GuardianFacade] getInactive() called");
        List<GuardianResponseDTO> response = guardianService.getInactive();
        log.info("[Facade:GuardianFacade] getInactive() succeeded - Found {} inactive guardians", response.size());
        return response;
    }

    public GuardianResponseDTO getById(Long id) {
        log.info("[Facade:GuardianFacade] getById() called - id: {}", id);
        GuardianResponseDTO response = guardianService.getById(id);
        log.info("[Facade:GuardianFacade] getById() succeeded - Found guardian with id: {}", id);
        return response;
    }

    public List<GuardianResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:GuardianFacade] searchByKeyword() called - keyword: {}", keyword);
        List<GuardianResponseDTO> response = guardianService.searchByKeyword(keyword);
        log.info("[Facade:GuardianFacade] searchByKeyword() succeeded - Found {} matches", response.size());
        return response;
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:GuardianFacade] softDeleteById() called - id: {}", id);
        guardianService.softDeleteById(id);
        log.info("[Facade:GuardianFacade] softDeleteById() succeeded - id: {}", id);
    }

    public GuardianResponseDTO createGuardian(GuardianCreateRequestDTO dto) {
        log.info("[Facade:GuardianFacade] createGuardian() called - guardian: {}", dto.getFullName());
        GuardianResponseDTO response = guardianService.createGuardian(dto);
        log.info("[Facade:GuardianFacade] createGuardian() succeeded - Created guardian with id: {}", response.getId());
        return response;
    }

    public GuardianResponseDTO updateGuardian(Long id, GuardianCreateRequestDTO dto) {
        log.info("[Facade:GuardianFacade] updateGuardian() called - id: {}", id);
        GuardianResponseDTO response = guardianService.updateGuardian(id, dto);
        log.info("[Facade:GuardianFacade] updateGuardian() succeeded - Updated guardian with id: {}", id);
        return response;
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:GuardianFacade] getStatistics() called");
        Map<String, Long> response = guardianService.getStatistics();
        log.info("[Facade:GuardianFacade] getStatistics() succeeded");
        return response;
    }

    public List<GuardianResponseDTO> getGuardiansByStudentId(Long studentId) {
        log.info("[Facade:GuardianFacade] getGuardiansByStudentId() called - studentId: {}", studentId);
        List<GuardianResponseDTO> response = guardianService.getGuardiansByStudentId(studentId);
        log.info("[Facade:GuardianFacade] getGuardiansByStudentId() succeeded - Found {} guardians", response.size());
        return response;
    }
}
