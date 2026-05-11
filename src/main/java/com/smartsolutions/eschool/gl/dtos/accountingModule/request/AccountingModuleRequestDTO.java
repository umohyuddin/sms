package com.smartsolutions.eschool.gl.dtos.accountingModule.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Request object for creating or updating an Accounting Module")
public class AccountingModuleRequestDTO {

    @NotBlank(message = "Code is required")
    @Schema(description = "Unique code for the module", example = "FEE")
    private String code;

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the module", example = "Student Fees")
    private String name;

    @Schema(description = "Detailed description", example = "Module for handling all fee related postings")
    private String description;

    @Schema(description = "Status", example = "true")
    private boolean active = true;
}
