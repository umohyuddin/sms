package com.smartsolutions.eschool.course.repository;

import com.smartsolutions.eschool.course.model.CourseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class CourseDaoImp implements CourseDao {
    private final JdbcTemplate jdbcTemplate;

    public CourseDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(CourseEntity pCourseEntity) {
        try {
            getSession().persist(pCourseEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(CourseEntity pCourseEntity) {
        try {
            getSession().merge(pCourseEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            CourseEntity entity = getSession().get(CourseEntity.class, id);
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
    public CourseEntity findById(Long id) {
        return getSession().get(CourseEntity.class, id);
    }

    @Override
    public List<CourseEntity> findAll() {
        String hql = "FROM CourseEntity";
        TypedQuery<CourseEntity> query = entityManager.createQuery(hql, CourseEntity.class);
        return query.getResultList();
    }

    @Override
    public List<CourseEntity> findByTeacherId(Long id) {
        String hql = "FROM CourseEntity e WHERE e.teacherId = :teacherId";
        TypedQuery<CourseEntity> query = entityManager.createQuery(hql, CourseEntity.class);
        query.setParameter("teacherId", id);
        return query.getResultList();
    }

    @Override
    public List<CourseEntity> findByDepartmentId(Long id) {
        String hql = "FROM CourseEntity WHERE e.department = :departmentId";
        TypedQuery<CourseEntity> query = entityManager.createQuery(hql, CourseEntity.class);
        query.setParameter("departmentId", id);
        return query.getResultList();
    }
}
