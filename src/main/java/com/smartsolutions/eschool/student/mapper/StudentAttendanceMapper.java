package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentAttendanceMapper {

    public static StudentAttendanceEntity toEntity(StudentAttendanceRequestDTO dto) {
        if (dto == null) return null;
        return StudentAttendanceEntity.builder()
                .id(dto.getId())
                .attendanceDate(dto.getAttendanceDate())
                .status(StudentAttendanceEntity.AttendanceStatus.valueOf(dto.getStatus()))
                .markedBy(dto.getMarkedById())
                .remarks(dto.getRemarks())
                .build();
    }

    public static StudentAttendanceResponseDTO toResponseDTO(StudentAttendanceEntity entity) {
        if (entity == null) return null;
        return StudentAttendanceResponseDTO.builder()
                .id(entity.getId())
                .organizationId(entity.getOrganization() != null ? entity.getOrganization().getId() : null)
                .campusId(entity.getCampus() != null ? entity.getCampus().getId() : null)
                .campusName(entity.getCampus() != null ? entity.getCampus().getCampusName() : null)
                .studentId(entity.getStudent() != null ? entity.getStudent().getId() : null)
                .studentName(entity.getStudent() != null ? entity.getStudent().getFullName() : null)
                .studentCode(entity.getStudent() != null ? entity.getStudent().getStudentCode() : null)
                .standardId(entity.getStandard() != null ? entity.getStandard().getId() : null)
                .standardName(entity.getStandard() != null ? entity.getStandard().getStandardName() : null)
                .sectionId(entity.getSection() != null ? entity.getSection().getId() : null)
                .sectionName(entity.getSection() != null ? entity.getSection().getSectionName() : null)
                .attendanceDate(entity.getAttendanceDate())
                .status(entity.getStatus().name())
                .markedById(entity.getMarkedBy())
                .remarks(entity.getRemarks())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deleted(entity.isDeleted())
                .build();
    }

    public static List<StudentAttendanceResponseDTO> toResponseDTOList(List<StudentAttendanceEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(StudentAttendanceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntityFromDTO(StudentAttendanceEntity entity, StudentAttendanceRequestDTO dto) {
        if (entity == null || dto == null) return;
        if (dto.getAttendanceDate() != null) entity.setAttendanceDate(dto.getAttendanceDate());
        if (dto.getStatus() != null) entity.setStatus(StudentAttendanceEntity.AttendanceStatus.valueOf(dto.getStatus()));
        if (dto.getMarkedById() != null) entity.setMarkedBy(dto.getMarkedById());
        if (dto.getRemarks() != null) entity.setRemarks(dto.getRemarks());
    }

    public static StudentAttendanceResponseDTO mapToProtoResponse(com.smartsolutions.eschool.student.model.StudentEntity student, java.time.LocalDate date, Long organizationId) {
        if (student == null) return null;
        return StudentAttendanceResponseDTO.builder()
                .id(null)
                .organizationId(organizationId)
                .campusId(student.getCampus() != null ? student.getCampus().getId() : null)
                .campusName(student.getCampus() != null ? student.getCampus().getCampusName() : null)
                .studentId(student.getId())
                .studentName(student.getFullName())
                .studentCode(student.getStudentCode())
                .standardId(student.getStandard() != null ? student.getStandard().getId() : null)
                .standardName(student.getStandard() != null ? student.getStandard().getStandardName() : null)
                .sectionId(student.getSection() != null ? student.getSection().getId() : null)
                .sectionName(student.getSection() != null ? student.getSection().getSectionName() : null)
                .attendanceDate(date)
                .status(null)
                .build();
    }
}
