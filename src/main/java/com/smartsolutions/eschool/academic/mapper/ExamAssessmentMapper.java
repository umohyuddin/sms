package com.smartsolutions.eschool.academic.mapper;

import com.smartsolutions.eschool.academic.dto.request.*;
import com.smartsolutions.eschool.academic.dto.response.*;
import com.smartsolutions.eschool.academic.entity.mapping.*;
import com.smartsolutions.eschool.academic.entity.master.*;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ExamAssessmentMapper {

    private ExamAssessmentMapper() {
        // prevent instantiation
    }

    // Exam Type
    public static ExamTypeEntity toEntity(ExamTypeRequestDTO dto) {
        if (dto == null)
            return null;
        ExamTypeEntity entity = new ExamTypeEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription()); // Object type
        entity.setActive(dto.isActive());
        return entity;
    }

    public static ExamTypeResponseDTO toResponse(ExamTypeEntity entity) {
        if (entity == null)
            return null;
        ExamTypeResponseDTO dto = new ExamTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<ExamTypeResponseDTO> toResponseList(List<ExamTypeEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }

    // Exam Term
    public static ExamTermEntity toEntity(ExamTermRequestDTO dto) {
        if (dto == null)
            return null;
        ExamTermEntity entity = new ExamTermEntity();
        entity.setName(dto.getName());
        entity.setSequenceNo(dto.getSequenceNo());
        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity ay = new AcademicYearEntity();
            ay.setId(dto.getAcademicYearId());
            entity.setAcademicYear(ay);
        }
        entity.setActive(dto.isActive());
        return entity;
    }

    public static ExamTermResponseDTO toResponse(ExamTermEntity entity) {
        if (entity == null)
            return null;
        ExamTermResponseDTO dto = new ExamTermResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSequenceNo(entity.getSequenceNo());
        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<ExamTermResponseDTO> toTermResponseList(List<ExamTermEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }

    // Assessment Type
    public static AssessmentTypeEntity toEntity(AssessmentTypeRequestDTO dto) {
        if (dto == null)
            return null;
        AssessmentTypeEntity entity = new AssessmentTypeEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static AssessmentTypeResponseDTO toResponse(AssessmentTypeEntity entity) {
        if (entity == null)
            return null;
        AssessmentTypeResponseDTO dto = new AssessmentTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<AssessmentTypeResponseDTO> toAssessmentTypeResponseList(List<AssessmentTypeEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }

    // Exam
    public static ExamEntity toEntity(ExamRequestDTO dto) {
        if (dto == null)
            return null;
        ExamEntity entity = new ExamEntity();
        entity.setName(dto.getName());
        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity ay = new AcademicYearEntity();
            ay.setId(dto.getAcademicYearId());
            entity.setAcademicYear(ay);
        }
        if (dto.getExamTermId() != null) {
            ExamTermEntity et = new ExamTermEntity();
            et.setId(dto.getExamTermId());
            entity.setExamTerm(et);
        }
        if (dto.getCampusId() != null) {
            CampusEntity c = new CampusEntity();
            c.setId(dto.getCampusId());
            entity.setCampus(c);
        }
        if (dto.getStandardId() != null) {
            StandardEntity s = new StandardEntity();
            s.setId(dto.getStandardId());
            entity.setStandard(s);
        }
        if (dto.getSectionId() != null) {
            SectionEntity s = new SectionEntity();
            s.setId(dto.getSectionId());
            entity.setSection(s);
        }
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static ExamResponseDTO toResponse(ExamEntity entity) {
        if (entity == null)
            return null;
        ExamResponseDTO dto = new ExamResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }
        if (entity.getExamTerm() != null) {
            dto.setExamTermId(entity.getExamTerm().getId());
            dto.setExamTermName(entity.getExamTerm().getName());
        }
        if (entity.getCampus() != null) {
            dto.setCampusId(entity.getCampus().getId());
            dto.setCampusName(entity.getCampus().getCampusName());
        }
        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }
        if (entity.getSection() != null) {
            dto.setSectionId(entity.getSection().getId());
            dto.setSectionName(entity.getSection().getSectionName());
        }
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<ExamResponseDTO> toExamResponseList(List<ExamEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }

    // Exam Subject
    public static ExamSubjectEntity toEntity(ExamSubjectRequestDTO dto) {
        if (dto == null)
            return null;
        ExamSubjectEntity entity = new ExamSubjectEntity();
        // ID is auto-generated

        if (dto.getExamId() != null) {
            ExamEntity exam = new ExamEntity();
            exam.setId(dto.getExamId());
            entity.setExam(exam);
        }

        if (dto.getSubjectId() != null) {
            SubjectEntity subject = new SubjectEntity();
            subject.setId(dto.getSubjectId());
            entity.setSubject(subject);
        }

        if (dto.getEvaluatorId() != null) {
            EmployeeMasterEntity evaluator = new EmployeeMasterEntity();
            evaluator.setId(dto.getEvaluatorId());
            entity.setEvaluator(evaluator);
        }

        entity.setExamDate(dto.getExamDate());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime()); // Entity has endTime, not durationMinutes
        entity.setTotalMarks(dto.getTotalMarks());
        entity.setPassingMarks(dto.getPassingMarks());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static ExamSubjectResponseDTO toResponse(ExamSubjectEntity entity) {
        if (entity == null)
            return null;
        ExamSubjectResponseDTO dto = new ExamSubjectResponseDTO();
        dto.setId(entity.getId());

        if (entity.getExam() != null) {
            dto.setExamId(entity.getExam().getId());
            dto.setExamName(entity.getExam().getName());
        }
        if (entity.getSubject() != null) {
            dto.setSubjectId(entity.getSubject().getId());
            dto.setSubjectName(entity.getSubject().getName());
        }
        if (entity.getEvaluator() != null) {
            dto.setEvaluatorId(entity.getEvaluator().getId());
            dto.setEvaluatorName(entity.getEvaluator().getFullName());
        }
        dto.setExamDate(entity.getExamDate());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        // Calculate duration if both times are present
        if (entity.getStartTime() != null && entity.getEndTime() != null) {
            long minutes = java.time.Duration.between(entity.getStartTime(), entity.getEndTime()).toMinutes();
            dto.setDurationMinutes((int) minutes);
        }
        dto.setTotalMarks(entity.getTotalMarks());
        dto.setPassingMarks(entity.getPassingMarks());
        dto.setActive(entity.isActive()); // DTO has boolean isActive field
        return dto;
    }

    public static List<ExamSubjectResponseDTO> toExamSubjectResponseList(List<ExamSubjectEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }

    // Assessment
    public static AssessmentEntity toEntity(AssessmentRequestDTO dto) {
        if (dto == null)
            return null;
        AssessmentEntity entity = new AssessmentEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        if (dto.getTeacherSubjectAssignmentId() != null) {
            TeacherSubjectAssignmentEntity tsa = new TeacherSubjectAssignmentEntity();
            tsa.setId(dto.getTeacherSubjectAssignmentId());
            entity.setTeacherSubjectAssignment(tsa);
        }
        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity ay = new AcademicYearEntity();
            ay.setId(dto.getAcademicYearId());
            entity.setAcademicYear(ay);
        }
        if (dto.getAssessmentTypeId() != null) {
            AssessmentTypeEntity at = new AssessmentTypeEntity();
            at.setId(dto.getAssessmentTypeId());
            entity.setAssessmentType(at);
        }
        entity.setAssessmentDate(dto.getAssessmentDate());
        entity.setTotalMarks(dto.getTotalMarks());
        entity.setPassingMarks(dto.getPassingMarks());
        // Note: entity doesn't have weightagePercentage field
        entity.setActive(dto.isActive());
        return entity;
    }

    public static AssessmentResponseDTO toResponse(AssessmentEntity entity) {
        if (entity == null)
            return null;
        AssessmentResponseDTO dto = new AssessmentResponseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        if (entity.getTeacherSubjectAssignment() != null) {
            dto.setTeacherSubjectAssignmentId(entity.getTeacherSubjectAssignment().getId());
            if (entity.getTeacherSubjectAssignment().getSubject() != null) {
                dto.setSubjectName(entity.getTeacherSubjectAssignment().getSubject().getName());
            }
            if (entity.getTeacherSubjectAssignment().getTeacher() != null) {
                dto.setTeacherName(entity.getTeacherSubjectAssignment().getTeacher().getFullName());
            }
        }
        if (entity.getAssessmentType() != null) {
            dto.setAssessmentTypeId(entity.getAssessmentType().getId());
            dto.setAssessmentTypeName(entity.getAssessmentType().getName());
        }
        // academicYearId and academicYearName fields don't exist in
        // AssessmentResponseDTO
        dto.setAssessmentDate(entity.getAssessmentDate());
        dto.setTotalMarks(entity.getTotalMarks());
        dto.setPassingMarks(entity.getPassingMarks());
        // Note: entity doesn't have weightagePercentage field
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<AssessmentResponseDTO> toAssessmentResponseList(List<AssessmentEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }

    // Student Assessment
    public static StudentAssessmentEntity toEntity(StudentAssessmentRequestDTO dto) {
        if (dto == null)
            return null;
        StudentAssessmentEntity entity = new StudentAssessmentEntity();
        // ID is auto-generated

        if (dto.getAssessmentId() != null) {
            AssessmentEntity assessment = new AssessmentEntity();
            assessment.setId(dto.getAssessmentId());
            entity.setAssessment(assessment);
        }

        if (dto.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(dto.getStudentId());
            entity.setStudent(student);
        }

        entity.setObtainedMarks(dto.getObtainedMarks());
        entity.setGrade(dto.getGrade());
        entity.setRemarks(dto.getRemarks());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static StudentAssessmentResponseDTO toResponse(StudentAssessmentEntity entity) {
        if (entity == null)
            return null;
        StudentAssessmentResponseDTO dto = new StudentAssessmentResponseDTO();
        // id field doesn't exist in StudentAssessmentResponseDTO

        if (entity.getAssessment() != null) {
            dto.setAssessmentId(entity.getAssessment().getId());
            dto.setAssessmentTitle(entity.getAssessment().getTitle());
        }
        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentName(entity.getStudent().getFullName());
            dto.setStudentCode(entity.getStudent().getStudentCode());
        }
        if (entity.getEvaluatedBy() != null) {
            // evaluatedById field doesn't exist in StudentAssessmentResponseDTO
            dto.setEvaluatedBy(entity.getEvaluatedBy().getFullName());
        }
        dto.setObtainedMarks(entity.getObtainedMarks());
        dto.setGrade(entity.getGrade());
        dto.setRemarks(entity.getRemarks());
        // active field doesn't exist in StudentAssessmentResponseDTO
        return dto;
    }

    public static List<StudentAssessmentResponseDTO> toStudentAssessmentResponseList(
            List<StudentAssessmentEntity> entities) {
        return entities == null ? null
                : entities.stream().map(ExamAssessmentMapper::toResponse).collect(Collectors.toList());
    }
}
