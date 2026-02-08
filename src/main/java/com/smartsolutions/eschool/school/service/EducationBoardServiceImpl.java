package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.model.EducationBoardEntity;
import com.smartsolutions.eschool.school.repository.EducationBoardRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EducationBoardServiceImpl implements EducationBoardService {

    private final EducationBoardRepository educationBoardRepository;

    public EducationBoardServiceImpl(EducationBoardRepository educationBoardRepository) {
        this.educationBoardRepository = educationBoardRepository;
    }

    @Override
    public EducationBoardResponseDTO createEducationBoard(EducationBoardCreateRequestDTO requestDTO) {
        log.info("Creating new EducationBoard: {}", requestDTO.getName());
        try {
            EducationBoardEntity entity = MapperUtil.mapObject(requestDTO, EducationBoardEntity.class);
            entity.setId(null);
            if (entity.getIsActive() == null) {
                entity.setIsActive(true);
            }
            EducationBoardEntity saved = educationBoardRepository.save(entity);
            return MapperUtil.mapObject(saved, EducationBoardResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating EducationBoard", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating EducationBoard", ex);
            throw ex;
        }
    }

    @Override
    public List<EducationBoardResponseDTO> getAll() {
        log.info("Fetching all EducationBoards from database");
        try {
            List<EducationBoardEntity> result = educationBoardRepository.findAllJpql();
            List<EducationBoardResponseDTO> response = MapperUtil.mapList(result, EducationBoardResponseDTO.class);
            log.info("Successfully fetched {} EducationBoards", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching EducationBoards", e);
            throw new CustomServiceException("Failed to fetch all EducationBoards");
        }
    }

    @Override
    public List<EducationBoardResponseDTO> getAllActive() {
        log.info("Fetching all active EducationBoards from database");
        try {
            List<EducationBoardEntity> result = educationBoardRepository.findAllActive();
            List<EducationBoardResponseDTO> response = MapperUtil.mapList(result, EducationBoardResponseDTO.class);
            log.info("Successfully fetched {} active EducationBoards", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching active EducationBoards", e);
            throw new CustomServiceException("Failed to fetch active EducationBoards");
        }
    }

    @Override
    public EducationBoardResponseDTO getById(Long id) {
        log.info("Fetching EducationBoard with id {} from database", id);
        try {
            EducationBoardEntity entity = educationBoardRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("EducationBoard not found with id: {}", id);
                        return new ResourceNotFoundException("EducationBoard not found with id: " + id);
                    });
            EducationBoardResponseDTO response = MapperUtil.mapObject(entity, EducationBoardResponseDTO.class);
            log.info("Successfully fetched EducationBoard: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching EducationBoard ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch EducationBoard by ID");
        }
    }

    @Override
    public EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardUpdateRequestDTO requestDTO) {
        log.info("Updating EducationBoard with id {} in database", id);
        try {
            EducationBoardEntity existing = educationBoardRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("EducationBoard not found for update with id: {}", id);
                        return new ResourceNotFoundException("EducationBoard not found with id: " + id);
                    });

            if (requestDTO.getCode() != null) {
                existing.setCode(requestDTO.getCode());
            }
            if (requestDTO.getName() != null && !requestDTO.getName().isBlank()) {
                existing.setName(requestDTO.getName());
            }
            if (requestDTO.getCountryCode() != null) {
                existing.setCountryCode(requestDTO.getCountryCode());
            }
            if (requestDTO.getDescription() != null) {
                existing.setDescription(requestDTO.getDescription());
            }
            if (requestDTO.getIsActive() != null) {
                existing.setIsActive(requestDTO.getIsActive());
            }

            EducationBoardEntity updated = educationBoardRepository.save(existing);
            EducationBoardResponseDTO response = MapperUtil.mapObject(updated, EducationBoardResponseDTO.class);
            log.info("EducationBoard updated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while updating EducationBoard id: {}", id, ex);
            throw new CustomServiceException("Failed to update EducationBoard");
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting EducationBoard with id {} from database", id);
        try {
            if (educationBoardRepository.findByIdJpql(id).isEmpty()) {
                log.warn("EducationBoard not found for deletion with id: {}", id);
                throw new ResourceNotFoundException("EducationBoard not found with id: " + id);
            }
            educationBoardRepository.deleteById(id);
            log.info("EducationBoard deleted successfully with id: {}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting EducationBoard ID: {}", id, e);
            throw new CustomServiceException("Failed to delete EducationBoard");
        }
    }

    @Override
    public List<EducationBoardResponseDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching EducationBoards with keyword: '{}' in database", searchKey);
        try {
            List<EducationBoardEntity> result = educationBoardRepository.searchByKeyword(searchKey);
            List<EducationBoardResponseDTO> response = MapperUtil.mapList(result, EducationBoardResponseDTO.class);
            log.info("Successfully fetched {} EducationBoards based on search", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching EducationBoards", e);
            throw new CustomServiceException("Failed to search EducationBoards");
        }
    }

    @Override
    public EducationBoardResponseDTO activate(Long id) {
        log.info("Activating EducationBoard with id {} in database", id);
        try {
            EducationBoardEntity entity = educationBoardRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("EducationBoard not found for activation with id: {}", id);
                        return new ResourceNotFoundException("EducationBoard not found with id: " + id);
                    });
            entity.setIsActive(true);
            EducationBoardEntity saved = educationBoardRepository.save(entity);
            EducationBoardResponseDTO response = MapperUtil.mapObject(saved, EducationBoardResponseDTO.class);
            log.info("EducationBoard activated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while activating EducationBoard ID: {}", id, e);
            throw new CustomServiceException("Failed to activate EducationBoard");
        }
    }

    @Override
    public EducationBoardResponseDTO deactivate(Long id) {
        log.info("Deactivating EducationBoard with id {} in database", id);
        try {
            EducationBoardEntity entity = educationBoardRepository.findByIdJpql(id)
                    .orElseThrow(() -> {
                        log.warn("EducationBoard not found for deactivation with id: {}", id);
                        return new ResourceNotFoundException("EducationBoard not found with id: " + id);
                    });
            entity.setIsActive(false);
            EducationBoardEntity saved = educationBoardRepository.save(entity);
            EducationBoardResponseDTO response = MapperUtil.mapObject(saved, EducationBoardResponseDTO.class);
            log.info("EducationBoard deactivated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deactivating EducationBoard ID: {}", id, e);
            throw new CustomServiceException("Failed to deactivate EducationBoard");
        }
    }
}
