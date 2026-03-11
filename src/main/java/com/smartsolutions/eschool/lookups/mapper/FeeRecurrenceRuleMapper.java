package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.FeeRecurrenceRuleErrors;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for FeeRecurrenceRuleEntity to DTOs and vice versa.
 */
public class FeeRecurrenceRuleMapper {

    private FeeRecurrenceRuleMapper() {
        // prevent instantiation
    }

    public static FeeRecurrenceRuleEntity toEntity(FeeRecurrenceRuleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(FeeRecurrenceRuleErrors.INVALID_FEE_RECURRENCE_RULE_DATA,
                    "Fee recurrence rule name is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(FeeRecurrenceRuleErrors.INVALID_FEE_RECURRENCE_RULE_DATA,
                    "Fee recurrence rule code is required", HttpStatus.BAD_REQUEST);
        }

        FeeRecurrenceRuleEntity entity = new FeeRecurrenceRuleEntity();
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);
        return entity;
    }

    public static FeeRecurrenceRuleResponseDTO toResponseDTO(FeeRecurrenceRuleEntity entity) {
        if (entity == null) {
            return null;
        }

        FeeRecurrenceRuleResponseDTO dto = new FeeRecurrenceRuleResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<FeeRecurrenceRuleResponseDTO> toResponseDTOList(List<FeeRecurrenceRuleEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(FeeRecurrenceRuleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntity(FeeRecurrenceRuleEntity entity, FeeRecurrenceRuleRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(FeeRecurrenceRuleErrors.INVALID_FEE_RECURRENCE_RULE_DATA,
                        "Fee recurrence rule name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(FeeRecurrenceRuleErrors.INVALID_FEE_RECURRENCE_RULE_DATA,
                        "Fee recurrence rule code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
