package com.smartsolutions.eschool.sclass.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.sclass.facade.SClassFacade;
import com.smartsolutions.eschool.sclass.facade.StandardFacade;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/standard")
@Slf4j
public class StandardController {
    @Autowired
    private StandardFacade standardFacade;

    //  get all Enrollments
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject<ResourceObject> getAll() {

        log.info("GET /api/standards called");
        List<ResourceObject> resources = standardFacade.getAll();
        log.info("GET /api/standards succeeded, returned {} resources", resources.size());
        return new MultiResourceSuccessResponseObject<>(resources);
    }


    //get Enrollment by ID
//    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {
//
//        Map<String, Object> resourceAttributes = objectMapper.convertValue(standardFacade.getById(id), Map.class);
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(id),
//                                    "class",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//    //get all Enrollment of a teacher
//    @GetMapping(value = "/getbyteacherid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByTeacherId(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                standardFacade.getByTeacherId(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "class",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//    //get all Enrollment of a course
//    @GetMapping(value = "/getbycourseid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByCourseId(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                standardFacade.getByCourseId(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "class",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//    //get all Enrollment of a Student
//    @GetMapping(value = "/getbystudentid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByStudentId(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                standardFacade.getByStudentId(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "class",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//
//    //add new Enrollment
//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject create(
//            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
//        if (!requestBody.containsKey("data")) {
//            throw new ValidationException("The request body did not contain a data attribute");
//        }
//        Map<String, Object> resourceMap = requestBody.get("data");
//        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
//        SClassEntity nSClassEntity = objectMapper.convertValue(attributes, SClassEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message", standardFacade.create(nSClassEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                nSClassEntity.getName(),
//                                "class",
//                                resourceAttributes
//                        ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject update(
//            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
//        if (!requestBody.containsKey("data")) {
//            throw new ValidationException("The request body did not contain a data attribute");
//        }
//        Map<String, Object> resourceMap = requestBody.get("data");
//        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
//        SClassEntity nSClassEntity = objectMapper.convertValue(attributes, SClassEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message", standardFacade.update(nSClassEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(nSClassEntity.getId()),
//                                    "class ",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject delete(
//            @PathVariable Long id
//    ) throws Exception {
//        Map<String, Object> resourceAttributes = Map.of("message", standardFacade.delete(id));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(id),
//                                    "class",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
}
