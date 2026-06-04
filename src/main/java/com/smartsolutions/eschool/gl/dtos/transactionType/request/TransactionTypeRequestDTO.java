package com.smartsolutions.eschool.gl.dtos.transactionType.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Request object for creating or updating a GL Transaction Type")
public class TransactionTypeRequestDTO {

    @NotBlank(message = "Code is required")
    @Schema(description = "Unique code for the transaction type", example = "FEES")
    private String code;

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the transaction type", example = "Student Fees")
    private String name;

    @Schema(description = "Detailed description", example = "All student related fee transactions")
    private String description;

    @Schema(description = "Whether the transaction type is active", example = "true")
    private boolean active = true;
}
