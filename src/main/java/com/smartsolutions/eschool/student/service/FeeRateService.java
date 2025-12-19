package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.student.repository.FeeRateRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FeeRateService {

    private final FeeRateRepository feeRateRepository;
    private final CampusRepository campusRepository;
    private final StandardRepository standardRepository;
    private final AcademicYearRepository academicYearRepository;
    private final FeeComponentRepository feeComponentRepository;

    public FeeRateService(FeeRateRepository feeRateRepository, CampusRepository campusRepository, StandardRepository standardRepository, AcademicYearRepository academicYearRepository, FeeComponentRepository feeComponentRepository) {
        this.feeRateRepository = feeRateRepository;
        this.campusRepository = campusRepository;
        this.standardRepository = standardRepository;

        this.academicYearRepository = academicYearRepository;
        this.feeComponentRepository = feeComponentRepository;

    }


    public List<FeeRatesResponseDTO> searchFeeRates(Long feeCatalogId, Long feeComponentId, String keyword) {
        try {
            log.info("Searching FeeRates with filters → feeCatalogId={}, feeComponentId={}, keyword={}", feeCatalogId, feeComponentId, keyword);
            String searchKeyword = (keyword == null || keyword.isBlank()) ? null : keyword.trim();
            List<FeeRateEntity> results = feeRateRepository.searchFeeRates(feeCatalogId, feeComponentId, searchKeyword);
            log.info("Search returned {} FeeRates", results.size());
            return MapperUtil.mapList(results, FeeRatesResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while searching FeeRates", dae);
        } catch (MappingException me) {
            log.error("Error mapping FeeRateEntity to FeeRatesResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while searching FeeRates", e);
        }

        return Collections.emptyList();
    }

    public FeeRatesResponseDTO getById(Long id) {
        log.info("Fetching FeeRate with id: {}", id);
        FeeRateEntity feeRateEntity = feeRateRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching FeeRate with id: {}", id);
            return new ResourceNotFoundException("FeeRate not found with id: " + id);
        });

        FeeRatesResponseDTO feeRateDTO = MapperUtil.mapObject(feeRateEntity, FeeRatesResponseDTO.class);
        log.info("Successfully fetched FeeRate: id={}", feeRateDTO.getId());
        return feeRateDTO;
    }

    public List<FeeRatesResponseDTO> getAll() {
        try {
            log.info("Fetching all FeeRates from database");
            List<FeeRateEntity> result = feeRateRepository.findByDeletedFalse();
            log.info("Successfully fetched {} FeeRates", result.size());
            List<FeeRatesResponseDTO> feeRateDTOS = MapperUtil.mapList(result, FeeRatesResponseDTO.class);
            log.info("Successfully fetched FeeRates");
            return feeRateDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeRates", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to FeeRates", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeRates", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }


    public List<FeeRatesResponseDTO> getByFeeComponentId(Long id) {
        try {
            log.info("Fetching all Fee Rates by fee component from database");
            List<FeeRateEntity> result = feeRateRepository.findByFeeComponentId(id);
            log.info("Successfully fetched {} FeeRates by fee component", result.size());
            List<FeeRatesResponseDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeRatesResponseDTO.class);
            log.info("Successfully fetched FeeRates by fee component");
            return FeeComponentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeRates by fee component", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping FeeRateEntity to FeeRates by fee component", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeRates by fee component", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }


    public List<FeeRatesResponseDTO> findActiveFeeRates(Long campusId, Long standardId, Long academicYearId) {
        try {
            log.info("Fetching all Fee Rates by fee component from database");
            List<FeeRateEntity> result = feeRateRepository.findActiveFeeRates(campusId, standardId, academicYearId);
            log.info("Successfully fetched {} FeeRates by fee component", result.size());
            List<FeeRatesResponseDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeRatesResponseDTO.class);
            log.info("Successfully fetched FeeRates by fee component");
            return FeeComponentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeRates by fee component", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping FeeRateEntity to FeeRates by fee component", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeRates by fee component", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }


    @Transactional
    public FeeRatesResponseDTO createFeeRate(FeeRateCreateRequestDTO dto) {
        // Fetch related entities
        CampusEntity campus = campusRepository.findById(dto.getCampusId()).orElseThrow(() -> new IllegalArgumentException("Campus not found with id: " + dto.getCampusId()));

        StandardEntity standard = standardRepository.findById(dto.getStandardId()).orElseThrow(() -> new IllegalArgumentException("Standard not found with id: " + dto.getStandardId()));

        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId()).orElseThrow(() -> new IllegalArgumentException("Academic Year not found with id: " + dto.getAcademicYearId()));

        FeeComponentEntity feeComponent = null;
        if (dto.getFeeComponentId() != null) {
            feeComponent = feeComponentRepository.findById(dto.getFeeComponentId()).orElseThrow(() -> new IllegalArgumentException("Fee Component not found with id: " + dto.getFeeComponentId()));
        }

        // Validate effective dates
        LocalDate from = dto.getEffectiveFrom();
        LocalDate to = dto.getEffectiveTo();

        if (to != null && to.isBefore(from)) {
            throw new IllegalArgumentException("Effective To date cannot be before Effective From date");
        }

        // Check for overlapping FeeRates
        List<FeeRateEntity> overlapping = feeRateRepository.findActiveFeeRates(campus.getId(), standard.getId(), academicYear.getId());

        if (!CollectionUtils.isEmpty(overlapping)) {
            for (FeeRateEntity fr : overlapping) {
                LocalDate existingFrom = fr.getEffectiveFrom();
                LocalDate existingTo = fr.getEffectiveTo() != null ? fr.getEffectiveTo() : LocalDate.MAX;
                LocalDate newFrom = from;
                LocalDate newTo = to != null ? to : LocalDate.MAX;

                boolean isOverlapping = !(newTo.isBefore(existingFrom) || newFrom.isAfter(existingTo));
                if (isOverlapping) {
                    throw new IllegalArgumentException("Overlapping FeeRate exists for this Campus, Standard, and Academic Year");
                }
            }
        }

        // Create new FeeRate entity
        FeeRateEntity feeRate = new FeeRateEntity();
        feeRate.setCampus(campus);
        feeRate.setStandard(standard);
        feeRate.setAcademicYear(academicYear);
        feeRate.setFeeComponent(feeComponent);
        feeRate.setAmount(dto.getAmount());
        feeRate.setCurrency(dto.getCurrency());
        feeRate.setEffectiveFrom(from);
        feeRate.setEffectiveTo(to);
        feeRate.setActive(dto.isActive());
        feeRate.setDeleted(false);

        // Save entity
        FeeRateEntity savedFeeRate = feeRateRepository.save(feeRate);

        // Map to response DTO
        return MapperUtil.mapObject(savedFeeRate, FeeRatesResponseDTO.class);
    }


    @Transactional
    public FeeRatesResponseDTO updateFeeRate(Long feeRateId, FeeRateCreateRequestDTO dto) {
        //  Fetch existing FeeRate
        FeeRateEntity existingFeeRate = feeRateRepository.findById(feeRateId).orElseThrow(() -> new IllegalArgumentException("FeeRate not found with id: " + feeRateId));

        // Fetch related entities
        CampusEntity campus = campusRepository.findById(dto.getCampusId()).orElseThrow(() -> new IllegalArgumentException("Campus not found with id: " + dto.getCampusId()));

        var standard = standardRepository.findById(dto.getStandardId()).orElseThrow(() -> new IllegalArgumentException("Standard not found with id: " + dto.getStandardId()));

        var academicYear = academicYearRepository.findById(dto.getAcademicYearId()).orElseThrow(() -> new IllegalArgumentException("Academic Year not found with id: " + dto.getAcademicYearId()));

        var feeComponent = dto.getFeeComponentId() != null ? feeComponentRepository.findById(dto.getFeeComponentId()).orElseThrow(() -> new IllegalArgumentException("Fee Component not found with id: " + dto.getFeeComponentId())) : null;

        // Validate effective dates
        LocalDate from = dto.getEffectiveFrom();
        LocalDate to = dto.getEffectiveTo();

        if (to != null && to.isBefore(from)) {
            throw new IllegalArgumentException("Effective To date cannot be before Effective From date");
        }

        // Check for overlapping FeeRates (excluding the current record)
        List<FeeRateEntity> overlapping = feeRateRepository.findActiveFeeRates(campus.getId(), standard.getId(), academicYear.getId());

        if (!CollectionUtils.isEmpty(overlapping)) {
            for (FeeRateEntity fr : overlapping) {
                if (fr.getId().equals(feeRateId)) continue; // skip current fee rate

                LocalDate existingFrom = fr.getEffectiveFrom();
                LocalDate existingTo = fr.getEffectiveTo() != null ? fr.getEffectiveTo() : LocalDate.MAX;
                LocalDate newFrom = from;
                LocalDate newTo = to != null ? to : LocalDate.MAX;

                boolean isOverlapping = !(newTo.isBefore(existingFrom) || newFrom.isAfter(existingTo));
                if (isOverlapping) {
                    throw new IllegalArgumentException("Overlapping FeeRate exists for this Campus, Standard, and Academic Year");
                }
            }
        }

        //  Update fields
        existingFeeRate.setCampus(campus);
        existingFeeRate.setStandard(standard);
        existingFeeRate.setAcademicYear(academicYear);
        existingFeeRate.setFeeComponent(feeComponent);
        existingFeeRate.setAmount(dto.getAmount());
        existingFeeRate.setCurrency(dto.getCurrency());
        existingFeeRate.setEffectiveFrom(from);
        existingFeeRate.setEffectiveTo(to);
        existingFeeRate.setActive(dto.isActive());

        //  Save updated FeeRate
        FeeRateEntity feeRateEntity = feeRateRepository.save(existingFeeRate);
        return MapperUtil.mapObject(feeRateEntity, FeeRatesResponseDTO.class);
    }
}
