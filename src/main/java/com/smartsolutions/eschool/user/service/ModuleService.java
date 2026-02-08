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
        log.info("Creating new Module in database: {}", requestDTO.getName());
        try {
            ModuleEntity entity = ModuleMapper.toEntity(requestDTO);
            ModuleEntity saved = moduleRepository.save(entity);
            log.info("Successfully created Module with ID: {}", saved.getId());
            return ModuleMapper.toResponseDTO(saved);
        } catch (Exception e) {
            log.error("Unexpected error while creating Module", e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ModuleResponseDTO> getAll() {
        log.info("Fetching all active Modules from database");
        try {
            List<ModuleEntity> result = moduleRepository.findByActiveTrueAndDeletedFalseOrderByDisplayOrderAsc();
            log.info("Successfully fetched {} active Modules", result.size());
            return ModuleMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Modules", e);
            return Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public ModuleResponseDTO getById(Long id) {
        log.info("Fetching Module with ID: {} from database", id);
        try {
            ModuleEntity entity = moduleRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Module not found with ID: {}", id);
                        return new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + id);
                    });
            log.info("Successfully fetched Module: id={}", entity.getId());
            return ModuleMapper.toResponseDTO(entity);
        } catch (com.smartsolutions.eschool.global.exception.ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Module ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public ModuleResponseDTO updateModule(Long id, ModuleRequestDTO requestDTO) {
        log.info("Updating Module with ID: {} in database", id);
        try {
            ModuleEntity existing = moduleRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Module not found for update with ID: {}", id);
                        return new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + id);
                    });

            ModuleMapper.updateEntityFromDTO(existing, requestDTO);
            ModuleEntity updated = moduleRepository.save(existing);
            log.info("Successfully updated Module ID: {}", id);
            return ModuleMapper.toResponseDTO(updated);
        } catch (Exception e) {
            log.error("Unexpected error while updating Module ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Soft delete request received for Module ID: {}", id);
        try {
            ModuleEntity entity = moduleRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Module not found for deletion with ID: {}", id);
                        return new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + id);
                    });
            entity.setDeleted(true);
            moduleRepository.save(entity);
            log.info("Module ID: {} marked as deleted successfully", id);
        } catch (Exception e) {
            log.error("Error while soft deleting Module with ID: {}", id, e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ModuleResponseDTO> searchByKeyword(String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Modules based on search from database with keyword: '{}'", searchKey);
            List<ModuleEntity> result = moduleRepository.searchByKeyword(searchKey);
            log.info("Successfully fetched {} Modules based on search", result.size());
            return ModuleMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while searching Modules", e);
            return Collections.emptyList();
        }
    }
}
