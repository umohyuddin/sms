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
        log.info("Creating new Department in database: {}", requestDTO.getDepartmentName());
        try {
            DepartmentEntity entity = DepartmentMapper.INSTANCE.toEntity(requestDTO);
            // Fetch and set parent department if provided
            if (requestDTO.getParentDepartmentId() != null) {
                DepartmentEntity parent = departmentRepository.findById(requestDTO.getParentDepartmentId())
                        .orElseThrow(() -> {
                            log.warn("Parent Department not found with ID: {}", requestDTO.getParentDepartmentId());
                            return new ResourceNotFoundException("Parent Department not found with id: " + requestDTO.getParentDepartmentId());
                        });
                entity.setParentDepartment(parent);
            } else {
                entity.setParentDepartment(null);
            }

            // Fetch and set head employee if provided, else set null
            if (requestDTO.getHeadEmployeeId() != null) {
                EmployeeMasterEntity headEmployee = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                        .orElseThrow(() -> {
                            log.warn("Employee not found with ID: {}", requestDTO.getHeadEmployeeId());
                            return new ResourceNotFoundException("Employee not found with id: " + requestDTO.getHeadEmployeeId());
                        });
                entity.setHeadEmployee(headEmployee);
            } else {
                entity.setHeadEmployee(null);
            }

            DepartmentEntity saved = departmentRepository.save(entity);
            log.info("Department saved successfully with ID: {}", saved.getId());
            return MapperUtil.mapObject(saved, DepartmentResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while creating Department", e);
            throw new CustomServiceException("Failed to create Department");
        }
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        log.info("Fetching all active Departments from database");
        try {
            List<DepartmentEntity> departments = departmentRepository.findAllActiveDepartments();
            log.info("Successfully fetched {} active Departments", departments.size());
            return departments.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching Departments", e);
            throw new CustomServiceException("Unexpected error occurred while fetching departments", e);
        }
    }

    public DepartmentResponseDTO getDepartmentById(Long id) {
        log.info("Fetching Department with ID: {} from database", id);
        try {
            DepartmentEntity entity = departmentRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Department not found with ID: {}", id);
                        return new ResourceNotFoundException("Department not found with id: " + id);
                    });
            log.info("Successfully fetched Department: id={}", entity.getId());
            return toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Department ID: {}", id, e);
            throw new CustomServiceException("Unexpected error occurred while fetching department", e);
        }
    }

    public DepartmentResponseDTO updateDepartment(Long id, @Valid DepartmentRequestDTO requestDTO) {
        log.info("Updating Department with ID: {} in database", id);
        try {
            // Fetch existing department
            DepartmentEntity existing = findDepartmentOrThrow(id);

            // Update basic fields
            updateEntityFromDto(existing, requestDTO);

            if (requestDTO.getHeadEmployeeId() != null) {
                EmployeeMasterEntity headEmployee = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                        .orElseThrow(() -> {
                            log.warn("Head Employee not found for department update with ID: {}", requestDTO.getHeadEmployeeId());
                            return new ResourceNotFoundException("Head Employee not found with id: " + requestDTO.getHeadEmployeeId());
                        });
                existing.setHeadEmployee(headEmployee);
            } else {
                existing.setHeadEmployee(null);
            }
            // Handle parent department
            if (requestDTO.getParentDepartmentId() != null) {
                DepartmentEntity parent = findDepartmentOrThrow(requestDTO.getParentDepartmentId());
                existing.setParentDepartment(parent);
            } else {
                existing.setParentDepartment(null);
            }

            // Save changes
            DepartmentEntity updated = departmentRepository.save(existing);
            log.info("Department updated successfully with ID: {}", updated.getId());

            return toDto(updated);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating Department ID: {}", id, e);
            throw new CustomServiceException("Unexpected error occurred while updating Department", e);
        }
    }

    // Helper: Fetch department or throw exception
    private DepartmentEntity findDepartmentOrThrow(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Department not found with ID: {}", id);
                    return new ResourceNotFoundException("Department not found with id: " + id);
                });
    }

    // Helper: Map DTO to entity
    private void updateEntityFromDto(DepartmentEntity entity, DepartmentRequestDTO dto) {
        entity.setDepartmentName(dto.getDepartmentName());
        entity.setDepartmentCode(dto.getDepartmentCode());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive());
    }

    public void deleteDepartment(Long id) {
        log.info("Soft delete request received for Department ID: {}", id);
        try {
            DepartmentEntity existing = departmentRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Department not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("Department not found with id: " + id);
                    });
            existing.setDeleted(true);
            departmentRepository.save(existing);
            log.info("Department ID: {} marked as deleted successfully", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while soft deleting Department ID: {}", id, e);
            throw new CustomServiceException("Unexpected error occurred while deleting Department", e);
        }
    }

    public List<DepartmentResponseDTO> getAllActiveDepartments() {
        log.info("Fetching all active Departments from database");
        try {
            List<DepartmentEntity> departments = departmentRepository.findAllActiveDepartments();
            log.info("Successfully fetched {} active Departments", departments.size());
            return departments.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error while fetching active Departments", e);
            throw new CustomServiceException("Failed to fetch active Departments", e);
        }
    }


    public List<DepartmentResponseDTO> searchDepartments(String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Departments based on search from database with keyword: '{}'", searchKey);
            List<DepartmentEntity> results = departmentRepository.searchDepartments(searchKey);
            log.info("Successfully fetched {} Departments based on search", results.size());
            return results.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while searching Departments", e);
            throw new CustomServiceException("Unexpected error occurred while searching Departments", e);
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
        dto.setHeadEmployeeName(entity.getHeadEmployee() != null ? entity.getHeadEmployee().getFullName() : null);
        dto.setHeadEmployeeCode(entity.getHeadEmployee() != null ? entity.getHeadEmployee().getEmployeeCode() : null);

        return dto;
    }
}