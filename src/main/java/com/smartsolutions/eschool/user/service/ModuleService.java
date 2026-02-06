package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.responseMappers.ModuleMapper;
import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.model.ModuleEntity;
import com.smartsolutions.eschool.user.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Transactional
    public ModuleResponseDTO createModule(ModuleRequestDTO requestDTO) {
        log.info("Creating new Module: {}", requestDTO.getName());
        try {
            ModuleEntity entity = ModuleMapper.toEntity(requestDTO);
            ModuleEntity saved = moduleRepository.save(entity);
            ModuleResponseDTO response = ModuleMapper.toResponseDTO(saved);
            log.info("Module created successfully with ID: {}", response.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Module", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Module", ex);
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public List<ModuleResponseDTO> getAll() {
        try {
            log.info("Fetching all active Modules");
            List<ModuleEntity> result = moduleRepository.findByActiveTrueAndDeletedFalseOrderByDisplayOrderAsc();
            List<ModuleResponseDTO> responseDTOS = ModuleMapper.toResponseDTOList(result);
            log.info("Successfully fetched {} Modules", responseDTOS.size());
            return responseDTOS;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Modules", e);
        }
        return Collections.emptyList();
    }

    @Transactional(readOnly = true)
    public ModuleResponseDTO getById(Long id) {
        log.info("Fetching Module with id: {}", id);
        ModuleEntity entity = moduleRepository.findById(id)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + id));
        return ModuleMapper.toResponseDTO(entity);
    }

    @Transactional
    public ModuleResponseDTO updateModule(Long id, ModuleRequestDTO requestDTO) {
        log.info("Updating Module with id {}", id);
        ModuleEntity existing = moduleRepository.findById(id)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + id));

        ModuleMapper.updateEntity(existing, requestDTO);

        ModuleEntity updated = moduleRepository.save(existing);
        return ModuleMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Delete request received for Module ID: {}", id);
        ModuleEntity entity = moduleRepository.findById(id)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + id));
        entity.setDeleted(true);
        moduleRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<ModuleResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Modules with keyword: {}", keyword);
        List<ModuleEntity> result = moduleRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return ModuleMapper.toResponseDTOList(result);
    }
}
