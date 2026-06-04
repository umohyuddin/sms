package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.StudentAssessmentRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAssessmentResponseDTO;

import java.util.List;

public interface StudentAssessmentService {
    void submitAssessment(StudentAssessmentRequestDTO dto);
    void evaluateAssessment(StudentAssessmentRequestDTO dto);
    List<StudentAssessmentResponseDTO> getByAssessment(Long assessmentId);
    List<StudentAssessmentResponseDTO> getByStudent(Long studentId);
}
