package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.model.ResourceEntity;
import com.smartsolutions.eschool.user.model.ModuleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceMapper {

    private ResourceMapper() {
        // prevent instantiation
    }

    public static ResourceEntity toEntity(ResourceRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        ResourceEntity entity = new ResourceEntity();
        entity.setResourceName(dto.getResourceName());
        entity.setVersion(dto.getVersion());
        if (dto.getIsActive() != null) {
            entity.setActive(dto.getIsActive());
        }
        entity.setDescription(dto.getDescription());
        if (dto.getIsAuthRequired() != null) {
            entity.setAuthRequired(dto.getIsAuthRequired());
        }
        entity.setRateLimit(dto.getRateLimit());
        if (dto.getIsDeprecated() != null) {
            entity.setDeprecated(dto.getIsDeprecated());
        }
        entity.setDocumentationUrl(dto.getDocumentationUrl());
        entity.setOwner(dto.getOwner());

        if (dto.getModuleId() != null) {
            ModuleEntity module = new ModuleEntity();
            module.setId(dto.getModuleId());
            entity.setModule(module);
        }

        return entity;
    }

    public static ResourceResponseDTO toResponseDTO(ResourceEntity entity) {
        if (entity == null) {
            return null;
        }

        ResourceResponseDTO dto = new ResourceResponseDTO();
        dto.setId(entity.getId());
        dto.setResourceName(entity.getResourceName());
        dto.setVersion(entity.getVersion());
        dto.setIsActive(entity.isActive());
        dto.setDescription(entity.getDescription());
        dto.setIsAuthRequired(entity.isAuthRequired());
        dto.setRateLimit(entity.getRateLimit());
        dto.setIsDeprecated(entity.isDeprecated());
        dto.setDocumentationUrl(entity.getDocumentationUrl());
        dto.setOwner(entity.getOwner());
        dto.setDeleted(entity.isDeleted());

        if (entity.getModule() != null) {
            dto.setModule(ModuleMapper.toResponseDTO(entity.getModule()));
        }

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        return dto;
    }

    public static List<ResourceResponseDTO> toResponseDTOList(List<ResourceEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(ResourceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntityFromDTO(ResourceEntity entity, ResourceRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getResourceName() != null) entity.setResourceName(dto.getResourceName());
        if (dto.getVersion() != null) entity.setVersion(dto.getVersion());
        if (dto.getIsActive() != null) entity.setActive(dto.getIsActive());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getIsAuthRequired() != null) entity.setAuthRequired(dto.getIsAuthRequired());
        if (dto.getRateLimit() != null) entity.setRateLimit(dto.getRateLimit());
        if (dto.getIsDeprecated() != null) entity.setDeprecated(dto.getIsDeprecated());
        if (dto.getDocumentationUrl() != null) entity.setDocumentationUrl(dto.getDocumentationUrl());
        if (dto.getOwner() != null) entity.setOwner(dto.getOwner());

        if (dto.getModuleId() != null) {
            ModuleEntity module = new ModuleEntity();
            module.setId(dto.getModuleId());
            entity.setModule(module);
        }
    }
}
