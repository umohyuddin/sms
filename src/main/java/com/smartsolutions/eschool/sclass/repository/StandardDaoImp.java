package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository
@Slf4j
public class StandardDaoImp implements StandardDao {
    private final JdbcTemplate jdbcTemplate;

    public StandardDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(StandardEntity standardEntity ) {
        try {
            standardEntity.setId(null);
            getSession().persist(standardEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(StandardEntity standardEntity) {
        try {
            getSession().merge(standardEntity);
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
    public StandardEntity findById(Long id) {
        return getSession().get(StandardEntity.class, id);
    }

    @Override
    public List<StandardEntity> findAll() {
        try {
            String hql = "FROM StandardEntity ";
            TypedQuery<StandardEntity> query = entityManager.createQuery(hql, StandardEntity.class);
            List<StandardEntity> results = query.getResultList();
            return results;
        } catch (Exception e) {
            log.error("Error while fetching all standards", e);
            return Collections.emptyList();
        }
    }



//    @Override
//    public List<SClassEntity> findByTeacherId(Long id) {
//        String hql = "FROM SClassEntity e WHERE e.course.teacherId = :teacherId";
//        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
//        query.setParameter("teacherId", id);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<SClassEntity> findByCourseId(Long id) {
//        String hql = "FROM SClassEntity e WHERE e.courseId=:courseId";
//        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
//        query.setParameter("courseId", id);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<SClassEntity> findByStudentId(Long id) {
//        String hql = "FROM SClassEntity e Where e.studentId=:studentId";
//        TypedQuery<SClassEntity> query = entityManager.createQuery(hql, SClassEntity.class);
//        query.setParameter("studentId", id);
//        return query.getResultList();
//    }
}
