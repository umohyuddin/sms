package com.smartsolutions.eschool.employee.repository.sql;

import com.smartsolutions.eschool.employee.model.EmployeeAttendanceEntity;
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
public class EmployeeAttendanceDaoImp implements EmployeeAttendanceDao{

    private final JdbcTemplate jdbcTemplate;

    public EmployeeAttendanceDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(EmployeeAttendanceEntity employeeAttendanceEntity) {
        try {
            getSession().persist(employeeAttendanceEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(EmployeeAttendanceEntity employeeAttendanceEntity) {
        try {
            getSession().persist(employeeAttendanceEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            EmployeeAttendanceEntity entity = getSession().get(EmployeeAttendanceEntity.class, id);
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
    public EmployeeAttendanceEntity findById(Long id) {
        return getSession().get(EmployeeAttendanceEntity.class, id);
    }

    @Override
    public List<EmployeeAttendanceEntity> findAll() {
        String hql = "FROM EmployeeAttendanceEntity";
        TypedQuery<EmployeeAttendanceEntity> query = entityManager.createQuery(hql, EmployeeAttendanceEntity.class);
        return query.getResultList();
    }
    @Override
    public List<EmployeeAttendanceEntity> findByEmpId(Long emp_id) {
        String hql = "FROM EmployeeAttendanceEntity e where e.empId = :emp_id";
        TypedQuery<EmployeeAttendanceEntity> query = entityManager.createQuery(hql, EmployeeAttendanceEntity.class);
        query.setParameter("emp_id", emp_id);
        return query.getResultList();
    }
}
