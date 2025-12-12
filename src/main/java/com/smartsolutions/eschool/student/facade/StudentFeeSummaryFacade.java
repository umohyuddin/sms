package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import com.smartsolutions.eschool.student.repository.StudentFeePaymentsRepository;
import com.smartsolutions.eschool.student.service.StudentFeeAssignmentService;
import com.smartsolutions.eschool.student.service.StudentFeePaymentsService;
import com.smartsolutions.eschool.student.service.StudentFeeSummaryService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentFeeSummaryFacade {

    private final StudentFeeSummaryService studentFeeSummaryService;
    private final StudentFeePaymentsService studentFeePaymentsService;

    public StudentFeeSummaryFacade(StudentFeeSummaryService studentFeeSummaryService, StudentFeePaymentsService studentFeePaymentsService) {
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.studentFeePaymentsService = studentFeePaymentsService;
    }


    public StudentFeeSummaryDTO getByStudentId(Long id) {
        return studentFeeSummaryService.getByStudentId(id);
    }

    public List<StudentFeeSummaryDTO> getAll() {
        return studentFeeSummaryService.getAll();
    }

    public StudentFeeSummaryDTO getByStudentFeeSummaryAcademicYear(Long studentId, Long academicYearId) {
        List<StudentFeePaymentResponseDTO> responseDTOS = studentFeePaymentsService.getStudentPaymentsByAcademicYear(studentId, academicYearId);
        StudentFeeSummaryDTO studentFeeSummaryDTO = studentFeeSummaryService.getByStudentFeeSummaryAcademicYear(studentId, academicYearId);
        studentFeeSummaryDTO.setStudentFeePaymentsList(responseDTOS);
        return studentFeeSummaryDTO;
    }
}

