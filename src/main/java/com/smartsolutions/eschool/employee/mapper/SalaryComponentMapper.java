package com.smartsolutions.eschool.employee.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.SalaryComponentErrors;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryComponentMapper {

    private SalaryComponentMapper() {
    }

    public static SalaryComponentResponseDTO toResponseDTO(SalaryComponentEntity entity) {
        if (entity == null) {
            return null;
        }

        SalaryComponentResponseDTO dto = new SalaryComponentResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setIsPercentage(entity.getIsPercentage());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<SalaryComponentResponseDTO> toResponseDTOList(List<SalaryComponentEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(SalaryComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static SalaryComponentEntity toEntity(SalaryComponentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(SalaryComponentErrors.INVALID_SALARY_COMPONENT_DATA, "Salary component name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getType() == null) {
            throw new ApiException(SalaryComponentErrors.INVALID_SALARY_COMPONENT_DATA, "Salary component type is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getIsPercentage() == null) {
            throw new ApiException(SalaryComponentErrors.INVALID_SALARY_COMPONENT_DATA, "Salary component isPercentage is required", HttpStatus.BAD_REQUEST);
        }

        SalaryComponentEntity entity = new SalaryComponentEntity();
        
        entity.setName(dto.getName().trim());
        entity.setType(dto.getType());
        entity.setIsPercentage(dto.getIsPercentage());
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(SalaryComponentEntity entity, SalaryComponentRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(SalaryComponentErrors.INVALID_SALARY_COMPONENT_DATA, "Salary component name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getType() != null) {
            entity.setType(dto.getType());
        }

        if (dto.getIsPercentage() != null) {
            entity.setIsPercentage(dto.getIsPercentage());
        }
    }
}
