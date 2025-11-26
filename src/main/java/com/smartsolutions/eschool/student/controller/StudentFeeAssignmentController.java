package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeAssignmentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.facade.FeeRateFacade;
import com.smartsolutions.eschool.student.facade.StudentFeeAssignmentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentFeeAssignmentController {

private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;

    public StudentFeeAssignmentController(StudentFeeAssignmentFacade studentFeeAssignmentFacade) {
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
    }

    @PostMapping( value = "/{studentId}/fees/assign",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSection(@PathVariable Long studentId, @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {

        log.info("Received request to Student Fee Assignment for student Id: {}", studentId);
        StudentFeeSummaryDTO studentFeeSummaryDTO = studentFeeAssignmentFacade.assignStudentFee(studentId,requestDTO);
        log.info("Student Fee Assignment created successfully with id: {}", studentFeeSummaryDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(studentFeeSummaryDTO);
    }

    @GetMapping(value = "/{studentId}/fees/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long studentId, @PathVariable Long academicYearId) {
        log.info("GET /api/student/fee/assignment by Student id called");
        StudentFeeAssignmentsResponseDTO feeAssignmentByStudentId  = studentFeeAssignmentFacade.getFeeAssignmentByStudentId(studentId,academicYearId);
        log.info("GET /api/student/fee/assignment by Student id succeeded");
        return ResponseEntity.ok().body(feeAssignmentByStudentId);
    }
}
