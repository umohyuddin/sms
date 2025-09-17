package com.smartsolutions.eschool.school.repository;
import com.smartsolutions.eschool.school.model.FailCriteriaEntity;
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
public class FailCriteriaDaoImp implements  FailCriteriaDao{

    private final JdbcTemplate jdbcTemplate;
    public FailCriteriaDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(FailCriteriaEntity pFailCriteriaEntity) {
        try {
            pFailCriteriaEntity.setId(null);
            getSession().persist(pFailCriteriaEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(FailCriteriaEntity pFailCriteriaEntity) {
        try {
            getSession().merge(pFailCriteriaEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            FailCriteriaEntity entity = getSession().get(FailCriteriaEntity.class, id);
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
    public FailCriteriaEntity findById(Long id) {
        return getSession().get(FailCriteriaEntity.class, id);
    }

    @Override
    public List<FailCriteriaEntity> findByInstitute(Long id) {
        String hql = "From FailCriteriaEntity e where e.instituteId=:id";
        TypedQuery<FailCriteriaEntity> query = entityManager.createQuery(hql,FailCriteriaEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<FailCriteriaEntity> findAll() {
        String hql = "From FailCriteriaEntity";
        TypedQuery<FailCriteriaEntity> query = entityManager.createQuery(hql,FailCriteriaEntity.class);
        return query.getResultList();
    }
}
