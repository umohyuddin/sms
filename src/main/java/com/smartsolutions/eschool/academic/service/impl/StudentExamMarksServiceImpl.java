package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.academic.dto.request.StudentExamMarksRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentExamMarksResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.ExamSubjectRepository;
import com.smartsolutions.eschool.academic.repository.StudentExamMarksRepository;
import com.smartsolutions.eschool.academic.service.StudentExamMarksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentExamMarksServiceImpl implements StudentExamMarksService {

    private final StudentExamMarksRepository marksRepository;
    private final ExamSubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void recordMarks(List<StudentExamMarksRequestDTO> dtos) {
        for (StudentExamMarksRequestDTO dto : dtos) {
            // Validate presence check would go here...

            StudentExamMarksEntity entity = ResultsMapper.toEntity(dto);
            // organizationId is handled automatically by AuditableEntity
            marksRepository.save(entity);
        }
    }

    @Override
    public List<StudentExamMarksResponseDTO> getByExamSubject(Long examSubjectId) {
        return marksRepository.findByExamSubjectId(examSubjectId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentExamMarksResponseDTO> getStudentMarks(Long studentId, Long examId) {
        return marksRepository.findByStudentIdAndExamId(studentId, examId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }
}
