package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.repository.FeeCatalogRepository;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FeeComponentService {

    private final FeeComponentRepository feeComponentRepository;
    private final FeeCatalogRepository  feeCatalogRepository;

    public FeeComponentService(FeeComponentRepository feeComponentRepository, FeeCatalogRepository feeCatalogRepository) {

        this.feeComponentRepository = feeComponentRepository;
        this.feeCatalogRepository = feeCatalogRepository;
    }


    public FeeComponentResponseDTO getById(Long id) {
        log.info("Fetching FeeComponent with id: {}", id);
        FeeComponentEntity FeeComponentEntity = feeComponentRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching FeeComponent with id: {}", id);
            return new ResourceNotFoundException("FeeComponent not found with id: " + id);
        });

        FeeComponentResponseDTO FeeComponentDTO = MapperUtil.mapObject(FeeComponentEntity, FeeComponentResponseDTO.class);
        log.info("Successfully fetched FeeComponent: id={}", FeeComponentDTO.getId());
        return FeeComponentDTO;
    }

    public List<FeeComponentResponseDTO> getAll() {
        try {
            log.info("Fetching all FeeComponent from database");
            List<FeeComponentEntity> result = feeComponentRepository.findByDeletedFalse();
            log.info("Successfully fetched {} FeeComponent", result.size());
            List<FeeComponentResponseDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeComponentResponseDTO.class);
            log.info("Successfully fetched FeeComponent");
            return FeeComponentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeComponent", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to FeeComponent", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeComponent", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public List<FeeComponentResponseDTO> searchFeeCatalogComponents(Long feeCatalogId, String keyword) {
        log.info("Fetching Standards for campusId={} with keyword='{}'", feeCatalogId, keyword);

        try {
            String search = (keyword != null && !keyword.trim().isEmpty()) ? keyword.trim() : null;
            List<FeeComponentEntity> result = feeComponentRepository.searchFeeComponent(feeCatalogId, search);
            if (result.isEmpty()) {
                log.warn("No Standards found for campusId={} with keyword='{}'", feeCatalogId, keyword);
//                throw new ResourceNotFoundException("No Standards found matching the criteria");
                return Collections.emptyList();
            }
            List<FeeComponentResponseDTO> standardDTOS = MapperUtil.mapList(result, FeeComponentResponseDTO.class);
            log.info("Successfully fetched {} Standards by filter", standardDTOS.size());
            return standardDTOS;

        } catch (Exception e) {
            log.error("Error fetching Standards for campusId={} with keyword='{}'", feeCatalogId, keyword, e);
            throw new CustomServiceException("Failed to fetch Standards", e);
        }
    }


    @Transactional
    public FeeComponentResponseDTO updateFeeComponent(Long id, FeeCatalogComponentRequestDTO dto) {
        log.info("Updating Fee Component with id {} using DTO {}", id, dto);
        // Fetch existing component
        FeeComponentEntity entity = feeComponentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fee Component not found with id: " + id));

        // Update fields if they are provided
        if (dto.getComponentName() != null && !dto.getComponentName().isBlank()) {
            entity.setComponentName(dto.getComponentName());
        }
        if (dto.getComponentCode() != null) {
            entity.setComponentCode(dto.getComponentCode());
        }
//        if (dto.getDescription() != null) {
//            entity.setDescription(dto.getDescription());
//        }

        // Update active status
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }

        if (dto.getDiscountable() != null) {
            entity.setActive(dto.getDiscountable());
        }

        // Update Fee Catalog association if provided
        if (dto.getFeeCatalogId() != null && (entity.getFeeCatalog() == null || !entity.getFeeCatalog().getId().equals(dto.getFeeCatalogId()))) {
            FeeCatalogEntity feeCatalog = feeCatalogRepository.findById(dto.getFeeCatalogId())
                    .orElseThrow(() -> new ResourceNotFoundException("Fee Catalog not found with id: " + dto.getFeeCatalogId()));
            entity.setFeeCatalog(feeCatalog);
        }

        // Save updated entity
        FeeComponentEntity updated = feeComponentRepository.save(entity);

        // Map to response DTO
        FeeComponentResponseDTO response = MapperUtil.mapObject(updated, FeeComponentResponseDTO.class);

        log.info("Fee Component updated successfully: {}", response.getId());
        return response;
    }



    public FeeComponentResponseDTO create(@Valid FeeCatalogComponentRequestDTO requestDTO) {
        log.info("Creating new Fee Component: {}", requestDTO);
        try {
            FeeComponentEntity entity = MapperUtil.mapObject(requestDTO, FeeComponentEntity.class);
            entity.setId(null);
            // Fetch managed FeeCatalogEntity
            FeeCatalogEntity feeCatalog = feeCatalogRepository.findById(requestDTO.getFeeCatalogId())
                    .orElseThrow(() -> new ResourceNotFoundException("FeeCatalog not found with id: " + requestDTO.getFeeCatalogId()));
            entity.setFeeCatalog(feeCatalog);

            FeeComponentEntity saved = feeComponentRepository.save(entity);
            FeeComponentResponseDTO responseDTO = MapperUtil.mapObject(saved, FeeComponentResponseDTO.class);
            log.info("Fee Component created successfully with ID: {}", responseDTO.getId());
            return responseDTO;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Fee Component", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Fee Component", ex);
            throw ex;
        }
    }


    public List<FeeComponentResponseDTO> getByFeeCatalogId(Long feeCatalogId) {
        try {
            log.info("Fetching all FeeRates from database");
            List<FeeComponentEntity> result = feeComponentRepository.getByFeeCatalogId(feeCatalogId);
            log.info("Successfully fetched {} FeeRates", result.size());
            List<FeeComponentResponseDTO> feeRateDTOS = MapperUtil.mapList(result, FeeComponentResponseDTO.class);
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

}
