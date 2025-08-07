package com.smartsolutions.eschool.school.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.DepartmentFacade;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
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
@RequestMapping("/api/schools/department")
public class DepartmentController {


    private DepartmentFacade nDepartmentFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public DepartmentController(DepartmentFacade pDepartmentFacade, ObjectMapper objectMapper) {
        this.nDepartmentFacade = pDepartmentFacade;
        this.objectMapper = objectMapper;
    }

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nDepartmentFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCampusId()),
                                    "Department",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nDepartmentFacade.getById(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Department",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        DepartmentEntity nDepartmentEntity = objectMapper.convertValue(attributes, DepartmentEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nDepartmentFacade.create(nDepartmentEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                nDepartmentEntity.getDepartmentName(),
                "Department",
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
        DepartmentEntity nDepartmentEntity = objectMapper.convertValue(attributes, DepartmentEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nDepartmentFacade.update(nDepartmentEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nDepartmentEntity.getDepartmentName()),
                "Department",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nDepartmentFacade.delete(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Department",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }
}
