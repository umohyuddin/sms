package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.ExamSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamSubjectResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.ExamSubjectEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.ExamRepository;
import com.smartsolutions.eschool.academic.repository.ExamSubjectRepository;
import com.smartsolutions.eschool.academic.repository.SubjectRepository;
import com.smartsolutions.eschool.academic.service.ExamSubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamSubjectServiceImpl implements ExamSubjectService {

    private final ExamSubjectRepository examSubjectRepository;
    private final ExamRepository examRepository;
    private final SubjectRepository subjectRepository;
    private final EmployeeMasterRepository employeeRepository;

    @Override
    @Transactional
    public ExamSubjectResponseDTO scheduleSubject(ExamSubjectRequestDTO dto) {
        ExamEntity exam = examRepository.findByIdAndDeletedFalse(dto.getExamId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        SubjectEntity subject = subjectRepository.findActiveById(dto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        ExamSubjectEntity entity = ExamAssessmentMapper.toEntity(dto);
        entity.setExam(exam);
        entity.setSubject(subject);

        if (dto.getEvaluatorId() != null) {
            EmployeeMasterEntity evaluator = employeeRepository.findById(dto.getEvaluatorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Evaluator not found"));
            entity.setEvaluator(evaluator);
        }

        ExamSubjectEntity saved = examSubjectRepository.save(entity);
        return ExamAssessmentMapper.toResponse(saved);
    }

    @Override
    public List<ExamSubjectResponseDTO> getByExam(Long examId) {
        return examSubjectRepository.findByExamId(examId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void unschedule(Long examId, Long subjectId) {
        ExamSubjectEntity entity = examSubjectRepository.findByExamAndSubject(examId, subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Subject assignment not found"));
        examSubjectRepository.softDeleteById(entity.getId());
    }
}
