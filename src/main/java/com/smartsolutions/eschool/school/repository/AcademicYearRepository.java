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

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYearEntity, Long> {

    @Query("SELECT ar FROM AcademicYearEntity ar " +
            "WHERE ar.isCurrent = true")
    Optional<AcademicYearEntity> findByIsCurrentTrue();


    @Modifying
    @Query("UPDATE AcademicYearEntity a SET a.isCurrent = false WHERE a.isCurrent = true")
    void deactivateAllAcademicYears();


}


