package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.MCQEntity;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MCQDaoImp implements  MCQDao{

    private final JdbcTemplate jdbcTemplate;
    public MCQDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public int save(MCQEntity pMCQEntity) {
        try {
            pMCQEntity.setId(null);
            getSession().persist(pMCQEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(MCQEntity pMCQEntity) {
        try {
            getSession().merge(pMCQEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            MCQEntity entity = getSession().get(MCQEntity.class, id);
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
    public MCQEntity findById(Long id) {
        return getSession().get(MCQEntity.class, id);
    }

    @Override
    public List<MCQEntity> findAll() {
        String hql = "FROM MCQEntity";
        TypedQuery<MCQEntity> query = entityManager.createQuery(hql, MCQEntity.class);
        return query.getResultList();
    }

    @Override
    public List<MCQEntity> findByChapter(Long sid, Long chp) {
        String hql = "FROM MCQEntity e where e.subjectId:=id AND e.chapter:=chp";
        TypedQuery<MCQEntity> query = entityManager.createQuery(hql, MCQEntity.class);
        query.setParameter("id",sid);
        query.setParameter("chp",chp);
        return query.getResultList();
    }

    @Override
    public List<MCQEntity> findBySubjectId(Long id) {
        String hql = "FROM MCQEntity e where e.subjectId:=id";
        TypedQuery<MCQEntity> query = entityManager.createQuery(hql, MCQEntity.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
