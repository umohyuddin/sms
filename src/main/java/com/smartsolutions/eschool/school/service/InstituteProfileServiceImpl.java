package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.responseDto.InstituteProfileResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteProfileEntity;
import com.smartsolutions.eschool.school.repository.InstituteProfileRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteProfileServiceImpl implements InstituteProfileService {

    private final InstituteProfileRepository instituteProfileRepository;
    private final InstituteRepository instituteRepository;

    public InstituteProfileServiceImpl(InstituteProfileRepository instituteProfileRepository, InstituteRepository instituteRepository) {
        this.instituteProfileRepository = instituteProfileRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteProfileResponseDTO createProfile(InstituteProfileCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteProfileEntity entity = MapperUtil.mapObject(requestDTO, InstituteProfileEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteProfileEntity saved = instituteProfileRepository.save(entity);
            InstituteProfileResponseDTO dto = MapperUtil.mapObject(saved, InstituteProfileResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteProfile", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteProfile", ex);
            throw ex;
        }
    }

    @Override
    public InstituteProfileResponseDTO getById(Long id) {
        InstituteProfileEntity entity = instituteProfileRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteProfile not found with id: " + id));
        InstituteProfileResponseDTO dto = MapperUtil.mapObject(entity, InstituteProfileResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteProfileResponseDTO getByInstituteId(Long instituteId) {
        InstituteProfileEntity entity = instituteProfileRepository.findByInstituteId(instituteId)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteProfile not found for institute id: " + instituteId));
        InstituteProfileResponseDTO dto = MapperUtil.mapObject(entity, InstituteProfileResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteProfileResponseDTO updateProfile(Long id, InstituteProfileUpdateRequestDTO requestDTO) {
        InstituteProfileEntity existing = instituteProfileRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteProfile not found with id: " + id));

        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getMission() != null) {
            existing.setMission(requestDTO.getMission());
        }
        if (requestDTO.getVision() != null) {
            existing.setVision(requestDTO.getVision());
        }
        if (requestDTO.getValues() != null) {
            existing.setValues(requestDTO.getValues());
        }
        if (requestDTO.getAboutChairperson() != null) {
            existing.setAboutChairperson(requestDTO.getAboutChairperson());
        }
        if (requestDTO.getOrganizationEmail() != null) {
            existing.setOrganizationEmail(requestDTO.getOrganizationEmail());
        }

        InstituteProfileEntity updated = instituteProfileRepository.save(existing);
        InstituteProfileResponseDTO dto = MapperUtil.mapObject(updated, InstituteProfileResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteProfileRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteProfile not found with id: " + id);
        }
        instituteProfileRepository.deleteById(id);
    }

    @Override
    public List<InstituteProfileResponseDTO> searchByKeyword(String keyword) {
        List<InstituteProfileEntity> result = instituteProfileRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteProfileResponseDTO dto = MapperUtil.mapObject(entity, InstituteProfileResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
