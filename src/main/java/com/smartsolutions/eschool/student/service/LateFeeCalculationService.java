package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.institute.entity.CampusFinancialSettings;
import com.smartsolutions.eschool.institute.enums.LateFeeFrequency;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class LateFeeCalculationService {

    public BigDecimal calculateLateFee(com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity invoice, CampusFinancialSettings settings) {
        if (invoice == null) return BigDecimal.ZERO;
        return calculateLateFee(invoice.getTotalAmount(), invoice.getDueDate(), LocalDate.now(), settings);
    }

    public BigDecimal calculateLateFee(BigDecimal baseAmount, LocalDate dueDate, LocalDate calculationDate, CampusFinancialSettings settings) {
        if (baseAmount == null || dueDate == null || settings == null || !Boolean.TRUE.equals(settings.getLateFeeApplicable())) {
            return BigDecimal.ZERO;
        }

        if (calculationDate == null) calculationDate = LocalDate.now();

        Integer graceDays = settings.getGraceDays() != null ? settings.getGraceDays() : 0;
        LocalDate dueDateWithGrace = dueDate.plusDays(graceDays);

        if (!calculationDate.isAfter(dueDateWithGrace)) {
            return BigDecimal.ZERO;
        }

        long overdueDays = ChronoUnit.DAYS.between(dueDateWithGrace, calculationDate);
        BigDecimal lateFee = BigDecimal.ZERO;

        LateFeeType type = settings.getLateFeeType();
        if (LateFeeType.FIXED.equals(type)) {
            lateFee = settings.getLateFeeFixedAmount() != null ? settings.getLateFeeFixedAmount() : BigDecimal.ZERO;
        } else if (LateFeeType.PERCENTAGE.equals(type)) {
            BigDecimal percentage = settings.getLateFeePercentage() != null ? settings.getLateFeePercentage() : BigDecimal.ZERO;
            lateFee = baseAmount.multiply(percentage.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP));
        }

        LateFeeFrequency frequency = settings.getLateFeeFrequency();
        if (LateFeeFrequency.PER_DAY.equals(frequency)) {
            lateFee = lateFee.multiply(BigDecimal.valueOf(overdueDays));
        } else if (LateFeeFrequency.PER_WEEK.equals(frequency)) {
            long weeks = (overdueDays + 6) / 7; // Ceil division
            lateFee = lateFee.multiply(BigDecimal.valueOf(weeks));
        } else if (LateFeeFrequency.PER_MONTH.equals(frequency)) {
            long months = (overdueDays + 29) / 30; // Approximation of ceil division for months
            lateFee = lateFee.multiply(BigDecimal.valueOf(months));
        }

        BigDecimal maxAmount = settings.getLateFeeMaxAmount();
        if (maxAmount != null && maxAmount.compareTo(BigDecimal.ZERO) > 0) {
            lateFee = lateFee.min(maxAmount);
        }

        return lateFee.setScale(0, RoundingMode.HALF_UP);
    }
}
