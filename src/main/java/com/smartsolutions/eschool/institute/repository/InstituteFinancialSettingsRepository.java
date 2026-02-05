package com.smartsolutions.eschool.institute.repository;

import com.smartsolutions.eschool.institute.entity.InstituteFinancialSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituteFinancialSettingsRepository extends JpaRepository<InstituteFinancialSettings, Long> {

    Optional<InstituteFinancialSettings> findByInstituteIdAndAcademicYearIdAndIsDeletedFalse(Long instituteId, Long academicYearId);

    Optional<InstituteFinancialSettings> findByIdAndIsDeletedFalse(Long id);
}
