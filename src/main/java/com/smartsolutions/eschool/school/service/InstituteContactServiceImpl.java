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
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<InstituteContactResponseDTO> getAll() {
        try {
            List<InstituteContactEntity> result = instituteContactRepository.findAllJpql();
            return result.stream().map(entity -> {
                InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            }).toList();
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteContacts", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteContactEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteContacts", e);
        }
        return List.of();
    }

    @Override
    public List<InstituteContactResponseDTO> getByInstituteId(Long instituteId) {
        List<InstituteContactEntity> result = instituteContactRepository.findByInstituteId(instituteId);
        return result.stream().map(entity -> {
            InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteContactResponseDTO getById(Long contactId, Long instituteId) {
        InstituteContactEntity entity = instituteContactRepository.findByIdAndOrganizationId(contactId, instituteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "InstituteContact not found with id: " + contactId + " for institute id: " + instituteId));

        InstituteContactResponseDTO dto = MapperUtil.mapObject(entity, InstituteContactResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }


    @Override
    public InstituteContactResponseDTO updateContact(Long contactId, Long instituteId, InstituteContactUpdateRequestDTO requestDTO) {
        InstituteContactEntity entity = instituteContactRepository
                .findByIdAndOrganizationId(contactId, instituteId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id=" + contactId + " for institute=" + instituteId
                ));

        // update fields
        if (requestDTO.getContactPersonName() != null) entity.setContactPersonName(requestDTO.getContactPersonName());
        if (requestDTO.getRole() != null) entity.setRole(requestDTO.getRole());
        if (requestDTO.getPhone() != null) entity.setPhone(requestDTO.getPhone());
        if (requestDTO.getEmail() != null) entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getIsPrimary() != null) entity.setIsPrimary(requestDTO.getIsPrimary());

        // save updated entity
        InstituteContactEntity updated = instituteContactRepository.save(entity);

        InstituteContactResponseDTO dto = MapperUtil.mapObject(updated, InstituteContactResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    @Transactional
    public void deleteById(Long id, Long organizationId) {

        InstituteContactEntity entity = instituteContactRepository
                .findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "InstituteContact not found with id: " + id));

        entity.setIsDeleted(true);
        entity.setDeletedAt(LocalDateTime.now());
        entity.setDeletedBy(1L);

        instituteContactRepository.save(entity);
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
