package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectGroupResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.SubjectGroupEntity;
import com.smartsolutions.eschool.academic.mapper.CoreAcademicMapper;
import com.smartsolutions.eschool.academic.repository.SubjectGroupRepository;
import com.smartsolutions.eschool.academic.service.SubjectGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectGroupServiceImpl implements SubjectGroupService {

    private final SubjectGroupRepository subjectGroupRepository;

    @Override
    @Transactional
    public SubjectGroupResponseDTO create(SubjectGroupRequestDTO dto) {
        log.info("Creating Subject Group: {}", dto.getName());
        SubjectGroupEntity entity = CoreAcademicMapper.toEntity(dto);
        // organizationId is handled by AuditableEntity @PrePersist
        SubjectGroupEntity saved = subjectGroupRepository.save(entity);
        return CoreAcademicMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public SubjectGroupResponseDTO update(Long id, SubjectGroupRequestDTO dto) {
        log.info("Updating Subject Group ID: {}", id);
        SubjectGroupEntity entity = subjectGroupRepository.findActiveById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject Group not found or deleted with ID: " + id));
        
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setActive(dto.isActive());
        
        SubjectGroupEntity updated = subjectGroupRepository.save(entity);
        return CoreAcademicMapper.toResponse(updated);
    }

    @Override
    public SubjectGroupResponseDTO getById(Long id) {
        return subjectGroupRepository.findActiveById(id)
                .map(CoreAcademicMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Subject Group not found with ID: " + id));
    }

    @Override
    public List<SubjectGroupResponseDTO> getAllActive() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();

        log.debug("Fetching active subject groups for organizationId={}", orgId);

        List<SubjectGroupResponseDTO> response = subjectGroupRepository
                .findAllByOrg(orgId)
                .stream()
                .map(CoreAcademicMapper::toResponse)
                .toList();

        log.debug("Fetched {} active subject groups for organizationId={}", response.size(), orgId);

        return response;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting Subject Group ID: {}", id);
        if (!subjectGroupRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject Group not found with ID: " + id);
        }
        subjectGroupRepository.softDeleteById(id);
    }
}
