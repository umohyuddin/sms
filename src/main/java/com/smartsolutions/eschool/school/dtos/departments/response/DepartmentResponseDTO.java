package com.smartsolutions.eschool.school.dtos.departments.response;

import com.smartsolutions.eschool.school.model.DepartmentEntity;
import lombok.*;

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
    public static DepartmentResponseDTO fromEntity(DepartmentEntity entity) {
        if (entity == null) return null;
        return DepartmentResponseDTO.builder()
                .id(entity.getId())
                .departmentName(entity.getDepartmentName())
                .build();
    }

}