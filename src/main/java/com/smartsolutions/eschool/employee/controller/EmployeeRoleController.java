package com.smartsolutions.eschool.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.facade.EmployeeRoleFacade;
import com.smartsolutions.eschool.employee.model.EmployeeRoleEntity;
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
@RequestMapping("/api/employee/role")
public class EmployeeRoleController {

    private EmployeeRoleFacade employeeRoleFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public EmployeeRoleController(EmployeeRoleFacade employeeRoleFacade, ObjectMapper objectMapper) {
        this.employeeRoleFacade = employeeRoleFacade;
        this.objectMapper = objectMapper;
    }

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                employeeRoleFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Employee Role",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(employeeRoleFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                String.valueOf(id),
                                "Employee Role",
                                resourceAttributes
                        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        EmployeeRoleEntity nEmployeeRoleEntity = objectMapper.convertValue(attributes, EmployeeRoleEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",employeeRoleFacade.create(nEmployeeRoleEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    nEmployeeRoleEntity.getName(),
                                    "Employee Role",
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
        EmployeeRoleEntity nEmployeeRoleEntity = objectMapper.convertValue(attributes, EmployeeRoleEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",employeeRoleFacade.update(nEmployeeRoleEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nEmployeeRoleEntity.getId()),
                                    "Employee Role",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",employeeRoleFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Employee Role",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }


}
