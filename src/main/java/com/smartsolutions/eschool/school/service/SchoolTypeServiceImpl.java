package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
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
        log.info("Fetching all SchoolTypes from database");
        try {
            List<SchoolTypeEntity> result = schoolTypeRepository.findAllJpql();
            List<SchoolTypeResponseDTO> response = MapperUtil.mapList(result, SchoolTypeResponseDTO.class);
            log.info("Successfully fetched {} SchoolTypes", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SchoolTypes", e);
            throw new CustomServiceException("Failed to fetch all SchoolTypes");
        }
    }

    @Override
    public List<SchoolTypeResponseDTO> getAllActive() {
        log.info("Fetching all active SchoolTypes from database");
        try {
            List<SchoolTypeEntity> result = schoolTypeRepository.findAllActive();
            List<SchoolTypeResponseDTO> response = MapperUtil.mapList(result, SchoolTypeResponseDTO.class);
            log.info("Successfully fetched {} active SchoolTypes", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching active SchoolTypes", e);
            throw new CustomServiceException("Failed to fetch active SchoolTypes");
        }
    }

    @Override
    public SchoolTypeResponseDTO getById(Long id) {
        log.info("Fetching SchoolType with id {} from database", id);
        try {
            SchoolTypeEntity entity = schoolTypeRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("SchoolType not found with id: {}", id);
                        return new ResourceNotFoundException("SchoolType not found with id: " + id);
                    });
            SchoolTypeResponseDTO response = MapperUtil.mapObject(entity, SchoolTypeResponseDTO.class);
            log.info("Successfully fetched SchoolType: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SchoolType ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch SchoolType by ID");
        }
    }

    @Override
    public SchoolTypeResponseDTO updateSchoolType(Long id, SchoolTypeUpdateRequestDTO requestDTO) {
        log.info("Updating SchoolType with id {} in database", id);
        try {
            SchoolTypeEntity existing = schoolTypeRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("SchoolType not found for update with id: {}", id);
                        return new ResourceNotFoundException("SchoolType not found with id: " + id);
                    });

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
            log.info("SchoolType updated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while updating SchoolType id: {}", id, ex);
            throw new CustomServiceException("Failed to update SchoolType");
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting SchoolType with id {} from database", id);
        try {
            if (schoolTypeRepository.findByIdJpql(id).isEmpty()) {
                log.warn("SchoolType not found for deletion with id: {}", id);
                throw new ResourceNotFoundException("SchoolType not found with id: " + id);
            }
            schoolTypeRepository.deleteById(id);
            log.info("SchoolType deleted successfully with id: {}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting SchoolType ID: {}", id, e);
            throw new CustomServiceException("Failed to delete SchoolType");
        }
    }

    @Override
    public List<SchoolTypeResponseDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching SchoolTypes with keyword: '{}' in database", searchKey);
        try {
            List<SchoolTypeEntity> result = schoolTypeRepository.searchByKeyword(searchKey);
            List<SchoolTypeResponseDTO> response = MapperUtil.mapList(result, SchoolTypeResponseDTO.class);
            log.info("Successfully fetched {} SchoolTypes based on search", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching SchoolTypes", e);
            throw new CustomServiceException("Failed to search SchoolTypes");
        }
    }

    @Override
    public SchoolTypeResponseDTO activate(Long id) {
        log.info("Activating SchoolType with id {} in database", id);
        try {
            SchoolTypeEntity entity = schoolTypeRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("SchoolType not found for activation with id: {}", id);
                        return new ResourceNotFoundException("SchoolType not found with id: " + id);
                    });
            entity.setIsActive(true);
            SchoolTypeEntity saved = schoolTypeRepository.save(entity);
            SchoolTypeResponseDTO response = MapperUtil.mapObject(saved, SchoolTypeResponseDTO.class);
            log.info("SchoolType activated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while activating SchoolType ID: {}", id, e);
            throw new CustomServiceException("Failed to activate SchoolType");
        }
    }

    @Override
    public SchoolTypeResponseDTO deactivate(Long id) {
        log.info("Deactivating SchoolType with id {} in database", id);
        try {
            SchoolTypeEntity entity = schoolTypeRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("SchoolType not found for deactivation with id: {}", id);
                        return new ResourceNotFoundException("SchoolType not found with id: " + id);
                    });
            entity.setIsActive(false);
            SchoolTypeEntity saved = schoolTypeRepository.save(entity);
            SchoolTypeResponseDTO response = MapperUtil.mapObject(saved, SchoolTypeResponseDTO.class);
            log.info("SchoolType deactivated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deactivating SchoolType ID: {}", id, e);
            throw new CustomServiceException("Failed to deactivate SchoolType");
        }
    }
}
