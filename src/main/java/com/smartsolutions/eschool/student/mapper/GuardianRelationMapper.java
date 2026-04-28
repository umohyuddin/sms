package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.student.error.GuardianRelationErrors;
import com.smartsolutions.eschool.student.dtos.guardianRelation.requestDto.GuardianRelationCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.guardianRelation.responseDto.GuardianRelationResponseDTO;
import com.smartsolutions.eschool.student.model.GuardianRelationEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GuardianRelationMapper {

    private GuardianRelationMapper() {
        // prevent instantiation
    }

    public static GuardianRelationResponseDTO toResponseDTO(GuardianRelationEntity entity) {
        if (entity == null) {
            return null;
        }

        GuardianRelationResponseDTO dto = new GuardianRelationResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());
        dto.setIsDefault(entity.getIsDefault());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.isDeleted());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<GuardianRelationResponseDTO> toResponseDTOList(List<GuardianRelationEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(GuardianRelationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static GuardianRelationEntity toEntity(GuardianRelationCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(GuardianRelationErrors.INVALID_GUARDIAN_RELATION_DATA, "Guardian relation name is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(GuardianRelationErrors.INVALID_GUARDIAN_RELATION_DATA, "Guardian relation code is required", HttpStatus.BAD_REQUEST);
        }
        
        if (dto.getStatus() != null && !(dto.getStatus().equals("ACTIVE") || dto.getStatus().equals("INACTIVE"))) {
            throw new ApiException(GuardianRelationErrors.INVALID_GUARDIAN_RELATION_DATA, "Status must be ACTIVE or INACTIVE", HttpStatus.BAD_REQUEST);
        }

        GuardianRelationEntity entity = new GuardianRelationEntity();
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setIsDefault(dto.getIsDefault() != null ? dto.getIsDefault() : false);
        entity.setStatus(dto.getStatus() != null ? dto.getStatus() : "ACTIVE");
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(GuardianRelationEntity entity, GuardianRelationCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(GuardianRelationErrors.INVALID_GUARDIAN_RELATION_DATA, "Guardian relation name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(GuardianRelationErrors.INVALID_GUARDIAN_RELATION_DATA, "Guardian relation code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }

        if (dto.getIsDefault() != null) {
            entity.setIsDefault(dto.getIsDefault());
        }
        
        if (dto.getStatus() != null) {
             if (!(dto.getStatus().equals("ACTIVE") || dto.getStatus().equals("INACTIVE"))) {
                throw new ApiException(GuardianRelationErrors.INVALID_GUARDIAN_RELATION_DATA, "Status must be ACTIVE or INACTIVE", HttpStatus.BAD_REQUEST);
             }
             entity.setStatus(dto.getStatus());
        }
    }
}
