package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentFeeInvoiceRepository extends JpaRepository<StudentFeeInvoiceEntity, Long> {
    
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
}
