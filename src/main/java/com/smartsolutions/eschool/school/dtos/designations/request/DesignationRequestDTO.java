package com.smartsolutions.eschool.school.dtos.designations.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationRequestDTO {

    private String designationCode;       // Unique code
    private String designationName;       // Name of the designation
    private String description;           // Optional description
    private Boolean active = true;      // Optional; defaults to true
}
