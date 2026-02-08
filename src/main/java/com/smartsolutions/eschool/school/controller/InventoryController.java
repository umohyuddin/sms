package com.smartsolutions.eschool.school.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.InventoryFacade;
import com.smartsolutions.eschool.school.model.InventoryEntity;
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
@RequestMapping("/api/schools/inventory")
@Slf4j
public class InventoryController {

    private final InventoryFacade nInventoryFacade;
    private final ObjectMapper objectMapper;

    public InventoryController(InventoryFacade pInventoryFacade, ObjectMapper objectMapper) {
        this.nInventoryFacade = pInventoryFacade;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        log.info("GET /api/schools/inventory called");
        List<InventoryEntity> result = nInventoryFacade.getAll();
        log.info("GET /api/schools/inventory succeeded, returned {} resources", result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCampusId()),
                                    "Inventory",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/by-campus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByCampus(@PathVariable Long id) throws Exception {
        log.info("GET /api/schools/inventory/by-campus/{} called", id);
        List<InventoryEntity> result = nInventoryFacade.findByCampus(id);
        log.info("GET /api/schools/inventory/by-campus/{} succeeded, returned {} resources", id, result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCampusId()),
                                    "Inventory",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/by-institute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByInstitute(@PathVariable Long id) throws Exception {
        log.info("GET /api/schools/inventory/by-institute/{} called", id);
        List<InventoryEntity> result = nInventoryFacade.findByInstitute(id);
        log.info("GET /api/schools/inventory/by-institute/{} succeeded, returned {} resources", id, result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCampusId()),
                                    "Inventory",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {
        log.info("GET /api/schools/inventory/{} called", id);
        InventoryEntity entity = nInventoryFacade.getById(id);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Inventory",
                                    resourceAttributes
                            ));
        log.info("GET /api/schools/inventory/{} succeeded", id);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject search(@RequestParam String keyword) throws Exception {
        log.info("GET /api/schools/inventory/search called with keyword: {}", keyword);
        List<InventoryEntity> result = nInventoryFacade.searchByKeyword(keyword);
        log.info("GET /api/schools/inventory/search succeeded, returned {} resources", result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getCampusId()),
                                    "Inventory",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        InventoryEntity nInventoryEntity = objectMapper.convertValue(attributes, InventoryEntity.class);
        
        log.info("POST /api/schools/inventory called for item: {}", nInventoryEntity.getItemName());
        String message = nInventoryFacade.create(nInventoryEntity);
        Map<String, Object> resourceAttributes = Map.of("message", message);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                nInventoryEntity.getItemName(),
                                "Inventory",
                                resourceAttributes
                        ));
        log.info("POST /api/schools/inventory succeeded: {}", message);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject update(
            @PathVariable Long id,
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        InventoryEntity nInventoryEntity = objectMapper.convertValue(attributes, InventoryEntity.class);
        nInventoryEntity.setId(id);
        
        log.info("PUT /api/schools/inventory/{} called", id);
        String message = nInventoryFacade.update(nInventoryEntity);
        Map<String, Object> resourceAttributes = Map.of("message", message);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nInventoryEntity.getItemName()),
                                    "Inventory",
                                    resourceAttributes
                            ));
        log.info("PUT /api/schools/inventory/{} succeeded: {}", id, message);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        log.info("DELETE /api/schools/inventory/{} called", id);
        String message = nInventoryFacade.delete(id);
        Map<String, Object> resourceAttributes = Map.of("message", message);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                        String.valueOf(id),
                                        "Inventory",
                                        resourceAttributes
                                ));
        log.info("DELETE /api/schools/inventory/{} succeeded: {}", id, message);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
