package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Transactional
@Repository
@Slf4j
public class SectionDaoImp implements  SectionDao {

    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public int save(SectionEntity pSectionEntity) {
        try {
            pSectionEntity.setId(null);
            getSession().persist(pSectionEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(SectionEntity pSectionEntity) {
        try {
            getSession().merge(pSectionEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            SectionEntity entity = getSession().get(SectionEntity.class, id);
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
    public SectionEntity findById(Long id) {
        return getSession().get(SectionEntity.class, id);
    }

    @Override
    public List<SectionEntity> findAll() {
        try {
            //String hql = "FROM SectionEntity";
            String hql = "SELECT s FROM SectionEntity s LEFT JOIN FETCH s.standard";
            TypedQuery<SectionEntity> query = entityManager.createQuery(hql, SectionEntity.class);
            List<SectionEntity> results = query.getResultList();

            return results;
        } catch (Exception e) {
            log.error("Error while fetching all sections", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<SectionEntity> findByClassId(Long id) {
        String hql = "FROM SectionEntity e WHERE e.classId = :id";
        TypedQuery<SectionEntity> query = entityManager.createQuery(hql, SectionEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<SectionEntity> findByCampusId(Long id) {
        String hql = "FROM SectionEntity e WHERE e.class.campusId = :id";
        TypedQuery<SectionEntity> query = entityManager.createQuery(hql, SectionEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<SectionEntity> findByInstituteId(Long id) {
        String hql = "FROM SectionEntity e WHERE e.class.campus.instituteId = :id";
        TypedQuery<SectionEntity> query = entityManager.createQuery(hql, SectionEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
