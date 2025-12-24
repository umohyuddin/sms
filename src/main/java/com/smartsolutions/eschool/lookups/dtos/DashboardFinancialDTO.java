package com.smartsolutions.eschool.lookups.dtos;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardFinancialDTO {
    private double assignedMonthlyFee;
    private double collectedMonthlyFee;
    private double outstandingMonthlyFee;
    private double collectionPercentageMonthlyFee;
    private String monthName;

    private double assignedYearlyFee;
    private double collectedYearlyFee;
    private double outstandingYearlyFee;
    private double collectionPercentageYearlyFee;
    private String academicYearName;
}
