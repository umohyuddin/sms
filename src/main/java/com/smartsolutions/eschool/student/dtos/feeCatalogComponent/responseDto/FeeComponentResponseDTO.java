package com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto;

import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeComponentResponseDTO {
    private Long id;
    private Long feeCatalogId;  // Relation to FeeCatalog
    private String componentCode;
    private String componentName;
    private String accountCode;
    private boolean taxable;
    private boolean active;
    private boolean discountable;
    private FeeCatalogDTO feeCatalog;

}
