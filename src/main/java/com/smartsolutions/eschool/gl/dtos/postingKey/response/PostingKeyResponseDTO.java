package com.smartsolutions.eschool.gl.dtos.postingKey.response;

import com.smartsolutions.eschool.gl.enums.BalanceSide;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Response object for GL Posting Key")
public class PostingKeyResponseDTO {

    @Schema(description = "Unique ID", example = "1")
    private Long id;

    @Schema(description = "Unique code", example = "40")
    private String code;

    @Schema(description = "Name", example = "Debit Entry")
    private String name;

    @Schema(description = "Account Side", example = "DEBIT")
    private BalanceSide accountSide;

    @Schema(description = "Description", example = "Standard debit posting key")
    private String description;

    @Schema(description = "Status", example = "true")
    private boolean active;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;
}
