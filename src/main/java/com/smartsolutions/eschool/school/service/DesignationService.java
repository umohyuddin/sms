package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.employee.repository.EmployeeDesignationHistoryRepository;
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
    private final EmployeeDesignationHistoryRepository employeeDesignationHistoryRepository;

    public DesignationService(DesignationRepository designationRepository,
                              EmployeeDesignationHistoryRepository employeeDesignationHistoryRepository) {
        this.designationRepository = designationRepository;
        this.employeeDesignationHistoryRepository = employeeDesignationHistoryRepository;
    }

    @Transactional
    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] createDesignation() called - name: {}", requestDTO.getDesignationName());

        if (requestDTO.getDesignationCode() != null && !requestDTO.getDesignationCode().trim().isEmpty()) {
            if (designationRepository.existsByCodeAndOrganizationId(requestDTO.getDesignationCode().trim(), organizationId)) {
                throw new ApiException(DesignationErrors.DUPLICATE_DESIGNATION_CODE, HttpStatus.CONFLICT);
            }
        }

        DesignationEntity entity = DesignationMapper.toEntity(requestDTO);
        DesignationEntity saved = designationRepository.save(entity);
        log.info("[Service:DesignationService] createDesignation() succeeded - created ID: {}", saved.getId());
        return DesignationMapper.toResponseDTO(saved);
    }

    public DesignationResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getById() called - id: {}", id);
        DesignationEntity entity = designationRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DesignationErrors.DESIGNATION_NOT_FOUND, HttpStatus.NOT_FOUND));

        return DesignationMapper.toResponseDTO(entity);
    }

    public List<DesignationResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getAll() called");
        List<DesignationEntity> entities = designationRepository.findByOrganizationId(organizationId);
        return DesignationMapper.toResponseDTOList(entities);
    }

    public List<DesignationResponseDTO> getAllActive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] getAllActive() called");
        List<DesignationEntity> entities = designationRepository.findAllEnabled(organizationId);
        return DesignationMapper.toResponseDTOList(entities);
    }

    @Transactional
    public DesignationResponseDTO updateDesignation(Long id, @Valid DesignationRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] updateDesignation() called - id: {}", id);

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
        log.info("[Service:DesignationService] searchByKeyword() called - keyword: {}", searchKey);
        List<DesignationEntity> entities = designationRepository.searchByKeywordAndOrganizationId(searchKey, organizationId);
        return DesignationMapper.toResponseDTOList(entities);
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DesignationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DesignationService] softDeleteById() called - id: {}", id);

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
        return employeeDesignationHistoryRepository.getStaffCountByDesignation(organizationId);
    }
}
