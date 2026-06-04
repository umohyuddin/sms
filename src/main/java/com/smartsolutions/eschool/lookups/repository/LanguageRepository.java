package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    @Query("""
            SELECT l
            FROM LanguageEntity l
            WHERE l.isActive = true
            ORDER BY l.name ASC
            """)
    List<LanguageEntity> findAllActive();

    @Query("""
            SELECT l
            FROM LanguageEntity l
            WHERE (LOWER(l.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(l.isoCode) LIKE LOWER(CONCAT('%', :keyword, '%')))
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

    @Query("SELECT COUNT(l) FROM LanguageEntity l WHERE l.isActive = true")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(l) FROM LanguageEntity l WHERE l.isActive = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(l) > 0) FROM LanguageEntity l WHERE l.isoCode = :isoCode")
    boolean existsByIsoCode(@Param("isoCode") String isoCode);

    @Query("SELECT (COUNT(l) > 0) FROM LanguageEntity l WHERE l.isoCode = :isoCode AND l.id <> :id")
    boolean existsByIsoCodeAndIdNot(@Param("isoCode") String isoCode, @Param("id") Long id);
}
