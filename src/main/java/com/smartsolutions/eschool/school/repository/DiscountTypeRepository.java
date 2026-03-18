package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
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
      SELECT d FROM DiscountTypeEntity d
      JOIN FETCH d.chargeType ct
      LEFT JOIN FETCH d.recurrenceRule rr
      WHERE d.id = :id AND d.deleted = false
      """)
  Optional<DiscountTypeEntity> findByIdAndDeletedFalse(@Param("id") Long id);

  @Query("""
      SELECT d FROM DiscountTypeEntity d
      JOIN FETCH d.chargeType ct
      LEFT JOIN FETCH d.recurrenceRule rr
      WHERE d.deleted = false
      ORDER BY d.displayOrder ASC
      """)
  List<DiscountTypeEntity> findAllDeletedFalse();

  @Query("""
      SELECT d FROM DiscountTypeEntity d
      JOIN FETCH d.chargeType ct
      LEFT JOIN FETCH d.recurrenceRule rr
      WHERE d.active = true AND d.deleted = false
      ORDER BY d.displayOrder ASC
      """)
  List<DiscountTypeEntity> findAllActive();

  @Query("""
      SELECT d FROM DiscountTypeEntity d
      JOIN FETCH d.chargeType ct
      LEFT JOIN FETCH d.recurrenceRule rr
      WHERE d.active = false AND d.deleted = false
      ORDER BY d.displayOrder ASC
      """)
  List<DiscountTypeEntity> findAllNonActive();

  @Modifying
  @Transactional
  @Query("UPDATE DiscountTypeEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP WHERE d.id = :id")
  int softDeleteById(@Param("id") Long id);

  @Modifying
  @Transactional
  @Query("UPDATE DiscountTypeEntity d SET d.deleted = true, d.deletedAt = CURRENT_TIMESTAMP")
  int softDeleteAll();

  @Query("""
      SELECT d FROM DiscountTypeEntity d
      JOIN FETCH d.chargeType ct
      LEFT JOIN FETCH d.recurrenceRule rr
      WHERE d.deleted = false
      AND (:keyword IS NULL OR :keyword = ''
           OR LOWER(d.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(d.code) LIKE LOWER(CONCAT('%', :keyword, '%')))
      ORDER BY d.displayOrder ASC
      """)
  List<DiscountTypeEntity> searchByKeyword(@Param("keyword") String keyword);
}
