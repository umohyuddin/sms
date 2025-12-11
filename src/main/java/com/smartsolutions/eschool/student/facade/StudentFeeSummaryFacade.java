package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.service.StudentFeeAssignmentService;
import com.smartsolutions.eschool.student.service.StudentFeeSummaryService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentFeeSummaryFacade {

    private final StudentFeeSummaryService studentFeeSummaryService;

    public StudentFeeSummaryFacade(StudentFeeSummaryService studentFeeSummaryService) {
        this.studentFeeSummaryService = studentFeeSummaryService;
    }


    public StudentFeeSummaryDTO getByStudentId(Long id) {
        return studentFeeSummaryService.getByStudentId(id);
    }

    public List<StudentFeeSummaryDTO> getAll() {
        return studentFeeSummaryService.getAll();
    }

    public StudentFeeSummaryDTO getByStudentFeeSummaryAcademicYear(Long studentId, Long academicYearId) {
        return studentFeeSummaryService.getByStudentFeeSummaryAcademicYear(studentId,academicYearId);
    }
}

