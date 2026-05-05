package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.error.DesignationErrors;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for DesignationEntity to DTOs and vice versa.
 */
public class DesignationMapper {

    private DesignationMapper() {
        // prevent instantiation
    }

    public static DesignationResponseDTO toResponseDTO(DesignationEntity entity) {
        if (entity == null) {
            return null;
        }

        DesignationResponseDTO dto = new DesignationResponseDTO();
        dto.setId(entity.getId());
        dto.setDesignationCode(entity.getDesignationCode());
        dto.setDesignationName(entity.getDesignationName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setDeleted(entity.isDeleted());

        return dto;
    }

    public static List<DesignationResponseDTO> toResponseDTOList(List<DesignationEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(DesignationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static DesignationEntity toEntity(DesignationRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getDesignationName() == null || dto.getDesignationName().trim().isEmpty()) {
            throw new ApiException(DesignationErrors.INVALID_DESIGNATION_DATA, "Designation name is required",
                    HttpStatus.BAD_REQUEST);
        }

        DesignationEntity entity = new DesignationEntity();
        entity.setDesignationName(dto.getDesignationName().trim());
        entity.setDesignationCode(dto.getDesignationCode() != null ? dto.getDesignationCode().trim() : null);
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(DesignationEntity entity, DesignationRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getDesignationName() != null) {
            if (dto.getDesignationName().trim().isEmpty()) {
                throw new ApiException(DesignationErrors.INVALID_DESIGNATION_DATA, "Designation name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setDesignationName(dto.getDesignationName().trim());
        }

        if (dto.getDesignationCode() != null) {
            entity.setDesignationCode(dto.getDesignationCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
