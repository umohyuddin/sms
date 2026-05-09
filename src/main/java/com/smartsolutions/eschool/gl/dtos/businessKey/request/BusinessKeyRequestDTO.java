package com.smartsolutions.eschool.gl.dtos.businessKey.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Request object for creating or updating a GL Business Key")
public class BusinessKeyRequestDTO {

    @NotBlank(message = "Code is required")
    @Schema(description = "Unique code for the business key", example = "STUDENT_FEE")
    private String code;

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the business key", example = "Student Fee Posting")
    private String name;

    @Schema(description = "Associated module", example = "Fee")
    private String module;

    @Schema(description = "Detailed description", example = "Key for automated fee postings")
    private String description;

    @Schema(description = "Status", example = "true")
    private boolean active = true;
}
