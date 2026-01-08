package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeAssignmentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
import com.smartsolutions.eschool.student.service.StudentFeeAssignmentService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentFeeAssignmentFacade {

    private StudentFeeAssignmentService studentFeeAssignmentService;

    public StudentFeeAssignmentFacade(StudentFeeAssignmentService studentFeeAssignmentService) {
        this.studentFeeAssignmentService = studentFeeAssignmentService;
    }

    public StudentFeeSummaryDTO assignStudentFee(Long id, @Valid StudentFeeAssignmentRequestDTO dto) {
        return studentFeeAssignmentService.assignStudentFee(id, dto);
    }

    public StudentFeeSummaryDTO updateStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {
        return studentFeeAssignmentService.updateStudentFee(studentId, dto);
    }
    public StudentFeeAssignmentsResponseDTO getFeeAssignmentByStudentId(Long studentId, Long academicYearId) {
        return studentFeeAssignmentService.getFeeAssignmentByStudentId(studentId, academicYearId);
    }

    public Double getTotalFeeAssigned(Long academicYearId) {
        return studentFeeAssignmentService.getTotalFeeAssigned(academicYearId);
    }

    public boolean hasAssignedFees(Long studentId, Long academicYearId) {
        return studentFeeAssignmentService.isFeeAssigned(studentId, academicYearId);
    }

    public List<StudentFeeAssignmentFlatDTO> getAssignedFeesFlat(Long studentId, Long academicYearId) {
        return studentFeeAssignmentService.getAssignedFeesForStudent(studentId, academicYearId // service will handle fetching current year if null
        );
    }

}

