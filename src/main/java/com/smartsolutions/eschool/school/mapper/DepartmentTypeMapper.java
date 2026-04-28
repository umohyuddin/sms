package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.DepartmentTypeErrors;
import com.smartsolutions.eschool.school.dtos.departmentTypes.requestDto.DepartmentTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departmentTypes.response.DepartmentTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DepartmentTypeEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for DepartmentTypeEntity to DTOs and vice versa.
 */
public class DepartmentTypeMapper {

    private DepartmentTypeMapper() {
        // prevent instantiation
    }

    public static DepartmentTypeResponseDTO toResponseDTO(DepartmentTypeEntity entity) {
        if (entity == null) {
            return null;
        }

        return DepartmentTypeResponseDTO.builder()
                .id(entity.getId())
                .organizationId(entity.getOrganizationId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .active(entity.isActive())
                .deleted(entity.isDeleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<DepartmentTypeResponseDTO> toResponseDTOList(List<DepartmentTypeEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(DepartmentTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static DepartmentTypeEntity toEntity(DepartmentTypeCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(DepartmentTypeErrors.INVALID_DEPARTMENT_TYPE_DATA, "Department type name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(DepartmentTypeErrors.INVALID_DEPARTMENT_TYPE_DATA, "Department type code is required", HttpStatus.BAD_REQUEST);
        }

        DepartmentTypeEntity entity = new DepartmentTypeEntity();
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(DepartmentTypeEntity entity, DepartmentTypeCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(DepartmentTypeErrors.INVALID_DEPARTMENT_TYPE_DATA, "Department type name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(DepartmentTypeErrors.INVALID_DEPARTMENT_TYPE_DATA, "Department type code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        entity.setActive(dto.isActive());
    }
}
