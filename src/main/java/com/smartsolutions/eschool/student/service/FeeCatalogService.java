package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.configs.FeeConfig;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.repository.FeeCatalogRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FeeCatalogService {
    private final FeeCatalogRepository feeCatalogRepository;
    private final FeeConfig feeConfig;

    public FeeCatalogService(FeeCatalogRepository feeCatalogRepository, FeeConfig feeConfig) {
        this.feeCatalogRepository = feeCatalogRepository;
        this.feeConfig = feeConfig;
    }

    public List<FeeCatalogDTO> searchFeeCatalog(String keyword) {
        try {
            log.info("Fetching all FeeCatalog based on keyword from database");
            List<FeeCatalogEntity> result = feeCatalogRepository.searchFeeCatalog(keyword);
            log.info("Successfully fetched {} FeeCatalog based on keyword", result.size());

//            List<FeeCatalogDTO> feeCatalogDTOList = MapperUtil.mapList(result, FeeCatalogDTO.class);
            return result.stream().map(this::toDto).collect(Collectors.toList());
            //log.info("Successfully fetched FeeCatalog based on keyword");
            // return feeCatalogDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeCatalog based on keyword", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to FeeCatalog based on keyword", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeCatalog based on keyword", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }


    public FeeCatalogDTO getById(Long id) {
        log.info("Fetching FeeCatalog with id: {}", id);
        FeeCatalogEntity feeCatalogEntity = feeCatalogRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching FeeCatalog with id: {}", id);
            return new ResourceNotFoundException("FeeCatalog not found with id: " + id);
        });


        FeeCatalogDTO feeCatalogDTO = toDto(feeCatalogEntity);
        //FeeCatalogDTO feeCatalogDTO = MapperUtil.mapObject(feeCatalogEntity, FeeCatalogDTO.class);
        log.info("Successfully fetched FeeCatalog: id={}", feeCatalogDTO.getId());
        return feeCatalogDTO;
    }

    public List<FeeCatalogDTO> getAll() {
        try {
            log.info("Fetching all FeeCatalog from database");
            List<FeeCatalogEntity> result = feeCatalogRepository.findByDeletedFalse();
            log.info("Successfully fetched {} FeeCatalog", result.size());
            return result.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching FeeCatalog", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to FeeCatalog", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching FeeCatalog", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    private String getChargeTypeLabel(String chargeType) {
        return feeConfig.getChargeTypes().getOrDefault(chargeType, chargeType);
    }

    private String getRecurrenceRuleLabel(String recurrenceRule) {
        return feeConfig.getRecurrenceRules().getOrDefault(recurrenceRule, recurrenceRule);
    }

    private FeeCatalogDTO toDto(FeeCatalogEntity entity) {
        FeeCatalogDTO dto = new FeeCatalogDTO();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.isActive());

        dto.setChargeType(entity.getChargeType());
        dto.setChargeTypeLabel(getChargeTypeLabel(entity.getChargeType()));

        dto.setRecurrenceRule(entity.getRecurrenceRule());
        dto.setRecurrenceRuleLabel(getRecurrenceRuleLabel(entity.getRecurrenceRule()));

        return dto;
    }
}
