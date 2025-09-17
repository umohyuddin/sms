package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.user.model.UserEntity;
import com.smartsolutions.eschool.user.repository.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserEntity> getAll() {
        return userDao.findAll();
    }
    public List<UserEntity> getByCampus(Long institute_Id, Long campus_id) {
        return userDao.findUsers(institute_Id,campus_id);
    }

    public List<UserEntity> getByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public UserEntity getById(Long id) {
        return userDao.findById(id);
    }

    public String create(UserEntity userEntity) {
        return userDao.save(userEntity) == 1 ? "User created" : "Error creating User";
    }

    public String update(UserEntity userEntity) {
        return userDao.update(userEntity) == 1 ? "User updated" : "Error updating User";
    }

    public String delete(Long id) {
        return userDao.deleteById(id) == 1 ? "User deleted" : "Error deleting User";
    }
}

