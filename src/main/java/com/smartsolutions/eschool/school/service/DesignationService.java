package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.employee.repository.EmployeeAssignmentRepository;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationCountDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.error.DesignationErrors;
import com.smartsolutions.eschool.school.mapper.DesignationMapper;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import com.smartsolutions.eschool.school.repository.DesignationRepository;
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
public class DesignationService {

    private final DesignationRepository designationRepository;
    private final EmployeeAssignmentRepository employeeAssignmentRepository;

    public DesignationService(DesignationRepository designationRepository,
                              EmployeeAssignmentRepository employeeAssignmentRepository) {
        this.designationRepository = designationRepository;
        this.employeeAssignmentRepository = employeeAssignmentRepository;
    }

    @Transactional
    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] createDesignation() called - Creating for organization: {}", organizationId);

        if (requestDTO.getDesignationCode() != null && !requestDTO.getDesignationCode().trim().isEmpty()) {
            if (designationRepository.existsByCodeAndOrganizationId(requestDTO.getDesignationCode().trim(), organizationId)) {
                throw new ApiException(DesignationErrors.DUPLICATE_DESIGNATION_CODE, HttpStatus.CONFLICT);
            }
        }

        DesignationEntity entity = DesignationMapper.toEntity(requestDTO);
        DesignationEntity saved = designationRepository.save(entity);
        log.info("[Service:DesignationService] createDesignation() succeeded - Designation created with id: {}", saved.getId());
        return DesignationMapper.toResponseDTO(saved);
    }

    public DesignationResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getById() called - id: {}, organization: {}", id, organizationId);
        DesignationEntity entity = designationRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DesignationErrors.DESIGNATION_NOT_FOUND, HttpStatus.NOT_FOUND));

        DesignationResponseDTO responseDTO = DesignationMapper.toResponseDTO(entity);
        log.info("[Service:DesignationService] getById() succeeded - Found designation: {}", id);
        return responseDTO;
    }

    public List<DesignationResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getAll() called - Fetching all for organization: {}", organizationId);
        List<DesignationEntity> entities = designationRepository.findByOrganizationId(organizationId);
        List<DesignationResponseDTO> responseDTOs = DesignationMapper.toResponseDTOList(entities);
        log.info("[Service:DesignationService] getAll() succeeded - Found {} designations", responseDTOs.size());
        return responseDTOs;
    }

    public List<DesignationResponseDTO> getAllActive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getAllActive() called - Fetching all active for organization: {}", organizationId);
        List<DesignationEntity> entities = designationRepository.findAllEnabled(organizationId);
        List<DesignationResponseDTO> responseDTOs = DesignationMapper.toResponseDTOList(entities);
        log.info("[Service:DesignationService] getAllActive() succeeded - Found {} active designations", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public DesignationResponseDTO updateDesignation(Long id, @Valid DesignationRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] updateDesignation() called - id: {}, organization: {}", id, organizationId);

        DesignationEntity existing = designationRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DesignationErrors.DESIGNATION_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getDesignationCode() != null && !requestDTO.getDesignationCode().trim().equals(existing.getDesignationCode())) {
            if (designationRepository.existsByCodeAndOrganizationIdAndIdNot(requestDTO.getDesignationCode().trim(), organizationId, id)) {
                throw new ApiException(DesignationErrors.DUPLICATE_DESIGNATION_CODE, HttpStatus.CONFLICT);
            }
        }

        DesignationMapper.updateEntityFromDTO(existing, requestDTO);
        DesignationEntity updated = designationRepository.save(existing);
        log.info("[Service:DesignationService] updateDesignation() succeeded - id: {}", id);

        return DesignationMapper.toResponseDTO(updated);
    }

    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[Service:DesignationService] searchByKeyword() called - keyword: {}, organization: {}", searchKey, organizationId);
        List<DesignationEntity> entities = designationRepository.searchByKeywordAndOrganizationId(searchKey, organizationId);
        List<DesignationResponseDTO> responseDTOs = DesignationMapper.toResponseDTOList(entities);
        log.info("[Service:DesignationService] searchByKeyword() succeeded - Found {} designations", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = designationRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(DesignationErrors.DESIGNATION_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:DesignationService] softDeleteById() succeeded - id: {}", id);
    }

    public List<DesignationCountDTO> getStaffCountReport() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getStaffCountReport() called - organization: {}", organizationId);
        List<DesignationCountDTO> resources = employeeAssignmentRepository.getStaffCountByDesignation(organizationId);
        log.info("[Service:DesignationService] getStaffCountReport() succeeded - Found {} entries", resources.size());
        return resources;
    }
}
