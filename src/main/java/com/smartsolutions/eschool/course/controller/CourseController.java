package com.smartsolutions.eschool.course.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.course.facade.CourseFacade;
import com.smartsolutions.eschool.course.model.CourseEntity;
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
@RequestMapping("/api/course")
public class CourseController {
    private CourseFacade courseFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public CourseController(CourseFacade pCourseFacade, ObjectMapper objectMapper) {
        this.courseFacade = pCourseFacade;
        this.objectMapper = objectMapper;
    }

    //  get all course
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                courseFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCourseId()),
                                    "Course",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get Course by ID
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(courseFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                String.valueOf(id),
                                "Course",
                                resourceAttributes
                        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
    //get all course of a teacher
    @GetMapping(value = "/getbyteacherid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByTeacherId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                courseFacade.getByTeacherId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCourseId()),
                                    "Course",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //get all course of a department
    @GetMapping(value = "/getbydepartmentid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByDepartmentId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                courseFacade.getByDepartmentId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCourseId()),
                                    "Course",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    //add new course
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        CourseEntity nCourseEntity = objectMapper.convertValue(attributes, CourseEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",courseFacade.create(nCourseEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    nCourseEntity.getCourseName(),
                                    "Course",
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
        CourseEntity nCourseEntity = objectMapper.convertValue(attributes, CourseEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",courseFacade.update(nCourseEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nCourseEntity.getCourseId()),
                                    "Course ",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",courseFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Course",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
