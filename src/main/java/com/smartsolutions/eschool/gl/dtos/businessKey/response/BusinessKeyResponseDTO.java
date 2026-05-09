package com.smartsolutions.eschool.gl.dtos.businessKey.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Response object for GL Business Key")
public class BusinessKeyResponseDTO {

    @Schema(description = "Unique ID", example = "1")
    private Long id;

    @Schema(description = "Unique code", example = "STUDENT_FEE")
    private String code;

    @Schema(description = "Name", example = "Student Fee Posting")
    private String name;

    @Schema(description = "Module", example = "Fee")
    private String module;

    @Schema(description = "Description", example = "Key for automated fee postings")
    private String description;

    @Schema(description = "Status", example = "true")
    private boolean active;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;
}
