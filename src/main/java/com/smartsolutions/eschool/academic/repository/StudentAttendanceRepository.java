package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.StudentAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity, Long> {

    @Query("SELECT sa FROM StudentAttendanceEntity sa WHERE sa.student.id = :studentId " +
           "AND sa.attendanceDate BETWEEN :startDate AND :endDate AND sa.deleted = false")
    List<StudentAttendanceEntity> findMonthlyView(@Param("student_id") Long studentId, 
                                                @Param("startDate") LocalDate startDate, 
                                                @Param("endDate") LocalDate endDate);

    @Query("SELECT sa FROM StudentAttendanceEntity sa WHERE sa.standard.id = :standardId " +
           "AND sa.section.id = :sectionId AND sa.attendanceDate = :date AND sa.deleted = false")
    List<StudentAttendanceEntity> findByStandardSectionAndDate(@Param("standardId") Long standardId,
                                                              @Param("section_id") Long sectionId,
                                                              @Param("date") LocalDate date);

    @Modifying
    @Query("UPDATE StudentAttendanceEntity sa SET sa.deleted = true, sa.deletedAt = CURRENT_TIMESTAMP WHERE sa.id = :id")
    void softDeleteById(@Param("id") Long id);
}
