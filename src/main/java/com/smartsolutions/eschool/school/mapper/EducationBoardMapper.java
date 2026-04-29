package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.EducationBoardErrors;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.model.EducationBoardEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for EducationBoardEntity to DTOs and vice versa.
 */
public class EducationBoardMapper {

    private EducationBoardMapper() {
        // prevent instantiation
    }

    public static EducationBoardResponseDTO toResponseDTO(EducationBoardEntity entity) {
        if (entity == null) {
            return null;
        }

        EducationBoardResponseDTO dto = new EducationBoardResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setCountryCode(entity.getCountryCode());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<EducationBoardResponseDTO> toResponseDTOList(List<EducationBoardEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(EducationBoardMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static EducationBoardEntity toEntity(EducationBoardRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(EducationBoardErrors.INVALID_EDUCATION_BOARD_DATA,
                    "Education board name is required", HttpStatus.BAD_REQUEST);
        }

        EducationBoardEntity entity = new EducationBoardEntity();
        
        if (dto.getCode() != null && !dto.getCode().trim().isEmpty()) {
            entity.setCode(dto.getCode().trim());
        }
        
        entity.setName(dto.getName().trim());
        
        if (dto.getCountryCode() != null) {
            entity.setCountryCode(dto.getCountryCode().trim());
        }
        
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(EducationBoardEntity entity, EducationBoardRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(EducationBoardErrors.INVALID_EDUCATION_BOARD_DATA,
                        "Education board name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            entity.setCode(dto.getCode().trim().isEmpty() ? null : dto.getCode().trim());
        }

        if (dto.getCountryCode() != null) {
            entity.setCountryCode(dto.getCountryCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
