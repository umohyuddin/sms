package com.smartsolutions.eschool.gl.dtos.transactionType.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Response object for GL Transaction Type")
public class TransactionTypeResponseDTO {

    @Schema(description = "Unique ID", example = "1")
    private Long id;

    @Schema(description = "Unique code", example = "FEES")
    private String code;

    @Schema(description = "Name", example = "Student Fees")
    private String name;

    @Schema(description = "Description", example = "All student related fee transactions")
    private String description;

    @Schema(description = "Status", example = "true")
    private boolean active;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;
}
