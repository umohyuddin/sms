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

            // Process each student
            for (StudentEntity student : students) {
                processStudentResult(student, examTerm, weightages, termExams);
            }

            log.info("Successfully processed term results for {} students", students.size());

        } catch (Exception e) {
            log.error("Error processing term results", e);
            throw new RuntimeException("Failed to process term results: " + e.getMessage(), e);
        }
    }

    private void processStudentResult(StudentEntity student, ExamTermEntity examTerm,
            List<ExamWeightageEntity> weightages, List<ExamEntity> termExams) {
        try {
            // Get all marks for this student across all exams in this term
            List<StudentExamMarksEntity> allMarks = termExams.stream()
                    .flatMap(exam -> marksRepository.findByStudentIdAndExamId(student.getId(), exam.getId()).stream())
                    .collect(Collectors.toList());

            if (allMarks.isEmpty()) {
                log.debug("No marks found for student {} in term {}", student.getId(), examTerm.getId());
                return;
            }

            // Calculate total and obtained marks based on weightages
            BigDecimal totalMarks = BigDecimal.ZERO;
            BigDecimal obtainedMarks = BigDecimal.ZERO;

            for (ExamWeightageEntity weightage : weightages) {
                // Find marks for this subject
                StudentExamMarksEntity subjectMarks = allMarks.stream()
                        .filter(m -> m.getExamSubject() != null &&
                                m.getExamSubject().getSubject() != null &&
                                m.getExamSubject().getSubject().getId()
                                        .equals(weightage.getStandardSubject().getSubject().getId()))
                        .findFirst()
                        .orElse(null);

                if (subjectMarks != null && subjectMarks.getObtainedMarks() != null) {
                    BigDecimal weightagePercent = weightage.getWeightPercentage() != null
                            ? weightage.getWeightPercentage()
                            : BigDecimal.ZERO;
                    BigDecimal weightedMarks = subjectMarks.getObtainedMarks()
                            .multiply(weightagePercent)
                            .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

                    obtainedMarks = obtainedMarks.add(weightedMarks);
                    totalMarks = totalMarks.add(weightagePercent);
                }
            }

            // Calculate percentage
            BigDecimal percentage = BigDecimal.ZERO;
            if (totalMarks.compareTo(BigDecimal.ZERO) > 0) {
                percentage = obtainedMarks.multiply(BigDecimal.valueOf(100))
                        .divide(totalMarks, 2, RoundingMode.HALF_UP);
            }

            // Determine grade based on percentage
            String grade = calculateGrade(percentage);

            // Create or update term result
            StudentTermResultEntity result = resultRepository
                    .findByStudentIdAndExamTerm(student.getId(), examTerm.getId())
                    .orElseGet(StudentTermResultEntity::new);

            result.setStudent(student);
            result.setAcademicYear(examTerm.getAcademicYear());
            result.setExamTerm(examTerm);
            result.setTotalMarks(totalMarks);
            result.setObtainedMarks(obtainedMarks);
            result.setPercentage(percentage);
            result.setGrade(grade);
            result.setGeneratedAt(LocalDateTime.now());
            result.setActive(true);
            result.setDeleted(false);

            resultRepository.save(result);
            log.debug("Saved result for student {}: {}% ({})", student.getId(), percentage, grade);

        } catch (Exception e) {
            log.error("Error processing result for student {}", student.getId(), e);
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
