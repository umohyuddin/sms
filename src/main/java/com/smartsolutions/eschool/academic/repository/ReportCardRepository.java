package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.ReportCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCardEntity, Long> {

    @Query("SELECT rc FROM ReportCardEntity rc WHERE rc.student.id = :studentId " +
            "AND rc.academicYear.id = :academicYearId AND rc.deleted = false")
    List<ReportCardEntity> findByStudentAndYear(@Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId);

    @Query("SELECT rc FROM ReportCardEntity rc WHERE rc.student.id = :studentId AND rc.deleted = false")
    List<ReportCardEntity> findByStudentId(@Param("studentId") Long studentId);

    @Modifying
    @Query("UPDATE ReportCardEntity rc SET rc.deleted = true, rc.deletedAt = CURRENT_TIMESTAMP WHERE rc.id = :id")
    void softDeleteById(@Param("id") Long id);
}
