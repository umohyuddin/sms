package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.model.UserEntity;
import com.smartsolutions.eschool.user.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class UserServiceFacade {
    private static final Log LOG = LogFactory.getLog(UserServiceFacade.class);
    @Autowired
    @Lazy
    private UserService userService;

    public UserServiceFacade changeUser() {
        //this.user = user;
        return this;
    }

    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
    public List<UserEntity> getUsers(Long institute_Id, Long campus_id) {
        return userService.getUsers(institute_Id, campus_id);
    }

    public String createUser(UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    public String updateUser(UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }
    public String deleteUser(Long id) {
        return userService.deleteUser(id);
    }


//    public <O> O createUser(
//            Long institute_Id,
//            Long campus_id,
//            Map<String, Object> attributes,
//            ReturnFunction<UserEntity, O> returnFunction)
//            throws Exception {
//
//        if (attributes.isEmpty()) {
//            throw new Exception("Data is missing");
//        }
//
//        UserEntity nUserEntity = new UserEntity();
//        nUserEntity.setEmpId();
//        nUserEntity.setCampus_id(campus_id);
//        nUserEntity.setFirstName((String) attributes.get("firstName"));
//        nUserEntity.setLastName((String) attributes.get("lastName"));
//        nUserEntity.setEmail((String) attributes.get("email"));
//        userService.createUser(nUserEntity);
//
//        return returnFunction.getObject(nUserEntity);
//    }
}
