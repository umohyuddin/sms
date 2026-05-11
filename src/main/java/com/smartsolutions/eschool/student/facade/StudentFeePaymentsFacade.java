package com.smartsolutions.eschool.student.facade;



import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.LateFeeWaiverRequestDTO;
import com.smartsolutions.eschool.student.service.StudentFeePaymentsService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
    public BigDecimal getTotalFeeCollected(Long academicYearId) {
        return studentFeePaymentsService.getTotalFeeCollected(academicYearId);
    }

    public BigDecimal getCollectedUpToCurrentMonth(){
        return studentFeePaymentsService.getCollectedUpToCurrentMonth();
    }

    public byte[] generateReceipt(Long paymentId) {
        return studentFeePaymentsService.generateReceipt(paymentId);
    }

    public void waiveLateFee(LateFeeWaiverRequestDTO requestDTO) {
        studentFeePaymentsService.waiveLateFee(requestDTO);
    }
}

