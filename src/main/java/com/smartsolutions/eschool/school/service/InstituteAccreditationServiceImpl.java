package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteAccreditationErrors;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteAccreditationEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.mapper.InstituteAccreditationMapper;
import com.smartsolutions.eschool.school.repository.InstituteAccreditationRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteAccreditationServiceImpl implements InstituteAccreditationService {

    private final InstituteAccreditationRepository instituteAccreditationRepository;
    private final InstituteRepository instituteRepository;

    public InstituteAccreditationServiceImpl(InstituteAccreditationRepository instituteAccreditationRepository,
            InstituteRepository instituteRepository) {
        this.instituteAccreditationRepository = instituteAccreditationRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteAccreditationResponseDTO createAccreditation(InstituteAccreditationCreateRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteAccreditationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info(
                "[Service:InstituteAccreditationServiceImpl] createAccreditation() called - Creating accreditation for institute: {}",
                contextInstituteId);

        // Robustness: check inheritance/duplicate by license number
        if (instituteAccreditationRepository.existsByInstituteIdAndLicenseNumber(contextInstituteId,
                requestDTO.getLicenseNumber())) {
            log.warn(
                    "[Service:InstituteAccreditationServiceImpl] createAccreditation() failed - License number {} already exists for institute: {}",
                    requestDTO.getLicenseNumber(), contextInstituteId);
            throw new ApiException(InstituteAccreditationErrors.DUPLICATE_LICENSE, HttpStatus.CONFLICT);
        }

        InstituteEntity institute = instituteRepository.findById(contextInstituteId)
                .orElseThrow(
                        () -> new ApiException(InstituteAccreditationErrors.INSTITUTE_NOT_FOUND, HttpStatus.NOT_FOUND));

        InstituteAccreditationEntity entity = InstituteAccreditationMapper.toEntity(requestDTO);
        entity.setInstitute(institute);

        InstituteAccreditationEntity saved = instituteAccreditationRepository.save(entity);
        log.info(
                "[Service:InstituteAccreditationServiceImpl] createAccreditation() succeeded - Accreditation created with id: {}",
                saved.getId());
        return InstituteAccreditationMapper.toResponseDTO(saved);
    }

    @Override
    public List<InstituteAccreditationResponseDTO> getAll() {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteAccreditationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteAccreditationServiceImpl] getAll() called - Fetching all for institute: {}",
                contextInstituteId);
        List<InstituteAccreditationEntity> result = instituteAccreditationRepository
                .findByInstituteIdAndDeletedFalse(contextInstituteId);
        List<InstituteAccreditationResponseDTO> responseDTOs = InstituteAccreditationMapper.toResponseDTOList(result);
        log.info("[Service:InstituteAccreditationServiceImpl] getAll() succeeded - Found {} accreditations",
                responseDTOs.size());
        return responseDTOs;
    }

    @Override
    public List<InstituteAccreditationResponseDTO> getByInstituteId(Long instituteId) {
        log.info("[Service:InstituteAccreditationServiceImpl] getByInstituteId() called - Fetching for institute: {}",
                instituteId);
        List<InstituteAccreditationEntity> result = instituteAccreditationRepository
                .findByInstituteIdAndDeletedFalse(instituteId);
        return InstituteAccreditationMapper.toResponseDTOList(result);
    }

    @Override
    public List<InstituteAccreditationResponseDTO> getAllActive() {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        log.info(
                "[Service:InstituteAccreditationServiceImpl] getAllActive() called - Fetching active for institute: {}",
                contextInstituteId);
        List<InstituteAccreditationEntity> result = (contextInstituteId != null)
                ? instituteAccreditationRepository.findAllActiveByInstituteId(contextInstituteId)
                : instituteAccreditationRepository.findAllActiveAndNotDeleted();
        return InstituteAccreditationMapper.toResponseDTOList(result);
    }

    @Override
    public InstituteAccreditationResponseDTO getById(Long id) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:InstituteAccreditationServiceImpl] getById() called - id: {}, institute: {}", id,
                contextInstituteId);
        InstituteAccreditationEntity entity = (contextInstituteId != null)
                ? instituteAccreditationRepository.findByIdAndInstituteIdAndDeletedFalse(id, contextInstituteId)
                        .orElseThrow(() -> new ApiException(InstituteAccreditationErrors.ACCREDITATION_NOT_FOUND,
                                HttpStatus.NOT_FOUND))
                : instituteAccreditationRepository.findByIdAndDeletedFalse(id)
                        .orElseThrow(() -> new ApiException(InstituteAccreditationErrors.ACCREDITATION_NOT_FOUND,
                                HttpStatus.NOT_FOUND));

        return InstituteAccreditationMapper.toResponseDTO(entity);
    }

    @Override
    public InstituteAccreditationResponseDTO updateAccreditation(Long id,
            InstituteAccreditationUpdateRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteAccreditationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteAccreditationServiceImpl] updateAccreditation() called - id: {}, institute: {}", id,
                contextInstituteId);

        InstituteAccreditationEntity existing = instituteAccreditationRepository
                .findByIdAndInstituteIdAndDeletedFalse(id, contextInstituteId)
                .orElseThrow(() -> new ApiException(InstituteAccreditationErrors.ACCREDITATION_NOT_FOUND,
                        HttpStatus.NOT_FOUND));

        // Robustness: check duplicate license number on update
        if (requestDTO.getLicenseNumber() != null
                && !requestDTO.getLicenseNumber().equals(existing.getLicenseNumber())) {
            if (instituteAccreditationRepository.existsByInstituteIdAndLicenseNumberAndIdNot(contextInstituteId,
                    requestDTO.getLicenseNumber(), id)) {
                log.warn(
                        "[Service:InstituteAccreditationServiceImpl] updateAccreditation() failed - License number {} already exists for institute: {}",
                        requestDTO.getLicenseNumber(), contextInstituteId);
                throw new ApiException(InstituteAccreditationErrors.DUPLICATE_LICENSE, HttpStatus.CONFLICT);
            }
        }

        InstituteAccreditationMapper.updateEntityFromDTO(existing, requestDTO);
        InstituteAccreditationEntity updated = instituteAccreditationRepository.save(existing);
        log.info("[Service:InstituteAccreditationServiceImpl] updateAccreditation() succeeded - id: {}", id);
        return InstituteAccreditationMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteAccreditationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteAccreditationServiceImpl] deleteById() called - id: {}, institute: {}", id,
                contextInstituteId);

        if (!instituteAccreditationRepository.existsByIdAndInstituteIdAndDeletedFalse(id, contextInstituteId)) {
            throw new ApiException(InstituteAccreditationErrors.ACCREDITATION_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        instituteAccreditationRepository.softDeleteById(id);
        log.info("[Service:InstituteAccreditationServiceImpl] deleteById() succeeded - id: {}", id);
    }

    @Override
    public List<InstituteAccreditationResponseDTO> searchByKeyword(String keyword) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:InstituteAccreditationServiceImpl] searchByKeyword() called - keyword: {}, institute: {}",
                keyword, contextInstituteId);
        List<InstituteAccreditationEntity> result = (contextInstituteId != null)
                ? instituteAccreditationRepository.searchByKeywordAndInstituteId(keyword == null ? "" : keyword.trim(),
                        contextInstituteId)
                : instituteAccreditationRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return InstituteAccreditationMapper.toResponseDTOList(result);
    }

    @Override
    public InstituteAccreditationResponseDTO activate(Long id) {
        return setActivationStatus(id, true);
    }

    @Override
    public InstituteAccreditationResponseDTO deactivate(Long id) {
        return setActivationStatus(id, false);
    }

    private InstituteAccreditationResponseDTO setActivationStatus(Long id, boolean status) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteAccreditationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteAccreditationServiceImpl] setActivationStatus() called - id: {}, status: {}", id,
                status);

        InstituteAccreditationEntity entity = instituteAccreditationRepository
                .findByIdAndInstituteIdAndDeletedFalse(id, contextInstituteId)
                .orElseThrow(() -> new ApiException(InstituteAccreditationErrors.ACCREDITATION_NOT_FOUND,
                        HttpStatus.NOT_FOUND));

        entity.setIsActive(status);
        InstituteAccreditationEntity saved = instituteAccreditationRepository.save(entity);
        return InstituteAccreditationMapper.toResponseDTO(saved);
    }
}
