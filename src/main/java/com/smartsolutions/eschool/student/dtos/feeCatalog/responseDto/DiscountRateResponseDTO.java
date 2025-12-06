package com.smartsolutions.eschool.student.dtos.feeCatalog.responseDto;

import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRateResponseDTO {
    private Long id;

    private DiscountSubTypeResponseDTO discountSubType; // nested parent

    private Long campusId;
    private String campusName; // optional, for display

    private Long academicYearId;
    private String academicYearName; // optional, for display

    private BigDecimal amount;
    private BigDecimal percentage;
    private Boolean isPercentage;

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    private Boolean isActive;
}
