package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Query("""
            SELECT l
            FROM LanguageEntity l
            WHERE l.deleted = false
            ORDER BY l.name ASC
            """)
    List<LanguageEntity> findAllNotDeleted();

    @Query("""
            SELECT l
            FROM LanguageEntity l
            WHERE (LOWER(l.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(l.isoCode) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND l.deleted = false
            ORDER BY l.name ASC
            """)
    List<LanguageEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE LanguageEntity l
            SET l.deleted = true,
                l.deletedAt = CURRENT_TIMESTAMP
            WHERE l.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(l) FROM LanguageEntity l WHERE l.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(l) FROM LanguageEntity l WHERE l.isActive = true AND l.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(l) FROM LanguageEntity l WHERE l.isActive = false AND l.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(l) > 0) FROM LanguageEntity l WHERE l.isoCode = :isoCode AND l.deleted = false")
    boolean existsByIsoCode(@Param("isoCode") String isoCode);

    @Query("SELECT (COUNT(l) > 0) FROM LanguageEntity l WHERE l.isoCode = :isoCode AND l.id <> :id AND l.deleted = false")
    boolean existsByIsoCodeAndIdNot(@Param("isoCode") String isoCode, @Param("id") Long id);
}
