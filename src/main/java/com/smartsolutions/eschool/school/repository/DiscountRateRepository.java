package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DiscountRateEntity;
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

        @Modifying
        @Transactional
        @Query("UPDATE DiscountRateEntity dr SET dr.isActive = true WHERE dr.id = :id")
        int markAsActive(@Param("id") Long id);

        @Modifying
        @Transactional
        @Query("UPDATE DiscountRateEntity dr SET dr.isActive = false WHERE dr.id = :id")
        int markAsInactive(@Param("id") Long id);

        // Base fetch with all JOINs
        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.deleted = false
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> findAllDeletedFalse();

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        LEFT JOIN FETCH dr.discountSubType dst
                        LEFT JOIN FETCH dst.discountType dt
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.id = :id AND dr.organizationId = :organizationId AND dr.deleted = false
                        """)
        Optional<DiscountRateEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

        @Query("""
                        SELECT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.id = :id AND dr.deleted = false
                        """)
        Optional<DiscountRateEntity> findByIdAndDeletedFalse(@Param("id") Long id);

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.isActive = true AND dr.deleted = false
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> findAllActive();

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.isActive = false AND dr.deleted = false
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> findAllNonActive();

        @Modifying
        @Transactional
        @Query("UPDATE DiscountRateEntity dr SET dr.deleted = true, dr.deletedAt = CURRENT_TIMESTAMP WHERE dr.id = :id")
        int softDeleteById(@Param("id") Long id);

        @Modifying
        @Transactional
        @Query("UPDATE DiscountRateEntity dr SET dr.deleted = true, dr.deletedAt = CURRENT_TIMESTAMP")
        int softDeleteAll();

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.discountSubType.id = :subTypeId AND dr.deleted = false
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> findAllByDiscountSubType(@Param("subTypeId") Long subTypeId);

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.campus.id = :campusId AND dr.deleted = false
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> findAllByCampus(@Param("campusId") Long campusId);

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.academicYear.id = :academicYearId AND dr.deleted = false
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> findAllByAcademicYear(@Param("academicYearId") Long academicYearId);

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.deleted = false AND dst.deleted = false AND dt.deleted = false
                        AND dr.campus.id = :campusId AND dr.academicYear.id = :academicYearId
                        """)
        List<DiscountRateEntity> findDiscountRatesByCampusAndAcademicYear(@Param("campusId") Long campusId,
                        @Param("academicYearId") Long academicYearId);

        @Query("""
                        SELECT DISTINCT dr FROM DiscountRateEntity dr
                        JOIN FETCH dr.discountSubType dst
                        JOIN FETCH dst.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        LEFT JOIN FETCH dr.campus c
                        LEFT JOIN FETCH dr.academicYear ay
                        WHERE dr.deleted = false AND dst.deleted = false AND dt.deleted = false
                        AND (:discountTypeId IS NULL OR dt.id = :discountTypeId)
                        AND (:discountSubTypeId IS NULL OR dst.id = :discountSubTypeId)
                        AND (:recurrenceRuleId IS NULL OR rr.id = :recurrenceRuleId)
                        AND (:campusId IS NULL OR c.id = :campusId)
                        AND (:academicYearId IS NULL OR ay.id = :academicYearId)
                        AND (:keyword IS NULL OR :keyword = ''
                             OR LOWER(dst.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                             OR LOWER(dst.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
                        ORDER BY dr.id ASC
                        """)
        List<DiscountRateEntity> search(@Param("discountTypeId") Long discountTypeId,
                        @Param("discountSubTypeId") Long discountSubTypeId,
                        @Param("recurrenceRuleId") Long recurrenceRuleId,
                        @Param("campusId") Long campusId,
                        @Param("academicYearId") Long academicYearId,
                        @Param("keyword") String keyword);

        @Query("""
                        SELECT dr FROM DiscountRateEntity dr
                        WHERE dr.discountSubType.id = :subTypeId
                        AND dr.campus.id = :campusId
                        AND dr.academicYear.id = :academicYearId
                        AND dr.deleted = false AND dr.isActive = true
                        """)
        Optional<DiscountRateEntity> findApplicableDiscountRate(
                        @Param("subTypeId") Long subTypeId,
                        @Param("campusId") Long campusId,
                        @Param("academicYearId") Long academicYearId);
}
