package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;
import com.smartsolutions.eschool.school.dtos.chargetype.request.ChargeTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.school.error.ChargeTypeErrors;
import com.smartsolutions.eschool.school.mapper.ChargeTypeMapper;
import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import com.smartsolutions.eschool.school.repository.ChargeTypeRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ChargeTypeService {

    @Autowired
    private EntityReferenceValidator entityReferenceValidator;


    private final ChargeTypeRepository chargeTypeRepository;

    public ChargeTypeService(ChargeTypeRepository chargeTypeRepository) {
        this.chargeTypeRepository = chargeTypeRepository;
    }

    @Transactional(readOnly = true)
    public List<ChargeTypeResponseDTO> getAllChargeTypes() {
        log.info("[Service:ChargeTypeService] getAllChargeTypes() called");
        List<ChargeTypeEntity> entities = chargeTypeRepository.findAllChargeTypes();
        return ChargeTypeMapper.toResponseDTOList(entities);
    }

    @Transactional(readOnly = true)
    public List<ChargeTypeResponseDTO> getAllActiveChargeTypes() {
        log.info("[Service:ChargeTypeService] getAllActiveChargeTypes() called");
        List<ChargeTypeEntity> entities = chargeTypeRepository.findAllActiveChargeTypes();
        return ChargeTypeMapper.toResponseDTOList(entities);
    }

    @Transactional(readOnly = true)
    public ChargeTypeResponseDTO getChargeTypeById(Long id) {
        log.info("[Service:ChargeTypeService] getChargeTypeById() called - id: {}", id);
        ChargeTypeEntity entity = chargeTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(ChargeTypeErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        return ChargeTypeMapper.toResponseDTO(entity);
    }

    @Transactional
    public ChargeTypeResponseDTO createChargeType(ChargeTypeRequestDTO requestDTO) {
        log.info("[Service:ChargeTypeService] createChargeType() called - code: {}", requestDTO.getCode());

        if (chargeTypeRepository.existsByCode(requestDTO.getCode())) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_CODE, HttpStatus.CONFLICT);
        }

        if (chargeTypeRepository.existsByName(requestDTO.getName())) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_NAME, HttpStatus.CONFLICT);
        }

        ChargeTypeEntity entity = ChargeTypeMapper.toEntity(requestDTO);
        ChargeTypeEntity saved = chargeTypeRepository.save(entity);

        log.info("[Service:ChargeTypeService] createChargeType() succeeded - id: {}", saved.getId());
        return ChargeTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public ChargeTypeResponseDTO updateChargeType(Long id, ChargeTypeRequestDTO requestDTO) {
        log.info("[Service:ChargeTypeService] updateChargeType() called - id: {}", id);

        ChargeTypeEntity entity = chargeTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(ChargeTypeErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (chargeTypeRepository.existsByCodeAndIdNot(requestDTO.getCode(), id)) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_CODE, HttpStatus.CONFLICT);
        }

        if (chargeTypeRepository.existsByNameAndIdNot(requestDTO.getName(), id)) {
            throw new ApiException(ChargeTypeErrors.DUPLICATE_CHARGE_TYPE_NAME, HttpStatus.CONFLICT);
        }

        ChargeTypeMapper.updateEntityFromDTO(entity, requestDTO);
        ChargeTypeEntity updated = chargeTypeRepository.save(entity);

        log.info("[Service:ChargeTypeService] updateChargeType() succeeded - id: {}", updated.getId());
        return ChargeTypeMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteChargeType(Long id) {
        log.info("[Service:ChargeTypeService] deleteChargeType() called - id: {}", id);
        ChargeTypeEntity entity = chargeTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(ChargeTypeErrors.CHARGE_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        chargeTypeRepository.delete(entity);
        log.info("[Service:ChargeTypeService] deleteChargeType() succeeded - id: {}", id);
    }

    @Transactional(readOnly = true)
    public List<ChargeTypeResponseDTO> searchChargeTypes(String keyword) {
        log.info("[Service:ChargeTypeService] searchChargeTypes() called - keyword: {}", keyword);
        List<ChargeTypeEntity> result = chargeTypeRepository.searchByKeyword(keyword);
        return ChargeTypeMapper.toResponseDTOList(result);
    }

    public java.util.Map<String, Long> getStatistics() {
        log.info("[Service:ChargeTypeService] getStatistics() called");

        java.util.Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("totalChargeTypes", chargeTypeRepository.countAllChargeTypes());
        stats.put("activeChargeTypes", chargeTypeRepository.countByActiveTrue());
        stats.put("inactiveChargeTypes", chargeTypeRepository.countByActiveFalse());

        log.info("[Service:ChargeTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
