package com.smartsolutions.eschool.institute.repository;

import com.smartsolutions.eschool.institute.entity.CampusFinancialSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampusFinancialSettingsRepository extends JpaRepository<CampusFinancialSettings, Long> {

    @Query("""
                SELECT s FROM CampusFinancialSettings s
                WHERE s.campusId = :campusId
                  AND s.academicYearId = :academicYearId
                  AND s.isDeleted = false
            """)
    Optional<CampusFinancialSettings> findByCampusIdAndAcademicYearIdJpql(
            @Param("campusId") Long campusId,
            @Param("academicYearId") Long academicYearId);

    @Query("""
                SELECT s FROM CampusFinancialSettings s
                WHERE s.id = :id
                  AND s.instituteId = :instituteId
                  AND s.isDeleted = false
            """)
    Optional<CampusFinancialSettings> findByIdAndInstituteIdJpql(
            @Param("id") Long id,
            @Param("instituteId") Long instituteId);

    Optional<CampusFinancialSettings> findByCampusIdAndAcademicYearIdAndIsDeletedFalse(Long campusId,
            Long academicYearId);

    Optional<CampusFinancialSettings> findByIdAndIsDeletedFalse(Long id);

    java.util.List<CampusFinancialSettings> findAllByCampusIdAndIsDeletedFalse(Long campusId);
}
