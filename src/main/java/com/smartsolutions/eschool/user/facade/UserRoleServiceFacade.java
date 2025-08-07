package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.model.UserRoleEntity;
import com.smartsolutions.eschool.user.service.UserRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class UserRoleServiceFacade {
    private static final Log LOG = LogFactory.getLog(UserRoleServiceFacade.class);
    @Autowired
    @Lazy
    private UserRoleService userRoleService;

    public UserRoleServiceFacade changeUser() {
        //this.user = user;
        return this;
    }

    public List<UserRoleEntity> getAll() {
        return userRoleService.getAll();
    }
    public List<UserRoleEntity> getById(Long id) {
        return userRoleService.getById(id);
    }

    public String create(UserRoleEntity userRoleEntity) {
        return userRoleService.create(userRoleEntity);
    }

    public String update(UserRoleEntity userRoleEntity) {
        return userRoleService.update(userRoleEntity);
    }
    public String delete(Long id) {
        return userRoleService.delete(id);
    }


}
