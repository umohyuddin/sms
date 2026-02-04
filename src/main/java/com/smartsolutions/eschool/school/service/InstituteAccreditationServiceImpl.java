package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteAccreditationEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteAccreditationRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteAccreditationServiceImpl implements InstituteAccreditationService {

    private final InstituteAccreditationRepository instituteAccreditationRepository;
    private final InstituteRepository instituteRepository;

    public InstituteAccreditationServiceImpl(InstituteAccreditationRepository instituteAccreditationRepository, InstituteRepository instituteRepository) {
        this.instituteAccreditationRepository = instituteAccreditationRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteAccreditationResponseDTO createAccreditation(InstituteAccreditationCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteAccreditationEntity entity = MapperUtil.mapObject(requestDTO, InstituteAccreditationEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            if (entity.getIsActive() == null) {
                entity.setIsActive(true);
            }
            InstituteAccreditationEntity saved = instituteAccreditationRepository.save(entity);
            InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(saved, InstituteAccreditationResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteAccreditation", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteAccreditation", ex);
            throw ex;
        }
    }

    @Override
    public List<InstituteAccreditationResponseDTO> getAll() {
        try {
            List<InstituteAccreditationEntity> result = instituteAccreditationRepository.findAllActiveJpql();
            return result.stream().map(entity -> {
                InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(entity, InstituteAccreditationResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteAccreditations", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteAccreditationEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteAccreditations", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteAccreditationResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteAccreditationEntity> result = instituteAccreditationRepository.findByInstituteIdAndDeletedFalse(instituteId);
        return result.stream().map(entity -> {
            InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(entity, InstituteAccreditationResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public List<InstituteAccreditationResponseDTO> getAllActive() {
        List<InstituteAccreditationEntity> result = instituteAccreditationRepository.findAllActiveAndNotDeleted();
        return result.stream().map(entity -> {
            InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(entity, InstituteAccreditationResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteAccreditationResponseDTO getById(Long id) {
        InstituteAccreditationEntity entity = instituteAccreditationRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteAccreditation not found with id: " + id));
        InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(entity, InstituteAccreditationResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteAccreditationResponseDTO updateAccreditation(Long id, InstituteAccreditationUpdateRequestDTO requestDTO) {
        InstituteAccreditationEntity existing = instituteAccreditationRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteAccreditation not found with id: " + id));

        if (requestDTO.getAuthorityName() != null) {
            existing.setAuthorityName(requestDTO.getAuthorityName());
        }
        if (requestDTO.getLicenseNumber() != null) {
            existing.setLicenseNumber(requestDTO.getLicenseNumber());
        }
        if (requestDTO.getValidFrom() != null) {
            existing.setValidFrom(requestDTO.getValidFrom());
        }
        if (requestDTO.getValidTo() != null) {
            existing.setValidTo(requestDTO.getValidTo());
        }
        if (requestDTO.getIsActive() != null) {
            existing.setIsActive(requestDTO.getIsActive());
        }

        InstituteAccreditationEntity updated = instituteAccreditationRepository.save(existing);
        InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(updated, InstituteAccreditationResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Soft delete request for Institute Accreditation id={}", id);
        int result = instituteAccreditationRepository.softDeleteById(id);
        if (result == 0) {
            throw new ResourceNotFoundException("InstituteAccreditation not found with id: " + id);
        }
    }

    @Override
    public List<InstituteAccreditationResponseDTO> searchByKeyword(String keyword) {
        List<InstituteAccreditationEntity> result = instituteAccreditationRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(entity, InstituteAccreditationResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteAccreditationResponseDTO activate(Long id) {
        InstituteAccreditationEntity entity = instituteAccreditationRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteAccreditation not found with id: " + id));
        entity.setIsActive(true);
        InstituteAccreditationEntity saved = instituteAccreditationRepository.save(entity);
        InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(saved, InstituteAccreditationResponseDTO.class);
        dto.setInstituteId(saved.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteAccreditationResponseDTO deactivate(Long id) {
        InstituteAccreditationEntity entity = instituteAccreditationRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteAccreditation not found with id: " + id));
        entity.setIsActive(false);
        InstituteAccreditationEntity saved = instituteAccreditationRepository.save(entity);
        InstituteAccreditationResponseDTO dto = MapperUtil.mapObject(saved, InstituteAccreditationResponseDTO.class);
        dto.setInstituteId(saved.getInstitute().getId());
        return dto;
    }
}
