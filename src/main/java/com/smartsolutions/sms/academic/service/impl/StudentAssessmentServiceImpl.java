package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.sms.academic.dto.request.StudentAssessmentRequestDTO;
import com.smartsolutions.sms.academic.dto.response.StudentAssessmentResponseDTO;
import com.smartsolutions.sms.academic.entity.mapping.StudentAssessmentEntity;
import com.smartsolutions.sms.academic.entity.master.AssessmentEntity;
import com.smartsolutions.sms.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.sms.academic.repository.AssessmentRepository;
import com.smartsolutions.sms.academic.repository.StudentAssessmentRepository;
import com.smartsolutions.sms.academic.service.StudentAssessmentService;
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
    private final ExamAssessmentMapper examMapper;

    @Override
    @Transactional
    public void submitAssessment(StudentAssessmentRequestDTO dto) {
        log.info("Student {} submitting assessment {}", dto.getStudentId(), dto.getAssessmentId());
        
        AssessmentEntity assessment = assessmentRepository.findByIdAndDeletedFalse(dto.getAssessmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
        StudentEntity student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        StudentAssessmentEntity entity = examMapper.toEntity(dto);
        entity.setAssessment(assessment);
        entity.setStudent(student);
        entity.setSubmissionStatus(StudentAssessmentEntity.SubmissionStatus.SUBMITTED);
        
        if (entity.getId().getOrganizationId() == null) {
            entity.getId().setOrganizationId(SecurityUtils.getCurrentOrganizationId());
        }

        studentAssessmentRepository.save(entity);
    }

    @Override
    @Transactional
    public void evaluateAssessment(StudentAssessmentRequestDTO dto) {
        log.info("Evaluating assessment {} for student {}", dto.getAssessmentId(), dto.getStudentId());
        
        StudentAssessmentEntity entity = studentAssessmentRepository.findById(null) // Should use actual composite ID
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
                .map(examMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentAssessmentResponseDTO> getByStudent(Long studentId) {
        return studentAssessmentRepository.findByStudentId(studentId).stream()
                .map(examMapper::toResponse)
                .collect(Collectors.toList());
    }
}
