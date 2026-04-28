package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.EducationLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationLevelRepository extends JpaRepository<EducationLevelEntity, Long> {

    @Query("""
            SELECT e
            FROM EducationLevelEntity e
            WHERE e.id = :id
              AND e.deleted = false
            """)
    Optional<EducationLevelEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT e
            FROM EducationLevelEntity e
            WHERE e.isActive = true
              AND e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EducationLevelEntity> findAllActive();

    @Query("""
            SELECT e
            FROM EducationLevelEntity e
            WHERE e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EducationLevelEntity> findAllNotDeleted();

    @Query("""
            SELECT e
            FROM EducationLevelEntity e
            WHERE (LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(e.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND e.deleted = false
            ORDER BY e.name ASC
            """)
    List<EducationLevelEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE EducationLevelEntity e
            SET e.deleted = true,
                e.deletedAt = CURRENT_TIMESTAMP
            WHERE e.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(e) FROM EducationLevelEntity e WHERE e.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(e) FROM EducationLevelEntity e WHERE e.isActive = true AND e.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(e) FROM EducationLevelEntity e WHERE e.isActive = false AND e.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(e) > 0) FROM EducationLevelEntity e WHERE e.code = :code AND e.deleted = false")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(e) > 0) FROM EducationLevelEntity e WHERE e.code = :code AND e.id <> :id AND e.deleted = false")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}
