package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.academic.dto.request.BulkExamWeightageRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.ExamWeightageRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamWeightageResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StandardSubjectEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.ExamWeightageRepository;
import com.smartsolutions.eschool.academic.repository.StandardSubjectRepository;
import com.smartsolutions.eschool.academic.service.ExamWeightageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamWeightageServiceImpl implements ExamWeightageService {

    private final ExamWeightageRepository weightageRepository;
    private final StandardSubjectRepository standardSubjectRepository;

    @Override
    @Transactional
    public void saveWeightages(List<ExamWeightageRequestDTO> dtos) {
        for (ExamWeightageRequestDTO dto : dtos) {
            ExamWeightageEntity entity = ResultsMapper.toEntity(dto);
            weightageRepository.save(entity);
        }
    }

    @Override
    @Transactional
    public void saveBulkWeightages(BulkExamWeightageRequestDTO dto) {
        log.info("Bulk saving weightages for year: {}, standard: {}, term: {}",
                dto.getAcademicYearId(), dto.getStandardId(), dto.getExamTermId());

        // 1. Soft delete existing weightages for this year/standard/term
        weightageRepository.bulkSoftDelete(dto.getAcademicYearId(), dto.getStandardId(), dto.getExamTermId());

        // 2. Prepare new entities
        List<ExamWeightageEntity> entities = new ArrayList<>();
        for (BulkExamWeightageRequestDTO.SubjectWeightageDTO sw : dto.getWeightages()) {
            // Find standard subject mapping
            StandardSubjectEntity standardSubject = standardSubjectRepository
                    .findByStandardSubjectAndYear(dto.getStandardId(), sw.getSubjectId(), dto.getAcademicYearId())
                    .orElseThrow(() -> new ResourceNotFoundException("Subject not found for this standard and year"));

            ExamWeightageRequestDTO requestDTO = new ExamWeightageRequestDTO();
            requestDTO.setAcademicYearId(dto.getAcademicYearId());
            requestDTO.setStandardSubjectId(standardSubject.getId());
            requestDTO.setExamTermId(dto.getExamTermId());
            requestDTO.setWeightPercentage(sw.getWeightPercentage());
            requestDTO.setActive(sw.isActive());

            entities.add(ResultsMapper.toEntity(requestDTO));
        }

        // 3. Save all
        weightageRepository.saveAll(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamWeightageResponseDTO> getByStandard(Long standardId, Long academicYearId) {
        return weightageRepository.findByAcademicYearIdAndStandardId(academicYearId, standardId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }
}
