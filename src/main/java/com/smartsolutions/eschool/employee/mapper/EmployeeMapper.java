package com.smartsolutions.eschool.employee.mapper;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.model.EmployeeAssignmentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Static utility mapper for Employee domain objects.
 * Provides entity-to-DTO mapping without depending on assignment repository at this layer.
 * Assignment enrichment should be performed in the Service layer after calling toBaseDTO.
 */
public class EmployeeMapper {

    private EmployeeMapper() {
        // utility class — do not instantiate
    }

    /**
     * Maps an EmployeeMasterEntity to a base EmployeeMasterResponseDto (without assignment details).
     * Call enrichWithAssignment() separately to populate campus/department/designation fields.
     */
    public static EmployeeMasterResponseDto toBaseDTO(EmployeeMasterEntity entity) {
        if (entity == null) return null;

        return EmployeeMasterResponseDto.builder()
                .id(entity.getId())
                .employeeCode(entity.getEmployeeCode())
                .firstName(entity.getFirstName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .fullName(entity.getFullName())
                .gender(entity.getGender())
                .dateOfBirth(entity.getDateOfBirth())
                .maritalStatus(entity.getMaritalStatus())
                .religion(entity.getReligion())
                .nationality(entity.getNationality())
                .bloodGroup(entity.getBloodGroup())
                .email(entity.getEmail())
                .primaryPhone(entity.getPrimaryPhone())
                .secondaryPhone(entity.getSecondaryPhone())
                .workPhone(entity.getWorkPhone())
                .joiningDate(entity.getJoiningDate())
                .probationEndDate(entity.getProbationEndDate())
                .employeeTypeId(entity.getEmployeeType() != null ? entity.getEmployeeType().getId() : null)
                .employeeTypeName(entity.getEmployeeType() != null ? entity.getEmployeeType().getName() : null)
                .profilePicture(entity.getProfilePicture())
                .bio(entity.getBio())
                .active(entity.getActive())
                .build();
    }

    /**
     * Enriches an existing DTO with primary assignment data (campus, department, designation).
     */
    public static void enrichWithAssignment(EmployeeMasterResponseDto dto, EmployeeAssignmentEntity assignment) {
        if (dto == null || assignment == null) return;

        if (assignment.getCampus() != null) {
            dto.setCampusId(assignment.getCampus().getId());
            dto.setCampusName(assignment.getCampus().getCampusName());
        }
        if (assignment.getDepartment() != null) {
            dto.setDepartmentId(assignment.getDepartment().getId());
            dto.setDepartmentName(assignment.getDepartment().getDepartmentName());
        }
        if (assignment.getDesignation() != null) {
            dto.setDesignationId(assignment.getDesignation().getId());
            dto.setDesignationName(assignment.getDesignation().getDesignationName());
        }
    }

    /**
     * Maps a list of entities to a list of base DTOs (without assignment enrichment).
     */
    public static List<EmployeeMasterResponseDto> toBaseDTOList(List<EmployeeMasterEntity> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .map(EmployeeMapper::toBaseDTO)
                .collect(Collectors.toList());
    }
}
