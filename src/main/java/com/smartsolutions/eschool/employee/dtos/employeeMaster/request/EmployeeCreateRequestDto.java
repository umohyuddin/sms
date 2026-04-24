package com.smartsolutions.eschool.employee.dtos.employeeMaster.request;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class EmployeeCreateRequestDto extends EmployeeMasterRequestDto {

    private Long campusId;
    private Long departmentId;
    private Long designationId;
    private Date assignmentStartDate;
}
