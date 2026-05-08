package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentFeeInvoiceRepository extends JpaRepository<StudentFeeInvoiceEntity, Long> {
    
    Optional<StudentFeeInvoiceEntity> findByStudentIdAndAcademicYearIdAndMonthAndYearAndDeletedFalse(
            Long studentId, Long academicYearId, String month, Integer year);
            
    Optional<StudentFeeInvoiceEntity> findByInvoiceNumberAndDeletedFalse(String invoiceNumber);
}
