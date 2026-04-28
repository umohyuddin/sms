package com.smartsolutions.eschool.sclass.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.error.StandardErrors;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.school.mapper.CampusMapper;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for StandardEntity to DTOs and vice versa.
 */
public class StandardMapper {

    private StandardMapper() {
        // prevent instantiation
    }

    public static StandardDTO toResponseDTO(StandardEntity entity) {
        if (entity == null) {
            return null;
        }

        StandardDTO dto = new StandardDTO();
        dto.setId(entity.getId());
        dto.setStandardName(entity.getStandardName());
        dto.setStandardCode(entity.getStandardCode());
        dto.setDescription(entity.getDescription());

        if (entity.getCampus() != null) {
            dto.setCampusId(entity.getCampus().getId());
            dto.setCampus(CampusMapper.toResponseDTO(entity.getCampus()));
        }

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDeleted(entity.isDeleted());

        return dto;
    }

    public static List<StandardDTO> toResponseDTOList(List<StandardEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(StandardMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static StandardEntity toEntity(StandardCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getStandardName() == null || dto.getStandardName().trim().isEmpty()) {
            throw new ApiException(StandardErrors.INVALID_STANDARD_DATA, "Standard name is required",
                    HttpStatus.BAD_REQUEST);
        }

        StandardEntity entity = new StandardEntity();
        entity.setStandardName(dto.getStandardName().trim());
        entity.setStandardCode(dto.getStandardCode() != null ? dto.getStandardCode().trim() : null);
        entity.setDescription(dto.getDescription());
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(StandardEntity entity, StandardCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getStandardName() != null) {
            if (dto.getStandardName().trim().isEmpty()) {
                throw new ApiException(StandardErrors.INVALID_STANDARD_DATA, "Standard name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setStandardName(dto.getStandardName().trim());
        }

        if (dto.getStandardCode() != null) {
            entity.setStandardCode(dto.getStandardCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        // Campus entity should be updated by the service
    }
}
