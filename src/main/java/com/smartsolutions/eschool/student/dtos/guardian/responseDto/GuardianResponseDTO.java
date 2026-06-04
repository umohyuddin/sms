package com.smartsolutions.eschool.student.dtos.guardian.responseDto;

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
@Schema(description = "Response object for student guardian details")
public class GuardianResponseDTO {
    @Schema(description = "Unique identifier", example = "1")
    private Long id;
    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;
    @Schema(description = "First name", example = "Jane")
    private String firstName;
    @Schema(description = "Middle name", example = "Marie")
    private String middleName;
    @Schema(description = "Last name", example = "Doe")
    private String lastName;
    @Schema(description = "Full name", example = "Jane Marie Doe")
    private String fullName;
    @Schema(description = "ID of the relationship type", example = "1")
    private Long relationId;
    @Schema(description = "National ID / CNIC", example = "35201-1234567-8")
    private String cnic;
    @Schema(description = "Primary phone", example = "+923001234567")
    private String phone;
    @Schema(description = "Alternate phone", example = "+923007654321")
    private String alternatePhone;
    @Schema(description = "Email address", example = "jane.doe@example.com")
    private String email;
    @Schema(description = "Occupation", example = "Engineer")
    private String occupation;
    @Schema(description = "Organization", example = "Tech Corp")
    private String organization;
    @Schema(description = "Residential address", example = "123 Street, Lahore")
    private String address;
    @Builder.Default
    @Schema(description = "Active status", example = "true")
    private Boolean isActive = true;
    @Schema(description = "Status text", example = "ACTIVE")
    private String status;
    @Builder.Default
    @Schema(description = "Deleted flag", example = "false")
    private boolean deleted = false;
    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;
    @Schema(description = "Update timestamp")
    private LocalDateTime updatedAt;
}
