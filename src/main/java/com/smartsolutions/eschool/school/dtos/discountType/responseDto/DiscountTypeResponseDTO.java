package com.smartsolutions.eschool.school.dtos.discountType.responseDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeResponseDTO {

    private Long id;
    private String code;
    private String name;
    private String description;

    private Boolean isActive;
    //private Integer priority;
    //private Integer displayOrder;

}
