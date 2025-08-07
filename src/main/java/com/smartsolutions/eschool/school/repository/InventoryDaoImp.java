package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InventoryEntity;
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
public class InventoryDaoImp implements InventoryDao {

    private final JdbcTemplate jdbcTemplate;
    public InventoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(InventoryEntity pInventoryEntity) {
        try {
            getSession().persist(pInventoryEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(InventoryEntity pInventoryEntity) {
        try {
            getSession().merge(pInventoryEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            InventoryEntity entity = getSession().get(InventoryEntity.class, id);
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
    public InventoryEntity findById(Long id) {
        return getSession().get(InventoryEntity.class, id);
    }

    @Override
    public List<InventoryEntity> findByCampus(Long id) {
        String hql = "From InventoryEntity e WHERE e.campusId=:id";
        TypedQuery<InventoryEntity> query = entityManager.createQuery(hql,InventoryEntity.class);

        return query.getResultList();
    }

    @Deprecated
    @Override
    public List<InventoryEntity> findByInstitute(Long id) {
        String hql = "From InventoryEntity";
        TypedQuery<InventoryEntity> query = entityManager.createQuery(hql,InventoryEntity.class);

        return query.getResultList();
    }

    @Override
    public List<InventoryEntity> findAll() {
        String hql = "From InventoryEntity";
        TypedQuery<InventoryEntity> query = entityManager.createQuery(hql,InventoryEntity.class);

        return query.getResultList();
    }
}
