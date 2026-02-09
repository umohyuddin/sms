package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.sms.academic.dto.request.GradeScaleRequestDTO;
import com.smartsolutions.sms.academic.dto.response.GradeScaleResponseDTO;
import com.smartsolutions.sms.academic.entity.master.GradeScaleEntity;
import com.smartsolutions.sms.academic.mapper.ResultsMapper;
import com.smartsolutions.sms.academic.repository.GradeScaleRepository;
import com.smartsolutions.sms.academic.service.GradeScaleService;
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
    private final ResultsMapper resultsMapper;

    @Override
    @Transactional
    public GradeScaleResponseDTO create(GradeScaleRequestDTO dto) {
        GradeScaleEntity entity = resultsMapper.toEntity(dto);
        return resultsMapper.toResponse(gradeScaleRepository.save(entity));
    }

    @Override
    @Transactional
    public GradeScaleResponseDTO update(Long id, GradeScaleRequestDTO dto) {
        GradeScaleEntity entity = gradeScaleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grade Scale not found"));
        entity.setGrade(dto.getGrade());
        entity.setMinPercentage(dto.getMinPercentage());
        entity.setMaxPercentage(dto.getMaxPercentage());
        entity.setRemarks(dto.getRemarks());
        return resultsMapper.toResponse(gradeScaleRepository.save(entity));
    }

    @Override
    public List<GradeScaleResponseDTO> getAllActive() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return gradeScaleRepository.findAllActiveByOrg(orgId).stream()
                .map(resultsMapper::toResponse)
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
