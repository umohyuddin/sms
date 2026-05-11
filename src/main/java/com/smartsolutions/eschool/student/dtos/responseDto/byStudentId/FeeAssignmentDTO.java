package com.smartsolutions.eschool.student.dtos.responseDto.byStudentId;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Individual fee component assignment details")
public class FeeAssignmentDTO {
    @Schema(description = "ID of the applied fee rate", example = "50")
    private Long feeRateId;

    @Schema(description = "ID of the fee component", example = "10")
    private Long componentId;

    @Schema(description = "Display name of the component", example = "Tuition Fee")
    private String componentName;

    @Schema(description = "Assigned amount", example = "5000.00")
    private BigDecimal amount;

    @Schema(description = "Date assigned", example = "2024-04-01")
    private LocalDate assignedDate;

    @Schema(description = "Payment due date", example = "2024-05-15")
    private LocalDate dueDate;
}
