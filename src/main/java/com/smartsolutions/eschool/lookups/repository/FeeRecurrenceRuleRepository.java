package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
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
public interface FeeRecurrenceRuleRepository extends JpaRepository<FeeRecurrenceRuleEntity, Long> {

    @Query("""
            SELECT f
            FROM FeeRecurrenceRuleEntity f
            WHERE f.id = :id
              AND f.deleted = false
            """)
    Optional<FeeRecurrenceRuleEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT f
            FROM FeeRecurrenceRuleEntity f
            WHERE f.isActive = true
              AND f.deleted = false
            ORDER BY f.name ASC
            """)
    List<FeeRecurrenceRuleEntity> findAllActive();

    @Modifying
    @Transactional
    @Query("""
            UPDATE FeeRecurrenceRuleEntity f
            SET f.deleted = true,
                f.deletedAt = CURRENT_TIMESTAMP
            WHERE f.id = :id
            """)
    int softDeleteById(@Param("id") Long id);
}
