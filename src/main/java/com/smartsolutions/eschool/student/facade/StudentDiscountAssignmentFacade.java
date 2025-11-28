package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto.StudentDiscountAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.responseDto.StudentDiscountAssignmentResponseDTO;
import com.smartsolutions.eschool.student.service.StudentDiscountAssignmentService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentDiscountAssignmentFacade {

    private final StudentDiscountAssignmentService studentDiscountService;

    public StudentDiscountAssignmentFacade(StudentDiscountAssignmentService studentDiscountService) {
        this.studentDiscountService = studentDiscountService;
    }

    // -------------------------------------------------------------------------
    // CREATE / ASSIGN DISCOUNT
    // -------------------------------------------------------------------------
    public StudentDiscountAssignmentResponseDTO assignDiscount(@Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        return studentDiscountService.assignDiscount(requestDTO);
    }

    // -------------------------------------------------------------------------
    // GET ALL ASSIGNMENTS
    // -------------------------------------------------------------------------
    public List<StudentDiscountAssignmentResponseDTO> getAll() {
        return studentDiscountService.getAll();
    }

    // -------------------------------------------------------------------------
    // GET BY ID
    // -------------------------------------------------------------------------
    public StudentDiscountAssignmentResponseDTO getById(Long assignmentId) {
        return studentDiscountService.getById(assignmentId);
    }

    // -------------------------------------------------------------------------
    // GET BY STUDENT
    // -------------------------------------------------------------------------
    public List<StudentDiscountAssignmentResponseDTO> getByStudent(Long studentId) {
        return studentDiscountService.getByStudent(studentId);
    }

    // -------------------------------------------------------------------------
    // UPDATE ASSIGNMENT
    // -------------------------------------------------------------------------
    public StudentDiscountAssignmentResponseDTO updateAssignment(Long assignmentId, @Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        return studentDiscountService.updateAssignment(assignmentId, requestDTO);
    }

    // -------------------------------------------------------------------------
    // SOFT DELETE
    // -------------------------------------------------------------------------
    public int softDelete(Long assignmentId) {
        return studentDiscountService.softDelete(assignmentId);
    }

    // -------------------------------------------------------------------------
    // SOFT DELETE ALL
    // -------------------------------------------------------------------------
    public int softDeleteAll() {
        return studentDiscountService.softDeleteAll();
    }

    // -------------------------------------------------------------------------
    // ACTIVATE
    // -------------------------------------------------------------------------
    public int markAsActive(Long assignmentId) {
        return studentDiscountService.markAsActive(assignmentId);
    }

    // -------------------------------------------------------------------------
    // DEACTIVATE
    // -------------------------------------------------------------------------
    public int markAsInactive(Long assignmentId) {
        return studentDiscountService.markAsInactive(assignmentId);
    }

//    // -------------------------------------------------------------------------
//    // SEARCH
//    // -------------------------------------------------------------------------
//    public List<StudentDiscountResponseDTO> search(String keyword) {
//        return studentDiscountService.search(keyword);
//    }
}
