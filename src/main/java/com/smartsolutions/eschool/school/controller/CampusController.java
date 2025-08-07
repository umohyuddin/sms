package com.smartsolutions.eschool.school.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.CampusFacade;
import com.smartsolutions.eschool.school.model.CampusEntity;
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
@RequestMapping("/api/schools/campus")
public class CampusController {

    private CampusFacade nCampusFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public CampusController(CampusFacade pCampusFacade, ObjectMapper objectMapper) {
        this.nCampusFacade = pCampusFacade;
        this.objectMapper = objectMapper;
    }

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nCampusFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCampusId()),
                                    "Campus",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nCampusFacade.getById(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Campus",
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
        CampusEntity nCampusEntity = objectMapper.convertValue(attributes, CampusEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nCampusFacade.create(nCampusEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                nCampusEntity.getName(),
                "Campus",
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
        CampusEntity nCampusEntity = objectMapper.convertValue(attributes, CampusEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nCampusFacade.update(nCampusEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nCampusEntity.getName()),
                "Campus",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nCampusFacade.delete(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Campus",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }
}
