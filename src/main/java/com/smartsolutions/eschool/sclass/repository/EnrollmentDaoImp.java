package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
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
    public int save(SClassEntity pSClassEntity) {
        try {
            pSClassEntity.setId(null);
            getSession().persist(pSClassEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(SClassEntity pSClassEntity) {
        try {
            getSession().merge(pSClassEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            SClassEntity entity = getSession().get(SClassEntity.class, id);
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
    public SClassEntity findById(Long id) {
        return getSession().get(SClassEntity.class, id);
    }

    @Override
    public List<SClassEntity> findAll() {
        String hql = "FROM SClassEntity";
        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
        return query.getResultList();
    }

    @Override
    public List<SClassEntity> findByTeacherId(Long id) {
        String hql = "FROM SClassEntity e WHERE e.course.teacherId = :teacherId";
        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
        query.setParameter("teacherId", id);
        return query.getResultList();
    }

    @Override
    public List<SClassEntity> findByCourseId(Long id) {
        String hql = "FROM SClassEntity e WHERE e.courseId=:courseId";
        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
        query.setParameter("courseId", id);
        return query.getResultList();
    }

    @Override
    public List<SClassEntity> findByStudentId(Long id) {
        String hql = "FROM SClassEntity e Where e.studentId=:studentId";
        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
        query.setParameter("studentId", id);
        return query.getResultList();
    }
}
