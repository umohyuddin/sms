package com.smartsolutions.eschool.employee.dtos.PayRollPeriod.response;

import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PayrollPeriodResponseDTO {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private PayrollPeriodEntity.PayrollStatus status;

    private String description;

    private Boolean deleted;
}
