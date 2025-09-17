package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.UserRoleEntity;
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
public class UserRoleDaoImpl implements UserRoleDao{
    private final JdbcTemplate jdbcTemplate;

    public UserRoleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(UserRoleEntity userRoleEntity) {
        try {
            userRoleEntity.setId(null);
            getSession().persist(userRoleEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(UserRoleEntity userRoleEntity) {
        try {
            getSession().merge(userRoleEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteById(Long id) {
        try {
            UserRoleEntity entity = getSession().get(UserRoleEntity.class, id);
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
    public List<UserRoleEntity> findById(Long id) {
        String hql = "FROM UserRoleEntity u WHERE u.id = :roleId";
        TypedQuery<UserRoleEntity> query = entityManager.createQuery(hql, UserRoleEntity.class);
        query.setParameter("roleId", id);
        return query.getResultList();
       // return getSession().get(UserRoleEntity.class, id);
    }

    @Override
    public List<UserRoleEntity> findAll() {
        String hql = "FROM UserRoleEntity";
        TypedQuery<UserRoleEntity> query = entityManager.createQuery(hql, UserRoleEntity.class);
        return query.getResultList();
    }
}
