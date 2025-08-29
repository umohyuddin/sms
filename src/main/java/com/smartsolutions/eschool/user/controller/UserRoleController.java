package com.smartsolutions.eschool.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.user.facade.UserRoleServiceFacade;
import com.smartsolutions.eschool.user.model.UserRoleEntity;
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
@RequestMapping("/api/user/user-role")
public class UserRoleController {

    private UserRoleServiceFacade userRoleServiceFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public UserRoleController(UserRoleServiceFacade userRoleServiceFacade, ObjectMapper objectMapper) {
        this.userRoleServiceFacade = userRoleServiceFacade;
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
        UserRoleEntity nUserRoleEntity = objectMapper.convertValue(attributes, UserRoleEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",userRoleServiceFacade.create(nUserRoleEntity) );
        List<ResourceObject> resourceObject = new ArrayList<>();
                resourceObject.add(new ResourceObject(
                nUserRoleEntity.getRoleName(),
                "User Role",
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
        UserRoleEntity nUserRoleEntity = objectMapper.convertValue(attributes, UserRoleEntity.class);

        Map<String, Object> resourceAttributes = Map.of("message",userRoleServiceFacade.update(nUserRoleEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(new ResourceObject(
                String.valueOf(nUserRoleEntity.getId()),
                "User Role",
                resourceAttributes
        ));
        return  new MultiResourceSuccessResponseObject(resourceObject);
    }

    // Get Role by ID
    @GetMapping(value = "/get/{role_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getUsers(@PathVariable Long role_id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                userRoleServiceFacade.getById(role_id)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "User Role",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    //  get all roles
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                userRoleServiceFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "User Role",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    @DeleteMapping(value = "/delete/{role_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject deleteUser(
            @PathVariable Long role_id
            ) throws Exception {
        Map<String, Object> resourceAttributes = Map.of("message",userRoleServiceFacade.delete(role_id));
        List<ResourceObject> resourceObject = new ArrayList<>();
                resourceObject.add(new ResourceObject(
                String.valueOf(role_id),
                "User Role",
                resourceAttributes
                ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
