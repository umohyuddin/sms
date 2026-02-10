package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.academic.dto.request.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.StudentAttendanceEntity;
import com.smartsolutions.eschool.academic.mapper.AttendanceMapper;
import com.smartsolutions.eschool.academic.repository.StudentAttendanceRepository;
import com.smartsolutions.eschool.academic.service.StudentAttendanceService;
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
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    private final StudentAttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final EmployeeMasterRepository employeeRepository;

    @Override
    @Transactional
    public void markAttendance(List<StudentAttendanceRequestDTO> dtos) {
        log.info("Marking student attendance for {} records", dtos.size());
        for (StudentAttendanceRequestDTO dto : dtos) {
            StudentEntity student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + dto.getStudentId()));
            StandardEntity standard = standardRepository.findById(dto.getStandardId())
                    .orElseThrow(() -> new ResourceNotFoundException("Standard not found: " + dto.getStandardId()));
            SectionEntity section = sectionRepository.findById(dto.getSectionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Section not found: " + dto.getSectionId()));
            
            StudentAttendanceEntity entity = AttendanceMapper.toEntity(dto);
            entity.setStudent(student);
            entity.setStandard(standard);
            entity.setSection(section);
            
            if (dto.getMarkedById() != null) {
                EmployeeMasterEntity marker = employeeRepository.findById(dto.getMarkedById())
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + dto.getMarkedById()));
                entity.setMarkedBy(marker);
            }
            
            attendanceRepository.save(entity);
        }
    }

    @Override
    public List<StudentAttendanceResponseDTO> getSectionAttendance(Long standardId, Long sectionId, LocalDate date) {
        return attendanceRepository.findByStandardSectionAndDate(standardId, sectionId, date).stream()
                .map(AttendanceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentAttendanceResponseDTO> getStudentMonthlyView(Long studentId, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return attendanceRepository.findMonthlyView(studentId, startDate, endDate).stream()
                .map(AttendanceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting Student Attendance ID: {}", id);
        if (!attendanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Attendance record not found");
        }
        attendanceRepository.softDeleteById(id);
    }
}
