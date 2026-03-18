package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateResponseDTO;
import com.smartsolutions.eschool.school.mapper.DiscountRateMapper;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DiscountRateEntity;
import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.DiscountRateRepository;
import com.smartsolutions.eschool.school.repository.DiscountSubTypeRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DiscountRateService {

    private final DiscountRateRepository discountRateRepository;
    private final DiscountSubTypeRepository discountSubTypeRepository;
    private final CampusRepository campusRepository;
    private final AcademicYearRepository academicYearRepository;
    public DiscountRateService(DiscountRateRepository discountRateRepository,
            DiscountSubTypeRepository discountSubTypeRepository,
            CampusRepository campusRepository,
            AcademicYearRepository academicYearRepository) {
        this.discountRateRepository = discountRateRepository;
        this.discountSubTypeRepository = discountSubTypeRepository;
        this.campusRepository = campusRepository;
        this.academicYearRepository = academicYearRepository;
    }

    @Transactional
    public DiscountRateResponseDTO create(@Valid DiscountRateRequestDTO requestDTO) {
        log.info("Creating new Discount Rate for SubTypeId: {}", requestDTO.getDiscountSubTypeId());
        try {
            DiscountSubTypeEntity subType = discountSubTypeRepository
                    .findByIdAndDeletedFalse(requestDTO.getDiscountSubTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Discount Sub Type not found with id: " + requestDTO.getDiscountSubTypeId()));


            CampusEntity campus = null;
            if (requestDTO.getCampusId() != null) {
                campus = campusRepository.findById(requestDTO.getCampusId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Campus not found with id: " + requestDTO.getCampusId()));
            }

            AcademicYearEntity academicYear = academicYearRepository.findById(requestDTO.getAcademicYearId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Academic Year not found with id: " + requestDTO.getAcademicYearId()));

            DiscountRateEntity entity = DiscountRateMapper.toEntity(requestDTO);
            entity.setDiscountSubType(subType);
            entity.setCampus(campus);
            entity.setAcademicYear(academicYear);

            discountRateRepository.save(entity);
            log.info("Discount Rate saved with id: {}", entity.getId());
            return DiscountRateMapper.toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Rate", dae);
            throw new CustomServiceException("Failed to create Discount Rate due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Rate", e);
            throw new CustomServiceException("Failed to create Discount Rate", e);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountRateResponseDTO> getAll() {
        log.info("Fetching all Discount Rates");
        try {
            return DiscountRateMapper.toDtoList(discountRateRepository.findAllDeletedFalse());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Rates", dae);
            throw new CustomServiceException("Unable to fetch Discount Rates", dae);
        }
    }

    @Transactional(readOnly = true)
    public DiscountRateResponseDTO getById(Long id) {
        log.info("Fetching Discount Rate with id: {}", id);
        DiscountRateEntity entity = discountRateRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount Rate not found with id: " + id));
        return DiscountRateMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<DiscountRateResponseDTO> getAllByCampus(Long campusId) {
        log.info("Fetching all Discount Rates for campusId: {}", campusId);
        try {
            return DiscountRateMapper.toDtoList(discountRateRepository.findAllByCampus(campusId));
        } catch (Exception e) {
            log.error("Error fetching Discount Rates by campusId: {}", campusId, e);
            throw new CustomServiceException("Failed to fetch Discount Rates by campus", e);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountRateResponseDTO> getAllByAcademicYear(Long academicYearId) {
        log.info("Fetching all Discount Rates for academicYearId: {}", academicYearId);
        try {
            return DiscountRateMapper.toDtoList(discountRateRepository.findAllByAcademicYear(academicYearId));
        } catch (Exception e) {
            log.error("Error fetching Discount Rates by academicYearId: {}", academicYearId, e);
            throw new CustomServiceException("Failed to fetch Discount Rates by academic year", e);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountRateResponseDTO> getDiscountRatesByCampusAndAcademicYear(Long campusId, Long academicYearId) {
        log.info("Fetching Discount Rates for campusId={} and academicYearId={}", campusId, academicYearId);
        try {
            return DiscountRateMapper.toDtoList(
                    discountRateRepository.findDiscountRatesByCampusAndAcademicYear(campusId, academicYearId));
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Rates for campusId={} and academicYearId={}", campusId,
                    academicYearId, dae);
            throw new CustomServiceException("Failed to fetch Discount Rates due to database error", dae);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountRateResponseDTO> search(Long discountTypeId, Long discountSubTypeId,
            Long recurrenceRuleId, String keyword) {
        log.info(
                "SEARCH DiscountRates discountTypeId={}, discountSubTypeId={}, recurrenceRuleId={}, keyword={}",
                discountTypeId, discountSubTypeId, recurrenceRuleId, keyword);
        try {
            String kw = (keyword == null || keyword.isBlank()) ? null : keyword.trim();
            List<DiscountRateEntity> entities = discountRateRepository.search(discountTypeId, discountSubTypeId,
                    recurrenceRuleId, kw);
            return DiscountRateMapper.toDtoList(entities);
        } catch (DataAccessException dae) {
            log.error("Database error while searching Discount Rates", dae);
            throw new CustomServiceException("Failed to search Discount Rates", dae);
        }
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft deleting Discount Rate id: {}", id);
        try {
            return discountRateRepository.softDeleteById(id);
        } catch (Exception e) {
            log.error("Error soft deleting Discount Rate with id: {}", id, e);
            throw new CustomServiceException("Failed to soft delete Discount Rate", e);
        }
    }

    @Transactional
    public int markAsActive(Long id) {
        log.info("Marking Discount Rate as active with id: {}", id);
        try {
            int updated = discountRateRepository.markAsActive(id);
            if (updated == 0)
                throw new ResourceNotFoundException("Discount Rate not found with id: " + id);
            return updated;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error marking Discount Rate as active with id: {}", id, e);
            throw new CustomServiceException("Failed to mark Discount Rate as active", e);
        }
    }

    @Transactional
    public int markAsInactive(Long id) {
        log.info("Marking Discount Rate as inactive with id: {}", id);
        try {
            int updated = discountRateRepository.markAsInactive(id);
            if (updated == 0)
                throw new ResourceNotFoundException("Discount Rate not found with id: " + id);
            return updated;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error marking Discount Rate as inactive with id: {}", id, e);
            throw new CustomServiceException("Failed to mark Discount Rate as inactive", e);
        }
    }
    @Transactional
    public int softDeleteAll() {
        log.info("Soft deleting all Discount Rates");
        try {
            return discountRateRepository.softDeleteAll();
        } catch (Exception e) {
            log.error("Error soft deleting all Discount Rates", e);
            throw new CustomServiceException("Failed to soft delete all Discount Rates", e);
        }
    }

    @Transactional
    public DiscountRateResponseDTO update(Long id, @Valid DiscountRateRequestDTO requestDTO) {
        log.info("Updating Discount Rate with id: {}", id);
        try {
            DiscountRateEntity existing = discountRateRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Discount Rate not found with id: " + id));

            DiscountSubTypeEntity subType = discountSubTypeRepository
                    .findByIdAndDeletedFalse(requestDTO.getDiscountSubTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Discount Sub Type not found with id: " + requestDTO.getDiscountSubTypeId()));



            CampusEntity campus = null;
            if (requestDTO.getCampusId() != null) {
                campus = campusRepository.findById(requestDTO.getCampusId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Campus not found with id: " + requestDTO.getCampusId()));
            }

            AcademicYearEntity academicYear = academicYearRepository.findById(requestDTO.getAcademicYearId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Academic Year not found with id: " + requestDTO.getAcademicYearId()));

            existing.setValue(requestDTO.getValue());
            existing.setIsPercentage(requestDTO.getIsPercentage());
            existing.setEffectiveFrom(requestDTO.getEffectiveFrom());
            existing.setEffectiveTo(requestDTO.getEffectiveTo());
            existing.setIsActive(requestDTO.getIsActive() != null ? requestDTO.getIsActive() : true);
            existing.setDiscountSubType(subType);
            existing.setCampus(campus);
            existing.setAcademicYear(academicYear);

            discountRateRepository.save(existing);
            log.info("Discount Rate updated successfully with id: {}", existing.getId());
            return DiscountRateMapper.toDto(existing);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (DataAccessException dae) {
            log.error("Database error while updating Discount Rate with id: {}", id, dae);
            throw new CustomServiceException("Failed to update Discount Rate due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating Discount Rate with id: {}", id, e);
            throw new CustomServiceException("Unexpected error while updating Discount Rate", e);
        }
    }
}
