package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.LanguageEntity;
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
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    @Query("""
            SELECT l
            FROM LanguageEntity l
            WHERE l.id = :id
              AND l.deleted = false
            """)
    Optional<LanguageEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT l
            FROM LanguageEntity l
            WHERE l.isActive = true
              AND l.deleted = false
            ORDER BY l.name ASC
            """)
    List<LanguageEntity> findAllActive();

    @Modifying
    @Transactional
    @Query("""
            UPDATE LanguageEntity l
            SET l.deleted = true,
                l.deletedAt = CURRENT_TIMESTAMP
            WHERE l.id = :id
            """)
    int softDeleteById(@Param("id") Long id);
}
