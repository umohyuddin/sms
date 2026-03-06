package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.error.DepartmentErrors;
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

    public static DepartmentEntity toEntity(DepartmentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getDepartmentName() == null || dto.getDepartmentName().trim().isEmpty()) {
            throw new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Department name is required",
                    HttpStatus.BAD_REQUEST);
        }
        if (dto.getDepartmentCode() == null || dto.getDepartmentCode().trim().isEmpty()) {
            throw new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Department code is required",
                    HttpStatus.BAD_REQUEST);
        }

        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentName(dto.getDepartmentName().trim());
        entity.setDepartmentCode(dto.getDepartmentCode().trim());
        entity.setDescription(dto.getDescription() != null ? dto.getDescription().trim() : null);
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static DepartmentResponseDTO toResponseDTO(DepartmentEntity entity) {
        if (entity == null) {
            return null;
        }

        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(entity.getId());
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentName(entity.getDepartmentName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());

        if (entity.getParentDepartment() != null) {
            dto.setParentDepartmentId(entity.getParentDepartment().getId());
            dto.setParentDepartmentName(entity.getParentDepartment().getDepartmentName());
        }

        if (entity.getHeadEmployee() != null) {
            dto.setHeadEmployeeId(entity.getHeadEmployee().getId());
            dto.setHeadEmployeeCode(entity.getHeadEmployee().getEmployeeCode());
            dto.setHeadEmployeeName(entity.getHeadEmployee().getFullName());
        }

        dto.setDeleted(entity.getDeleted());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

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

    public static void updateEntityFromDTO(DepartmentEntity entity, DepartmentRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getDepartmentName() != null) {
            if (dto.getDepartmentName().trim().isEmpty()) {
                throw new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Department name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setDepartmentName(dto.getDepartmentName().trim());
        }

        if (dto.getDepartmentCode() != null) {
            if (dto.getDepartmentCode().trim().isEmpty()) {
                throw new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Department code cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setDepartmentCode(dto.getDepartmentCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription().trim());
        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
