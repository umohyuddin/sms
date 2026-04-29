package com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response object containing detailed fee component information")
public class FeeComponentResponseDTO {
    @Schema(description = "Unique identifier of the fee component linkage", example = "10")
    private Long id;

    @Schema(description = "ID of the associated fee catalog", example = "1")
    private Long feeCatalogId;  // Relation to FeeCatalog

    @Schema(description = "Internal code of the fee component", example = "TUI-01")
    private String componentCode;

    @Schema(description = "User-friendly name of the fee component", example = "Monthly Tuition")
    private String componentName;

    @Schema(description = "GL account code for financial tracking", example = "400101")
    private String accountCode;

    @Schema(description = "Status indicating if this component attract taxes", example = "false")
    private boolean taxable;

    @Schema(description = "Status indicating if this component is active", example = "true")
    private boolean active;

    @Schema(description = "Status indicating if this component is discountable", example = "true")
    private boolean discountable;

    @Schema(description = "Details of the associated fee catalog")
    private FeeCatalogDTO feeCatalog;

    // Related FeeCatalog properties
    @Schema(description = "Associated charge type details")
    private ChargeTypeResponseDTO chargeType;

    @Schema(description = "Associated recurrence rule details")
    private FeeRecurrenceRuleResponseDTO recurrenceRule;

    @Schema(description = "Associated institute details")
    private InstituteResponseDTO institute;
}
