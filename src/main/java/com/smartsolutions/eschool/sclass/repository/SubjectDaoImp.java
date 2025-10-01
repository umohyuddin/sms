package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SubjectEntity;
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
public class SubjectDaoImp implements SubjectDao {
    private final JdbcTemplate jdbcTemplate;

    public SubjectDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(SubjectEntity pSubjectEntity) {
        try {
            pSubjectEntity.setId(null);
            getSession().persist(pSubjectEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(SubjectEntity pSubjectEntity) {
        try {
            getSession().merge(pSubjectEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            SubjectEntity entity = getSession().get(SubjectEntity.class, id);
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
    public SubjectEntity findById(Long id) {
        return getSession().get(SubjectEntity.class, id);
    }

    @Override
    public List<SubjectEntity> findAll() {
        String hql = "FROM SubjectEntity";
        TypedQuery<SubjectEntity> query = entityManager.createQuery(hql, SubjectEntity.class);
        return query.getResultList();
    }

    @Override
    public List<SubjectEntity> findByTeacherId(Long id) {
        String hql = "FROM SubjectEntity e WHERE e.teacherId = :teacherId";
        TypedQuery<SubjectEntity> query = entityManager.createQuery(hql, SubjectEntity.class);
        query.setParameter("teacherId", id);
        return query.getResultList();
    }

    @Override
    public List<SubjectEntity> findByClassId(Long id) {
        String hql = "FROM SubjectEntity e WHERE e.classId = :id";
        TypedQuery<SubjectEntity> query = entityManager.createQuery(hql, SubjectEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
