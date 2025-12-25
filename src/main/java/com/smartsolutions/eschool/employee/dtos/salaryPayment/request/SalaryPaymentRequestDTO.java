package com.smartsolutions.eschool.employee.dtos.salaryPayment.request;

import com.smartsolutions.eschool.employee.model.SalaryPaymentEntity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SalaryPaymentRequestDTO {
    @NotNull(message = "Employee Salary ID is required")
    private Long employeeSalaryId;

    @NotNull(message = "Payment date is required")
    private LocalDate paymentDate;

    @NotNull(message = "Payment mode is required")
    private SalaryPaymentEntity.PaymentMode paymentMode;

    @Size(max = 100, message = "Transaction reference must be max 100 characters")
    private String transactionReference;

    @NotNull(message = "Amount paid is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    private BigDecimal amountPaid;

    @Size(max = 255, message = "Remarks must be max 255 characters")
    private String remarks;

}
