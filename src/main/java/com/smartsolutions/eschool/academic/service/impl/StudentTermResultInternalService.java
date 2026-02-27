package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentTermResultEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import com.smartsolutions.eschool.academic.repository.StudentExamMarksRepository;
import com.smartsolutions.eschool.academic.repository.StudentTermResultRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentTermResultInternalService {

    private final StudentTermResultRepository resultRepository;
    private final StudentExamMarksRepository marksRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processStudentResult(StudentEntity student, ExamTermEntity examTerm,
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
            log.error("Error processing result for student {}: {}", student.getId(), e.getMessage());
            // Rethrowing to ensure this child transaction rolls back,
            // but it won't affect the parent batch transaction because we will catch it
            // there.
            throw e;
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
}
