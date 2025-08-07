package com.smartsolutions.eschool.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.user.facade.UserRoleServiceFacade;
import com.smartsolutions.eschool.user.model.UserRoleEntity;
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
@RequestMapping("/api/schools/user-role")
public class UserRoleController {

    private UserRoleServiceFacade userRoleServiceFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public UserRoleController(UserRoleServiceFacade userRoleServiceFacade, ObjectMapper objectMapper) {
        this.userRoleServiceFacade = userRoleServiceFacade;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject createUser(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        UserRoleEntity nUserRoleEntity = objectMapper.convertValue(attributes, UserRoleEntity.class);
//        UserRoleEntity nUserRoleEntity = new UserRoleEntity();
//        nUserRoleEntity.setRoleName((String) attributes.get("name"));

        return new SingleResourceSuccessResponseObject(AbstractUserRestController.strToResourceObject(
                userRoleServiceFacade.create(nUserRoleEntity)));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject updateUser(
            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        UserRoleEntity nUserRoleEntity = objectMapper.convertValue(attributes, UserRoleEntity.class);
        //nUserRoleEntity.setId((Long) attributes.get("id"));
        return new SingleResourceSuccessResponseObject(AbstractUserRestController.strToResourceObject(
                userRoleServiceFacade.update(nUserRoleEntity)));
    }

    // Get Role by ID
    @GetMapping(value = "/get/{role_id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getUsers(@PathVariable Long role_Id) throws Exception {
        return new MultiResourceSuccessResponseObject(
                userRoleServiceFacade.getById(role_Id)
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
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
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
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleResourceSuccessResponseObject deleteUser(
            @PathVariable Long role_Id
            ) throws Exception {

        return new SingleResourceSuccessResponseObject(AbstractUserRestController.strToResourceObject(
                userRoleServiceFacade.delete(role_Id)));
    }
}
