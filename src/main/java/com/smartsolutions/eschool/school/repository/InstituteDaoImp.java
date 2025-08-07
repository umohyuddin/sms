package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteEntity;
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
public class InstituteDaoImp implements InstituteDao{

    private final JdbcTemplate jdbcTemplate;
    public InstituteDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(InstituteEntity pInstituteEntity) {
        try {
            getSession().persist(pInstituteEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(InstituteEntity pInstituteEntity) {
        try {
            getSession().merge(pInstituteEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            InstituteEntity entity = getSession().get(InstituteEntity.class, id);
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
    public InstituteEntity findById(Long id) {
        return getSession().get(InstituteEntity.class, id);
    }

    @Override
    public List<InstituteEntity> findAll() {
        String hql = "From InstituteEntity";
        TypedQuery<InstituteEntity> query = entityManager.createQuery(hql,InstituteEntity.class);

        return query.getResultList();
    }
}
