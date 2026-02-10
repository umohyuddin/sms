package com.smartsolutions.eschool.academic.facade;

import com.smartsolutions.eschool.academic.dto.request.*;
import com.smartsolutions.eschool.academic.dto.response.*;
import com.smartsolutions.eschool.academic.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ResultsHistoryFacade {

    private final StudentExamMarksService marksService;
    private final ExamWeightageService weightageService;
    private final StudentTermResultService resultService;
    private final ReportCardService reportCardService;
    private final GradeScaleService gradeScaleService;

    // Student Exam Marks
    public void recordExamMarks(List<StudentExamMarksRequestDTO> dtos) { marksService.recordMarks(dtos); }
    public List<StudentExamMarksResponseDTO> getMarksByExamSubject(Long examSubjectId) { return marksService.getByExamSubject(examSubjectId); }
    public List<StudentExamMarksResponseDTO> getStudentMarks(Long studentId, Long examId) { return marksService.getStudentMarks(studentId, examId); }

    // Exam Weightage
    public void saveWeightages(List<ExamWeightageRequestDTO> dtos) { weightageService.saveWeightages(dtos); }
    public List<ExamWeightageResponseDTO> getWeightagesByStandard(Long standardId, Long academicYearId) { return weightageService.getByStandard(standardId, academicYearId); }

    // Student Term Result
    public void processTermResults(Long standardId, Long sectionId, Long examTermId) { resultService.processResults(standardId, sectionId, examTermId); }
    public List<StudentTermResultResponseDTO> getSectionTermResults(Long standardId, Long sectionId, Long examTermId) { return resultService.getSectionResults(standardId, sectionId, examTermId); }
    public StudentTermResultResponseDTO getStudentTermResult(Long studentId, Long examTermId) { return resultService.getStudentResult(studentId, examTermId); }

    // Report Card
    public ReportCardResponseDTO generateReportCard(ReportCardRequestDTO dto) { return reportCardService.generate(dto); }
    public List<ReportCardResponseDTO> getReportCardsByStudent(Long studentId) { return reportCardService.getByStudent(studentId); }
    public void deleteReportCard(Long id) { reportCardService.delete(id); }

    // Grade Scale
    public GradeScaleResponseDTO createGradeScale(GradeScaleRequestDTO dto) { return gradeScaleService.create(dto); }
    public GradeScaleResponseDTO updateGradeScale(Long id, GradeScaleRequestDTO dto) { return gradeScaleService.update(id, dto); }
    public List<GradeScaleResponseDTO> getAllActiveGradeScales() { return gradeScaleService.getAllActive(); }
    public void deleteGradeScale(Long id) { gradeScaleService.delete(id); }
}
