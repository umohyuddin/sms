package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import java.util.List;
import java.util.stream.Collectors;

public class StudentFeeSummaryMapper {

    private StudentFeeSummaryMapper() {
        // Prevent instantiation
    }

    public static StudentFeeSummaryDTO toSummaryDTO(StudentFeeSummaryEntity entity) {
        if (entity == null) {
            return null;
        }

        StudentFeeSummaryDTO dto = new StudentFeeSummaryDTO();
        dto.setId(entity.getId());
        dto.setTotalAssignedFee(entity.getTotalAssignedFee());
        dto.setTotalDiscount(entity.getTotalDiscount());
        dto.setTotalPaid(entity.getTotalPaid());
        dto.setTotalLateFee(entity.getTotalLateFee());
        dto.setTotalTax(entity.getTotalTax());
        dto.setBalance(entity.getBalance());

        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentFullName(entity.getStudent().getFullName());
        }

        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
            dto.setStartDate(entity.getAcademicYear().getStartDate());
            dto.setEndDate(entity.getAcademicYear().getEndDate());
            dto.setAcademicTotalMonths(entity.getAcademicYear().getTotalMonths());
        }

        return dto;
    }

    public static List<StudentFeeSummaryDTO> toSummaryDTOList(List<StudentFeeSummaryEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(StudentFeeSummaryMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    public static StudentFeeSummaryResponseDto toDetailedResponseDTO(StudentFeeSummaryEntity entity) {
        if (entity == null) {
            return null;
        }

        StudentFeeSummaryResponseDto dto = new StudentFeeSummaryResponseDto();
        dto.setId(entity.getId());
        dto.setTotalAssignedFee(entity.getTotalAssignedFee());
        dto.setTotalPaid(entity.getTotalPaid());
        dto.setTotalLateFee(entity.getTotalLateFee());
        dto.setTotalTax(entity.getTotalTax());
        dto.setBalance(entity.getBalance());

        if (entity.getStudent() != null) {
            dto.setStudentId(entity.getStudent().getId());
            dto.setStudentFullName(entity.getStudent().getFullName());
        }

        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
            dto.setAcademicStartDate(entity.getAcademicYear().getStartDate());
            dto.setAcademicEndDate(entity.getAcademicYear().getEndDate());
            dto.setAcademicTotalMonths(entity.getAcademicYear().getTotalMonths());
        }

        return dto;
    }
}
