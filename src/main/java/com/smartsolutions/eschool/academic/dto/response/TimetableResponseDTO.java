package com.smartsolutions.eschool.academic.dto.response;

import com.smartsolutions.eschool.academic.entity.master.TimetableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableResponseDTO {
    private Long id;
    private Long standardId;
    private String standardName;
    private Long sectionId;
    private String sectionName;
    private Long subjectId;
    private String subjectName;
    private Long teacherId;
    private String teacherName;
    private TimetableEntity.DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String room;
    private Long organizationId;
    private Boolean isActive;
}
