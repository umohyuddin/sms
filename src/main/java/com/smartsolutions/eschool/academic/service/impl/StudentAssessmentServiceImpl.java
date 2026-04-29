package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.StudentAssessmentRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAssessmentResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentAssessmentEntity;
import com.smartsolutions.eschool.academic.entity.master.AssessmentEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.AssessmentRepository;
import com.smartsolutions.eschool.academic.repository.StudentAssessmentRepository;
import com.smartsolutions.eschool.academic.service.StudentAssessmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentAssessmentServiceImpl implements StudentAssessmentService {

    private final StudentAssessmentRepository studentAssessmentRepository;
    private final AssessmentRepository assessmentRepository;
    private final StudentRepository studentRepository;
    private final EmployeeMasterRepository employeeRepository;

    @Override
    @Transactional
    public void submitAssessment(StudentAssessmentRequestDTO dto) {
        log.info("Student {} submitting assessment {}", dto.getStudentId(), dto.getAssessmentId());
        
        AssessmentEntity assessment = assessmentRepository.findByIdAndDeletedFalse(dto.getAssessmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
        StudentEntity student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        StudentAssessmentEntity entity = ExamAssessmentMapper.toEntity(dto);
        entity.setAssessment(assessment);
        entity.setStudent(student);
        entity.setSubmissionStatus(StudentAssessmentEntity.SubmissionStatus.SUBMITTED);
        
        studentAssessmentRepository.save(entity);
    }

    @Override
    @Transactional
    public void evaluateAssessment(StudentAssessmentRequestDTO dto) {
        log.info("Evaluating assessment {} for student {}", dto.getAssessmentId(), dto.getStudentId());
        
        StudentAssessmentEntity entity = studentAssessmentRepository.findByAssessmentIdAndStudentId(dto.getAssessmentId(), dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Submission not found"));
        
        entity.setObtainedMarks(dto.getObtainedMarks());
        entity.setGrade(dto.getGrade());
        entity.setRemarks(dto.getRemarks());
        entity.setSubmissionStatus(StudentAssessmentEntity.SubmissionStatus.GRADED);
        
        if (dto.getEvaluatedById() != null) {
            EmployeeMasterEntity evaluator = employeeRepository.findById(dto.getEvaluatedById())
                    .orElseThrow(() -> new ResourceNotFoundException("Evaluator not found"));
            entity.setEvaluatedBy(evaluator);
        }
        
        studentAssessmentRepository.save(entity);
    }

    @Override
    public List<StudentAssessmentResponseDTO> getByAssessment(Long assessmentId) {
        return studentAssessmentRepository.findByAssessmentId(assessmentId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentAssessmentResponseDTO> getByStudent(Long studentId) {
        return studentAssessmentRepository.findByStudentId(studentId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }
}
