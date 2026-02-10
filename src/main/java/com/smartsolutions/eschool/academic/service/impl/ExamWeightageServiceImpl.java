package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.ExamWeightageRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamWeightageResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.ExamWeightageRepository;
import com.smartsolutions.eschool.academic.service.ExamWeightageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamWeightageServiceImpl implements ExamWeightageService {

    private final ExamWeightageRepository weightageRepository;

    @Override
    @Transactional
    public void saveWeightages(List<ExamWeightageRequestDTO> dtos) {
        for (ExamWeightageRequestDTO dto : dtos) {
            ExamWeightageEntity entity = ResultsMapper.toEntity(dto);
            weightageRepository.save(entity);
        }
    }

    @Override
    public List<ExamWeightageResponseDTO> getByStandard(Long standardId, Long academicYearId) {
        return weightageRepository.findByStandardId(standardId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }
}
