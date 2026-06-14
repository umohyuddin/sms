package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.BoardMemberRoleErrors;
import com.smartsolutions.eschool.school.dtos.boardMemberRoles.request.BoardMemberRoleRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMemberRoles.response.BoardMemberRoleResponseDTO;
import com.smartsolutions.eschool.school.mapper.BoardMemberRoleMapper;
import com.smartsolutions.eschool.school.model.BoardMemberRoleEntity;
import com.smartsolutions.eschool.school.repository.BoardMemberRoleRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BoardMemberRoleService {

    private final BoardMemberRoleRepository roleRepository;
    private final com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public BoardMemberRoleService(BoardMemberRoleRepository roleRepository, com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator) {
        this.entityReferenceValidator = entityReferenceValidator;
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public List<BoardMemberRoleResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(BoardMemberRoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:BoardMemberRoleService] getAll() called - Organization: {}", organizationId);
        List<BoardMemberRoleEntity> result = roleRepository.findByOrganizationId(organizationId);
        return BoardMemberRoleMapper.toResponseDTOList(result);
    }

    @Transactional(readOnly = true)
    public BoardMemberRoleResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(BoardMemberRoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:BoardMemberRoleService] getById() called - id: {}, Organization: {}", id, organizationId);
        BoardMemberRoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(BoardMemberRoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));
        return BoardMemberRoleMapper.toResponseDTO(entity);
    }

    @Transactional
    public BoardMemberRoleResponseDTO create(BoardMemberRoleRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(BoardMemberRoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:BoardMemberRoleService] create() called - Organization: {}", organizationId);

        if (roleRepository.existsByCodeAndOrganizationIdAndDeletedFalse(requestDTO.getCode(), organizationId)) {
            throw new ApiException(BoardMemberRoleErrors.DUPLICATE_ROLE_CODE, HttpStatus.CONFLICT);
        }

        BoardMemberRoleEntity entity = BoardMemberRoleMapper.toEntity(requestDTO);
        // Note: organizationId is automatically set by AuditableEntity.prePersist()
        BoardMemberRoleEntity saved = roleRepository.save(entity);

        log.info("[Service:BoardMemberRoleService] create() succeeded - Role created with id: {}", saved.getId());
        return BoardMemberRoleMapper.toResponseDTO(saved);
    }

    @Transactional
    public BoardMemberRoleResponseDTO update(Long id, BoardMemberRoleRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(BoardMemberRoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:BoardMemberRoleService] update() called - id: {}, Organization: {}", id, organizationId);

        BoardMemberRoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(BoardMemberRoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!existing.getCode().equalsIgnoreCase(requestDTO.getCode())) {
            if (roleRepository.existsByCodeAndOrganizationIdAndDeletedFalse(requestDTO.getCode(), organizationId)) {
                throw new ApiException(BoardMemberRoleErrors.DUPLICATE_ROLE_CODE, HttpStatus.CONFLICT);
            }
        }

        BoardMemberRoleMapper.updateEntity(existing, requestDTO);
        BoardMemberRoleEntity updated = roleRepository.save(existing);

        log.info("[Service:BoardMemberRoleService] update() succeeded - id: {}", id);
        return BoardMemberRoleMapper.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(BoardMemberRoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:BoardMemberRoleService] delete() called - id: {}, Organization: {}", id, organizationId);

        BoardMemberRoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(BoardMemberRoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));

        entity.setDeleted(true);
        roleRepository.save(entity);
        log.info("[Service:BoardMemberRoleService] delete() succeeded - id: {}", id);
    }

    @Transactional(readOnly = true)
    public List<BoardMemberRoleResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(BoardMemberRoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:BoardMemberRoleService] search() called - keyword: {}, Organization: {}", keyword, organizationId);
        List<BoardMemberRoleEntity> result = roleRepository.searchByKeyword(organizationId, keyword);
        return BoardMemberRoleMapper.toResponseDTOList(result);
    }
}
