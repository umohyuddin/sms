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
public interface FeeRateRepository extends JpaRepository<FeeComponentEntity, Long> {

    @Query("""
                SELECT fr FROM FeeRateEntity fr
                LEFT JOIN FETCH fr.campus c
                LEFT JOIN FETCH fr.standard s
                LEFT JOIN FETCH fr.feeComponent fc
                LEFT JOIN FETCH fr.academicYear ay
                WHERE fr.deleted = false
            """)
    List<FeeRateEntity> findByDeletedFalse();

    @Query("SELECT fr FROM FeeRateEntity fr " +
            "WHERE fr.deleted = false AND fr.id=:id")
    Optional<FeeRateEntity> findByIdAndDeletedFalse(@Param("id") Long id);


    @Query("SELECT f FROM FeeRateEntity f " +
            "WHERE (" +
            "LOWER(f.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            ") AND f.deleted = false")
    List<FeeRateEntity> searchFeeComponent(@Param("keyword") String keyword);


    @Query("SELECT fr FROM FeeRateEntity fr " +
            "WHERE fr.feeComponent.id = :componentId " +
            "AND fr.active = true")
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
            @Param("academicYearId") Long academicYearId
    );
}


