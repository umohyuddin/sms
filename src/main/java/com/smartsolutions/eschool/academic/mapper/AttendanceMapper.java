package com.smartsolutions.eschool.academic.mapper;

import com.smartsolutions.eschool.academic.dto.request.EmployeeAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.EmployeeAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.EmployeeAttendanceEntity;
import com.smartsolutions.eschool.academic.entity.master.StudentAttendanceEntity;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AttendanceMapper {

    private AttendanceMapper() {
        // prevent instantiation
    }

    // Student Attendance
    public static StudentAttendanceEntity toEntity(StudentAttendanceRequestDTO dto) {
        if (dto == null) return null;
        StudentAttendanceEntity entity = new StudentAttendanceEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        
        if (dto.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(dto.getStudentId());
            entity.setStudent(student);
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
        
        if (dto.getMarkedById() != null) {
            EmployeeMasterEntity markedBy = new EmployeeMasterEntity();
            markedBy.setId(dto.getMarkedById());
            entity.setMarkedBy(markedBy);
        }

        entity.setAttendanceDate(dto.getAttendanceDate());
        entity.setStatus(dto.getStatus());
        entity.setRemarks(dto.getRemarks());
        //entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        return entity;
    }

    public static StudentAttendanceResponseDTO toResponse(StudentAttendanceEntity entity) {
        if (entity == null) return null;
        StudentAttendanceResponseDTO dto = new StudentAttendanceResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        
        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentName(entity.getStudent().getFullName());
        }
        
        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }
        
        if (entity.getSection() != null) {
            dto.setSectionId(entity.getSection().getId());
            dto.setSectionName(entity.getSection().getSectionName());
        }
        
        if (entity.getMarkedBy() != null) {
            dto.setMarkedBy(entity.getMarkedBy().getFullName());
        }

        dto.setAttendanceDate(entity.getAttendanceDate());
        dto.setStatus(entity.getStatus());
        dto.setRemarks(entity.getRemarks());
        dto.setOrganizationId(entity.getOrganizationId());
        //dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public static List<StudentAttendanceResponseDTO> toStudentAttendanceResponseList(List<StudentAttendanceEntity> entities) {
        return entities == null ? null : entities.stream().map(AttendanceMapper::toResponse).collect(Collectors.toList());
    }

    // Employee Attendance
    public static EmployeeAttendanceEntity toEntity(EmployeeAttendanceRequestDTO dto) {
        if (dto == null) return null;
        EmployeeAttendanceEntity entity = new EmployeeAttendanceEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        
        if (dto.getEmployeeId() != null) {
            EmployeeMasterEntity employee = new EmployeeMasterEntity();
            employee.setId(dto.getEmployeeId());
            entity.setEmployee(employee);
        }
        
        entity.setAttendanceDate(dto.getAttendanceDate());
        entity.setStatus(dto.getStatus());
        entity.setRemarks(dto.getRemarks());
        //entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        return entity;
    }

    public static EmployeeAttendanceResponseDTO toResponse(EmployeeAttendanceEntity entity) {
        if (entity == null) return null;
        EmployeeAttendanceResponseDTO dto = new EmployeeAttendanceResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        
        if (entity.getEmployee() != null) {
            dto.setEmployeeId(entity.getEmployee().getId());
            dto.setEmployeeName(entity.getEmployee().getFullName());
        }

        dto.setAttendanceDate(entity.getAttendanceDate());
        dto.setStatus(entity.getStatus());
        dto.setRemarks(entity.getRemarks());
        dto.setOrganizationId(entity.getOrganizationId());
        //dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public static List<EmployeeAttendanceResponseDTO> toEmployeeAttendanceResponseList(List<EmployeeAttendanceEntity> entities) {
        return entities == null ? null : entities.stream().map(AttendanceMapper::toResponse).collect(Collectors.toList());
    }
}
