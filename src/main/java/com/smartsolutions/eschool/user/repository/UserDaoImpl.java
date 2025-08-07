package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<User> studentRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setSchoolId(rs.getLong("school_id"));
        user.setCampusUuid(rs.getString("campus_uuid"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        return user;
    };

    @Override
    public int save(User user) {
        String sql = "INSERT INTO students (school_id, campus_uuid, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getSchoolId(), user.getCampusUuid(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());
    }

    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, studentRowMapper, id);
    }

    @Override
    public List<User> findAll(Long schoolId, String campusUuid) {
        String sql = "SELECT * FROM students WHERE school_id = ? AND campus_uuid = ?";
        return jdbcTemplate.query(sql, studentRowMapper, schoolId, campusUuid);
    }
}

