package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.user.model.UserEntity;
import com.smartsolutions.eschool.user.repository.sql.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }
    public List<UserEntity> getUsers(Long institute_Id, Long campus_id) {
        return userDao.findUsers(institute_Id,campus_id);
    }

    public UserEntity getUserById(Long id) {
        return userDao.findById(id);
    }

    public String createUser(UserEntity userEntity) {
        return userDao.save(userEntity) == 1 ? "User created" : "Error creating User";
    }

    public String updateUser(UserEntity userEntity) {
        return userDao.update(userEntity) == 1 ? "User updated" : "Error updating User";
    }

    public String deleteUser(Long id) {
        return userDao.deleteById(id) == 1 ? "User deleted" : "Error deleting User";
    }
}

