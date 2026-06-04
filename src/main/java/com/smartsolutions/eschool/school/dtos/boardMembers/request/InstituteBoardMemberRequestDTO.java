package com.smartsolutions.eschool.school.dtos.boardMembers.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating an institute board member")
public class InstituteBoardMemberRequestDTO {

    @Schema(description = "Unique identifier of the board member", example = "1")
    private Long id;

    @Schema(description = "ID of the associated organization", example = "1")
    private Long organizationId;

    @NotNull(message = "Full name is required")
    @Size(max = 100, message = "Full name must be at most 100 characters")
    @Schema(description = "Full name of the board member", example = "John Doe")
    private String fullName;

    @Schema(description = "ID of the board member role", example = "1")
    private Long roleId;

    @Size(max = 100, message = "Email must be at most 100 characters")
    @Schema(description = "Email address of the board member", example = "john.doe@example.com")
    private String email;

    @Size(max = 20, message = "Contact number must be at most 20 characters")
    @Schema(description = "Contact phone number", example = "+923001234567")
    private String contactNumber;

    @Schema(description = "Start date of the term")
    private LocalDate termStart;

    @Schema(description = "End date of the term")
    private LocalDate termEnd;

    @Schema(description = "Flag to indicate if the board member is active", example = "true")
    private boolean active = true;
}
