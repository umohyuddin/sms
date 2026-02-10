package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.GradeScaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface GradeScaleRepository extends JpaRepository<GradeScaleEntity, Long> {

    @Query("SELECT gs FROM GradeScaleEntity gs WHERE gs.organizationId = :orgId AND gs.deleted = false")
    List<GradeScaleEntity> findAllByOrgId(@Param("orgId") Long orgId);

    @Query("SELECT gs FROM GradeScaleEntity gs WHERE gs.organizationId = :orgId " +
           "AND :percentage BETWEEN gs.minPercentage AND gs.maxPercentage AND gs.deleted = false")
    Optional<GradeScaleEntity> findGradeByPercentage(@Param("orgId") Long orgId, @Param("percentage") BigDecimal percentage);

    @Query("SELECT gs FROM GradeScaleEntity gs WHERE gs.id = :id AND gs.deleted = false")
    Optional<GradeScaleEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Modifying
    @Query("UPDATE GradeScaleEntity gs SET gs.deleted = true, gs.deletedAt = CURRENT_TIMESTAMP WHERE gs.id = :id")
    void softDeleteById(@Param("id") Long id);
}
