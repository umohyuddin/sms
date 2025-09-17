package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(UserEntity userEntity) {
        try {
            userEntity.setId(null);
            getSession().persist(userEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(UserEntity userEntity) {
        try {
            getSession().merge(userEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteById(Long id) {
        try {
            UserEntity entity = getSession().get(UserEntity.class, id);
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
    public UserEntity findById(Long id) {
        return getSession().get(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> findByUserName(String userName) {
        String hql = "FROM UserEntity u WHERE u.email = :email";
        TypedQuery<UserEntity> query = entityManager.createQuery(hql, UserEntity.class);
        query.setParameter("email", userName);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> findAll() {
        String hql = "FROM UserEntity";
        TypedQuery<UserEntity> query = entityManager.createQuery(hql, UserEntity.class);
        return query.getResultList();
    }
    @Override
    public List<UserEntity> findUsers(Long institute_Id, Long camp_id) {
        String hql = "FROM UserEntity u WHERE u.cmpId = :campusId";
        TypedQuery<UserEntity> query = entityManager.createQuery(hql, UserEntity.class);
//        query.setParameter("instituteId", institute_Id);
        query.setParameter("campusId", camp_id);
        return query.getResultList();
    }
}

