package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@lombok.extern.slf4j.Slf4j
public class ActionFacade {

    private final ActionService actionService;

    public ActionResponseDTO createAction(ActionRequestDTO dto) {
        log.info("[ACTION_FACADE] Request to create Action: {}", dto.getName());
        return actionService.createAction(dto);
    }

    public List<ActionResponseDTO> getAllActions() {
        log.info("[ACTION_FACADE] Request to fetch all Actions");
        return actionService.getAllActions();
    }

    public ActionResponseDTO getActionById(Long id) {
        log.info("[ACTION_FACADE] Request to fetch Action ID: {}", id);
        return actionService.getActionById(id);
    }

    public ActionResponseDTO updateAction(Long id, ActionRequestDTO dto) {
        log.info("[ACTION_FACADE] Request to update Action ID: {}", id);
        return actionService.updateAction(id, dto);
    }

    public void deleteAction(Long id) {
        log.info("[ACTION_FACADE] Request to delete Action ID: {}", id);
        actionService.deleteAction(id);
    }

    public List<ActionResponseDTO> searchActions(String keyword) {
        log.info("[ACTION_FACADE] Request to search Actions with keyword: '{}'", keyword);
        return actionService.searchByKeyword(keyword);
    }
}
