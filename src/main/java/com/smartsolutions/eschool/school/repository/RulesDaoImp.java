package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.RulesEntity;
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
public class RulesDaoImp implements  RulesDao{

    private final JdbcTemplate jdbcTemplate;
    public RulesDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(RulesEntity pRulesEntity) {
        try {
            pRulesEntity.setId(null);
            getSession().persist(pRulesEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(RulesEntity pRulesEntity) {
        try {
            getSession().merge(pRulesEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            RulesEntity entity = getSession().get(RulesEntity.class, id);
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
    public RulesEntity findByInstitute(Long id) {
        String hql = "From RulesEntity e where e.instituteId=:id";
        TypedQuery<RulesEntity> query = entityManager.createQuery(hql,RulesEntity.class);
        query.setParameter("id", id);
        List<RulesEntity> rulesEntity = query.getResultList();
        return rulesEntity.size() > 0 ? rulesEntity.get(0):null;
    }
}
