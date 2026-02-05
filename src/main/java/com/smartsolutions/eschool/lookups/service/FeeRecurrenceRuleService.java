package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.FeeRecurrenceRuleMapper;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.repository.FeeRecurrenceRuleRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FeeRecurrenceRuleService {
    
    private final FeeRecurrenceRuleRepository repository;

    public FeeRecurrenceRuleService(FeeRecurrenceRuleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FeeRecurrenceRuleResponseDTO create(@Valid FeeRecurrenceRuleRequestDTO requestDTO) {
        log.info("Creating new FeeRecurrenceRule: {}", requestDTO.getName());
        try {
            FeeRecurrenceRuleEntity entity = FeeRecurrenceRuleMapper.toEntity(requestDTO);
            repository.save(entity);
            return FeeRecurrenceRuleMapper.toResponseDTO(entity);
        } catch (DataAccessException dae) {
            log.error("Database error while creating FeeRecurrenceRule", dae);
            throw new CustomServiceException("Failed to create FeeRecurrenceRule due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating FeeRecurrenceRule", e);
            throw new CustomServiceException("Failed to create FeeRecurrenceRule");
        }
    }

    public List<FeeRecurrenceRuleResponseDTO> getAllActive() {
        try {
            log.info("Fetching active FeeRecurrenceRules");
            List<FeeRecurrenceRuleEntity> result = repository.findAllActive();
            return result.stream()
                    .map(FeeRecurrenceRuleMapper::toResponseDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error fetching active fee recurrence rules", e);
            throw new CustomServiceException("Failed to fetch active FeeRecurrenceRules", e);
        }
    }

    public FeeRecurrenceRuleResponseDTO getById(Long id) {
        log.info("Fetching FeeRecurrenceRule with id={}", id);
        FeeRecurrenceRuleEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeRecurrenceRule not found with id=" + id));
        return FeeRecurrenceRuleMapper.toResponseDTO(entity);
    }

    @Transactional
    public FeeRecurrenceRuleResponseDTO update(Long id, @Valid FeeRecurrenceRuleRequestDTO requestDTO) {
        log.info("Updating FeeRecurrenceRule id={}", id);
        FeeRecurrenceRuleEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeRecurrenceRule not found with id=" + id));
        
        FeeRecurrenceRuleMapper.updateEntity(entity, requestDTO);
        repository.save(entity);
        return FeeRecurrenceRuleMapper.toResponseDTO(entity);
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft delete request for FeeRecurrenceRule id={}", id);
        return repository.softDeleteById(id);
    }
}
