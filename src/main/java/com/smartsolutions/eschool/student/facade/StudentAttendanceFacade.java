package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.attendance.AttendanceReportDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.student.service.StudentAttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class StudentAttendanceFacade {

    private final StudentAttendanceService attendanceService;

    public List<StudentAttendanceResponseDTO> search(Long campusId, Long standardId, Long sectionId, LocalDate date, String keyword) {
        log.info("[Facade:StudentAttendanceFacade] search() called");
        return attendanceService.search(campusId, standardId, sectionId, date, keyword);
    }

    public StudentAttendanceResponseDTO getById(Long id) {
        log.info("[Facade:StudentAttendanceFacade] getById() called - id: {}", id);
        return attendanceService.getById(id);
    }

    public StudentAttendanceResponseDTO create(StudentAttendanceRequestDTO dto) {
        log.info("[Facade:StudentAttendanceFacade] create() called");
        return attendanceService.create(dto);
    }

    public List<StudentAttendanceResponseDTO> saveBatch(List<StudentAttendanceRequestDTO> dtos) {
        log.info("[Facade:StudentAttendanceFacade] saveBatch() called - count: {}", dtos.size());
        return attendanceService.saveBatch(dtos);
    }

    public StudentAttendanceResponseDTO update(Long id, StudentAttendanceRequestDTO dto) {
        log.info("[Facade:StudentAttendanceFacade] update() called - id: {}", id);
        return attendanceService.update(id, dto);
    }

    public void softDelete(Long id) {
        log.info("[Facade:StudentAttendanceFacade] softDelete() called - id: {}", id);
        attendanceService.softDelete(id);
    }

    public Map<String, Long> getStatistics(LocalDate date) {
        log.info("[Facade:StudentAttendanceFacade] getStatistics() called");
        return attendanceService.getStatistics(date);
    }

    public AttendanceReportDTO getDetailedReport(Long campusId, Long standardId, LocalDate date) {
        log.info("[Facade:StudentAttendanceFacade] getDetailedReport() called");
        return attendanceService.getDetailedReport(campusId, standardId, date);
    }
}
