package com.smartsolutions.eschool.school.dtos.boardMembers.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object for institute board member details")
public class InstituteBoardMemberResponseDTO {

    @Schema(description = "Unique identifier of the board member", example = "1")
    private Long id;

    @Schema(description = "ID of the associated organization", example = "1")
    private Long organizationId;

    @Schema(description = "Name of the associated organization", example = "Smart Academy")
    private String organizationName;

    @Schema(description = "Full name of the board member", example = "John Doe")
    private String fullName;

    @Schema(description = "ID of the assigned role", example = "1")
    private Long roleId;

    @Schema(description = "Name of the assigned role", example = "Chairman")
    private String roleName;

    @Schema(description = "Email address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Contact phone number", example = "+923001234567")
    private String contactNumber;

    @Schema(description = "Start date of the term")
    private LocalDate termStart;

    @Schema(description = "End date of the term")
    private LocalDate termEnd;

    @Schema(description = "Flag to indicate if active")
    private boolean active;

    @Schema(description = "Timestamp when created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when last updated")
    private LocalDateTime updatedAt;
}
