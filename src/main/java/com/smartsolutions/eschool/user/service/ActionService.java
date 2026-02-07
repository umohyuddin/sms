package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.ActionMapper;
import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.model.ActionEntity;
import com.smartsolutions.eschool.user.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;

    @Transactional
    public ActionResponseDTO createAction(ActionRequestDTO dto) {
        log.info("[ACTION_SERVICE] Creating new Action - Name: {}, Code: {}", dto.getName(), dto.getCode());
        try {
            ActionEntity entity = ActionMapper.toEntity(dto);
            ActionEntity saved = actionRepository.save(entity);
            log.info("[ACTION_SERVICE] Action created successfully with ID: {}", saved.getId());
            return ActionMapper.toResponseDTO(saved);
        } catch (Exception e) {
            log.error("[ACTION_SERVICE] Error creating Action: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ActionResponseDTO> getAllActions() {
        log.info("[ACTION_SERVICE] Fetching all active Actions");
        List<ActionEntity> actions = actionRepository.findAllNotDeleted();
        log.info("[ACTION_SERVICE] Found {} active Actions", actions.size());
        return ActionMapper.toResponseDTOList(actions);
    }

    @Transactional(readOnly = true)
    public ActionResponseDTO getActionById(Long id) {
        log.info("[ACTION_SERVICE] Fetching Action by ID: {}", id);
        ActionEntity entity = actionRepository.findByIdNotDeleted(id)
                .orElseThrow(() -> {
                    log.warn("[ACTION_SERVICE] Action not found with ID: {}", id);
                    return new ResourceNotFoundException("Action not found with id: " + id);
                });
        return ActionMapper.toResponseDTO(entity);
    }

    @Transactional
    public ActionResponseDTO updateAction(Long id, ActionRequestDTO dto) {
        log.info("[ACTION_SERVICE] Updating Action ID: {} - New Name: {}", id, dto.getName());
        try {
            ActionEntity entity = actionRepository.findByIdNotDeleted(id)
                    .orElseThrow(() -> {
                        log.warn("[ACTION_SERVICE] Action not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Action not found with id: " + id);
                    });
            ActionMapper.updateEntityFromDTO(entity, dto);
            ActionEntity updated = actionRepository.save(entity);
            log.info("[ACTION_SERVICE] Action ID: {} updated successfully", id);
            return ActionMapper.toResponseDTO(updated);
        } catch (Exception e) {
            log.error("[ACTION_SERVICE] Error updating Action ID: {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    public void deleteAction(Long id) {
        log.info("[ACTION_SERVICE] Masking Action as deleted with ID: {}", id);
        ActionEntity entity = actionRepository.findByIdNotDeleted(id)
                .orElseThrow(() -> {
                    log.warn("[ACTION_SERVICE] Action not found for deletion with ID: {}", id);
                    return new ResourceNotFoundException("Action not found with id: " + id);
                });
        entity.setDeleted(true);
        entity.setDeletedAt(LocalDateTime.now());
        actionRepository.save(entity);
        log.info("[ACTION_SERVICE] Action ID: {} marked as deleted", id);
    }

    @Transactional(readOnly = true)
    public List<ActionResponseDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[ACTION_SERVICE] Searching Actions with keyword: '{}'", searchKey);
        List<ActionEntity> actions = actionRepository.searchByKeyword(searchKey);
        log.info("[ACTION_SERVICE] Search completed: {} Actions found for keyword: '{}'", actions.size(), searchKey);
        return ActionMapper.toResponseDTOList(actions);
    }
}
