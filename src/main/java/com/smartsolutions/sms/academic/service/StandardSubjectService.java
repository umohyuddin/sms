package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.sms.academic.dto.response.StandardSubjectResponseDTO;

import java.util.List;

public interface StandardSubjectService {
    StandardSubjectResponseDTO assign(StandardSubjectRequestDTO dto);
    List<StandardSubjectResponseDTO> getByStandardAndYear(Long standardId, Long academicYearId);
    void unassign(Long standardId, Long subjectId, Long academicYearId);
}
