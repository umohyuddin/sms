package com.smartsolutions.eschool.sclass.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.sclass.facade.AssessmentFacade;
import com.smartsolutions.eschool.sclass.model.AssessmentEntity;
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
@RequestMapping("/api/course/assessment")
public class AssessmentController {

    private AssessmentFacade assessmentFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public AssessmentController(AssessmentFacade pAssessmentFacade, ObjectMapper objectMapper) {
        this.assessmentFacade = pAssessmentFacade;
        this.objectMapper = objectMapper;
    }

    //  get all Assessments
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                assessmentFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Assessment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
//get assessment by ID
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(assessmentFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Assessment",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
//get all assessments of a course
    @GetMapping(value = "/getbycourseid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByCourseId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                assessmentFacade.getByCourseId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Assessment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
//get all assessments of a student
    @GetMapping(value = "/getbystudentid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByStudentId(@PathVariable Long id) throws Exception {

        return new MultiResourceSuccessResponseObject(
                assessmentFacade.getByStudentId(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Assessment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    // get all assessments of a student related to a course
    @GetMapping(value = "/getstudentwithincourse/{std_id}/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getStudentWithinCourse(@PathVariable Long std_id, @PathVariable Long course_id ) throws Exception {

        return new MultiResourceSuccessResponseObject(
                assessmentFacade.getStudentWithinCourse(std_id, course_id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Assessment",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

//add new assessment
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        AssessmentEntity nAssessmentEntity = objectMapper.convertValue(attributes, AssessmentEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",assessmentFacade.create(nAssessmentEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                nAssessmentEntity.getName(),
                                "Assessment",
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
        AssessmentEntity nAssessmentEntity = objectMapper.convertValue(attributes, AssessmentEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",assessmentFacade.update(nAssessmentEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nAssessmentEntity.getId()),
                                    "Assessment ",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",assessmentFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Assessment",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
