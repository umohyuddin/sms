package com.smartsolutions.eschool.academic.dto.response;

import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentExamAttendanceResponseDTO {
    Long id;
    Long studentId;
    String studentName;
    Long examSubjectId;
    StudentExamAttendanceEntity.AttendanceStatus status;
}
