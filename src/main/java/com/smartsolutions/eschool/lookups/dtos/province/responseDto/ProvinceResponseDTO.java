package com.smartsolutions.eschool.lookups.dtos.province.responseDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceResponseDTO {
//--
    private Long id;
    private String code;
    private String name;
    private String description;

    private Boolean isActive;
    //private Integer priority;
    //private Integer displayOrder;

}
