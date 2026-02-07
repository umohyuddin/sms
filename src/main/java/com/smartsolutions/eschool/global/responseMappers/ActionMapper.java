package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.model.ActionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ActionMapper {

    private ActionMapper() {
        // prevent instantiation
    }

    public static ActionEntity toEntity(ActionRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        ActionEntity entity = new ActionEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
        return entity;
    }

    public static ActionResponseDTO toResponseDTO(ActionEntity entity) {
        if (entity == null) {
            return null;
        }

        ActionResponseDTO dto = new ActionResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setDeleted(entity.getDeleted());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    public static List<ActionResponseDTO> toResponseDTOList(List<ActionEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(ActionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntityFromDTO(ActionEntity entity, ActionRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCode() != null && !dto.getCode().isBlank()) {
            entity.setCode(dto.getCode());
        }
        if (dto.getName() != null && !dto.getName().isBlank()) {
            entity.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
