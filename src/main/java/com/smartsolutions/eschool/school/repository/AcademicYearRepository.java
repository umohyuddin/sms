package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYearEntity, Long> {

    @Query("SELECT a FROM AcademicYearEntity a WHERE a.id = :id AND a.deletedAt IS NULL")
    Optional<AcademicYearEntity> findActiveById(@Param("id") Long id);
    @Query("SELECT a FROM AcademicYearEntity a WHERE a.deletedAt IS NULL ORDER BY a.startDate DESC")
    List<AcademicYearEntity> findAllActiveAcademicYears();

    @Query("SELECT ar FROM AcademicYearEntity ar " +
            "WHERE ar.isCurrent = true")
    Optional<AcademicYearEntity> findByIsCurrentTrue();



    @Modifying
    @Query("UPDATE AcademicYearEntity a SET a.isCurrent = false WHERE a.isCurrent = true")
    void deactivateAllAcademicYears();

    @Query("SELECT ar FROM AcademicYearEntity ar " +
            "WHERE LOWER(ar.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<AcademicYearEntity> searchByName(@Param("keyword") String keyword);

    @Query("SELECT a FROM AcademicYearEntity a WHERE a.id = :id")
    Optional<AcademicYearEntity> findAcademicYearById(@Param("id") Long id);


    @Query("""
                SELECT CASE WHEN COUNT(ay) > 0 THEN true ELSE false END
                FROM AcademicYearEntity ay
                WHERE (:startDate <= ay.endDate) AND (:endDate >= ay.startDate)
            """)
    boolean existsByDateRange(@Param("startDate") LocalDate startDate,
                              @Param("endDate") LocalDate endDate);


    @Modifying
    @Query("""
                UPDATE AcademicYearEntity ay
                SET ay.status = 'DELETED',
                    ay.deletedAt = :deletedAt,
                    ay.deletedBy = :deletedBy,
                    ay.isCurrent = false
                WHERE ay.id = :id
                  AND ay.isCurrent = false
                  AND ay.isLocked = false
                  AND ay.status <> 'DELETED'
            """)
    int softDelete(@Param("id") Long id,
                   @Param("deletedAt") LocalDateTime deletedAt,
                   @Param("deletedBy") Long deletedBy);

    @Query("""
    SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
    FROM AcademicYearEntity a
    WHERE a.startDate <= :endDate
      AND a.endDate >= :startDate
      AND a.id <> :id
""")
    boolean existsByDateRangeExcludingId(
            LocalDate startDate,
            LocalDate endDate,
            Long id
    );
}



