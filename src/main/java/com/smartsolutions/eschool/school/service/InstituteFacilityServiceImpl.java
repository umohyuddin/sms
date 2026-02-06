package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteFacilityEntity;
import com.smartsolutions.eschool.school.repository.InstituteFacilityRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import com.smartsolutions.eschool.lookups.repository.FacilityTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("instituteFacilityService")
@Slf4j
public class InstituteFacilityServiceImpl implements InstituteFacilityService {

    private final InstituteFacilityRepository instituteFacilityRepository;
    private final InstituteRepository instituteRepository;
    private final FacilityTypeRepository facilityTypeRepository;

    public InstituteFacilityServiceImpl(InstituteFacilityRepository instituteFacilityRepository, 
                                        InstituteRepository instituteRepository, 
                                        FacilityTypeRepository facilityTypeRepository) {
        this.instituteFacilityRepository = instituteFacilityRepository;
        this.instituteRepository = instituteRepository;
        this.facilityTypeRepository = facilityTypeRepository;
    }

    @Override
    @Transactional
    public List<InstituteFacilityResponseDTO> createFacility(
            InstituteFacilityCreateRequestDTO requestDTO) {

        log.info("Replacing facilities for institute {}", requestDTO.getInstituteId());

        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Institute not found with id: " + requestDTO.getInstituteId()));

        /* ===============================
           1. Delete existing facilities
           =============================== */
            instituteFacilityRepository.deleteByInstituteId(institute.getId());

        /* ===============================
           2. Create new facilities
           =============================== */
            List<InstituteFacilityEntity> entities = new ArrayList<>();

            for (InstituteFacilityCreateRequestDTO.FacilitySelectionDTO selection
                    : requestDTO.getSelections()) {

                FacilityTypeEntity facilityType = facilityTypeRepository
                        .findById(selection.getFacilityTypeId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "FacilityType not found with id: " + selection.getFacilityTypeId()));

                InstituteFacilityEntity entity = new InstituteFacilityEntity();
                entity.setInstitute(institute);
                entity.setFacilityType(facilityType);
                entity.setDescription(selection.getDescription());
                entity.setCapacity(selection.getCapacity());

                entities.add(entity);
            }

            List<InstituteFacilityEntity> savedEntities =
                    instituteFacilityRepository.saveAll(entities);

            return savedEntities.stream()
                    .map(this::toResponseDTO)
                    .collect(Collectors.toList());

        } catch (DataAccessException dae) {
            log.error("Database error while replacing InstituteFacilities", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error replacing InstituteFacilities", ex);
            throw ex;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstituteFacilityResponseDTO> getAll() {
        try {
            List<InstituteFacilityEntity> result = instituteFacilityRepository.findAllJpql();
            return result.stream().map(this::toResponseDTO).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteFacilities", e);
            return List.of();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteFacilityEntity> result = instituteFacilityRepository.findByInstituteId(instituteId);
        return result.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public InstituteFacilityResponseDTO getById(Long id) {
        InstituteFacilityEntity entity = instituteFacilityRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteFacility not found with id: " + id));
        return toResponseDTO(entity);
    }

    @Override
    @Transactional
    public InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO) {
        InstituteFacilityEntity existing = instituteFacilityRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteFacility not found with id: " + id));

        if (requestDTO.getFacilityTypeId() != null) {
            FacilityTypeEntity facilityType = facilityTypeRepository.findById(requestDTO.getFacilityTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("FacilityType not found with id: " + requestDTO.getFacilityTypeId()));
            existing.setFacilityType(facilityType);
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getCapacity() != null) {
            existing.setCapacity(requestDTO.getCapacity());
        }

        InstituteFacilityEntity updated = instituteFacilityRepository.save(existing);
        return toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (instituteFacilityRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteFacility not found with id: " + id);
        }
        instituteFacilityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstituteFacilityResponseDTO> searchByKeyword(String keyword) {
        List<InstituteFacilityEntity> result = instituteFacilityRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    private InstituteFacilityResponseDTO toResponseDTO(InstituteFacilityEntity entity) {
        InstituteFacilityResponseDTO dto = new InstituteFacilityResponseDTO();
        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstitute().getId());
        if (entity.getFacilityType() != null) {
            dto.setFacilityTypeId(entity.getFacilityType().getId());
            dto.setFacilityTypeCode(entity.getFacilityType().getCode());
            dto.setFacilityTypeName(entity.getFacilityType().getName());
        }
        dto.setDescription(entity.getDescription());
        dto.setCapacity(entity.getCapacity());
        return dto;
    }
}
