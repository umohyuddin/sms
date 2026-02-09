package com.smartsolutions.sms.academic.dto.request;

import com.smartsolutions.sms.academic.entity.master.ExamEntity;
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
    
    @NotNull
    private Long sectionId;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotNull
    private LocalDate startDate;
    
    @NotNull
    private LocalDate endDate;
    
    private ExamEntity.ExamStatus status = ExamEntity.ExamStatus.DRAFT;
    private boolean active = true;
}
