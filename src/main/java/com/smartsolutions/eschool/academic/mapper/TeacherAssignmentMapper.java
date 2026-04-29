package com.smartsolutions.eschool.academic.mapper;

import com.smartsolutions.eschool.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.TimetableRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.TimetableResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import com.smartsolutions.eschool.academic.entity.master.TimetableEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherAssignmentMapper {

    private TeacherAssignmentMapper() {
        // prevent instantiation
    }

    // TeacherSubjectAssignment
    public static TeacherSubjectAssignmentEntity toEntity(TeacherSubjectAssignmentRequestDTO dto) {
        if (dto == null)
            return null;
        TeacherSubjectAssignmentEntity entity = new TeacherSubjectAssignmentEntity();
        // ID is auto-generated

        if (dto.getEmployeeId() != null) {
            EmployeeMasterEntity teacher = new EmployeeMasterEntity();
            teacher.setId(dto.getEmployeeId());
            entity.setTeacher(teacher);
        }

        if (dto.getStandardId() != null) {
            StandardEntity standard = new StandardEntity();
            standard.setId(dto.getStandardId());
            entity.setStandard(standard);
        }

        if (dto.getSectionId() != null) {
            SectionEntity section = new SectionEntity();
            section.setId(dto.getSectionId());
            entity.setSection(section);
        }

        if (dto.getSubjectId() != null) {
            SubjectEntity subject = new SubjectEntity();
            subject.setId(dto.getSubjectId());
            entity.setSubject(subject);
        }

        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity year = new AcademicYearEntity();
            year.setId(dto.getAcademicYearId());
            entity.setAcademicYear(year);
        }

        entity.setEffectiveFrom(dto.getEffectiveFrom());
        entity.setEffectiveTo(dto.getEffectiveTo());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static TeacherSubjectAssignmentResponseDTO toResponse(TeacherSubjectAssignmentEntity entity) {
        if (entity == null)
            return null;
        TeacherSubjectAssignmentResponseDTO dto = new TeacherSubjectAssignmentResponseDTO();
        dto.setId(entity.getId());

        if (entity.getTeacher() != null) {
            dto.setEmployeeId(entity.getTeacher().getId());
            dto.setEmployeeName(entity.getTeacher().getFullName());
        }
        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }
        if (entity.getSection() != null) {
            dto.setSectionId(entity.getSection().getId());
            dto.setSectionName(entity.getSection().getSectionName());
        }
        if (entity.getSubject() != null) {
            dto.setSubjectId(entity.getSubject().getId());
            dto.setSubjectName(entity.getSubject().getName());
        }
        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }
        dto.setEffectiveFrom(entity.getEffectiveFrom());
        dto.setEffectiveTo(entity.getEffectiveTo());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<TeacherSubjectAssignmentResponseDTO> toTeacherAssignmentResponseList(
            List<TeacherSubjectAssignmentEntity> entities) {
        return entities == null ? null
                : entities.stream().map(TeacherAssignmentMapper::toResponse).collect(Collectors.toList());
    }

    // Timetable
    public static TimetableEntity toEntity(TimetableRequestDTO dto) {
        if (dto == null)
            return null;
        TimetableEntity entity = new TimetableEntity();
        // organizationId is handled automatically by AuditableEntity

        StandardEntity standard = new StandardEntity();
        standard.setId(dto.getStandardId());
        entity.setStandard(standard);

        SectionEntity section = new SectionEntity();
        section.setId(dto.getSectionId());
        entity.setSection(section);

        SubjectEntity subject = new SubjectEntity();
        subject.setId(dto.getSubjectId());
        entity.setSubject(subject);

        EmployeeMasterEntity teacher = new EmployeeMasterEntity();
        teacher.setId(dto.getTeacherId());
        entity.setTeacher(teacher);

        entity.setDayOfWeek(dto.getDayOfWeek());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static TimetableResponseDTO toResponse(TimetableEntity entity) {
        if (entity == null)
            return null;
        TimetableResponseDTO dto = new TimetableResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId()); // Read from entity for response

        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }
        if (entity.getSection() != null) {
            dto.setSectionId(entity.getSection().getId());
            dto.setSectionName(entity.getSection().getSectionName());
        }
        if (entity.getSubject() != null) {
            dto.setSubjectId(entity.getSubject().getId());
            dto.setSubjectName(entity.getSubject().getName());
        }
        if (entity.getTeacher() != null) {
            dto.setTeacherId(entity.getTeacher().getId());
            dto.setTeacherName(entity.getTeacher().getFullName());
        }

        dto.setDayOfWeek(entity.getDayOfWeek());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setIsActive(entity.isActive());
        return dto;
    }

    public static List<TimetableResponseDTO> toTimetableResponseList(List<TimetableEntity> entities) {
        return entities == null ? null
                : entities.stream().map(TeacherAssignmentMapper::toResponse).collect(Collectors.toList());
    }
}
