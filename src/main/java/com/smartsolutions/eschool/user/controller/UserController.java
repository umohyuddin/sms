package com.smartsolutions.eschool.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.user.model.UserEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import com.smartsolutions.eschool.user.facade.UserServiceFacade;
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
@RequestMapping("/api/user")
public class UserController extends AbstractUserRestController {
    private UserServiceFacade userServiceFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public UserController(UserServiceFacade userServiceFacade, ObjectMapper objectMapper) {
        super(userServiceFacade);
        this.userServiceFacade = userServiceFacade;
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
        UserEntity nUserEntity = objectMapper.convertValue(attributes, UserEntity.class);
        Map<String, Object> resourceAttributes = Map.of("message",userServiceFacade.create(nUserEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                nUserEntity.getUsername(),
                "User",
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
        UserEntity nUserEntity = objectMapper.convertValue(attributes, UserEntity.class);

        Map<String, Object> resourceAttributes = Map.of("message",userServiceFacade.update(nUserEntity));
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add(  new ResourceObject(
                String.valueOf(nUserEntity.getId()),
                "User",
                resourceAttributes
            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

    // Get Role by ID
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getUsers(@PathVariable Long id) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(userServiceFacade.getById(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "User",
                resourceAttributes
            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
    //  get all roles
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getAll() throws Exception {
        return new MultiResourceSuccessResponseObject(
                userServiceFacade.getAll()
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "User",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }

    //  get all roles
    @GetMapping(value = "/getbyusername/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getByUserName(@PathVariable String userName) throws Exception {
        return new MultiResourceSuccessResponseObject(
                userServiceFacade.getByUserName(userName)
                        .stream()
                        .map(entity -> {
                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
                            return new ResourceObject(
                                    String.valueOf(entity.getId()),
                                    "User",
                                    resourceAttributes
                            );
                        })
                        .collect(Collectors.toList()));
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject deleteUser(
            @PathVariable Long id
    ) throws Exception {
        Map<String, Object> resourceAttributes = objectMapper.convertValue(userServiceFacade.delete(id), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "User",
                resourceAttributes
            ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }
}
