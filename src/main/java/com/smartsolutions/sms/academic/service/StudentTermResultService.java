package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.StudentTermResultRequestDTO;
import com.smartsolutions.sms.academic.dto.response.StudentTermResultResponseDTO;

import java.util.List;

public interface StudentTermResultService {
    void processResults(Long standardId, Long sectionId, Long examTermId);
    List<StudentTermResultResponseDTO> getSectionResults(Long standardId, Long sectionId, Long examTermId);
    StudentTermResultResponseDTO getStudentResult(Long studentId, Long examTermId);
}
