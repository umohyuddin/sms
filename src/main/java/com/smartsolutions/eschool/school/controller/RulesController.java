package com.smartsolutions.eschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.RulesFacade;
import com.smartsolutions.eschool.school.model.RulesEntity;
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

@Transactional
@RestController
@RequestMapping("/api/schools/rules")
public class RulesController {
    private RulesFacade nRulesFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public RulesController(RulesFacade pRulesFacade, ObjectMapper objectMapper) {
        this.nRulesFacade = pRulesFacade;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/getbyinstitute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByInstitute(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nRulesFacade.getByInstitute(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "Rules and regulations",
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
        RulesEntity nRulesEntity = objectMapper.convertValue(attributes, RulesEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nRulesFacade.create(nRulesEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                nRulesEntity.getId().toString(),
                "Rules And Regulations",
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
        RulesEntity nRulesEntity = objectMapper.convertValue(attributes, RulesEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nRulesFacade.update(nRulesEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(nRulesEntity.getId()),
                "Rules and Regulations",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",nRulesFacade.delete(id));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(id),
                "Rules and regulation",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
