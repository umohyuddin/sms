package com.smartsolutions.eschool.institute.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.entity.InstituteFinancialSettings;
import com.smartsolutions.eschool.institute.enums.RefundType;
import com.smartsolutions.eschool.institute.error.InstituteFinancialSettingsErrors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

public class FinancialSettingsMapper {

    private FinancialSettingsMapper() {
        // prevent instantiation
    }

    public static InstituteFinancialSettings toEntity(FinancialSettingsRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        validateDTO(dto);

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
        entity.setRefundType(dto.getRefundType());
        entity.setMaxRefundPercentage(dto.getMaxRefundPercentage());
        entity.setMaxRefundAmount(dto.getMaxRefundAmount());
        entity.setInvoiceMandatory(dto.getInvoiceMandatory() != null ? dto.getInvoiceMandatory() : false);
        entity.setReceiptMandatory(dto.getReceiptMandatory() != null ? dto.getReceiptMandatory() : true);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setIsDeleted(false);

        return entity;
    }

    public static FinancialSettingsResponseDTO toDTO(InstituteFinancialSettings entity) {
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
        dto.setRefundType(entity.getRefundType());
        dto.setMaxRefundPercentage(entity.getMaxRefundPercentage());
        dto.setMaxRefundAmount(entity.getMaxRefundAmount());
        dto.setInvoiceMandatory(entity.getInvoiceMandatory());
        dto.setReceiptMandatory(entity.getReceiptMandatory());
        dto.setIsActive(entity.getIsActive());
        // dto.setOrganizationId(entity.getOrganizationId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static void updateEntityFromDTO(FinancialSettingsRequestDTO dto, InstituteFinancialSettings entity) {
        if (dto == null || entity == null) {
            return;
        }

        validateDTO(dto);

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
        entity.setRefundType(dto.getRefundType());
        entity.setMaxRefundPercentage(dto.getMaxRefundPercentage());
        entity.setMaxRefundAmount(dto.getMaxRefundAmount());
        entity.setInvoiceMandatory(dto.getInvoiceMandatory() != null ? dto.getInvoiceMandatory() : false);
        entity.setReceiptMandatory(dto.getReceiptMandatory() != null ? dto.getReceiptMandatory() : true);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
    }

    private static void validateDTO(FinancialSettingsRequestDTO dto) {
        if (dto.getInstituteId() == null) {
            throw new ApiException(InstituteFinancialSettingsErrors.INSTITUTE_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
        if (dto.getAcademicYearId() == null) {
            throw new ApiException(InstituteFinancialSettingsErrors.ACADEMIC_YEAR_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        if (Boolean.TRUE.equals(dto.getRefundsAllowed())) {
            if (dto.getRefundType() == null) {
                throw new ApiException(InstituteFinancialSettingsErrors.REFUND_TYPE_REQUIRED, HttpStatus.BAD_REQUEST);
            }
            if (dto.getRefundType() == RefundType.PERCENTAGE && dto.getMaxRefundPercentage() == null) {
                throw new ApiException(InstituteFinancialSettingsErrors.INVALID_REFUND_VALUE,
                        "Refund percentage is required for PERCENTAGE refund type", HttpStatus.BAD_REQUEST);
            }
            if (dto.getRefundType() == RefundType.FIXED && dto.getMaxRefundAmount() == null) {
                throw new ApiException(InstituteFinancialSettingsErrors.INVALID_REFUND_VALUE,
                        "Refund amount is required for FIXED refund type", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
