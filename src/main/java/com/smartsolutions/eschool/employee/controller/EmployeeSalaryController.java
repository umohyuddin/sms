package com.smartsolutions.eschool.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.facade.EmployeeSalaryFaced;
import com.smartsolutions.eschool.employee.model.EmployeeSalaryEntity;
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
@RequestMapping("/api/employee/salary")
public class EmployeeSalaryController {

    private EmployeeSalaryFaced employeeSalaryFaced;
    private ObjectMapper objectMapper;
    @Autowired
    public EmployeeSalaryController(EmployeeSalaryFaced employeeSalaryFaced, ObjectMapper objectMapper) {
        this.employeeSalaryFaced = employeeSalaryFaced;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                employeeSalaryFaced.getAll()
                        .stream()
                        .map(EmployeeSalaryEntity -> objectMapper.convertValue(EmployeeSalaryEntity, ResourceObject.class))
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeSalaryFaced.getById(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Employee Salary",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/get/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByEmpId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                employeeSalaryFaced.getByEmpId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee Salary",
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
        EmployeeSalaryEntity nEmployeeSalaryEntity = objectMapper.convertValue(attributes, EmployeeSalaryEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeSalaryFaced.create(nEmployeeSalaryEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nEmployeeSalaryEntity.getEmpId()),
                "Employee Salary",
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
        EmployeeSalaryEntity nEmployeeSalaryEntity = objectMapper.convertValue(attributes, EmployeeSalaryEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeSalaryFaced.update(nEmployeeSalaryEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nEmployeeSalaryEntity.getId()),
                "Employee Salary",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeSalaryFaced.delete(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Employee Role",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }
}
