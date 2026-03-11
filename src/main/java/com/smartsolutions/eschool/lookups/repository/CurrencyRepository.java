package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

    @Query("""
            SELECT c
            FROM CurrencyEntity c
            WHERE c.id = :id
              AND c.deleted = false
            """)
    Optional<CurrencyEntity> findByIdAndDeletedFalse(@Param("id") Integer id);

    @Query("""
            SELECT c
            FROM CurrencyEntity c
            WHERE c.isActive = true
              AND c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurrencyEntity> findAllActive();

    @Query("""
            SELECT c
            FROM CurrencyEntity c
            WHERE c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurrencyEntity> findAllNotDeleted();

    @Query("""
            SELECT c
            FROM CurrencyEntity c
            WHERE (LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(c.isoCode) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND c.deleted = false
            ORDER BY c.name ASC
            """)
    List<CurrencyEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE CurrencyEntity c
            SET c.deleted = true,
                c.deletedAt = CURRENT_TIMESTAMP
            WHERE c.id = :id
            """)
    int softDeleteById(@Param("id") Integer id);

    @Query("SELECT COUNT(c) FROM CurrencyEntity c WHERE c.deleted = false")
    Long countAllNotDeleted();

    @Query("SELECT COUNT(c) FROM CurrencyEntity c WHERE c.isActive = true AND c.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(c) FROM CurrencyEntity c WHERE c.isActive = false AND c.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(c) > 0) FROM CurrencyEntity c WHERE c.isoCode = :isoCode AND c.deleted = false")
    boolean existsByIsoCode(@Param("isoCode") String isoCode);

    @Query("SELECT (COUNT(c) > 0) FROM CurrencyEntity c WHERE c.isoCode = :isoCode AND c.id <> :id AND c.deleted = false")
    boolean existsByIsoCodeAndIdNot(@Param("isoCode") String isoCode, @Param("id") Integer id);
}
