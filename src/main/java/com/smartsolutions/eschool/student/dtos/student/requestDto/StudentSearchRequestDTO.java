package com.smartsolutions.eschool.student.dtos.student.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for filtering students")
public class StudentSearchRequestDTO {

    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @Schema(description = "ID of the academic standard (class)", example = "5")
    private Long standardId;

    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "Direct ID search", example = "10")
    private Long studentId;

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Filter by active status", example = "true")
    private Boolean isActive;

    @Schema(description = "Keyword search (name/code)", example = "Arslan")
    private String keyword;
}
