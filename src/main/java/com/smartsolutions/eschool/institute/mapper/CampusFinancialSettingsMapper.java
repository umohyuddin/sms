package com.smartsolutions.eschool.institute.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.CampusFinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.CampusFinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.entity.CampusFinancialSettings;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.enums.RefundType;
import com.smartsolutions.eschool.institute.error.CampusFinancialSettingsErrors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

public class CampusFinancialSettingsMapper {

    private CampusFinancialSettingsMapper() {
        // prevent instantiation
    }

    public static CampusFinancialSettings toEntity(CampusFinancialSettingsRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        validateDTO(dto);

        CampusFinancialSettings entity = new CampusFinancialSettings();
        entity.setInstituteId(dto.getInstituteId());
        entity.setCampusId(dto.getCampusId());
        entity.setAcademicYearId(dto.getAcademicYearId());
        entity.setCurrencyId(dto.getCurrencyId());
        entity.setLanguageId(dto.getLanguageId());
        entity.setLocale(dto.getLocale());
        entity.setAllowPartialPayments(dto.getAllowPartialPayments() != null ? dto.getAllowPartialPayments() : false);
        entity.setLateFeeApplicable(dto.getLateFeeApplicable() != null ? dto.getLateFeeApplicable() : false);
        entity.setLateFeeType(dto.getLateFeeType());
        entity.setLateFeeFixedAmount(dto.getLateFeeFixedAmount());
        entity.setLateFeePercentage(dto.getLateFeePercentage());
        entity.setGraceDays(dto.getGraceDays() != null ? dto.getGraceDays() : 0);
        entity.setLateFeeFrequency(dto.getLateFeeFrequency());
        entity.setLateFeeMaxAmount(dto.getLateFeeMaxAmount());
        entity.setLateFeeApplyOn(dto.getLateFeeApplyOn());
        entity.setSendPaymentReminder(dto.getSendPaymentReminder() != null ? dto.getSendPaymentReminder() : false);
        entity.setReminderDaysBeforeDue(dto.getReminderDaysBeforeDue() != null ? dto.getReminderDaysBeforeDue() : 0);
        entity.setTaxTypeId(dto.getTaxTypeId());
        entity.setRefundsAllowed(dto.getRefundsAllowed() != null ? dto.getRefundsAllowed() : false);
        entity.setRefundPolicyUrl(dto.getRefundPolicyUrl());
        entity.setRefundWindowDays(dto.getRefundWindowDays());
        entity.setRefundType(dto.getRefundType());
        entity.setMaxRefundPercentage(dto.getMaxRefundPercentage());
        entity.setMaxRefundAmount(dto.getMaxRefundAmount());
        entity.setInvoiceMandatory(dto.getInvoiceMandatory() != null ? dto.getInvoiceMandatory() : false);
        entity.setReceiptMandatory(dto.getReceiptMandatory() != null ? dto.getReceiptMandatory() : true);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setFeeRecurrenceRuleId(dto.getFeeRecurrenceRuleId());
        entity.setInvoiceGenerationDay(dto.getInvoiceGenerationDay());
        entity.setInvoiceDueDay(dto.getInvoiceDueDay());
        entity.setDeleted(false);

        return entity;
    }

    public static CampusFinancialSettingsResponseDTO toDTO(CampusFinancialSettings entity) {
        if (entity == null) {
            return null;
        }

        CampusFinancialSettingsResponseDTO dto = new CampusFinancialSettingsResponseDTO();
        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstituteId());
        dto.setCampusId(entity.getCampusId());
        dto.setAcademicYearId(entity.getAcademicYearId());
        dto.setCurrencyId(entity.getCurrencyId());
        dto.setLanguageId(entity.getLanguageId());
        dto.setLocale(entity.getLocale());
        dto.setAllowPartialPayments(entity.getAllowPartialPayments());
        dto.setLateFeeApplicable(entity.getLateFeeApplicable());
        dto.setLateFeeType(entity.getLateFeeType());
        dto.setLateFeeFixedAmount(entity.getLateFeeFixedAmount());
        dto.setLateFeePercentage(entity.getLateFeePercentage());
        dto.setGraceDays(entity.getGraceDays());
        dto.setLateFeeFrequency(entity.getLateFeeFrequency());
        dto.setLateFeeMaxAmount(entity.getLateFeeMaxAmount());
        dto.setLateFeeApplyOn(entity.getLateFeeApplyOn());
        dto.setSendPaymentReminder(entity.getSendPaymentReminder());
        dto.setReminderDaysBeforeDue(entity.getReminderDaysBeforeDue());
        dto.setTaxTypeId(entity.getTaxTypeId());
        dto.setRefundsAllowed(entity.getRefundsAllowed());
        dto.setRefundPolicyUrl(entity.getRefundPolicyUrl());
        dto.setRefundWindowDays(entity.getRefundWindowDays());
        dto.setRefundType(entity.getRefundType());
        dto.setMaxRefundPercentage(entity.getMaxRefundPercentage());
        dto.setMaxRefundAmount(entity.getMaxRefundAmount());
        dto.setInvoiceMandatory(entity.getInvoiceMandatory());
        dto.setReceiptMandatory(entity.getReceiptMandatory());
        dto.setIsActive(entity.getIsActive());
        dto.setFeeRecurrenceRuleId(entity.getFeeRecurrenceRuleId());
        dto.setInvoiceGenerationDay(entity.getInvoiceGenerationDay());
        dto.setInvoiceDueDay(entity.getInvoiceDueDay());
        // dto.setOrganizationId(entity.getOrganizationId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static void updateEntityFromDTO(CampusFinancialSettingsRequestDTO dto, CampusFinancialSettings entity) {
        if (dto == null || entity == null) {
            return;
        }

        validateDTO(dto);

        entity.setCurrencyId(dto.getCurrencyId());
        entity.setLanguageId(dto.getLanguageId());
        entity.setLocale(dto.getLocale());
        entity.setAllowPartialPayments(dto.getAllowPartialPayments() != null ? dto.getAllowPartialPayments() : false);
        entity.setLateFeeApplicable(dto.getLateFeeApplicable() != null ? dto.getLateFeeApplicable() : false);
        entity.setLateFeeType(dto.getLateFeeType());
        entity.setLateFeeFixedAmount(dto.getLateFeeFixedAmount());
        entity.setLateFeePercentage(dto.getLateFeePercentage());
        entity.setGraceDays(dto.getGraceDays() != null ? dto.getGraceDays() : 0);
        entity.setLateFeeFrequency(dto.getLateFeeFrequency());
        entity.setLateFeeMaxAmount(dto.getLateFeeMaxAmount());
        entity.setLateFeeApplyOn(dto.getLateFeeApplyOn());
        entity.setSendPaymentReminder(dto.getSendPaymentReminder() != null ? dto.getSendPaymentReminder() : false);
        entity.setReminderDaysBeforeDue(dto.getReminderDaysBeforeDue() != null ? dto.getReminderDaysBeforeDue() : 0);
        entity.setTaxTypeId(dto.getTaxTypeId());
        entity.setRefundsAllowed(dto.getRefundsAllowed() != null ? dto.getRefundsAllowed() : false);
        entity.setRefundPolicyUrl(dto.getRefundPolicyUrl());
        entity.setRefundWindowDays(dto.getRefundWindowDays());
        entity.setRefundType(dto.getRefundType());
        entity.setMaxRefundPercentage(dto.getMaxRefundPercentage());
        entity.setMaxRefundAmount(dto.getMaxRefundAmount());
        entity.setInvoiceMandatory(dto.getInvoiceMandatory() != null ? dto.getInvoiceMandatory() : false);
        entity.setReceiptMandatory(dto.getReceiptMandatory() != null ? dto.getReceiptMandatory() : true);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setFeeRecurrenceRuleId(dto.getFeeRecurrenceRuleId());
        entity.setInvoiceGenerationDay(dto.getInvoiceGenerationDay());
        entity.setInvoiceDueDay(dto.getInvoiceDueDay());
    }

    private static void validateDTO(CampusFinancialSettingsRequestDTO dto) {
        if (dto.getInstituteId() == null) {
            throw new ApiException(CampusFinancialSettingsErrors.INSTITUTE_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
        if (dto.getCampusId() == null) {
            throw new ApiException(CampusFinancialSettingsErrors.CAMPUS_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
        if (dto.getAcademicYearId() == null) {
            throw new ApiException(CampusFinancialSettingsErrors.ACADEMIC_YEAR_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        if (Boolean.TRUE.equals(dto.getRefundsAllowed())) {
            if (dto.getRefundType() == null) {
                throw new ApiException(CampusFinancialSettingsErrors.REFUND_TYPE_REQUIRED, HttpStatus.BAD_REQUEST);
            }
            if (dto.getRefundType() == RefundType.PERCENTAGE && dto.getMaxRefundPercentage() == null) {
                throw new ApiException(CampusFinancialSettingsErrors.INVALID_REFUND_VALUE,
                        "Refund percentage is required for PERCENTAGE refund type", HttpStatus.BAD_REQUEST);
            }
            if (dto.getRefundType() == RefundType.FIXED && dto.getMaxRefundAmount() == null) {
                throw new ApiException(CampusFinancialSettingsErrors.INVALID_REFUND_VALUE,
                        "Refund amount is required for FIXED refund type", HttpStatus.BAD_REQUEST);
            }
        }
        if (Boolean.TRUE.equals(dto.getLateFeeApplicable())) {
            if (dto.getLateFeeType() == null) {
                throw new ApiException(CampusFinancialSettingsErrors.LATE_FEE_TYPE_REQUIRED, HttpStatus.BAD_REQUEST);
            }
            if (dto.getLateFeeType() == LateFeeType.PERCENTAGE && dto.getLateFeePercentage() == null) {
                throw new ApiException(CampusFinancialSettingsErrors.INVALID_LATE_FEE_VALUE,
                        "Late fee percentage is required for PERCENTAGE late fee type", HttpStatus.BAD_REQUEST);
            }
            if (dto.getLateFeeType() == LateFeeType.FIXED && dto.getLateFeeFixedAmount() == null) {
                throw new ApiException(CampusFinancialSettingsErrors.INVALID_LATE_FEE_VALUE,
                        "Late fee amount is required for FIXED late fee type", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
