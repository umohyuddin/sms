package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteFacilityEntity;
import com.smartsolutions.eschool.school.repository.InstituteFacilityRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteFacilityServiceImpl implements InstituteFacilityService {

    private final InstituteFacilityRepository instituteFacilityRepository;
    private final InstituteRepository instituteRepository;

    public InstituteFacilityServiceImpl(InstituteFacilityRepository instituteFacilityRepository, InstituteRepository instituteRepository) {
        this.instituteFacilityRepository = instituteFacilityRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteFacilityResponseDTO createFacility(InstituteFacilityCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteFacilityEntity entity = MapperUtil.mapObject(requestDTO, InstituteFacilityEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteFacilityEntity saved = instituteFacilityRepository.save(entity);
            InstituteFacilityResponseDTO dto = MapperUtil.mapObject(saved, InstituteFacilityResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteFacility", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteFacility", ex);
            throw ex;
        }
    }

    @Override
    public List<InstituteFacilityResponseDTO> getAll() {
        try {
            List<InstituteFacilityEntity> result = instituteFacilityRepository.findAllJpql();
            return result.stream().map(entity -> {
                InstituteFacilityResponseDTO dto = MapperUtil.mapObject(entity, InstituteFacilityResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteFacilities", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteFacilityEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteFacilities", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteFacilityEntity> result = instituteFacilityRepository.findByInstituteId(instituteId);
        return result.stream().map(entity -> {
            InstituteFacilityResponseDTO dto = MapperUtil.mapObject(entity, InstituteFacilityResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteFacilityResponseDTO getById(Long id) {
        InstituteFacilityEntity entity = instituteFacilityRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteFacility not found with id: " + id));
        InstituteFacilityResponseDTO dto = MapperUtil.mapObject(entity, InstituteFacilityResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO) {
        InstituteFacilityEntity existing = instituteFacilityRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteFacility not found with id: " + id));

        if (requestDTO.getFacilityType() != null) {
            existing.setFacilityType(requestDTO.getFacilityType());
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getCapacity() != null) {
            existing.setCapacity(requestDTO.getCapacity());
        }

        InstituteFacilityEntity updated = instituteFacilityRepository.save(existing);
        InstituteFacilityResponseDTO dto = MapperUtil.mapObject(updated, InstituteFacilityResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteFacilityRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteFacility not found with id: " + id);
        }
        instituteFacilityRepository.deleteById(id);
    }

    @Override
    public List<InstituteFacilityResponseDTO> searchByKeyword(String keyword) {
        List<InstituteFacilityEntity> result = instituteFacilityRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteFacilityResponseDTO dto = MapperUtil.mapObject(entity, InstituteFacilityResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
