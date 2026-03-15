package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;

import java.util.List;
import java.util.stream.Collectors;

public class FeeRateMapper {

    private FeeRateMapper() {
    }

    public static FeeRatesResponseDTO toResponseDTO(FeeRateEntity entity) {
        if (entity == null)
            return null;

        FeeRatesResponseDTO dto = new FeeRatesResponseDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());

        dto.setFixedAmount(entity.getFixedAmount());
        dto.setPercentageValue(entity.getPercentageValue());
        dto.setUnitPrice(entity.getUnitPrice());

        if (entity.getPercentageOfComponent() != null) {
            dto.setPercentageOfComponent(toFeeComponentDTO(entity.getPercentageOfComponent()));
        }

        if (entity.getSlabGroup() != null) {
            FeeRatesResponseDTO.SlabGroupDTO slabGroupDTO = new FeeRatesResponseDTO.SlabGroupDTO();
            slabGroupDTO.setId(entity.getSlabGroup().getId());
            slabGroupDTO.setName(entity.getSlabGroup().getName());
            slabGroupDTO.setCode(entity.getSlabGroup().getCode());
            dto.setSlabGroup(slabGroupDTO);
        }

        if (entity.getChargeType() != null) {
            FeeRatesResponseDTO.ChargeTypeDTO chargeTypeDTO = new FeeRatesResponseDTO.ChargeTypeDTO();
            chargeTypeDTO.setId(entity.getChargeType().getId());
            chargeTypeDTO.setCode(entity.getChargeType().getCode());
            chargeTypeDTO.setName(entity.getChargeType().getName());
            dto.setChargeType(chargeTypeDTO);
        }

        dto.setPriority(entity.getPriority());

        dto.setCurrency(entity.getCurrency());
        dto.setEffectiveFrom(entity.getEffectiveFrom());
        dto.setEffectiveTo(entity.getEffectiveTo());
        dto.setActive(entity.isActive());

        // Basic map of campus, standard, component, academic year
        if (entity.getCampus() != null) {
            FeeRatesResponseDTO.CampusDTO campus = new FeeRatesResponseDTO.CampusDTO();
            campus.setId(entity.getCampus().getId());
            campus.setCampusName(entity.getCampus().getCampusName());
            dto.setCampus(campus);
        }

        if (entity.getStandard() != null) {
            FeeRatesResponseDTO.StandardDTO standard = new FeeRatesResponseDTO.StandardDTO();
            standard.setId(entity.getStandard().getId());
            standard.setStandardName(entity.getStandard().getStandardName());
            dto.setStandard(standard);
        }

        if (entity.getFeeComponent() != null) {
            dto.setFeeComponent(toFeeComponentDTO(entity.getFeeComponent()));
        }

        if (entity.getAcademicYear() != null) {
            FeeRatesResponseDTO.AcademicYearDTO ay = new FeeRatesResponseDTO.AcademicYearDTO();
            ay.setId(entity.getAcademicYear().getId());
            ay.setName(entity.getAcademicYear().getName());
            dto.setAcademicYear(ay);
        }

        return dto;
    }

    private static FeeRatesResponseDTO.FeeComponentDTO toFeeComponentDTO(FeeComponentEntity entity) {
        if (entity == null)
            return null;
        FeeRatesResponseDTO.FeeComponentDTO dto = new FeeRatesResponseDTO.FeeComponentDTO();
        dto.setId(entity.getId());
        dto.setComponentCode(entity.getComponentCode());
        dto.setComponentName(entity.getComponentName());
        dto.setAccountCode(entity.getAccountCode());
        dto.setTaxable(entity.isTaxable());
        dto.setDiscountable(entity.isDiscountable());

        if (entity.getFeeCatalog() != null) {
            FeeRatesResponseDTO.FeeComponentDTO.FeeCatalogDTO catalog = new FeeRatesResponseDTO.FeeComponentDTO.FeeCatalogDTO();
            catalog.setId(entity.getFeeCatalog().getId());
            catalog.setCode(entity.getFeeCatalog().getCode());
            catalog.setName(entity.getFeeCatalog().getName());
            catalog.setDescription(entity.getFeeCatalog().getDescription());
            catalog.setActive(entity.getFeeCatalog().isActive());

            if (entity.getFeeCatalog().getChargeType() != null) {
                catalog.setChargeType(entity.getFeeCatalog().getChargeType().getCode());
                catalog.setChargeTypeLabel(entity.getFeeCatalog().getChargeType().getName());

                // Also set top-level chargeType in FeeComponentDTO for full consistency
                FeeRatesResponseDTO.ChargeTypeDTO ct = new FeeRatesResponseDTO.ChargeTypeDTO();
                ct.setId(entity.getFeeCatalog().getChargeType().getId());
                ct.setCode(entity.getFeeCatalog().getChargeType().getCode());
                ct.setName(entity.getFeeCatalog().getChargeType().getName());
                dto.setChargeType(ct);
            }

            if (entity.getFeeCatalog().getRecurrenceRule() != null) {
                catalog.setRecurrenceRule(entity.getFeeCatalog().getRecurrenceRule().getCode());
                catalog.setRecurrenceRuleLabel(entity.getFeeCatalog().getRecurrenceRule().getName());

                // Also set top-level recurrenceRule in FeeComponentDTO
                FeeRatesResponseDTO.FeeComponentDTO.RecurrenceRuleDTO rr = new FeeRatesResponseDTO.FeeComponentDTO.RecurrenceRuleDTO();
                rr.setId(entity.getFeeCatalog().getRecurrenceRule().getId());
                rr.setCode(entity.getFeeCatalog().getRecurrenceRule().getCode());
                rr.setName(entity.getFeeCatalog().getRecurrenceRule().getName());
                dto.setRecurrenceRule(rr);
            }
            dto.setFeeCatalog(catalog);
        }
        return dto;
    }

    public static List<FeeRatesResponseDTO> toResponseDTOList(List<FeeRateEntity> entities) {
        if (entities == null)
            return java.util.Collections.emptyList();
        return entities.stream().map(FeeRateMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static FeeRateEntity toEntity(FeeRateCreateRequestDTO dto) {
        if (dto == null)
            return null;

        FeeRateEntity entity = new FeeRateEntity();

        entity.setFixedAmount(dto.getFixedAmount());
        entity.setPercentageValue(dto.getPercentageValue());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setPriority(dto.getPriority() != null ? dto.getPriority() : 0);

        entity.setCurrency(dto.getCurrency());
        entity.setEffectiveFrom(dto.getEffectiveFrom());
        entity.setEffectiveTo(dto.getEffectiveTo());
        entity.setActive(dto.isActive());
        entity.setDeleted(false);

        return entity;
    }

}
