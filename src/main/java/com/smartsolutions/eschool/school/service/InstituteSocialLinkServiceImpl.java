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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<InstituteSocialLinkResponseDTO> getAll(Pageable pageable) {
        try {
            Page<InstituteSocialLinkEntity> result = instituteSocialLinkRepository.findAllJpql(pageable);
            return result.map(entity -> {
                InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            });
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteSocialLinks", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteSocialLinkEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteSocialLinks", e);
        }
        return Page.empty();
    }

    @Override
    public Page<InstituteSocialLinkResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        Page<InstituteSocialLinkEntity> result = instituteSocialLinkRepository.findByInstituteId(instituteId, pageable);
        return result.map(entity -> {
            InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        });
    }

    @Override
    public InstituteSocialLinkResponseDTO getById(Long id) {
        InstituteSocialLinkEntity entity = instituteSocialLinkRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteSocialLink not found with id: " + id));
        InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteSocialLinkResponseDTO updateSocialLink(Long id, InstituteSocialLinkUpdateRequestDTO requestDTO) {
        InstituteSocialLinkEntity existing = instituteSocialLinkRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteSocialLink not found with id: " + id));

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
    public void deleteById(Long id) {
        if (instituteSocialLinkRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteSocialLink not found with id: " + id);
        }
        instituteSocialLinkRepository.deleteById(id);
    }

    @Override
    public List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword) {
        List<InstituteSocialLinkEntity> result = instituteSocialLinkRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteSocialLinkResponseDTO dto = MapperUtil.mapObject(entity, InstituteSocialLinkResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
