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

    public List<UserEntity> getAll() {
        return userService.getAll();
    }
    public UserEntity getById(Long id) {
        return userService.getById(id);
    }

    public List<UserEntity> getByUserName(String userName) {
        return userService.getByUserName(userName);
    }

    public String create(UserEntity pUserEntity) {
        return userService.create(pUserEntity);
    }

    public String update(UserEntity pUserEntity) {
        return userService.update(pUserEntity);
    }
    public String delete(Long id) {
        return userService.delete(id);
    }
}
