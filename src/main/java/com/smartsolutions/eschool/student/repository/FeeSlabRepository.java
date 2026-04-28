package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeSlabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FeeSlabRepository extends JpaRepository<FeeSlabEntity, Long> {

    @Query("""
            SELECT fs FROM FeeSlabEntity fs
            LEFT JOIN FETCH fs.slabGroup sg
            WHERE fs.deleted = false
            """)
    List<FeeSlabEntity> findByDeletedFalse();

    @Query("SELECT fs FROM FeeSlabEntity fs LEFT JOIN FETCH fs.slabGroup sg WHERE fs.deleted = false AND fs.id=:id")
    Optional<FeeSlabEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
            SELECT fs FROM FeeSlabEntity fs
            WHERE fs.slabGroup.id = :slabGroupId
              AND fs.deleted = false
            """)
    List<FeeSlabEntity> findBySlabGroupId(@Param("slabGroupId") Long slabGroupId);

    @Query("""
            SELECT fs FROM FeeSlabEntity fs
            WHERE fs.slabGroup.id = :slabGroupId
              AND fs.deleted = false
              AND :value >= fs.minValue
              AND (fs.maxValue IS NULL OR :value <= fs.maxValue)
            """)
    Optional<FeeSlabEntity> findApplicableSlab(
            @Param("slabGroupId") Long slabGroupId,
            @Param("value") BigDecimal value);
}
