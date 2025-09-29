package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.BankEntity;
import com.smartsolutions.eschool.school.model.ExpensesEntity;

import java.util.List;

public class ExpensesDaoImp implements  ExpensesDao{
    private final JdbcTemplate jdbcTemplate;
    public ExpensesDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(ExpensesEntity pExpensesEntity) {
        try {
            pExpensesEntity.setId(null);
            getSession().persist(pExpensesEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ExpensesEntity pExpensesEntity) {
        try {
            getSession().merge(pExpensesEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            BankEntity entity = getSession().get(ExpensesEntity.class, id);
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
    public ExpensesEntity findById(Long id) {
        return getSession().get(ExpensesEntity.class, id);
    }

    @Override
    public List<ExpensesEntity> findByInstitute(Long id) {
        String hql = "From ExpensesEntity e where e.campusId=:id";
        TypedQuery<BankEntity> query = entityManager.createQuery(hql,ExpensesEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<ExpensesEntity> findByCampus(Long id) {
        String hql = "From ExpensesEntity e where e.campusId=:id";
        TypedQuery<BankEntity> query = entityManager.createQuery(hql,ExpensesEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<ExpensesEntity> findAll() {
        String hql = "From ExpensesEntity";
        TypedQuery<BankEntity> query = entityManager.createQuery(hql,ExpensesEntity.class);
        return query.getResultList();
    }
}
