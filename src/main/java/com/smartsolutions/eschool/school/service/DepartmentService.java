package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.DepartmentErrors;
import com.smartsolutions.eschool.school.dtos.departments.requestDto.DepartmentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.mapper.DepartmentMapper;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.model.DepartmentTypeEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.school.repository.DepartmentTypeRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CampusRepository campusRepository;
    private final DepartmentTypeRepository departmentTypeRepository;
    private final EmployeeMasterRepository employeeMasterRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             CampusRepository campusRepository,
                             DepartmentTypeRepository departmentTypeRepository,
                             EmployeeMasterRepository employeeMasterRepository) {
        this.departmentRepository = departmentRepository;
        this.campusRepository = campusRepository;
        this.departmentTypeRepository = departmentTypeRepository;
        this.employeeMasterRepository = employeeMasterRepository;
    }

    public List<DepartmentResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getAll() called - Organization: {}", organizationId);
        List<DepartmentEntity> result = departmentRepository.findByOrganizationId(organizationId);
        return DepartmentMapper.toResponseDTOList(result);
    }

    public List<DepartmentResponseDTO> getByCampusId(Long campusId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getByCampusId() called - Campus: {}, Organization: {}", campusId, organizationId);
        List<DepartmentEntity> result = departmentRepository.findByCampusIdAndOrganizationId(campusId, organizationId);
        return DepartmentMapper.toResponseDTOList(result);
    }

    public DepartmentResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getById() called - id: {}, organization: {}", id, organizationId);
        DepartmentEntity entity = departmentRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));
        return DepartmentMapper.toResponseDTO(entity);
    }

    @Transactional
    public DepartmentResponseDTO createDepartment(DepartmentCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] createDepartment() called - Organization: {}", organizationId);

        // Validation for uniqueness
        if (requestDTO.getDepartmentCode() != null && departmentRepository.existsByOrganizationIdAndCampusIdAndDepartmentCode(organizationId, requestDTO.getCampusId(), requestDTO.getDepartmentCode().trim())) {
            throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_CODE, HttpStatus.CONFLICT);
        }
        if (departmentRepository.existsByOrganizationIdAndCampusIdAndDepartmentName(organizationId, requestDTO.getCampusId(), requestDTO.getDepartmentName().trim())) {
            throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_NAME, HttpStatus.CONFLICT);
        }

        DepartmentEntity entity = DepartmentMapper.toEntity(requestDTO);
        resolveAssociations(entity, requestDTO, organizationId);

        DepartmentEntity saved = departmentRepository.save(entity);
        log.info("[Service:DepartmentService] createDepartment() succeeded - id: {}", saved.getId());
        return DepartmentMapper.toResponseDTO(saved);
    }

    @Transactional
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] updateDepartment() called - id: {}, organization: {}", id, organizationId);

        DepartmentEntity existing = departmentRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Validation for uniqueness if name/code changed
        if (requestDTO.getDepartmentCode() != null && !requestDTO.getDepartmentCode().trim().equalsIgnoreCase(existing.getDepartmentCode())) {
             if (departmentRepository.existsByOrganizationIdAndCampusIdAndDepartmentCode(organizationId, requestDTO.getCampusId(), requestDTO.getDepartmentCode().trim())) {
                 throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_CODE, HttpStatus.CONFLICT);
             }
        }
        if (!requestDTO.getDepartmentName().trim().equalsIgnoreCase(existing.getDepartmentName())) {
             if (departmentRepository.existsByOrganizationIdAndCampusIdAndDepartmentName(organizationId, requestDTO.getCampusId(), requestDTO.getDepartmentName().trim())) {
                 throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_NAME, HttpStatus.CONFLICT);
             }
        }

        DepartmentMapper.updateEntityFromDTO(existing, requestDTO);
        resolveAssociations(existing, requestDTO, organizationId);

        DepartmentEntity updated = departmentRepository.save(existing);
        log.info("[Service:DepartmentService] updateDepartment() succeeded - id: {}", id);
        return DepartmentMapper.toResponseDTO(updated);
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] softDeleteById() called - id: {}, organization: {}", id, organizationId);
        int result = departmentRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public List<DepartmentResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] searchByKeyword() called - keyword: {}", keyword);
        List<DepartmentEntity> result = departmentRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        return DepartmentMapper.toResponseDTOList(result);
    }

    private void resolveAssociations(DepartmentEntity entity, DepartmentCreateRequestDTO dto, Long organizationId) {
        CampusEntity campus = campusRepository.findByIdAndInstituteId(dto.getCampusId(), organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));
        entity.setCampus(campus);

        DepartmentTypeEntity type = departmentTypeRepository.findByIdAndOrganizationId(dto.getDepartmentTypeId(), organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        entity.setDepartmentType(type);

        if (dto.getParentId() != null) {
            DepartmentEntity parent = departmentRepository.findByIdAndOrganizationId(dto.getParentId(), organizationId)
                    .orElseThrow(() -> new ApiException(DepartmentErrors.PARENT_DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setParent(parent);
        } else {
            entity.setParent(null);
        }

        if (dto.getHeadEmployeeId() != null) {
            EmployeeMasterEntity head = employeeMasterRepository.findById(dto.getHeadEmployeeId())
                    .orElseThrow(() -> new ApiException(DepartmentErrors.HEAD_EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setHeadEmployee(head);
        } else {
            entity.setHeadEmployee(null);
        }
    }

    public java.util.Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        java.util.Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("total", departmentRepository.countByOrganizationId(organizationId));
        stats.put("active", departmentRepository.countByOrganizationIdAndActiveTrue(organizationId));
        return stats;
    }
}
