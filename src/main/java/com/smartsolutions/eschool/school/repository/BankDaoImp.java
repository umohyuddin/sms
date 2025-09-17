package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.BankEntity;
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
public class BankDaoImp implements  BankDao{

    private final JdbcTemplate jdbcTemplate;
    public BankDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(BankEntity pBankEntity) {
        try {
            pBankEntity.setId(null);
            getSession().persist(pBankEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(BankEntity pBankEntity) {
        try {
            getSession().merge(pBankEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            BankEntity entity = getSession().get(BankEntity.class, id);
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
    public BankEntity findById(Long id) {
        return getSession().get(BankEntity.class, id);
    }

    @Override
    public List<BankEntity> findByInstitute(Long id) {
        String hql = "From BankEntity e where e.instituteId=:id";
        TypedQuery<BankEntity> query = entityManager.createQuery(hql,BankEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<BankEntity> findAll() {
        String hql = "From BankEntity";
        TypedQuery<BankEntity> query = entityManager.createQuery(hql,BankEntity.class);
        return query.getResultList();
    }
}
