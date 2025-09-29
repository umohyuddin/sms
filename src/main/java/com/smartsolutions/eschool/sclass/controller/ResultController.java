package com.smartsolutions.eschool.sclass.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.sclass.facade.ResultFacade;
import com.smartsolutions.eschool.sclass.model.ResultEntity;
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
@RequestMapping("/api/class/result")
public class ResultController {

    private ResultFacade nResultFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public ResultController(ResultFacade pResultFacade, ObjectMapper objectMapper) {
        this.nResultFacade = pResultFacade;
        this.objectMapper = objectMapper;
    }

    //  get all course
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nResultFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "result",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get Course by ID
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nResultFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(id),
                "result",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/getbysubjectid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getBySubjectId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                nResultFacade.getBySubjectId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "result",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/getbyclassid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByClassId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                nResultFacade.getByClassId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "result",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/getbystudentid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByStudentId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                nResultFacade.getByStudentId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "result",
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
        ResultEntity nResultEntity = objectMapper.convertValue(attributes, ResultEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message", nResultFacade.create(nResultEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(nResultEntity.getId()),
                "result",
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
        ResultEntity nResultEntity = objectMapper.convertValue(attributes, ResultEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message", nResultFacade.update(nResultEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(nResultEntity.getId()),
                "result ",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message", nResultFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(id),
                "result",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
