package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.TaxTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaxTypeRepository extends JpaRepository<TaxTypeEntity, Long> {

    @Query("""
            SELECT t
            FROM TaxTypeEntity t
            WHERE t.id = :id
              AND t.deleted = false
            """)
    Optional<TaxTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT t
            FROM TaxTypeEntity t
            WHERE t.isActive = true
              AND t.deleted = false
            ORDER BY t.name ASC
            """)
    List<TaxTypeEntity> findAllActive();

    @Query("""
            SELECT t
            FROM TaxTypeEntity t
            WHERE t.deleted = false
            ORDER BY t.name ASC
            """)
    List<TaxTypeEntity> findAllNotDeleted();

    @Query("""
            SELECT t
            FROM TaxTypeEntity t LEFT JOIN FETCH t.country
            WHERE t.country.id = :countryId
              AND t.isActive = true
              AND t.deleted = false
            ORDER BY t.name ASC
            """)
    List<TaxTypeEntity> findByCountryId(@Param("countryId") Long countryId);

    @Query("""
            SELECT t
            FROM TaxTypeEntity t
            WHERE (t.name LIKE %:keyword% OR t.code LIKE %:keyword%)
              AND t.deleted = false
            ORDER BY t.name ASC
            """)
    List<TaxTypeEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE TaxTypeEntity t
            SET t.deleted = true,
                t.deletedAt = CURRENT_TIMESTAMP
            WHERE t.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(t) FROM TaxTypeEntity t WHERE t.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(t) FROM TaxTypeEntity t WHERE t.isActive = true AND t.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(t) FROM TaxTypeEntity t WHERE t.isActive = false AND t.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(t) > 0) FROM TaxTypeEntity t WHERE t.code = :code AND t.deleted = false")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(t) > 0) FROM TaxTypeEntity t WHERE t.code = :code AND t.id <> :id AND t.deleted = false")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}
