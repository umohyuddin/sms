package com.smartsolutions.eschool.school.service;

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
        try {
            List<EducationBoardEntity> result = educationBoardRepository.findAllJpql();
            return MapperUtil.mapList(result, EducationBoardResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching EducationBoards", dae);
        } catch (MappingException me) {
            log.error("Error mapping EducationBoardEntity to EducationBoardResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching EducationBoards", e);
        }
        return List.of();
    }

    @Override
    public List<EducationBoardResponseDTO> getAllActive() {
        List<EducationBoardEntity> result = educationBoardRepository.findAllActive();
        return MapperUtil.mapList(result, EducationBoardResponseDTO.class);
    }

    @Override
    public EducationBoardResponseDTO getById(Long id) {
        EducationBoardEntity entity = educationBoardRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationBoard not found with id: " + id));
        return MapperUtil.mapObject(entity, EducationBoardResponseDTO.class);
    }

    @Override
    public EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardUpdateRequestDTO requestDTO) {
        EducationBoardEntity existing = educationBoardRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationBoard not found with id: " + id));

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
        return MapperUtil.mapObject(updated, EducationBoardResponseDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (educationBoardRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("EducationBoard not found with id: " + id);
        }
        educationBoardRepository.deleteById(id);
    }

    @Override
    public List<EducationBoardResponseDTO> searchByKeyword(String keyword) {
        List<EducationBoardEntity> result = educationBoardRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, EducationBoardResponseDTO.class);
    }

    @Override
    public EducationBoardResponseDTO activate(Long id) {
        EducationBoardEntity entity = educationBoardRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationBoard not found with id: " + id));
        entity.setIsActive(true);
        return MapperUtil.mapObject(educationBoardRepository.save(entity), EducationBoardResponseDTO.class);
    }

    @Override
    public EducationBoardResponseDTO deactivate(Long id) {
        EducationBoardEntity entity = educationBoardRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationBoard not found with id: " + id));
        entity.setIsActive(false);
        return MapperUtil.mapObject(educationBoardRepository.save(entity), EducationBoardResponseDTO.class);
    }
}
