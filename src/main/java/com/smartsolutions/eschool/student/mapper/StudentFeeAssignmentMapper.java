package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for StudentFeeAssignmentEntity and StudentFeeSummaryEntity to DTOs.
 */
public class StudentFeeAssignmentMapper {

    private StudentFeeAssignmentMapper() {
        // prevent instantiation
    }

    public static StudentFeeAssignmentFlatDTO toFlatDTO(StudentFeeAssignmentEntity assignment) {
        if (assignment == null) {
            return null;
        }

        var student = assignment.getStudent();
        var feeRate = assignment.getFeeRate();
        var feeComponent = feeRate != null ? feeRate.getFeeComponent() : null;
        var feeCatalog = feeComponent != null ? feeComponent.getFeeCatalog() : null;

        StudentFeeAssignmentFlatDTO.StudentFeeAssignmentFlatDTOBuilder builder = StudentFeeAssignmentFlatDTO.builder();

        if (student != null) {
            builder.studentId(student.getId())
                    .studentCode(student.getStudentCode())
                    .fullName(student.getFullName())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .email(student.getEmail())
                    .phone(student.getPhone());
            
            if (student.getCampus() != null) {
                builder.campusId(student.getCampus().getId())
                        .campusName(student.getCampus().getCampusName());
            }
            if (student.getStandard() != null) {
                builder.standardId(student.getStandard().getId())
                        .standardName(student.getStandard().getStandardName());
            }
            if (student.getSection() != null) {
                builder.sectionId(student.getSection().getId())
                        .sectionName(student.getSection().getSectionName());
            }
            if (student.getAcademicYear() != null) {
                builder.academicYearId(student.getAcademicYear().getId())
                        .academicYearName(student.getAcademicYear().getName());
            }
        }

        builder.assignmentId(assignment.getId())
                .totalAmount(assignment.getTotalAmount())
                .assignedDate(assignment.getAssignedDate())
                .dueDate(assignment.getDueDate());

        if (feeRate != null) {
            builder.feeRateId(feeRate.getId())
                    .feeAmount(feeRate.getFixedAmount())
                    .currency(feeRate.getCurrency())
                    .feeEffectiveFrom(feeRate.getEffectiveFrom())
                    .feeEffectiveTo(feeRate.getEffectiveTo());
        }

        if (feeComponent != null) {
            builder.feeComponentId(feeComponent.getId())
                    .feeComponentCode(feeComponent.getComponentCode())
                    .feeComponentName(feeComponent.getComponentName())
                    .discountable(feeComponent.isDiscountable())
                    .taxable(feeComponent.isTaxable());
        }

        if (feeCatalog != null) {
            builder.feeCatalogId(feeCatalog.getId())
                    .feeCatalogCode(feeCatalog.getCode())
                    .feeCatalogName(feeCatalog.getName());
            if (feeCatalog.getChargeType() != null) {
               builder.feeCatalogChargeType(feeCatalog.getChargeType().getName());
            }
            if (feeCatalog.getRecurrenceRule() != null) {
                builder.feeCatalogRecurrenceRule(feeCatalog.getRecurrenceRule().getName());
            }
        }

        return builder.build();
    }

    public static List<StudentFeeAssignmentFlatDTO> toFlatDTOList(List<StudentFeeAssignmentEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(StudentFeeAssignmentMapper::toFlatDTO)
                .collect(Collectors.toList());
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
}
