package com.smartsolutions.eschool.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.student.facade.StudentAttendanceFacade;
import com.smartsolutions.eschool.student.facade.StudentFacade;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import com.smartsolutions.eschool.util.SingleResourceSuccessResponseObject;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;
@Transactional
@RestController
@RequestMapping("/api/student/attendance")
public class StudentAttendanceController {
    private StudentAttendanceFacade studentAttendanceFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public StudentAttendanceController(StudentAttendanceFacade pStudentAttendanceFacade, ObjectMapper objectMapper) {
        this.studentAttendanceFacade = pStudentAttendanceFacade;
        this.objectMapper = objectMapper;
    }

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                studentAttendanceFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getStudentId()),
                                    "Student Attendance",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(studentAttendanceFacade.getById(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Student Attendance" ,
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/getbystudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByStudent(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                studentAttendanceFacade.getByStudent(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getStudentId()),
                                    "Student Attendance",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        StudentAttendanceEntity nStudentAttendanceEntity = objectMapper.convertValue(attributes, StudentAttendanceEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(studentAttendanceFacade.create(nStudentAttendanceEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nStudentAttendanceEntity.getAttendanceId()),
                "Student Attendance",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject update(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        StudentAttendanceEntity nStudentAttendanceEntity = objectMapper.convertValue(attributes, StudentAttendanceEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(studentAttendanceFacade.update(nStudentAttendanceEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nStudentAttendanceEntity.getAttendanceId()),
                "Student Attendance",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(studentAttendanceFacade.delete(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Student Attendance",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }
}
