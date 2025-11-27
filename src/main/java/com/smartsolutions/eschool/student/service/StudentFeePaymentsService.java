package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.model.*;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentFeePaymentsService {


    private final StudentRepository studentRepository;
    private final FeeRateRepository feeRateRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentFeeSummaryRepository studentFeeSummaryRepository;
    private final AcademicYearRepository academicYearRepository;
    private final StudentFeePaymentsRepository studentFeePaymentsRepository;


    public StudentFeePaymentsService(StudentRepository studentRepository, FeeRateRepository feeRateRepository, StudentFeeAssignmentRepository studentFeeAssignmentRepository, StudentFeeSummaryRepository studentFeeSummaryRepository, AcademicYearRepository academicYearRepository, StudentFeePaymentsRepository studentFeePaymentsRepository) {
        this.studentRepository = studentRepository;
        this.feeRateRepository = feeRateRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryRepository = studentFeeSummaryRepository;
        this.academicYearRepository = academicYearRepository;
        this.studentFeePaymentsRepository = studentFeePaymentsRepository;
    }


    public StudentFeePaymentRequestDTO studentFeePayment(Long studentId, @Valid StudentFeePaymentRequestDTO requestDTO) {
        log.info("💰 Processing fee payment | studentId={},  amount={}", studentId, requestDTO.getAmountPaid());
        try {
            // Fetch and validate student --add academic year
            StudentEntity student = studentRepository.findByIdAndDeletedFalse(studentId).orElseThrow(() -> {
                log.error("Student with id {} not found", studentId);
                return new ResourceNotFoundException("Student not found with id " + studentId);
            });

            // Fetch academic year
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> {
                log.error("Current academic year not found");
                return new ResourceNotFoundException("Current academic year not found");
            });

            //validate fee assignment
            //StudentFeeAssignmentEntity assignment = studentFeeAssignmentRepository.findById(requestDTO.getAssignmentId()).orElseThrow(() -> new ResourceNotFoundException("Fee Assignment not found"));

            List<StudentFeeAssignmentEntity> assignments =
                    studentFeeAssignmentRepository.findAllByStudentAndAcademicYear(studentId, currentYear.getId());

            if (assignments.isEmpty()) {
                throw new ResourceNotFoundException("No fee assignments found for this student");
            }


//            if (!assignment.getStudent().getId().equals(requestDTO.getStudentId())) {
//                throw new IllegalArgumentException("Assignment does not belong to the given student");
//            }
            StudentFeePaymentEntity payment = new StudentFeePaymentEntity();
            payment.setStudent(student);
            //payment.setAssignment(assignment);
            payment.setPaymentDate(requestDTO.getPaymentDate());
            payment.setAmountPaid(requestDTO.getAmountPaid());
            payment.setPaymentMonth(requestDTO.getPaymentMonth());
            payment.setPaymentYear(requestDTO.getPaymentYear());
            payment.setPaymentMode(requestDTO.getPaymentMode());
            payment.setCreatedAt(LocalDateTime.now());
            payment.setAcademicYear(currentYear);

            studentFeePaymentsRepository.save(payment);
            log.info("Fee payment recorded successfully | paymentId={}", payment.getId());

            // Total assigned fee
            Double totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, requestDTO.getAcademicYearId());

            if (totalAssigned == null) totalAssigned = 0.0;
            BigDecimal assignedBD = BigDecimal.valueOf(totalAssigned);


            // Optional: Add a new field in assignment entity if you want:
            // assignment.setRemainingAmount(remaining);
            // assignmentRepository.save(assignment);


            StudentFeeSummaryEntity summary = studentFeeSummaryRepository.findByStudentId(student.getId()).orElse(null);
            if (summary == null) {
                log.info("Creating new fee summary | studentId={}, year={}", studentId, currentYear.getName());
                summary = new StudentFeeSummaryEntity();
                summary.setStudent(student);
                summary.setAcademicYear(currentYear);

                BigDecimal assigned = BigDecimal.valueOf(totalAssigned);
                BigDecimal paid = BigDecimal.valueOf(payment.getAmountPaid());
                BigDecimal balance = assigned.subtract(paid);

                summary.setTotalAssignedFee(assigned);
                summary.setTotalPaid(paid);
                summary.setBalance(balance);

            } else {
                log.info("Updating existing summary | summaryId={}", summary.getId());
                BigDecimal updatedPaid = summary.getTotalPaid().add(BigDecimal.valueOf(requestDTO.getAmountPaid()));

                BigDecimal balance = summary.getTotalAssignedFee().subtract(updatedPaid);

                summary.setTotalPaid(updatedPaid);
                summary.setBalance(balance);
            }

            studentFeeSummaryRepository.save(summary);
            log.info("Fee summary updated | studentId={}, balance={}", studentId, summary.getBalance());
            return MapperUtil.mapObject(payment, StudentFeePaymentRequestDTO.class);

        } catch (ResourceNotFoundException e) {
            // Already logged, rethrow to propagate
            throw e;
        } catch (Exception e) {
            log.error("Failed to assign fees for studentId={}", studentId, e);
            throw new RuntimeException("Failed to assign fees. Transaction rolled back.", e);
        }
    }
}
