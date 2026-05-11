package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentFeeInvoiceRepository extends JpaRepository<StudentFeeInvoiceEntity, Long> {
    
    @Query("SELECT SUM(i.lateFeeAmount) FROM StudentFeeInvoiceEntity i " +
           "WHERE i.student.id = ?1 AND i.academicYear.id = ?2 AND i.deleted = false")
    java.math.BigDecimal sumTotalLateFee(Long studentId, Long academicYearId);

    @Query("SELECT SUM(i.waivedAmount) FROM StudentFeeInvoiceEntity i " +
           "WHERE i.student.id = ?1 AND i.academicYear.id = ?2 AND i.deleted = false")
    java.math.BigDecimal sumTotalWaivedAmount(Long studentId, Long academicYearId);

    @Query("""
        SELECT COALESCE(SUM(i.balance), 0)
        FROM StudentFeeInvoiceEntity i
        WHERE i.organizationId = :instituteId
          AND i.deleted = false
          AND (:campusIds IS NULL OR i.student.campus.id IN :campusIds)
          AND (:academicYearId IS NULL OR i.academicYear.id = :academicYearId)
          AND (:toDate IS NULL OR i.dueDate <= :toDate)
    """)
    java.math.BigDecimal sumPendingDuesByFilters(
            @Param("campusIds") java.util.List<Long> campusIds,
            @Param("academicYearId") Long academicYearId,
            @Param("toDate") java.time.LocalDate toDate,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT i.student.standard.standardName, COALESCE(SUM(i.balance), 0)
        FROM StudentFeeInvoiceEntity i
        WHERE i.organizationId = :instituteId
          AND i.deleted = false
          AND (:campusIds IS NULL OR i.student.campus.id IN :campusIds)
          AND (:toDate IS NULL OR i.dueDate <= :toDate)
        GROUP BY i.student.standard.standardName
    """)
    java.util.List<Object[]> pendingDuesByStandardDistribution(
            @Param("campusIds") java.util.List<Long> campusIds,
            @Param("toDate") java.time.LocalDate toDate,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT 
            i.status,
            COUNT(i)
        FROM StudentFeeInvoiceEntity i
        WHERE i.organizationId = :instituteId
          AND i.deleted = false
          AND (:campusIds IS NULL OR i.student.campus.id IN :campusIds)
          AND (:toDate IS NULL OR i.dueDate <= :toDate)
        GROUP BY i.status
    """)
    java.util.List<Object[]> getFeeStatusDistribution(
            @Param("campusIds") java.util.List<Long> campusIds,
            @Param("toDate") java.time.LocalDate toDate,
            @Param("instituteId") Long instituteId
    );

    Optional<StudentFeeInvoiceEntity> findByStudentIdAndAcademicYearIdAndMonthAndYearAndDeletedFalse(
            Long studentId, Long academicYearId, String month, Integer year);
            
    Optional<StudentFeeInvoiceEntity> findByInvoiceNumberAndDeletedFalse(String invoiceNumber);

    @Query("SELECT i FROM StudentFeeInvoiceEntity i " +
           "WHERE i.student.id = ?1 AND i.academicYear.id = ?2 AND i.deleted = false " +
           "AND (i.status = 'UNPAID' OR i.status = 'PARTIAL') " +
           "ORDER BY i.dueDate ASC")
    List<StudentFeeInvoiceEntity> findOutstandingInvoices(Long studentId, Long academicYearId);

    @Query("SELECT i FROM StudentFeeInvoiceEntity i " +
           "WHERE i.student.id = ?1 AND i.academicYear.id = ?2 AND i.deleted = false " +
           "ORDER BY i.invoiceDate DESC")
    List<StudentFeeInvoiceEntity> findByStudentAndAcademicYear(Long studentId, Long academicYearId);

    @Query("SELECT i FROM StudentFeeInvoiceEntity i " +
           "WHERE i.organizationId = ?1 AND i.deleted = false " +
           "AND (i.status = 'UNPAID' OR i.status = 'PARTIAL') " +
           "ORDER BY i.dueDate ASC")
    List<StudentFeeInvoiceEntity> findAllOutstandingByOrganization(Long organizationId);
    @Query("SELECT i FROM StudentFeeInvoiceEntity i " +
           "WHERE i.dueDate <= :targetDate " +
           "AND i.deleted = false " +
           "AND (i.status = 'UNPAID' OR i.status = 'PARTIAL') " +
           "AND (i.lastReminderSentAt IS NULL OR i.lastReminderSentAt < :reminderWindowStart)")
    List<StudentFeeInvoiceEntity> findUpcomingInvoicesForReminder(
            @Param("targetDate") java.time.LocalDate targetDate, 
            @Param("reminderWindowStart") java.time.LocalDateTime reminderWindowStart);

    @Query("SELECT i FROM StudentFeeInvoiceEntity i " +
           "WHERE i.dueDate < CURRENT_DATE " +
           "AND i.deleted = false " +
           "AND (i.status = 'UNPAID' OR i.status = 'PARTIAL')")
    List<StudentFeeInvoiceEntity> findAllOverdueInvoices();
}
