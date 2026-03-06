package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.error.DepartmentErrors;
import com.smartsolutions.eschool.school.mapper.DepartmentMapper;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeMasterRepository employeeMasterRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
            EmployeeMasterRepository employeeMasterRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeMasterRepository = employeeMasterRepository;
    }

    @Transactional
    public DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] createDepartment() called - Creating for institute: {}", organizationId);

        // Validation: Unique Code
        if (requestDTO.getDepartmentCode() != null && !requestDTO.getDepartmentCode().trim().isEmpty()) {
            if (departmentRepository.existsByOrganizationIdAndDepartmentCode(organizationId,
                    requestDTO.getDepartmentCode().trim())) {
                throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_CODE, HttpStatus.CONFLICT);
            }
        }

        // Validation: Unique Name
        if (requestDTO.getDepartmentName() != null && !requestDTO.getDepartmentName().trim().isEmpty()) {
            if (departmentRepository.existsByOrganizationIdAndDepartmentName(organizationId,
                    requestDTO.getDepartmentName().trim())) {
                throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_NAME, HttpStatus.CONFLICT);
            }
        }

        DepartmentEntity entity = DepartmentMapper.toEntity(requestDTO);

        // Fetch and set parent department if provided
        if (requestDTO.getParentDepartmentId() != null) {
            DepartmentEntity parent = departmentRepository
                    .findByIdAndOrganizationId(requestDTO.getParentDepartmentId(), organizationId)
                    .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND,
                            "Parent Department not found", HttpStatus.NOT_FOUND));
            entity.setParentDepartment(parent);
        }

        // Fetch and set head employee if provided
        if (requestDTO.getHeadEmployeeId() != null) {
            EmployeeMasterEntity headEmployee = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                    .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA,
                            "Head employee not found", HttpStatus.NOT_FOUND));
            entity.setHeadEmployee(headEmployee);
        }

        DepartmentEntity saved = departmentRepository.save(entity);
        log.info("[Service:DepartmentService] createDepartment() succeeded - Created with ID: {}", saved.getId());
        return DepartmentMapper.toResponseDTO(saved);
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getAllDepartments() called - Fetching for institute: {}", organizationId);
        List<DepartmentEntity> departments = departmentRepository.findByOrganizationId(organizationId);
        List<DepartmentResponseDTO> response = DepartmentMapper.toResponseDTOList(departments);
        log.info("[Service:DepartmentService] getAllDepartments() succeeded - Found {} departments", response.size());
        return response;
    }

    public DepartmentResponseDTO getDepartmentById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getDepartmentById() called - id: {}, institute: {}", id, organizationId);
        DepartmentEntity entity = departmentRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));
        log.info("[Service:DepartmentService] getDepartmentById() succeeded - Found department: {}", id);
        return DepartmentMapper.toResponseDTO(entity);
    }

    @Transactional
    public DepartmentResponseDTO updateDepartment(Long id, @Valid DepartmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] updateDepartment() called - id: {}, institute: {}", id, organizationId);

        DepartmentEntity existing = departmentRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Validation: Unique Code
        if (requestDTO.getDepartmentCode() != null
                && !requestDTO.getDepartmentCode().trim().equals(existing.getDepartmentCode())) {
            if (departmentRepository.existsByOrganizationIdAndDepartmentCodeAndIdNot(organizationId,
                    requestDTO.getDepartmentCode().trim(), id)) {
                throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_CODE, HttpStatus.CONFLICT);
            }
        }

        // Validation: Unique Name
        if (requestDTO.getDepartmentName() != null
                && !requestDTO.getDepartmentName().trim().equals(existing.getDepartmentName())) {
            if (departmentRepository.existsByOrganizationIdAndDepartmentNameAndIdNot(organizationId,
                    requestDTO.getDepartmentName().trim(), id)) {
                throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_NAME, HttpStatus.CONFLICT);
            }
        }

        DepartmentMapper.updateEntityFromDTO(existing, requestDTO);

        // Handle head employee
        if (requestDTO.getHeadEmployeeId() != null) {
            EmployeeMasterEntity headEmployee = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                    .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA,
                            "Head employee not found", HttpStatus.NOT_FOUND));
            existing.setHeadEmployee(headEmployee);
        } else {
            existing.setHeadEmployee(null);
        }

        // Handle parent department
        if (requestDTO.getParentDepartmentId() != null) {
            DepartmentEntity parent = departmentRepository
                    .findByIdAndOrganizationId(requestDTO.getParentDepartmentId(), organizationId)
                    .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND,
                            "Parent Department not found", HttpStatus.NOT_FOUND));
            existing.setParentDepartment(parent);
        } else {
            existing.setParentDepartment(null);
        }

        DepartmentEntity updated = departmentRepository.save(existing);
        log.info("[Service:DepartmentService] updateDepartment() succeeded - Updated ID: {}", updated.getId());

        return DepartmentMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteDepartment(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] deleteDepartment() called - id: {}, institute: {}", id, organizationId);

        DepartmentEntity existing = departmentRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        existing.setDeleted(true);
        departmentRepository.save(existing);
        log.info("[Service:DepartmentService] deleteDepartment() succeeded - Marked ID: {} as deleted", id);
    }

    public List<DepartmentResponseDTO> getAllActiveDepartments() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getAllActiveDepartments() called - Fetching for institute: {}",
                organizationId);
        List<DepartmentEntity> departments = departmentRepository.findAllActive(organizationId);
        log.info("[Service:DepartmentService] getAllActiveDepartments() succeeded - Found {} active departments",
                departments.size());
        return DepartmentMapper.toResponseDTOList(departments);
    }

    public List<DepartmentResponseDTO> searchDepartments(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[Service:DepartmentService] searchDepartments() called - keyword: '{}', institute: {}", searchKey,
                organizationId);
        List<DepartmentEntity> results = departmentRepository.searchDepartments(organizationId,
                searchKey.isEmpty() ? null : searchKey);
        log.info("[Service:DepartmentService] searchDepartments() succeeded - Found {} departments", results.size());
        return DepartmentMapper.toResponseDTOList(results);
    }
}
