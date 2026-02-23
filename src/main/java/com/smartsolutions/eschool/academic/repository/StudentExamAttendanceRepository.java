package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceDetailDTO;
import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamAttendanceRepository extends JpaRepository<StudentExamAttendanceEntity, Long> {

        @Query("SELECT sea FROM StudentExamAttendanceEntity sea JOIN FETCH sea.student " +
                        "WHERE sea.examSubject.id = :examSubjectId AND sea.organizationId = :orgId AND sea.deleted = false")
        List<StudentExamAttendanceEntity> findByExamSubjectIdAndOrganizationId(
                        @Param("examSubjectId") Long examSubjectId,
                        @Param("orgId") Long orgId);

        @Query("SELECT sea FROM StudentExamAttendanceEntity sea " +
                        "WHERE sea.examSubject.id = :examSubjectId AND sea.student.id = :studentId AND sea.organizationId = :orgId AND sea.deleted = false")
        StudentExamAttendanceEntity findByExamSubjectIdAndStudentIdAndOrganizationId(
                        @Param("examSubjectId") Long examSubjectId, @Param("studentId") Long studentId,
                        @Param("orgId") Long orgId);

        @Modifying
        @Query("UPDATE StudentExamAttendanceEntity sea SET sea.deleted = true, sea.deletedAt = CURRENT_TIMESTAMP WHERE sea.id = :id AND sea.organizationId = :orgId")
        void softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("orgId") Long orgId);

        // Reporting Queries

        // 1. Campus Wise Summary
        @Query("SELECT new com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO(" +
                        "c.id, " +
                        "c.campusName, " +
                        "COUNT(sea.id), " +
                        "SUM(CASE WHEN sea.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'UFM' THEN 1 ELSE 0 END), " +
                        "CAST(0 AS java.math.BigDecimal)) " + // Percentage calculated in service
                        "FROM StudentExamAttendanceEntity sea " +
                        "JOIN sea.examSubject es " +
                        "JOIN es.exam e " +
                        "JOIN e.campus c " +
                        "WHERE sea.organizationId = :orgId AND sea.deleted = false " +
                        "AND (:academicYearId IS NULL OR e.academicYear.id = :academicYearId) " +
                        "GROUP BY c.id, c.campusName")
        List<ExamAttendanceSummaryDTO> getCampusSummary(@Param("orgId") Long orgId,
                        @Param("academicYearId") Long academicYearId);

        // 2. Standard Wise Summary
        @Query("SELECT new com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO(" +
                        "s.id, " +
                        "s.standardName, " +
                        "COUNT(sea.id), " +
                        "SUM(CASE WHEN sea.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'UFM' THEN 1 ELSE 0 END), " +
                        "CAST(0 AS java.math.BigDecimal)) " +
                        "FROM StudentExamAttendanceEntity sea " +
                        "JOIN sea.examSubject es " +
                        "JOIN es.exam e " +
                        "JOIN e.standard s " +
                        "WHERE sea.organizationId = :orgId AND sea.deleted = false " +
                        "AND (:campusId IS NULL OR e.campus.id = :campusId) " +
                        "AND (:academicYearId IS NULL OR e.academicYear.id = :academicYearId) " +
                        "GROUP BY s.id, s.standardName")
        List<ExamAttendanceSummaryDTO> getStandardSummary(@Param("orgId") Long orgId, @Param("campusId") Long campusId,
                        @Param("academicYearId") Long academicYearId);

        // 3. Section Wise Summary
        @Query("SELECT new com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO(" +
                        "sec.id, " +
                        "sec.sectionName, " +
                        "COUNT(sea.id), " +
                        "SUM(CASE WHEN sea.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'UFM' THEN 1 ELSE 0 END), " +
                        "CAST(0 AS java.math.BigDecimal)) " +
                        "FROM StudentExamAttendanceEntity sea " +
                        "JOIN sea.examSubject es " +
                        "JOIN es.exam e " +
                        "JOIN e.section sec " +
                        "WHERE sea.organizationId = :orgId AND sea.deleted = false " +
                        "AND (:standardId IS NULL OR e.standard.id = :standardId) " +
                        "AND (:academicYearId IS NULL OR e.academicYear.id = :academicYearId) " +
                        "GROUP BY sec.id, sec.sectionName")
        List<ExamAttendanceSummaryDTO> getSectionSummary(@Param("orgId") Long orgId,
                        @Param("standardId") Long standardId, @Param("academicYearId") Long academicYearId);

        // 4. Subject Wise Summary
        @Query("SELECT new com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO(" +
                        "sub.id, " +
                        "sub.name, " +
                        "COUNT(sea.id), " +
                        "SUM(CASE WHEN sea.status = 'PRESENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'ABSENT' THEN 1 ELSE 0 END), " +
                        "SUM(CASE WHEN sea.status = 'UFM' THEN 1 ELSE 0 END), " +
                        "CAST(0 AS java.math.BigDecimal)) " +
                        "FROM StudentExamAttendanceEntity sea " +
                        "JOIN sea.examSubject es " +
                        "JOIN es.subject sub " +
                        "JOIN es.exam e " +
                        "WHERE sea.organizationId = :orgId AND sea.deleted = false " +
                        "AND (:sectionId IS NULL OR e.section.id = :sectionId) " +
                        "AND (:academicYearId IS NULL OR e.academicYear.id = :academicYearId) " +
                        "GROUP BY sub.id, sub.name")
        List<ExamAttendanceSummaryDTO> getSubjectSummary(@Param("orgId") Long orgId, @Param("sectionId") Long sectionId,
                        @Param("academicYearId") Long academicYearId);

        // 5. Detailed Report (For Absentees, UFM, or Student History)
        @Query("SELECT new com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceDetailDTO(" +
                        "sea.id, " +
                        "stu.id, " +
                        "stu.firstName || ' ' || stu.lastName, " +
                        "stu.studentCode, " +
                        "c.campusName, " +
                        "stan.standardName, " +
                        "sec.sectionName, " +
                        "sub.name, " +
                        "es.examDate, " +
                        "sea.status) " +
                        "FROM StudentExamAttendanceEntity sea " +
                        "JOIN sea.student stu " +
                        "JOIN sea.examSubject es " +
                        "JOIN es.exam e " +
                        "JOIN e.campus c " +
                        "JOIN e.standard stan " +
                        "JOIN e.section sec " +
                        "JOIN es.subject sub " +
                        "WHERE sea.organizationId = :orgId AND sea.deleted = false " +
                        "AND (:campusId IS NULL OR e.campus.id = :campusId) " +
                        "AND (:standardId IS NULL OR e.standard.id = :standardId) " +
                        "AND (:sectionId IS NULL OR e.section.id = :sectionId) " +
                        "AND (:examSubjectId IS NULL OR es.id = :examSubjectId) " +
                        "AND (:studentId IS NULL OR stu.id = :studentId) " +
                        "AND (:status IS NULL OR sea.status = :status) " +
                        "AND (:startDate IS NULL OR es.examDate >= :startDate) " +
                        "AND (:endDate IS NULL OR es.examDate <= :endDate)")
        List<ExamAttendanceDetailDTO> getDetailedReport(@Param("orgId") Long orgId,
                        @Param("campusId") Long campusId,
                        @Param("standardId") Long standardId,
                        @Param("sectionId") Long sectionId,
                        @Param("examSubjectId") Long examSubjectId,
                        @Param("studentId") Long studentId,
                        @Param("status") StudentExamAttendanceEntity.AttendanceStatus status,
                        @Param("startDate") java.time.LocalDate startDate,
                        @Param("endDate") java.time.LocalDate endDate);
}
