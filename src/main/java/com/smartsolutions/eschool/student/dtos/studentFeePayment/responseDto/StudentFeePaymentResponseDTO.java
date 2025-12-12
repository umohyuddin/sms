package com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeePaymentResponseDTO {
    private Long id;

    private Long studentId;
    private String studentFullName;

    private LocalDate paymentDate;

    private Double amountPaid;

    private String paymentMonth;

    private Integer paymentYear;

    private String paymentMode;

    private LocalDateTime createdAt;

    private Long academicYearId;
    private String academicYearName;

}
