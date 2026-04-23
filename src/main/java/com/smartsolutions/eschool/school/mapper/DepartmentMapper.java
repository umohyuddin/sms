package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.DepartmentErrors;
import com.smartsolutions.eschool.school.dtos.departments.requestDto.DepartmentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for DepartmentEntity to DTOs and vice versa.
 */
public class DepartmentMapper {

    private DepartmentMapper() {
        // prevent instantiation
    }

    public static DepartmentResponseDTO toResponseDTO(DepartmentEntity entity) {
        if (entity == null) {
            return null;
        }

        DepartmentResponseDTO dto = DepartmentResponseDTO.builder()
                .id(entity.getId())
                .organizationId(entity.getOrganizationId())
                .departmentCode(entity.getDepartmentCode())
                .departmentName(entity.getDepartmentName())
                .description(entity.getDescription())
                .active(entity.isActive())
                .deleted(entity.isDeleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();

        if (entity.getCampus() != null) {
            dto.setCampusId(entity.getCampus().getId());
            dto.setCampusName(entity.getCampus().getCampusName());
        }

        if (entity.getDepartmentType() != null) {
            dto.setDepartmentTypeId(entity.getDepartmentType().getId());
            dto.setDepartmentTypeName(entity.getDepartmentType().getName());
        }

        if (entity.getParent() != null) {
            dto.setParentId(entity.getParent().getId());
            dto.setParentName(entity.getParent().getDepartmentName());
        }

        if (entity.getHeadEmployee() != null) {
            dto.setHeadEmployeeId(entity.getHeadEmployee().getId());
            dto.setHeadEmployeeName(entity.getHeadEmployee().getFirstName() + " " + entity.getHeadEmployee().getLastName());
        }

        return dto;
    }

    public static List<DepartmentResponseDTO> toResponseDTOList(List<DepartmentEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(DepartmentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static DepartmentEntity toEntity(DepartmentCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getDepartmentName() == null || dto.getDepartmentName().trim().isEmpty()) {
            throw new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Department name is required", HttpStatus.BAD_REQUEST);
        }

        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentCode(dto.getDepartmentCode() != null ? dto.getDepartmentCode().trim() : null);
        entity.setDepartmentName(dto.getDepartmentName().trim());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(DepartmentEntity entity, DepartmentCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getDepartmentName() != null) {
            if (dto.getDepartmentName().trim().isEmpty()) {
                throw new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Department name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setDepartmentName(dto.getDepartmentName().trim());
        }

        if (dto.getDepartmentCode() != null) {
            entity.setDepartmentCode(dto.getDepartmentCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        entity.setActive(dto.isActive());
    }
}
