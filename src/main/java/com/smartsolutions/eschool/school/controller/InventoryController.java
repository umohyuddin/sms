package com.smartsolutions.eschool.school.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.InventoryFacade;
import com.smartsolutions.eschool.school.model.InventoryEntity;
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
@RequestMapping("/api/schools/inventory")
public class InventoryController {

    private InventoryFacade nInventoryFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public InventoryController(InventoryFacade pInventoryFacade, ObjectMapper objectMapper) {
        this.nInventoryFacade = pInventoryFacade;
        this.objectMapper = objectMapper;
    }

    //  get all Inventory
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nInventoryFacade.getAll()
                        .stream()
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
    //  get all inventory of campus
    @GetMapping(value = "/getbycampus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByCampus(@PathVariable Long id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                nInventoryFacade.findByCampus(id)
                        .stream()
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
//  get all inventory of institute
    @GetMapping(value = "/getbyinstitute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByInstitute(@PathVariable Long id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                nInventoryFacade.findByInstitute(id)
                        .stream()
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

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nInventoryFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(id),
                                    "Inventory",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject create(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        InventoryEntity nInventoryEntity = objectMapper.convertValue(attributes, InventoryEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nInventoryFacade.create(nInventoryEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                nInventoryEntity.getItemName(),
                                "Inventory",
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
        InventoryEntity nInventoryEntity = objectMapper.convertValue(attributes, InventoryEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nInventoryFacade.update(nInventoryEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                    String.valueOf(nInventoryEntity.getItemName()),
                                    "Inventory",
                                    resourceAttributes
                            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",nInventoryFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                                        String.valueOf(id),
                                        "Inventory",
                                        resourceAttributes
                                ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
