package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
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
@RequestMapping("/api/student/fee/assignment")
@Slf4j
public class StudentFeeAssignmentController {

private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;

    public StudentFeeAssignmentController(StudentFeeAssignmentFacade studentFeeAssignmentFacade) {
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
    }

    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSection(@PathVariable Long id, @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {

        log.info("Received request to Student Fee Assignment for student Id: {}", requestDTO.getStudentId());
        StudentFeeAssignmentRequestDTO createdSection = studentFeeAssignmentFacade.assignStudentFee(id,requestDTO);
        log.info("Student Fee Assignment created successfully with id: {}", createdSection.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSection);
    }
}
