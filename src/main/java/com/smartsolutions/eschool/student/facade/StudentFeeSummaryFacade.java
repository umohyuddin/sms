package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.global.utils.SmsUtil;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.repository.StudentFeePaymentsRepository;
import com.smartsolutions.eschool.student.service.StudentFeeAssignmentService;
import com.smartsolutions.eschool.student.service.StudentFeePaymentsService;
import com.smartsolutions.eschool.student.service.StudentFeeSummaryService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class StudentFeeSummaryFacade {

    private final StudentFeeSummaryService studentFeeSummaryService;
    private final StudentFeePaymentsService studentFeePaymentsService;

    public StudentFeeSummaryFacade(StudentFeeSummaryService studentFeeSummaryService, StudentFeePaymentsService studentFeePaymentsService) {
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.studentFeePaymentsService = studentFeePaymentsService;
    }


    public StudentFeeSummaryDTO getByStudentId(Long id) {
        return studentFeeSummaryService.getByStudentId(id);
    }

    public List<StudentFeeSummaryDTO> getAll() {
        return studentFeeSummaryService.getAll();
    }

    public StudentFeeSummaryResponseDto getByStudentFeeSummaryAcademicYear(Long studentId, Long academicYearId) {
        //Fetch all student payments for this academic year
        List<StudentFeePaymentResponseDTO> responseDTOS = studentFeePaymentsService.getStudentPaymentsByAcademicYear(studentId, academicYearId);

        //Fetch all student payments for this academic year
        StudentFeeSummaryResponseDto studentFeeSummaryDTO = studentFeeSummaryService.getByStudentFeeSummaryAcademicYear(studentId, academicYearId);

        //Calculate monthly fee
        BigDecimal totalAssigned = studentFeeSummaryDTO.getTotalAssignedFee();
        BigDecimal months = BigDecimal.valueOf(studentFeeSummaryDTO.getAcademicTotalMonths());
        BigDecimal monthlyFeeDecimal = totalAssigned.divide(months, RoundingMode.HALF_UP);

        //Generate month names
        List<String> academicMonths = SmsUtil.getAcademicMonths(studentFeeSummaryDTO.getAcademicStartDate(), studentFeeSummaryDTO.getAcademicTotalMonths());
        studentFeeSummaryDTO.setMonthsNames(academicMonths);


        //Initialize monthly payments map
        Map<String, StudentFeeSummaryResponseDto.MonthlyPaymentDTO> monthMap = new HashMap<>();
        for (String month : academicMonths) {
            StudentFeeSummaryResponseDto.MonthlyPaymentDTO dto = new StudentFeeSummaryResponseDto.MonthlyPaymentDTO(month);
            studentFeeSummaryDTO.getMonthlyPayments().add(dto);
            monthMap.put(month, dto);
        }
        //Map each payment to its month
        for (StudentFeePaymentResponseDTO payment : studentFeeSummaryDTO.getStudentFeePaymentsList()) {
            StudentFeeSummaryResponseDto.MonthlyPaymentDTO dto = monthMap.get(payment.getPaymentMonth());
            if (dto != null) {
                dto.addPartialPayment(new StudentFeeSummaryResponseDto.PartialPaymentDTO(payment));
            }
        }

        BigDecimal cumulativePaid = BigDecimal.ZERO;
        BigDecimal cumulativeFee = BigDecimal.ZERO;
        for (StudentFeeSummaryResponseDto.MonthlyPaymentDTO monthDto : studentFeeSummaryDTO.getMonthlyPayments()) {
            BigDecimal monthPaid = monthDto.getPartialPayments().stream()
                    .map(StudentFeeSummaryResponseDto.PartialPaymentDTO::getAmountPaid)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            cumulativePaid = cumulativePaid.add(monthPaid);
            cumulativeFee = cumulativeFee.add(monthlyFeeDecimal);

            monthDto.setTotalPaid(monthPaid);
            monthDto.setTotalMonthlyFee(cumulativeFee);
            monthDto.setTotalPaidSoFar(cumulativePaid);

            // Determine status
            if (monthPaid.compareTo(monthlyFeeDecimal) >= 0) {
                monthDto.setStatus("Paid");
            } else if (monthPaid.compareTo(BigDecimal.ZERO) > 0) {
                monthDto.setStatus("Partial");
            } else {
                monthDto.setStatus("Unpaid");
            }
        }

        studentFeeSummaryDTO.setMonthlyFeeDecimal(monthlyFeeDecimal);
        studentFeeSummaryDTO.setStudentFeePaymentsList(responseDTOS);
        return studentFeeSummaryDTO;
    }
}

