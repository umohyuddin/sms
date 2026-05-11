package com.smartsolutions.eschool.gl.dtos.accounts.requestDto;

import com.smartsolutions.eschool.gl.enums.AccountType;
import com.smartsolutions.eschool.gl.enums.BalanceSide;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a GL account")
public class GLAccountCreateRequestDTO {
    
    @Schema(description = "Unique identifier of the GL account (only for updates)", example = "1")
    private Long id;

    @Schema(description = "ID of the associated campus (optional)", example = "1")
    private Long campusId;

    @NotBlank(message = "Account code is required")
    @Schema(description = "Unique code for the account", example = "1111")
    private String accountCode;

    @NotBlank(message = "Account name is required")
    @Schema(description = "Name of the account", example = "Cash in Hand")
    private String accountName;

    @Schema(description = "ID of the parent account (optional)", example = "10")
    private Long parentId;

    @NotNull(message = "Account type is required")
    @Schema(description = "Type of account", example = "ASSET")
    private AccountType accountType;

    @Schema(description = "Whether this is a group account", example = "false")
    private boolean isGroup;

    @Schema(description = "Whether this is a control account", example = "false")
    private boolean isControlAccount;

    @Schema(description = "Whether this is a cash account", example = "true")
    private boolean isCashAccount;

    @Schema(description = "Whether this is a bank account", example = "false")
    private boolean isBankAccount;

    @Schema(description = "Whether this is reconcilable", example = "false")
    private boolean isReconcilable;

    @NotNull(message = "Normal balance side is required")
    @Schema(description = "Normal balance side (DEBIT/CREDIT)", example = "DEBIT")
    private BalanceSide normalBalance;

    @Schema(description = "Currency code", example = "PKR")
    private String currencyCode;

    @Schema(description = "Whether the account is active", example = "true")
    private boolean active = true;
}
