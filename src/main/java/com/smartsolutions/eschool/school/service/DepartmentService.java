package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.mapper.DepartmentMapper;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeMasterRepository employeeMasterRepository;
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeMasterRepository employeeMasterRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeMasterRepository = employeeMasterRepository;
    }

    public DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO requestDTO) {
        log.info("Creating new Department: {}", requestDTO.getDepartmentName());
        try {
            DepartmentEntity entity = DepartmentMapper.INSTANCE.toEntity(requestDTO);
            // Fetch and set parent department if provided
            if (requestDTO.getParentDepartmentId() != null) {
                DepartmentEntity parent = departmentRepository.findById(requestDTO.getParentDepartmentId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Parent Department not found with id: " + requestDTO.getParentDepartmentId()));
                entity.setParentDepartment(parent);
            } else {
                entity.setParentDepartment(null);
            }

            // Fetch and set head employee if provided, else set null
            if (requestDTO.getHeadEmployeeId() != null) {
                EmployeeMasterEntity headEmployee = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Employee not found with id: " + requestDTO.getHeadEmployeeId()));
                entity.setHeadEmployee(headEmployee);
            } else {
                entity.setHeadEmployee(null);
            }

            departmentRepository.save(entity);
            log.info("Department saved with id: {}", entity.getId());
            return MapperUtil.mapObject(entity, DepartmentResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Department", dae);
            throw new CustomServiceException("Failed to create Department due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Department", e);
            throw new CustomServiceException("Failed to create Department");
        }
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        try {
            log.info("Fetching all Departments from database");
            List<DepartmentEntity> departments = departmentRepository.findAllActiveDepartments();
            return departments.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Departments", dae);
            throw new CustomServiceException("Unable to fetch Departments from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping Department Entity to DTO", me);
            throw new CustomServiceException("Error converting Department data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Departments", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public DepartmentResponseDTO getDepartmentById(Long id) {
        log.info("Fetching Department with id={}", id);
        DepartmentEntity entity = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        return toDto(entity);
    }

    public DepartmentResponseDTO updateDepartment(Long id, @Valid DepartmentRequestDTO requestDTO) {
        log.info("Updating Department with id={}", id);
        try {
            DepartmentEntity existing = departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

            existing.setDepartmentName(requestDTO.getDepartmentName());
            existing.setDepartmentCode(requestDTO.getDepartmentCode());
            existing.setDescription(requestDTO.getDescription());
            existing.setActive(requestDTO.getActive());

            if (requestDTO.getParentDepartmentId() != null) {
                DepartmentEntity parent = departmentRepository.findById(requestDTO.getParentDepartmentId())
                        .orElseThrow(() -> new ResourceNotFoundException("Parent Department not found with id: " + requestDTO.getParentDepartmentId()));
                existing.setParentDepartment(parent);
            } else {
                existing.setParentDepartment(null);
            }

            departmentRepository.save(existing);
            log.info("Department updated successfully with id={}", existing.getId());
            return toDto(existing);
        } catch (DataAccessException dae) {
            log.error("Database error while updating Department with id={}", id, dae);
            throw new CustomServiceException("Failed to update Department due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating Department with id={}", id, e);
            throw new CustomServiceException("Unexpected error occurred while updating Department", e);
        }
    }

    public void deleteDepartment(Long id) {
        log.info("Soft deleting Department with id={}", id);
        try {
            DepartmentEntity existing = departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
            existing.setDeleted(true);
            departmentRepository.save(existing);
            log.info("Department soft deleted with id={}", id);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting Department with id={}", id, dae);
            throw new CustomServiceException("Failed to delete Department due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while deleting Department with id={}", id, e);
            throw new CustomServiceException("Unexpected error occurred while deleting Department", e);
        }
    }

    public List<DepartmentResponseDTO> getAllActiveDepartments() {
        try {
            log.info("Fetching all active Departments");
            List<DepartmentEntity> departments = departmentRepository.findAllActiveDepartments();
            return departments.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error fetching active Departments", e);
            throw new CustomServiceException("Failed to fetch active Departments", e);
        }
    }

    private DepartmentResponseDTO toDto(DepartmentEntity entity) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(entity.getId());
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentName(entity.getDepartmentName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setParentDepartmentName(entity.getParentDepartment() != null ? entity.getParentDepartment().getDepartmentName() : null);
        dto.setParentDepartmentId(entity.getParentDepartment() != null ? entity.getParentDepartment().getId() : null);
        dto.setHeadEmployeeId(entity.getHeadEmployee() != null ? entity.getHeadEmployee().getId() : null);
        return dto;
    }
}