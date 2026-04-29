package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.academic.dto.request.ExamRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamTypeEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.ExamRepository;
import com.smartsolutions.eschool.academic.repository.ExamTermRepository;
import com.smartsolutions.eschool.academic.repository.ExamTypeRepository;
import com.smartsolutions.eschool.academic.service.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamServiceImpl implements ExamService {

        private final ExamRepository examRepository;
        private final AcademicYearRepository academicYearRepository;
        private final ExamTermRepository examTermRepository;
        private final ExamTypeRepository examTypeRepository;
        private final CampusRepository campusRepository;
        private final StandardRepository standardRepository;
        private final SectionRepository sectionRepository;

        @Override
        @Transactional
        public List<ExamResponseDTO> create(ExamRequestDTO dto) {
                AcademicYearEntity year = academicYearRepository.findById(dto.getAcademicYearId())
                                .orElseThrow(() -> new ResourceNotFoundException("Academic Year not found"));
                ExamTermEntity term = examTermRepository.findByIdAndDeletedFalse(dto.getExamTermId())
                                .orElseThrow(() -> new ResourceNotFoundException("Exam Term not found"));
                ExamTypeEntity examType = examTypeRepository.findByIdAndDeletedFalse(dto.getExamTypeId())
                                .orElseThrow(() -> new ResourceNotFoundException("Exam Type not found"));
                CampusEntity campus = campusRepository.findById(dto.getCampusId())
                                .orElseThrow(() -> new ResourceNotFoundException("Campus not found"));
                StandardEntity standard = standardRepository.findById(dto.getStandardId())
                                .orElseThrow(() -> new ResourceNotFoundException("Standard not found"));

                if (dto.getSelectedSections() != null && !dto.getSelectedSections().isEmpty()) {
                        return dto.getSelectedSections().stream()
                                        .filter(ExamRequestDTO.SelectedSectionDTO::isSelected)
                                        .map(sectionDto -> {
                                                SectionEntity section = sectionRepository
                                                                .findById(sectionDto.getSectionId())
                                                                .orElseThrow(() -> new ResourceNotFoundException(
                                                                                "Section not found: " + sectionDto
                                                                                                .getSectionId()));

                                                ExamEntity entity = new ExamEntity();
                                                entity.setAcademicYear(year);
                                                entity.setExamTerm(term);
                                                entity.setExamType(examType);
                                                entity.setCampus(campus);
                                                entity.setStandard(standard);
                                                entity.setSection(section);
                                                entity.setName(sectionDto.getExamName() != null
                                                                ? sectionDto.getExamName()
                                                                : dto.getName());
                                                entity.setStartDate(sectionDto.getStartDate() != null
                                                                ? sectionDto.getStartDate()
                                                                : dto.getStartDate());
                                                entity.setEndDate(sectionDto.getEndDate() != null
                                                                ? sectionDto.getEndDate()
                                                                : dto.getEndDate());
                                                entity.setStatus(sectionDto.getStatus() != null ? sectionDto.getStatus()
                                                                : dto.getStatus());
                                                entity.setActive(dto.isActive());

                                                return ExamAssessmentMapper.toResponse(examRepository.save(entity));
                                        })
                                        .collect(Collectors.toList());
                }

                // Fallback for single section if still used via sectionId
                if (dto.getSectionId() != null) {
                        SectionEntity section = sectionRepository.findById(dto.getSectionId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Section not found"));

                        ExamEntity entity = ExamAssessmentMapper.toEntity(dto);
                        entity.setAcademicYear(year);
                        entity.setExamTerm(term);
                        entity.setExamType(examType);
                        entity.setCampus(campus);
                        entity.setStandard(standard);
                        entity.setSection(section);

                        return List.of(ExamAssessmentMapper.toResponse(examRepository.save(entity)));
                }

                return List.of();
        }

        @Override
        @Transactional
        public ExamResponseDTO update(Long id, ExamRequestDTO dto) {
                ExamEntity entity = examRepository.findByIdAndDeletedFalse(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));

                entity.setName(dto.getName());
                entity.setStartDate(dto.getStartDate());
                entity.setEndDate(dto.getEndDate());
                entity.setStatus(dto.getStatus());
                entity.setActive(dto.isActive());

                // Update terms/campus/standard if changed...

                return ExamAssessmentMapper.toResponse(examRepository.save(entity));
        }

        @Override
        public ExamResponseDTO getById(Long id) {
                return examRepository.findByIdAndDeletedFalse(id)
                                .map(ExamAssessmentMapper::toResponse)
                                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        }

        @Override
        public ExamResponseDTO getById(Long id, Long orgId) {
                return examRepository.findByIdAndOrganizationIdAndDeletedFalse(id, orgId)
                                .map(ExamAssessmentMapper::toResponse)
                                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        }

        @Override
        public List<ExamResponseDTO> getBySection(Long standardId, Long sectionId, Long academicYearId) {
                return examRepository.findBySectionAndAcademicYear(standardId, sectionId, academicYearId).stream()
                                .map(ExamAssessmentMapper::toResponse)
                                .collect(Collectors.toList());
        }

        @Override
        public List<ExamResponseDTO> search(Long academicYearId, Long campusId, Long standardId, Long sectionId,
                        Long examTermId, Long examTypeId, String keyword) {
                Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
                return examRepository
                                .searchExams(orgId, academicYearId, campusId, standardId, sectionId, examTermId,
                                                examTypeId, keyword)
                                .stream()
                                .map(ExamAssessmentMapper::toResponse)
                                .collect(Collectors.toList());
        }

        @Override
        @Transactional
        public void delete(Long id) {
                if (!examRepository.existsById(id)) {
                        throw new ResourceNotFoundException("Exam not found");
                }
                examRepository.softDeleteById(id);
        }
}
