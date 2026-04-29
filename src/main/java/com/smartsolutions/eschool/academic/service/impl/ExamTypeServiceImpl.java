package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.ExamTypeRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamTypeResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.ExamTypeEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.ExamTypeRepository;
import com.smartsolutions.eschool.academic.service.ExamTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamTypeServiceImpl implements ExamTypeService {

    private final ExamTypeRepository examTypeRepository;

    @Override
    @Transactional
    public ExamTypeResponseDTO create(ExamTypeRequestDTO dto) {
        ExamTypeEntity entity = ExamAssessmentMapper.toEntity(dto);
        ExamTypeEntity saved = examTypeRepository.save(entity);
        return ExamAssessmentMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public ExamTypeResponseDTO update(Long id, ExamTypeRequestDTO dto) {
        ExamTypeEntity entity = examTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Type not found"));
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setActive(dto.isActive());
        return ExamAssessmentMapper.toResponse(examTypeRepository.save(entity));
    }

    @Override
    public ExamTypeResponseDTO getById(Long id) {
        return examTypeRepository.findByIdAndDeletedFalse(id)
                .map(ExamAssessmentMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Exam Type not found"));
    }

    @Override
    public List<ExamTypeResponseDTO> getAllActive() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return examTypeRepository.findAllActiveByOrg(orgId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExamTypeResponseDTO> searchByKeyword(String keyword) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return examTypeRepository.searchByKeyword(keyword, orgId).stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!examTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exam Type not found");
        }
        examTypeRepository.softDeleteById(id);
    }
}
