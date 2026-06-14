package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import com.smartsolutions.eschool.school.repository.ChargeTypeRepository;
import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.error.FeeRateErrors;
import com.smartsolutions.eschool.student.mapper.FeeRateMapper;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.model.FeeSlabGroupEntity;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.student.repository.FeeRateRepository;
import com.smartsolutions.eschool.student.repository.FeeSlabGroupRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;

@Service
@Slf4j
public class FeeRateService {

    private final FeeRateRepository feeRateRepository;
    private final CampusRepository campusRepository;
    private final StandardRepository standardRepository;
    private final AcademicYearRepository academicYearRepository;
    private final FeeComponentRepository feeComponentRepository;
    private final ChargeTypeRepository chargeTypeRepository;
    private final FeeSlabGroupRepository feeSlabGroupRepository;
    private com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public FeeRateService(FeeRateRepository feeRateRepository, CampusRepository campusRepository,
            StandardRepository standardRepository, AcademicYearRepository academicYearRepository,
            FeeComponentRepository feeComponentRepository, ChargeTypeRepository chargeTypeRepository,
            FeeSlabGroupRepository feeSlabGroupRepository,
                             com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator) {
        this.entityReferenceValidator = entityReferenceValidator;

        this.feeRateRepository = feeRateRepository;
        this.campusRepository = campusRepository;
        this.standardRepository = standardRepository;
        this.academicYearRepository = academicYearRepository;
        this.feeComponentRepository = feeComponentRepository;
        this.chargeTypeRepository = chargeTypeRepository;
        this.feeSlabGroupRepository = feeSlabGroupRepository;
    }

    public List<FeeRatesResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] getAll() called - Fetching for organization: {}", organizationId);
        List<FeeRateEntity> result = feeRateRepository.findByOrganizationIdAndDeletedFalse(organizationId);
        List<FeeRatesResponseDTO> responseDTOs = FeeRateMapper.toResponseDTOList(result);
        log.info("[Service:FeeRateService] getAll() succeeded - Found {} fee rates", responseDTOs.size());
        return responseDTOs;
    }

    public FeeRatesResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] getById() called - id: {}, organization: {}", id, organizationId);
        FeeRateEntity entity = feeRateRepository.findByIdAndOrganizationIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> new ApiException(FeeRateErrors.FEE_RATE_NOT_FOUND, HttpStatus.NOT_FOUND));

        FeeRatesResponseDTO responseDTO = FeeRateMapper.toResponseDTO(entity);
        log.info("[Service:FeeRateService] getById() succeeded - Found fee rate: {}", id);
        return responseDTO;
    }

    public List<FeeRatesResponseDTO> getByFeeComponentId(Long componentId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] getByFeeComponentId() called - component: {}, organization: {}", componentId, organizationId);
        List<FeeRateEntity> result = feeRateRepository.findByFeeComponentId(componentId);
        // Filtering by organization as findByFeeComponentId is not yet organization-aware
        List<FeeRateEntity> filtered = result.stream()
                .filter(fr -> organizationId.equals(fr.getOrganizationId()))
                .toList();
        return FeeRateMapper.toResponseDTOList(filtered);
    }

    public List<FeeRatesResponseDTO> findActiveFeeRates(Long campusId, Long standardId, Long academicYearId) {
        log.info("[Service:FeeRateService] findActiveFeeRates() called - campus: {}, standard: {}, year: {}", campusId, standardId, academicYearId);
        List<FeeRateEntity> result = feeRateRepository.findActiveFeeRates(campusId, standardId, academicYearId);
        return FeeRateMapper.toResponseDTOList(result);
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
        entityReferenceValidator.ensureNotReferenced(FeeRateEntity.class, id);
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = feeRateRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(FeeRateErrors.FEE_RATE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:FeeRateService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public FeeRatesResponseDTO createFeeRate(FeeRateCreateRequestDTO dto) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] createFeeRate() called - Creating for organization: {}", organizationId);

        // Fetch related entities
        CampusEntity campus = campusRepository.findById(dto.getCampusId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));

        StandardEntity standard = standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND));

        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));

        FeeComponentEntity feeComponent = null;
        if (dto.getFeeComponentId() != null) {
            feeComponent = feeComponentRepository.findById(dto.getFeeComponentId())
                    .orElseThrow(() -> new ApiException(FeeRateErrors.FEE_COMPONENT_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        ChargeTypeEntity chargeType = chargeTypeRepository.findById(dto.getChargeTypeId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        FeeSlabGroupEntity slabGroup = null;
        if (dto.getSlabGroupId() != null) {
            slabGroup = feeSlabGroupRepository.findById(dto.getSlabGroupId())
                    .orElseThrow(() -> new ApiException(FeeRateErrors.SLAB_GROUP_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        FeeComponentEntity percComponent = null;
        if (dto.getPercentageOfComponentId() != null) {
            percComponent = feeComponentRepository.findById(dto.getPercentageOfComponentId())
                    .orElseThrow(() -> new ApiException(FeeRateErrors.FEE_COMPONENT_NOT_FOUND, "Percentage base component not found", HttpStatus.NOT_FOUND));
        }

        // Validate dates
        validateDates(dto.getEffectiveFrom(), dto.getEffectiveTo());
        checkOverlaps(campus.getId(), standard.getId(), academicYear, feeComponent, dto.getEffectiveFrom(), dto.getEffectiveTo(), null);

        // Create entity
        FeeRateEntity entity = FeeRateMapper.toEntity(dto);
        entity.setCampus(campus);
        entity.setStandard(standard);
        entity.setAcademicYear(academicYear);
        entity.setFeeComponent(feeComponent);
        entity.setChargeType(chargeType);
        entity.setSlabGroup(slabGroup);
        entity.setPercentageOfComponent(percComponent);

        FeeRateEntity saved = feeRateRepository.save(entity);
        log.info("[Service:FeeRateService] createFeeRate() succeeded - id: {}", saved.getId());
        return FeeRateMapper.toResponseDTO(saved);
    }

    @Transactional
    public FeeRatesResponseDTO updateFeeRate(Long id, FeeRateCreateRequestDTO dto) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] updateFeeRate() called - id: {}, organization: {}", id, organizationId);

        FeeRateEntity existing = feeRateRepository.findByIdAndOrganizationIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> new ApiException(FeeRateErrors.FEE_RATE_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Fetch related entities if changed (or just refresh them)
        CampusEntity campus = campusRepository.findById(dto.getCampusId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));
        StandardEntity standard = standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND));
        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
        
        FeeComponentEntity feeComponent = null;
        if (dto.getFeeComponentId() != null) {
            feeComponent = feeComponentRepository.findById(dto.getFeeComponentId())
                    .orElseThrow(() -> new ApiException(FeeRateErrors.FEE_COMPONENT_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        ChargeTypeEntity chargeType = chargeTypeRepository.findById(dto.getChargeTypeId())
                .orElseThrow(() -> new ApiException(FeeRateErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        FeeSlabGroupEntity slabGroup = null;
        if (dto.getSlabGroupId() != null) {
            slabGroup = feeSlabGroupRepository.findById(dto.getSlabGroupId())
                    .orElseThrow(() -> new ApiException(FeeRateErrors.SLAB_GROUP_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        FeeComponentEntity percComponent = null;
        if (dto.getPercentageOfComponentId() != null) {
            percComponent = feeComponentRepository.findById(dto.getPercentageOfComponentId())
                    .orElseThrow(() -> new ApiException(FeeRateErrors.FEE_COMPONENT_NOT_FOUND, "Percentage base component not found", HttpStatus.NOT_FOUND));
        }

        // Validate
        validateDates(dto.getEffectiveFrom(), dto.getEffectiveTo());
        checkOverlaps(campus.getId(), standard.getId(), academicYear, feeComponent, dto.getEffectiveFrom(), dto.getEffectiveTo(), id);

        // Update
        FeeRateMapper.updateEntityFromDTO(existing, dto);
        existing.setCampus(campus);
        existing.setStandard(standard);
        existing.setAcademicYear(academicYear);
        existing.setFeeComponent(feeComponent);
        existing.setChargeType(chargeType);
        existing.setSlabGroup(slabGroup);
        existing.setPercentageOfComponent(percComponent);

        FeeRateEntity updated = feeRateRepository.save(existing);
        log.info("[Service:FeeRateService] updateFeeRate() succeeded - id: {}", id);
        return FeeRateMapper.toResponseDTO(updated);
    }

    public List<FeeRatesResponseDTO> searchFeeRates(Long feeCatalogId, Long feeComponentId, String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] searchFeeRates() called - keyword: {}, organization: {}", keyword, organizationId);
        List<FeeRateEntity> result = feeRateRepository.searchFeeRatesByOrganization(feeCatalogId, feeComponentId, keyword, organizationId);
        return FeeRateMapper.toResponseDTOList(result);
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeRateErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeRateService] getStatistics() called - organization: {}", organizationId);

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalRates", feeRateRepository.countByOrganizationId(organizationId));
        stats.put("activeRates", feeRateRepository.countByOrganizationIdAndActiveTrue(organizationId));
        stats.put("inactiveRates", feeRateRepository.countByOrganizationIdAndActiveFalse(organizationId));

        log.info("[Service:FeeRateService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }

    private void validateDates(LocalDate from, LocalDate to) {
        if (to != null && to.isBefore(from)) {
            throw new ApiException(FeeRateErrors.INVALID_FEE_RATE_DATA, "Effective To date cannot be before Effective From date", HttpStatus.BAD_REQUEST);
        }
    }

    private void checkOverlaps(Long campusId, Long standardId, AcademicYearEntity academicYear, FeeComponentEntity component, LocalDate from, LocalDate to, Long existingId) {
        List<FeeRateEntity> overlapping = feeRateRepository.findActiveFeeRatesByComponent(campusId, standardId, academicYear.getId(), component != null ? component.getId() : null);

        if (!CollectionUtils.isEmpty(overlapping)) {
            for (FeeRateEntity fr : overlapping) {
                if (existingId != null && fr.getId().equals(existingId)) continue;

                LocalDate existingFrom = fr.getEffectiveFrom();
                LocalDate existingTo = fr.getEffectiveTo() != null ? fr.getEffectiveTo() : academicYear.getEndDate();
                LocalDate newFrom = from;
                LocalDate newTo = to != null ? to : academicYear.getEndDate();

                if (!(newTo.isBefore(existingFrom) || newFrom.isAfter(existingTo))) {
                    throw new ApiException(FeeRateErrors.OVERLAPPING_FEE_RATE, HttpStatus.CONFLICT);
                }
            }
        }
    }
}
