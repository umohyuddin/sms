package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ExamSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamSubjectResponseDTO;

import java.util.List;

public interface ExamSubjectService {
    ExamSubjectResponseDTO scheduleSubject(ExamSubjectRequestDTO dto);
    List<ExamSubjectResponseDTO> getByExam(Long examId);
    void unschedule(Long examId, Long subjectId);
}
