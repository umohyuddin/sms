package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamTermRepository extends JpaRepository<ExamTermEntity, Long> {

    @Query("SELECT et FROM ExamTermEntity et JOIN FETCH et.academicYear WHERE et.academicYear.id = :academicYearId AND et.deleted = false")
    List<ExamTermEntity> findByAcademicYearId(@Param("academicYearId") Long academicYearId);

    @Modifying
    @Query("UPDATE ExamTermEntity et SET et.deleted = true, et.deletedAt = CURRENT_TIMESTAMP WHERE et.id = :id")
    void softDeleteById(@Param("id") Long id);
}
