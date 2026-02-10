package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.school.model.AcademicSubjectEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.SubjectRepository;
import com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.model.TeacherSubjectAssignmentEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.sclass.repository.TeacherSubjectAssignmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherSubjectAssignmentService{

    private final TeacherSubjectAssignmentRepository repository;
    private final EmployeeMasterRepository employeeRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;
    private final AcademicYearRepository academicYearRepository;


    public TeacherSubjectAssignmentResponseDTO assign(
            TeacherSubjectAssignmentRequestDTO dto) {

        boolean exists = repository
                .existsByEmployee_IdAndStandard_IdAndSection_IdAndSubject_IdAndAcademicYear_Id(
                        dto.getEmployeeId(),
                        dto.getStandardId(),
                        dto.getSectionId(),
                        dto.getSubjectId(),
                        dto.getAcademicYearId()
                );

        if (exists) {
            throw new IllegalStateException("Teacher already assigned to this subject and class");
        }

        EmployeeMasterEntity employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        StandardEntity standard = standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new EntityNotFoundException("Standard not found"));

        SectionEntity section = sectionRepository.findById(dto.getSectionId())
                .orElseThrow(() -> new EntityNotFoundException("Section not found"));

        AcademicSubjectEntity subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new EntityNotFoundException("Academic year not found"));

        TeacherSubjectAssignmentEntity entity =
                TeacherSubjectAssignmentEntity.builder()
                        .employee(employee)
                        .standard(standard)
                        .section(section)
                        .subject(subject)
                        .academicYear(academicYear)
                        .build();

        return mapToDTO(repository.save(entity));
    }

    public void unassign(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Assignment not found");
        }
        repository.deleteById(id);
    }

    public TeacherSubjectAssignmentResponseDTO getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Assignment not found"));
    }

    public List<TeacherSubjectAssignmentResponseDTO> getByTeacher(Long employeeId) {
        return repository.findByEmployee_Id(employeeId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public List<TeacherSubjectAssignmentResponseDTO> getByClassSection(
            Long standardId,
            Long sectionId,
            Long academicYearId) {

        return repository
                .findByStandard_IdAndSection_IdAndAcademicYear_Id(
                        standardId, sectionId, academicYearId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private TeacherSubjectAssignmentResponseDTO mapToDTO(
            TeacherSubjectAssignmentEntity entity) {

        return TeacherSubjectAssignmentResponseDTO.builder()
                .id(entity.getId())
                .employeeId(entity.getEmployee().getId())
                .employeeName(entity.getEmployee().getFullName())
                .standardId(entity.getStandard().getId())
                .standardName(entity.getStandard().getStandardName())
                .sectionId(entity.getSection().getId())
                .sectionName(entity.getSection().getSectionName())
                .subjectId(entity.getSubject().getId())
                .subjectName(entity.getSubject().getName())
                .academicYearId(entity.getAcademicYear().getId())
                .academicYearName(entity.getAcademicYear().getName())
                .build();
    }
}
