package com.smartsolutions.eschool.employee.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.facade.EmployeeFacade;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
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
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeFacade employeeFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public EmployeeController(EmployeeFacade employeeFacade, ObjectMapper objectMapper) {
        this.employeeFacade = employeeFacade;
        this.objectMapper = objectMapper;
    }

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                employeeFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{emp_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long emp_id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeFacade.getById(emp_id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                String.valueOf(emp_id),
                                "Employee",
                                resourceAttributes
                        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/getbycampus/{cmp_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByCampus(@PathVariable Long cmp_id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                employeeFacade.getByCampus(cmp_id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/getbyinst/{inst_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByInstitute(@PathVariable Long inst_id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                employeeFacade.getByInstitute(inst_id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee",
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
        EmployeeEntity nEmployeeEntity = objectMapper.convertValue(attributes, EmployeeEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",employeeFacade.create(nEmployeeEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                nEmployeeEntity.getFirstName(),
                                "Employee",
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
        EmployeeEntity nEmployeeEntity = objectMapper.convertValue(attributes, EmployeeEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",employeeFacade.update(nEmployeeEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nEmployeeEntity.getId()),
                                    "Employee",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{emp_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long emp_id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",employeeFacade.delete(emp_id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(emp_id),
                                    "Employee",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
