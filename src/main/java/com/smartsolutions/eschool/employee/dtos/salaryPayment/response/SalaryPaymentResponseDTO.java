package com.smartsolutions.eschool.employee.dtos.salaryPayment.response;

import com.smartsolutions.eschool.employee.model.SalaryPaymentEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SalaryPaymentResponseDTO {

    private Long id;

    private Long employeeSalaryId;

    private LocalDate paymentDate;

    private SalaryPaymentEntity.PaymentMode paymentMode;

    private String transactionReference;

    private BigDecimal amountPaid;

    private String remarks;
}
