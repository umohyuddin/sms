package com.smartsolutions.eschool.school.dtos.instituteFinancialSettings.responseDto;

import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFinancialSettingsResponseDTO {
    
    private Long id;
    private Long instituteId;
    private AcademicYearResponseDTO academicYear;

    private FeeRecurrenceRuleResponseDTO feeRecurrenceRule;
    
    private CurrencyResponseDTO currency;
    private LanguageResponseDTO language;
    private String locale;
    
    private String feeFrequency;
    private Boolean allowPartialPayments;
    private String lateFeeType;
    private BigDecimal lateFeeAmount;
    
    private Boolean isTaxApplicable;
    private TaxTypeResponseDTO taxType;
    private Boolean isTaxInclusive;
    
    private Boolean allowRefunds;
    private String refundPolicyUrl;
    private Integer refundWindowDays;
    private BigDecimal refundPercentage;
    private BigDecimal refundFixedAmount;
    
    private Boolean invoiceMandatory;
    private Boolean receiptMandatory;
    private Boolean isActive;
}
