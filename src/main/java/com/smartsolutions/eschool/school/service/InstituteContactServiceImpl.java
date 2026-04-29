package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.InstituteContactMapper;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteContactEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteContactRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;
import com.smartsolutions.eschool.user.repository.RoleRepository;
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
    private final RoleRepository roleRepository;

    public InstituteContactServiceImpl(InstituteContactRepository instituteContactRepository, InstituteRepository instituteRepository, RoleRepository roleRepository) {
        this.instituteContactRepository = instituteContactRepository;
        this.instituteRepository = instituteRepository;
        this.roleRepository = roleRepository;
    }

    public InstituteContactResponseDTO createContact(InstituteContactCreateRequestDTO requestDTO) {

        // Fetch institute
        InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Institute not found with id: " + requestDTO.getInstituteId()));

        // Fetch role
        RoleEntity role = roleRepository.findById(requestDTO.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Role not found with id: " + requestDTO.getRoleId()));

        // Map request DTO → Entity
        InstituteContactEntity entity = InstituteContactMapper.toEntity(requestDTO);

        // Set relationships
        entity.setInstitute(institute);
        entity.setRole(role);

        // Save entity
        InstituteContactEntity saved = instituteContactRepository.save(entity);

        // Map Entity → Response DTO
        return InstituteContactMapper.toResponseDTO(saved);
    }

    @Override
    public List<InstituteContactResponseDTO> getAll() {
        try {
            List<InstituteContactEntity> result = instituteContactRepository.findAllJpql();
            return result.stream().map(InstituteContactMapper::toResponseDTO).toList();

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

        return result.stream().map(InstituteContactMapper::toResponseDTO).toList();
    }

    @Override
    public InstituteContactResponseDTO getById(Long contactId, Long instituteId) {

        InstituteContactEntity entity = instituteContactRepository.findByIdAndInstituteId(contactId, instituteId).orElseThrow(() -> new ResourceNotFoundException("InstituteContact not found with id: " + contactId + " for institute id: " + instituteId));

        return InstituteContactMapper.toResponseDTO(entity);
    }


    @Transactional
    @Override
    public InstituteContactResponseDTO updateContact(
            Long contactId,
            Long instituteId,
            InstituteContactUpdateRequestDTO requestDTO
    ) {
        // Fetch the existing contact with role eagerly
        InstituteContactEntity entity = instituteContactRepository
                .findByIdAndInstituteIdWithRole(contactId, instituteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Contact not found with id=" + contactId + " for institute=" + instituteId
                ));

        // Update simple fields using utility method
        InstituteContactMapper.updateEntity(entity, requestDTO);

        // Update role if roleId is provided
        if (requestDTO.getRoleId() != null &&
                (entity.getRole() == null || !entity.getRole().getId().equals(requestDTO.getRoleId()))) {

            RoleEntity role = roleRepository
                    .findById(requestDTO.getRoleId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Role not found with id=" + requestDTO.getRoleId()
                    ));
            entity.setRole(role);
        }

        // Save the updated entity
        InstituteContactEntity updated = instituteContactRepository.save(entity);

        // Map to DTO using reusable mapper (role is already loaded, no LazyInitializationException)
        return InstituteContactMapper.toResponseDTO(updated);
    }


    @Override
    @Transactional
    public void deleteById(Long id, Long instituteId) {

        // Fetch the entity
        InstituteContactEntity entity = instituteContactRepository
                .findByIdAndInstituteId(id, instituteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "InstituteContact not found with id: " + id + " for institute: " + instituteId
                ));

        // Soft delete
        entity.setIsDeleted(true);
        entity.setDeletedAt(LocalDateTime.now());
        entity.setDeletedBy(1L); // TODO: Replace with current user ID from context

        // Save updated entity
        instituteContactRepository.save(entity);

    }

    @Override
    public List<InstituteContactResponseDTO> searchByKeyword(Long instituteId, String keyword) {

        // Null-safe keyword
        String searchTerm = (keyword == null) ? "" : keyword.trim();

        // Multi-tenant scoped query
        List<InstituteContactEntity> result =
                instituteContactRepository.searchByKeyword(instituteId, searchTerm);

        // Map entities to DTOs using reusable mapper
        return result.stream()
                .map(InstituteContactMapper::toResponseDTO)
                .toList();
    }

}
