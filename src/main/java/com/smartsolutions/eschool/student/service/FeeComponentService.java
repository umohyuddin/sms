package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
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

    public List<FeeComponentDTO> searchFeeComponent(String keyword) {
        try {
            log.info("Fetching all FeeComponent based on keyword from database");
            List<FeeComponentEntity> result = feeComponentRepository.searchFeeComponent(keyword);
            log.info("Successfully fetched {} FeeComponent based on keyword", result.size());
            List<FeeComponentDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeComponentDTO.class);
            log.info("Successfully fetched FeeComponent based on keyword");
            return FeeComponentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeComponent based on keyword", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to FeeComponent based on keyword", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeComponent based on keyword", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
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

}
