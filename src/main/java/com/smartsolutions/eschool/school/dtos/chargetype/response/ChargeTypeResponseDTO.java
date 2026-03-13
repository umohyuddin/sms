package com.smartsolutions.eschool.school.dtos.chargetype.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChargeTypeResponseDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean active;
}
