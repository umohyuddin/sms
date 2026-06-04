package com.smartsolutions.eschool.user.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.ModuleErrors;
import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.model.ModuleEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleMapper {

    private ModuleMapper() {
    }

    public static ModuleResponseDTO toResponseDTO(ModuleEntity entity) {
        if (entity == null) {
            return null;
        }

        ModuleResponseDTO dto = new ModuleResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        dto.setRoute(entity.getRoute());
        dto.setDisplayOrder(entity.getDisplayOrder());
        dto.setSystemModule(entity.getSystemModule());
        dto.setActive(entity.getActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<ModuleResponseDTO> toResponseDTOList(List<ModuleEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(ModuleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static ModuleEntity toEntity(ModuleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(ModuleErrors.INVALID_MODULE_DATA, "Module name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(ModuleErrors.INVALID_MODULE_DATA, "Module code is required", HttpStatus.BAD_REQUEST);
        }

        ModuleEntity entity = new ModuleEntity();
        
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setIcon(dto.getIcon());
        entity.setRoute(dto.getRoute());
        entity.setDisplayOrder(dto.getDisplayOrder());
        
        entity.setSystemModule(dto.getSystemModule() != null ? dto.getSystemModule() : true);
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(ModuleEntity entity, ModuleRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(ModuleErrors.INVALID_MODULE_DATA, "Module name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(ModuleErrors.INVALID_MODULE_DATA, "Module code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getIcon() != null) {
            entity.setIcon(dto.getIcon().trim().isEmpty() ? null : dto.getIcon().trim());
        }

        if (dto.getRoute() != null) {
            entity.setRoute(dto.getRoute().trim().isEmpty() ? null : dto.getRoute().trim());
        }

        if (dto.getDisplayOrder() != null) {
            entity.setDisplayOrder(dto.getDisplayOrder());
        }

        if (dto.getSystemModule() != null) {
            entity.setSystemModule(dto.getSystemModule());
        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
