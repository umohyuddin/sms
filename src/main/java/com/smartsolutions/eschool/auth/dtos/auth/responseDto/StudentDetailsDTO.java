package com.smartsolutions.eschool.auth.dtos.auth.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Student details for the authenticated user")
public class StudentDetailsDTO {

    @Schema(description = "Student ID if the user is a student", example = "500")
    private Long studentId;

    @Schema(description = "Student code", example = "STU001")
    private String studentCode;
}
