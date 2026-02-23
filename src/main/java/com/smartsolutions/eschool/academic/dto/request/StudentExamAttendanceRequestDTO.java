package com.smartsolutions.eschool.academic.dto.request;

import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentExamAttendanceRequestDTO {
    Long studentId;
    Long examSubjectId;
    StudentExamAttendanceEntity.AttendanceStatus status;
}
