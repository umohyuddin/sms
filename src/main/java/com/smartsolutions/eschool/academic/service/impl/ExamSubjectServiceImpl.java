package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.BulkExamSubjectRequestDTO;
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
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamSubjectServiceImpl implements ExamSubjectService {

    private final ExamSubjectRepository examSubjectRepository;
    private final ExamRepository examRepository;
    private final SubjectRepository subjectRepository;
    private final EmployeeMasterRepository employeeRepository;
    private final com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    @Override
    @Transactional
    public ExamSubjectResponseDTO scheduleSubject(ExamSubjectRequestDTO dto) {
        return schedule(dto);
    }

    @Override
    @Transactional
    public List<ExamSubjectResponseDTO> scheduleSubjects(BulkExamSubjectRequestDTO dto) {
        return dto.getAssignments().stream()
                .map(this::schedule)
                .collect(Collectors.toList());
    }

    private ExamSubjectResponseDTO schedule(ExamSubjectRequestDTO dto) {
        ExamEntity exam = examRepository.findByIdAndDeletedFalse(dto.getExamId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        SubjectEntity subject = subjectRepository.findActiveById(dto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        // ✅ Pehle check karo — exist karta hai ya nahi (soft deleted bhi)
        ExamSubjectEntity entity = examSubjectRepository
                .findByExamAndSubject(dto.getExamId(), dto.getSubjectId())
                .orElse(new ExamSubjectEntity());

        // Fields set karo (insert aur update dono ke liye)
        entity.setExam(exam);
        entity.setSubject(subject);
        entity.setExamDate(dto.getExamDate());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setTotalMarks(dto.getTotalMarks());
        entity.setPassingMarks(dto.getPassingMarks());
        entity.setActive(dto.isActive());
        entity.setDeleted(false); // ✅ Soft deleted tha toh reactivate ho jayega

        if (dto.getEvaluatorId() != null) {
            EmployeeMasterEntity evaluator = employeeRepository.findById(dto.getEvaluatorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Evaluator not found"));
            entity.setEvaluator(evaluator);
        } else {
            entity.setEvaluator(null);
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
    public List<ExamSubjectResponseDTO> getByExam(Long examId, Long orgId) {
        log.info("Service: Executing repository query for examId: {}, orgId: {}", examId, orgId);
        List<ExamSubjectEntity> entities = examSubjectRepository.findByExamIdAndOrganizationIdAndDeletedFalse(examId,
                orgId);
        log.info("Service: Found {} entities in repository", entities.size());
        return entities.stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void unschedule(Long examId, Long subjectId) {
        ExamSubjectEntity entity = examSubjectRepository.findByExamAndSubject(examId, subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Subject assignment not found"));
        entityReferenceValidator.ensureNotReferenced(ExamSubjectEntity.class, entity.getId());
        examSubjectRepository.softDeleteById(entity.getId());
    }
}
