package com.smartsolutions.eschool.student.dtos.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeComponentDTO {
    private Long id;
    private Long feeCatalogId;  // Relation to FeeCatalog
    private String componentCode;
    private String componentName;
    private String accountCode;
    private boolean taxable;

    // Optionally, include fee rates IDs (or a separate FeeRateDTO if needed)
//    private List<Long> feeRateIds;
}