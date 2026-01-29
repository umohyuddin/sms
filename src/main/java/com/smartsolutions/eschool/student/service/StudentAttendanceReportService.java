package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.student.dtos.studentAttendance.response.*;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.student.repository.StudentAttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentAttendanceReportService {

    private final StudentAttendanceRepository repository;

    public List<DailyAttendanceReportDTO> getDailyAttendance(LocalDate date) {
        return repository.getDailyAttendance(date);
    }

    public List<ClassAttendanceReportDTO> getClassAttendance(Long standardId, Long sectionId, LocalDate startDate, LocalDate endDate) {
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
            throw new RuntimeException("Attendance record not found with id: " + dto.getId());
        }
        StudentAttendanceEntity entity = mapToEntity(dto);
        entity = repository.save(entity);
        return mapToDTO(entity);
    }

    public void deleteAttendance(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Attendance record not found with id: " + id);
        }
        repository.deleteById(id);
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
        return repository.countByStudentAndStatus(studentId, "PRESENT", startDate, endDate);
    }

    public long countAbsent(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.countByStudentAndStatus(studentId, "ABSENT", startDate, endDate);
    }

    public long countLeave(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.countByStudentAndStatus(studentId, "LEAVE", startDate, endDate);
    }

    // ----------------- Mapping Methods -----------------
    private StudentAttendanceDTO mapToDTO(StudentAttendanceEntity entity) {
        return new StudentAttendanceDTO(
                entity.getId(),
                entity.getStudentId(),
                entity.getStandardId(),
                entity.getSectionId(),
                entity.getAttendanceDate(),
                entity.getStatus().name(),
                entity.getMarkedBy(),
                entity.getRemarks()
        );
    }

    private StudentAttendanceEntity mapToEntity(StudentAttendanceDTO dto) {
        StudentAttendanceEntity entity = new StudentAttendanceEntity();
        entity.setId(dto.getId());
        entity.setStudentId(dto.getStudentId());
        entity.setStandardId(dto.getStandardId());
        entity.setSectionId(dto.getSectionId());
        entity.setAttendanceDate(dto.getAttendanceDate());
        entity.setStatus(StudentAttendanceEntity.AttendanceStatus.valueOf(dto.getStatus()));
        entity.setMarkedBy(dto.getMarkedBy());
        entity.setRemarks(dto.getRemarks());
        return entity;
    }

}
