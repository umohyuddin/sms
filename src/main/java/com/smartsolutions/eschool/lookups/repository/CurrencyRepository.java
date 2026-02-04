package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CurrencyEntity;
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

    @Modifying
    @Transactional
    @Query("""
            UPDATE CurrencyEntity c
            SET c.deleted = true,
                c.deletedAt = CURRENT_TIMESTAMP
            WHERE c.id = :id
            """)
    int softDeleteById(@Param("id") Integer id);
}
