package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.dtos.attendance.AttendanceReportDTO;
import com.smartsolutions.eschool.student.dtos.attendance.AttendanceSummaryDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.student.error.StudentAttendanceErrors;
import com.smartsolutions.eschool.student.mapper.StudentAttendanceMapper;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.student.repository.StudentAttendanceRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentAttendanceService {

    private final StudentAttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final CampusRepository campusRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final InstituteRepository instituteRepository;

    public List<StudentAttendanceResponseDTO> search(Long campusId, Long standardId, Long sectionId, LocalDate date, String keyword) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] search() - org: {}, campus: {}, date: {}", organizationId, campusId, date);
        
        // 1. Fetch existing attendance records
        List<StudentAttendanceEntity> entities = attendanceRepository.searchAttendance(organizationId, campusId, standardId, sectionId, date, keyword);
        
        if (!entities.isEmpty()) {
            return StudentAttendanceMapper.toResponseDTOList(entities);
        }

        // 2. If no records and enough filters provided, perform "Roll Call"
        if (campusId != null && standardId != null && sectionId != null && date != null && (keyword == null || keyword.trim().isEmpty())) {
            log.info("[Service:StudentAttendanceService] search() - No records found. Loading Roll Call for section: {}", sectionId);
            List<com.smartsolutions.eschool.student.model.StudentEntity> students = studentRepository.searchStudentsWithFilters(
                    campusId, standardId, sectionId, null, null, null, organizationId);
            
            return students.stream()
                    .map(s -> StudentAttendanceMapper.mapToProtoResponse(s, date, organizationId))
                    .collect(java.util.stream.Collectors.toList());
        }

        return new ArrayList<>();
    }

    public StudentAttendanceResponseDTO getById(Long id) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] getById() called - id: {}, org: {}", id, organizationId);
        StudentAttendanceEntity entity = attendanceRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.ATTENDANCE_NOT_FOUND, HttpStatus.NOT_FOUND));
        return StudentAttendanceMapper.toResponseDTO(entity);
    }

    @Transactional
    public StudentAttendanceResponseDTO create(StudentAttendanceRequestDTO dto) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] create() called - student: {}, date: {}", dto.getStudentId(), dto.getAttendanceDate());

        if (attendanceRepository.existsByOrganizationIdAndStudentIdAndAttendanceDate(organizationId, dto.getStudentId(), dto.getAttendanceDate())) {
            // If already exists, we might want to update it instead of failing in a batch context, 
            // but for single create we throw error.
            throw new ApiException(StudentAttendanceErrors.DUPLICATE_ATTENDANCE, HttpStatus.CONFLICT);
        }

        StudentAttendanceEntity entity = mapAndSave(dto, organizationId);
        log.info("[Service:StudentAttendanceService] create() succeeded - id: {}", entity.getId());
        return StudentAttendanceMapper.toResponseDTO(entity);
    }

    @Transactional
    public List<StudentAttendanceResponseDTO> saveBatch(List<StudentAttendanceRequestDTO> dtos) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] saveBatch() called - count: {}", dtos.size());
        
        List<StudentAttendanceResponseDTO> results = new ArrayList<>();
        for (StudentAttendanceRequestDTO dto : dtos) {
            // For batch, if it exists, update it; if not, create it.
            Optional<StudentAttendanceEntity> existing = attendanceRepository.searchAttendance(
                    organizationId, dto.getCampusId(), dto.getStandardId(), dto.getSectionId(), dto.getAttendanceDate(), null)
                    .stream()
                    .filter(sa -> sa.getStudent().getId().equals(dto.getStudentId()))
                    .findFirst();
            
            StudentAttendanceEntity entity;
            if (existing.isPresent()) {
                entity = existing.get();
                StudentAttendanceMapper.updateEntityFromDTO(entity, dto);
                
                // Also update relationships if they changed (unlikely in batch but for safety)
                if (dto.getCampusId() != null && !dto.getCampusId().equals(entity.getCampus().getId())) {
                    entity.setCampus(campusRepository.getReferenceById(dto.getCampusId()));
                }
                if (dto.getStandardId() != null && !dto.getStandardId().equals(entity.getStandard().getId())) {
                    entity.setStandard(standardRepository.getReferenceById(dto.getStandardId()));
                }
                if (dto.getSectionId() != null && !dto.getSectionId().equals(entity.getSection().getId())) {
                    entity.setSection(sectionRepository.getReferenceById(dto.getSectionId()));
                }
            } else {
                entity = StudentAttendanceMapper.toEntity(dto);
                entity.setOrganization(instituteRepository.getReferenceById(organizationId));
                entity.setCampus(campusRepository.getReferenceById(dto.getCampusId()));
                entity.setStudent(studentRepository.getReferenceById(dto.getStudentId()));
                entity.setStandard(standardRepository.getReferenceById(dto.getStandardId()));
                entity.setSection(sectionRepository.getReferenceById(dto.getSectionId()));
            }
            
            if (dto.getMarkedById() != null) {
                entity.setMarkedBy(dto.getMarkedById());
            }
            
            StudentAttendanceEntity saved = attendanceRepository.save(entity);
            results.add(StudentAttendanceMapper.toResponseDTO(saved));
        }
        return results;
    }

    private StudentAttendanceEntity mapAndSave(StudentAttendanceRequestDTO dto, Long organizationId) {
        StudentAttendanceEntity entity = StudentAttendanceMapper.toEntity(dto);
        
        entity.setOrganization(instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN)));
        
        entity.setCampus(campusRepository.findById(dto.getCampusId())
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND)));
        
        entity.setStudent(studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.STUDENT_NOT_FOUND, HttpStatus.NOT_FOUND)));
        
        entity.setStandard(standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND)));
        
        entity.setSection(sectionRepository.findById(dto.getSectionId())
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.SECTION_NOT_FOUND, HttpStatus.NOT_FOUND)));

        if (dto.getMarkedById() != null) {
            entity.setMarkedBy(dto.getMarkedById());
        }

        return attendanceRepository.save(entity);
    }

    @Transactional
    public StudentAttendanceResponseDTO update(Long id, StudentAttendanceRequestDTO dto) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] update() called - id: {}", id);

        StudentAttendanceEntity existing = attendanceRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(StudentAttendanceErrors.ATTENDANCE_NOT_FOUND, HttpStatus.NOT_FOUND));

        StudentAttendanceMapper.updateEntityFromDTO(existing, dto);
        
        // Handle relationship updates if they changed
        if (dto.getCampusId() != null && !dto.getCampusId().equals(existing.getCampus().getId())) {
            existing.setCampus(campusRepository.findById(dto.getCampusId())
                    .orElseThrow(() -> new ApiException(StudentAttendanceErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND)));
        }
        if (dto.getStandardId() != null && !dto.getStandardId().equals(existing.getStandard().getId())) {
            existing.setStandard(standardRepository.findById(dto.getStandardId())
                    .orElseThrow(() -> new ApiException(StudentAttendanceErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND)));
        }
        if (dto.getSectionId() != null && !dto.getSectionId().equals(existing.getSection().getId())) {
            existing.setSection(sectionRepository.findById(dto.getSectionId())
                    .orElseThrow(() -> new ApiException(StudentAttendanceErrors.SECTION_NOT_FOUND, HttpStatus.NOT_FOUND)));
        }

        if (dto.getMarkedById() != null) {
             existing.setMarkedBy(dto.getMarkedById());
        }

        StudentAttendanceEntity saved = attendanceRepository.save(existing);
        log.info("[Service:StudentAttendanceService] update() succeeded - id: {}", id);
        return StudentAttendanceMapper.toResponseDTO(saved);
    }

    @Transactional
    public void softDelete(Long id) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] softDelete() called - id: {}", id);
        int rows = attendanceRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (rows == 0) {
            throw new ApiException(StudentAttendanceErrors.ATTENDANCE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public Map<String, Long> getStatistics(LocalDate date) {
        Long organizationId = getOrgId();
        log.info("[Service:StudentAttendanceService] getStatistics() called - date: {}", date);
        LocalDate targetDate = (date != null) ? date : LocalDate.now();
        
        Map<String, Long> stats = new HashMap<>();
        stats.put("present", attendanceRepository.countByOrganizationIdAndDateAndStatus(organizationId, targetDate, StudentAttendanceEntity.AttendanceStatus.PRESENT));
        stats.put("absent", attendanceRepository.countByOrganizationIdAndDateAndStatus(organizationId, targetDate, StudentAttendanceEntity.AttendanceStatus.ABSENT));
        stats.put("leave", attendanceRepository.countByOrganizationIdAndDateAndStatus(organizationId, targetDate, StudentAttendanceEntity.AttendanceStatus.LEAVE));
        
        return stats;
    }

    public AttendanceReportDTO getDetailedReport(Long campusId, Long standardId, LocalDate date) {
        Long organizationId = getOrgId();
        LocalDate targetDate = (date != null) ? date : LocalDate.now();
        log.info("[Service:StudentAttendanceService] getDetailedReport() called - org: {}, campus: {}, standard: {}, date: {}", 
                organizationId, campusId, standardId, targetDate);

        AttendanceReportDTO report = new AttendanceReportDTO();
        report.setLevel("ORGANIZATION");
        report.setLevelId(organizationId);
        
        List<Object[]> statsData;
        Map<Long, AttendanceSummaryDTO> summaryMap = new HashMap<>();

        if (standardId != null) {
            report.setLevel("STANDARD");
            report.setLevelId(standardId);
            statsData = attendanceRepository.getSectionLevelStats(organizationId, standardId, targetDate);
            report.setLevelName("Standard Report"); 
        } else if (campusId != null) {
            report.setLevel("CAMPUS");
            report.setLevelId(campusId);
            statsData = attendanceRepository.getStandardLevelStats(organizationId, campusId, targetDate);
            report.setLevelName("Campus Report");
        } else {
            statsData = attendanceRepository.getCampusLevelStats(organizationId, targetDate);
            report.setLevelName("Organization Report");
        }

        long grandPresent = 0, grandAbsent = 0, grandLeave = 0;

        for (Object[] row : statsData) {
            Long id = (Long) row[0];
            StudentAttendanceEntity.AttendanceStatus status = (StudentAttendanceEntity.AttendanceStatus) row[1];
            long count = (Long) row[2];

            AttendanceSummaryDTO summary = summaryMap.computeIfAbsent(id, k -> AttendanceSummaryDTO.builder().id(k).name("ID: " + k).build());
            
            if (status == StudentAttendanceEntity.AttendanceStatus.PRESENT) {
                summary.setPresentCount(count);
                grandPresent += count;
            } else if (status == StudentAttendanceEntity.AttendanceStatus.ABSENT) {
                summary.setAbsentCount(count);
                grandAbsent += count;
            } else if (status == StudentAttendanceEntity.AttendanceStatus.LEAVE) {
                summary.setLeaveCount(count);
                grandLeave += count;
            }
            
            summary.setTotalCount(summary.getPresentCount() + summary.getAbsentCount() + summary.getLeaveCount());
            if (summary.getTotalCount() > 0) {
                summary.setAttendancePercentage((double) summary.getPresentCount() / summary.getTotalCount() * 100);
            }
        }

        report.setTotalPresent(grandPresent);
        report.setTotalAbsent(grandAbsent);
        report.setTotalLeave(grandLeave);
        report.setTotalStudents(grandPresent + grandAbsent + grandLeave);
        
        if (report.getTotalStudents() > 0) {
            report.setPresentPercentage((double) grandPresent / report.getTotalStudents() * 100);
            report.setAbsentPercentage((double) grandAbsent / report.getTotalStudents() * 100);
            report.setLeavePercentage((double) grandLeave / report.getTotalStudents() * 100);
        }

        report.setDetails(new ArrayList<>(summaryMap.values()));
        return report;
    }

    private Long getOrgId() {
        Long id = SecurityUtils.getCurrentOrganizationId();
        if (id == null) {
            throw new ApiException(StudentAttendanceErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        return id;
    }
}
