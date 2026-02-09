package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.ExamSubjectRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ExamSubjectResponseDTO;

import java.util.List;

public interface ExamSubjectService {
    ExamSubjectResponseDTO scheduleSubject(ExamSubjectRequestDTO dto);
    List<ExamSubjectResponseDTO> getByExam(Long examId);
    void unschedule(Long examId, Long subjectId);
}
