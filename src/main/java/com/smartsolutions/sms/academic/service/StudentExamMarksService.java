package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.StudentExamMarksRequestDTO;
import com.smartsolutions.sms.academic.dto.response.StudentExamMarksResponseDTO;

import java.util.List;

public interface StudentExamMarksService {
    void recordMarks(List<StudentExamMarksRequestDTO> dtos);
    List<StudentExamMarksResponseDTO> getByExamSubject(Long examSubjectId);
    List<StudentExamMarksResponseDTO> getStudentMarks(Long studentId, Long examId);
}
