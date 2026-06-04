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
                  AND s.deleted = false
            """)
    Optional<CampusFinancialSettings> findByCampusIdAndAcademicYearId(
            @Param("campusId") Long campusId,
            @Param("academicYearId") Long academicYearId);

    @Query("""
                SELECT s FROM CampusFinancialSettings s
                WHERE s.id = :id
                  AND s.instituteId = :instituteId
                  AND s.deleted = false
            """)
    Optional<CampusFinancialSettings> findByIdAndInstituteId(
            @Param("id") Long id,
            @Param("instituteId") Long instituteId);

    @Query("""
                SELECT s FROM CampusFinancialSettings s
                WHERE s.id = :id
                  AND s.deleted = false
            """)
    Optional<CampusFinancialSettings> findByIdAndDeletedFalse(
            @Param("id") Long id);

    @Query("""
                SELECT s FROM CampusFinancialSettings s
                WHERE s.campusId = :campusId
                  AND s.deleted = false
            """)
    java.util.List<CampusFinancialSettings> findAllByCampusIdAndDeletedFalse(
            @Param("campusId") Long campusId);
}
