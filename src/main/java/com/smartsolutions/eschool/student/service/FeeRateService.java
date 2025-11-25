package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.student.repository.FeeRateRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FeeRateService {

    private final FeeRateRepository feeRateRepository;

    public FeeRateService(FeeRateRepository feeRateRepository) {
        this.feeRateRepository = feeRateRepository;
    }


    public List<FeeRateDTO> searchFeeRates(String keyword) {
        try {
            log.info("Fetching all Fee Rates based on keyword from database");
            List<FeeRateEntity> result = feeRateRepository.searchFeeComponent(keyword);
            log.info("Successfully fetched {} FeeRates based on keyword", result.size());
            List<FeeRateDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeRateDTO.class);
            log.info("Successfully fetched FeeRates based on keyword");
            return FeeComponentDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeRates based on keyword", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping FeeRateEntity to FeeRates based on keyword", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeRates based on keyword", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }


    public FeeRateDTO getById(Long id) {
        log.info("Fetching FeeRate with id: {}", id);
        FeeRateEntity feeRateEntity = feeRateRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching FeeRate with id: {}", id);
            return new ResourceNotFoundException("FeeRate not found with id: " + id);
        });

        FeeRateDTO feeRateDTO = MapperUtil.mapObject(feeRateEntity, FeeRateDTO.class);
        log.info("Successfully fetched FeeRate: id={}", feeRateDTO.getId());
        return feeRateDTO;
    }

    public List<FeeRateDTO> getAll() {
        try {
            log.info("Fetching all FeeRates from database");
            List<FeeRateEntity> result = feeRateRepository.findByDeletedFalse();
            log.info("Successfully fetched {} FeeRates", result.size());
            List<FeeRateDTO> feeRateDTOS = MapperUtil.mapList(result, FeeRateDTO.class);
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

    public List<FeeRateDTO> getByFeeComponentId(Long id) {
        try {
            log.info("Fetching all Fee Rates by fee component from database");
            List<FeeRateEntity> result = feeRateRepository.findByFeeComponentId(id);
            log.info("Successfully fetched {} FeeRates by fee component", result.size());
            List<FeeRateDTO> FeeComponentDTOList = MapperUtil.mapList(result, FeeRateDTO.class);
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

}
