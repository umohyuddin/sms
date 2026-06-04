package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity, Long> {

    @Query("""
        SELECT sa FROM StudentAttendanceEntity sa
        JOIN FETCH sa.student s
        JOIN FETCH sa.campus c
        JOIN FETCH sa.standard st
        JOIN FETCH sa.section sec
        WHERE sa.organizationId = :organizationId
        AND (:campusId IS NULL OR sa.campus.id = :campusId)
        AND (:standardId IS NULL OR sa.standard.id = :standardId)
        AND (:sectionId IS NULL OR sa.section.id = :sectionId)
        AND (:attendanceDate IS NULL OR sa.attendanceDate = :attendanceDate)
        AND (:keyword IS NULL OR (s.fullName LIKE %:keyword% OR s.studentCode LIKE %:keyword%))
        ORDER BY sa.attendanceDate DESC, s.fullName ASC
    """)
    List<StudentAttendanceEntity> searchAttendance(
            @Param("organizationId") Long organizationId,
            @Param("campusId") Long campusId,
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("attendanceDate") LocalDate attendanceDate,
            @Param("keyword") String keyword);

    @Query("""
        SELECT sa FROM StudentAttendanceEntity sa
        JOIN FETCH sa.student s
        JOIN FETCH sa.campus c
        JOIN FETCH sa.standard st
        JOIN FETCH sa.section sec
        WHERE sa.id = :id AND sa.organizationId = :organizationId
    """)
    Optional<StudentAttendanceEntity> findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Modifying
    @Transactional
    @Query("UPDATE StudentAttendanceEntity sa SET sa.deleted = true, sa.deletedAt = CURRENT_TIMESTAMP WHERE sa.id = :id AND sa.organizationId = :organizationId")
    int softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    boolean existsByOrganizationIdAndStudentIdAndAttendanceDate(Long organizationId, Long studentId, LocalDate attendanceDate);

    @Query("SELECT COUNT(sa) FROM StudentAttendanceEntity sa WHERE sa.organizationId = :organizationId AND sa.attendanceDate = :date AND sa.status = :status")
    long countByOrganizationIdAndDateAndStatus(@Param("organizationId") Long organizationId, @Param("date") LocalDate date, @Param("status") StudentAttendanceEntity.AttendanceStatus status);

    @Query("""
        SELECT sa.campus.id, sa.status, COUNT(sa)
        FROM StudentAttendanceEntity sa
        WHERE sa.organizationId = :organizationId AND sa.attendanceDate BETWEEN :startDate AND :endDate
        GROUP BY sa.campus.id, sa.status
    """)
    List<Object[]> getCampusLevelStats(@Param("organizationId") Long organizationId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("""
        SELECT sa.standard.id, sa.status, COUNT(sa)
        FROM StudentAttendanceEntity sa
        WHERE sa.organizationId = :organizationId AND sa.campus.id = :campusId AND sa.attendanceDate BETWEEN :startDate AND :endDate
        GROUP BY sa.standard.id, sa.status
    """)
    List<Object[]> getStandardLevelStats(@Param("organizationId") Long organizationId, @Param("campusId") Long campusId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("""
        SELECT sa.section.id, sa.status, COUNT(sa)
        FROM StudentAttendanceEntity sa
        WHERE sa.organizationId = :organizationId AND sa.standard.id = :standardId AND sa.attendanceDate BETWEEN :startDate AND :endDate
        GROUP BY sa.section.id, sa.status
    """)
    List<Object[]> getSectionLevelStats(@Param("organizationId") Long organizationId, @Param("standardId") Long standardId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("""
        SELECT sa.student.id, sa.status, COUNT(sa.id)
        FROM StudentAttendanceEntity sa
        WHERE sa.organizationId = :organizationId AND sa.section.id = :sectionId 
        AND sa.attendanceDate BETWEEN :startDate AND :endDate
        GROUP BY sa.student.id, sa.status
    """)
    List<Object[]> getStudentLevelStats(@Param("organizationId") Long organizationId, @Param("sectionId") Long sectionId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
