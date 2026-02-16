package com.smartsolutions.eschool.academic.mapper;

import com.smartsolutions.eschool.academic.dto.request.*;
import com.smartsolutions.eschool.academic.dto.response.*;
import com.smartsolutions.eschool.academic.entity.mapping.ExamSubjectEntity;
import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentTermResultEntity;
import com.smartsolutions.eschool.academic.entity.master.GradeScaleEntity;
import com.smartsolutions.eschool.academic.entity.master.ReportCardEntity;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsMapper {

    private ResultsMapper() {
        // prevent instantiation
    }

    // Marks
    public static StudentExamMarksEntity toEntity(StudentExamMarksRequestDTO dto) {
        if (dto == null)
            return null;
        StudentExamMarksEntity entity = new StudentExamMarksEntity();
        // ID is auto-generated

        if (dto.getExamSubjectId() != null) {
            ExamSubjectEntity examSubject = new ExamSubjectEntity();
            examSubject.setId(dto.getExamSubjectId());
            entity.setExamSubject(examSubject);
        }

        if (dto.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(dto.getStudentId());
            entity.setStudent(student);
        }

        entity.setObtainedMarks(dto.getObtainedMarks());
        entity.setGraceMarks(dto.getGraceMarks());
        // Note: grade field was problematic, ensure it's mapped if it exists in entity
        // entity.setGrade(dto.getGrade());
        entity.setRemarks(dto.getRemarks());
        entity.setLocked(dto.isLocked());
        entity.setActive(dto.getIsActive() != null && dto.getIsActive());
        return entity;
    }

    public static StudentExamMarksResponseDTO toResponse(StudentExamMarksEntity entity) {
        if (entity == null)
            return null;
        StudentExamMarksResponseDTO dto = new StudentExamMarksResponseDTO();

        if (entity.getExamSubject() != null) {
            dto.setExamSubjectId(entity.getExamSubject().getId());
        }

        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentName(entity.getStudent().getFullName());
            dto.setStudentCode(entity.getStudent().getStudentCode());
        }

        dto.setObtainedMarks(entity.getObtainedMarks());
        dto.setGraceMarks(entity.getGraceMarks());
        dto.setRemarks(entity.getRemarks());
        dto.setLocked(entity.isLocked());
        return dto;
    }

    public static List<StudentExamMarksResponseDTO> toStudentExamMarksResponseList(
            List<StudentExamMarksEntity> entities) {
        return entities == null ? null : entities.stream().map(ResultsMapper::toResponse).collect(Collectors.toList());
    }

    // Weightage
    public static ExamWeightageEntity toEntity(ExamWeightageRequestDTO dto) {
        if (dto == null)
            return null;
        ExamWeightageEntity entity = new ExamWeightageEntity();
        // ID is auto-generated

        if (dto.getStandardId() != null) {
            StandardEntity standard = new StandardEntity();
            standard.setId(dto.getStandardId());
            entity.setStandard(standard);
        }

        if (dto.getSubjectId() != null) {
            SubjectEntity subject = new SubjectEntity();
            subject.setId(dto.getSubjectId());
            entity.setSubject(subject);
        }

        if (dto.getExamTermId() != null) {
            ExamTermEntity examTerm = new ExamTermEntity();
            examTerm.setId(dto.getExamTermId());
            entity.setExamTerm(examTerm);
        }

        entity.setWeightPercentage(dto.getWeightPercentage());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static ExamWeightageResponseDTO toResponse(ExamWeightageEntity entity) {
        if (entity == null)
            return null;
        ExamWeightageResponseDTO dto = new ExamWeightageResponseDTO();
        dto.setId(entity.getId());

        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }
        if (entity.getSubject() != null) {
            dto.setSubjectId(entity.getSubject().getId());
            dto.setSubjectName(entity.getSubject().getName());
        }
        if (entity.getExamTerm() != null) {
            dto.setExamTermId(entity.getExamTerm().getId());
            dto.setExamTermName(entity.getExamTerm().getName());
        }
        dto.setWeightPercentage(entity.getWeightPercentage());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<ExamWeightageResponseDTO> toExamWeightageResponseList(List<ExamWeightageEntity> entities) {
        return entities == null ? null : entities.stream().map(ResultsMapper::toResponse).collect(Collectors.toList());
    }

    // Term Result
    public static StudentTermResultEntity toEntity(StudentTermResultRequestDTO dto) {
        if (dto == null)
            return null;
        StudentTermResultEntity entity = new StudentTermResultEntity();
        // ID is auto-generated

        if (dto.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(dto.getStudentId());
            entity.setStudent(student);
        }

        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity year = new AcademicYearEntity();
            year.setId(dto.getAcademicYearId());
            entity.setAcademicYear(year);
        }

        if (dto.getExamTermId() != null) {
            ExamTermEntity term = new ExamTermEntity();
            term.setId(dto.getExamTermId());
            entity.setExamTerm(term);
        }

        entity.setTotalMarks(dto.getTotalMarks());
        entity.setObtainedMarks(dto.getObtainedMarks());
        entity.setPercentage(dto.getPercentage());
        entity.setGrade(dto.getGrade());
        // Note: entity has gpa field, not rank
        entity.setActive(dto.isActive());
        return entity;
    }

    public static StudentTermResultResponseDTO toResponse(StudentTermResultEntity entity) {
        if (entity == null)
            return null;
        StudentTermResultResponseDTO dto = new StudentTermResultResponseDTO();
        dto.setId(entity.getId());

        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentName(entity.getStudent().getFullName());
        }
        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }
        if (entity.getExamTerm() != null) {
            dto.setExamTermId(entity.getExamTerm().getId());
            dto.setExamTermName(entity.getExamTerm().getName());
        }
        dto.setTotalMarks(entity.getTotalMarks());
        dto.setObtainedMarks(entity.getObtainedMarks());
        dto.setPercentage(entity.getPercentage());
        dto.setGrade(entity.getGrade());
        // Entity has gpa field, not rank
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<StudentTermResultResponseDTO> toStudentTermResultResponseList(
            List<StudentTermResultEntity> entities) {
        return entities == null ? null : entities.stream().map(ResultsMapper::toResponse).collect(Collectors.toList());
    }

    // Report Card
    public static ReportCardEntity toEntity(ReportCardRequestDTO dto) {
        if (dto == null)
            return null;
        ReportCardEntity entity = new ReportCardEntity();
        if (dto.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(dto.getStudentId());
            entity.setStudent(student);
        }
        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity year = new AcademicYearEntity();
            year.setId(dto.getAcademicYearId());
        }
        // Note: ReportCardEntity only has generatedAt and fileUrl fields
        // DTO doesn't have active field, entity will use default value
        return entity;
    }

    public static ReportCardResponseDTO toResponse(ReportCardEntity entity) {
        if (entity == null)
            return null;
        ReportCardResponseDTO dto = new ReportCardResponseDTO();
        dto.setId(entity.getId());
        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentName(entity.getStudent().getFullName());
        }
        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }
        dto.setGeneratedAt(entity.getGeneratedAt());
        dto.setFileUrl(entity.getFileUrl());
        return dto;
    }

    public static List<ReportCardResponseDTO> toReportCardResponseList(List<ReportCardEntity> entities) {
        return entities == null ? null : entities.stream().map(ResultsMapper::toResponse).collect(Collectors.toList());
    }

    // Grade Scale
    public static GradeScaleEntity toEntity(GradeScaleRequestDTO dto) {
        if (dto == null)
            return null;
        GradeScaleEntity entity = new GradeScaleEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setGrade(dto.getGrade());
        entity.setMinPercentage(dto.getMinPercentage());
        entity.setMaxPercentage(dto.getMaxPercentage());
        //entity.setPoints(dto.getPoints());
        entity.setRemarks(dto.getRemarks());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static GradeScaleResponseDTO toResponse(GradeScaleEntity entity) {
        if (entity == null)
            return null;
        GradeScaleResponseDTO dto = new GradeScaleResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setGrade(entity.getGrade());
        dto.setMinPercentage(entity.getMinPercentage());
        dto.setMaxPercentage(entity.getMaxPercentage());
        //dto.setPoints(entity.getPoints());
        dto.setRemarks(entity.getRemarks());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static List<GradeScaleResponseDTO> toGradeScaleResponseList(List<GradeScaleEntity> entities) {
        return entities == null ? null : entities.stream().map(ResultsMapper::toResponse).collect(Collectors.toList());
    }
}
