package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class ModuleFacade {
    private final ModuleService moduleService;

    public ModuleFacade(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public List<ModuleResponseDTO> getAll() {
        log.info("[Facade:ModuleFacade] getAll() called");
        return moduleService.getAll();
    }

    public List<ModuleResponseDTO> getAllActive() {
        log.info("[Facade:ModuleFacade] getAllActive() called");
        return moduleService.getAllActive();
    }

    public ModuleResponseDTO getById(Long id) {
        log.info("[Facade:ModuleFacade] getById() called - id: {}", id);
        return moduleService.getById(id);
    }

    public List<ModuleResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:ModuleFacade] searchByKeyword() called - keyword: {}", keyword);
        return moduleService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:ModuleFacade] softDeleteById() called - id: {}", id);
        moduleService.softDeleteById(id);
    }

    public ModuleResponseDTO create(ModuleRequestDTO dto) {
        log.info("[Facade:ModuleFacade] create() called");
        return moduleService.create(dto);
    }

    public ModuleResponseDTO update(Long id, ModuleRequestDTO dto) {
        log.info("[Facade:ModuleFacade] update() called - id: {}", id);
        return moduleService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:ModuleFacade] getStatistics() called");
        return moduleService.getStatistics();
    }
}
