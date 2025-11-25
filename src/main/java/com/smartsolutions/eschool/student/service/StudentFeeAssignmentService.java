package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.FeeRateRepository;
import com.smartsolutions.eschool.student.repository.StudentFeeAssignmentRepository;
import com.smartsolutions.eschool.student.repository.StudentFeeSummaryRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentFeeAssignmentService {


    private final StudentRepository studentRepository;
    private final FeeRateRepository feeRateRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentFeeSummaryRepository studentFeeSummaryRepository;
    private  final AcademicYearRepository academicYearRepository;


    public StudentFeeAssignmentService(StudentRepository studentRepository, FeeRateRepository feeRateRepository, StudentFeeAssignmentRepository studentFeeAssignmentRepository, StudentFeeSummaryRepository studentFeeSummaryRepository, AcademicYearRepository academicYearRepository) {
        this.studentRepository = studentRepository;
        this.feeRateRepository = feeRateRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryRepository = studentFeeSummaryRepository;
        this.academicYearRepository = academicYearRepository;
    }

    @Transactional
    public StudentFeeAssignmentRequestDTO assignStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {

        // Fetch student
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        List<FeeRateEntity> feeRates = feeRateRepository.findApplicableFeeRatesForStudent(
                dto.getComponentIds(), dto.getCampusId(), dto.getStandardId(),dto.getAcademicYearId()
        );

        List<StudentFeeAssignmentEntity> assignments = feeRates.stream().map(feeRate -> {
            StudentFeeAssignmentEntity assignment = new StudentFeeAssignmentEntity();
            assignment.setStudent(student);
            assignment.setFeeRate(feeRate);
            assignment.setTotalAmount(feeRate.getAmount().doubleValue());
            assignment.setAssignedDate(LocalDate.now());
            assignment.setDueDate(dto.getDueDate()); // from payload or calculate
            return assignment;
        }).collect(Collectors.toList());
        studentFeeAssignmentRepository.saveAll(assignments);
        Double totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, dto.getAcademicYearId());

        //Fetch the current academic year (or the one you want)
        AcademicYearEntity currentYear =academicYearRepository.findByIsCurrentTrue()
                .orElseThrow(() -> new ResourceNotFoundException("Current academic year not found"));

//         Fetch existing summary or create new
        StudentFeeSummaryEntity summary = studentFeeSummaryRepository
                .findByStudentId(studentId)
                .orElseGet(() -> {
                    StudentFeeSummaryEntity s = new StudentFeeSummaryEntity();
                    s.setStudent(student);
                    s.setAcademicYear(currentYear);
                    s.setTotalPaid(BigDecimal.ZERO);
                    return s;
                });

        // Set totals
        summary.setTotalAssignedFee(BigDecimal.valueOf(totalAssigned));
        summary.setBalance(summary.getTotalAssignedFee().subtract(summary.getTotalPaid()));

        // Save summary
        studentFeeSummaryRepository.save(summary);
        return new StudentFeeAssignmentRequestDTO();
    }
}
