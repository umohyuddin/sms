package com.smartsolutions.eschool.school.dtos.departments.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDTO {

    private Long id;

    private String departmentCode;

    private String departmentName;

    private String description;

    private Long parentDepartmentId;
    private String parentDepartmentName;

    private Long headEmployeeId;

    private Boolean active;
}