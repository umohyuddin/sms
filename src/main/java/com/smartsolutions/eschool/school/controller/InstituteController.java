package com.smartsolutions.eschool.school.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.InstituteFacade;
import com.smartsolutions.eschool.school.model.InstituteEntity;
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
@RequestMapping("/api/schools/institute")
public class InstituteController {

    private InstituteFacade nInstituteFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public InstituteController(InstituteFacade pInstituteFacade, ObjectMapper objectMapper) {
        this.nInstituteFacade = pInstituteFacade;
        this.objectMapper = objectMapper;
    }

    //  get all employee
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nInstituteFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getInstituteId()),
                                    "Institute",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nInstituteFacade.getById(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Institute",
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
        InstituteEntity nInstituteEntity = objectMapper.convertValue(attributes, InstituteEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nInstituteFacade.create(nInstituteEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                nInstituteEntity.getName(),
                "Institute",
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
        InstituteEntity nInstituteEntity = objectMapper.convertValue(attributes, InstituteEntity.class);
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nInstituteFacade.update(nInstituteEntity), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(nInstituteEntity.getName()),
                "Institute",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject delete(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nInstituteFacade.delete(id), Map.class);
        ResourceObject resourceObject = new ResourceObject(
                String.valueOf(id),
                "Institute",
                resourceAttributes
        );
        return new SingleResourceSuccessResponseObject(resourceObject);
    }
}
