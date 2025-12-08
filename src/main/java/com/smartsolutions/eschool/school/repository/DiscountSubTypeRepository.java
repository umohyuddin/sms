package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
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

    // ------------------------------------------------------------
// MARK AS ACTIVE
// ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
        UPDATE DiscountSubTypeEntity ds
        SET ds.isActive = true
        WHERE ds.id = :id
        """)
    int markAsActive(@Param("id") Long id);

    // ------------------------------------------------------------
// MARK AS INACTIVE
// ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
        UPDATE DiscountSubTypeEntity ds
        SET ds.isActive = false
        WHERE ds.id = :id
        """)
    int markAsInactive(@Param("id") Long id);


    // ------------------------------------------------------------
    // FIND BY ALL (ACTIVE/NON ACTIVE)
    // ------------------------------------------------------------
    @Query("""
            SELECT ds
            FROM DiscountSubTypeEntity ds
            JOIN FETCH ds.discountType s
            WHERE ds.deleted = false
            """)
    List<DiscountSubTypeEntity> findAllDeletedFalse();



    // ------------------------------------------------------------
    // FIND BY ID (ACTIVE ONLY)
    // ------------------------------------------------------------
    @Query("""
            SELECT ds
            FROM DiscountSubTypeEntity ds
            JOIN FETCH ds.discountType s
            WHERE ds.id = :id
              AND ds.deleted = false
            """)
    Optional<DiscountSubTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);


    // ------------------------------------------------------------
    // FIND ALL ACTIVE
    // ------------------------------------------------------------
    @Query("""
            SELECT ds
            FROM DiscountSubTypeEntity ds
            WHERE ds.isActive = true
              AND ds.deleted = false
            ORDER BY ds.displayOrder ASC
            """)
    List<DiscountSubTypeEntity> findAllActive();


    // ------------------------------------------------------------
    // FIND ALL NON-ACTIVE
    // ------------------------------------------------------------
    @Query("""
            SELECT ds
            FROM DiscountSubTypeEntity ds
            WHERE ds.isActive = false
              AND ds.deleted = false
            ORDER BY ds.displayOrder ASC
            """)
    List<DiscountSubTypeEntity> findAllNonActive();

    // ------------------------------------------------------------
    // SOFT DELETE BY ID
    // ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
            UPDATE DiscountSubTypeEntity ds
            SET ds.deleted = true,
                ds.deletedAt = CURRENT_TIMESTAMP
            WHERE ds.id = :id
            """)
    int softDeleteById(@Param("id") Long id);


    // ------------------------------------------------------------
    // SOFT DELETE ALL RECORDS
    // ------------------------------------------------------------
    @Modifying
    @Transactional
    @Query("""
            UPDATE DiscountSubTypeEntity ds
            SET ds.deleted = true,
                ds.deletedAt = CURRENT_TIMESTAMP
            """)
    int softDeleteAll();

    // ------------------------------------------------------------
    // SEARCH BY NAME OR CODE
    // ------------------------------------------------------------
    @Query("""
            SELECT ds
            FROM DiscountSubTypeEntity ds
            WHERE ds.deleted = false
              AND (ds.name LIKE %:keyword%
               OR  ds.code LIKE %:keyword%)
            """)
    List<DiscountSubTypeEntity> searchByKeyword(@Param("keyword") String keyword);


    // ------------------------------------------------------------
    // GET ALL BY PARENT TYPE
    // ------------------------------------------------------------
    @Query("""
            SELECT ds
            FROM DiscountSubTypeEntity ds
            WHERE ds.discountType.id = :typeId
              AND ds.deleted = false
            ORDER BY ds.displayOrder ASC
            """)
    List<DiscountSubTypeEntity> findAllByDiscountType(@Param("typeId") Long typeId);



    @Query("SELECT f FROM DiscountSubTypeEntity f " +
            "JOIN FETCH f.discountType fc " +
            "WHERE (:discountTypeId IS NULL OR fc.id = :discountTypeId) " +
            "AND (:keyword IS NULL OR :keyword = '' OR LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "     OR LOWER(f.code) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND f.deleted = false " +
            "ORDER BY f.name ASC")
    List<DiscountSubTypeEntity> searchDiscountComponents(@Param("discountTypeId") Long discountTypeId,
                                                @Param("keyword") String keyword);
}






