package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.responseDto.InstituteExecutiveResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteExecutiveEntity;
import com.smartsolutions.eschool.school.repository.InstituteExecutiveRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteExecutiveServiceImpl implements InstituteExecutiveService {

    private final InstituteExecutiveRepository instituteExecutiveRepository;
    private final InstituteRepository instituteRepository;

    public InstituteExecutiveServiceImpl(InstituteExecutiveRepository instituteExecutiveRepository, InstituteRepository instituteRepository) {
        this.instituteExecutiveRepository = instituteExecutiveRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteExecutiveResponseDTO createExecutive(InstituteExecutiveCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteExecutiveEntity entity = MapperUtil.mapObject(requestDTO, InstituteExecutiveEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteExecutiveEntity saved = instituteExecutiveRepository.save(entity);
            InstituteExecutiveResponseDTO dto = MapperUtil.mapObject(saved, InstituteExecutiveResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteExecutive", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteExecutive", ex);
            throw ex;
        }
    }

    @Override
    public List<InstituteExecutiveResponseDTO> getAll() {
        try {
            List<InstituteExecutiveEntity> result = instituteExecutiveRepository.findAllJpql();
            return result.stream().map(entity -> {
                InstituteExecutiveResponseDTO dto = MapperUtil.mapObject(entity, InstituteExecutiveResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteExecutives", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteExecutiveEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteExecutives", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteExecutiveResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteExecutiveEntity> result = instituteExecutiveRepository.findByInstituteId(instituteId);
        return result.stream().map(entity -> {
            InstituteExecutiveResponseDTO dto = MapperUtil.mapObject(entity, InstituteExecutiveResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteExecutiveResponseDTO getById(Long id) {
        InstituteExecutiveEntity entity = instituteExecutiveRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteExecutive not found with id: " + id));
        InstituteExecutiveResponseDTO dto = MapperUtil.mapObject(entity, InstituteExecutiveResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteExecutiveResponseDTO updateExecutive(Long id, InstituteExecutiveUpdateRequestDTO requestDTO) {
        InstituteExecutiveEntity existing = instituteExecutiveRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteExecutive not found with id: " + id));

        if (requestDTO.getFullName() != null) {
            existing.setFullName(requestDTO.getFullName());
        }
        if (requestDTO.getTitle() != null) {
            existing.setTitle(requestDTO.getTitle());
        }
        if (requestDTO.getEmail() != null) {
            existing.setEmail(requestDTO.getEmail());
        }

        InstituteExecutiveEntity updated = instituteExecutiveRepository.save(existing);
        InstituteExecutiveResponseDTO dto = MapperUtil.mapObject(updated, InstituteExecutiveResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteExecutiveRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteExecutive not found with id: " + id);
        }
        instituteExecutiveRepository.deleteById(id);
    }

    @Override
    public List<InstituteExecutiveResponseDTO> searchByKeyword(String keyword) {
        List<InstituteExecutiveEntity> result = instituteExecutiveRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteExecutiveResponseDTO dto = MapperUtil.mapObject(entity, InstituteExecutiveResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
