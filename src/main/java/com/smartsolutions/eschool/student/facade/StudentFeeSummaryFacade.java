package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import com.smartsolutions.eschool.student.repository.StudentFeeInvoiceRepository;
import com.smartsolutions.eschool.institute.entity.CampusFinancialSettings;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.repository.FeeRecurrenceRuleRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.global.utils.SmsUtil;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.service.StudentFeePaymentsService;
import com.smartsolutions.eschool.student.service.StudentFeeSummaryService;
import com.smartsolutions.eschool.student.service.LateFeeCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Scope("prototype")
@Slf4j
public class StudentFeeSummaryFacade {

    private final StudentFeeSummaryService studentFeeSummaryService;
    private final StudentFeePaymentsService studentFeePaymentsService;
    private final CampusFinancialSettingsRepository campusFinancialSettingsRepository;
    private final FeeRecurrenceRuleRepository feeRecurrenceRuleRepository;
    private final StudentRepository studentRepository;
    private final StudentFeeInvoiceRepository studentFeeInvoiceRepository;
    private final LateFeeCalculationService lateFeeCalculationService;

    public StudentFeeSummaryFacade(StudentFeeSummaryService studentFeeSummaryService,
            StudentFeePaymentsService studentFeePaymentsService,
            CampusFinancialSettingsRepository campusFinancialSettingsRepository,
            FeeRecurrenceRuleRepository feeRecurrenceRuleRepository,
            StudentRepository studentRepository,
            StudentFeeInvoiceRepository studentFeeInvoiceRepository,
            LateFeeCalculationService lateFeeCalculationService) {
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.studentFeePaymentsService = studentFeePaymentsService;
        this.campusFinancialSettingsRepository = campusFinancialSettingsRepository;
        this.feeRecurrenceRuleRepository = feeRecurrenceRuleRepository;
        this.studentRepository = studentRepository;
        this.studentFeeInvoiceRepository = studentFeeInvoiceRepository;
        this.lateFeeCalculationService = lateFeeCalculationService;
    }

    public StudentFeeSummaryDTO getByStudentId(Long id) {
        log.info("[Facade:StudentFeeSummaryFacade] getByStudentId() called - id: {}", id);
        return studentFeeSummaryService.getByStudentId(id);
    }

    public List<StudentFeeSummaryDTO> getAll() {
        log.info("[Facade:StudentFeeSummaryFacade] getAll() called");
        return studentFeeSummaryService.getAll();
    }

    public List<StudentFeeSummaryDTO> searchByKeyword(String keyword) {
        log.info("[Facade:StudentFeeSummaryFacade] searchByKeyword() called - keyword: {}", keyword);
        return studentFeeSummaryService.searchByKeyword(keyword);
    }

    public StudentFeeSummaryResponseDto getByStudentFeeSummaryAcademicYear(Long studentId, Long academicYearId) {
        log.info("[Facade:StudentFeeSummaryFacade] getByStudentFeeSummaryAcademicYear() called - studentId: {}, academicYearId: {}", 
                studentId, academicYearId);

        // Fetch all student payments for this academic year for detailed list
        List<StudentFeePaymentResponseDTO> payments = studentFeePaymentsService
                .getStudentPaymentsByAcademicYear(studentId, academicYearId);

        // Fetch base summary
        StudentFeeSummaryResponseDto studentFeeSummaryDTO = studentFeeSummaryService
                .getDetailedSummary(studentId, academicYearId);

        // Fetch Financial Settings to determine installments
        Long organizationId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        StudentEntity student = studentRepository.findByIdAndOrganizationId(studentId, organizationId).orElse(null);
        int occurrenceInterval = 1; // Default to monthly
        String billingCycleName = "Monthly"; // Default
        CampusFinancialSettings campusSett = null;
        if (student != null && student.getCampus() != null) {
            Optional<CampusFinancialSettings> settings = campusFinancialSettingsRepository
                    .findByCampusIdAndAcademicYearId(student.getCampus().getId(), academicYearId);
            if (settings.isPresent()) {
                campusSett = settings.get();
                if (campusSett.getFeeRecurrenceRuleId() != null) {
                    Optional<FeeRecurrenceRuleEntity> rule = feeRecurrenceRuleRepository
                            .findById(campusSett.getFeeRecurrenceRuleId());
                    if (rule.isPresent()) {
                        if (rule.get().getOccurrenceInterval() != null && rule.get().getOccurrenceInterval() > 0) {
                            occurrenceInterval = rule.get().getOccurrenceInterval();
                        }
                        if (rule.get().getName() != null) {
                            billingCycleName = rule.get().getName();
                        }
                    }
                }
            }
        }
        studentFeeSummaryDTO.setBillingCycle(billingCycleName);

        if (campusSett != null) {
            studentFeeSummaryDTO.setLateFeeApplicable(campusSett.getLateFeeApplicable());
            studentFeeSummaryDTO.setLateFeeType(campusSett.getLateFeeType() != null ? campusSett.getLateFeeType().name() : null);
            studentFeeSummaryDTO.setLateFeeFixedAmount(campusSett.getLateFeeFixedAmount());
            studentFeeSummaryDTO.setLateFeePercentage(campusSett.getLateFeePercentage());
            studentFeeSummaryDTO.setGraceDays(campusSett.getGraceDays());
            studentFeeSummaryDTO.setLateFeeFrequency(campusSett.getLateFeeFrequency() != null ? campusSett.getLateFeeFrequency().name() : null);
            studentFeeSummaryDTO.setLateFeeMaxAmount(campusSett.getLateFeeMaxAmount());
            studentFeeSummaryDTO.setLateFeeApplyOn(campusSett.getLateFeeApplyOn() != null ? campusSett.getLateFeeApplyOn().name() : null);
        } else {
            studentFeeSummaryDTO.setLateFeeApplicable(false);
        }

        // Generate month names for the entire academic year
        List<String> academicMonths = SmsUtil.getAcademicMonths(studentFeeSummaryDTO.getAcademicStartDate(),
                studentFeeSummaryDTO.getAcademicTotalMonths());
        studentFeeSummaryDTO.setMonthsNames(academicMonths);

        // Calculate Installments
        long totalMonths = studentFeeSummaryDTO.getAcademicTotalMonths();
        int totalInstallments = (int) Math.ceil((double) totalMonths / occurrenceInterval);
        
        BigDecimal totalAssigned = studentFeeSummaryDTO.getTotalAssignedFee();
        BigDecimal installmentAmount = (totalInstallments > 0) 
                ? totalAssigned.divide(BigDecimal.valueOf(totalInstallments), 2, RoundingMode.FLOOR) 
                : BigDecimal.ZERO;
        
        // Handle remainder for the last installment
        BigDecimal remainder = totalAssigned.subtract(installmentAmount.multiply(BigDecimal.valueOf(totalInstallments)));

        // Group months and payments into installments
        List<StudentFeeSummaryResponseDto.MonthlyPaymentDTO> installmentList = new ArrayList<>();
        Map<Integer, StudentFeeSummaryResponseDto.MonthlyPaymentDTO> installmentMap = new HashMap<>();

        for (int i = 0; i < totalInstallments; i++) {
            int startMonthIdx = i * occurrenceInterval;
            int endMonthIdx = Math.min((i + 1) * occurrenceInterval, (int) totalMonths) - 1;
            
            String installmentName;
            if (occurrenceInterval == 1) {
                installmentName = academicMonths.get(startMonthIdx);
            } else if (occurrenceInterval == 3) {
                installmentName = "Quarter " + (i + 1) + " (" + academicMonths.get(startMonthIdx).substring(0, 3) + "-" + academicMonths.get(endMonthIdx).substring(0, 3) + ")";
            } else if (occurrenceInterval == 12) {
                installmentName = "Annual";
            } else {
                installmentName = "Installment " + (i + 1);
            }

            StudentFeeSummaryResponseDto.MonthlyPaymentDTO installmentDto = new StudentFeeSummaryResponseDto.MonthlyPaymentDTO(installmentName);
            
            // Set monthly fee for this installment (add remainder to last one)
            BigDecimal currentInstallmentFee = installmentAmount;
            if (i == totalInstallments - 1) {
                currentInstallmentFee = installmentAmount.add(remainder);
            }
            installmentDto.setTotalMonthlyFee(currentInstallmentFee); // Reusing field for installment fee
            
            installmentList.add(installmentDto);
            installmentMap.put(i, installmentDto);
        }

        // Create month to installment index mapping
        Map<String, Integer> monthToInstallmentIdx = new HashMap<>();
        for (int m = 0; m < academicMonths.size(); m++) {
            monthToInstallmentIdx.put(academicMonths.get(m), m / occurrenceInterval);
        }

        // Fetch Invoices to get Late Fee information
        List<StudentFeeInvoiceEntity> invoices = studentFeeInvoiceRepository
                .findByStudentAndAcademicYear(studentId, academicYearId);

        for (StudentFeeInvoiceEntity invoice : invoices) {
            Integer installmentIdx = monthToInstallmentIdx.get(invoice.getMonth());
            if (installmentIdx != null && installmentMap.containsKey(installmentIdx)) {
                StudentFeeSummaryResponseDto.MonthlyPaymentDTO instDto = installmentMap.get(installmentIdx);
                
                // Calculate dynamic late fee based on current date and grace days/settings
                BigDecimal lateFee = BigDecimal.ZERO;
                if (invoice.getStatus() != StudentFeeInvoiceEntity.InvoiceStatus.PAID && campusSett != null) {
                    lateFee = lateFeeCalculationService.calculateLateFee(invoice, campusSett);
                }
                
                // If invoice already has a higher late fee recorded in DB (or if it's already cleared)
                if (invoice.getLateFeeAmount() != null && invoice.getLateFeeAmount().compareTo(lateFee) > 0) {
                    lateFee = invoice.getLateFeeAmount();
                }
                
                BigDecimal waived = invoice.getWaivedAmount() != null ? invoice.getWaivedAmount() : BigDecimal.ZERO;
                
                instDto.setLateFeeAmount(instDto.getLateFeeAmount().add(lateFee));
                instDto.setWaivedAmount(instDto.getWaivedAmount().add(waived));
            }
        }

        // Map each payment to its installment
        for (StudentFeePaymentResponseDTO payment : payments) {
            Integer installmentIdx = monthToInstallmentIdx.get(payment.getPaymentMonth());
            if (installmentIdx != null && installmentMap.containsKey(installmentIdx)) {
                installmentMap.get(installmentIdx).addPartialPayment(new StudentFeeSummaryResponseDto.PartialPaymentDTO(payment));
            }
        }

        BigDecimal cumulativePaid = BigDecimal.ZERO;
        BigDecimal cumulativeFee = BigDecimal.ZERO;
        
        for (StudentFeeSummaryResponseDto.MonthlyPaymentDTO instDto : installmentList) {
            BigDecimal instPaid = instDto.getPartialPayments().stream()
                    .map(StudentFeeSummaryResponseDto.PartialPaymentDTO::getAmountPaid)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            cumulativePaid = cumulativePaid.add(instPaid);
            cumulativeFee = cumulativeFee.add(instDto.getTotalMonthlyFee());

            instDto.setTotalPaid(instPaid);
            // In the UI, 'totalMonthlyFee' might be expected as cumulative or per installment.
            // Based on previous code: monthDto.setTotalMonthlyFee(cumulativeFee);
            instDto.setTotalMonthlyFee(cumulativeFee); 
            instDto.setTotalPaidSoFar(cumulativePaid);

            // Determine status based on installment fee (not cumulative)
            BigDecimal targetFee = instDto.getTotalMonthlyFee();
            // Wait, if it's cumulative, I should compare cumulativePaid vs cumulativeFee
            if (cumulativePaid.compareTo(cumulativeFee) >= 0) {
                instDto.setStatus("Paid");
            } else if (cumulativePaid.compareTo(BigDecimal.ZERO) > 0) {
                instDto.setStatus("Partial");
            } else {
                instDto.setStatus("Unpaid");
            }
        }

        studentFeeSummaryDTO.setMonthlyPayments(installmentList);
        studentFeeSummaryDTO.setMonthlyFeeDecimal(installmentAmount); // Representing the base installment amount
        studentFeeSummaryDTO.setStudentFeePaymentsList(payments);
        
        log.info("[Facade:StudentFeeSummaryFacade] getByStudentFeeSummaryAcademicYear() succeeded");
        return studentFeeSummaryDTO;
    }
}

