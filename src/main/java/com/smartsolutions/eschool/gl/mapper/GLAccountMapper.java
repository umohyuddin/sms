package com.smartsolutions.eschool.gl.mapper;

import com.smartsolutions.eschool.gl.dtos.accounts.requestDto.GLAccountCreateRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accounts.responseDto.GLAccountResponseDTO;
import com.smartsolutions.eschool.gl.model.GLAccountEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for GLAccountEntity to DTOs and vice versa.
 */
public class GLAccountMapper {

    private GLAccountMapper() {
        // prevent instantiation
    }

    public static GLAccountResponseDTO toResponseDTO(GLAccountEntity entity) {
        if (entity == null) {
            return null;
        }

        GLAccountResponseDTO dto = new GLAccountResponseDTO();
        dto.setId(entity.getId());
        dto.setCampusId(entity.getCampusId());
        dto.setAccountCode(entity.getAccountCode());
        dto.setAccountName(entity.getAccountName());
        
        if (entity.getParent() != null) {
            dto.setParentId(entity.getParent().getId());
            dto.setParentName(entity.getParent().getAccountName());
        }
        
        dto.setAccountType(entity.getAccountType());
        dto.setGroup(entity.isGroup());
        dto.setLevelNo(entity.getLevelNo());
        dto.setControlAccount(entity.isControlAccount());
        dto.setCashAccount(entity.isCashAccount());
        dto.setBankAccount(entity.isBankAccount());
        dto.setReconcilable(entity.isReconcilable());
        dto.setNormalBalance(entity.getNormalBalance());
        dto.setCurrencyCode(entity.getCurrencyCode());
        dto.setActive(entity.isActive());
        
        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<GLAccountResponseDTO> toResponseDTOList(List<GLAccountEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(GLAccountMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static GLAccountEntity toEntity(GLAccountCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        GLAccountEntity entity = new GLAccountEntity();
        entity.setCampusId(dto.getCampusId());
        entity.setAccountCode(dto.getAccountCode());
        entity.setAccountName(dto.getAccountName());
        entity.setAccountType(dto.getAccountType());
        entity.setGroup(dto.isGroup());
        entity.setControlAccount(dto.isControlAccount());
        entity.setCashAccount(dto.isCashAccount());
        entity.setBankAccount(dto.isBankAccount());
        entity.setReconcilable(dto.isReconcilable());
        entity.setNormalBalance(dto.getNormalBalance());
        entity.setCurrencyCode(dto.getCurrencyCode() != null ? dto.getCurrencyCode() : "PKR");
        entity.setActive(dto.isActive());

        return entity;
    }

    public static void updateEntityFromDTO(GLAccountEntity entity, GLAccountCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCampusId() != null) entity.setCampusId(dto.getCampusId());
        if (dto.getAccountCode() != null) entity.setAccountCode(dto.getAccountCode());
        if (dto.getAccountName() != null) entity.setAccountName(dto.getAccountName());
        if (dto.getAccountType() != null) entity.setAccountType(dto.getAccountType());
        
        entity.setGroup(dto.isGroup());
        entity.setControlAccount(dto.isControlAccount());
        entity.setCashAccount(dto.isCashAccount());
        entity.setBankAccount(dto.isBankAccount());
        entity.setReconcilable(dto.isReconcilable());
        
        if (dto.getNormalBalance() != null) entity.setNormalBalance(dto.getNormalBalance());
        if (dto.getCurrencyCode() != null) entity.setCurrencyCode(dto.getCurrencyCode());
        
        entity.setActive(dto.isActive());
    }
}
