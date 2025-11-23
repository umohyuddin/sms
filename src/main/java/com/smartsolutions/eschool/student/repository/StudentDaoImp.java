package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
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
public class StudentDaoImp implements StudentDao{

    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    @Override
    public int save(StudentEntity pStudentEntity) {
        try {
//            pStudentEntity.setId(null);
//            getSession().persist(pStudentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(StudentEntity pStudentEntity) {
        try {
            getSession().merge(pStudentEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            StudentEntity entity = getSession().get(StudentEntity.class, id);
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
    public StudentEntity findById(Long id) {
        return getSession().get(StudentEntity.class, id);
    }

    @Override
    public List<StudentEntity> findAll() {
        try {
            String hql = "FROM StudentEntity";
            TypedQuery<StudentEntity> query = entityManager.createQuery(hql, StudentEntity.class);
            List<StudentEntity> results = query.getResultList();
            return results;
        } catch (Exception e) {
            log.error("Error while fetching all students", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<StudentEntity> findByCampus(Long cmp_id) {
        String hql = "FROM StudentEntity c WHERE c.campusId = :cmp_id";
        TypedQuery<StudentEntity> query = entityManager.createQuery(hql, StudentEntity.class);
        query.setParameter("cmp_id", cmp_id);
        return query.getResultList();
    }

    @Deprecated
    @Override
    public List<StudentEntity> findByInstitute(Long inst_id) {
        String hql = "FROM StudentEntity";
        TypedQuery<StudentEntity> query = entityManager.createQuery(hql, StudentEntity.class);
        return query.getResultList();
    }
}
