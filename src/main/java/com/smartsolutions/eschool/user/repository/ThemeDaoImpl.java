package com.smartsolutions.eschool.user.repository;

import com.smartsolutions.eschool.user.model.ThemeEntity;
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
public class ThemeDaoImpl implements  ThemeDao{

    private final JdbcTemplate jdbcTemplate;

    public ThemeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(ThemeEntity pThemeEntity) {
        try {
            pThemeEntity.setId(null);
            getSession().persist(pThemeEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ThemeEntity pThemeEntity) {
        try {
            getSession().merge(pThemeEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            ThemeEntity entity = getSession().get(ThemeEntity.class, id);
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
    public ThemeEntity findById(Long id) {
        return getSession().get(ThemeEntity.class, id);
    }

    @Override
    public List<ThemeEntity> findAll() {
        String hql = "FROM ThemeEntity";
        TypedQuery<ThemeEntity> query = entityManager.createQuery(hql, ThemeEntity.class);
        return query.getResultList();
    }

    @Override
    public List<ThemeEntity> findByUser(Long id) {
        String hql = "FROM ThemeEntity u WHERE u.id = :id";
        TypedQuery<ThemeEntity> query = entityManager.createQuery(hql, ThemeEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<ThemeEntity> findByInstitute(Long id) {
        String hql = "FROM ThemeEntity u WHERE u.instituteId = :id";
        TypedQuery<ThemeEntity> query = entityManager.createQuery(hql, ThemeEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
