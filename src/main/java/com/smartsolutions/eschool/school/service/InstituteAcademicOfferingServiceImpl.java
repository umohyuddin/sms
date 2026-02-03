package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto.InstituteAcademicOfferingResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteAcademicOfferingEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteAcademicOfferingRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteAcademicOfferingServiceImpl implements InstituteAcademicOfferingService {

    private final InstituteAcademicOfferingRepository instituteAcademicOfferingRepository;
    private final InstituteRepository instituteRepository;

    public InstituteAcademicOfferingServiceImpl(InstituteAcademicOfferingRepository instituteAcademicOfferingRepository, InstituteRepository instituteRepository) {
        this.instituteAcademicOfferingRepository = instituteAcademicOfferingRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteAcademicOfferingResponseDTO createOffering(InstituteAcademicOfferingCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteAcademicOfferingEntity entity = MapperUtil.mapObject(requestDTO, InstituteAcademicOfferingEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteAcademicOfferingEntity saved = instituteAcademicOfferingRepository.save(entity);
            InstituteAcademicOfferingResponseDTO dto = MapperUtil.mapObject(saved, InstituteAcademicOfferingResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteAcademicOffering", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteAcademicOffering", ex);
            throw ex;
        }
    }

    @Override
    public List<InstituteAcademicOfferingResponseDTO> getAll() {
        try {
            List<InstituteAcademicOfferingEntity> result = instituteAcademicOfferingRepository.findAllJpql();
            return result.stream().map(entity -> {
                InstituteAcademicOfferingResponseDTO dto = MapperUtil.mapObject(entity, InstituteAcademicOfferingResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteAcademicOfferings", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteAcademicOfferingEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteAcademicOfferings", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteAcademicOfferingResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteAcademicOfferingEntity> result = instituteAcademicOfferingRepository.findByInstituteId(instituteId);
        return result.stream().map(entity -> {
            InstituteAcademicOfferingResponseDTO dto = MapperUtil.mapObject(entity, InstituteAcademicOfferingResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteAcademicOfferingResponseDTO getById(Long id) {
        InstituteAcademicOfferingEntity entity = instituteAcademicOfferingRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteAcademicOffering not found with id: " + id));
        InstituteAcademicOfferingResponseDTO dto = MapperUtil.mapObject(entity, InstituteAcademicOfferingResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteAcademicOfferingResponseDTO updateOffering(Long id, InstituteAcademicOfferingUpdateRequestDTO requestDTO) {
        InstituteAcademicOfferingEntity existing = instituteAcademicOfferingRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteAcademicOffering not found with id: " + id));

        if (requestDTO.getEducationLevel() != null) {
            existing.setEducationLevel(requestDTO.getEducationLevel());
        }
        if (requestDTO.getCurriculum() != null) {
            existing.setCurriculum(requestDTO.getCurriculum());
        }
        if (requestDTO.getBoard() != null) {
            existing.setBoard(requestDTO.getBoard());
        }

        InstituteAcademicOfferingEntity updated = instituteAcademicOfferingRepository.save(existing);
        InstituteAcademicOfferingResponseDTO dto = MapperUtil.mapObject(updated, InstituteAcademicOfferingResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteAcademicOfferingRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteAcademicOffering not found with id: " + id);
        }
        instituteAcademicOfferingRepository.deleteById(id);
    }

    @Override
    public List<InstituteAcademicOfferingResponseDTO> searchByKeyword(String keyword) {
        List<InstituteAcademicOfferingEntity> result = instituteAcademicOfferingRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteAcademicOfferingResponseDTO dto = MapperUtil.mapObject(entity, InstituteAcademicOfferingResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
