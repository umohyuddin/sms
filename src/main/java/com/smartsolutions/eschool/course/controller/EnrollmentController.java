package com.smartsolutions.eschool.course.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.course.facade.EnrollmentFacade;
import com.smartsolutions.eschool.course.model.EnrollmentEntity;
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
                                    String.valueOf(entity.getCourseId()),
                                    "Enrollment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get Enrollment by ID
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nEnrollmentFacade.getById(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Enrollment",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
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
                                    String.valueOf(entity.getCourseId()),
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
                                    String.valueOf(entity.getCourseId()),
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
                                    String.valueOf(entity.getCourseId()),
                                    "Enrollment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    //add new Enrollment
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        EnrollmentEntity nEnrollmentEntity = objectMapper.convertValue(attributes, EnrollmentEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nEnrollmentFacade.create(nEnrollmentEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                nEnrollmentEntity.getStudent().getFirstName(),
                "Enrollment",
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
        EnrollmentEntity nEnrollmentEntity = objectMapper.convertValue(attributes, EnrollmentEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nEnrollmentFacade.update(nEnrollmentEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nEnrollmentEntity.getCourseId()),
                "Enrollment ",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nEnrollmentFacade.delete(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Enrollment",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }
}
