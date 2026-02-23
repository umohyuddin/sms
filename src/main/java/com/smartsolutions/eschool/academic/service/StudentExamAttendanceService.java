package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.StudentExamAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentExamAttendanceResponseDTO;

import java.util.List;

public interface StudentExamAttendanceService {
    List<StudentExamAttendanceResponseDTO> markAttendance(List<StudentExamAttendanceRequestDTO> requests, Long orgId);

    List<StudentExamAttendanceResponseDTO> getAttendanceByExamSubject(Long examSubjectId, Long orgId);
}
