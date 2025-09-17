package com.smartsolutions.eschool.student.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import java.util.List;

@Transactional
@Repository
public class StudentAttendanceDaoImp implements StudentAttendanceDao{
    private final JdbcTemplate jdbcTemplate;

    public StudentAttendanceDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(StudentAttendanceEntity pStudentAttendanceEntity) {
        try {
            pStudentAttendanceEntity.setAttendanceId(null);
            getSession().persist(pStudentAttendanceEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(StudentAttendanceEntity pStudentAttendanceEntity) {
        try {
            getSession().merge(pStudentAttendanceEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            StudentAttendanceEntity entity = getSession().get(StudentAttendanceEntity.class, id);
            if (entity != null) {
                getSession().remove(entity);
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public StudentAttendanceEntity findById(Long id) {
        return getSession().get(StudentAttendanceEntity.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentAttendanceEntity> findAll() {
        String hql = "FROM StudentAttendanceEntity";
        TypedQuery<StudentAttendanceEntity> query = entityManager.createQuery(hql, StudentAttendanceEntity.class);
        return query.getResultList();
    }

    @Override
    public List<StudentAttendanceEntity> findByStudent(Long std_id) {
        String hql = "FROM StudentAttendanceEntity e WHERE e.studentId=:studentId";
        TypedQuery<StudentAttendanceEntity> query = entityManager.createQuery(hql, StudentAttendanceEntity.class);
        query.setParameter("studentId", std_id);
        return query.getResultList();
    }
}
