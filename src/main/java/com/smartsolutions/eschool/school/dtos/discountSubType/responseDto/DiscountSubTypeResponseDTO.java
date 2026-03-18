package com.smartsolutions.eschool.school.dtos.discountSubType.responseDto;

import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountSubTypeResponseDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private DiscountTypeResponseDTO discountType;
    private Boolean isActive;
    private Integer priority;
    private Integer displayOrder;
}
