package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.sms.academic.dto.request.TimetableRequestDTO;
import com.smartsolutions.sms.academic.dto.response.TimetableResponseDTO;
import com.smartsolutions.sms.academic.entity.master.SubjectEntity;
import com.smartsolutions.sms.academic.entity.master.TimetableEntity;
import com.smartsolutions.sms.academic.mapper.TeacherAssignmentMapper;
import com.smartsolutions.sms.academic.repository.SubjectRepository;
import com.smartsolutions.sms.academic.repository.TimetableRepository;
import com.smartsolutions.sms.academic.service.TimetableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;
    private final EmployeeMasterRepository employeeRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherAssignmentMapper teacherMapper;

    @Override
    @Transactional
    public TimetableResponseDTO create(TimetableRequestDTO dto) {
        log.info("Creating Timetable entry for Standard {} Section {}", dto.getStandardId(), dto.getSectionId());
        
        // Basic presence checks
        StandardEntity standard = standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found: " + dto.getStandardId()));
        SectionEntity section = sectionRepository.findById(dto.getSectionId())
                .orElseThrow(() -> new ResourceNotFoundException("Section not found: " + dto.getSectionId()));
        SubjectEntity subject = subjectRepository.findActiveById(dto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found: " + dto.getSubjectId()));
        EmployeeMasterEntity teacher = employeeRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found: " + dto.getTeacherId()));

        // Conflict check logic could be added here
        
        TimetableEntity entity = teacherMapper.toEntity(dto);
        entity.setStandard(standard);
        entity.setSection(section);
        entity.setSubject(subject);
        entity.setTeacher(teacher);
        
        TimetableEntity saved = timetableRepository.save(entity);
        return teacherMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public TimetableResponseDTO update(Long id, TimetableRequestDTO dto) {
        log.info("Updating Timetable ID: {}", id);
        TimetableEntity entity = timetableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Timetable entry not found with ID: " + id));
        
        entity.setDayOfWeek(dto.getDayOfWeek());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setRoom(dto.getRoom());
        
        // Update relations if changed...
        
        TimetableEntity updated = timetableRepository.save(entity);
        return teacherMapper.toResponse(updated);
    }

    @Override
    public List<TimetableResponseDTO> getSectionTimetable(Long standardId, Long sectionId) {
        return timetableRepository.findByStandardAndSection(standardId, sectionId).stream()
                .map(teacherMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<TimetableResponseDTO> getTeacherTimetable(Long teacherId, TimetableEntity.DayOfWeek day) {
        return timetableRepository.findTeacherTimetableByDay(teacherId, day).stream()
                .map(teacherMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting Timetable entry ID: {}", id);
        if (!timetableRepository.existsById(id)) {
            throw new ResourceNotFoundException("Timetable entry not found with ID: " + id);
        }
        timetableRepository.softDeleteById(id);
    }
}
