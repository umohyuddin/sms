package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.TimetableRequestDTO;
import com.smartsolutions.sms.academic.dto.response.TimetableResponseDTO;
import com.smartsolutions.sms.academic.entity.master.TimetableEntity;

import java.util.List;

public interface TimetableService {
    TimetableResponseDTO create(TimetableRequestDTO dto);
    TimetableResponseDTO update(Long id, TimetableRequestDTO dto);
    List<TimetableResponseDTO> getSectionTimetable(Long standardId, Long sectionId);
    List<TimetableResponseDTO> getTeacherTimetable(Long teacherId, TimetableEntity.DayOfWeek day);
    void delete(Long id);
}
