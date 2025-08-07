package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.user.model.UserRoleEntity;
import com.smartsolutions.eschool.user.repository.sql.UserRoleDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    private final UserRoleDao userRoleDao;

    public UserRoleService(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    public List<UserRoleEntity> getAll() {
        return userRoleDao.findAll();
    }

    public List<UserRoleEntity> getById(Long id) {
        return userRoleDao.findById(id);
    }

    public String create(UserRoleEntity userRoleEntity) {
        return userRoleDao.save(userRoleEntity) == 1 ? "Role created" : "Error creating Role";
    }

    public String update(UserRoleEntity userRoleEntity) {
        return userRoleDao.update(userRoleEntity) == 1 ? "Role updated" : "Error updating Role";
    }

    public String delete(Long id) {
        return userRoleDao.deleteById(id) == 1 ? "Role deleted" : "Error deleting Role";
    }
}
