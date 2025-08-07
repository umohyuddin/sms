package com.smartsolutions.eschool.user.repository.sql;

import com.smartsolutions.eschool.user.model.UserEntity;

import java.util.List;

public interface UserDao {
    int save(UserEntity userEntity);
    int update(UserEntity userEntity);
    int deleteById(Long id);
    UserEntity findById(Long id);
    List<UserEntity> findAll();
    List<UserEntity> findUsers(Long institute_id, Long campus_id);
}

