package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.AcademicStudentAttendanceEntity;
import com.smartsolutions.eschool.student.dtos.studentAttendance.response.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademicStudentAttendanceRepository extends JpaRepository<AcademicStudentAttendanceEntity, Long> {

       @Query("SELECT sa FROM AcademicStudentAttendanceEntity sa WHERE sa.student.id = :studentId " +
                     "AND sa.attendanceDate BETWEEN :startDate AND :endDate AND sa.deleted = false")
       List<AcademicStudentAttendanceEntity> findMonthlyView(@Param("studentId") Long studentId,
                     @Param("startDate") LocalDate startDate,
                     @Param("endDate") LocalDate endDate);

       @Query("SELECT sa FROM AcademicStudentAttendanceEntity sa WHERE sa.standard.id = :standardId " +
                     "AND sa.section.id = :sectionId AND sa.attendanceDate = :date AND sa.deleted = false")
       List<AcademicStudentAttendanceEntity> findByStandardSectionAndDate(@Param("standardId") Long standardId,
                     @Param("sectionId") Long sectionId,
                     @Param("date") LocalDate date);

       @Modifying
       @Query("UPDATE AcademicStudentAttendanceEntity sa SET sa.deleted = true, sa.deletedAt = CURRENT_TIMESTAMP WHERE sa.id = :id")
       void softDeleteById(@Param("id") Long id);

       // --- Merged methods from student package ---

       @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.DailyAttendanceReportDTO("
                     +
                     "s.student.id, NULL, s.attendanceDate, s.status, s.remarks) " +
                     "FROM AcademicStudentAttendanceEntity s WHERE s.attendanceDate = :date AND s.deleted = false")
       List<DailyAttendanceReportDTO> getDailyAttendance(@Param("date") LocalDate date);

       @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.ClassAttendanceReportDTO("
                     +
                     "s.standard.id, s.section.id, s.attendanceDate, " +
                     "SUM(CASE WHEN s.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                     "SUM(CASE WHEN s.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                     "SUM(CASE WHEN s.status = 'LEAVE' THEN 1 ELSE 0 END)) " +
                     "FROM AcademicStudentAttendanceEntity s " +
                     "WHERE s.standard.id = :standardId AND s.section.id = :sectionId AND s.attendanceDate BETWEEN :startDate AND :endDate AND s.deleted = false "
                     +
                     "GROUP BY s.standard.id, s.section.id, s.attendanceDate")
       List<ClassAttendanceReportDTO> getClassAttendance(@Param("standardId") Long standardId,
                     @Param("sectionId") Long sectionId,
                     @Param("startDate") LocalDate startDate,
                     @Param("endDate") LocalDate endDate);

       @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.AttendanceSummaryDTO(" +
                     "s.student.id, NULL, " +
                     "SUM(CASE WHEN s.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                     "SUM(CASE WHEN s.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                     "SUM(CASE WHEN s.status = 'LEAVE' THEN 1 ELSE 0 END)) " +
                     "FROM AcademicStudentAttendanceEntity s " +
                     "WHERE s.student.id = :studentId AND s.attendanceDate BETWEEN :startDate AND :endDate AND s.deleted = false "
                     +
                     "GROUP BY s.student.id")
       AttendanceSummaryDTO getStudentAttendanceSummary(@Param("studentId") Long studentId,
                     @Param("startDate") LocalDate startDate,
                     @Param("endDate") LocalDate endDate);

       @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.AttendanceSummaryDTO(" +
                     "s.student.id, NULL, " +
                     "SUM(CASE WHEN s.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                     "SUM(CASE WHEN s.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                     "SUM(CASE WHEN s.status = 'LEAVE' THEN 1 ELSE 0 END)) " +
                     "FROM AcademicStudentAttendanceEntity s " +
                     "WHERE s.attendanceDate BETWEEN :startDate AND :endDate AND s.deleted = false " +
                     "GROUP BY s.student.id")
       List<AttendanceSummaryDTO> getOverallAttendanceSummary(@Param("startDate") LocalDate startDate,
                     @Param("endDate") LocalDate endDate);

       boolean existsByStudentIdAndAttendanceDate(Long studentId, LocalDate date);

       @Query("SELECT s FROM AcademicStudentAttendanceEntity s WHERE s.student.id = :studentId AND s.attendanceDate BETWEEN :startDate AND :endDate AND s.deleted = false")
       List<AcademicStudentAttendanceEntity> findByStudentIdAndDateRange(@Param("studentId") Long studentId,
                     @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

       @Query("SELECT s FROM AcademicStudentAttendanceEntity s WHERE s.standard.id = :standardId AND s.section.id = :sectionId AND s.attendanceDate = :date AND s.deleted = false")
       List<AcademicStudentAttendanceEntity> findByClassAndDate(@Param("standardId") Long standardId,
                     @Param("sectionId") Long sectionId, @Param("date") LocalDate date);

       @Query("SELECT s FROM AcademicStudentAttendanceEntity s WHERE s.standard.id = :standardId AND s.attendanceDate BETWEEN :startDate AND :endDate AND s.deleted = false")
       List<AcademicStudentAttendanceEntity> findByStandardAndDateRange(@Param("standardId") Long standardId,
                     @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

       @Query("SELECT COUNT(s) FROM AcademicStudentAttendanceEntity s WHERE s.student.id = :studentId AND s.status = :status AND s.attendanceDate BETWEEN :startDate AND :endDate AND s.deleted = false")
       long countByStudentAndStatus(@Param("studentId") Long studentId,
                     @Param("status") AcademicStudentAttendanceEntity.AttendanceStatus status,
                     @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
