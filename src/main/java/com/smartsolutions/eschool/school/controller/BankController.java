package com.smartsolutions.eschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.BankFacade;
import com.smartsolutions.eschool.school.model.BankEntity;
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
@RequestMapping("/api/schools/bank")
@Slf4j
public class BankController {
    private final BankFacade nBankFacade;
    private final ObjectMapper objectMapper;

    public BankController(BankFacade pBankFacade, ObjectMapper objectMapper) {
        this.nBankFacade = pBankFacade;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        log.info("GET /api/schools/bank called");
        List<BankEntity> result = nBankFacade.getAll();
        log.info("GET /api/schools/bank succeeded, returned {} resources", result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "bank",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/by-institute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByInstitute(@PathVariable Long id) throws Exception {
        log.info("GET /api/schools/bank/by-institute/{} called", id);
        List<BankEntity> result = nBankFacade.getByInstitute(id);
        log.info("GET /api/schools/bank/by-institute/{} succeeded, returned {} resources", id, result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "bank",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {
        log.info("GET /api/schools/bank/{} called", id);
        BankEntity entity = nBankFacade.getById(id);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "bank",
                resourceAttributes
        ));
        log.info("GET /api/schools/bank/{} succeeded", id);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject search(@RequestParam String keyword) throws Exception {
        log.info("GET /api/schools/bank/search called with keyword: {}", keyword);
        List<BankEntity> result = nBankFacade.searchByKeyword(keyword);
        log.info("GET /api/schools/bank/search succeeded, returned {} resources", result.size());
        return new MultiResourceSuccessResponseObject(
                result.stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "bank",
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
        BankEntity nBankEntity = objectMapper.convertValue(attributes, BankEntity.class);
        
        log.info("POST /api/schools/bank called for bank: {}", nBankEntity.getName());
        String message = nBankFacade.create(nBankEntity);
        Map<String, Object> resourceAttributes = Map.of("message", message);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                nBankEntity.getName(),
                "bank",
                resourceAttributes
        ));
        log.info("POST /api/schools/bank succeeded: {}", message);
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
        BankEntity nBankEntity = objectMapper.convertValue(attributes, BankEntity.class);
        nBankEntity.setId(id);
        
        log.info("PUT /api/schools/bank/{} called", id);
        String message = nBankFacade.update(nBankEntity);
        Map<String, Object> resourceAttributes = Map.of("message", message);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(nBankEntity.getName()),
                "bank",
                resourceAttributes
        ));
        log.info("PUT /api/schools/bank/{} succeeded: {}", id, message);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        log.info("DELETE /api/schools/bank/{} called", id);
        String message = nBankFacade.delete(id);
        Map<String, Object> resourceAttributes = Map.of("message", message);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(id),
                "bank",
                resourceAttributes
        ));
        log.info("DELETE /api/schools/bank/{} succeeded: {}", id, message);
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
