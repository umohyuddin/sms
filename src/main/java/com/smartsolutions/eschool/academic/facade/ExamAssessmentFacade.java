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
public class ExamAssessmentFacade {

    private final ExamTypeService examTypeService;
    private final ExamTermService examTermService;
    private final AssessmentTypeService assessmentTypeService;
    private final ExamService examService;
    private final ExamSubjectService examSubjectService;
    private final AssessmentService assessmentService;
    private final StudentAssessmentService studentAssessmentService;

    // Exam Type
    public ExamTypeResponseDTO createExamType(ExamTypeRequestDTO dto) {
        return examTypeService.create(dto);
    }

    public ExamTypeResponseDTO updateExamType(Long id, ExamTypeRequestDTO dto) {
        return examTypeService.update(id, dto);
    }

    public ExamTypeResponseDTO getExamTypeById(Long id) {
        return examTypeService.getById(id);
    }

    public List<ExamTypeResponseDTO> getAllActiveExamTypes() {
        return examTypeService.getAllActive();
    }

    public List<ExamTypeResponseDTO> searchExamTypes(String keyword) {
        return examTypeService.searchByKeyword(keyword);
    }

    public void deleteExamType(Long id) {
        examTypeService.delete(id);
    }

    // Exam Term
    public ExamTermResponseDTO createExamTerm(ExamTermRequestDTO dto) {
        return examTermService.create(dto);
    }

    public ExamTermResponseDTO updateExamTerm(Long id, ExamTermRequestDTO dto) {
        return examTermService.update(id, dto);
    }

    public ExamTermResponseDTO getExamTermById(Long id) {
        return examTermService.getById(id);
    }

    public List<ExamTermResponseDTO> getActiveTermsByYear(Long academicYearId) {
        return examTermService.getActiveByYear(academicYearId);
    }

    public List<ExamTermResponseDTO> searchExamTerms(String keyword) {
        return examTermService.searchByKeyword(keyword);
    }

    public void deleteExamTerm(Long id) {
        examTermService.delete(id);
    }

    // Assessment Type
    public AssessmentTypeResponseDTO createAssessmentType(AssessmentTypeRequestDTO dto) {
        return assessmentTypeService.create(dto);
    }

    public AssessmentTypeResponseDTO updateAssessmentType(Long id, AssessmentTypeRequestDTO dto) {
        return assessmentTypeService.update(id, dto);
    }

    public AssessmentTypeResponseDTO getAssessmentTypeById(Long id) {
        return assessmentTypeService.getById(id);
    }

    public List<AssessmentTypeResponseDTO> getAllActiveAssessmentTypes() {
        return assessmentTypeService.getAllActive();
    }

    public List<AssessmentTypeResponseDTO> searchAssessmentTypes(String keyword) {
        return assessmentTypeService.searchByKeyword(keyword);
    }

    public void deleteAssessmentType(Long id) {
        assessmentTypeService.delete(id);
    }

    // Exam
    public List<ExamResponseDTO> createExam(ExamRequestDTO dto) {
        return examService.create(dto);
    }

    public ExamResponseDTO updateExam(Long id, ExamRequestDTO dto) {
        return examService.update(id, dto);
    }

    public ExamResponseDTO getExamById(Long id) {
        return examService.getById(id);
    }

    public List<ExamResponseDTO> getExamsBySection(Long standardId, Long sectionId, Long academicYearId) {
        return examService.getBySection(standardId, sectionId, academicYearId);
    }

    public List<ExamResponseDTO> searchExams(Long academicYearId, Long campusId, Long standardId, Long sectionId,
            Long examTermId, String keyword) {
        return examService.search(academicYearId, campusId, standardId, sectionId, examTermId, keyword);
    }

    public void deleteExam(Long id) {
        examService.delete(id);
    }

    // Exam Subject
    public ExamSubjectResponseDTO scheduleSubject(ExamSubjectRequestDTO dto) {
        return examSubjectService.scheduleSubject(dto);
    }

    public List<ExamSubjectResponseDTO> getSubjectsByExam(Long examId) {
        return examSubjectService.getByExam(examId);
    }

    public void unscheduleSubject(Long examId, Long subjectId) {
        examSubjectService.unschedule(examId, subjectId);
    }

    // Assessment
    public AssessmentResponseDTO createAssessment(AssessmentRequestDTO dto) {
        return assessmentService.create(dto);
    }

    public AssessmentResponseDTO updateAssessment(Long id, AssessmentRequestDTO dto) {
        return assessmentService.update(id, dto);
    }

    public AssessmentResponseDTO getAssessmentById(Long id) {
        return assessmentService.getById(id);
    }

    public List<AssessmentResponseDTO> getAssessmentsByAssignment(Long teacherSubjectAssignmentId) {
        return assessmentService.getByAssignment(teacherSubjectAssignmentId);
    }

    public void deleteAssessment(Long id) {
        assessmentService.delete(id);
    }

    // Student Assessment
    public void submitAssessment(StudentAssessmentRequestDTO dto) {
        studentAssessmentService.submitAssessment(dto);
    }

    public void evaluateAssessment(StudentAssessmentRequestDTO dto) {
        studentAssessmentService.evaluateAssessment(dto);
    }

    public List<StudentAssessmentResponseDTO> getByAssessment(Long assessmentId) {
        return studentAssessmentService.getByAssessment(assessmentId);
    }

    public List<StudentAssessmentResponseDTO> getByStudent(Long studentId) {
        return studentAssessmentService.getByStudent(studentId);
    }
}
