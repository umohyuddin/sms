package com.smartsolutions.eschool.school.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.facade.InstituteFacade;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
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

@Transactional
@RestController
@RequestMapping("/api/institute")
@Slf4j
public class InstituteController {

    @Autowired
    private InstituteFacade instituteFacade;
    @Autowired
    private ObjectMapper objectMapper;

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/institute/getall called");
        List<InstituteDTO> resources  =instituteFacade.getAll();
        log.info("GET /api/institute/getall succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

//    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {
//
//        Map<String, Object> resourceAttributes = objectMapper.convertValue(nInstituteFacade.getById(id), Map.class);
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(id),
//                                    "Institute",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
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
//        InstituteEntity nInstituteEntity = objectMapper.convertValue(attributes, InstituteEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message",nInstituteFacade.create(nInstituteEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    nInstituteEntity.getName(),
//                                    "Institute",
//                                    resourceAttributes
//                            ));
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
//        InstituteEntity nInstituteEntity = objectMapper.convertValue(attributes, InstituteEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message",nInstituteFacade.update(nInstituteEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(nInstituteEntity.getName()),
//                                    "Institute",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject delete(
//            @PathVariable Long id
//    ) throws Exception {
//        Map<String, Object> resourceAttributes = Map.of("message",nInstituteFacade.delete(id));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                String.valueOf(id),
//                                "Institute",
//                                resourceAttributes
//                        ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
}
