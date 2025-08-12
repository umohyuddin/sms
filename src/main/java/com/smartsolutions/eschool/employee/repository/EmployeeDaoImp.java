package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
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
public class EmployeeDaoImp implements EmployeeDao{

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(EmployeeEntity employeeEntity) {

        try {
            getSession().persist(employeeEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(EmployeeEntity employeeEntity) {
        try {
            getSession().merge(employeeEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            EmployeeEntity entity = getSession().get(EmployeeEntity.class, id);
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
    public EmployeeEntity findById(Long id) {
        return getSession().get(EmployeeEntity.class, id);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        String hql = "FROM EmployeeEntity";
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(hql, EmployeeEntity.class);
        return query.getResultList();
    }

    @Override
    public List<EmployeeEntity> findByCampus(Long campus_id) {
        String hql = "FROM EmployeeEntity e where e.campusId = :campus_id";
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(hql, EmployeeEntity.class);
        query.setParameter("campus_id", campus_id);
        return query.getResultList();
    }

    @Deprecated
    @Override
    public List<EmployeeEntity> findByInstitute(Long institute_id) {
        String hql = "FROM EmployeeEntity e where e.campusId = :campus_id";
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(hql, EmployeeEntity.class);
        query.setParameter("campus_id", institute_id);
        return query.getResultList();
    }
}
