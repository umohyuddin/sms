package com.smartsolutions.eschool.lookups.dtos;


import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardFinancialDTO {
    private BigDecimal assignedMonthlyFee;
    private BigDecimal collectedMonthlyFee;
    private BigDecimal outstandingMonthlyFee;
    private BigDecimal collectionPercentageMonthlyFee;
    private String monthName;

    private BigDecimal assignedYearlyFee;
    private BigDecimal collectedYearlyFee;
    private BigDecimal outstandingYearlyFee;
    private BigDecimal collectionPercentageYearlyFee;
    private String academicYearName;
}
