package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.FeeRecurrenceRuleErrors;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.FeeRecurrenceRuleMapper;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.repository.FeeRecurrenceRuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FeeRecurrenceRuleService {

    private final FeeRecurrenceRuleRepository feeRecurrenceRuleRepository;

    public FeeRecurrenceRuleService(FeeRecurrenceRuleRepository feeRecurrenceRuleRepository) {
        this.feeRecurrenceRuleRepository = feeRecurrenceRuleRepository;
    }

    public List<FeeRecurrenceRuleResponseDTO> getAll() {
        log.info("[Service:FeeRecurrenceRuleService] getAll() called - Fetching all fee recurrence rules");
        List<FeeRecurrenceRuleEntity> result = feeRecurrenceRuleRepository.findAllNotDeleted();
        List<FeeRecurrenceRuleResponseDTO> responseDTOs = FeeRecurrenceRuleMapper.toResponseDTOList(result);
        log.info("[Service:FeeRecurrenceRuleService] getAll() succeeded - Found {} fee recurrence rules",
                responseDTOs.size());
        return responseDTOs;
    }

    public FeeRecurrenceRuleResponseDTO getById(Long id) {
        log.info("[Service:FeeRecurrenceRuleService] getById() called - id: {}", id);
        FeeRecurrenceRuleEntity entity = feeRecurrenceRuleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(FeeRecurrenceRuleErrors.FEE_RECURRENCE_RULE_NOT_FOUND,
                        HttpStatus.NOT_FOUND));

        FeeRecurrenceRuleResponseDTO responseDTO = FeeRecurrenceRuleMapper.toResponseDTO(entity);
        log.info("[Service:FeeRecurrenceRuleService] getById() succeeded - Found fee recurrence rule: {}", id);
        return responseDTO;
    }

    public List<FeeRecurrenceRuleResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:FeeRecurrenceRuleService] searchByKeyword() called - keyword: {}", keyword);
        List<FeeRecurrenceRuleEntity> result = feeRecurrenceRuleRepository.searchByKeyword(keyword);
        List<FeeRecurrenceRuleResponseDTO> responseDTOs = FeeRecurrenceRuleMapper.toResponseDTOList(result);
        log.info("[Service:FeeRecurrenceRuleService] searchByKeyword() succeeded - Found {} fee recurrence rules",
                responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:FeeRecurrenceRuleService] softDeleteById() called - id: {}", id);

        int result = feeRecurrenceRuleRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(FeeRecurrenceRuleErrors.FEE_RECURRENCE_RULE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:FeeRecurrenceRuleService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public FeeRecurrenceRuleResponseDTO createFeeRecurrenceRule(FeeRecurrenceRuleRequestDTO requestDTO) {
        log.info("[Service:FeeRecurrenceRuleService] createFeeRecurrenceRule() called - Creating: {}",
                requestDTO.getName());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (feeRecurrenceRuleRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(FeeRecurrenceRuleErrors.DUPLICATE_FEE_RECURRENCE_RULE_CODE, HttpStatus.CONFLICT);
            }
        }

        FeeRecurrenceRuleEntity entity = FeeRecurrenceRuleMapper.toEntity(requestDTO);

        FeeRecurrenceRuleEntity saved = feeRecurrenceRuleRepository.save(entity);

        log.info("[Service:FeeRecurrenceRuleService] createFeeRecurrenceRule() succeeded - Created with id: {}",
                saved.getId());
        return FeeRecurrenceRuleMapper.toResponseDTO(saved);
    }

    @Transactional
    public FeeRecurrenceRuleResponseDTO updateFeeRecurrenceRule(Long id, FeeRecurrenceRuleRequestDTO requestDTO) {
        log.info("[Service:FeeRecurrenceRuleService] updateFeeRecurrenceRule() called - id: {}", id);

        FeeRecurrenceRuleEntity existing = feeRecurrenceRuleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(FeeRecurrenceRuleErrors.FEE_RECURRENCE_RULE_NOT_FOUND,
                        HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (feeRecurrenceRuleRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(FeeRecurrenceRuleErrors.DUPLICATE_FEE_RECURRENCE_RULE_CODE, HttpStatus.CONFLICT);
            }
        }

        FeeRecurrenceRuleMapper.updateEntity(existing, requestDTO);

        FeeRecurrenceRuleEntity updated = feeRecurrenceRuleRepository.save(existing);

        log.info("[Service:FeeRecurrenceRuleService] updateFeeRecurrenceRule() succeeded - id: {}", id);
        return FeeRecurrenceRuleMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:FeeRecurrenceRuleService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalFeeRecurrenceRules", feeRecurrenceRuleRepository.countAllActive());
        stats.put("activeFeeRecurrenceRules", feeRecurrenceRuleRepository.countByIsActiveTrue());
        stats.put("inactiveFeeRecurrenceRules", feeRecurrenceRuleRepository.countByIsActiveFalse());

        log.info("[Service:FeeRecurrenceRuleService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
