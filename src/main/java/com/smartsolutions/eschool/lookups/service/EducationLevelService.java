package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.model.EducationLevelEntity;
import com.smartsolutions.eschool.lookups.repository.EducationLevelRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class EducationLevelService {
    private final EducationLevelRepository educationLevelRepository;

    public EducationLevelService(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    @Transactional
    public EducationLevelResponseDTO create(@Valid EducationLevelRequestDTO requestDTO) {
        log.info("Creating new EducationLevel: {}", requestDTO.getName());
        try {
            EducationLevelEntity entity = MapperUtil.mapObject(requestDTO, EducationLevelEntity.class);
            educationLevelRepository.save(entity);
            return MapperUtil.mapObject(entity, EducationLevelResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating EducationLevel", dae);
            throw new CustomServiceException("Failed to create EducationLevel due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating EducationLevel", e);
            throw new CustomServiceException("Failed to create EducationLevel");
        }
    }

    public List<EducationLevelResponseDTO> getAllActive() {
        try {
            log.info("Fetching active EducationLevels");
            List<EducationLevelEntity> result = educationLevelRepository.findAllActive();
            return MapperUtil.mapList(result, EducationLevelResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching active education levels", e);
            throw new CustomServiceException("Failed to fetch active EducationLevels", e);
        }
    }

    public EducationLevelResponseDTO getById(Long id) {
        log.info("Fetching EducationLevel with id={}", id);
        EducationLevelEntity entity = educationLevelRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationLevel not found with id=" + id));
        return MapperUtil.mapObject(entity, EducationLevelResponseDTO.class);
    }

    @Transactional
    public EducationLevelResponseDTO update(Long id, @Valid EducationLevelRequestDTO requestDTO) {
        log.info("Updating EducationLevel id={}", id);
        EducationLevelEntity entity = educationLevelRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationLevel not found with id=" + id));
        
        entity.setName(requestDTO.getName());
        entity.setCode(requestDTO.getCode());
        entity.setIsActive(requestDTO.getIsActive());
        
        educationLevelRepository.save(entity);
        return MapperUtil.mapObject(entity, EducationLevelResponseDTO.class);
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft delete request for EducationLevel id={}", id);
        return educationLevelRepository.softDeleteById(id);
    }
}
