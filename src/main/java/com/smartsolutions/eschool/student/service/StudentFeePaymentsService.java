package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import com.smartsolutions.eschool.student.error.StudentFeeAssignmentErrors;
import com.smartsolutions.eschool.student.model.*;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
@Slf4j
public class StudentFeePaymentsService {
    private final StudentRepository studentRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentFeeSummaryService studentFeeSummaryService;
    private final AcademicYearRepository academicYearRepository;
    private final StudentFeePaymentsRepository studentFeePaymentsRepository;
    private final InstituteRepository instituteRepository;

    public StudentFeePaymentsService(StudentRepository studentRepository, 
            StudentFeeAssignmentRepository studentFeeAssignmentRepository, 
            StudentFeeSummaryService studentFeeSummaryService, 
            AcademicYearRepository academicYearRepository, 
            StudentFeePaymentsRepository studentFeePaymentsRepository,
            InstituteRepository instituteRepository) {
        this.studentRepository = studentRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.academicYearRepository = academicYearRepository;
        this.studentFeePaymentsRepository = studentFeePaymentsRepository;
        this.instituteRepository = instituteRepository;
    }

    @Transactional
    public StudentFeePaymentRequestDTO studentFeePayment(Long studentId, @Valid StudentFeePaymentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] studentFeePayment() called - studentId={}, amount={}, institute={}", 
                studentId, requestDTO.getAmountPaid(), organizationId);

        // Fetch student
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> {
            log.error("[Service:StudentFeePaymentsService] Student with id {} not found", studentId);
            return new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Student not found", HttpStatus.NOT_FOUND);
        });

        // Fetch academic year
        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> {
            log.error("[Service:StudentFeePaymentsService] Current academic year not found");
            return new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND);
        });

        // Validate fee assignment
        List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository.findAllByStudentAndAcademicYear(studentId, currentYear.getId(), organizationId);

        if (assignments.isEmpty()) {
            throw new ApiException(StudentFeeAssignmentErrors.ASSIGNMENT_NOT_FOUND, "No fee assignments found for this student", HttpStatus.NOT_FOUND);
        }

        InstituteEntity institute = instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN));

        StudentFeePaymentEntity payment = new StudentFeePaymentEntity();
        payment.setStudent(student);
        payment.setOrganizationId(organizationId);
        payment.setPaymentDate(requestDTO.getPaymentDate());
        payment.setAmountPaid(requestDTO.getAmountPaid());
        payment.setPaymentMonth(requestDTO.getPaymentMonth());
        payment.setPaymentYear(requestDTO.getPaymentYear());
        payment.setPaymentMode(requestDTO.getPaymentMode());
        payment.setAcademicYear(currentYear);

        studentFeePaymentsRepository.save(payment);
        log.info("[Service:StudentFeePaymentsService] Fee payment recorded successfully | paymentId={}", payment.getId());

        // Update Summary
        studentFeeSummaryService.updateSummary(studentId, currentYear.getId(), organizationId);
        
        return MapperUtil.mapObject(payment, StudentFeePaymentRequestDTO.class);
    }

    public List<StudentFeePaymentResponseDTO> getStudentPaymentsByAcademicYear(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] getStudentPaymentsByAcademicYear() called - studentId={}, academicYearId={}, institute={}", 
                studentId, academicYearId, organizationId);

        List<StudentFeePaymentEntity> payments = studentFeePaymentsRepository.findPaymentsByStudentAndAcademicYear(studentId, academicYearId, organizationId);
        log.info("[Service:StudentFeePaymentsService] Found {} payments", payments.size());
        
        return MapperUtil.mapList(payments, StudentFeePaymentResponseDTO.class);
    }

    public Double getTotalFeeCollected(Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] getTotalFeeCollected() called - academicYearId={}, institute={}", academicYearId, organizationId);

        if (academicYearId == null) {
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() ->
                    new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
            academicYearId = currentYear.getId();
        }
        return studentFeePaymentsRepository.getTotalFeeCollected(academicYearId, organizationId);
    }

    public Double getCollectedUpToCurrentMonth() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] getCollectedUpToCurrentMonth() called - institute={}", organizationId);

        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() ->
                new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
        
        LocalDate endOfCurrentMonth = YearMonth.now().atEndOfMonth();
        return studentFeePaymentsRepository.getTotalCollectedUpToMonth(currentYear.getId(), endOfCurrentMonth, organizationId);
    }
}
