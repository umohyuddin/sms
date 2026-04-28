package com.smartsolutions.eschool.institute.repository;

import com.smartsolutions.eschool.institute.entity.InstituteFinancialSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituteFinancialSettingsRepository extends JpaRepository<InstituteFinancialSettings, Long> {

    @Query("""
                SELECT s FROM InstituteFinancialSettings s
                WHERE s.instituteId = :instituteId
                  AND s.academicYearId = :academicYearId
                  AND s.isDeleted = false
            """)
    Optional<InstituteFinancialSettings> findByInstituteIdAndAcademicYearIdJpql(
            @Param("instituteId") Long instituteId,
            @Param("academicYearId") Long academicYearId);

    @Query("""
                SELECT s FROM InstituteFinancialSettings s
                WHERE s.id = :id
                  AND s.instituteId = :instituteId
                  AND s.isDeleted = false
            """)
    Optional<InstituteFinancialSettings> findByIdAndInstituteIdJpql(
            @Param("id") Long id,
            @Param("instituteId") Long instituteId);

    Optional<InstituteFinancialSettings> findByInstituteIdAndAcademicYearIdAndIsDeletedFalse(Long instituteId,
            Long academicYearId);

    Optional<InstituteFinancialSettings> findByIdAndIsDeletedFalse(Long id);
}
