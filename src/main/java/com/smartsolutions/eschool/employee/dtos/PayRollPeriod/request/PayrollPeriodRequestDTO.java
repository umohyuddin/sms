package com.smartsolutions.eschool.employee.dtos.PayRollPeriod.request;

import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PayrollPeriodRequestDTO {

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Status is required")
    private PayrollPeriodEntity.PayrollStatus status;

    private String description;
}
