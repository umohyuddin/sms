package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class DiscountTypeService {
    private DiscountTypeRepository discountTypeRepository;

    public DiscountTypeRequestDTO createDiscountType(@Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Creating new Discount Type: {}", requestDTO.getName());

        try {
            DiscountTypeEntity entity = MapperUtil.mapObject(requestDTO, DiscountTypeEntity.class);

            discountTypeRepository.save(entity);

            log.info("Discount Type  saved with id: {}", entity.getId());

            // Map back to DTO
            return MapperUtil.mapObject(entity, DiscountTypeRequestDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Type", dae);
            throw new RuntimeException("Failed to create Discount Type due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Type", e);
            throw new RuntimeException("Failed to create Discount Type");
        }
    }

    public List<DiscountTypeResponseDTO> getAll() {
        try {
            log.info("Fetching all Academic year from database");
            List<DiscountTypeEntity> result = discountTypeRepository.findAll();
            log.info("Successfully fetched {} Academic year", result.size());
            List<DiscountTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountTypeResponseDTO.class);
            log.info("Successfully fetched Academic year");
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Academic year", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Academic year", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Academic year", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }
}

