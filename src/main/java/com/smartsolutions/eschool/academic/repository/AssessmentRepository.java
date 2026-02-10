package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentEntity, Long> {

    @Query("SELECT a FROM AssessmentEntity a JOIN FETCH a.assessmentType JOIN FETCH a.teacherSubjectAssignment " +
           "WHERE a.academicYear.id = :academicYearId AND a.deleted = false")
    List<AssessmentEntity> findByAcademicYearId(@Param("academicYearId") Long academicYearId);

    @Modifying
    @Query("UPDATE AssessmentEntity a SET a.deleted = true, a.deletedAt = CURRENT_TIMESTAMP WHERE a.id = :id")
    void softDeleteById(@Param("id") Long id);
}
