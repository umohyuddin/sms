package com.smartsolutions.eschool.user.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.ActionErrors;
import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.model.ActionEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ActionMapper {

    private ActionMapper() {
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

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<ActionResponseDTO> toResponseDTOList(List<ActionEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(ActionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static ActionEntity toEntity(ActionRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(ActionErrors.INVALID_ACTION_DATA, "Action name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(ActionErrors.INVALID_ACTION_DATA, "Action code is required", HttpStatus.BAD_REQUEST);
        }

        ActionEntity entity = new ActionEntity();
        
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(ActionEntity entity, ActionRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(ActionErrors.INVALID_ACTION_DATA, "Action name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(ActionErrors.INVALID_ACTION_DATA, "Action code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
