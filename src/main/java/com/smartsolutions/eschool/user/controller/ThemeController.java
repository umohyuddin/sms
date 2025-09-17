package com.smartsolutions.eschool.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.user.facade.ThemeServiceFacade;
import com.smartsolutions.eschool.user.model.ThemeEntity;
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
@RequestMapping("/api/user/theme")
public class ThemeController {

    private ThemeServiceFacade nThemeServiceFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public ThemeController(ThemeServiceFacade pThemeServiceFacade, ObjectMapper objectMapper) {
        this.nThemeServiceFacade = pThemeServiceFacade;
        this.objectMapper = objectMapper;
    }


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject createUser(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        ThemeEntity nThemeEntity = objectMapper.convertValue(attributes, ThemeEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",nThemeServiceFacade.create(nThemeEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                nThemeEntity.getId().toString(),
                "Theme",
                resourceAttributes
        ));

        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject updateUser(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        ThemeEntity nThemeEntity = objectMapper.convertValue(attributes, ThemeEntity.class);

        Map<String, Object> resourceAttributes = Map.of("message",nThemeServiceFacade.update(nThemeEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(  new ResourceObject(
                String.valueOf(nThemeEntity.getId()),
                "Theme",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    // Get theme by id
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getById(@PathVariable Long id) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nThemeServiceFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "Theme",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
    // Get theme by user id
    @GetMapping(value = "/getbyuser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByUser(@PathVariable Long id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                nThemeServiceFacade.getByUser(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Theme",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    // Get theme by user id
    @GetMapping(value = "/getbyinstitute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByInstitute(@PathVariable Long id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                nThemeServiceFacade.getByInstitute(id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Theme",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //  get all theme
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                nThemeServiceFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "Theme",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject deleteUser(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(nThemeServiceFacade.delete(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "Theme",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
