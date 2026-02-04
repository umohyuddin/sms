package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.EducationLevelEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
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

    @Modifying
    @Transactional
    @Query("""
            UPDATE EducationLevelEntity e
            SET e.deleted = true,
                e.deletedAt = CURRENT_TIMESTAMP
            WHERE e.id = :id
            """)
    int softDeleteById(@Param("id") Long id);
}
