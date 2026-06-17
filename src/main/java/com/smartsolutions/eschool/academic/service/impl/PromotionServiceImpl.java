package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.academic.dto.request.PromotionRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.PromotionResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.entity.master.StudentAcademicHistoryEntity;
import com.smartsolutions.eschool.academic.entity.master.StudentAcademicHistoryEntity.AcademicStatus;
import com.smartsolutions.eschool.academic.repository.StudentAcademicHistoryRepository;
import com.smartsolutions.eschool.academic.repository.StudentExamMarksRepository;
import com.smartsolutions.eschool.academic.service.PromotionService;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromotionServiceImpl implements PromotionService {

    private final StudentRepository studentRepository;
    private final StudentExamMarksRepository marksRepository;
    private final StudentAcademicHistoryRepository historyRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final AcademicYearRepository academicYearRepository;

    // ══════════════════════════════════════════════════════════════════════
    // PREVIEW
    // ══════════════════════════════════════════════════════════════════════
    @Override
    @Transactional(readOnly = true)
    public List<PromotionResponseDTO> previewPromotion(PromotionRequestDTO request) {
        log.info("Generating promotion preview for examId: {}", request.getExamId());

        // ✅ Sirf examId aur campusId se marks fetch karo
        List<StudentExamMarksEntity> marks = marksRepository.findMarksForPromotion(
                request.getExamId(),
                request.getCampusId()
        );

        log.info("Marks returned: {}", marks.size());

        if (marks.isEmpty()) return Collections.emptyList();

        // ✅ Student ke hisaab se group karo
        Map<Long, List<StudentExamMarksEntity>> marksByStudent = marks.stream()
                .collect(Collectors.groupingBy(m -> m.getStudent().getId()));

        List<PromotionResponseDTO> responses = new ArrayList<>();

        for (Map.Entry<Long, List<StudentExamMarksEntity>> entry : marksByStudent.entrySet()) {
            Long studentId = entry.getKey();
            List<StudentExamMarksEntity> studentMarks = entry.getValue();
            StudentEntity student = studentMarks.get(0).getStudent();

            Optional<StudentAcademicHistoryEntity> existingOpt = historyRepository
                    .findByStudentId(studentId).stream()
                    .filter(h -> h.getAcademicYear().getId().equals(request.getAcademicYearId()))
                    .findFirst();

            PromotionResponseDTO dto;
            if (existingOpt.isPresent()) {
                StudentAcademicHistoryEntity history = existingOpt.get();
                String promoStatus = history.getStatus() == AcademicStatus.PROMOTED ? "PROMOTED"
                        : history.getStatus() == AcademicStatus.WITHDRAWN ? "LEFT"
                        : "RETAINED";
                dto = PromotionResponseDTO.builder()
                        .studentId(studentId)
                        .studentName(student.getFirstName() + " " +
                                (student.getLastName() != null ? student.getLastName() : ""))
                        .rollNumber(student.getStudentCode())
                        .status(evaluateExamStatus(studentMarks))
                        .promotionStatus(promoStatus)
                        .remarks(history.getRemarks())
                        .isProcessed(true)
                        .build();
            } else {
                dto = evaluateStudent(student, studentMarks);
                dto.setIsProcessed(false);
            }
            responses.add(dto);
        }

        return responses;
    }

    // ══════════════════════════════════════════════════════════════════════
    // PROCESS — history mein save karo
    // ══════════════════════════════════════════════════════════════════════
    @Override
    @Transactional
    public List<PromotionResponseDTO> processPromotion(PromotionRequestDTO request) {
        log.info("Processing promotion request: {}", request);

        StandardEntity standard = standardRepository.findById(request.getStandardId())
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found: " + request.getStandardId()));
        SectionEntity section = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> new ResourceNotFoundException("Section not found: " + request.getSectionId()));
        AcademicYearEntity academicYear = academicYearRepository.findById(request.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found: " + request.getAcademicYearId()));

        // ✅ examId aur campusId se marks fetch karo
        List<StudentExamMarksEntity> marks = marksRepository.findMarksForPromotion(
                request.getExamId(),
                request.getCampusId()
        );

        log.info("Marks returned for process: {}", marks.size());

        if (marks.isEmpty()) {
            log.warn("No marks found for examId: {} campusId: {}", request.getExamId(), request.getCampusId());
            return Collections.emptyList();
        }

        Map<Long, List<StudentExamMarksEntity>> marksByStudent = marks.stream()
                .collect(Collectors.groupingBy(m -> m.getStudent().getId()));

        // Manual overrides map
        Map<Long, PromotionRequestDTO.StudentPromotionRequest> customPromotionsMap = null;
        if (request.getStudentPromotions() != null && !request.getStudentPromotions().isEmpty()) {
            customPromotionsMap = request.getStudentPromotions().stream()
                    .collect(Collectors.toMap(
                            PromotionRequestDTO.StudentPromotionRequest::getStudentId,
                            p -> p,
                            (p1, p2) -> p1
                    ));
        }

        List<PromotionResponseDTO> responses = new ArrayList<>();

        for (Map.Entry<Long, List<StudentExamMarksEntity>> entry : marksByStudent.entrySet()) {
            Long studentId = entry.getKey();
            List<StudentExamMarksEntity> studentMarks = entry.getValue();

            StudentEntity student = studentMarks.get(0).getStudent();

            String examStatus = evaluateExamStatus(studentMarks);

            PromotionResponseDTO evaluation = evaluateStudent(student, studentMarks);
            evaluation.setStatus(examStatus);

            // ✅ Manual override apply karo
            if (customPromotionsMap != null && customPromotionsMap.containsKey(studentId)) {
                PromotionRequestDTO.StudentPromotionRequest customPromo = customPromotionsMap.get(studentId);
                if (customPromo.getPromotionStatus() != null) {
                    evaluation.setPromotionStatus(customPromo.getPromotionStatus());
                }
                if (customPromo.getRemarks() != null) {
                    evaluation.setRemarks(customPromo.getRemarks());
                }
            }

            evaluation.setIsProcessed(true);
            responses.add(evaluation);

            // History status map karo
            AcademicStatus historyStatus;
            if ("PROMOTED".equalsIgnoreCase(evaluation.getPromotionStatus())) {
                historyStatus = AcademicStatus.PROMOTED;
            } else if ("LEFT".equalsIgnoreCase(evaluation.getPromotionStatus())) {
                historyStatus = AcademicStatus.WITHDRAWN;
            } else {
                historyStatus = AcademicStatus.RETAINED;
            }

            // ✅ History mein save karo
            Optional<StudentAcademicHistoryEntity> existingOpt = historyRepository
                    .findByStudentId(studentId)
                    .stream()
                    .filter(h -> h.getAcademicYear().getId().equals(request.getAcademicYearId()))
                    .findFirst();

            StudentAcademicHistoryEntity history;
            // ✅ History save karte waqt student ka actual standard use karo
            if (existingOpt.isPresent()) {
                history = existingOpt.get();
                history.setStatus(historyStatus);
                history.setRemarks(evaluation.getRemarks());
                history.setStandard(student.getStandard());  // ← request.standard ki bajaye student.getStandard()
                history.setSection(section);
            } else {
                history = StudentAcademicHistoryEntity.builder()
                        .student(student)
                        .standard(student.getStandard())  // ← yahan bhi student.getStandard()
                        .section(section)
                        .academicYear(academicYear)
                        .status(historyStatus)
                        .remarks(evaluation.getRemarks())
                        .active(true)
                        .build();
            }
            historyRepository.save(history);

            // ✅ PROMOTED students ka next grade update karo
            if (historyStatus == AcademicStatus.PROMOTED) {

                // ✅ Next academic year pehle dhundo
                AcademicYearEntity nextAcademicYear = academicYearRepository
                        .findNextAcademicYear(request.getAcademicYearId())
                        .orElse(academicYear);

                standardRepository.findNextStandard(
                        request.getCampusId(),
                        student.getStandard().getId()
                ).ifPresentOrElse(
                        nextStandard -> {
                            // Next grade bhi hai
                            student.setStandard(nextStandard);
                            student.setAcademicYear(nextAcademicYear);
                            studentRepository.save(student);
                            log.info("Student {} promoted to: {} in year: {}",
                                    student.getStudentCode(),
                                    nextStandard.getStandardName(),
                                    nextAcademicYear.getName());
                        },
                        () -> {
                            // Next grade nahi — sirf academic year update karo
                            student.setAcademicYear(nextAcademicYear);
                            studentRepository.save(student);
                            log.warn("No next grade for student {} — only academic year updated to: {}",
                                    student.getStudentCode(),
                                    nextAcademicYear.getName());
                        }
                );
            }
        }
        return responses;

    }
    // ══════════════════════════════════════════════════════════════════════
    // HELPER — marks se Pass/Fail evaluate karo
    // ══════════════════════════════════════════════════════════════════════
    private PromotionResponseDTO evaluateStudent(StudentEntity student, List<StudentExamMarksEntity> studentMarks) {
        String studentName = student.getFirstName() + " " + (student.getLastName() != null ? student.getLastName() : "");

        if (student.getStatus() != null && student.getStatus().equalsIgnoreCase("LEFT")) {
            return PromotionResponseDTO.builder()
                    .studentId(student.getId())
                    .studentName(studentName)
                    .rollNumber(student.getStudentCode())
                    .status("Fail")
                    .promotionStatus("LEFT")
                    .remarks("Student has left the school")
                    .build();
        }

        if (studentMarks == null || studentMarks.isEmpty()) {
            return PromotionResponseDTO.builder()
                    .studentId(student.getId())
                    .studentName(studentName)
                    .rollNumber(student.getStudentCode())
                    .status("Fail")
                    .promotionStatus("RETAINED")
                    .remarks("No exam marks recorded for this term")
                    .build();
        }

        String examStatus = evaluateExamStatus(studentMarks);

        if ("Pass".equals(examStatus)) {
            return PromotionResponseDTO.builder()
                    .studentId(student.getId())
                    .studentName(studentName)
                    .rollNumber(student.getStudentCode())
                    .status("Pass")
                    .promotionStatus("PROMOTED")
                    .remarks("Passed all exam subjects successfully")
                    .build();
        } else {
            return PromotionResponseDTO.builder()
                    .studentId(student.getId())
                    .studentName(studentName)
                    .rollNumber(student.getStudentCode())
                    .status("Fail")
                    .promotionStatus("RETAINED")
                    .remarks("Failed in one or more exam subjects")
                    .build();
        }
    }

    // ✅ Exam status hamesha marks se
    private String evaluateExamStatus(List<StudentExamMarksEntity> studentMarks) {
        if (studentMarks == null || studentMarks.isEmpty()) return "Fail";

        for (StudentExamMarksEntity mark : studentMarks) {
            BigDecimal obtained = mark.getObtainedMarks() != null ? mark.getObtainedMarks() : BigDecimal.ZERO;
            BigDecimal grace    = mark.getGraceMarks()    != null ? mark.getGraceMarks()    : BigDecimal.ZERO;
            BigDecimal passing  = (mark.getExamSubject() != null && mark.getExamSubject().getPassingMarks() != null)
                    ? mark.getExamSubject().getPassingMarks()
                    : BigDecimal.ZERO;

            if (obtained.add(grace).compareTo(passing) < 0) return "Fail";
        }
        return "Pass";
    }

    @Override
    @Transactional(readOnly = true)
    public List<PromotionResponseDTO> getNextYearStudents(PromotionRequestDTO request) {
        log.info("Fetching next year students for academicYearId: {}", request.getAcademicYearId());

        List<StudentEntity> students = studentRepository.findStudentsByAcademicYear(
                request.getAcademicYearId(),
                request.getCampusId(),
                request.getStandardId(),
                request.getSectionId()
        );

        log.info("Next year students found: {}", students.size());

        return students.stream().map(st -> PromotionResponseDTO.builder()
                .studentId(st.getId())
                .studentName(st.getFirstName() + " " +
                        (st.getLastName() != null ? st.getLastName() : ""))
                .rollNumber(st.getStudentCode())
                .status("PROMOTED")
                .promotionStatus("PROMOTED")
                .isProcessed(true)
                .build()
        ).collect(Collectors.toList());
    }
}
