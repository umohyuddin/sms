package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.SubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectGroupEntity;
import com.smartsolutions.eschool.academic.mapper.CoreAcademicMapper;
import com.smartsolutions.eschool.academic.repository.SubjectGroupRepository;
import com.smartsolutions.eschool.academic.repository.SubjectRepository;
import com.smartsolutions.eschool.academic.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectGroupRepository subjectGroupRepository;

    @Override
    @Transactional
    public SubjectResponseDTO create(SubjectRequestDTO dto) {
        log.info("Creating Subject: {}", dto.getName());
        SubjectEntity entity = CoreAcademicMapper.toEntity(dto);
        
        if (dto.getSubjectGroupId() != null) {
            SubjectGroupEntity group = subjectGroupRepository.findActiveById(dto.getSubjectGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Subject group not found: " + dto.getSubjectGroupId()));
            entity.setSubjectGroup(group);
        }
        
        SubjectEntity saved = subjectRepository.save(entity);
        return CoreAcademicMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public SubjectResponseDTO update(Long id, SubjectRequestDTO dto) {
        log.info("Updating Subject ID: {}", id);
        SubjectEntity entity = subjectRepository.findActiveById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found or deleted with ID: " + id));
        
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        entity.setCore(dto.isCore());
        entity.setActive(dto.isActive());

        if (dto.getSubjectGroupId() != null) {
            SubjectGroupEntity group = subjectGroupRepository.findActiveById(dto.getSubjectGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Subject group not found: " + dto.getSubjectGroupId()));
            entity.setSubjectGroup(group);
        } else {
            entity.setSubjectGroup(null);
        }
        
        SubjectEntity updated = subjectRepository.save(entity);
        return CoreAcademicMapper.toResponse(updated);
    }

    @Override
    public SubjectResponseDTO getById(Long id) {
        return subjectRepository.findActiveById(id)
                .map(CoreAcademicMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with ID: " + id));
    }

    @Override
    public List<SubjectResponseDTO> getAllActive() {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        return subjectRepository.findAllActiveByOrg(orgId).stream()
                .map(CoreAcademicMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectResponseDTO> getByGroupId(Long groupId) {
        return subjectRepository.findByGroupId(groupId).stream()
                .map(CoreAcademicMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting Subject ID: {}", id);
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with ID: " + id);
        }
        subjectRepository.softDeleteById(id);
    }
}
