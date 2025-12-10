package com.smartsolutions.eschool.school.dtos.discountRate.responseDto;

import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
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
public class DiscountRateFullResponseDTO {


    private Long id;
    private BigDecimal value;
    private Boolean isPercentage;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private Boolean isActive;

    private DiscountSubTypeResponseDTO discountSubType;
    private CampusResponseDTO campus;
    private AcademicYearResponseDTO academicYear;
}
