package com.smartsolutions.eschool.academic.dto.request;

import com.smartsolutions.eschool.academic.entity.master.TimetableEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableRequestDTO {
    private Long id;
    
    @NotNull
    private Long standardId;
    
    @NotNull
    private Long sectionId;
    
    @NotNull
    private Long subjectId;
    
    @NotNull
    private Long teacherId;
    
    @NotNull
    private TimetableEntity.DayOfWeek dayOfWeek;
    
    @NotNull
    private LocalTime startTime;
    
    @NotNull
    private LocalTime endTime;
    
    private String room;
}
