package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class ModuleFacade {

    private final ModuleService moduleService;

    public ModuleResponseDTO createModule(ModuleRequestDTO requestDTO) {
        log.info("Facade: Request to create Module: {}", requestDTO.getName());
        ModuleResponseDTO result = moduleService.createModule(requestDTO);
        log.info("Facade: Module created successfully with ID: {}", result.getId());
        return result;
    }

    public List<ModuleResponseDTO> getAll() {
        log.info("Facade: Request to fetch all Modules");
        List<ModuleResponseDTO> result = moduleService.getAll();
        log.info("Facade: Successfully fetched {} Modules", result.size());
        return result;
    }

    public ModuleResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch Module ID: {}", id);
        ModuleResponseDTO result = moduleService.getById(id);
        log.info("Facade: Successfully fetched Module ID: {}", id);
        return result;
    }

    public ModuleResponseDTO updateModule(Long id, ModuleRequestDTO requestDTO) {
        log.info("Facade: Request to update Module ID: {}", id);
        ModuleResponseDTO result = moduleService.updateModule(id, requestDTO);
        log.info("Facade: Successfully updated Module ID: {}", id);
        return result;
    }

    public void deleteById(Long id) {
        log.info("Facade: Request to delete Module ID: {}", id);
        moduleService.deleteById(id);
        log.info("Facade: Successfully deleted Module ID: {}", id);
    }

    public List<ModuleResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Modules with keyword: '{}'", keyword);
        List<ModuleResponseDTO> result = moduleService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Modules", result.size());
        return result;
    }
}
