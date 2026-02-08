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
        log.info("Creating new Action from database: {}", dto.getName());
        try {
            ActionEntity entity = ActionMapper.toEntity(dto);
            ActionEntity saved = actionRepository.save(entity);
            log.info("Successfully created Action with ID: {}", saved.getId());
            return ActionMapper.toResponseDTO(saved);
        } catch (Exception e) {
            log.error("Unexpected error while creating Action", e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ActionResponseDTO> getAllActions() {
        try {
            log.info("Fetching all active Actions from database");
            List<ActionEntity> actions = actionRepository.findAllNotDeleted();
            log.info("Successfully fetched {} active Actions", actions.size());
            return ActionMapper.toResponseDTOList(actions);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Actions", e);
            return java.util.Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public ActionResponseDTO getActionById(Long id) {
        log.info("Fetching Action with ID: {} from database", id);
        ActionEntity entity = actionRepository.findByIdNotDeleted(id)
                .orElseThrow(() -> {
                    log.warn("Action not found with ID: {}", id);
                    return new ResourceNotFoundException("Action not found with id: " + id);
                });
        log.info("Successfully fetched Action: id={}", entity.getId());
        return ActionMapper.toResponseDTO(entity);
    }

    @Transactional
    public ActionResponseDTO updateAction(Long id, ActionRequestDTO dto) {
        log.info("Updating Action with ID: {} in database", id);
        try {
            ActionEntity entity = actionRepository.findByIdNotDeleted(id)
                    .orElseThrow(() -> {
                        log.warn("Action not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Action not found with id: " + id);
                    });
            ActionMapper.updateEntityFromDTO(entity, dto);
            ActionEntity updated = actionRepository.save(entity);
            log.info("Successfully updated Action ID: {}", id);
            return ActionMapper.toResponseDTO(updated);
        } catch (Exception e) {
            log.error("Unexpected error while updating Action ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void deleteAction(Long id) {
        log.info("Soft delete request received for Action ID: {}", id);
        try {
            ActionEntity entity = actionRepository.findByIdNotDeleted(id)
                    .orElseThrow(() -> {
                        log.warn("Action not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("Action not found with id: " + id);
                    });
            entity.setDeleted(true);
            entity.setDeletedAt(LocalDateTime.now());
            actionRepository.save(entity);
            log.info("Action ID: {} marked as deleted successfully", id);
        } catch (Exception e) {
            log.error("Error while soft deleting Action with ID: {}", id, e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ActionResponseDTO> searchByKeyword(String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Actions based on search from database with keyword: '{}'", searchKey);
            List<ActionEntity> actions = actionRepository.searchByKeyword(searchKey);
            log.info("Successfully fetched {} Actions based on search", actions.size());
            return ActionMapper.toResponseDTOList(actions);
        } catch (Exception e) {
            log.error("Unexpected error while searching Actions", e);
            return java.util.Collections.emptyList();
        }
    }
}
