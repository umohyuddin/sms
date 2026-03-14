package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.lookups.mapper.FeeRecurrenceRuleMapper;
import com.smartsolutions.eschool.school.mapper.ChargeTypeMapper;
import com.smartsolutions.eschool.school.mapper.InstituteMapper;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FeeComponentMapper {
    private FeeComponentMapper() {
        // prevent instantiation
    }

    // ===========================
    // ENTITY → RESPONSE DTO
    // ===========================
    public static FeeComponentResponseDTO toDto(FeeComponentEntity entity) {
        if (entity == null) {
            return null;
        }

        FeeComponentResponseDTO dto = new FeeComponentResponseDTO();
        dto.setId(entity.getId());
        dto.setComponentCode(entity.getComponentCode());
        dto.setComponentName(entity.getComponentName());
        dto.setAccountCode(entity.getAccountCode());
        dto.setTaxable(entity.isTaxable());
        dto.setActive(entity.isActive());
        dto.setDiscountable(entity.isDiscountable());

        if (entity.getFeeCatalog() != null) {
            FeeCatalogEntity feeCatalog = entity.getFeeCatalog();
            dto.setFeeCatalogId(feeCatalog.getId());
            dto.setFeeCatalog(FeeCatalogMapper.toDto(feeCatalog));
            dto.setChargeType(ChargeTypeMapper.toResponseDTO(feeCatalog.getChargeType()));
            dto.setRecurrenceRule(FeeRecurrenceRuleMapper.toResponseDTO(feeCatalog.getRecurrenceRule()));
            //dto.setInstitute(InstituteMapper.toDto(feeCatalog.getInstitute()));
        }

        return dto;
    }

    public static List<FeeComponentResponseDTO> toDtoList(List<FeeComponentEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(FeeComponentMapper::toDto)
                .collect(Collectors.toList());
    }

    // ===========================
    // REQUEST DTO → ENTITY
    // ===========================
    public static FeeComponentEntity toEntity(FeeCatalogComponentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        FeeComponentEntity entity = new FeeComponentEntity();
        entity.setComponentCode(dto.getComponentCode() != null ? dto.getComponentCode().trim() : null);
        entity.setComponentName(dto.getComponentName() != null ? dto.getComponentName().trim() : null);
        //entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDiscountable(dto.getDiscountable() != null ? dto.getDiscountable() : false);
        entity.setDeleted(false);

        // FeeCatalog relation (just set the ID here, full entity should be set in Service)
        if (dto.getFeeCatalogId() != null) {
            FeeCatalogEntity feeCatalog = new FeeCatalogEntity();
            feeCatalog.setId(dto.getFeeCatalogId());
            entity.setFeeCatalog(feeCatalog);
        }

        return entity;
    }

    // ===========================
    // UPDATE EXISTING ENTITY
    // ===========================
    public static void updateEntityFromDto(FeeComponentEntity entity, FeeCatalogComponentRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getComponentCode() != null && !dto.getComponentCode().isBlank()) {
            entity.setComponentCode(dto.getComponentCode().trim());
        }

        if (dto.getComponentName() != null && !dto.getComponentName().isBlank()) {
            entity.setComponentName(dto.getComponentName().trim());
        }

//        if (dto.getDescription() != null) {
//            entity.setDescription(dto.getDescription());
//        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }

        if (dto.getDiscountable() != null) {
            entity.setDiscountable(dto.getDiscountable());
        }

        // FeeCatalog relation (update if provided)
        if (dto.getFeeCatalogId() != null) {
            if (entity.getFeeCatalog() == null) {
                entity.setFeeCatalog(new FeeCatalogEntity());
            }
            entity.getFeeCatalog().setId(dto.getFeeCatalogId());
        }
    }
}