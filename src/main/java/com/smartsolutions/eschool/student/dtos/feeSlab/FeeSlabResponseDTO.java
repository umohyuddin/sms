package com.smartsolutions.eschool.student.dtos.feeSlab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeSlabResponseDTO {
    private Long id;
    private Long slabGroupId;
    private String slabGroupName;
    private BigDecimal minValue;
    private BigDecimal maxValue;
    private BigDecimal amount;
    private String currency;
    private boolean active;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
