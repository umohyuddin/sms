package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
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
public interface DiscountTypeRepository extends JpaRepository<DiscountTypeEntity, Long> {


    @Query("""
            SELECT d
            FROM DiscountTypeEntity d
            WHERE d.id = :id
              AND d.deleted = false
            """)
    Optional<DiscountTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

    @Query("""
        SELECT d
        FROM DiscountTypeEntity d
        WHERE d.active = true
          AND d.deleted = false
        """)
    List<DiscountTypeEntity> findAllActive();

    // Find all non-active discount types
    @Query("""
           SELECT d
           FROM DiscountTypeEntity d
           WHERE d.active = false
             AND d.deleted = false
           """)
    List<DiscountTypeEntity> findAllNonActive();

    @Modifying
    @Transactional
    @Query("UPDATE DiscountTypeEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP " +
            "WHERE d.id = :id")
    int softDeleteById(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query("UPDATE DiscountTypeEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP")
    int softDeleteAll();


    @Query("""
            SELECT d FROM DiscountTypeEntity d WHERE (d.name LIKE %:keyword% OR d.code LIKE %:keyword%) AND d.deleted = false""")
    List<DiscountTypeEntity> searchByKeyword(@Param("keyword") String keyword);
}




