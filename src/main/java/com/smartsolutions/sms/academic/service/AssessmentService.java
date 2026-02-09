package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.AssessmentRequestDTO;
import com.smartsolutions.sms.academic.dto.response.AssessmentResponseDTO;

import java.util.List;

public interface AssessmentService {
    AssessmentResponseDTO create(AssessmentRequestDTO dto);
    AssessmentResponseDTO update(Long id, AssessmentRequestDTO dto);
    AssessmentResponseDTO getById(Long id);
    List<AssessmentResponseDTO> getByAssignment(Long teacherSubjectAssignmentId);
    void delete(Long id);
}
