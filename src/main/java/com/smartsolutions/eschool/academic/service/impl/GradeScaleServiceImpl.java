package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.GradeScaleRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.GradeScaleResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.GradeScaleEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.GradeScaleRepository;
import com.smartsolutions.eschool.academic.service.GradeScaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GradeScaleServiceImpl implements GradeScaleService {

    private final GradeScaleRepository gradeScaleRepository;

    @Override
    @Transactional
    public GradeScaleResponseDTO create(GradeScaleRequestDTO dto) {
        GradeScaleEntity entity = ResultsMapper.toEntity(dto);
        return ResultsMapper.toResponse(gradeScaleRepository.save(entity));
    }

    @Override
    @Transactional
    public GradeScaleResponseDTO update(Long id, GradeScaleRequestDTO dto) {
        GradeScaleEntity entity = gradeScaleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grade Scale not found"));
        entity.setGrade(dto.getGrade());
        entity.setMinPercentage(dto.getMinPercentage());
        entity.setMaxPercentage(dto.getMaxPercentage());
        entity.setRemarks(dto.getRemarks()); // Entity has 'remarks', not 'description'
        entity.setPoints(dto.getPoints());
        entity.setActive(dto.isActive());
        return ResultsMapper.toResponse(gradeScaleRepository.save(entity));
    }

    @Override
    public GradeScaleResponseDTO getById(Long id) {
        return gradeScaleRepository.findByIdAndDeletedFalse(id)
                .map(ResultsMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Grade Scale not found"));
    }

    @Override
    public List<GradeScaleResponseDTO> getAllActive() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return gradeScaleRepository.findAllByOrgId(orgId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<GradeScaleResponseDTO> searchByKeyword(String keyword) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return gradeScaleRepository.searchByKeyword(keyword, orgId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!gradeScaleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Grade Scale not found");
        }
        gradeScaleRepository.softDeleteById(id);
    }
}
