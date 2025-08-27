package com.smartsolutions.eschool.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.student.facade.StudentAttendanceFacade;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    //  get all Student Attendance
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
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(studentAttendanceFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(id),
                "Student Attendance" ,
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
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
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        StudentAttendanceEntity nStudentAttendanceEntity = objectMapper.convertValue(attributes, StudentAttendanceEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",studentAttendanceFacade.create(nStudentAttendanceEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(nStudentAttendanceEntity.getAttendanceId()),
                "Student Attendance",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject update(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        StudentAttendanceEntity nStudentAttendanceEntity = objectMapper.convertValue(attributes, StudentAttendanceEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",studentAttendanceFacade.update(nStudentAttendanceEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(nStudentAttendanceEntity.getAttendanceId()),
                "Student Attendance",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",studentAttendanceFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "Student Attendance",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
