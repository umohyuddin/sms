package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.model.CurriculumEntity;
import com.smartsolutions.eschool.lookups.repository.CurriculumRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;

    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    @Transactional
    public CurriculumResponseDTO create(@Valid CurriculumRequestDTO requestDTO) {
        log.info("Creating new Curriculum: {}", requestDTO.getName());
        try {
            CurriculumEntity entity = MapperUtil.mapObject(requestDTO, CurriculumEntity.class);
            curriculumRepository.save(entity);
            return MapperUtil.mapObject(entity, CurriculumResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Curriculum", dae);
            throw new CustomServiceException("Failed to create Curriculum due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Curriculum", e);
            throw new CustomServiceException("Failed to create Curriculum");
        }
    }

    public List<CurriculumResponseDTO> getAllActive() {
        try {
            log.info("Fetching active Curricula");
            List<CurriculumEntity> result = curriculumRepository.findAllActive();
            return MapperUtil.mapList(result, CurriculumResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching active curricula", e);
            throw new CustomServiceException("Failed to fetch active Curricula", e);
        }
    }

    public CurriculumResponseDTO getById(Long id) {
        log.info("Fetching Curriculum with id={}", id);
        CurriculumEntity entity = curriculumRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curriculum not found with id=" + id));
        return MapperUtil.mapObject(entity, CurriculumResponseDTO.class);
    }

    @Transactional
    public CurriculumResponseDTO update(Long id, @Valid CurriculumRequestDTO requestDTO) {
        log.info("Updating Curriculum id={}", id);
        CurriculumEntity entity = curriculumRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curriculum not found with id=" + id));
        
        entity.setName(requestDTO.getName());
        entity.setCode(requestDTO.getCode());
        entity.setIsActive(requestDTO.getIsActive());
        
        curriculumRepository.save(entity);
        return MapperUtil.mapObject(entity, CurriculumResponseDTO.class);
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft delete request for Curriculum id={}", id);
        return curriculumRepository.softDeleteById(id);
    }
}
