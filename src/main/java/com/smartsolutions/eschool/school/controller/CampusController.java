package com.smartsolutions.eschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.dtos.CampusDTO;
import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.facade.CampusFacade;
import com.smartsolutions.eschool.school.model.CampusEntity;
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
@RequestMapping("/api/institute/campus")
@Slf4j
public class CampusController {

    @Autowired
    private CampusFacade nCampusFacade;

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/institute/getall called");
        List<CampusDTO> resources = nCampusFacade.getAll();
        log.info("GET /api/institute/getall succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus with id: {}", id);
        CampusDTO campus = nCampusFacade.getById(id);
        log.info("Returning campus: id={}", campus.getId());
        return ResponseEntity.ok(campus);
    }

    @GetMapping(value = "/getByInstituteId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByInstituteId(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus by Institute Id: {}", id);
        List<CampusDTO> campuses = nCampusFacade.findByInstituteId(id);
        log.info("Returning campuses data");
        return ResponseEntity.ok(campuses);
    }

    @GetMapping(value = "/getByCampusName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByInstituteId(@PathVariable String name) throws Exception {
        log.info("Received request to fetch campus by Institute name: {}", name);
        List<CampusDTO> campuses = nCampusFacade.findByCampusNameContaining(name);
        log.info("Returning campuses  data");
        return ResponseEntity.ok(campuses);
    }


//
//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject create(
//            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
//        if (!requestBody.containsKey("data")) {
//            throw new ValidationException("The request body did not contain a data attribute");
//        }
//        Map<String, Object> resourceMap = requestBody.get("data");
//        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
//        CampusEntity nCampusEntity = objectMapper.convertValue(attributes, CampusEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message",nCampusFacade.create(nCampusEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    nCampusEntity.getName(),
//                                    "Campus",
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
//        CampusEntity nCampusEntity = objectMapper.convertValue(attributes, CampusEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message",nCampusFacade.update(nCampusEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(nCampusEntity.getName()),
//                                    "Campus",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject delete(
//            @PathVariable Long id
//    ) throws Exception {
//        Map<String, Object> resourceAttributes = Map.of("message",nCampusFacade.delete(id));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                                    String.valueOf(id),
//                                    "Campus",
//                                    resourceAttributes
//                            ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
}
