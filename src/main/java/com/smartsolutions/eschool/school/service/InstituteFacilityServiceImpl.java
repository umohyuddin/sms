package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteFacilityErrors;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteFacilityEntity;
import com.smartsolutions.eschool.school.mapper.InstituteFacilityMapper;
import com.smartsolutions.eschool.school.repository.InstituteFacilityRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import com.smartsolutions.eschool.lookups.repository.FacilityTypeRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("instituteFacilityService")
@Slf4j
public class InstituteFacilityServiceImpl implements InstituteFacilityService {

    private final InstituteFacilityRepository instituteFacilityRepository;
    private final InstituteRepository instituteRepository;
    private final FacilityTypeRepository facilityTypeRepository;

    public InstituteFacilityServiceImpl(InstituteFacilityRepository instituteFacilityRepository, InstituteRepository instituteRepository, FacilityTypeRepository facilityTypeRepository) {
        this.instituteFacilityRepository = instituteFacilityRepository;
        this.instituteRepository = instituteRepository;
        this.facilityTypeRepository = facilityTypeRepository;
    }

    @Override
    @Transactional
    public List<InstituteFacilityResponseDTO> createFacility(InstituteFacilityCreateRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFacilityErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteFacilityServiceImpl] createFacility() called - Replacing facilities for institute: {}", contextInstituteId);

        InstituteEntity institute = instituteRepository.findById(contextInstituteId).orElseThrow(() -> new ApiException(InstituteFacilityErrors.INSTITUTE_NOT_FOUND, HttpStatus.NOT_FOUND));

        /*
         * ===============================
         * 1. Delete existing facilities
         * ===============================
         */
        instituteFacilityRepository.deleteByInstituteId(institute.getId());

        /*
         * ===============================
         * 2. Create new facilities
         * ===============================
         */
        List<InstituteFacilityEntity> entities = new ArrayList<>();

        if (requestDTO.getSelections() != null) {
            for (InstituteFacilityCreateRequestDTO.FacilitySelectionDTO selection : requestDTO.getSelections()) {
                FacilityTypeEntity facilityType = facilityTypeRepository.findById(selection.getFacilityTypeId()).orElseThrow(() -> new ApiException(InstituteFacilityErrors.FACILITY_TYPE_NOT_FOUND, "FacilityType not found with id: " + selection.getFacilityTypeId(), HttpStatus.NOT_FOUND));

                InstituteFacilityEntity entity = new InstituteFacilityEntity();
                entity.setInstitute(institute);
                entity.setFacilityType(facilityType);
                entity.setDescription(selection.getDescription());
                entity.setCapacity(selection.getCapacity());

                entities.add(entity);
            }
        }

        List<InstituteFacilityEntity> savedEntities = instituteFacilityRepository.saveAll(entities);
        log.info("[Service:InstituteFacilityServiceImpl] createFacility() succeeded - Created {} facilities", savedEntities.size());
        return InstituteFacilityMapper.toResponseDTOList(savedEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstituteFacilityResponseDTO> getAll() {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFacilityErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteFacilityServiceImpl] getAll() called - Fetching all for institute: {}", contextInstituteId);
        List<InstituteFacilityEntity> result = instituteFacilityRepository.findAllByInstituteIdJpql(contextInstituteId);
        List<InstituteFacilityResponseDTO> responseDTOs = InstituteFacilityMapper.toResponseDTOList(result);
        log.info("[Service:InstituteFacilityServiceImpl] getAll() succeeded - Found {} facilities", responseDTOs.size());
        return responseDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId) {
        log.info("[Service:InstituteFacilityServiceImpl] getByInstituteId() called - Fetching for institute: {}", instituteId);
        List<InstituteFacilityEntity> result = instituteFacilityRepository.findByInstituteId(instituteId);
        return InstituteFacilityMapper.toResponseDTOList(result);
    }

    @Override
    @Transactional(readOnly = true)
    public InstituteFacilityResponseDTO getById(Long id) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:InstituteFacilityServiceImpl] getById() called - id: {}, institute: {}", id, contextInstituteId);

        InstituteFacilityEntity entity = (contextInstituteId != null) ? instituteFacilityRepository.findByIdAndInstituteIdJpql(id, contextInstituteId).orElseThrow(() -> new ApiException(InstituteFacilityErrors.FACILITY_NOT_FOUND, HttpStatus.NOT_FOUND)) : instituteFacilityRepository.findById(id) // Fallback or admin usage
                .orElseThrow(() -> new ApiException(InstituteFacilityErrors.FACILITY_NOT_FOUND, HttpStatus.NOT_FOUND));

        return InstituteFacilityMapper.toResponseDTO(entity);
    }

    @Override
    @Transactional
    public InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFacilityErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteFacilityServiceImpl] updateFacility() called - id: {}, institute: {}", id, contextInstituteId);

        InstituteFacilityEntity existing = instituteFacilityRepository.findByIdAndInstituteIdJpql(id, contextInstituteId).orElseThrow(() -> new ApiException(InstituteFacilityErrors.FACILITY_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getFacilityTypeId() != null) {
            FacilityTypeEntity facilityType = facilityTypeRepository.findById(requestDTO.getFacilityTypeId()).orElseThrow(() -> new ApiException(InstituteFacilityErrors.FACILITY_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
            existing.setFacilityType(facilityType);
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getCapacity() != null) {
            existing.setCapacity(requestDTO.getCapacity());
        }

        InstituteFacilityEntity updated = instituteFacilityRepository.save(existing);
        log.info("[Service:InstituteFacilityServiceImpl] updateFacility() succeeded - id: {}", id);
        return InstituteFacilityMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(InstituteFacilityErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteFacilityServiceImpl] deleteById() called - id: {}, institute: {}", id, contextInstituteId);

        if (instituteFacilityRepository.findByIdAndInstituteIdJpql(id, contextInstituteId).isEmpty()) {
            throw new ApiException(InstituteFacilityErrors.FACILITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        instituteFacilityRepository.deleteById(id);
        log.info("[Service:InstituteFacilityServiceImpl] deleteById() succeeded - id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstituteFacilityResponseDTO> searchByKeyword(String keyword) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:InstituteFacilityServiceImpl] searchByKeyword() called - keyword: {}, institute: {}", keyword, contextInstituteId);
        List<InstituteFacilityEntity> result = (contextInstituteId != null) ? instituteFacilityRepository.searchByKeywordAndInstituteId(keyword == null ? "" : keyword.trim(), contextInstituteId) : instituteFacilityRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return InstituteFacilityMapper.toResponseDTOList(result);
    }
}
