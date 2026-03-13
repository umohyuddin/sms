package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.dtos.chargetype.request.ChargeTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.school.error.ChargeTypeErrors;
import com.smartsolutions.eschool.school.mapper.ChargeTypeMapper;
import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import com.smartsolutions.eschool.school.repository.ChargeTypeRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ChargeTypeService {

    private final ChargeTypeRepository chargeTypeRepository;

    public ChargeTypeService(ChargeTypeRepository chargeTypeRepository) {
        this.chargeTypeRepository = chargeTypeRepository;
    }

    @Transactional(readOnly = true)
    public List<ChargeTypeResponseDTO> getAllChargeTypes() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] getAllChargeTypes() called - OrgId: {}", orgId);
        List<ChargeTypeEntity> entities = chargeTypeRepository.findAllByOrganizationId(orgId);
        return ChargeTypeMapper.toResponseDTOList(entities);
    }

    @Transactional(readOnly = true)
    public List<ChargeTypeResponseDTO> getAllActiveChargeTypes() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] getAllActiveChargeTypes() called - OrgId: {}", orgId);
        List<ChargeTypeEntity> entities = chargeTypeRepository.findAllActiveByOrganizationId(orgId);
        return ChargeTypeMapper.toResponseDTOList(entities);
    }

    @Transactional(readOnly = true)
    public ChargeTypeResponseDTO getChargeTypeById(Long id) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] getChargeTypeById() called - id: {}, OrgId: {}", id, orgId);
        ChargeTypeEntity entity = chargeTypeRepository.findByIdAndOrganizationId(id, orgId)
                .orElseThrow(() -> new ApiException(ChargeTypeErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        return ChargeTypeMapper.toResponseDTO(entity);
    }

    @Transactional
    public ChargeTypeResponseDTO createChargeType(ChargeTypeRequestDTO requestDTO) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] createChargeType() called - code: {}, OrgId: {}", requestDTO.getCode(),
                orgId);

        if (chargeTypeRepository.existsByOrganizationIdAndCode(orgId, requestDTO.getCode())) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_CODE, HttpStatus.CONFLICT);
        }

        if (chargeTypeRepository.existsByOrganizationIdAndName(orgId, requestDTO.getName())) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_NAME, HttpStatus.CONFLICT);
        }

        ChargeTypeEntity entity = ChargeTypeMapper.toEntity(requestDTO);
        entity.setOrganizationId(orgId);
        ChargeTypeEntity saved = chargeTypeRepository.save(entity);

        log.info("[Service:ChargeTypeService] createChargeType() succeeded - id: {}", saved.getId());
        return ChargeTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public ChargeTypeResponseDTO updateChargeType(Long id, ChargeTypeRequestDTO requestDTO) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] updateChargeType() called - id: {}, OrgId: {}", id, orgId);

        ChargeTypeEntity entity = chargeTypeRepository.findByIdAndOrganizationId(id, orgId)
                .orElseThrow(() -> new ApiException(ChargeTypeErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (chargeTypeRepository.existsByOrganizationIdAndCodeAndIdNot(orgId, requestDTO.getCode(), id)) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_CODE, HttpStatus.CONFLICT);
        }

        if (chargeTypeRepository.existsByOrganizationIdAndNameAndIdNot(orgId, requestDTO.getName(), id)) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_NAME, HttpStatus.CONFLICT);
        }

        ChargeTypeMapper.updateEntityFromDTO(entity, requestDTO);
        ChargeTypeEntity updated = chargeTypeRepository.save(entity);

        log.info("[Service:ChargeTypeService] updateChargeType() succeeded - id: {}", updated.getId());
        return ChargeTypeMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteChargeType(Long id) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] deleteChargeType() called - id: {}, OrgId: {}", id, orgId);
        ChargeTypeEntity entity = chargeTypeRepository.findByIdAndOrganizationId(id, orgId)
                .orElseThrow(() -> new ApiException(ChargeTypeErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        chargeTypeRepository.delete(entity);
        log.info("[Service:ChargeTypeService] deleteChargeType() succeeded - id: {}", id);
    }

    @Transactional(readOnly = true)
    public List<ChargeTypeResponseDTO> searchChargeTypes(String keyword) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] searchChargeTypes() called - keyword: {}, OrgId: {}", keyword, orgId);
        List<ChargeTypeEntity> result = chargeTypeRepository.searchByKeyword(orgId, keyword);
        return ChargeTypeMapper.toResponseDTOList(result);
    }

    public java.util.Map<String, Long> getStatistics() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:ChargeTypeService] getStatistics() called - OrgId: {}", orgId);

        java.util.Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("totalChargeTypes", chargeTypeRepository.countByOrganizationId(orgId));
        stats.put("activeChargeTypes", chargeTypeRepository.countByOrganizationIdAndActiveTrue(orgId));
        stats.put("inactiveChargeTypes", chargeTypeRepository.countByOrganizationIdAndActiveFalse(orgId));

        log.info("[Service:ChargeTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
