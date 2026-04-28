package com.smartsolutions.eschool.student.dtos.guardian.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a student guardian")
public class GuardianCreateRequestDTO {
    @Schema(description = "Unique ID for updates", example = "1")
    private Long id;

    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @NotNull
    @Schema(description = "First name of the guardian", example = "Jane")
    private String firstName;

    @Schema(description = "Middle name", example = "Marie")
    private String middleName;

    @NotNull
    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @NotNull
    @Schema(description = "Full formal name", example = "Jane Marie Doe")
    private String fullName;

    @NotNull
    @Schema(description = "ID of the relationship type", example = "1")
    private Long relationId;

    @NotNull
    @Schema(description = "National ID / CNIC", example = "35201-1234567-8")
    private String cnic;

    @NotNull
    @Schema(description = "Primary contact phone", example = "+923001234567")
    private String phone;

    @Schema(description = "Secondary phone", example = "+923007654321")
    private String alternatePhone;

    @Schema(description = "Guardian email address", example = "jane.doe@example.com")
    private String email;

    @Schema(description = "Current occupation", example = "Engineer")
    private String occupation;

    @Schema(description = "Employing organization", example = "Tech Corp")
    private String organization;

    @Schema(description = "Residential address", example = "123 Street, Lahore")
    private String address;

    @Schema(description = "Active status", example = "true")
    private Boolean isActive = true;

    @Schema(description = "Status text", example = "ACTIVE")
    private String status;

    @Schema(description = "ID of the linked student", example = "5001")
    private Long studentId;
}
