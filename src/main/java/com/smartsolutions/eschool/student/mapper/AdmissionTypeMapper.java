package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.AdmissionTypeErrors;
import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.dtos.admissionType.requestDto.AdmissionTypeCreateRequestDTO;
import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for AdmissionTypeEntity to DTOs and vice versa.
 */
public class AdmissionTypeMapper {

    private AdmissionTypeMapper() {
        // prevent instantiation
    }

    public static AdmissionTypeResponseDTO toResponseDTO(AdmissionTypeEntity entity) {
        if (entity == null) {
            return null;
        }

        AdmissionTypeResponseDTO dto = new AdmissionTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());
        dto.setDeleted(entity.isDeleted());

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<AdmissionTypeResponseDTO> toResponseDTOList(List<AdmissionTypeEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(AdmissionTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static AdmissionTypeEntity toEntity(AdmissionTypeCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(AdmissionTypeErrors.INVALID_ADMISSION_TYPE_DATA, "Admission type name is required",
                    HttpStatus.BAD_REQUEST);
        }

        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(AdmissionTypeErrors.INVALID_ADMISSION_TYPE_DATA, "Admission type code is required",
                    HttpStatus.BAD_REQUEST);
        }

        AdmissionTypeEntity entity = new AdmissionTypeEntity();
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(AdmissionTypeEntity entity, AdmissionTypeCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(AdmissionTypeErrors.INVALID_ADMISSION_TYPE_DATA,
                        "Admission type name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(AdmissionTypeErrors.INVALID_ADMISSION_TYPE_DATA,
                        "Admission type code cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
