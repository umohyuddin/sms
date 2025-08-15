package com.smartsolutions.eschool.course.repository;

import com.smartsolutions.eschool.course.model.EnrollmentEntity;
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
public class EnrollmentDaoImp implements EnrollmentDao{
    private final JdbcTemplate jdbcTemplate;

    public EnrollmentDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(EnrollmentEntity pEnrollmentEntity) {
        try {
            getSession().persist(pEnrollmentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(EnrollmentEntity pEnrollmentEntity) {
        try {
            getSession().merge(pEnrollmentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            EnrollmentEntity entity = getSession().get(EnrollmentEntity.class, id);
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
    public EnrollmentEntity findById(Long id) {
        return getSession().get(EnrollmentEntity.class, id);
    }

    @Override
    public List<EnrollmentEntity> findAll() {
        String hql = "FROM EnrollmentEntity";
        TypedQuery<EnrollmentEntity> query = entityManager.createQuery(hql, EnrollmentEntity.class);
        return query.getResultList();
    }

    @Override
    public List<EnrollmentEntity> findByTeacherId(Long id) {
        String hql = "FROM EnrollmentEntity e WHERE e.course.teacherId = :teacherId";
        TypedQuery<EnrollmentEntity> query = entityManager.createQuery(hql, EnrollmentEntity.class);
        query.setParameter("teacherId", id);
        return query.getResultList();
    }

    @Override
    public List<EnrollmentEntity> findByCourseId(Long id) {
        String hql = "FROM EnrollmentEntity e WHERE e.courseId=:courseId";
        TypedQuery<EnrollmentEntity> query = entityManager.createQuery(hql, EnrollmentEntity.class);
        query.setParameter("courseId", id);
        return query.getResultList();
    }

    @Override
    public List<EnrollmentEntity> findByStudentId(Long id) {
        String hql = "FROM EnrollmentEntity e Where e.studentId=:studentId";
        TypedQuery<EnrollmentEntity> query = entityManager.createQuery(hql, EnrollmentEntity.class);
        query.setParameter("studentId", id);
        return query.getResultList();
    }
}
