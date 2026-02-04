package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CurriculumEntity;
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
public interface CurriculumRepository extends JpaRepository<CurriculumEntity, Long> {

    @Query("""
            SELECT c
            FROM CurriculumEntity c
            WHERE c.id = :id
              AND c.deleted = false
            """)
    Optional<CurriculumEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT c
            FROM CurriculumEntity c
            WHERE c.isActive = true
              AND c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurriculumEntity> findAllActive();

    @Modifying
    @Transactional
    @Query("""
            UPDATE CurriculumEntity c
            SET c.deleted = true,
                c.deletedAt = CURRENT_TIMESTAMP
            WHERE c.id = :id
            """)
    int softDeleteById(@Param("id") Long id);
}
