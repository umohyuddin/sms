package com.smartsolutions.eschool.institute.mapper;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.entity.InstituteFinancialSettings;
import org.springframework.stereotype.Component;

@Component
public class FinancialSettingsMapper {

    public InstituteFinancialSettings toEntity(FinancialSettingsRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        InstituteFinancialSettings entity = new InstituteFinancialSettings();
        entity.setInstituteId(dto.getInstituteId());
        entity.setAcademicYearId(dto.getAcademicYearId());
        entity.setFeeRecurrenceRuleId(dto.getFeeRecurrenceRuleId());
        entity.setCurrencyId(dto.getCurrencyId());
        entity.setLanguageId(dto.getLanguageId());
        entity.setLocale(dto.getLocale());
        entity.setAllowPartialPayments(dto.getAllowPartialPayments() != null ? dto.getAllowPartialPayments() : false);
        entity.setLateFeeApplicable(dto.getLateFeeApplicable() != null ? dto.getLateFeeApplicable() : false);
        entity.setLateFeeType(dto.getLateFeeType());
        entity.setLateFeeValue(dto.getLateFeeValue());
        entity.setTaxApplicable(dto.getTaxApplicable() != null ? dto.getTaxApplicable() : false);
        entity.setTaxTypeId(dto.getTaxTypeId());
        entity.setTaxIncludedInFee(dto.getTaxIncludedInFee() != null ? dto.getTaxIncludedInFee() : false);
        entity.setRefundsAllowed(dto.getRefundsAllowed() != null ? dto.getRefundsAllowed() : false);
        entity.setRefundPolicyUrl(dto.getRefundPolicyUrl());
        entity.setRefundWindowDays(dto.getRefundWindowDays());
        entity.setMaxRefundPercentage(dto.getMaxRefundPercentage());
        entity.setMaxRefundAmount(dto.getMaxRefundAmount());
        entity.setInvoiceMandatory(dto.getInvoiceMandatory() != null ? dto.getInvoiceMandatory() : false);
        entity.setReceiptMandatory(dto.getReceiptMandatory() != null ? dto.getReceiptMandatory() : true);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setIsDeleted(false);

        return entity;
    }

    public FinancialSettingsResponseDTO toDTO(InstituteFinancialSettings entity) {
        if (entity == null) {
            return null;
        }

        FinancialSettingsResponseDTO dto = new FinancialSettingsResponseDTO();
        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstituteId());
        dto.setAcademicYearId(entity.getAcademicYearId());
        dto.setFeeRecurrenceRuleId(entity.getFeeRecurrenceRuleId());
        dto.setCurrencyId(entity.getCurrencyId());
        dto.setLanguageId(entity.getLanguageId());
        dto.setLocale(entity.getLocale());
        dto.setAllowPartialPayments(entity.getAllowPartialPayments());
        dto.setLateFeeApplicable(entity.getLateFeeApplicable());
        dto.setLateFeeType(entity.getLateFeeType());
        dto.setLateFeeValue(entity.getLateFeeValue());
        dto.setTaxApplicable(entity.getTaxApplicable());
        dto.setTaxTypeId(entity.getTaxTypeId());
        dto.setTaxIncludedInFee(entity.getTaxIncludedInFee());
        dto.setRefundsAllowed(entity.getRefundsAllowed());
        dto.setRefundPolicyUrl(entity.getRefundPolicyUrl());
        dto.setRefundWindowDays(entity.getRefundWindowDays());
        dto.setMaxRefundPercentage(entity.getMaxRefundPercentage());
        dto.setMaxRefundAmount(entity.getMaxRefundAmount());
        dto.setInvoiceMandatory(entity.getInvoiceMandatory());
        dto.setReceiptMandatory(entity.getReceiptMandatory());
        dto.setIsActive(entity.getIsActive());

        return dto;
    }

    public void updateEntityFromDTO(FinancialSettingsRequestDTO dto, InstituteFinancialSettings entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setCurrencyId(dto.getCurrencyId());
        entity.setFeeRecurrenceRuleId(dto.getFeeRecurrenceRuleId());
        entity.setLanguageId(dto.getLanguageId());
        entity.setLocale(dto.getLocale());
        entity.setAllowPartialPayments(dto.getAllowPartialPayments() != null ? dto.getAllowPartialPayments() : false);
        entity.setLateFeeApplicable(dto.getLateFeeApplicable() != null ? dto.getLateFeeApplicable() : false);
        entity.setLateFeeType(dto.getLateFeeType());
        entity.setLateFeeValue(dto.getLateFeeValue());
        entity.setTaxApplicable(dto.getTaxApplicable() != null ? dto.getTaxApplicable() : false);
        entity.setTaxTypeId(dto.getTaxTypeId());
        entity.setTaxIncludedInFee(dto.getTaxIncludedInFee() != null ? dto.getTaxIncludedInFee() : false);
        entity.setRefundsAllowed(dto.getRefundsAllowed() != null ? dto.getRefundsAllowed() : false);
        entity.setRefundPolicyUrl(dto.getRefundPolicyUrl());
        entity.setRefundWindowDays(dto.getRefundWindowDays());
        entity.setMaxRefundPercentage(dto.getMaxRefundPercentage());
        entity.setMaxRefundAmount(dto.getMaxRefundAmount());
        entity.setInvoiceMandatory(dto.getInvoiceMandatory() != null ? dto.getInvoiceMandatory() : false);
        entity.setReceiptMandatory(dto.getReceiptMandatory() != null ? dto.getReceiptMandatory() : true);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
    }
}
