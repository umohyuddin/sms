package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.ActionErrors;
import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.mapper.ActionMapper;
import com.smartsolutions.eschool.user.model.ActionEntity;
import com.smartsolutions.eschool.user.repository.ActionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ActionService {
    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<ActionResponseDTO> getAll() {
        log.info("[Service:ActionService] getAll() called - Fetching all actions");
        List<ActionEntity> result = actionRepository.findAllNotDeleted();
        List<ActionResponseDTO> responseDTOs = ActionMapper.toResponseDTOList(result);
        log.info("[Service:ActionService] getAll() succeeded - Found {} actions", responseDTOs.size());
        return responseDTOs;
    }

    public List<ActionResponseDTO> getAllActive() {
        log.info("[Service:ActionService] getAllActive() called - Fetching active actions");
        List<ActionEntity> result = actionRepository.findAllActive();
        List<ActionResponseDTO> responseDTOs = ActionMapper.toResponseDTOList(result);
        log.info("[Service:ActionService] getAllActive() succeeded - Found {} active actions", responseDTOs.size());
        return responseDTOs;
    }

    public ActionResponseDTO getById(Long id) {
        log.info("[Service:ActionService] getById() called - id: {}", id);
        ActionEntity entity = actionRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(ActionErrors.ACTION_NOT_FOUND, HttpStatus.NOT_FOUND));

        ActionResponseDTO responseDTO = ActionMapper.toResponseDTO(entity);
        log.info("[Service:ActionService] getById() succeeded - Found action: {}", id);
        return responseDTO;
    }

    public List<ActionResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:ActionService] searchByKeyword() called - keyword: {}", keyword);
        List<ActionEntity> result = actionRepository.searchByKeyword(keyword);
        List<ActionResponseDTO> responseDTOs = ActionMapper.toResponseDTOList(result);
        log.info("[Service:ActionService] searchByKeyword() succeeded - Found {} actions", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:ActionService] softDeleteById() called - id: {}", id);

        int result = actionRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(ActionErrors.ACTION_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:ActionService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public ActionResponseDTO create(ActionRequestDTO requestDTO) {
        log.info("[Service:ActionService] create() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (actionRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(ActionErrors.DUPLICATE_ACTION_CODE, "Action code already exists", HttpStatus.CONFLICT);
            }
        }

        ActionEntity entity = ActionMapper.toEntity(requestDTO);
        ActionEntity saved = actionRepository.save(entity);

        log.info("[Service:ActionService] create() succeeded - Created with id: {}", saved.getId());
        return ActionMapper.toResponseDTO(saved);
    }

    @Transactional
    public ActionResponseDTO update(Long id, ActionRequestDTO requestDTO) {
        log.info("[Service:ActionService] update() called - id: {}", id);

        ActionEntity existing = actionRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(ActionErrors.ACTION_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (actionRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(ActionErrors.DUPLICATE_ACTION_CODE, "Action code already exists", HttpStatus.CONFLICT);
            }
        }

        ActionMapper.updateEntityFromDTO(existing, requestDTO);
        ActionEntity updated = actionRepository.save(existing);

        log.info("[Service:ActionService] update() succeeded - id: {}", id);
        return ActionMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:ActionService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalActions", actionRepository.countAllNotDeleted());
        stats.put("activeActions", actionRepository.countByActiveTrue());
        stats.put("inactiveActions", actionRepository.countByActiveFalse());

        log.info("[Service:ActionService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
