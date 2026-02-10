package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.AssessmentTypeRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.AssessmentTypeResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.AssessmentTypeEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.AssessmentTypeRepository;
import com.smartsolutions.eschool.academic.service.AssessmentTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssessmentTypeServiceImpl implements AssessmentTypeService {

    private final AssessmentTypeRepository assessmentTypeRepository;
    private final ExamAssessmentMapper examMapper;

    @Override
    @Transactional
    public AssessmentTypeResponseDTO create(AssessmentTypeRequestDTO dto) {
        AssessmentTypeEntity entity = examMapper.toEntity(dto);
        return examMapper.toResponse(assessmentTypeRepository.save(entity));
    }

    @Override
    @Transactional
    public AssessmentTypeResponseDTO update(Long id, AssessmentTypeRequestDTO dto) {
        AssessmentTypeEntity entity = assessmentTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment Type not found"));
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
        return examMapper.toResponse(assessmentTypeRepository.save(entity));
    }

    @Override
    public List<AssessmentTypeResponseDTO> getAllActive() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return assessmentTypeRepository.findAllActiveByOrg(orgId).stream()
                .map(examMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!assessmentTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assessment Type not found");
        }
        assessmentTypeRepository.softDeleteById(id);
    }
}
