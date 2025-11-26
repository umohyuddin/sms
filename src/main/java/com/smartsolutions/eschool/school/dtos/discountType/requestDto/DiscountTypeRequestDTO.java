package com.smartsolutions.eschool.school.dtos.discountType.requestDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeRequestDTO {

    private Long id;
    private String name; // e.g., "2024-2025"
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isCurrent;
}
