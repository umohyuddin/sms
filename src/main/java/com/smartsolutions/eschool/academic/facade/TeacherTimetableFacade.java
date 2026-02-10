package com.smartsolutions.eschool.academic.facade;

import com.smartsolutions.eschool.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.TimetableRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.TimetableResponseDTO;
import com.smartsolutions.eschool.academic.entity.master.TimetableEntity;
import com.smartsolutions.eschool.academic.service.TeacherSubjectAssignmentService;
import com.smartsolutions.eschool.academic.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class TeacherTimetableFacade {

    private final TeacherSubjectAssignmentService teacherAssignmentService;
    private final TimetableService timetableService;

    // Teacher Assignment
    public TeacherSubjectAssignmentResponseDTO assignTeacher(TeacherSubjectAssignmentRequestDTO dto) { return teacherAssignmentService.assign(dto); }
    public List<TeacherSubjectAssignmentResponseDTO> getByTeacher(Long employeeId) { return teacherAssignmentService.getByTeacher(employeeId); }
    public List<TeacherSubjectAssignmentResponseDTO> getBySection(Long standardId, Long sectionId, Long academicYearId) { return teacherAssignmentService.getBySection(standardId, sectionId, academicYearId); }
    public void unassignTeacher(Long employeeId, Long standardId, Long sectionId, Long subjectId, Long academicYearId, LocalDate effectiveFrom) { 
        teacherAssignmentService.unassign(employeeId, standardId, sectionId, subjectId, academicYearId, effectiveFrom); 
    }

    // Timetable
    public TimetableResponseDTO createTimetable(TimetableRequestDTO dto) { return timetableService.create(dto); }
    public TimetableResponseDTO updateTimetable(Long id, TimetableRequestDTO dto) { return timetableService.update(id, dto); }
    public List<TimetableResponseDTO> getSectionTimetable(Long standardId, Long sectionId) { return timetableService.getSectionTimetable(standardId, sectionId); }
    public List<TimetableResponseDTO> getTeacherTimetable(Long teacherId, TimetableEntity.DayOfWeek day) { return timetableService.getTeacherTimetable(teacherId, day); }
    public void deleteTimetable(Long id) { timetableService.delete(id); }
}
