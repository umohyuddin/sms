package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
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
public class TimeTableDaoImp implements TimeTableDao {
    private final JdbcTemplate jdbcTemplate;

    public TimeTableDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(TimeTableEntity pTimeTableEntity) {
        try {
            pTimeTableEntity.setClassId(null);
            getSession().persist(pTimeTableEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(TimeTableEntity pTimeTableEntity) {
        try {
            getSession().merge(pTimeTableEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            TimeTableEntity entity = getSession().get(TimeTableEntity.class, id);
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
    public TimeTableEntity findById(Long id) {
        return getSession().get(TimeTableEntity.class, id);
    }

    @Override
    public List<TimeTableEntity> findAll() {
        String hql = "FROM TimeTableEntity";
        TypedQuery<TimeTableEntity> query = entityManager.createQuery(hql, TimeTableEntity.class);
        return query.getResultList();
    }

    @Override
    public List<TimeTableEntity> findByTeacherId(Long id) {
        String hql = "FROM TimeTableEntity e WHERE e.teacherId = :id";
        TypedQuery<TimeTableEntity> query = entityManager.createQuery(hql, TimeTableEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<TimeTableEntity> findByClassId(Long id) {
        String hql = "FROM TimeTableEntity e WHERE e.classId = :id";
        TypedQuery<TimeTableEntity> query = entityManager.createQuery(hql, TimeTableEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
