package com.smartsolutions.eschool.gl.mapper;

import com.smartsolutions.eschool.gl.dtos.accountingModule.request.AccountingModuleRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accountingModule.response.AccountingModuleResponseDTO;
import com.smartsolutions.eschool.gl.model.AccountingModuleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AccountingModuleMapper {

    public static AccountingModuleEntity toEntity(AccountingModuleRequestDTO dto) {
        if (dto == null) return null;
        return AccountingModuleEntity.builder()
                .code(dto.getCode().trim())
                .name(dto.getName().trim())
                .description(dto.getDescription())
                .isActive(dto.isActive())
                .build();
    }

    public static AccountingModuleResponseDTO toResponseDTO(AccountingModuleEntity entity) {
        if (entity == null) return null;
        return AccountingModuleResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static void updateEntityFromDTO(AccountingModuleEntity entity, AccountingModuleRequestDTO dto) {
        if (dto == null) return;
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
    }

    public static List<AccountingModuleResponseDTO> toResponseDTOList(List<AccountingModuleEntity> entities) {
        return entities.stream().map(AccountingModuleMapper::toResponseDTO).collect(Collectors.toList());
    }
}
