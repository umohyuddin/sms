package com.smartsolutions.eschool.user.student.service;

import com.smartsolutions.eschool.user.student.model.User;
import com.smartsolutions.eschool.user.student.repository.sql.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final UserDao userDao;

    public StudentService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllStudents(Long schoolId, String campusUuid) {
        return userDao.findAll(schoolId, campusUuid);
    }

    public User getStudentById(Long id) {
        return userDao.findById(id);
    }

    public String createStudent(User user) {
        return userDao.save(user) == 1 ? "Student created" : "Error creating student";
    }

    public String updateStudent(Long id, User user) {
        user.setId(id);
        return userDao.update(user) == 1 ? "Student updated" : "Error updating student";
    }

    public String deleteStudent(Long id) {
        return userDao.deleteById(id) == 1 ? "Student deleted" : "Error deleting student";
    }
}

