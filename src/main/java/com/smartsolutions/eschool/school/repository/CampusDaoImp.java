package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
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
public class CampusDaoImp implements CampusDao{

    private final JdbcTemplate jdbcTemplate;
    public CampusDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(CampusEntity pCampusEntity) {
        try {
            pCampusEntity.setCampusId(null);
            getSession().persist(pCampusEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(CampusEntity pCampusEntity) {
        try {
            getSession().merge(pCampusEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            CampusEntity entity = getSession().get(CampusEntity.class, id);
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
    public CampusEntity findById(Long id) {
        return getSession().get(CampusEntity.class, id);
    }

    @Override
    public List<CampusEntity> findAll() {
        String hql = "From CampusEntity";
        TypedQuery<CampusEntity> query = entityManager.createQuery(hql,CampusEntity.class);

        return query.getResultList();
    }
}
