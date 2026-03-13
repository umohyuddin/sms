package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.repository.FeeRecurrenceRuleRepository;
import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import com.smartsolutions.eschool.school.repository.ChargeTypeRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto.FeeCatalogRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.error.FeeCatalogErrors;
import com.smartsolutions.eschool.student.mapper.FeeCatalogMapper;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.repository.FeeCatalogRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FeeCatalogService {
    private final FeeCatalogRepository feeCatalogRepository;
    private final InstituteRepository instituteRepository;
    private final ChargeTypeRepository chargeTypeRepository;
    private final FeeRecurrenceRuleRepository recurrenceRuleRepository;

    public FeeCatalogService(FeeCatalogRepository feeCatalogRepository,
            InstituteRepository instituteRepository,
            ChargeTypeRepository chargeTypeRepository,
            FeeRecurrenceRuleRepository recurrenceRuleRepository) {
        this.feeCatalogRepository = feeCatalogRepository;
        this.instituteRepository = instituteRepository;
        this.chargeTypeRepository = chargeTypeRepository;
        this.recurrenceRuleRepository = recurrenceRuleRepository;
    }

    public List<FeeCatalogDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] getAll() called - institute: {}", organizationId);
        List<FeeCatalogEntity> result = feeCatalogRepository.findByInstituteId(organizationId);
        List<FeeCatalogDTO> responseDTOs = FeeCatalogMapper.toDtoList(result);
        log.info("[Service:FeeCatalogService] getAll() succeeded - Found {} catalogs", responseDTOs.size());
        return responseDTOs;
    }

    public FeeCatalogDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] getById() called - id: {}, institute: {}", id, organizationId);
        FeeCatalogEntity entity = feeCatalogRepository.findByIdAndInstituteId(id, organizationId)
                .orElseThrow(() -> new ApiException(FeeCatalogErrors.FEE_CATALOG_NOT_FOUND, HttpStatus.NOT_FOUND));

        FeeCatalogDTO responseDTO = FeeCatalogMapper.toDto(entity);
        log.info("[Service:FeeCatalogService] getById() succeeded - Found catalog: {}", id);
        return responseDTO;
    }

    public List<FeeCatalogDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] searchByKeyword() called - keyword: {}, institute: {}", keyword,
                organizationId);
        List<FeeCatalogEntity> result = feeCatalogRepository.searchByKeywordAndInstituteId(keyword, organizationId);
        List<FeeCatalogDTO> responseDTOs = FeeCatalogMapper.toDtoList(result);
        log.info("[Service:FeeCatalogService] searchByKeyword() succeeded - Found {} catalogs", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] softDeleteById() called - id: {}, institute: {}", id, organizationId);

        int result = feeCatalogRepository.softDeleteByIdAndInstituteId(id, organizationId);
        if (result == 0) {
            throw new ApiException(FeeCatalogErrors.FEE_CATALOG_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:FeeCatalogService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public FeeCatalogDTO createFeeCatalog(FeeCatalogRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] createFeeCatalog() called - institute: {}", organizationId);

        // Check for duplicates
        Optional<FeeCatalogEntity> existing = feeCatalogRepository.findByCodeOrNameAndInstituteId(
                requestDTO.getCode(), requestDTO.getName(), organizationId);
        if (existing.isPresent()) {
            throw new ApiException(FeeCatalogErrors.DUPLICATE_FEE_CATALOG_CODE, HttpStatus.CONFLICT);
        }

        InstituteEntity institute = instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(FeeCatalogErrors.INSTITUTE_NOT_FOUND, HttpStatus.NOT_FOUND));

        ChargeTypeEntity chargeType = chargeTypeRepository.findById(requestDTO.getChargeTypeId())
                .orElseThrow(() -> new ApiException(FeeCatalogErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        FeeRecurrenceRuleEntity recurrenceRule = null;
        if (requestDTO.getRecurrenceRuleId() != null) {
            recurrenceRule = recurrenceRuleRepository.findById(requestDTO.getRecurrenceRuleId())
                    .orElseThrow(
                            () -> new ApiException(FeeCatalogErrors.RECURRENCE_RULE_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        FeeCatalogEntity entity = FeeCatalogMapper.toEntity(requestDTO);
        entity.setInstitute(institute);
        entity.setChargeType(chargeType);
        entity.setRecurrenceRule(recurrenceRule);

        FeeCatalogEntity saved = feeCatalogRepository.save(entity);
        log.info("[Service:FeeCatalogService] createFeeCatalog() succeeded - id: {}", saved.getId());
        return FeeCatalogMapper.toDto(saved);
    }

    @Transactional
    public FeeCatalogDTO updateFeeCatalog(Long id, FeeCatalogRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] updateFeeCatalog() called - id: {}, institute: {}", id, organizationId);

        FeeCatalogEntity existing = feeCatalogRepository.findByIdAndInstituteId(id, organizationId)
                .orElseThrow(() -> new ApiException(FeeCatalogErrors.FEE_CATALOG_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Check for duplicates excluding current entity
        Optional<FeeCatalogEntity> duplicate = feeCatalogRepository.findByCodeOrNameAndInstituteId(
                requestDTO.getCode(), requestDTO.getName(), organizationId);
        if (duplicate.isPresent() && !duplicate.get().getId().equals(id)) {
            throw new ApiException(FeeCatalogErrors.DUPLICATE_FEE_CATALOG_CODE, HttpStatus.CONFLICT);
        }

        if (requestDTO.getChargeTypeId() != null) {
            ChargeTypeEntity chargeType = chargeTypeRepository.findById(requestDTO.getChargeTypeId())
                    .orElseThrow(() -> new ApiException(FeeCatalogErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
            existing.setChargeType(chargeType);
        }

        if (requestDTO.getRecurrenceRuleId() != null) {
            FeeRecurrenceRuleEntity recurrenceRule = recurrenceRuleRepository.findById(requestDTO.getRecurrenceRuleId())
                    .orElseThrow(
                            () -> new ApiException(FeeCatalogErrors.RECURRENCE_RULE_NOT_FOUND, HttpStatus.NOT_FOUND));
            existing.setRecurrenceRule(recurrenceRule);
        }

        FeeCatalogMapper.updateEntityFromDto(existing, requestDTO);
        FeeCatalogEntity updated = feeCatalogRepository.save(existing);
        log.info("[Service:FeeCatalogService] updateFeeCatalog() succeeded - id: {}", id);
        return FeeCatalogMapper.toDto(updated);
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(FeeCatalogErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:FeeCatalogService] getStatistics() called - institute: {}", organizationId);

        Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("totalCatalogs", feeCatalogRepository.countByInstituteId(organizationId));
        stats.put("activeCatalogs", feeCatalogRepository.countByInstituteIdAndActiveTrue(organizationId));
        stats.put("inactiveCatalogs", feeCatalogRepository.countByInstituteIdAndActiveFalse(organizationId));

        log.info("[Service:FeeCatalogService] getStatistics() succeeded");
        return stats;
    }
}
