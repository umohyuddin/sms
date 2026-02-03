package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.model.SchoolTypeEntity;
import com.smartsolutions.eschool.school.repository.SchoolTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SchoolTypeServiceImpl implements SchoolTypeService {

    private final SchoolTypeRepository schoolTypeRepository;

    public SchoolTypeServiceImpl(SchoolTypeRepository schoolTypeRepository) {
        this.schoolTypeRepository = schoolTypeRepository;
    }

    @Override
    public SchoolTypeResponseDTO createSchoolType(SchoolTypeCreateRequestDTO requestDTO) {
        log.info("Creating new SchoolType: {}", requestDTO.getCode());
        try {
            SchoolTypeEntity entity = MapperUtil.mapObject(requestDTO, SchoolTypeEntity.class);
            entity.setId(null);
            if (entity.getIsActive() == null) {
                entity.setIsActive(true);
            }
            SchoolTypeEntity saved = schoolTypeRepository.save(entity);
            SchoolTypeResponseDTO response = MapperUtil.mapObject(saved, SchoolTypeResponseDTO.class);
            log.info("SchoolType created successfully with ID: {}", response.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating SchoolType", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating SchoolType", ex);
            throw ex;
        }
    }

    @Override
    public List<SchoolTypeResponseDTO> getAll() {
        try {
            log.info("Fetching all SchoolTypes from database");
            List<SchoolTypeEntity> result = schoolTypeRepository.findAllJpql();
            return MapperUtil.mapList(result, SchoolTypeResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching SchoolTypes", dae);
        } catch (MappingException me) {
            log.error("Error mapping SchoolTypeEntity to SchoolTypeResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching SchoolTypes", e);
        }
        return Collections.emptyList();
    }

    @Override
    public List<SchoolTypeResponseDTO> getAllActive() {
        log.info("Fetching active SchoolTypes");
        List<SchoolTypeEntity> result = schoolTypeRepository.findAllActive();
        return MapperUtil.mapList(result, SchoolTypeResponseDTO.class);
    }

    @Override
    public SchoolTypeResponseDTO getById(Long id) {
        log.info("Fetching SchoolType with id: {}", id);
        SchoolTypeEntity entity = schoolTypeRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolType not found with id: " + id));
        SchoolTypeResponseDTO responseDTO = MapperUtil.mapObject(entity, SchoolTypeResponseDTO.class);
        log.info("Successfully fetched SchoolType: id={}", responseDTO.getId());
        return responseDTO;
    }

    @Override
    public SchoolTypeResponseDTO updateSchoolType(Long id, SchoolTypeUpdateRequestDTO requestDTO) {
        log.info("Updating SchoolType with id {} using DTO {}", id, requestDTO);
        SchoolTypeEntity existing = schoolTypeRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolType not found with id: " + id));

        if (requestDTO.getCode() != null && !requestDTO.getCode().isBlank()) {
            existing.setCode(requestDTO.getCode());
        }
        if (requestDTO.getName() != null && !requestDTO.getName().isBlank()) {
            existing.setName(requestDTO.getName());
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getIsActive() != null) {
            existing.setIsActive(requestDTO.getIsActive());
        }

        SchoolTypeEntity updated = schoolTypeRepository.save(existing);
        SchoolTypeResponseDTO response = MapperUtil.mapObject(updated, SchoolTypeResponseDTO.class);
        log.info("SchoolType updated successfully: {}", response.getId());
        return response;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete request received for SchoolType ID: {}", id);
        if (schoolTypeRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("SchoolType not found with id: " + id);
        }
        schoolTypeRepository.deleteById(id);
    }

    @Override
    public List<SchoolTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching SchoolTypes with keyword: {}", keyword);
        List<SchoolTypeEntity> result = schoolTypeRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, SchoolTypeResponseDTO.class);
    }

    @Override
    public SchoolTypeResponseDTO activate(Long id) {
        SchoolTypeEntity entity = schoolTypeRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolType not found with id: " + id));
        entity.setIsActive(true);
        return MapperUtil.mapObject(schoolTypeRepository.save(entity), SchoolTypeResponseDTO.class);
    }

    @Override
    public SchoolTypeResponseDTO deactivate(Long id) {
        SchoolTypeEntity entity = schoolTypeRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolType not found with id: " + id));
        entity.setIsActive(false);
        return MapperUtil.mapObject(schoolTypeRepository.save(entity), SchoolTypeResponseDTO.class);
    }
}
