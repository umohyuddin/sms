package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.boardMemberRoles.request.BoardMemberRoleRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMemberRoles.response.BoardMemberRoleResponseDTO;
import com.smartsolutions.eschool.school.service.BoardMemberRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class BoardMemberRoleFacade {

    private final BoardMemberRoleService roleService;

    public BoardMemberRoleFacade(BoardMemberRoleService roleService) {
        this.roleService = roleService;
    }

    public List<BoardMemberRoleResponseDTO> getAll() {
        log.info("[Facade:BoardMemberRoleFacade] getAll() called");
        return roleService.getAll();
    }

    public BoardMemberRoleResponseDTO getById(Long id) {
        log.info("[Facade:BoardMemberRoleFacade] getById() called - id: {}", id);
        return roleService.getById(id);
    }

    public BoardMemberRoleResponseDTO create(BoardMemberRoleRequestDTO dto) {
        log.info("[Facade:BoardMemberRoleFacade] create() called");
        return roleService.create(dto);
    }

    public BoardMemberRoleResponseDTO update(Long id, BoardMemberRoleRequestDTO dto) {
        log.info("[Facade:BoardMemberRoleFacade] update() called - id: {}", id);
        return roleService.update(id, dto);
    }

    public void delete(Long id) {
        log.info("[Facade:BoardMemberRoleFacade] delete() called - id: {}", id);
        roleService.delete(id);
    }

    public List<BoardMemberRoleResponseDTO> search(String keyword) {
        log.info("[Facade:BoardMemberRoleFacade] search() called - keyword: {}", keyword);
        return roleService.search(keyword);
    }
}
