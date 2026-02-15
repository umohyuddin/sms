package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.academic.dto.request.ExamTermRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamTermResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.ExamTermRepository;
import com.smartsolutions.eschool.academic.service.ExamTermService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamTermServiceImpl implements ExamTermService {

    private final ExamTermRepository examTermRepository;
    private final AcademicYearRepository academicYearRepository;

    @Override
    @Transactional
    public ExamTermResponseDTO create(ExamTermRequestDTO dto) {
        AcademicYearEntity year = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found"));
        ExamTermEntity entity = ExamAssessmentMapper.toEntity(dto);
        entity.setAcademicYear(year);
        return ExamAssessmentMapper.toResponse(examTermRepository.save(entity));
    }

    @Override
    @Transactional
    public ExamTermResponseDTO update(Long id, ExamTermRequestDTO dto) {
        ExamTermEntity entity = examTermRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Term not found"));
        entity.setName(dto.getName());
        entity.setSequenceNo(dto.getSequenceNo());
        entity.setActive(dto.isActive());
        return ExamAssessmentMapper.toResponse(examTermRepository.save(entity));
    }

    @Override
    public ExamTermResponseDTO getById(Long id) {
        return examTermRepository.findByIdAndDeletedFalse(id)
                .map(ExamAssessmentMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Term not found"));
    }

    @Override
    public List<ExamTermResponseDTO> getActiveByYear(Long academicYearId) {
        return examTermRepository.findByAcademicYearId(academicYearId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExamTermResponseDTO> searchByKeyword(String keyword) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        return examTermRepository.searchByKeyword(keyword, orgId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!examTermRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exam Term not found");
        }
        examTermRepository.softDeleteById(id);
    }
}
