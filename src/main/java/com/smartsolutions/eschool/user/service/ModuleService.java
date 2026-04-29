package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.ModuleErrors;
import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.mapper.ModuleMapper;
import com.smartsolutions.eschool.user.model.ModuleEntity;
import com.smartsolutions.eschool.user.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ModuleService {
    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<ModuleResponseDTO> getAll() {
        log.info("[Service:ModuleService] getAll() called - Fetching all modules");
        List<ModuleEntity> result = moduleRepository.findAllNotDeleted();
        List<ModuleResponseDTO> responseDTOs = ModuleMapper.toResponseDTOList(result);
        log.info("[Service:ModuleService] getAll() succeeded - Found {} modules", responseDTOs.size());
        return responseDTOs;
    }

    public List<ModuleResponseDTO> getAllActive() {
        log.info("[Service:ModuleService] getAllActive() called - Fetching active modules");
        List<ModuleEntity> result = moduleRepository.findAllActive();
        List<ModuleResponseDTO> responseDTOs = ModuleMapper.toResponseDTOList(result);
        log.info("[Service:ModuleService] getAllActive() succeeded - Found {} active modules", responseDTOs.size());
        return responseDTOs;
    }

    public ModuleResponseDTO getById(Long id) {
        log.info("[Service:ModuleService] getById() called - id: {}", id);
        ModuleEntity entity = moduleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(ModuleErrors.MODULE_NOT_FOUND, HttpStatus.NOT_FOUND));

        ModuleResponseDTO responseDTO = ModuleMapper.toResponseDTO(entity);
        log.info("[Service:ModuleService] getById() succeeded - Found module: {}", id);
        return responseDTO;
    }

    public List<ModuleResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:ModuleService] searchByKeyword() called - keyword: {}", keyword);
        List<ModuleEntity> result = moduleRepository.searchByKeyword(keyword);
        List<ModuleResponseDTO> responseDTOs = ModuleMapper.toResponseDTOList(result);
        log.info("[Service:ModuleService] searchByKeyword() succeeded - Found {} modules", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:ModuleService] softDeleteById() called - id: {}", id);

        int result = moduleRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(ModuleErrors.MODULE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:ModuleService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public ModuleResponseDTO create(ModuleRequestDTO requestDTO) {
        log.info("[Service:ModuleService] create() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (moduleRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(ModuleErrors.DUPLICATE_MODULE_CODE, "Module code already exists", HttpStatus.CONFLICT);
            }
        }

        ModuleEntity entity = ModuleMapper.toEntity(requestDTO);
        ModuleEntity saved = moduleRepository.save(entity);

        log.info("[Service:ModuleService] create() succeeded - Created with id: {}", saved.getId());
        return ModuleMapper.toResponseDTO(saved);
    }

    @Transactional
    public ModuleResponseDTO update(Long id, ModuleRequestDTO requestDTO) {
        log.info("[Service:ModuleService] update() called - id: {}", id);

        ModuleEntity existing = moduleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(ModuleErrors.MODULE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (moduleRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(ModuleErrors.DUPLICATE_MODULE_CODE, "Module code already exists", HttpStatus.CONFLICT);
            }
        }

        ModuleMapper.updateEntityFromDTO(existing, requestDTO);
        ModuleEntity updated = moduleRepository.save(existing);

        log.info("[Service:ModuleService] update() succeeded - id: {}", id);
        return ModuleMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:ModuleService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalModules", moduleRepository.countAllNotDeleted());
        stats.put("activeModules", moduleRepository.countByActiveTrue());
        stats.put("inactiveModules", moduleRepository.countByActiveFalse());

        log.info("[Service:ModuleService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
