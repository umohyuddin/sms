package com.smartsolutions.eschool.gl.dtos.accounts.responseDto;

import com.smartsolutions.eschool.gl.enums.AccountType;
import com.smartsolutions.eschool.gl.enums.BalanceSide;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object containing detailed GL account information")
public class GLAccountResponseDTO {
    
    @Schema(description = "Unique identifier of the GL account", example = "1")
    private Long id;

    @Schema(description = "ID of the associated campus", example = "1")
    private Long campusId;

    @Schema(description = "Account code", example = "1111")
    private String accountCode;

    @Schema(description = "Account name", example = "Cash in Hand")
    private String accountName;

    @Schema(description = "ID of the parent account", example = "10")
    private Long parentId;
    
    @Schema(description = "Name of the parent account")
    private String parentName;

    @Schema(description = "Account type", example = "ASSET")
    private AccountType accountType;

    @Schema(description = "Whether this is a group account", example = "false")
    private boolean isGroup;

    @Schema(description = "Level in the hierarchy", example = "2")
    private int levelNo;

    @Schema(description = "Whether this is a control account", example = "false")
    private boolean isControlAccount;

    @Schema(description = "Whether this is a cash account", example = "true")
    private boolean isCashAccount;

    @Schema(description = "Whether this is a bank account", example = "false")
    private boolean isBankAccount;

    @Schema(description = "Whether this is reconcilable", example = "false")
    private boolean isReconcilable;

    @Schema(description = "Normal balance side", example = "DEBIT")
    private BalanceSide normalBalance;

    @Schema(description = "Currency code", example = "PKR")
    private String currencyCode;

    @Schema(description = "Status indicating if the account is active", example = "true")
    private boolean isActive;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;
}
