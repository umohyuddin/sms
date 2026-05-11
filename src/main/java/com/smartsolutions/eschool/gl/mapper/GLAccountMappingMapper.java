package com.smartsolutions.eschool.gl.mapper;

import com.smartsolutions.eschool.gl.dtos.glAccountMapping.response.GLAccountMappingResponseDTO;
import com.smartsolutions.eschool.gl.model.GLAccountMappingEntity;

import java.util.List;
import java.util.stream.Collectors;

public class GLAccountMappingMapper {

    public static GLAccountMappingResponseDTO toResponseDTO(GLAccountMappingEntity entity) {
        if (entity == null) return null;
        return GLAccountMappingResponseDTO.builder()
                .id(entity.getId())
                .campusId(entity.getCampusId())
                .accountingModule(GLAccountMappingResponseDTO.NameCodeDTO.builder()
                        .id(entity.getAccountingModule().getId())
                        .code(entity.getAccountingModule().getCode())
                        .name(entity.getAccountingModule().getName())
                        .build())
                .transactionType(GLAccountMappingResponseDTO.NameCodeDTO.builder()
                        .id(entity.getTransactionType().getId())
                        .code(entity.getTransactionType().getCode())
                        .name(entity.getTransactionType().getName())
                        .build())
                .businessKey(GLAccountMappingResponseDTO.NameCodeDTO.builder()
                        .id(entity.getBusinessKey().getId())
                        .code(entity.getBusinessKey().getCode())
                        .name(entity.getBusinessKey().getName())
                        .build())
                .postingKey(GLAccountMappingResponseDTO.PostingKeyDetailDTO.builder()
                        .id(entity.getPostingKey().getId())
                        .code(entity.getPostingKey().getCode())
                        .name(entity.getPostingKey().getName())
                        .accountSide(entity.getPostingKey().getAccountSide().name())
                        .build())
                .glAccount(GLAccountMappingResponseDTO.GLAccountDetailDTO.builder()
                        .id(entity.getGlAccount().getId())
                        .accountCode(entity.getGlAccount().getAccountCode())
                        .accountName(entity.getGlAccount().getAccountName())
                        .accountType(entity.getGlAccount().getAccountType().name())
                        .build())
                .priorityOrder(entity.getPriorityOrder())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static List<GLAccountMappingResponseDTO> toResponseDTOList(List<GLAccountMappingEntity> entities) {
        return entities.stream().map(GLAccountMappingMapper::toResponseDTO).collect(Collectors.toList());
    }
}
