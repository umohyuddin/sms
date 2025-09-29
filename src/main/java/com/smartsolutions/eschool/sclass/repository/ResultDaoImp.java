package com.smartsolutions.eschool.sclass.repository;

import java.util.List;
import com.smartsolutions.eschool.sclass.model.ResultEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ResultDaoImp implements ResultDao{

    private final JdbcTemplate jdbcTemplate;
    public ResultDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(ResultEntity pResultEntity) {
        try {
            pResultEntity.setId(null);
            getSession().persist(pResultEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ResultEntity pResultEntity) {
        try {
            getSession().merge(pResultEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            ResultEntity entity = getSession().get(ResultEntity.class, id);
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
    public ResultEntity findById(Long id) {
        return getSession().get(ResultEntity.class, id);
    }

    @Override
    public List<ResultEntity> findAll() {
        String hql = "FROM ResultEntity";
        TypedQuery<ResultEntity> query = entityManager.createQuery(hql, ResultEntity.class);
        return query.getResultList();
    }

    @Override
    public List<ResultEntity> findByClassId(Long id) {
        String hql = "FROM ResultEntity e where e.studentId:=id";
        TypedQuery<ResultEntity> query = entityManager.createQuery(hql, ResultEntity.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public List<ResultEntity> findBySubjectId(Long id) {
        String hql = "FROM ResultEntity e where e.subjectId:=id";
        TypedQuery<ResultEntity> query = entityManager.createQuery(hql, ResultEntity.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public List<ResultEntity> findByStudentId(Long id) {
        String hql = "FROM ResultEntity e where e.studentId:=id";
        TypedQuery<ResultEntity> query = entityManager.createQuery(hql, ResultEntity.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
