package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.BulkStandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StandardSubjectResponseDTO;
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

        @Override
        @Transactional
        public StandardSubjectResponseDTO assign(StandardSubjectRequestDTO dto) {
                log.info("Assigning Subject {} to Standard {}", dto.getSubjectId(), dto.getStandardId());

                SubjectEntity subject = subjectRepository.findActiveById(dto.getSubjectId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Subject not found: " + dto.getSubjectId()));
                StandardEntity standard = standardRepository.findById(dto.getStandardId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Standard not found: " + dto.getStandardId()));
                AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                                .orElseThrow(
                                                () -> new ResourceNotFoundException(
                                                                "Academic Year not found: " + dto.getAcademicYearId()));

                StandardSubjectEntity entity = CoreAcademicMapper.toEntity(dto);
                // MapStruct copies IDs into the embedded object, but we set relations as well
                entity.setSubject(subject);
                entity.setStandard(standard);
                entity.setAcademicYear(academicYear);

                StandardSubjectEntity saved = standardSubjectRepository.save(entity);
                return CoreAcademicMapper.toResponse(saved);
        }

        @Override
        public List<StandardSubjectResponseDTO> getByStandardAndYear(Long standardId, Long academicYearId) {
                return standardSubjectRepository.findSubjectsByStandardAndAcademicYear(standardId, academicYearId)
                                .stream()
                                .map(CoreAcademicMapper::toResponse)
                                .collect(Collectors.toList());
        }

        @Override
        @Transactional
        public void unassign(Long standardId, Long subjectId, Long academicYearId) {
                log.info("Unassigning Subject {} from Standard {}", subjectId, standardId);

                StandardSubjectEntity entity = standardSubjectRepository
                                .findByStandardSubjectAndYear(standardId, subjectId, academicYearId)
                                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));

                standardSubjectRepository.deleteById(entity.getId());
        }

        @Override
        @Transactional
        public void bulkUnassign(Long standardId, List<Long> subjectIds, Long academicYearId) {
                log.info("Bulk unassigning subjects {} from Standard {} for Academic Year {}", subjectIds, standardId,
                                academicYearId);
                standardSubjectRepository.bulkDelete(standardId, subjectIds, academicYearId);
        }

        @Override
        @Transactional
        public void bulkAssign(BulkStandardSubjectRequestDTO dto) {
                log.info("Bulk assigning {} subjects", dto.getAssignments().size());

                for (StandardSubjectRequestDTO requestDTO : dto.getAssignments()) {
                        SubjectEntity subject = subjectRepository.findActiveById(requestDTO.getSubjectId())
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                        "Subject not found: " + requestDTO.getSubjectId()));
                        StandardEntity standard = standardRepository.findById(requestDTO.getStandardId())
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                        "Standard not found: " + requestDTO.getStandardId()));
                        AcademicYearEntity academicYear = academicYearRepository
                                        .findById(requestDTO.getAcademicYearId())
                                        .orElseThrow(
                                                        () -> new ResourceNotFoundException("Academic Year not found: "
                                                                        + requestDTO.getAcademicYearId()));

                        StandardSubjectEntity entity = CoreAcademicMapper.toEntity(requestDTO);
                        entity.setSubject(subject);
                        entity.setStandard(standard);
                        entity.setAcademicYear(academicYear);

                        standardSubjectRepository.save(entity);
                }
        }

        @Override
        @Transactional
        public StandardSubjectResponseDTO update(Long id, StandardSubjectRequestDTO dto) {
                log.info("Updating Standard Subject Mapping {}", id);

                StandardSubjectEntity entity = standardSubjectRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found with id: " + id));

                // Update fields
                entity.setOptional(dto.isOptional());
                entity.setWeeklyHours(dto.getWeeklyHours());
                entity.setTheoryMarks(dto.getTheoryMarks());
                entity.setPracticalMarks(dto.getPracticalMarks());
                entity.setActive(dto.isActive());

                // If standardId, subjectId or academicYearId are provided, we should re-fetch
                // them if they changed
                // However, usually these are immutable for a mapping record.
                // In some cases, we might want to allow changing them if we're sure.
                // For now, I'll stick to updating attributes as per the plan.

                StandardSubjectEntity saved = standardSubjectRepository.save(entity);
                return CoreAcademicMapper.toResponse(saved);
        }
}
