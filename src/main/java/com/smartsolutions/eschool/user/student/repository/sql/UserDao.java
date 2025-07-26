package com.smartsolutions.eschool.user.student.repository.sql;

import com.smartsolutions.eschool.user.student.model.User;

import java.util.List;

public interface UserDao {
    int save(User user);
    int update(User user);
    int deleteById(Long id);
    User findById(Long id);
    List<User> findAll(Long schoolId, String campusUuid);
}

