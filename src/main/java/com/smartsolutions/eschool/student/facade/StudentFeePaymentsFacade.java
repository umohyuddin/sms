package com.smartsolutions.eschool.student.facade;


import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.service.StudentFeePaymentsService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StudentFeePaymentsFacade {

    private StudentFeePaymentsService studentFeePaymentsService;

    public StudentFeePaymentsFacade(StudentFeePaymentsService studentFeePaymentsService) {
        this.studentFeePaymentsService = studentFeePaymentsService;
    }


    public StudentFeePaymentRequestDTO studentFeePayment(Long studentId, @Valid StudentFeePaymentRequestDTO requestDTO) {
        return studentFeePaymentsService.studentFeePayment(studentId, requestDTO);
    }
    public Double getTotalFeeCollected(Long academicYearId) {
        return studentFeePaymentsService.getTotalFeeCollected(academicYearId);
    }
}

