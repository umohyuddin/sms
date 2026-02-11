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
        @Query("SELECT s FROM StandardEntity s WHERE s.id = :id AND s.campus.institute.id = :instituteId AND s.deleted = false")
        Optional<StandardEntity> findByIdAndInstituteIdAndDeletedFalse(@Param("id") Long id,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT s FROM StandardEntity s WHERE s.campus.institute.id = :instituteId AND s.deleted = false")
        List<StandardEntity> findByInstituteIdAndDeletedFalse(@Param("instituteId") Long instituteId);

    @Query("SELECT s FROM StandardEntity s " +
            "JOIN FETCH s.campus c " +
            "JOIN FETCH c.institute i " +
            "WHERE c.id = :campusId " +
            "AND i.id = :instituteId " +
            "AND s.deleted = false")
    List<StandardEntity> findByCampusIdAndInstituteId(@Param("campusId") Long campusId,
                                                      @Param("instituteId") Long instituteId);
        // Search by standardName or standardCode with instituteId
        @Query("SELECT sec FROM StandardEntity sec " +
                        "WHERE (sec.standardName LIKE %:keyword% OR sec.standardCode LIKE %:keyword%) " +
                        "AND sec.campus.institute.id = :instituteId " +
                        "AND sec.deleted = false")
        List<StandardEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT s FROM StandardEntity s " +
                        "JOIN FETCH s.campus c " +
                        "WHERE (:campusId IS NULL OR c.id = :campusId) " +
                        "AND c.institute.id = :instituteId " +
                        "AND (:search IS NULL OR LOWER(s.standardName) LIKE LOWER(CONCAT('%', :search, '%')) " +
                        "     OR LOWER(s.standardCode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
                        "AND s.deleted = false " +
                        "ORDER BY s.standardName ASC")
        List<StandardEntity> searchStandardsWithOrg(@Param("campusId") Long campusId,
                        @Param("instituteId") Long instituteId,
                        @Param("search") String search);

        @Modifying
        @Transactional
        @Query("UPDATE StandardEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE s.id = :id AND s.campus.institute.id = :instituteId")
        int softDeleteByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

        @Modifying
        @Transactional
        @Query("UPDATE StandardEntity s SET s.deleted = true, s.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE s.campus.id = :campusId AND s.campus.institute.id = :instituteId AND s.deleted = false")
        int softDeleteByCampusIdAndInstituteId(@Param("campusId") Long campusId,
                        @Param("instituteId") Long instituteId);
}
