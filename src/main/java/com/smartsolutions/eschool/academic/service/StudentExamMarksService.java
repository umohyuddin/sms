package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.StudentExamMarksRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentExamMarksResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentMarkEntryResponseDTO;

import java.util.List;

public interface StudentExamMarksService {
    void recordMarks(List<StudentExamMarksRequestDTO> dtos);

    List<StudentExamMarksResponseDTO> getByExamSubject(Long examSubjectId);

    List<StudentExamMarksResponseDTO> getStudentMarks(Long studentId, Long examId);

    List<StudentMarkEntryResponseDTO> getStudentsForMarkEntry(Long examSubjectId);
}
