package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.dtos.studentAttendance.response.AttendanceSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentAttendance.response.ClassAttendanceReportDTO;
import com.smartsolutions.eschool.student.dtos.studentAttendance.response.DailyAttendanceReportDTO;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentAttendanceReportRepository extends JpaRepository<StudentAttendanceEntity, Long> {

    // Daily attendance per student
    @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.DailyAttendanceReportDTO(" +
            "s.studentId, NULL, s.attendanceDate, s.status, s.remarks) " +
            "FROM StudentAttendanceEntity s WHERE s.attendanceDate = :date")
    List<DailyAttendanceReportDTO> getDailyAttendance(@Param("date") LocalDate date);

    // Class attendance summary per day
    @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.ClassAttendanceReportDTO(" +
            "s.standardId, s.sectionId, s.attendanceDate, " +
            "SUM(CASE WHEN s.status = 'PRESENT' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.status = 'ABSENT' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.status = 'LEAVE' THEN 1 ELSE 0 END)) " +
            "FROM StudentAttendanceEntity s " +
            "WHERE s.standardId = :standardId AND s.sectionId = :sectionId AND s.attendanceDate BETWEEN :startDate AND :endDate "
            +
            "GROUP BY s.standardId, s.sectionId, s.attendanceDate")
    List<ClassAttendanceReportDTO> getClassAttendance(@Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // Overall attendance summary per student
    @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.AttendanceSummaryDTO(" +
            "s.studentId, NULL, " +
            "SUM(CASE WHEN s.status = 'PRESENT' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.status = 'ABSENT' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.status = 'LEAVE' THEN 1 ELSE 0 END)) " +
            "FROM StudentAttendanceEntity s " +
            "WHERE s.studentId = :studentId AND s.attendanceDate BETWEEN :startDate AND :endDate " +
            "GROUP BY s.studentId")
    AttendanceSummaryDTO getStudentAttendanceSummary(@Param("studentId") Long studentId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // Overall summary for all students
    @Query("SELECT new com.smartsolutions.eschool.student.dtos.studentAttendance.response.AttendanceSummaryDTO(" +
            "s.studentId, NULL, " +
            "SUM(CASE WHEN s.status = 'PRESENT' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.status = 'ABSENT' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.status = 'LEAVE' THEN 1 ELSE 0 END)) " +
            "FROM StudentAttendanceEntity s " +
            "WHERE s.attendanceDate BETWEEN :startDate AND :endDate " +
            "GROUP BY s.studentId")
    List<AttendanceSummaryDTO> getOverallAttendanceSummary(@Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    boolean existsByStudentIdAndAttendanceDate(Long studentId, LocalDate date);

    @Query("SELECT s FROM StudentAttendanceEntity s WHERE s.studentId = :studentId AND s.attendanceDate BETWEEN :startDate AND :endDate")
    List<StudentAttendanceEntity> findByStudentIdAndDateRange(Long studentId, LocalDate startDate, LocalDate endDate);

    @Query("SELECT s FROM StudentAttendanceEntity s WHERE s.standardId = :standardId AND s.sectionId = :sectionId AND s.attendanceDate = :date")
    List<StudentAttendanceEntity> findByClassAndDate(Long standardId, Long sectionId, LocalDate date);

    @Query("SELECT s FROM StudentAttendanceEntity s WHERE s.standardId = :standardId AND s.attendanceDate BETWEEN :startDate AND :endDate")
    List<StudentAttendanceEntity> findByStandardAndDateRange(Long standardId, LocalDate startDate, LocalDate endDate);

    @Query("SELECT COUNT(s) FROM StudentAttendanceEntity s WHERE s.studentId = :studentId AND s.status = :status AND s.attendanceDate BETWEEN :startDate AND :endDate")
    long countByStudentAndStatus(Long studentId, String status, LocalDate startDate, LocalDate endDate);

}
