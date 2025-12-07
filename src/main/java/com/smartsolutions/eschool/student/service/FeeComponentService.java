package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
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

    public FeeComponentService(FeeComponentRepository feeComponentRepository) {

        this.feeComponentRepository = feeComponentRepository;
    }


    public FeeComponentDTO getById(Long id) {
        log.info("Fetching FeeComponent with id: {}", id);
        FeeComponentEntity FeeComponentEntity = feeComponentRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching FeeComponent with id: {}", id);
            return new ResourceNotFoundException("FeeComponent not found with id: " + id);
        });

        FeeComponentDTO FeeComponentDTO = MapperUtil.mapObject(FeeComponentEntity, FeeComponentDTO.class);
        log.info("Successfully fetched FeeComponent: id={}", FeeComponentDTO.getId());
        return FeeComponentDTO;
    }

    public List<FeeComponentDTO> getAll() {
        try {
            log.info("Fetching all FeeComponent from database");
            List<FeeComponentEntity> result = feeComponentRepository.findByDeletedFalse();
            log.info("Successfully fetched {} FeeComponent", result.size());
            List<FeeComponentDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeComponentDTO.class);
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


}
