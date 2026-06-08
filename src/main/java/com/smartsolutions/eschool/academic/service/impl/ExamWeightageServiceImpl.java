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
import com.smartsolutions.eschool.academic.repository.ExamSubjectRepository;
import com.smartsolutions.eschool.academic.service.ExamWeightageService;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.ErrorCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    private final ExamSubjectRepository examSubjectRepository;

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

        // Validate that inactive weightages are not referenced by active exams
        for (BulkExamWeightageRequestDTO.SubjectWeightageDTO sw : dto.getWeightages()) {
            if (!sw.isActive()) {
                long count = examSubjectRepository.countActiveExamsBySubjectAndTerm(
                        dto.getStandardId(),
                        dto.getExamTermId(),
                        dto.getAcademicYearId(),
                        sw.getSubjectId()
                );
                if (count > 0) {
                    StandardSubjectEntity standardSubject = standardSubjectRepository
                            .findByStandardSubjectAndYear(dto.getStandardId(), sw.getSubjectId(), dto.getAcademicYearId())
                            .orElse(null);
                    String subjectName = (standardSubject != null && standardSubject.getSubject() != null)
                            ? standardSubject.getSubject().getName()
                            : "Subject";
                    
                    throw new ApiException(
                            buildDeactivateErrorCode(subjectName),
                            HttpStatus.CONFLICT
                    );
                }
            }
        }

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

    private BaseErrorCode buildDeactivateErrorCode(String subjectName) {
        String msg = "Unable to deactivate Exam Weightage for " + subjectName + ". Please remove or reassign all associated Exam Subject records first before attempting deactivation.";
        return new BaseErrorCode() {
            @Override
            public AppModule module() {
                return AppModule.COMMON;
            }

            @Override
            public ErrorCategory category() {
                return ErrorCategory.BUSINESS;
            }

            @Override
            public int number() {
                return 999;
            }

            @Override
            public String message() {
                return msg;
            }
        };
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamWeightageResponseDTO> getByStandard(Long standardId, Long academicYearId) {
        return weightageRepository.findByAcademicYearIdAndStandardId(academicYearId, standardId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }
}
