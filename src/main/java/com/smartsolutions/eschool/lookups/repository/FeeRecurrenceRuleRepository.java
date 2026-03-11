package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Query("""
            SELECT f
            FROM FeeRecurrenceRuleEntity f
            WHERE f.deleted = false
            ORDER BY f.name ASC
            """)
    List<FeeRecurrenceRuleEntity> findAllNotDeleted();

    @Query("""
            SELECT f
            FROM FeeRecurrenceRuleEntity f
            WHERE (f.name LIKE %:keyword% OR f.code LIKE %:keyword%)
              AND f.deleted = false
            ORDER BY f.name ASC
            """)
    List<FeeRecurrenceRuleEntity> searchByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("""
            UPDATE FeeRecurrenceRuleEntity f
            SET f.deleted = true,
                f.deletedAt = CURRENT_TIMESTAMP
            WHERE f.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    @Query("SELECT COUNT(f) FROM FeeRecurrenceRuleEntity f WHERE f.deleted = false")
    Long countAllActive();

    @Query("SELECT COUNT(f) FROM FeeRecurrenceRuleEntity f WHERE f.isActive = true AND f.deleted = false")
    Long countByIsActiveTrue();

    @Query("SELECT COUNT(f) FROM FeeRecurrenceRuleEntity f WHERE f.isActive = false AND f.deleted = false")
    Long countByIsActiveFalse();

    @Query("SELECT (COUNT(f) > 0) FROM FeeRecurrenceRuleEntity f WHERE f.code = :code AND f.deleted = false")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT (COUNT(f) > 0) FROM FeeRecurrenceRuleEntity f WHERE f.code = :code AND f.id <> :id AND f.deleted = false")
    boolean existsByCodeAndIdNot(@Param("code") String code, @Param("id") Long id);
}
