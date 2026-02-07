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

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;

    @Transactional
    public ActionResponseDTO createAction(ActionRequestDTO dto) {
        log.info("Creating new Action: {}", dto.getName());
        ActionEntity entity = ActionMapper.toEntity(dto);
        ActionEntity saved = actionRepository.save(entity);
        return ActionMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<ActionResponseDTO> getAllActions() {
        log.info("Fetching all Actions");
        List<ActionEntity> actions = actionRepository.findAll();
        return ActionMapper.toResponseDTOList(actions);
    }

    @Transactional(readOnly = true)
    public ActionResponseDTO getActionById(Long id) {
        log.info("Fetching Action by id: {}", id);
        ActionEntity entity = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Action not found with id: " + id));
        return ActionMapper.toResponseDTO(entity);
    }

    @Transactional
    public ActionResponseDTO updateAction(Long id, ActionRequestDTO dto) {
        log.info("Updating Action with id: {}", id);
        ActionEntity entity = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Action not found with id: " + id));
        ActionMapper.updateEntityFromDTO(entity, dto);
        ActionEntity updated = actionRepository.save(entity);
        return ActionMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteAction(Long id) {
        log.info("Deleting Action with id: {}", id);
        ActionEntity entity = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Action not found with id: " + id));
        entity.setDeleted(true);
        actionRepository.save(entity);
    }
}
