package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.student.model.FeeEntity;
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
public class FeeDaoImp implements FeeDao{

    private final JdbcTemplate jdbcTemplate;

    public FeeDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(FeeEntity pFeeEntity) {
        try {
            pFeeEntity.setId(null);
            getSession().persist(pFeeEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(FeeEntity pFeeEntity) {
        try {
            getSession().merge(pFeeEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            FeeEntity entity = getSession().get(FeeEntity.class, id);
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
    public FeeEntity findById(Long id) {
        return getSession().get(FeeEntity.class, id);
    }

    @Override
    public List<FeeEntity> findAll() {
        String hql = "FROM FeeEntity";
        TypedQuery<FeeEntity> query = entityManager.createQuery(hql, FeeEntity.class);
        return query.getResultList();
    }

    @Override
    public List<FeeEntity> findByStudent(Long std_id) {
        String hql = "FROM FeeEntity e WHERE e.studentId = :std_id";
        TypedQuery<FeeEntity> query = entityManager.createQuery(hql, FeeEntity.class);
        query.setParameter("std_id", std_id);
        return query.getResultList();
    }
}
