package com.smartsolutions.eschool.student.dtos.feeRates.responseDto;

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
public class FeeRatesResponseDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private BigDecimal amount;
    private String currency;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private boolean active;

    // Child DTOs
    private CampusDTO campus;
    private StandardDTO standard;
    private FeeComponentDTO feeComponent;
    private AcademicYearDTO academicYear;

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
    }

    // =======================
    // CHILD DTO: ACADEMIC YEAR
    // =======================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AcademicYearDTO {
        private Long id;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
        private Boolean isCurrent;
        private long totalMonths;
    }
}
