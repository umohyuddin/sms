package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteDocumentEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteDocumentRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteDocumentServiceImpl implements InstituteDocumentService {

    private final InstituteDocumentRepository instituteDocumentRepository;
    private final InstituteRepository instituteRepository;

    public InstituteDocumentServiceImpl(InstituteDocumentRepository instituteDocumentRepository, InstituteRepository instituteRepository) {
        this.instituteDocumentRepository = instituteDocumentRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteDocumentResponseDTO createDocument(InstituteDocumentCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteDocumentEntity entity = MapperUtil.mapObject(requestDTO, InstituteDocumentEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteDocumentEntity saved = instituteDocumentRepository.save(entity);
            InstituteDocumentResponseDTO dto = MapperUtil.mapObject(saved, InstituteDocumentResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteDocument", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteDocument", ex);
            throw ex;
        }
    }

    @Override
    public List<InstituteDocumentResponseDTO> getAll() {
        try {
            List<InstituteDocumentEntity> result = instituteDocumentRepository.findAllJpql();
            return result.stream().map(entity -> {
                InstituteDocumentResponseDTO dto = MapperUtil.mapObject(entity, InstituteDocumentResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteDocuments", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteDocumentEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteDocuments", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteDocumentResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteDocumentEntity> result = instituteDocumentRepository.findByInstituteId(instituteId);
        return result.stream().map(entity -> {
            InstituteDocumentResponseDTO dto = MapperUtil.mapObject(entity, InstituteDocumentResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteDocumentResponseDTO getById(Long id) {
        InstituteDocumentEntity entity = instituteDocumentRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteDocument not found with id: " + id));
        InstituteDocumentResponseDTO dto = MapperUtil.mapObject(entity, InstituteDocumentResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteDocumentResponseDTO updateDocument(Long id, InstituteDocumentUpdateRequestDTO requestDTO) {
        InstituteDocumentEntity existing = instituteDocumentRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteDocument not found with id: " + id));

        if (requestDTO.getDocumentType() != null) {
            existing.setDocumentType(requestDTO.getDocumentType());
        }
        if (requestDTO.getFileName() != null) {
            existing.setFileName(requestDTO.getFileName());
        }
        if (requestDTO.getFileUrl() != null) {
            existing.setFileUrl(requestDTO.getFileUrl());
        }
        if (requestDTO.getExpiryDate() != null) {
            existing.setExpiryDate(requestDTO.getExpiryDate());
        }

        InstituteDocumentEntity updated = instituteDocumentRepository.save(existing);
        InstituteDocumentResponseDTO dto = MapperUtil.mapObject(updated, InstituteDocumentResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteDocumentRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteDocument not found with id: " + id);
        }
        instituteDocumentRepository.deleteById(id);
    }

    @Override
    public List<InstituteDocumentResponseDTO> searchByKeyword(String keyword) {
        List<InstituteDocumentEntity> result = instituteDocumentRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteDocumentResponseDTO dto = MapperUtil.mapObject(entity, InstituteDocumentResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
