package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.sms.academic.dto.request.AssessmentRequestDTO;
import com.smartsolutions.sms.academic.dto.response.AssessmentResponseDTO;
import com.smartsolutions.sms.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import com.smartsolutions.sms.academic.entity.master.AssessmentEntity;
import com.smartsolutions.sms.academic.entity.master.AssessmentTypeEntity;
import com.smartsolutions.sms.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.sms.academic.repository.AssessmentRepository;
import com.smartsolutions.sms.academic.repository.AssessmentTypeRepository;
import com.smartsolutions.sms.academic.repository.TeacherSubjectAssignmentRepository;
import com.smartsolutions.sms.academic.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final TeacherSubjectAssignmentRepository assignmentRepository;
    private final AssessmentTypeRepository typeRepository;
    private final AcademicYearRepository yearRepository;
    private final ExamAssessmentMapper examMapper;

    @Override
    @Transactional
    public AssessmentResponseDTO create(AssessmentRequestDTO dto) {
        TeacherSubjectAssignmentEntity assignment = assignmentRepository.findById(dto.getTeacherSubjectAssignmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher assignment not found"));
        AssessmentTypeEntity type = typeRepository.findByIdAndDeletedFalse(dto.getAssessmentTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment Type not found"));
        AcademicYearEntity year = yearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found"));

        AssessmentEntity entity = examMapper.toEntity(dto);
        entity.setTeacherSubjectAssignment(assignment);
        entity.setAssessmentType(type);
        entity.setAcademicYear(year);
        
        return examMapper.toResponse(assessmentRepository.save(entity));
    }

    @Override
    @Transactional
    public AssessmentResponseDTO update(Long id, AssessmentRequestDTO dto) {
        AssessmentEntity entity = assessmentRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
        
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setTotalMarks(dto.getTotalMarks());
        entity.setPassingMarks(dto.getPassingMarks());
        entity.setAssessmentDate(dto.getAssessmentDate());
        entity.setDueDate(dto.getDueDate());
        entity.setPublished(dto.isPublished());
        entity.setActive(dto.isActive());
        
        return examMapper.toResponse(assessmentRepository.save(entity));
    }

    @Override
    public AssessmentResponseDTO getById(Long id) {
        return assessmentRepository.findByIdAndDeletedFalse(id)
                .map(examMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
    }

    @Override
    public List<AssessmentResponseDTO> getByAssignment(Long teacherSubjectAssignmentId) {
        return assessmentRepository.findByAssignmentId(teacherSubjectAssignmentId).stream()
                .map(examMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!assessmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assessment not found");
        }
        assessmentRepository.softDeleteById(id);
    }
}
