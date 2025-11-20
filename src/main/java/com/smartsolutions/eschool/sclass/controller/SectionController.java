package com.smartsolutions.eschool.sclass.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.facade.SClassFacade;
import com.smartsolutions.eschool.sclass.facade.SectionFacade;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@RestController
@RequestMapping("/api/standard/sections")
public class SectionController {
    @Autowired
    private SectionFacade sectionFacade;
    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/standards/sections called");
        List<SectionDTO> resources = sectionFacade.getAll();
        log.info("GET /api/standards/sections succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        SectionDTO sectionDTO = sectionFacade.getById(id);
        return ResponseEntity.ok().body(sectionDTO);
    }
//    //get all Enrollment of a teacher
//    @GetMapping(value = "/getbyinstituteid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByInstituteId(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                nSectionFacade.getByInstituteId(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "section",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//
//    @GetMapping(value = "/getbycampusid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByCampusId(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                nSectionFacade.getByCampusId(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "section",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//
//    @GetMapping(value = "/getbyclassid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByClassId(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                nSectionFacade.getByClassId(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "section",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//
//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject create(
//            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
//        if (!requestBody.containsKey("data")) {
//            throw new ValidationException("The request body did not contain a data attribute");
//        }
//        Map<String, Object> resourceMap = requestBody.get("data");
//        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
//        SectionEntity entity = objectMapper.convertValue(attributes, SectionEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message", nSectionFacade.create(entity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                entity.getName(),
//                                "section",
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
//        SectionEntity entity = objectMapper.convertValue(attributes, SectionEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message", nSectionFacade.update(entity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(entity.getId()),
//                                    "section",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject delete(
//            @PathVariable Long id
//    ) throws Exception {
//        Map<String, Object> resourceAttributes = Map.of("message", nSectionFacade.delete(id));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(id),
//                                    "section",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
}
