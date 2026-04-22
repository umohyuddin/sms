package com.smartsolutions.eschool.school.dtos.departments.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponseDTO {

    private Long id;

    private String departmentCode;

    private String departmentName;

    private String description;

    private Long parentDepartmentId;
    private String parentDepartmentName;

    private Long headEmployeeId;
    private String headEmployeeCode;
    private String headEmployeeName;

    private Boolean active;
    private Boolean deleted;
    private Long organizationId;
    private Long campusId;
    private String campusName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
