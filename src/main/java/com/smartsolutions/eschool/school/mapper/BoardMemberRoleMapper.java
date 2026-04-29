package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.boardMemberRoles.request.BoardMemberRoleRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMemberRoles.response.BoardMemberRoleResponseDTO;
import com.smartsolutions.eschool.school.model.BoardMemberRoleEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoardMemberRoleMapper {

    public static BoardMemberRoleEntity toEntity(BoardMemberRoleRequestDTO dto) {
        if (dto == null) return null;
        
        BoardMemberRoleEntity entity = BoardMemberRoleEntity.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .name(dto.getName())
                .active(dto.isActive())
                .build();
        
        return entity;
    }

    public static BoardMemberRoleResponseDTO toResponseDTO(BoardMemberRoleEntity entity) {
        if (entity == null) return null;

        return BoardMemberRoleResponseDTO.builder()
                .id(entity.getId())
                .organizationId(entity.getOrganizationId())
                .organizationName(entity.getOrganization() != null ? entity.getOrganization().getName() : null)
                .code(entity.getCode())
                .name(entity.getName())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<BoardMemberRoleResponseDTO> toResponseDTOList(List<BoardMemberRoleEntity> entities) {
        if (entities == null) return Collections.emptyList();
        return entities.stream()
                .map(BoardMemberRoleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntity(BoardMemberRoleEntity entity, BoardMemberRoleRequestDTO dto) {
        if (entity == null || dto == null) return;
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setActive(dto.isActive());
    }
}
