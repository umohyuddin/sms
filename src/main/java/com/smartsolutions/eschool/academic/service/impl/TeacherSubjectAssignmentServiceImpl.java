package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import com.smartsolutions.eschool.academic.mapper.TeacherAssignmentMapper;
import com.smartsolutions.eschool.academic.repository.SubjectRepository;
import com.smartsolutions.eschool.academic.repository.TeacherSubjectAssignmentRepository;
import com.smartsolutions.eschool.academic.service.TeacherSubjectAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherSubjectAssignmentServiceImpl implements TeacherSubjectAssignmentService {

        private final TeacherSubjectAssignmentRepository teacherAssignmentRepository;
        private final EmployeeMasterRepository employeeRepository;
        private final StandardRepository standardRepository;
        private final SectionRepository sectionRepository;
        private final SubjectRepository subjectRepository;
        private final AcademicYearRepository academicYearRepository;

        @Override
        @Transactional
        public TeacherSubjectAssignmentResponseDTO assign(TeacherSubjectAssignmentRequestDTO dto) {
                log.info("Assigning Teacher {} to Subject {} for Standard {} Section {}",
                                dto.getEmployeeId(), dto.getSubjectId(), dto.getStandardId(), dto.getSectionId());

                EmployeeMasterEntity teacher = employeeRepository.findById(dto.getEmployeeId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Teacher not found: " + dto.getEmployeeId()));
                SubjectEntity subject = subjectRepository.findActiveById(dto.getSubjectId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Subject not found: " + dto.getSubjectId()));
                StandardEntity standard = standardRepository.findById(dto.getStandardId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Standard not found: " + dto.getStandardId()));
                SectionEntity section = sectionRepository.findById(dto.getSectionId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Section not found: " + dto.getSectionId()));
                AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Academic Year not found: " + dto.getAcademicYearId()));

                TeacherSubjectAssignmentEntity entity = TeacherAssignmentMapper.toEntity(dto);
                entity.setTeacher(teacher);
                entity.setSubject(subject);
                entity.setStandard(standard);
                entity.setSection(section);
                entity.setAcademicYear(academicYear);

                TeacherSubjectAssignmentEntity saved = teacherAssignmentRepository.save(entity);
                return TeacherAssignmentMapper.toResponse(saved);
        }

        @Override
        public List<TeacherSubjectAssignmentResponseDTO> getByTeacher(Long employeeId) {
                return teacherAssignmentRepository.findByTeacherId(employeeId).stream()
                                .map(TeacherAssignmentMapper::toResponse)
                                .collect(Collectors.toList());
        }

        @Override
        public List<TeacherSubjectAssignmentResponseDTO> getBySection(Long standardId, Long sectionId,
                        Long academicYearId) {
                return teacherAssignmentRepository
                                .findByStandardSectionAndAcademicYear(standardId, sectionId, academicYearId).stream()
                                .map(TeacherAssignmentMapper::toResponse)
                                .collect(Collectors.toList());
        }

        @Override
        public List<TeacherSubjectAssignmentResponseDTO> getByStandard(Long standardId, Long academicYearId) {
                return teacherAssignmentRepository.findByStandardAndAcademicYear(standardId, academicYearId).stream()
                                .map(TeacherAssignmentMapper::toResponse)
                                .collect(Collectors.toList());
        }

        @Override
        @Transactional
        public void unassign(Long employeeId, Long standardId, Long sectionId, Long subjectId, Long academicYearId,
                        LocalDate effectiveFrom) {
                log.info("Unassigning Teacher assignment");
                TeacherSubjectAssignmentEntity entity = teacherAssignmentRepository
                                .findByTeacherStandardSectionSubjectAndYear(
                                                employeeId, standardId, sectionId, subjectId, academicYearId)
                                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));

                teacherAssignmentRepository.softDeleteById(entity.getId());
        }
}
