package com.smartsolutions.sms.academic.mapper;

import com.smartsolutions.sms.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.sms.academic.dto.request.TimetableRequestDTO;
import com.smartsolutions.sms.academic.dto.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.sms.academic.dto.response.TimetableResponseDTO;
import com.smartsolutions.sms.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import com.smartsolutions.sms.academic.entity.master.TimetableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherAssignmentMapper {

    TeacherAssignmentMapper INSTANCE = Mappers.getMapper(TeacherAssignmentMapper.class);

    @Mapping(target = "id.employeeId", source = "employeeId")
    @Mapping(target = "id.standardId", source = "standardId")
    @Mapping(target = "id.sectionId", source = "sectionId")
    @Mapping(target = "id.subjectId", source = "subjectId")
    @Mapping(target = "id.academicYearId", source = "academicYearId")
    @Mapping(target = "id.effectiveFrom", source = "effectiveFrom")
    @Mapping(target = "teacher.id", source = "employeeId")
    @Mapping(target = "standard.id", source = "standardId")
    @Mapping(target = "section.id", source = "sectionId")
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    TeacherSubjectAssignmentEntity toEntity(TeacherSubjectAssignmentRequestDTO dto);

    @Mapping(target = "employeeId", source = "id.employeeId")
    @Mapping(target = "employeeName", source = "teacher.fullName")
    @Mapping(target = "standardId", source = "id.standardId")
    @Mapping(target = "standardName", source = "standard.standardName")
    @Mapping(target = "sectionId", source = "id.sectionId")
    @Mapping(target = "sectionName", source = "section.sectionName")
    @Mapping(target = "subjectId", source = "id.subjectId")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "academicYearId", source = "id.academicYearId")
    @Mapping(target = "academicYearName", source = "academicYear.name")
    @Mapping(target = "effectiveFrom", source = "id.effectiveFrom")
    TeacherSubjectAssignmentResponseDTO toResponse(TeacherSubjectAssignmentEntity entity);

    // Timetable
    @Mapping(target = "standard.id", source = "standardId")
    @Mapping(target = "section.id", source = "sectionId")
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "teacher.id", source = "teacherId")
    TimetableEntity toEntity(TimetableRequestDTO dto);

    @Mapping(target = "standardId", source = "standard.id")
    @Mapping(target = "standardName", source = "standard.standardName")
    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "sectionName", source = "section.sectionName")
    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "teacherId", source = "teacher.id")
    @Mapping(target = "teacherName", source = "teacher.fullName")
    TimetableResponseDTO toResponse(TimetableEntity entity);
}
