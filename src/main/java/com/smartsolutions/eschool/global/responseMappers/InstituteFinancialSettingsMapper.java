package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.dtos.instituteFinancialSettings.requestDto.InstituteFinancialSettingsCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFinancialSettings.requestDto.InstituteFinancialSettingsUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFinancialSettings.responseDto.InstituteFinancialSettingsResponseDTO;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.school.model.InstituteFinancialSettingsEntity;

public class InstituteFinancialSettingsMapper {

    private InstituteFinancialSettingsMapper() {
        // prevent instantiation
    }

    public static InstituteFinancialSettingsEntity toEntity(InstituteFinancialSettingsCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        InstituteFinancialSettingsEntity entity = new InstituteFinancialSettingsEntity();
        
        // Basic fields
        entity.setLocale(dto.getLocale());
        entity.setFeeFrequency(dto.getFeeFrequency());
        entity.setAllowPartialPayments(dto.getAllowPartialPayments());
        entity.setLateFeeType(dto.getLateFeeType());
        entity.setLateFeeAmount(dto.getLateFeeAmount());
        
        // Tax fields
        entity.setIsTaxApplicable(dto.getIsTaxApplicable());
        entity.setIsTaxInclusive(dto.getIsTaxInclusive());

        // Fee recurrence rule
        if (dto.getFeeRecurrenceRuleId() != null) {
            FeeRecurrenceRuleEntity feeRecurrenceRule = new FeeRecurrenceRuleEntity();
            feeRecurrenceRule.setId(dto.getFeeRecurrenceRuleId());
            entity.setFeeRecurrenceRule(feeRecurrenceRule);
        }
        
        // Refund fields
        entity.setAllowRefunds(dto.getAllowRefunds());
        entity.setRefundPolicyUrl(dto.getRefundPolicyUrl());
        entity.setRefundWindowDays(dto.getRefundWindowDays());
        entity.setRefundPercentage(dto.getRefundPercentage());
        entity.setRefundFixedAmount(dto.getRefundFixedAmount());
        
        // Compliance fields
        entity.setInvoiceMandatory(dto.getInvoiceMandatory());
        entity.setReceiptMandatory(dto.getReceiptMandatory());
        entity.setIsActive(dto.getIsActive());
        
        // Institute, AcademicYear, Currency, Language, and TaxType are set in service
        return entity;
    }

    public static InstituteFinancialSettingsResponseDTO toResponseDTO(InstituteFinancialSettingsEntity entity) {
        if (entity == null) {
            return null;
        }

        InstituteFinancialSettingsResponseDTO dto = new InstituteFinancialSettingsResponseDTO();
        
        dto.setId(entity.getId());
        
        // Institute ID
        if (entity.getInstitute() != null) {
            dto.setInstituteId(entity.getInstitute().getId());
        }
        
        // Academic Year mapping
        if (entity.getAcademicYear() != null) {
            AcademicYearResponseDTO academicYearDTO = new AcademicYearResponseDTO();
            academicYearDTO.setId(entity.getAcademicYear().getId());
            academicYearDTO.setName(entity.getAcademicYear().getName());
            academicYearDTO.setCode(entity.getAcademicYear().getCode());
            academicYearDTO.setStartDate(entity.getAcademicYear().getStartDate());
            academicYearDTO.setEndDate(entity.getAcademicYear().getEndDate());
            academicYearDTO.setIsCurrent(entity.getAcademicYear().getIsCurrent());
            academicYearDTO.setStatus(entity.getAcademicYear().getStatus() != null ? entity.getAcademicYear().getStatus().name() : null);
            dto.setAcademicYear(academicYearDTO);
        }
        
        // Currency mapping
        if (entity.getCurrency() != null) {
            CurrencyResponseDTO currencyDTO = new CurrencyResponseDTO();
            currencyDTO.setId(entity.getCurrency().getId());
            currencyDTO.setIsoCode(entity.getCurrency().getIsoCode());
            currencyDTO.setName(entity.getCurrency().getName());
            currencyDTO.setSymbol(entity.getCurrency().getSymbol());
            currencyDTO.setIsActive(entity.getCurrency().getIsActive());
            dto.setCurrency(currencyDTO);
        }

        // Fee Recurrence Rule mapping
        if (entity.getFeeRecurrenceRule() != null) {
            FeeRecurrenceRuleResponseDTO feeRecurrenceRuleDTO = new FeeRecurrenceRuleResponseDTO();
            feeRecurrenceRuleDTO.setId(entity.getFeeRecurrenceRule().getId());
            feeRecurrenceRuleDTO.setCode(entity.getFeeRecurrenceRule().getCode());
            feeRecurrenceRuleDTO.setName(entity.getFeeRecurrenceRule().getName());
            feeRecurrenceRuleDTO.setDescription(entity.getFeeRecurrenceRule().getDescription());
            feeRecurrenceRuleDTO.setIsActive(entity.getFeeRecurrenceRule().getIsActive());
            dto.setFeeRecurrenceRule(feeRecurrenceRuleDTO);
        }
        
        // Language mapping
        if (entity.getLanguage() != null) {
            LanguageResponseDTO languageDTO = new LanguageResponseDTO();
            languageDTO.setId(entity.getLanguage().getId());
            languageDTO.setIsoCode(entity.getLanguage().getIsoCode());
            languageDTO.setName(entity.getLanguage().getName());
            languageDTO.setIsActive(entity.getLanguage().getIsActive());
            dto.setLanguage(languageDTO);
        }
        
        // Tax Type mapping
        if (entity.getTaxType() != null) {
            TaxTypeResponseDTO taxTypeDTO = new TaxTypeResponseDTO();
            taxTypeDTO.setId(entity.getTaxType().getId());
            taxTypeDTO.setCode(entity.getTaxType().getCode());
            taxTypeDTO.setName(entity.getTaxType().getName());
            taxTypeDTO.setTaxPercentage(entity.getTaxType().getTaxPercentage());
            if (entity.getTaxType().getCountry() != null) {
                taxTypeDTO.setCountryId(entity.getTaxType().getCountry().getId());
            }
            taxTypeDTO.setIsActive(entity.getTaxType().getIsActive());
            dto.setTaxType(taxTypeDTO);
        }
        
        // Basic fields
        dto.setLocale(entity.getLocale());
        dto.setFeeFrequency(entity.getFeeFrequency());
        dto.setAllowPartialPayments(entity.getAllowPartialPayments());
        dto.setLateFeeType(entity.getLateFeeType());
        dto.setLateFeeAmount(entity.getLateFeeAmount());
        
        // Tax fields
        dto.setIsTaxApplicable(entity.getIsTaxApplicable());
        dto.setIsTaxInclusive(entity.getIsTaxInclusive());
        
        // Refund fields
        dto.setAllowRefunds(entity.getAllowRefunds());
        dto.setRefundPolicyUrl(entity.getRefundPolicyUrl());
        dto.setRefundWindowDays(entity.getRefundWindowDays());
        dto.setRefundPercentage(entity.getRefundPercentage());
        dto.setRefundFixedAmount(entity.getRefundFixedAmount());
        
        // Compliance fields
        dto.setInvoiceMandatory(entity.getInvoiceMandatory());
        dto.setReceiptMandatory(entity.getReceiptMandatory());
        dto.setIsActive(entity.getIsActive());
        
        return dto;
    }

    public static void updateEntityFromDTO(InstituteFinancialSettingsEntity entity, InstituteFinancialSettingsUpdateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        // Update basic fields only if provided
        if (dto.getLocale() != null) entity.setLocale(dto.getLocale());
        if (dto.getFeeFrequency() != null) entity.setFeeFrequency(dto.getFeeFrequency());
        if (dto.getAllowPartialPayments() != null) entity.setAllowPartialPayments(dto.getAllowPartialPayments());
        if (dto.getLateFeeType() != null) entity.setLateFeeType(dto.getLateFeeType());
        if (dto.getLateFeeAmount() != null) entity.setLateFeeAmount(dto.getLateFeeAmount());
        
        // Tax fields
        if (dto.getIsTaxApplicable() != null) entity.setIsTaxApplicable(dto.getIsTaxApplicable());
        if (dto.getIsTaxInclusive() != null) entity.setIsTaxInclusive(dto.getIsTaxInclusive());

        // Fee recurrence rule
        if (dto.getFeeRecurrenceRuleId() != null) {
            FeeRecurrenceRuleEntity feeRecurrenceRule = new FeeRecurrenceRuleEntity();
            feeRecurrenceRule.setId(dto.getFeeRecurrenceRuleId());
            entity.setFeeRecurrenceRule(feeRecurrenceRule);
        }
        
        // Refund fields
        if (dto.getAllowRefunds() != null) entity.setAllowRefunds(dto.getAllowRefunds());
        if (dto.getRefundPolicyUrl() != null) entity.setRefundPolicyUrl(dto.getRefundPolicyUrl());
        if (dto.getRefundWindowDays() != null) entity.setRefundWindowDays(dto.getRefundWindowDays());
        if (dto.getRefundPercentage() != null) entity.setRefundPercentage(dto.getRefundPercentage());
        if (dto.getRefundFixedAmount() != null) entity.setRefundFixedAmount(dto.getRefundFixedAmount());
        
        // Compliance fields
        if (dto.getInvoiceMandatory() != null) entity.setInvoiceMandatory(dto.getInvoiceMandatory());
        if (dto.getReceiptMandatory() != null) entity.setReceiptMandatory(dto.getReceiptMandatory());
        if (dto.getIsActive() != null) entity.setIsActive(dto.getIsActive());
        
        // Relationships (Currency, Language, TaxType, AcademicYear) are updated in service
    }
}
