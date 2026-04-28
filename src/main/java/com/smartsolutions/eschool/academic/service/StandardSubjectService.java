package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.BulkStandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StandardSubjectResponseDTO;

import java.util.List;

public interface StandardSubjectService {
    StandardSubjectResponseDTO assign(StandardSubjectRequestDTO dto);

    List<StandardSubjectResponseDTO> getByStandardAndYear(Long standardId, Long academicYearId);

    void unassign(Long standardId, Long subjectId, Long academicYearId);

    void bulkUnassign(Long standardId, List<Long> subjectIds, Long academicYearId);

    void bulkAssign(BulkStandardSubjectRequestDTO dto);

    StandardSubjectResponseDTO update(Long id, StandardSubjectRequestDTO dto);
}
