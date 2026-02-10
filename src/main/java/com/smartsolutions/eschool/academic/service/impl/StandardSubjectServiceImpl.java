package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StandardSubjectResponseDTO;
import com.smartsolutions.eschool.academic.entity.embeddable.StandardSubjectId;
import com.smartsolutions.eschool.academic.entity.mapping.StandardSubjectEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import com.smartsolutions.eschool.academic.mapper.CoreAcademicMapper;
import com.smartsolutions.eschool.academic.repository.StandardSubjectRepository;
import com.smartsolutions.eschool.academic.repository.SubjectRepository;
import com.smartsolutions.eschool.academic.service.StandardSubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StandardSubjectServiceImpl implements StandardSubjectService {

    private final StandardSubjectRepository standardSubjectRepository;
    private final SubjectRepository subjectRepository;
    private final StandardRepository standardRepository;
    private final AcademicYearRepository academicYearRepository;
    private final CoreAcademicMapper coreAcademicMapper;

    @Override
    @Transactional
    public StandardSubjectResponseDTO assign(StandardSubjectRequestDTO dto) {
        log.info("Assigning Subject {} to Standard {}", dto.getSubjectId(), dto.getStandardId());
        
        SubjectEntity subject = subjectRepository.findActiveById(dto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found: " + dto.getSubjectId()));
        StandardEntity standard = standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found: " + dto.getStandardId()));
        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found: " + dto.getAcademicYearId()));

        StandardSubjectEntity entity = coreAcademicMapper.toEntity(dto);
        // MapStruct copies IDs into the embedded object, but we set relations as well
        entity.setSubject(subject);
        entity.setStandard(standard);
        entity.setAcademicYear(academicYear);
        
        // organizationId handled by @PrePersist on AuditableEntity via SecurityUtils
        // But for @EmbeddedId we might need to set it manually if not mapped by MapStruct
        if (entity.getId().getOrganizationId() == null) {
            entity.getId().setOrganizationId(SecurityUtils.getCurrentOrganizationId());
        }

        StandardSubjectEntity saved = standardSubjectRepository.save(entity);
        return coreAcademicMapper.toResponse(saved);
    }

    @Override
    public List<StandardSubjectResponseDTO> getByStandardAndYear(Long standardId, Long academicYearId) {
        return standardSubjectRepository.findSubjectsByStandardAndAcademicYear(standardId, academicYearId).stream()
                .map(coreAcademicMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void unassign(Long standardId, Long subjectId, Long academicYearId) {
        log.info("Unassigning Subject {} from Standard {}", subjectId, standardId);
        StandardSubjectId id = StandardSubjectId.builder()
                .organizationId(SecurityUtils.getCurrentOrganizationId())
                .standardId(standardId)
                .subjectId(subjectId)
                .academicYearId(academicYearId)
                .build();
        
        if (!standardSubjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assignment not found");
        }
        standardSubjectRepository.softDeleteById(id);
    }
}
