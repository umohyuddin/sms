package com.smartsolutions.eschool.school.repository;

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
public interface DiscountSubTypeRepository extends JpaRepository<DiscountSubTypeEntity, Long> {

        @Modifying
        @Transactional
        @Query("UPDATE DiscountSubTypeEntity ds SET ds.isActive = true WHERE ds.id = :id")
        int markAsActive(@Param("id") Long id);

        @Modifying
        @Transactional
        @Query("UPDATE DiscountSubTypeEntity ds SET ds.isActive = false WHERE ds.id = :id")
        int markAsInactive(@Param("id") Long id);

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE ds.deleted = false
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> findAllDeletedFalse();

        @Query("""
                        SELECT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE ds.id = :id AND ds.deleted = false
                        """)
        Optional<DiscountSubTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE ds.isActive = true AND ds.deleted = false
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> findAllActive();

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE ds.isActive = false AND ds.deleted = false
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> findAllNonActive();

        @Modifying
        @Transactional
        @Query("UPDATE DiscountSubTypeEntity ds SET ds.deleted = true, ds.deletedAt = CURRENT_TIMESTAMP WHERE ds.id = :id")
        int softDeleteById(@Param("id") Long id);

        @Modifying
        @Transactional
        @Query("UPDATE DiscountSubTypeEntity ds SET ds.deleted = true, ds.deletedAt = CURRENT_TIMESTAMP")
        int softDeleteAll();

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE ds.deleted = false
                        AND (:keyword IS NULL OR :keyword = ''
                             OR LOWER(ds.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                             OR LOWER(ds.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> searchByKeyword(@Param("keyword") String keyword);

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE (:discountTypeId IS NULL OR dt.id = :discountTypeId)
                        AND (:keyword IS NULL OR :keyword = ''
                             OR LOWER(ds.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
                             OR LOWER(ds.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
                        AND ds.deleted = false
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> searchDiscountComponents(@Param("discountTypeId") Long discountTypeId,
                        @Param("keyword") String keyword);

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        JOIN FETCH dt.chargeType ct
                        LEFT JOIN FETCH dt.recurrenceRule rr
                        WHERE dt.id = :discountTypeId AND ds.deleted = false AND ds.isActive = true
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> findActiveByDiscountTypeId(@Param("discountTypeId") Long discountTypeId);

        @Query("""
                        SELECT DISTINCT ds FROM DiscountSubTypeEntity ds
                        JOIN FETCH ds.discountType dt
                        WHERE dt.id = :typeId AND ds.deleted = false
                        ORDER BY ds.displayOrder ASC
                        """)
        List<DiscountSubTypeEntity> findAllByDiscountType(@Param("typeId") Long typeId);
}
