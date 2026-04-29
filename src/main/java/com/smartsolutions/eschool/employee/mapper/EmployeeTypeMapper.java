package com.smartsolutions.eschool.employee.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.EmployeeTypeErrors;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTypeMapper {

    private EmployeeTypeMapper() {
    }

    public static EmployeeTypeResponseDTO toResponseDTO(EmployeeTypeEntity entity) {
        if (entity == null) {
            return null;
        }

        EmployeeTypeResponseDTO dto = new EmployeeTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<EmployeeTypeResponseDTO> toResponseDTOList(List<EmployeeTypeEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(EmployeeTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static EmployeeTypeEntity toEntity(EmployeeTypeRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(EmployeeTypeErrors.INVALID_EMPLOYEE_TYPE_DATA, "Employee type name is required", HttpStatus.BAD_REQUEST);
        }

        EmployeeTypeEntity entity = new EmployeeTypeEntity();
        
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(EmployeeTypeEntity entity, EmployeeTypeRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(EmployeeTypeErrors.INVALID_EMPLOYEE_TYPE_DATA, "Employee type name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
