package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ActionFacade {

    private final ActionService actionService;

    public ActionResponseDTO createAction(ActionRequestDTO dto) {
        return actionService.createAction(dto);
    }

    public List<ActionResponseDTO> getAllActions() {
        return actionService.getAllActions();
    }

    public ActionResponseDTO getActionById(Long id) {
        return actionService.getActionById(id);
    }

    public ActionResponseDTO updateAction(Long id, ActionRequestDTO dto) {
        return actionService.updateAction(id, dto);
    }

    public void deleteAction(Long id) {
        actionService.deleteAction(id);
    }
}
