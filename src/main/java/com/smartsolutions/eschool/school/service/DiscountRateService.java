package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateFullResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateResponseDTO;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DiscountRateEntity;
import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.DiscountRateRepository;
import com.smartsolutions.eschool.school.repository.DiscountSubTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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

    public DiscountRateResponseDTO createDiscountRate(@Valid DiscountRateRequestDTO requestDTO) {
        log.info("Creating new Discount Rate for SubTypeId: {}", requestDTO.getDiscountSubTypeId());
        try {
            DiscountSubTypeEntity subType = discountSubTypeRepository
                    .findByIdAndDeletedFalse(requestDTO.getDiscountSubTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Discount Sub Type not found with id: " + requestDTO.getDiscountSubTypeId()));

            CampusEntity campus = null;
            if (requestDTO.getCampusId() != null) {
                campus = campusRepository.findById(requestDTO.getCampusId())
                        .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + requestDTO.getCampusId()));
            }

            AcademicYearEntity academicYear = academicYearRepository.findById(requestDTO.getAcademicYearId())
                    .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found with id: " + requestDTO.getAcademicYearId()));

            DiscountRateEntity entity = MapperUtil.mapObject(requestDTO, DiscountRateEntity.class);
            entity.setId(null);
            entity.setDiscountSubType(subType);
            entity.setCampus(campus);
            entity.setAcademicYear(academicYear);

            discountRateRepository.save(entity);
            log.info("Discount Rate saved with id: {}", entity.getId());
            return MapperUtil.mapObject(entity, DiscountRateResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Rate", dae);
            throw new CustomServiceException("Failed to create Discount Rate due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Rate", e);
            throw new CustomServiceException("Failed to create Discount Rate");
        }
    }

    public List<DiscountRateResponseDTO> getAll() {
        try {
            log.info("Fetching all Discount Rates");
            List<DiscountRateEntity> result = discountRateRepository.findAll();
            return MapperUtil.mapList(result, DiscountRateResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Rates", dae);
            throw new CustomServiceException("Unable to fetch Discount Rates", dae);
        } catch (MappingException me) {
            log.error("Mapping error while fetching Discount Rates", me);
            throw new CustomServiceException("Error converting Discount Rate data", me);
        }
    }


    public List<DiscountRateFullResponseDTO> getDiscountRatesByCampusAndAcademicYear(Long campusId, Long academicYearId) {
        try {
            log.info("Fetching Discount Rates for campusId: {} and academicYearId: {}", campusId, academicYearId);

            // Fetch from repository
            List<DiscountRateEntity> discountRates = discountRateRepository.findDiscountRatesByCampusAndAcademicYear(campusId, academicYearId);

            // Map entities to response DTOs
            return MapperUtil.mapList(discountRates, DiscountRateFullResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Rates for campusId: {} and academicYearId: {}", campusId, academicYearId, dae);
            throw new CustomServiceException("Failed to fetch Discount Rates due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while fetching Discount Rates for campusId: {} and academicYearId: {}", campusId, academicYearId, e);
            throw new CustomServiceException("Failed to fetch Discount Rates");
        }
    }

    public List<DiscountRateResponseDTO> getAllByCampus(Long campusId) {
        try {
            log.info("Fetching all Discount Rates for campusId: {}", campusId);
            List<DiscountRateEntity> result = discountRateRepository.findAllByCampus(campusId);
            return MapperUtil.mapList(result, DiscountRateResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching Discount Rates by campusId: {}", campusId, e);
            throw new CustomServiceException("Failed to fetch Discount Rates by campus", e);
        }
    }

    public List<DiscountRateResponseDTO> getAllByAcademicYear(Long academicYearId) {
        try {
            log.info("Fetching all Discount Rates for academicYearId: {}", academicYearId);
            List<DiscountRateEntity> result = discountRateRepository.findAllByAcademicYear(academicYearId);
            return MapperUtil.mapList(result, DiscountRateResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching Discount Rates by academicYearId: {}", academicYearId, e);
            throw new CustomServiceException("Failed to fetch Discount Rates by academic year", e);
        }
    }

    public DiscountRateResponseDTO getById(Long id) {
        log.info("Fetching Discount Rate with id: {}", id);
        DiscountRateEntity entity = discountRateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount Rate not found with id: " + id));
        return MapperUtil.mapObject(entity, DiscountRateResponseDTO.class);
    }

    public int softDeleteById(Long id) {
        log.info("Soft deleting Discount Rate id: {}", id);
        try {
            DiscountRateEntity entity = discountRateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Discount Rate not found with id: " + id));
            entity.setDeleted(true);
            discountRateRepository.save(entity);
            return 1;
        } catch (Exception e) {
            log.error("Error soft deleting Discount Rate with id: {}", id, e);
            throw new CustomServiceException("Failed to soft delete Discount Rate", e);
        }
    }

    public int softDeleteAll() {
        log.info("Soft deleting all Discount Rates");
        try {
            List<DiscountRateEntity> allRates = discountRateRepository.findAll();
            allRates.forEach(rate -> rate.setDeleted(true));
            discountRateRepository.saveAll(allRates);
            return allRates.size();
        } catch (Exception e) {
            log.error("Error soft deleting all Discount Rates", e);
            throw new CustomServiceException("Failed to soft delete all Discount Rates", e);
        }
    }

    public int markAsActive(Long id) {
        log.info("Marking Discount Rate as active with id: {}", id);
        try {
            DiscountRateEntity entity = discountRateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Discount Rate not found with id: " + id));
            entity.setIsActive(true);
            discountRateRepository.save(entity);
            return 1;
        } catch (Exception e) {
            log.error("Error marking Discount Rate as active with id: {}", id, e);
            throw new CustomServiceException("Failed to mark Discount Rate as active", e);
        }
    }

    public int markAsInactive(Long id) {
        log.info("Marking Discount Rate as inactive with id: {}", id);
        try {
            DiscountRateEntity entity = discountRateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Discount Rate not found with id: " + id));
            entity.setIsActive(false);
            discountRateRepository.save(entity);
            return 1;
        } catch (Exception e) {
            log.error("Error marking Discount Rate as inactive with id: {}", id, e);
            throw new CustomServiceException("Failed to mark Discount Rate as inactive", e);
        }
    }

}
