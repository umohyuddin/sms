package com.smartsolutions.eschool.sclass.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.sclass.facade.EnrollmentFacade;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
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
@RequestMapping("/api/course/enrollment")
public class EnrollmentController {
    private EnrollmentFacade nEnrollmentFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public EnrollmentController(EnrollmentFacade pEnrollmentFacade, ObjectMapper objectMapper) {
        this.nEnrollmentFacade = pEnrollmentFacade;
        this.objectMapper = objectMapper;
    }

    //  get all Enrollments
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nEnrollmentFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Enrollment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get Enrollment by ID
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nEnrollmentFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Enrollment",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
    //get all Enrollment of a teacher
    @GetMapping(value = "/getbyteacherid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByTeacherId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                nEnrollmentFacade.getByTeacherId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Enrollment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get all Enrollment of a course
    @GetMapping(value = "/getbycourseid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByCourseId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                nEnrollmentFacade.getByCourseId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Enrollment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get all Enrollment of a Student
    @GetMapping(value = "/getbystudentid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByStudentId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                nEnrollmentFacade.getByStudentId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Enrollment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    //add new Enrollment
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        SClassEntity nSClassEntity = objectMapper.convertValue(attributes, SClassEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nEnrollmentFacade.create(nSClassEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                nSClassEntity.getName(),
                                "Enrollment",
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
        SClassEntity nSClassEntity = objectMapper.convertValue(attributes, SClassEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nEnrollmentFacade.update(nSClassEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nSClassEntity.getId()),
                                    "Enrollment ",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",nEnrollmentFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Enrollment",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
