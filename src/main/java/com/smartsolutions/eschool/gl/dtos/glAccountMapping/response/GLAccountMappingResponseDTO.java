package com.smartsolutions.eschool.gl.dtos.glAccountMapping.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Response object for GL Account Mapping")
public class GLAccountMappingResponseDTO {

    @Schema(description = "Unique ID", example = "1")
    private Long id;

    @Schema(description = "Campus ID", example = "1")
    private Long campusId;

    @Schema(description = "Accounting Module Details")
    private NameCodeDTO accountingModule;

    @Schema(description = "Transaction Type Details")
    private NameCodeDTO transactionType;

    @Schema(description = "Business Key Details")
    private NameCodeDTO businessKey;

    @Schema(description = "Posting Key Details")
    private PostingKeyDetailDTO postingKey;

    @Schema(description = "GL Account Details")
    private GLAccountDetailDTO glAccount;

    @Schema(description = "Priority Order", example = "1")
    private int priorityOrder;

    @Schema(description = "Status", example = "true")
    private boolean active;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;

    @Data
    @Builder
    public static class NameCodeDTO {
        private Long id;
        private String code;
        private String name;
    }

    @Data
    @Builder
    public static class PostingKeyDetailDTO {
        private Long id;
        private String code;
        private String name;
        private String accountSide;
    }

    @Data
    @Builder
    public static class GLAccountDetailDTO {
        private Long id;
        private String accountCode;
        private String accountName;
        private String accountType;
    }
}
