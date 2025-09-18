package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.AssessmentEntity;
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
public class AssessmentDaoImp implements  AssessmentDao{

    private final JdbcTemplate jdbcTemplate;

    public AssessmentDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(AssessmentEntity pAssessmentEntity) {
        try {
            pAssessmentEntity.setId(null);
            getSession().persist(pAssessmentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(AssessmentEntity pAssessmentEntity) {
        try {
            getSession().merge(pAssessmentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            AssessmentEntity entity = getSession().get(AssessmentEntity.class, id);
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
    public AssessmentEntity findById(Long id) {
        return getSession().get(AssessmentEntity.class, id);
    }

    @Override
    public List<AssessmentEntity> findAll() {
        String hql = "FROM AssessmentEntity";
        TypedQuery<AssessmentEntity> query = entityManager.createQuery(hql, AssessmentEntity.class);
        return query.getResultList();
    }

    @Override
    public List<AssessmentEntity> findByStudentId(Long std_id) {
        String hql = "FROM AssessmentEntity e WHERE e.enrollment.studentId =:studentId";
        TypedQuery<AssessmentEntity> query = entityManager.createQuery(hql, AssessmentEntity.class);
        query.setParameter("studentId", std_id);
        return query.getResultList();
    }

    @Override
    public List<AssessmentEntity> findByCourseId(Long course_id) {
        String hql = "FROM AssessmentEntity e WHERE e.enrollment.courseId =:courseId";
        TypedQuery<AssessmentEntity> query = entityManager.createQuery(hql, AssessmentEntity.class);
        query.setParameter("courseId", course_id);
        return query.getResultList();
    }

    @Override
    public List<AssessmentEntity> findStudentWithinCourse(Long std_id, Long course_id) {
        String hql = "FROM AssessmentEntity e WHERE e.enrollment.studentId=:studentId AND e.enrollment.courseId =:courseId";
        TypedQuery<AssessmentEntity> query = entityManager.createQuery(hql, AssessmentEntity.class);
        query.setParameter("courseId", course_id);
        query.setParameter("studentId", std_id);
        return query.getResultList();
    }
}
