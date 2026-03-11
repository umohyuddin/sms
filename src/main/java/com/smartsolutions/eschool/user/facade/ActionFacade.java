package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class ActionFacade {
    private final ActionService actionService;

    public ActionFacade(ActionService actionService) {
        this.actionService = actionService;
    }

    public List<ActionResponseDTO> getAll() {
        log.info("[Facade:ActionFacade] getAll() called");
        return actionService.getAll();
    }

    public List<ActionResponseDTO> getAllActive() {
        log.info("[Facade:ActionFacade] getAllActive() called");
        return actionService.getAllActive();
    }

    public ActionResponseDTO getById(Long id) {
        log.info("[Facade:ActionFacade] getById() called - id: {}", id);
        return actionService.getById(id);
    }

    public List<ActionResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:ActionFacade] searchByKeyword() called - keyword: {}", keyword);
        return actionService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:ActionFacade] softDeleteById() called - id: {}", id);
        actionService.softDeleteById(id);
    }

    public ActionResponseDTO create(ActionRequestDTO dto) {
        log.info("[Facade:ActionFacade] create() called");
        return actionService.create(dto);
    }

    public ActionResponseDTO update(Long id, ActionRequestDTO dto) {
        log.info("[Facade:ActionFacade] update() called - id: {}", id);
        return actionService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:ActionFacade] getStatistics() called");
        return actionService.getStatistics();
    }
}
