package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
import com.smartsolutions.eschool.student.service.StudentFeeAssignmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class StudentFeeAssignmentFacade {

    private final StudentFeeAssignmentService studentFeeAssignmentService;

    public StudentFeeAssignmentFacade(StudentFeeAssignmentService studentFeeAssignmentService) {
        this.studentFeeAssignmentService = studentFeeAssignmentService;
    }

    public StudentFeeSummaryDTO assignStudentFee(Long id, @Valid StudentFeeAssignmentRequestDTO dto) {
        log.info("[Facade:StudentFeeAssignmentFacade] assignStudentFee() called - studentId={}, academicYearId={}", id, dto.getAcademicYearId());
        return studentFeeAssignmentService.assignStudentFee(id, dto);
    }

    public StudentFeeSummaryDTO updateStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {
        log.info("[Facade:StudentFeeAssignmentFacade] updateStudentFee() called - studentId={}, academicYearId={}", studentId, dto.getAcademicYearId());
        return studentFeeAssignmentService.updateStudentFee(studentId, dto);
    }

    public StudentFeeAssignmentsResponseDTO getFeeAssignmentByStudentId(Long studentId, Long academicYearId) {
        log.info("[Facade:StudentFeeAssignmentFacade] getFeeAssignmentByStudentId() called - studentId={}, academicYearId={}", studentId, academicYearId);
        return studentFeeAssignmentService.getFeeAssignmentByStudentId(studentId, academicYearId);
    }

    public BigDecimal getTotalFeeAssigned(Long academicYearId) {
        log.info("[Facade:StudentFeeAssignmentFacade] getTotalFeeAssigned() called - academicYearId={}", academicYearId);
        return studentFeeAssignmentService.getTotalFeeAssigned(academicYearId);
    }

    public boolean hasAssignedFees(Long studentId, Long academicYearId) {
        log.info("[Facade:StudentFeeAssignmentFacade] hasAssignedFees() called - studentId={}, academicYearId={}", studentId, academicYearId);
        return studentFeeAssignmentService.isFeeAssigned(studentId, academicYearId);
    }

    public List<StudentFeeAssignmentFlatDTO> getAssignedFeesFlat(Long studentId, Long academicYearId) {
        log.info("[Facade:StudentFeeAssignmentFacade] getAssignedFeesFlat() called - studentId={}, academicYearId={}", studentId, academicYearId);
        return studentFeeAssignmentService.getAssignedFeesForStudent(studentId, academicYearId);
    }

    public List<StudentFeeAssignmentFlatDTO> getAllAssignments() {
        log.info("[Facade:StudentFeeAssignmentFacade] getAllAssignments() called");
        return studentFeeAssignmentService.getAllAssignments();
    }

    public List<StudentFeeAssignmentFlatDTO> searchAssignments(String keyword) {
        log.info("[Facade:StudentFeeAssignmentFacade] searchAssignments() called - keyword: {}", keyword);
        return studentFeeAssignmentService.searchAssignments(keyword);
    }

    public Map<String, Object> getStatistics() {
        log.info("[Facade:StudentFeeAssignmentFacade] getStatistics() called");
        return studentFeeAssignmentService.getStatistics();
    }

    public void deleteAssignment(Long assignmentId) {
        log.info("[Facade:StudentFeeAssignmentFacade] deleteAssignment() called - assignmentId: {}", assignmentId);
        studentFeeAssignmentService.deleteAssignment(assignmentId);
    }
}

