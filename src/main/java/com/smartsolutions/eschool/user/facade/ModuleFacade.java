package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.service.ModuleService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ModuleFacade {

    private final ModuleService moduleService;

    public ModuleFacade(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public ModuleResponseDTO createModule(ModuleRequestDTO requestDTO) {
        return moduleService.createModule(requestDTO);
    }

    public List<ModuleResponseDTO> getAll() {
        return moduleService.getAll();
    }

    public ModuleResponseDTO getById(Long id) {
        return moduleService.getById(id);
    }

    public ModuleResponseDTO updateModule(Long id, ModuleRequestDTO requestDTO) {
        return moduleService.updateModule(id, requestDTO);
    }

    public void deleteById(Long id) {
        moduleService.deleteById(id);
    }

    public List<ModuleResponseDTO> searchByKeyword(String keyword) {
        return moduleService.searchByKeyword(keyword);
    }
}
