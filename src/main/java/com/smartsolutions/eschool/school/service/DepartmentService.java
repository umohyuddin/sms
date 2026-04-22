package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeDepartmentHistoryRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentCountDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.error.DepartmentErrors;
import com.smartsolutions.eschool.school.mapper.DepartmentMapper;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
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
    private final CampusRepository campusRepository;
    private final EmployeeMasterRepository employeeMasterRepository;
    private final EmployeeDepartmentHistoryRepository employeeDepartmentHistoryRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             CampusRepository campusRepository,
                             EmployeeMasterRepository employeeMasterRepository,
                             EmployeeDepartmentHistoryRepository employeeDepartmentHistoryRepository) {
        this.departmentRepository = departmentRepository;
        this.campusRepository = campusRepository;
        this.employeeMasterRepository = employeeMasterRepository;
        this.employeeDepartmentHistoryRepository = employeeDepartmentHistoryRepository;
    }

    @Transactional
    public DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        log.info("[Service:DepartmentService] createDepartment() called - name: {}, campus: {}", requestDTO.getDepartmentName(), campusId);

        if (departmentRepository.existsByCodeAndOrganizationAndCampus(requestDTO.getDepartmentCode().trim(), organizationId, campusId)) {
            throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_CODE, HttpStatus.CONFLICT);
        }

        CampusEntity campus = campusRepository.findByIdAndInstituteId(campusId, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Campus not found", HttpStatus.NOT_FOUND));

        DepartmentEntity entity = DepartmentMapper.toEntity(requestDTO);
        entity.setCampus(campus);

        if (requestDTO.getParentDepartmentId() != null) {
            DepartmentEntity parent = departmentRepository.findByIdAndOrganizationAndCampus(requestDTO.getParentDepartmentId(), organizationId, campusId)
                    .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Parent department not found", HttpStatus.NOT_FOUND));
            entity.setParentDepartment(parent);
        }

        if (requestDTO.getHeadEmployeeId() != null) {
            EmployeeMasterEntity head = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                    .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Head employee not found", HttpStatus.NOT_FOUND));
            entity.setHeadEmployee(head);
        }

        DepartmentEntity saved = departmentRepository.save(entity);
        log.info("[Service:DepartmentService] createDepartment() succeeded - ID: {}", saved.getId());
        return DepartmentMapper.toResponseDTO(saved);
    }

    public DepartmentResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        log.info("[Service:DepartmentService] getById() called - id: {}, campus: {}", id, campusId);
        DepartmentEntity entity = departmentRepository.findByIdAndOrganizationAndCampus(id, organizationId, campusId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        return DepartmentMapper.toResponseDTO(entity);
    }

    public List<DepartmentResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        log.info("[Service:DepartmentService] getAll() called - campus: {}", campusId);
        List<DepartmentEntity> entities = departmentRepository.findByOrganizationAndCampus(organizationId, campusId);
        return DepartmentMapper.toResponseDTOList(entities);
    }

    public List<DepartmentResponseDTO> getAllActive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        log.info("[Service:DepartmentService] getAllActive() called - campus: {}", campusId);
        List<DepartmentEntity> entities = departmentRepository.findAllActive(organizationId, campusId);
        return DepartmentMapper.toResponseDTOList(entities);
    }

    @Transactional
    public DepartmentResponseDTO updateDepartment(Long id, @Valid DepartmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        log.info("[Service:DepartmentService] updateDepartment() called - id: {}, campus: {}", id, campusId);

        DepartmentEntity existing = departmentRepository.findByIdAndOrganizationAndCampus(id, organizationId, campusId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getDepartmentCode() != null && !requestDTO.getDepartmentCode().trim().equals(existing.getDepartmentCode())) {
            if (departmentRepository.existsByCodeAndOrganizationAndCampusAndIdNot(requestDTO.getDepartmentCode().trim(), organizationId, campusId, id)) {
                throw new ApiException(DepartmentErrors.DUPLICATE_DEPARTMENT_CODE, HttpStatus.CONFLICT);
            }
        }

        if (requestDTO.getParentDepartmentId() != null) {
            DepartmentEntity parent = departmentRepository.findByIdAndOrganizationAndCampus(requestDTO.getParentDepartmentId(), organizationId, campusId)
                    .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Parent department not found", HttpStatus.NOT_FOUND));
            existing.setParentDepartment(parent);
        } else if (requestDTO.getParentDepartmentId() == null) {
             existing.setParentDepartment(null);
        }

        if (requestDTO.getHeadEmployeeId() != null) {
            EmployeeMasterEntity head = employeeMasterRepository.findById(requestDTO.getHeadEmployeeId())
                    .orElseThrow(() -> new ApiException(DepartmentErrors.INVALID_DEPARTMENT_DATA, "Head employee not found", HttpStatus.NOT_FOUND));
            existing.setHeadEmployee(head);
        } else if (requestDTO.getHeadEmployeeId() == null) {
            existing.setHeadEmployee(null);
        }

        DepartmentMapper.updateEntityFromDTO(existing, requestDTO);
        DepartmentEntity updated = departmentRepository.save(existing);
        log.info("[Service:DepartmentService] updateDepartment() succeeded - id: {}", id);

        return DepartmentMapper.toResponseDTO(updated);
    }

    public List<DepartmentResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[Service:DepartmentService] searchByKeyword() called - keyword: {}, campus: {}", searchKey, campusId);
        List<DepartmentEntity> entities = departmentRepository.searchByKeyword(searchKey, organizationId, campusId);
        return DepartmentMapper.toResponseDTOList(entities);
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        Long campusId = SecurityUtils.getCurrentCampusId();
        
        if (organizationId == null || campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        
        log.info("[Service:DepartmentService] softDeleteById() called - id: {}, campus: {}", id, campusId);
        
        DepartmentEntity entity = departmentRepository.findByIdAndOrganizationAndCampus(id, organizationId, campusId)
                .orElseThrow(() -> new ApiException(DepartmentErrors.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND));
        
        departmentRepository.delete(entity);
        log.info("[Service:DepartmentService] softDeleteById() succeeded - id: {}", id);
    }

    public List<DepartmentCountDTO> getStaffCountReport() {
        Long campusId = SecurityUtils.getCurrentCampusId();
        if (campusId == null) {
            throw new ApiException(DepartmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentService] getStaffCountReport() called - campus: {}", campusId);
        return employeeDepartmentHistoryRepository.getStaffCountByDepartment(campusId);
    }
}
