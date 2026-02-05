package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.TaxTypeEntity;
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
            WHERE t.country.id = :countryId
              AND t.isActive = true
              AND t.deleted = false
            ORDER BY t.name ASC
            """)
    List<TaxTypeEntity> findByCountryId(@Param("countryId") Long countryId);

    @Modifying
    @Transactional
    @Query("""
            UPDATE TaxTypeEntity t
            SET t.deleted = true,
                t.deletedAt = CURRENT_TIMESTAMP
            WHERE t.id = :id
            """)
    int softDeleteById(@Param("id") Long id);
}
