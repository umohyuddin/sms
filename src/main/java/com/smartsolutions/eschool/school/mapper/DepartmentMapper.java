package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {

    private DepartmentMapper() {
        // prevent instantiation
    }

    public static DepartmentEntity toEntity(DepartmentRequestDTO dto) {
        if (dto == null) return null;
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentName(dto.getDepartmentName());
        entity.setDepartmentCode(dto.getDepartmentCode());
        entity.setDescription(dto.getDescription());
        
        if (dto.getParentDepartmentId() != null) {
            DepartmentEntity parent = new DepartmentEntity();
            parent.setId(dto.getParentDepartmentId());
            entity.setParentDepartment(parent);
        }
        
        if (dto.getHeadEmployeeId() != null) {
            EmployeeMasterEntity head = new EmployeeMasterEntity();
            head.setId(dto.getHeadEmployeeId());
            entity.setHeadEmployee(head);
        }
        
        entity.setActive(dto.getActive());
        return entity;
    }

    public static DepartmentResponseDTO toResponseDTO(DepartmentEntity entity) {
        if (entity == null) return null;
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(entity.getId());
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentName(entity.getDepartmentName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        
        if (entity.getParentDepartment() != null) {
            dto.setParentDepartmentId(entity.getParentDepartment().getId());
            dto.setParentDepartmentName(entity.getParentDepartment().getDepartmentName());
        }
        
        if (entity.getHeadEmployee() != null) {
            dto.setHeadEmployeeId(entity.getHeadEmployee().getId());
            dto.setHeadEmployeeCode(entity.getHeadEmployee().getEmployeeCode());
            dto.setHeadEmployeeName(entity.getHeadEmployee().getFullName());
        }
        
        dto.setDeleted(entity.getDeleted());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        
        return dto;
    }

    public static List<DepartmentResponseDTO> toResponseDTOList(List<DepartmentEntity> entities) {
        return entities == null ? null : entities.stream().map(DepartmentMapper::toResponseDTO).collect(Collectors.toList());
    }
}
