package com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "Request object to waive a student's late fee")
public class LateFeeWaiverRequestDTO {

    @NotNull(message = "Invoice ID is required")
    @Schema(description = "ID of the student fee invoice", example = "50001")
    private Long invoiceId;

    @NotNull(message = "Waived amount is required")
    @DecimalMin(value = "0.0", message = "Waived amount cannot be negative")
    @Schema(description = "Amount of late fee to waive", example = "50.00")
    private BigDecimal waivedAmount;

    @NotBlank(message = "Reason for waiver is required")
    @Schema(description = "Reason for waiving the fee", example = "Medical emergency")
    private String reason;
}
