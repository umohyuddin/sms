package com.smartsolutions.sms.academic.mapper;

import com.smartsolutions.sms.academic.dto.request.*;
import com.smartsolutions.sms.academic.dto.response.*;
import com.smartsolutions.sms.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.sms.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.sms.academic.entity.mapping.StudentTermResultEntity;
import com.smartsolutions.sms.academic.entity.master.GradeScaleEntity;
import com.smartsolutions.sms.academic.entity.master.ReportCardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultsMapper {

    ResultsMapper INSTANCE = Mappers.getMapper(ResultsMapper.class);

    // Marks
    @Mapping(target = "id.examSubjectId", source = "examSubjectId")
    @Mapping(target = "id.studentId", source = "studentId")
    @Mapping(target = "examSubject.id", source = "examSubjectId")
    @Mapping(target = "student.id", source = "studentId")
    StudentExamMarksEntity toEntity(StudentExamMarksRequestDTO dto);

    @Mapping(target = "examSubjectId", source = "id.examSubjectId")
    @Mapping(target = "studentId", source = "id.studentId")
    @Mapping(target = "studentName", source = "student.fullName")
    @Mapping(target = "studentCode", source = "student.studentCode")
    StudentExamMarksResponseDTO toResponse(StudentExamMarksEntity entity);

    // Weightage
    @Mapping(target = "id.standardId", source = "standardId")
    @Mapping(target = "id.subjectId", source = "subjectId")
    @Mapping(target = "id.examTermId", source = "examTermId")
    @Mapping(target = "standard.id", source = "standardId")
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "examTerm.id", source = "examTermId")
    ExamWeightageEntity toEntity(ExamWeightageRequestDTO dto);

    @Mapping(target = "standardId", source = "id.standardId")
    @Mapping(target = "standardName", source = "standard.standardName")
    @Mapping(target = "subjectId", source = "id.subjectId")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "examTermId", source = "id.examTermId")
    @Mapping(target = "examTermName", source = "examTerm.name")
    ExamWeightageResponseDTO toResponse(ExamWeightageEntity entity);

    // Term Result
    @Mapping(target = "id.studentId", source = "studentId")
    @Mapping(target = "id.academicYearId", source = "academicYearId")
    @Mapping(target = "id.examTermId", source = "examTermId")
    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    @Mapping(target = "examTerm.id", source = "examTermId")
    StudentTermResultEntity toEntity(StudentTermResultRequestDTO dto);

    @Mapping(target = "studentId", source = "id.studentId")
    @Mapping(target = "studentName", source = "student.fullName")
    @Mapping(target = "academicYearId", source = "id.academicYearId")
    @Mapping(target = "academicYearName", source = "academicYear.name")
    @Mapping(target = "examTermId", source = "id.examTermId")
    @Mapping(target = "examTermName", source = "examTerm.name")
    StudentTermResultResponseDTO toResponse(StudentTermResultEntity entity);

    // Report Card
    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    ReportCardEntity toEntity(ReportCardRequestDTO dto);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "studentName", source = "student.fullName")
    @Mapping(target = "academicYearId", source = "academicYear.id")
    @Mapping(target = "academicYearName", source = "academicYear.name")
    ReportCardResponseDTO toResponse(ReportCardEntity entity);

    // Grade Scale
    GradeScaleEntity toEntity(GradeScaleRequestDTO dto);
    GradeScaleResponseDTO toResponse(GradeScaleEntity entity);
}
