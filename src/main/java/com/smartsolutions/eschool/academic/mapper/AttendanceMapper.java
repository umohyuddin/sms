package com.smartsolutions.eschool.academic.mapper;

import com.smartsolutions.eschool.academic.dto.request.EmployeeAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.EmployeeAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.EmployeeAttendanceEntity;
import com.smartsolutions.eschool.academic.entity.master.StudentAttendanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    // Student Attendance
    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "standard.id", source = "standardId")
    @Mapping(target = "section.id", source = "sectionId")
    @Mapping(target = "markedBy.id", source = "markedById")
    StudentAttendanceEntity toEntity(StudentAttendanceRequestDTO dto);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "studentName", source = "student.fullName")
    @Mapping(target = "standardId", source = "standard.id")
    @Mapping(target = "standardName", source = "standard.standardName")
    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "sectionName", source = "section.sectionName")
    @Mapping(target = "markedBy", source = "markedBy.fullName")
    StudentAttendanceResponseDTO toResponse(StudentAttendanceEntity entity);

    // Employee Attendance
    @Mapping(target = "employee.id", source = "employeeId")
    EmployeeAttendanceEntity toEntity(EmployeeAttendanceRequestDTO dto);

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", source = "employee.fullName")
    EmployeeAttendanceResponseDTO toResponse(EmployeeAttendanceEntity entity);
}
