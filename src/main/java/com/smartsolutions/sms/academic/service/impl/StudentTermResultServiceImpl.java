package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.sms.academic.dto.request.StudentTermResultRequestDTO;
import com.smartsolutions.sms.academic.dto.response.StudentTermResultResponseDTO;
import com.smartsolutions.sms.academic.entity.mapping.StudentTermResultEntity;
import com.smartsolutions.sms.academic.mapper.ResultsMapper;
import com.smartsolutions.sms.academic.repository.StudentTermResultRepository;
import com.smartsolutions.sms.academic.service.StudentTermResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentTermResultServiceImpl implements StudentTermResultService {

    private final StudentTermResultRepository resultRepository;
    private final ResultsMapper resultsMapper;

    @Override
    @Transactional
    public void processResults(Long standardId, Long sectionId, Long examTermId) {
        log.info("Processing term results for all students in Standard {} Section {}", standardId, sectionId);
        // Implementation logic for calculating results from marks and weightages would go here.
    }

    @Override
    public List<StudentTermResultResponseDTO> getSectionResults(Long standardId, Long sectionId, Long examTermId) {
        return resultRepository.findBySectionIdAndExamTerm(standardId, sectionId, examTermId).stream()
                .map(resultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentTermResultResponseDTO getStudentResult(Long studentId, Long examTermId) {
        return resultRepository.findByStudentIdAndExamTerm(studentId, examTermId)
                .map(resultsMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
