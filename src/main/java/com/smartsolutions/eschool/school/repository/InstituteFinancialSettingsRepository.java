package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteFinancialSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituteFinancialSettingsRepository extends JpaRepository<InstituteFinancialSettingsEntity, Long> {
    
    Optional<InstituteFinancialSettingsEntity> findByInstituteIdAndAcademicYearIdAndDeletedFalse(Long instituteId, Long academicYearId);
    
    Optional<InstituteFinancialSettingsEntity> findByInstituteIdAndIsActiveTrueAndDeletedFalse(Long instituteId);
}
