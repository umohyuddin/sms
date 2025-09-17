package com.smartsolutions.eschool.school.repository;
import com.smartsolutions.eschool.school.model.MarksGradingEntity;
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
public class MarksGradingDaoImp implements  MarksGradingDao {

    private final JdbcTemplate jdbcTemplate;
    public MarksGradingDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public int save(MarksGradingEntity pMarksGradingEntity) {
        try {
            pMarksGradingEntity.setId(null);
            getSession().persist(pMarksGradingEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(MarksGradingEntity pMarksGradingEntity) {
        try {
            getSession().merge(pMarksGradingEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            MarksGradingEntity entity = getSession().get(MarksGradingEntity.class, id);
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
    public MarksGradingEntity findById(Long id) {
        return getSession().get(MarksGradingEntity.class, id);
    }

    @Override
    public List<MarksGradingEntity> findByInstitute(Long id) {
        String hql = "From MarksGradingEntity e where e.instituteId=:id";
        TypedQuery<MarksGradingEntity> query = entityManager.createQuery(hql,MarksGradingEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<MarksGradingEntity> findAll() {
        String hql = "From MarksGradingEntity";
        TypedQuery<MarksGradingEntity> query = entityManager.createQuery(hql,MarksGradingEntity.class);
        return query.getResultList();
    }
}
