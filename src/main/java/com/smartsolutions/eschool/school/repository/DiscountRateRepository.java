package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DiscountRateEntity;
import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface DiscountRateRepository extends JpaRepository<DiscountRateEntity, Long> {
    // ------------------------------------------------------------
    // MARK AS ACTIVE
    // ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
            UPDATE DiscountRateEntity dr
            SET dr.isActive = true
            WHERE dr.id = :id
            """)
    int markAsActive(@Param("id") Long id);

    // ------------------------------------------------------------
    // MARK AS INACTIVE
    // ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
            UPDATE DiscountRateEntity dr
            SET dr.isActive = false
            WHERE dr.id = :id
            """)
    int markAsInactive(@Param("id") Long id);

    // ------------------------------------------------------------
    // FIND BY ALL (ACTIVE/NON ACTIVE)
    // ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.deleted = false
            """)
    List<DiscountRateEntity> findAllDeletedFalse();

    // ------------------------------------------------------------
    // FIND BY ID (ACTIVE ONLY)
    // ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.id = :id
              AND dr.deleted = false
            """)
    Optional<DiscountRateEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    // ------------------------------------------------------------
    // FIND ALL ACTIVE
    // ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.isActive = true
              AND dr.deleted = false
            ORDER BY dr.id ASC
            """)
    List<DiscountRateEntity> findAllActive();

    // ------------------------------------------------------------
    // FIND ALL NON-ACTIVE
    // ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.isActive = false
              AND dr.deleted = false
            ORDER BY dr.id ASC
            """)
    List<DiscountRateEntity> findAllNonActive();

    // ------------------------------------------------------------
    // SOFT DELETE BY ID
    // ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
            UPDATE DiscountRateEntity dr
            SET dr.deleted = true,
                dr.deletedAt = CURRENT_TIMESTAMP
            WHERE dr.id = :id
            """)
    int softDeleteById(@Param("id") Long id);

    // ------------------------------------------------------------
    // SOFT DELETE ALL RECORDS
    // ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
            UPDATE DiscountRateEntity dr
            SET dr.deleted = true,
                dr.deletedAt = CURRENT_TIMESTAMP
            """)
    int softDeleteAll();


    // ------------------------------------------------------------
    // GET ALL BY SUBTYPE
    // ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.discountSubType.id = :subTypeId
              AND dr.deleted = false
            ORDER BY dr.id ASC
            """)
    List<DiscountRateEntity> findAllByDiscountSubType(@Param("subTypeId") Long subTypeId);

    // ------------------------------------------------------------
// GET ALL BY CAMPUS
// ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.campus.id = :campusId
              AND dr.deleted = false
            ORDER BY dr.id ASC
            """)
    List<DiscountRateEntity> findAllByCampus(@Param("campusId") Long campusId);

    // ------------------------------------------------------------
// GET ALL BY ACADEMIC YEAR
// ------------------------------------------------------------
    @Query("""
            SELECT dr
            FROM DiscountRateEntity dr
            WHERE dr.academicYear.id = :academicYearId
              AND dr.deleted = false
            ORDER BY dr.id ASC
            """)
    List<DiscountRateEntity> findAllByAcademicYear(@Param("academicYearId") Long academicYearId);
}




