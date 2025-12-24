package com.smartsolutions.eschool.school.dtos.designations.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationResponseDTO {
    private Long id;
    private String designationCode;
    private String designationName;
    private String description;

    // Optional nested department info
    private Long departmentId;
    private String departmentName;

    // Employee Type info
    private Long employeeTypeId;
    private String employeeTypeName;

    private Boolean isActive;
    private Boolean isDeleted;
}
