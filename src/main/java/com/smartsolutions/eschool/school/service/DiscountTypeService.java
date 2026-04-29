package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.repository.FeeRecurrenceRuleRepository;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.mapper.DiscountTypeMapper;
import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.ChargeTypeRepository;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DiscountTypeService {
    private final DiscountTypeRepository discountTypeRepository;
    private final ChargeTypeRepository chargeTypeRepository;
    private final FeeRecurrenceRuleRepository feeRecurrenceRuleRepository;

    public DiscountTypeService(DiscountTypeRepository discountTypeRepository,
            ChargeTypeRepository chargeTypeRepository,
            FeeRecurrenceRuleRepository feeRecurrenceRuleRepository) {
        this.discountTypeRepository = discountTypeRepository;
        this.chargeTypeRepository = chargeTypeRepository;
        this.feeRecurrenceRuleRepository = feeRecurrenceRuleRepository;
    }

    @Transactional
    public DiscountTypeResponseDTO create(@Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Creating new Discount Type: {}", requestDTO.getName());
        try {
            ChargeTypeEntity chargeType = chargeTypeRepository.findById(requestDTO.getChargeTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Charge Type not found with id: " + requestDTO.getChargeTypeId()));

            FeeRecurrenceRuleEntity recurrenceRule = null;
            if (requestDTO.getRecurrenceRuleId() != null) {
                recurrenceRule = feeRecurrenceRuleRepository.findById(requestDTO.getRecurrenceRuleId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Recurrence Rule not found with id: " + requestDTO.getRecurrenceRuleId()));
            }

            DiscountTypeEntity entity = DiscountTypeMapper.toEntity(requestDTO);
            entity.setChargeType(chargeType);
            entity.setRecurrenceRule(recurrenceRule);

            discountTypeRepository.save(entity);
            log.info("Discount Type saved with id: {}", entity.getId());
            return DiscountTypeMapper.toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Type", dae);
            throw new CustomServiceException("Failed to create Discount Type due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Type", e);
            throw new CustomServiceException("Failed to create Discount Type", e);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountTypeResponseDTO> getAll() {
        log.info("Fetching all Discount Types");
        try {
            return DiscountTypeMapper.toDtoList(discountTypeRepository.findAllDeletedFalse());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Types", dae);
            throw new CustomServiceException("Unable to fetch Discount Types from database", dae);
        }
    }

    @Transactional(readOnly = true)
    public DiscountTypeResponseDTO getById(Long id) {
        log.info("Fetching DiscountType with id={}", id);
        DiscountTypeEntity entity = discountTypeRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.warn("DiscountType not found for id={}", id);
            return new ResourceNotFoundException("Discount Type not found with id: " + id);
        });
        return DiscountTypeMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<DiscountTypeResponseDTO> getAllActive() {
        log.info("Fetching all Active Discount Types");
        try {
            return DiscountTypeMapper.toDtoList(discountTypeRepository.findAllActive());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Active Discount Types", dae);
            throw new CustomServiceException("Unable to fetch Active Discount Types", dae);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountTypeResponseDTO> getAllInActive() {
        log.info("Fetching all Inactive Discount Types");
        try {
            return DiscountTypeMapper.toDtoList(discountTypeRepository.findAllNonActive());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Inactive Discount Types", dae);
            throw new CustomServiceException("Unable to fetch Inactive Discount Types", dae);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Discount Types with keyword={}", keyword);
        try {
            return DiscountTypeMapper.toDtoList(discountTypeRepository.searchByKeyword(keyword));
        } catch (DataAccessException dae) {
            log.error("Database error while searching Discount Types", dae);
            throw new CustomServiceException("Unable to search Discount Types", dae);
        }
    }

    @Transactional
    public DiscountTypeResponseDTO update(Long id, @Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Update request received for DiscountType ID: {}", id);
        try {
            DiscountTypeEntity existing = discountTypeRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
                log.warn("DiscountType not found with ID: {}", id);
                return new ResourceNotFoundException("Discount Type not found with id: " + id);
            });

            DiscountTypeMapper.updateEntityFromDto(existing, requestDTO);

            ChargeTypeEntity chargeType = chargeTypeRepository.findById(requestDTO.getChargeTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Charge Type not found with id: " + requestDTO.getChargeTypeId()));
            existing.setChargeType(chargeType);

            if (requestDTO.getRecurrenceRuleId() != null) {
                FeeRecurrenceRuleEntity rr = feeRecurrenceRuleRepository.findById(requestDTO.getRecurrenceRuleId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Recurrence Rule not found with id: " + requestDTO.getRecurrenceRuleId()));
                existing.setRecurrenceRule(rr);
            } else {
                existing.setRecurrenceRule(null);
            }

            discountTypeRepository.save(existing);
            log.info("DiscountType updated successfully with ID: {}", existing.getId());
            return DiscountTypeMapper.toDto(existing);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (DataAccessException dae) {
            log.error("Database error while updating DiscountType with ID: {}", id, dae);
            throw new CustomServiceException("Failed to update Discount Type due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating DiscountType with ID: {}", id, e);
            throw new CustomServiceException("Unexpected error occurred while updating Discount Type", e);
        }
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Delete request received for DiscountType ID: {}", id);
        try {
            return discountTypeRepository.softDeleteById(id);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting DiscountType with ID {}", id, dae);
            throw new CustomServiceException("Failed to delete DiscountType due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while deleting DiscountType with ID {}", id, e);
            throw new CustomServiceException("Unexpected error occurred during deletion", e);
        }
    }
}
