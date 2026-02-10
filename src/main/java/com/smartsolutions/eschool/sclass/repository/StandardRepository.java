package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository

public interface StandardRepository extends JpaRepository<StandardEntity, Long> {
    Optional<StandardEntity> findByIdAndDeletedFalse(Long id);

    List<StandardEntity> findByDeletedFalse();

    @Query("SELECT s FROM StandardEntity s WHERE s.campus.id = :campusId AND s.deleted = false")
    List<StandardEntity> findByCampusId(@Param("campusId") Long campusId);


    // Search by sectionName or sectionCode
    @Query("SELECT sec FROM StandardEntity sec " +
            "WHERE (sec.standardName LIKE %:keyword% OR sec.standardCode LIKE %:keyword%) " +
            "AND sec.deleted = false")
    List<StandardEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT s FROM StandardEntity s " +
            "JOIN FETCH s.campus c " +
            "WHERE (:campusId IS NULL OR c.id = :campusId) " +
            "AND (:search IS NULL OR LOWER(s.standardName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "     OR LOWER(s.standardCode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "AND s.deleted = false " +
            "ORDER BY s.standardName ASC")
    List<StandardEntity> searchStandards(@Param("campusId") Long campusId,
                                         @Param("search") String search);


    @Modifying
    @Transactional
    @Query("UPDATE StandardEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " + "WHERE s.id = :id")
    int softDeleteById(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query("UPDATE StandardEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
            "WHERE s.campus.id = :campusId AND s.deleted = false")
    int softDeleteByCampusId(@Param("campusId") Long campusId);
}
