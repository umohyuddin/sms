package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.service.ActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActionFacade {

    private final ActionService actionService;

    public ActionResponseDTO createAction(ActionRequestDTO dto) {
        log.info("Facade: Request to create Action: {}", dto.getName());
        ActionResponseDTO result = actionService.createAction(dto);
        log.info("Facade: Action created successfully with ID: {}", result.getId());
        return result;
    }

    public List<ActionResponseDTO> getAllActions() {
        log.info("Facade: Request to fetch all Actions");
        List<ActionResponseDTO> result = actionService.getAllActions();
        log.info("Facade: Successfully fetched {} Actions", result.size());
        return result;
    }

    public ActionResponseDTO getActionById(Long id) {
        log.info("Facade: Request to fetch Action ID: {}", id);
        ActionResponseDTO result = actionService.getActionById(id);
        log.info("Facade: Successfully fetched Action ID: {}", id);
        return result;
    }

    public ActionResponseDTO updateAction(Long id, ActionRequestDTO dto) {
        log.info("Facade: Request to update Action ID: {}", id);
        ActionResponseDTO result = actionService.updateAction(id, dto);
        log.info("Facade: Successfully updated Action ID: {}", id);
        return result;
    }

    public void deleteAction(Long id) {
        log.info("Facade: Request to delete Action ID: {}", id);
        actionService.deleteAction(id);
        log.info("Facade: Successfully deleted Action ID: {}", id);
    }

    public List<ActionResponseDTO> searchActions(String keyword) {
        log.info("Facade: Request to search Actions with keyword: '{}'", keyword);
        List<ActionResponseDTO> result = actionService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Actions", result.size());
        return result;
    }
}
