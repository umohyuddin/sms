package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.academic.entity.master.StudentAttendanceEntity;
import com.smartsolutions.eschool.academic.repository.StudentAttendanceRepository;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.dtos.studentAttendance.response.*;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentAttendanceReportService {

    private final StudentAttendanceRepository repository;
    private final StudentRepository studentRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final EmployeeMasterRepository employeeRepository;

    public List<DailyAttendanceReportDTO> getDailyAttendance(LocalDate date) {
        return repository.getDailyAttendance(date);
    }

    public List<ClassAttendanceReportDTO> getClassAttendance(Long standardId, Long sectionId, LocalDate startDate,
            LocalDate endDate) {
        return repository.getClassAttendance(standardId, sectionId, startDate, endDate);
    }

    public AttendanceSummaryDTO getStudentAttendanceSummary(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.getStudentAttendanceSummary(studentId, startDate, endDate);
    }

    public List<AttendanceSummaryDTO> getOverallAttendanceSummary(LocalDate startDate, LocalDate endDate) {
        return repository.getOverallAttendanceSummary(startDate, endDate);
    }

    public StudentAttendanceDTO markAttendance(StudentAttendanceDTO dto) {
        StudentAttendanceEntity entity = mapToEntity(dto);
        entity = repository.save(entity);
        return mapToDTO(entity);
    }

    public List<StudentAttendanceDTO> markBatchAttendance(List<StudentAttendanceDTO> dtos) {
        List<StudentAttendanceEntity> entities = dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
        entities = repository.saveAll(entities);
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public StudentAttendanceDTO updateAttendance(StudentAttendanceDTO dto) {
        if (!repository.existsById(dto.getId())) {
            throw new ResourceNotFoundException("Attendance record not found with id: " + dto.getId());
        }
        StudentAttendanceEntity entity = mapToEntity(dto);
        // Ensure ID is set for update
        entity.setId(dto.getId());
        entity = repository.save(entity);
        return mapToDTO(entity);
    }

    public void deleteAttendance(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Attendance record not found with id: " + id);
        }
        repository.softDeleteById(id);
    }

    public List<StudentAttendanceDTO> getAttendanceByStudent(Long studentId, LocalDate startDate, LocalDate endDate) {
        List<StudentAttendanceEntity> list = repository.findByStudentIdAndDateRange(studentId, startDate, endDate);
        return list.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<StudentAttendanceDTO> getAttendanceByClass(Long standardId, Long sectionId, LocalDate date) {
        List<StudentAttendanceEntity> list = repository.findByClassAndDate(standardId, sectionId, date);
        return list.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<StudentAttendanceDTO> getAttendanceByStandard(Long standardId, LocalDate startDate, LocalDate endDate) {
        List<StudentAttendanceEntity> list = repository.findByStandardAndDateRange(standardId, startDate, endDate);
        return list.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public AttendanceCheckDTO checkAttendanceExists(Long studentId, LocalDate attendanceDate) {
        boolean exists = repository.existsByStudentIdAndAttendanceDate(studentId, attendanceDate);
        return new AttendanceCheckDTO(studentId, attendanceDate, exists);
    }

    public long countPresent(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.countByStudentAndStatus(studentId, StudentAttendanceEntity.AttendanceStatus.PRESENT,
                startDate, endDate);
    }

    public long countAbsent(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.countByStudentAndStatus(studentId, StudentAttendanceEntity.AttendanceStatus.ABSENT, startDate,
                endDate);
    }

    public long countLeave(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.countByStudentAndStatus(studentId, StudentAttendanceEntity.AttendanceStatus.LEAVE, startDate,
                endDate);
    }

    // ----------------- Mapping Methods -----------------
    private StudentAttendanceDTO mapToDTO(StudentAttendanceEntity entity) {
        return new StudentAttendanceDTO(
                entity.getId(),
                entity.getStudent() != null ? entity.getStudent().getId() : null,
                entity.getStandard() != null ? entity.getStandard().getId() : null,
                entity.getSection() != null ? entity.getSection().getId() : null,
                entity.getAttendanceDate(),
                entity.getStatus().name(),
                entity.getMarkedBy() != null ? entity.getMarkedBy().getId() : null,
                entity.getRemarks());
    }

    private StudentAttendanceEntity mapToEntity(StudentAttendanceDTO dto) {
        StudentAttendanceEntity entity = new StudentAttendanceEntity();
        if (dto.getId() != null) {
            entity = repository.findById(dto.getId()).orElse(new StudentAttendanceEntity());
            // If ID provided but not found, treating as new or update logic?
            // Usually mapToEntity creates new instance unless fetched.
            // Simplified: create new instance and set fields.
            // But if updating, we should fetch existing relationships if not provided in
            // DTO?
            // DTO has all fields. So re-setting is fine.
            // Let's stick to creating/fetching fresh references.
            entity.setId(dto.getId());
        }

        if (dto.getStudentId() != null) {
            StudentEntity s = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + dto.getStudentId()));
            entity.setStudent(s);
        }

        if (dto.getStandardId() != null) {
            StandardEntity s = standardRepository.findById(dto.getStandardId())
                    .orElseThrow(() -> new ResourceNotFoundException("Standard not found: " + dto.getStandardId()));
            entity.setStandard(s);
        }

        if (dto.getSectionId() != null) {
            SectionEntity s = sectionRepository.findById(dto.getSectionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Section not found: " + dto.getSectionId()));
            entity.setSection(s);
        }

        entity.setAttendanceDate(dto.getAttendanceDate());
        if (dto.getStatus() != null) {
            entity.setStatus(StudentAttendanceEntity.AttendanceStatus.valueOf(dto.getStatus()));
        }

        if (dto.getMarkedBy() != null) {
            EmployeeMasterEntity e = employeeRepository.findById(dto.getMarkedBy())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + dto.getMarkedBy()));
            entity.setMarkedBy(e);
        }

        entity.setRemarks(dto.getRemarks());
        return entity;
    }
}
