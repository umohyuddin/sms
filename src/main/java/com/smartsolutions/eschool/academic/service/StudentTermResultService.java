package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.StudentTermResultRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentTermResultResponseDTO;

import java.util.List;

public interface StudentTermResultService {
    void processResults(Long standardId, Long sectionId, Long examTermId);
    List<StudentTermResultResponseDTO> getSectionResults(Long standardId, Long sectionId, Long examTermId);
    StudentTermResultResponseDTO getStudentResult(Long studentId, Long examTermId);
}
