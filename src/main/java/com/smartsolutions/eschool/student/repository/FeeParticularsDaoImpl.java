package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeParticularsEntity;
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
public class FeeParticularsDaoImpl implements  FeeParticularsDao{

    private final JdbcTemplate jdbcTemplate;

    public FeeParticularsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(FeeParticularsEntity pFeeParticularsEntity) {
        try {
            pFeeParticularsEntity.setId(null);
            getSession().persist(pFeeParticularsEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(FeeParticularsEntity pFeeParticularsEntity) {
        try {
            getSession().merge(pFeeParticularsEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            FeeParticularsEntity entity = getSession().get(FeeParticularsEntity.class, id);
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
    public FeeParticularsEntity findById(Long id) {
        return getSession().get(FeeParticularsEntity.class, id);
    }

    @Override
    public List<FeeParticularsEntity> findAll() {
        String hql = "FROM FeeParticularsEntity";
        TypedQuery<FeeParticularsEntity> query = entityManager.createQuery(hql, FeeParticularsEntity.class);
        return query.getResultList();
    }


    @Override
    public List<FeeParticularsEntity> findByInstitute(Long id) {
        String hql = "FROM FeeParticularsEntity e where e.instituteId = :id";
        TypedQuery<FeeParticularsEntity> query = entityManager.createQuery(hql, FeeParticularsEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
