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
        @Query("SELECT s FROM StandardEntity s JOIN FETCH s.campus c JOIN FETCH c.institute i LEFT JOIN FETCH i.country LEFT JOIN FETCH c.province LEFT JOIN FETCH c.city WHERE s.id = :id AND i.id = :instituteId")
        Optional<StandardEntity> findByIdAndInstituteIdAndDeletedFalse(@Param("id") Long id,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT s FROM StandardEntity s JOIN FETCH s.campus c JOIN FETCH c.institute i LEFT JOIN FETCH i.country LEFT JOIN FETCH c.province LEFT JOIN FETCH c.city WHERE i.id = :instituteId")
        List<StandardEntity> findByInstituteIdAndDeletedFalse(@Param("instituteId") Long instituteId);

        @Query("SELECT s FROM StandardEntity s " +
                        "JOIN FETCH s.campus c " +
                        "JOIN FETCH c.institute i " +
                        "LEFT JOIN FETCH i.country " +
                        "LEFT JOIN FETCH c.province " +
                        "LEFT JOIN FETCH c.city " +
                        "WHERE c.id = :campusId " +
                        "AND i.id = :instituteId")
        List<StandardEntity> findByCampusIdAndInstituteId(@Param("campusId") Long campusId,
                        @Param("instituteId") Long instituteId);

        // Search by standardName or standardCode with instituteId
        @Query("SELECT sec FROM StandardEntity sec " +
                        "JOIN FETCH sec.campus c " +
                        "JOIN FETCH c.institute i " +
                        "LEFT JOIN FETCH i.country " +
                        "LEFT JOIN FETCH c.province " +
                        "LEFT JOIN FETCH c.city " +
                        "WHERE (sec.standardName LIKE %:keyword% OR sec.standardCode LIKE %:keyword%) " +
                        "AND i.id = :instituteId")
        List<StandardEntity> searchByKeywordAndInstituteId(@Param("keyword") String keyword,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT s FROM StandardEntity s " +
                        "JOIN FETCH s.campus c " +
                        "JOIN FETCH c.institute i " +
                        "LEFT JOIN FETCH i.country " +
                        "LEFT JOIN FETCH c.province " +
                        "LEFT JOIN FETCH c.city " +
                        "WHERE (:campusId IS NULL OR c.id = :campusId) " +
                        "AND i.id = :instituteId " +
                        "AND (:search IS NULL OR LOWER(s.standardName) LIKE LOWER(CONCAT('%', :search, '%')) " +
                        "     OR LOWER(s.standardCode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
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
                        "WHERE s.campus.id = :campusId AND s.campus.institute.id = :instituteId")
        int softDeleteByCampusIdAndInstituteId(@Param("campusId") Long campusId,
                        @Param("instituteId") Long instituteId);

        @Query("SELECT (COUNT(s) > 0) FROM StandardEntity s WHERE s.campus.institute.id = :instituteId AND s.standardCode = :standardCode")
        boolean existsByInstituteIdAndStandardCode(@Param("instituteId") Long instituteId,
                        @Param("standardCode") String standardCode);

        @Query("SELECT (COUNT(s) > 0) FROM StandardEntity s WHERE s.campus.institute.id = :instituteId AND s.standardCode = :standardCode AND s.id <> :id")
        boolean existsByInstituteIdAndStandardCodeAndIdNot(@Param("instituteId") Long instituteId,
                        @Param("standardCode") String standardCode, @Param("id") Long id);

        @Query("SELECT (COUNT(s) > 0) FROM StandardEntity s WHERE s.campus.institute.id = :instituteId AND s.standardName = :standardName")
        boolean existsByInstituteIdAndStandardName(@Param("instituteId") Long instituteId,
                        @Param("standardName") String standardName);

        @Query("SELECT (COUNT(s) > 0) FROM StandardEntity s WHERE s.campus.institute.id = :instituteId AND s.standardName = :standardName AND s.id <> :id")
        boolean existsByInstituteIdAndStandardNameAndIdNot(@Param("instituteId") Long instituteId,
                        @Param("standardName") String standardName, @Param("id") Long id);
}
