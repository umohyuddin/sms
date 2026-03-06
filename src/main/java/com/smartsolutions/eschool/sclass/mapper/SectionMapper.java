package com.smartsolutions.eschool.sclass.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.error.SectionErrors;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for SectionEntity to DTOs and vice versa.
 */
public class SectionMapper {

    private SectionMapper() {
        // prevent instantiation
    }

    public static SectionDTO toResponseDTO(SectionEntity entity) {
        if (entity == null) {
            return null;
        }

        SectionDTO dto = new SectionDTO();
        dto.setId(entity.getId());
        dto.setSectionName(entity.getSectionName());
        dto.setSectionCode(entity.getSectionCode());

        if (entity.getStandard() != null) {
            dto.setStandard(StandardMapper.toResponseDTO(entity.getStandard()));
        }

        // Audit fields
        // SectionDTO currently doesn't map CreatedAt/UpdatedAt directly, but maps
        // deleted.
        dto.setDeleted(entity.isDeleted());
        dto.setDeletedAt(entity.getDeletedAt());

        return dto;
    }

    public static List<SectionDTO> toResponseDTOList(List<SectionEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(SectionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static SectionEntity toEntity(SectionCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getSectionName() == null || dto.getSectionName().trim().isEmpty()) {
            throw new ApiException(SectionErrors.INVALID_SECTION_DATA, "Section name is required",
                    HttpStatus.BAD_REQUEST);
        }
        if (dto.getStandardId() == null) {
            throw new ApiException(SectionErrors.INVALID_SECTION_DATA, "Standard ID is required",
                    HttpStatus.BAD_REQUEST);
        }

        SectionEntity entity = new SectionEntity();
        entity.setSectionName(dto.getSectionName().trim());
        entity.setSectionCode(dto.getSectionCode() != null ? dto.getSectionCode().trim() : null);

        // Standard entity should be set by the service using standardId

        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(SectionEntity entity, SectionCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getSectionName() != null) {
            if (dto.getSectionName().trim().isEmpty()) {
                throw new ApiException(SectionErrors.INVALID_SECTION_DATA, "Section name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setSectionName(dto.getSectionName().trim());
        }

        if (dto.getSectionCode() != null) {
            entity.setSectionCode(dto.getSectionCode().trim());
        }

        // Standard entity should be updated by the service if standardId changes
    }
}
