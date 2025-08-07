package com.smartsolutions.eschool.employee.repository.sql;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.employee.model.EmployeeSalaryEntity;
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
public class EmployeeSalaryDaoImp implements  EmployeeSalaryDao{

    private final JdbcTemplate jdbcTemplate;

    public EmployeeSalaryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(EmployeeSalaryEntity employeeSalaryEntity) {
        try {
            getSession().persist(employeeSalaryEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(EmployeeSalaryEntity employeeSalaryEntity) {
        try {
            getSession().merge(employeeSalaryEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            EmployeeSalaryEntity entity = getSession().get(EmployeeSalaryEntity.class, id);
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
    public EmployeeSalaryEntity findById(Long id) {
        return  getSession().get(EmployeeSalaryEntity.class, id);
    }

    @Override
    public List<EmployeeSalaryEntity> findAll() {
        String hql = "FROM EmployeeSalaryEntity";
        TypedQuery<EmployeeSalaryEntity> query = entityManager.createQuery(hql, EmployeeSalaryEntity.class);
        return query.getResultList();
    }

    @Override
    public List<EmployeeSalaryEntity> findByEmpId(Long emp_id) {
        String hql = "FROM EmployeeSalaryEntity e WHERE e.empId = :emp_id";
        TypedQuery<EmployeeSalaryEntity> query = entityManager.createQuery(hql, EmployeeSalaryEntity.class);
        query.setParameter("emp_id", emp_id);
        return query.getResultList();
    }
}
