package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.FacilityTypeErrors;
import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FacilityTypeMapper {

    private FacilityTypeMapper() {
    }

    public static FacilityTypeResponseDTO toResponseDTO(FacilityTypeEntity entity) {
        if (entity == null) {
            return null;
        }

        FacilityTypeResponseDTO dto = new FacilityTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<FacilityTypeResponseDTO> toResponseDTOList(List<FacilityTypeEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(FacilityTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static FacilityTypeEntity toEntity(FacilityTypeRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(FacilityTypeErrors.INVALID_FACILITY_TYPE_DATA, "Facility type name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(FacilityTypeErrors.INVALID_FACILITY_TYPE_DATA, "Facility type code is required", HttpStatus.BAD_REQUEST);
        }

        FacilityTypeEntity entity = new FacilityTypeEntity();
        
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(FacilityTypeEntity entity, FacilityTypeRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(FacilityTypeErrors.INVALID_FACILITY_TYPE_DATA, "Facility type name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(FacilityTypeErrors.INVALID_FACILITY_TYPE_DATA, "Facility type code cannot be empty", HttpStatus.BAD_REQUEST);
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
