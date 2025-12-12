package com.smartsolutions.eschool.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.facade.FeeParticularsFacade;
import com.smartsolutions.eschool.student.facade.StudentFeeSummaryFacade;
import com.smartsolutions.eschool.student.model.FeeParticularsEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentFeeSummaryController {
    private final StudentFeeSummaryFacade studentFeeSummaryFacade;

    public StudentFeeSummaryController(StudentFeeSummaryFacade studentFeeSummaryFacade) {
        this.studentFeeSummaryFacade = studentFeeSummaryFacade;
    }

    @GetMapping(value = "/fee/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/rates called");
        List<StudentFeeSummaryDTO> resources = studentFeeSummaryFacade.getAll();
        log.info("GET /api/fee/rates succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{studentId}/fee/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long studentId) throws Exception {
        log.info("Received request to fetch Fee rate with id: {}", studentId);
        StudentFeeSummaryDTO studentFeeSummaryDTO = studentFeeSummaryFacade.getByStudentId(studentId);
        log.info("Returning Fee rate: id={}", studentFeeSummaryDTO.getStudentId());
        return ResponseEntity.ok(studentFeeSummaryDTO);
    }

    @GetMapping(value = "/fee/summary/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFeeSummary(@RequestParam Long studentId, @RequestParam Long academicYearId) throws Exception {
        log.info("Received request to fetch Fee summary for studentId: {} and academicYearId: {}", studentId, academicYearId);
        StudentFeeSummaryResponseDto studentFeeSummaryDTO = studentFeeSummaryFacade.getByStudentFeeSummaryAcademicYear(studentId, academicYearId);
        log.info("Returning Fee summary for studentId={} and academicYearId={}", studentId, academicYearId);
        return ResponseEntity.ok(studentFeeSummaryDTO);
    }

}
