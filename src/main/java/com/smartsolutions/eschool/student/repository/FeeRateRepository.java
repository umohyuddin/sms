package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FeeRateRepository extends JpaRepository<FeeRateEntity, Long> {

  @Query("""
          SELECT fr FROM FeeRateEntity fr
          LEFT JOIN FETCH fr.campus c
          LEFT JOIN FETCH fr.standard s
          LEFT JOIN FETCH fr.chargeType ct
          LEFT JOIN FETCH fr.percentageOfComponent pc
          LEFT JOIN FETCH fr.slabGroup sg
          LEFT JOIN FETCH fr.feeComponent fc
          LEFT JOIN FETCH fc.feeCatalog fcat
          LEFT JOIN FETCH fcat.chargeType fcatct
          LEFT JOIN FETCH fcat.recurrenceRule fcatrr
          LEFT JOIN FETCH fr.academicYear ay
          WHERE fr.deleted = false
      """)
  List<FeeRateEntity> findByDeletedFalse();

  @Query("""
          SELECT fr FROM FeeRateEntity fr
          LEFT JOIN FETCH fr.campus c
          LEFT JOIN FETCH fr.standard s
          LEFT JOIN FETCH fr.chargeType ct
          LEFT JOIN FETCH fr.percentageOfComponent pc
          LEFT JOIN FETCH fr.slabGroup sg
          LEFT JOIN FETCH fr.feeComponent fc
          LEFT JOIN FETCH fc.feeCatalog fcat
          LEFT JOIN FETCH fcat.chargeType fcatct
          LEFT JOIN FETCH fcat.recurrenceRule fcatrr
          LEFT JOIN FETCH fr.academicYear ay
          WHERE fr.deleted = false AND fr.id = :id
      """)
  Optional<FeeRateEntity> findByIdAndDeletedFalse(@Param("id") Long id);

  @Query("""
          SELECT fr FROM FeeRateEntity fr
          LEFT JOIN FETCH fr.campus c
          LEFT JOIN FETCH fr.standard s
          LEFT JOIN FETCH fr.chargeType ct
          LEFT JOIN FETCH fr.percentageOfComponent pc
          LEFT JOIN FETCH fr.slabGroup sg
          LEFT JOIN FETCH fr.feeComponent fc
          LEFT JOIN FETCH fc.feeCatalog fcat
          LEFT JOIN FETCH fcat.chargeType fcatct
          LEFT JOIN FETCH fcat.recurrenceRule fcatrr
          LEFT JOIN FETCH fr.academicYear ay
          WHERE fc.id = :componentId AND fr.active = true AND fr.deleted = false
      """)
  List<FeeRateEntity> findByFeeComponentId(@Param("componentId") Long componentId);

  @Query("""
          SELECT fr FROM FeeRateEntity fr
          WHERE fr.feeComponent.id IN :componentIds
            AND fr.campus.id = :campusId
            AND fr.standard.id = :standardId
            AND fr.academicYear.id= :academicYearId
      """)
  List<FeeRateEntity> findApplicableFeeRatesForStudent(
      @Param("componentIds") List<Long> componentIds,
      @Param("campusId") Long campusId,
      @Param("standardId") Long standardId,
      @Param("academicYearId") Long academicYearId);

  @Query("""
          SELECT fr FROM FeeRateEntity fr
          LEFT JOIN FETCH fr.campus c
          LEFT JOIN FETCH fr.standard s
          LEFT JOIN FETCH fr.chargeType ct
          LEFT JOIN FETCH fr.percentageOfComponent pc
          LEFT JOIN FETCH fr.slabGroup sg
          LEFT JOIN FETCH fr.feeComponent fc
          LEFT JOIN FETCH fc.feeCatalog fcat
          LEFT JOIN FETCH fcat.chargeType fcatct
          LEFT JOIN FETCH fcat.recurrenceRule fcatrr
          LEFT JOIN FETCH fr.academicYear ay
          WHERE fcat.id = :feeCatalogId AND fr.deleted = false
      """)
  List<FeeRateEntity> getByFeeCatalogId(@Param("feeCatalogId") Long feeCatalogId);

  @Query("""
          SELECT f FROM FeeRateEntity f
          LEFT JOIN FETCH f.campus c
          LEFT JOIN FETCH f.standard s
          LEFT JOIN FETCH f.chargeType ct
          LEFT JOIN FETCH f.percentageOfComponent pc
          LEFT JOIN FETCH f.slabGroup sg
          LEFT JOIN FETCH f.feeComponent fc
          LEFT JOIN FETCH fc.feeCatalog fcat
          LEFT JOIN FETCH fcat.chargeType fcatct
          LEFT JOIN FETCH fcat.recurrenceRule fcatrr
          LEFT JOIN FETCH f.academicYear ay
          WHERE f.campus.id = :campusId
            AND f.standard.id = :standardId
            AND f.academicYear.id = :academicYearId
            AND f.deleted = false
      """)
  List<FeeRateEntity> findActiveFeeRates(
      @Param("campusId") Long campusId,
      @Param("standardId") Long standardId,
      @Param("academicYearId") Long academicYearId);

  @Query("""
          SELECT fr FROM FeeRateEntity fr
          LEFT JOIN FETCH fr.feeComponent fc
          LEFT JOIN FETCH fc.feeCatalog fcat
          LEFT JOIN FETCH fcat.chargeType fcatct
          LEFT JOIN FETCH fcat.recurrenceRule fcatrr
          LEFT JOIN FETCH fr.campus c
          LEFT JOIN FETCH fr.standard s
          LEFT JOIN FETCH fr.academicYear ay
          LEFT JOIN FETCH fr.chargeType ct
          LEFT JOIN FETCH fr.percentageOfComponent pc
          LEFT JOIN FETCH fr.slabGroup sg
          WHERE fr.deleted = false
            AND (:feeCatalogId IS NULL OR fcat.id = :feeCatalogId)
            AND (:feeComponentId IS NULL OR fc.id = :feeComponentId)
            AND (
                  :keyword IS NULL OR
                  LOWER(fc.componentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                  LOWER(fcat.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                  LOWER(c.campusName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                  LOWER(s.standardName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR
                  CAST(fr.fixedAmount AS string) LIKE CONCAT('%', :keyword, '%')
                )
      """)
  List<FeeRateEntity> searchFeeRates(
      @Param("feeCatalogId") Long feeCatalogId,
      @Param("feeComponentId") Long feeComponentId,
      @Param("keyword") String keyword);

}
