package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteContactEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteContactRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
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
public class InstituteContactServiceImpl implements InstituteContactService {

    private final InstituteContactRepository instituteContactRepository;
    private final InstituteRepository instituteRepository;

    public InstituteContactServiceImpl(InstituteContactRepository instituteContactRepository, InstituteRepository instituteRepository) {
        this.instituteContactRepository = instituteContactRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteContactResponseDTO createContact(InstituteContactCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteContactEntity entity = MapperUtil.mapObject(requestDTO, InstituteContactEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteContactEntity saved = instituteContactRepository.save(entity);
            InstituteContactResponseDTO response = MapperUtil.mapObject(saved, InstituteContactResponseDTO.class);
            response.setInstituteId(institute.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteContact", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteContact", ex);
            throw ex;
        }
    }

    @Override
    public Page<InstituteContactResponseDTO> getAll(Pageable pageable) {
        try {
            Page<InstituteContactEntity> result = instituteContactRepository.findAllJpql(pageable);
            return result.map(entity -> {
                InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            });
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteContacts", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteContactEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteContacts", e);
        }
        return Page.empty();
    }

    @Override
    public Page<InstituteContactResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        Page<InstituteContactEntity> result = instituteContactRepository.findByInstituteId(instituteId, pageable);
        return result.map(entity -> {
            InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        });
    }

    @Override
    public InstituteContactResponseDTO getById(Long id) {
        InstituteContactEntity entity = instituteContactRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteContact not found with id: " + id));
        InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteContactResponseDTO updateContact(Long id, InstituteContactUpdateRequestDTO requestDTO) {
        InstituteContactEntity existing = instituteContactRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteContact not found with id: " + id));

        if (requestDTO.getContactPersonName() != null) {
            existing.setContactPersonName(requestDTO.getContactPersonName());
        }
        if (requestDTO.getRole() != null) {
            existing.setRole(requestDTO.getRole());
        }
        if (requestDTO.getPhone() != null) {
            existing.setPhone(requestDTO.getPhone());
        }
        if (requestDTO.getEmail() != null) {
            existing.setEmail(requestDTO.getEmail());
        }
        if (requestDTO.getIsPrimary() != null) {
            existing.setIsPrimary(requestDTO.getIsPrimary());
        }

        InstituteContactEntity updated = instituteContactRepository.save(existing);
        InstituteContactResponseDTO dto = MapperUtil.mapObject(updated, InstituteContactResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteContactRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteContact not found with id: " + id);
        }
        instituteContactRepository.deleteById(id);
    }

    @Override
    public List<InstituteContactResponseDTO> searchByKeyword(String keyword) {
        List<InstituteContactEntity> result = instituteContactRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
