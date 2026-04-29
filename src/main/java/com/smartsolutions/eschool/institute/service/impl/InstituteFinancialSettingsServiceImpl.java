package com.smartsolutions.eschool.institute.service.impl;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.entity.InstituteFinancialSettings;
import com.smartsolutions.eschool.institute.error.InstituteFinancialSettingsErrors;
import com.smartsolutions.eschool.institute.mapper.FinancialSettingsMapper;
import com.smartsolutions.eschool.institute.repository.InstituteFinancialSettingsRepository;
import com.smartsolutions.eschool.institute.service.InstituteFinancialSettingsService;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstituteFinancialSettingsServiceImpl implements InstituteFinancialSettingsService {

    private final InstituteFinancialSettingsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public FinancialSettingsResponseDTO getByInstituteAndAcademicYear(Long instituteId, Long academicYearId) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        log.info(
                "[Service:InstituteFinancialSettingsServiceImpl] getByInstituteAndAcademicYear() called - institute: {}, year: {}, context: {}",
                instituteId, academicYearId, contextInstituteId);

        // If context available, enforce it or just use it as filter
        Long targetInstituteId = (contextInstituteId != null) ? contextInstituteId : instituteId;

        InstituteFinancialSettings settings = repository
                .findByInstituteIdAndAcademicYearIdJpql(targetInstituteId, academicYearId)
                .orElseThrow(() -> new ApiException(
                        InstituteFinancialSettingsErrors.INSTITUTE_FINANCIAL_SETTINGS_NOT_FOUND, HttpStatus.NOT_FOUND));

        return FinancialSettingsMapper.toDTO(settings);
    }

    @Override
    @Transactional
    public FinancialSettingsResponseDTO create(FinancialSettingsRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info(
                "[Service:InstituteFinancialSettingsServiceImpl] create() called - institute: {}, year: {}, context: {}",
                requestDTO.getInstituteId(), requestDTO.getAcademicYearId(), contextInstituteId);

        // Security Check: If request tries to create for different institute
        if (!contextInstituteId.equals(requestDTO.getInstituteId())) {
            throw new ApiException(InstituteFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }

        // Check if settings already exist for this institute and academic year
        repository.findByInstituteIdAndAcademicYearIdJpql(contextInstituteId, requestDTO.getAcademicYearId())
                .ifPresent(existing -> {
                    throw new ApiException(InstituteFinancialSettingsErrors.INSTITUTE_FINANCIAL_SETTINGS_ALREADY_EXISTS,
                            HttpStatus.CONFLICT);
                });

        InstituteFinancialSettings entity = FinancialSettingsMapper.toEntity(requestDTO);
        InstituteFinancialSettings saved = repository.save(entity);

        log.info("[Service:InstituteFinancialSettingsServiceImpl] create() succeeded - ID: {}", saved.getId());
        return FinancialSettingsMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public FinancialSettingsResponseDTO update(Long id, FinancialSettingsRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteFinancialSettingsServiceImpl] update() called - ID: {}, context: {}", id,
                contextInstituteId);

        InstituteFinancialSettings existing = repository.findByIdAndInstituteIdJpql(id, contextInstituteId)
                .orElseThrow(() -> new ApiException(
                        InstituteFinancialSettingsErrors.INSTITUTE_FINANCIAL_SETTINGS_NOT_FOUND, HttpStatus.NOT_FOUND));

        FinancialSettingsMapper.updateEntityFromDTO(requestDTO, existing);
        InstituteFinancialSettings updated = repository.save(existing);

        log.info("[Service:InstituteFinancialSettingsServiceImpl] update() succeeded - ID: {}", id);
        return FinancialSettingsMapper.toDTO(updated);
    }

    @Override
    @Transactional
    public void softDeleteById(Long id) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteFinancialSettingsServiceImpl] softDeleteById() called - ID: {}, context: {}", id,
                contextInstituteId);

        InstituteFinancialSettings settings = repository.findByIdAndInstituteIdJpql(id, contextInstituteId)
                .orElseThrow(() -> new ApiException(
                        InstituteFinancialSettingsErrors.INSTITUTE_FINANCIAL_SETTINGS_NOT_FOUND, HttpStatus.NOT_FOUND));

        settings.setIsDeleted(true);
        repository.save(settings);

        log.info("[Service:InstituteFinancialSettingsServiceImpl] softDeleteById() succeeded - ID: {}", id);
    }
}
