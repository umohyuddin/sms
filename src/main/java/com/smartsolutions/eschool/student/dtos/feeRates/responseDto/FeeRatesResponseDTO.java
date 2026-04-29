package com.smartsolutions.eschool.student.dtos.feeRates.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// =======================
// MAIN RESPONSE DTO
// =======================
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing detailed fee rate definitions")
public class FeeRatesResponseDTO {

    @Schema(description = "Unique identifier of the fee rate record", example = "100")
    private Long id;

    @Schema(description = "System-generated or manual code for the rate", example = "RATE-TUI-05")
    private String code;

    @Schema(description = "Name of the rate definition", example = "Standard 5 Tuition Rate")
    private String name;

    @Schema(description = "Description of the rate", example = "Monthly tuition fee for Grade 5 students")
    private String description;

    @Schema(description = "Fixed monetary amount", example = "5000.00")
    private BigDecimal fixedAmount;

    @Schema(description = "Percentage value for the fee", example = "10.0")
    private BigDecimal percentageValue;

    @Schema(description = "Price per unit if volume-based", example = "0.00")
    private BigDecimal unitPrice;

    @Schema(description = "Details of the component on which percentage is calculated")
    private FeeComponentDTO percentageOfComponent;

    @Schema(description = "Details of the slab group if applicable")
    private SlabGroupDTO slabGroup;

    @Schema(description = "Charge type details")
    private ChargeTypeDTO chargeType;

    @Schema(description = "Priority for rate application", example = "1")
    private Integer priority;

    @Schema(description = "Currency of the rate", example = "PKR")
    private String currency;

    @Schema(description = "Start date of validity", example = "2024-04-01")
    private LocalDate effectiveFrom;

    @Schema(description = "End date of validity", example = "2025-03-31")
    private LocalDate effectiveTo;

    @Schema(description = "Active status of the rate", example = "true")
    private boolean active;

    // Child DTOs
    @Schema(description = "Campus where this rate applies")
    private CampusDTO campus;

    @Schema(description = "Grade level (standard) where this rate applies")
    private StandardDTO standard;

    @Schema(description = "Associated fee component")
    private FeeComponentDTO feeComponent;

    @Schema(description = "Associated academic year")
    private AcademicYearDTO academicYear;

    // =======================
    // CHILD DTO: SLAB GROUP
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Nested DTO for Slab Group details within Fee Rate")
    public static class SlabGroupDTO {
        @Schema(description = "ID of the slab group", example = "1")
        private Long id;
        @Schema(description = "Name of the slab group", example = "Volume Tiers")
        private String name;
        @Schema(description = "Code of the slab group", example = "SLB-01")
        private String code;
    }

    // =======================
    // CHILD DTO: CHARGE TYPE
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Nested DTO for Charge Type details")
    public static class ChargeTypeDTO {
        @Schema(description = "ID of the charge type", example = "2")
        private Long id;
        @Schema(description = "Internal code", example = "MONTHLY")
        private String code;
        @Schema(description = "Display name", example = "Monthly Charge")
        private String name;
    }

    // =======================
    // CHILD DTO: CAMPUS
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CampusDTO {
        private Long id;
        private String campusName;
        private String campusCode;
        private String contactNumber;
        private String email;
        private String website;
        private String address;
        private boolean active;
    }

    // =======================
    // CHILD DTO: STANDARD
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StandardDTO {
        private Long id;
        private String standardName;
        private String standardCode;
        private String description;
    }

    // =======================
    // CHILD DTO: FEE COMPONENT
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeeComponentDTO {
        private Long id;
        private String componentCode;
        private String componentName;
        private String accountCode;
        private boolean taxable;
        private boolean discountable;
        // Add FeeCatalog here
        private FeeCatalogDTO feeCatalog;

        private ChargeTypeDTO chargeType;
        private RecurrenceRuleDTO recurrenceRule;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class FeeCatalogDTO {
            private Long id;
            private String code;
            private String name;
            private String description;
            private boolean active;
            private String chargeType;
            private String chargeTypeLabel;
            private String recurrenceRule;
            private String recurrenceRuleLabel;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class RecurrenceRuleDTO {
            private Long id;
            private String code;
            private String name;
        }
    }

    // =======================
    // CHILD DTO: ACADEMIC YEAR
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Nested DTO for Academic Year details")
    public static class AcademicYearDTO {
        @Schema(description = "ID of the academic year", example = "1")
        private Long id;
        @Schema(description = "Display name", example = "2024-2025")
        private String name;
        @Schema(description = "Start date", example = "2024-04-01")
        private LocalDate startDate;
        @Schema(description = "End date", example = "2025-03-31")
        private LocalDate endDate;
        @Schema(description = "Current active year flag", example = "true")
        private Boolean isCurrent;
        @Schema(description = "Total number of months in the year", example = "12")
        private long totalMonths;
    }
}
