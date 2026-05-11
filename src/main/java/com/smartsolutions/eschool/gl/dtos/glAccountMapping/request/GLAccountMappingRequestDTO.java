package com.smartsolutions.eschool.gl.dtos.glAccountMapping.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Request object for creating or updating a GL Account Mapping")
public class GLAccountMappingRequestDTO {

    @Schema(description = "Campus ID (Optional)", example = "1")
    private Long campusId;

    @NotNull(message = "Accounting Module ID is required")
    @Schema(description = "ID of the Accounting Module", example = "1")
    private Long accountingModuleId;

    @NotNull(message = "Transaction Type ID is required")
    @Schema(description = "ID of the Transaction Type", example = "1")
    private Long transactionTypeId;

    @NotNull(message = "Business Key ID is required")
    @Schema(description = "ID of the Business Key", example = "1")
    private Long businessKeyId;

    @NotNull(message = "Posting Key ID is required")
    @Schema(description = "ID of the Posting Key", example = "1")
    private Long postingKeyId;

    @NotNull(message = "GL Account ID is required")
    @Schema(description = "ID of the GL Account", example = "1")
    private Long glAccountId;

    @Schema(description = "Priority Order", example = "1")
    private int priorityOrder = 1;

    @Schema(description = "Status", example = "true")
    private boolean active = true;
}
