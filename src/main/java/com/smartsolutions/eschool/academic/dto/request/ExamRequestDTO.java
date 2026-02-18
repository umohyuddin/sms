package com.smartsolutions.eschool.academic.dto.request;

import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamRequestDTO {
    private Long id;

    @NotNull
    private Long academicYearId;

    @NotNull
    private Long examTermId;

    @NotNull
    private Long campusId;

    @NotNull
    private Long standardId;

    private Long sectionId;

    private String commonName;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private ExamEntity.ExamStatus status = ExamEntity.ExamStatus.DRAFT;
    private boolean active = true;

    private java.util.List<SelectedSectionDTO> selectedSections;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SelectedSectionDTO {
        private Long sectionId;
        private String sectionName;
        private boolean selected;
        private String examName;
        private LocalDate startDate;
        private LocalDate endDate;
        private ExamEntity.ExamStatus status;
    }
}
