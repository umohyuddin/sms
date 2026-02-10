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
    private final ExamAssessmentMapper examMapper;

    @Override
    @Transactional
    public ExamTermResponseDTO create(ExamTermRequestDTO dto) {
        AcademicYearEntity year = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found"));
        ExamTermEntity entity = examMapper.toEntity(dto);
        entity.setAcademicYear(year);
        return examMapper.toResponse(examTermRepository.save(entity));
    }

    @Override
    @Transactional
    public ExamTermResponseDTO update(Long id, ExamTermRequestDTO dto) {
        ExamTermEntity entity = examTermRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Term not found"));
        entity.setName(dto.getName());
        entity.setSequenceNo(dto.getSequenceNo());
        entity.setActive(dto.isActive());
        return examMapper.toResponse(examTermRepository.save(entity));
    }

    @Override
    public List<ExamTermResponseDTO> getActiveByYear(Long academicYearId) {
        return examTermRepository.findByAcademicYear(academicYearId).stream()
                .map(examMapper::toResponse)
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
