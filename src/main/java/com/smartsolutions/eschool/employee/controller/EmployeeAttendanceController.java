package com.smartsolutions.eschool.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.facade.EmployeeAttendanceFacade;
import com.smartsolutions.eschool.employee.model.EmployeeAttendanceEntity;
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
@RequestMapping("/api/employee/attendance")
public class EmployeeAttendanceController {

    private EmployeeAttendanceFacade employeeAttendanceFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public EmployeeAttendanceController(EmployeeAttendanceFacade employeeAttendanceFacade, ObjectMapper objectMapper) {
        this.employeeAttendanceFacade = employeeAttendanceFacade;
        this.objectMapper = objectMapper;
    }
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                employeeAttendanceFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee Attendance",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeAttendanceFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Employee Salary",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/get/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByEmpId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                employeeAttendanceFacade.getByEmpId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee Attendance",
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
        EmployeeAttendanceEntity nEmployeeAttendanceEntity = objectMapper.convertValue(attributes, EmployeeAttendanceEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",employeeAttendanceFacade.create(nEmployeeAttendanceEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nEmployeeAttendanceEntity.getEmpId()),
                                    "Employee Attendance",
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
        EmployeeAttendanceEntity nEmployeeAttendanceEntity = objectMapper.convertValue(attributes, EmployeeAttendanceEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",employeeAttendanceFacade.update(nEmployeeAttendanceEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                String.valueOf(nEmployeeAttendanceEntity.getId()),
                                "Employee Attendance",
                                resourceAttributes
                        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",employeeAttendanceFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                String.valueOf(id),
                                "Employee Attendance",
                                resourceAttributes
                        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

}
