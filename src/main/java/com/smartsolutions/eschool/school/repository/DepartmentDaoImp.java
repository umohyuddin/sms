package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DepartmentEntity;
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
public class DepartmentDaoImp implements DepartmentDao {

    private final JdbcTemplate jdbcTemplate;
    public DepartmentDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(DepartmentEntity pDepartmentEntity) {
        try {
            getSession().persist(pDepartmentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(DepartmentEntity pDepartmentEntity) {
        try {
            getSession().merge(pDepartmentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            DepartmentEntity entity = getSession().get(DepartmentEntity.class, id);
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
    public DepartmentEntity findById(Long id) {
        return getSession().get(DepartmentEntity.class, id);
    }

    @Override
    public List<DepartmentEntity> findAll() {
        String hql = "From DepartmentEntity";
        TypedQuery<DepartmentEntity> query = entityManager.createQuery(hql,DepartmentEntity.class);

        return query.getResultList();
    }
}
