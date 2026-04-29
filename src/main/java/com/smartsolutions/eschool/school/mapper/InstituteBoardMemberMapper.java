package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.boardMembers.request.InstituteBoardMemberRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMembers.response.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.model.BoardMemberRoleEntity;
import com.smartsolutions.eschool.school.model.InstituteBoardMemberEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InstituteBoardMemberMapper {

    public static InstituteBoardMemberEntity toEntity(InstituteBoardMemberRequestDTO dto, BoardMemberRoleEntity role) {
        if (dto == null) return null;

        return InstituteBoardMemberEntity.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .role(role)
                .email(dto.getEmail())
                .contactNumber(dto.getContactNumber())
                .termStart(dto.getTermStart())
                .termEnd(dto.getTermEnd())
                .active(dto.isActive())
                .build();
    }

    public static InstituteBoardMemberResponseDTO toResponseDTO(InstituteBoardMemberEntity entity) {
        if (entity == null) return null;

        return InstituteBoardMemberResponseDTO.builder()
                .id(entity.getId())
                .organizationId(entity.getOrganizationId())
                .organizationName(null) // AuditableEntity only has organizationId (Long), no Organization relationship
                .fullName(entity.getFullName())
                .roleId(entity.getRole() != null ? entity.getRole().getId() : null)
                .roleName(entity.getRole() != null ? entity.getRole().getName() : null)
                .email(entity.getEmail())
                .contactNumber(entity.getContactNumber())
                .termStart(entity.getTermStart())
                .termEnd(entity.getTermEnd())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<InstituteBoardMemberResponseDTO> toResponseDTOList(List<InstituteBoardMemberEntity> entities) {
        if (entities == null) return Collections.emptyList();
        return entities.stream()
                .map(InstituteBoardMemberMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntity(InstituteBoardMemberEntity entity, InstituteBoardMemberRequestDTO dto, BoardMemberRoleEntity role) {
        if (entity == null || dto == null) return;
        entity.setFullName(dto.getFullName());
        entity.setRole(role);
        entity.setEmail(dto.getEmail());
        entity.setContactNumber(dto.getContactNumber());
        entity.setTermStart(dto.getTermStart());
        entity.setTermEnd(dto.getTermEnd());
        entity.setActive(dto.isActive());
    }
}
