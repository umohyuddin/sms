package com.smartsolutions.sms.academic.mapper;

import com.smartsolutions.sms.academic.dto.request.*;
import com.smartsolutions.sms.academic.dto.response.*;
import com.smartsolutions.sms.academic.entity.mapping.*;
import com.smartsolutions.sms.academic.entity.master.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExamAssessmentMapper {

    ExamAssessmentMapper INSTANCE = Mappers.getMapper(ExamAssessmentMapper.class);

    // Exam Type & Term
    ExamTypeEntity toEntity(ExamTypeRequestDTO dto);
    ExamTypeResponseDTO toResponse(ExamTypeEntity entity);

    @Mapping(target = "academicYear.id", source = "academicYearId")
    ExamTermEntity toEntity(ExamTermRequestDTO dto);
    
    @Mapping(target = "academicYearId", source = "academicYear.id")
    @Mapping(target = "academicYearName", source = "academicYear.name")
    ExamTermResponseDTO toResponse(ExamTermEntity entity);

    // Assessment Type
    AssessmentTypeEntity toEntity(AssessmentTypeRequestDTO dto);
    AssessmentTypeResponseDTO toResponse(AssessmentTypeEntity entity);

    // Exam
    @Mapping(target = "academicYear.id", source = "academicYearId")
    @Mapping(target = "examTerm.id", source = "examTermId")
    @Mapping(target = "campus.id", source = "campusId")
    @Mapping(target = "standard.id", source = "standardId")
    @Mapping(target = "section.id", source = "sectionId")
    ExamEntity toEntity(ExamRequestDTO dto);

    @Mapping(target = "academicYearId", source = "academicYear.id")
    @Mapping(target = "academicYearName", source = "academicYear.name")
    @Mapping(target = "examTermId", source = "examTerm.id")
    @Mapping(target = "examTermName", source = "examTerm.name")
    @Mapping(target = "campusId", source = "campus.id")
    @Mapping(target = "campusName", source = "campus.campusName")
    @Mapping(target = "standardId", source = "standard.id")
    @Mapping(target = "standardName", source = "standard.standardName")
    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "sectionName", source = "section.sectionName")
    ExamResponseDTO toResponse(ExamEntity entity);

    // Exam Subject
    @Mapping(target = "id.examId", source = "examId")
    @Mapping(target = "id.subjectId", source = "subjectId")
    @Mapping(target = "exam.id", source = "examId")
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "evaluator.id", source = "evaluatorId")
    ExamSubjectEntity toEntity(ExamSubjectRequestDTO dto);

    @Mapping(target = "examId", source = "id.examId")
    @Mapping(target = "examName", source = "exam.name")
    @Mapping(target = "subjectId", source = "id.subjectId")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "evaluatorId", source = "evaluator.id")
    @Mapping(target = "evaluatorName", source = "evaluator.fullName")
    ExamSubjectResponseDTO toResponse(ExamSubjectEntity entity);

    // Assessment
    @Mapping(target = "teacherSubjectAssignment.id", source = "teacherSubjectAssignmentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    @Mapping(target = "assessmentType.id", source = "assessmentTypeId")
    AssessmentEntity toEntity(AssessmentRequestDTO dto);

    @Mapping(target = "teacherSubjectAssignmentId", source = "teacherSubjectAssignment.id")
    @Mapping(target = "subjectName", source = "teacherSubjectAssignment.subject.name")
    @Mapping(target = "teacherName", source = "teacherSubjectAssignment.teacher.fullName")
    @Mapping(target = "assessmentTypeId", source = "assessmentType.id")
    @Mapping(target = "assessmentTypeName", source = "assessmentType.name")
    AssessmentResponseDTO toResponse(AssessmentEntity entity);

    // Student Assessment
    @Mapping(target = "id.assessmentId", source = "assessmentId")
    @Mapping(target = "id.studentId", source = "studentId")
    @Mapping(target = "assessment.id", source = "assessmentId")
    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "evaluatedBy.id", source = "evaluatedById")
    StudentAssessmentEntity toEntity(StudentAssessmentRequestDTO dto);

    @Mapping(target = "assessmentId", source = "id.assessmentId")
    @Mapping(target = "assessmentTitle", source = "assessment.title")
    @Mapping(target = "studentId", source = "id.studentId")
    @Mapping(target = "studentName", source = "student.fullName")
    @Mapping(target = "studentCode", source = "student.studentCode")
    @Mapping(target = "evaluatedBy", source = "evaluatedBy.fullName")
    StudentAssessmentResponseDTO toResponse(StudentAssessmentEntity entity);
}
