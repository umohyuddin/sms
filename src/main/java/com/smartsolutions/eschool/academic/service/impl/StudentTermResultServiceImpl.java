package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.StudentTermResultRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentTermResultResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentTermResultEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.StudentTermResultRepository;
import com.smartsolutions.eschool.academic.repository.StudentExamMarksRepository;
import com.smartsolutions.eschool.academic.repository.ExamWeightageRepository;
import com.smartsolutions.eschool.academic.repository.ExamRepository;
import com.smartsolutions.eschool.academic.repository.ExamTermRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.academic.service.StudentTermResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentTermResultServiceImpl implements StudentTermResultService {

    private final StudentTermResultRepository resultRepository;
    private final StudentRepository studentRepository;
    private final StudentExamMarksRepository marksRepository;
    private final ExamWeightageRepository weightageRepository;
    private final ExamRepository examRepository;
    private final ExamTermRepository examTermRepository;
    private final StudentTermResultInternalService internalProcessor;

    @Override
    @Transactional
    public void processResults(Long standardId, Long sectionId, Long examTermId) {
        log.info("Processing term results for all students in Standard {} Section {}", standardId, sectionId);

        try {
            // Get exam term entity
            ExamTermEntity examTerm = examTermRepository.findById(examTermId)
                    .orElseThrow(() -> new ResourceNotFoundException("Exam Term not found"));

            // Get all students in this section
            List<StudentEntity> students = studentRepository.findBySectionId(sectionId);

            if (students.isEmpty()) {
                log.warn("No students found for section {}", sectionId);
                return;
            }

            // Get weightages for this standard and term
            List<ExamWeightageEntity> weightages = weightageRepository.findByStandardAndExamTerm(standardId,
                    examTermId);

            if (weightages.isEmpty()) {
                log.warn("No weightages configured for standard {} and term {}", standardId, examTermId);
            }

            // Get all exams for this standard, section, and academic year
            List<ExamEntity> exams = examRepository.findExamsByStandardSectionAndAcademicYear(
                    standardId, sectionId, examTerm.getAcademicYear().getId());

            // Filter exams by the specific term
            List<ExamEntity> termExams = exams.stream()
                    .filter(exam -> exam.getExamTerm() != null && exam.getExamTerm().getId().equals(examTermId))
                    .collect(Collectors.toList());

            if (termExams.isEmpty()) {
                log.warn("No exams found for standard {} section {} and term {}", standardId, sectionId, examTermId);
                return;
            }

            int successCount = 0;
            // Process each student
            for (StudentEntity student : students) {
                try {
                    internalProcessor.processStudentResult(student, examTerm, weightages, termExams);
                    successCount++;
                } catch (Exception e) {
                    log.error("Failed to process result for student {}: {}", student.getId(), e.getMessage());
                    // We continue the loop; child transaction rolled back, but parent continues
                }
            }

            log.info("Finished processing term results. Success: {}, Total: {}", successCount, students.size());

        } catch (Exception e) {
            log.error("Critical error in batch result processing", e);
            throw new RuntimeException("Failed to process term results: " + e.getMessage(), e);
        }
    }

    private String calculateGrade(BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.valueOf(90)) >= 0)
            return "A+";
        if (percentage.compareTo(BigDecimal.valueOf(80)) >= 0)
            return "A";
        if (percentage.compareTo(BigDecimal.valueOf(70)) >= 0)
            return "B";
        if (percentage.compareTo(BigDecimal.valueOf(60)) >= 0)
            return "C";
        if (percentage.compareTo(BigDecimal.valueOf(50)) >= 0)
            return "D";
        return "F";
    }

    @Override
    public List<StudentTermResultResponseDTO> getSectionResults(Long standardId, Long sectionId, Long examTermId) {
        return resultRepository.findBySectionIdAndExamTerm(standardId, sectionId, examTermId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentTermResultResponseDTO getStudentResult(Long studentId, Long examTermId) {
        return resultRepository.findByStudentIdAndExamTerm(studentId, examTermId)
                .map(ResultsMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
