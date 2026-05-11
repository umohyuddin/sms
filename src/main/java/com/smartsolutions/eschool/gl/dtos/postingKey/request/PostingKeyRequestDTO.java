package com.smartsolutions.eschool.gl.dtos.postingKey.request;

import com.smartsolutions.eschool.gl.enums.BalanceSide;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Request object for creating or updating a GL Posting Key")
public class PostingKeyRequestDTO {

    @NotBlank(message = "Code is required")
    @Schema(description = "Unique code for the posting key", example = "40")
    private String code;

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the posting key", example = "Debit Entry")
    private String name;

    @NotNull(message = "Account side is required")
    @Schema(description = "Side of the entry (DEBIT/CREDIT)", example = "DEBIT")
    private BalanceSide accountSide;

    @Schema(description = "Detailed description", example = "Standard debit posting key")
    private String description;

    @Schema(description = "Status", example = "true")
    private boolean active = true;
}
