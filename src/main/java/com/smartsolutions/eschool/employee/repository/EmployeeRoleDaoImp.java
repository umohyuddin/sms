package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeRoleEntity;
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
public class EmployeeRoleDaoImp implements EmployeeRoleDao{

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRoleDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(EmployeeRoleEntity employeeRoleEntity) {
        try {
            employeeRoleEntity.setId(null);
            getSession().persist(employeeRoleEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(EmployeeRoleEntity employeeRoleEntity) {
        try {
            getSession().merge(employeeRoleEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            EmployeeRoleEntity entity = getSession().get(EmployeeRoleEntity.class, id);
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
    public EmployeeRoleEntity findById(Long id) {
        return getSession().get(EmployeeRoleEntity.class, id);
    }

    @Override
    public List<EmployeeRoleEntity> findAll() {
        String hql = "From EmployeeRoleEntity";
        TypedQuery<EmployeeRoleEntity> query = entityManager.createQuery(hql,EmployeeRoleEntity.class);

        return query.getResultList();
    }
}
