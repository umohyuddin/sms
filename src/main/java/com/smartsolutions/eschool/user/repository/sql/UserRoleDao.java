package com.smartsolutions.eschool.user.repository.sql;

import com.smartsolutions.eschool.user.model.UserEntity;
import com.smartsolutions.eschool.user.model.UserRoleEntity;

import java.util.List;

public interface UserRoleDao {
    int save(UserRoleEntity userRoleEntity);
    int update(UserRoleEntity userRoleEntity);
    int deleteById(Long id);
    List<UserRoleEntity> findById(Long id);
    List<UserRoleEntity> findAll();
}
