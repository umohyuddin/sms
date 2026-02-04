package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteSocialLinkEntity;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.school.repository.InstituteSocialLinkRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteSocialLinkServiceImpl implements InstituteSocialLinkService {

    private final InstituteSocialLinkRepository instituteSocialLinkRepository;
    private final InstituteRepository instituteRepository;

    public InstituteSocialLinkServiceImpl(InstituteSocialLinkRepository instituteSocialLinkRepository, InstituteRepository instituteRepository) {
        this.instituteSocialLinkRepository = instituteSocialLinkRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteSocialLinkEntity entity = MapperUtil.mapObject(requestDTO, InstituteSocialLinkEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteSocialLinkEntity saved = instituteSocialLinkRepository.save(entity);
            InstituteSocialLinkResponseDTO response = MapperUtil.mapObject(saved, InstituteSocialLinkResponseDTO.class);
            response.setInstituteId(institute.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteSocialLink", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteSocialLink", ex);
            throw ex;
        }
    }

    @Override
    public List<InstituteSocialLinkResponseDTO> getAll(Long instituteId) {
        try {
            List<InstituteSocialLinkEntity> result = instituteSocialLinkRepository.findByInstituteId(instituteId);
            return result.stream().map(entity -> {
                InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteSocialLinks", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteSocialLinkEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteSocialLinks", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteSocialLinkResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteSocialLinkEntity> result = instituteSocialLinkRepository.findByInstituteId(instituteId);
        return result.stream().map(entity -> {
            InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteSocialLinkResponseDTO getById(Long id, Long instituteId) {
        InstituteSocialLinkEntity entity = instituteSocialLinkRepository.findByIdAndInstituteId(id, instituteId)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteSocialLink not found with id: " + id + " for institute id: " + instituteId));
        InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteSocialLinkResponseDTO updateSocialLink(Long id, Long instituteId, InstituteSocialLinkUpdateRequestDTO requestDTO) {
        InstituteSocialLinkEntity existing = instituteSocialLinkRepository.findByIdAndInstituteId(id, instituteId)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteSocialLink not found with id: " + id + " for institute id: " + instituteId));

        if (requestDTO.getPlatform() != null) {
            existing.setPlatform(requestDTO.getPlatform());
        }
        if (requestDTO.getUrl() != null) {
            existing.setUrl(requestDTO.getUrl());
        }

        InstituteSocialLinkEntity updated = instituteSocialLinkRepository.save(existing);
        InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(updated, InstituteSocialLinkResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id, Long instituteId) {
        if (instituteSocialLinkRepository.findByIdAndInstituteId(id, instituteId).isEmpty()) {
            throw new ResourceNotFoundException("InstituteSocialLink not found with id: " + id + " for institute id: " + instituteId);
        }
        instituteSocialLinkRepository.deleteById(id);
    }

    @Override
    public List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword, Long instituteId) {
        List<InstituteSocialLinkEntity> result = instituteSocialLinkRepository.searchByKeywordAndInstituteId(keyword == null ? "" : keyword.trim(), instituteId);
        return result.stream().map(entity -> {
            InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
