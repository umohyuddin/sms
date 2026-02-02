package com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteBillingUpdateRequestDTO {
    private String billingEmail;
    private String taxNumber;
    private String currency;

    private String subscriptionPlan;
    private String paymentCycle;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionEnd;
}
