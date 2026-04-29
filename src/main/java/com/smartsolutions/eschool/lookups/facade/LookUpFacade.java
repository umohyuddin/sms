package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.lookups.dtos.DashboardCountsDTO;
import com.smartsolutions.eschool.lookups.dtos.DashboardFinancialDTO;
import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.facade.AcademicYearFacade;
import com.smartsolutions.eschool.student.facade.StudentFeeAssignmentFacade;
import com.smartsolutions.eschool.student.facade.StudentFeePaymentsFacade;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
@Scope("prototype")
public class LookUpFacade {

    private EmployeeMasterFacade employeeMasterFacade;
    private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;
    private final StudentFeePaymentsFacade studentFeePaymentsFacade;
    private final AcademicYearFacade academicYearFacade;


    public LookUpFacade(EmployeeMasterFacade employeeMasterFacade, StudentFeeAssignmentFacade studentFeeAssignmentFacade, StudentFeePaymentsFacade studentFeePaymentsFacade, AcademicYearFacade academicYearFacade) {
        this.employeeMasterFacade = employeeMasterFacade;
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
        this.studentFeePaymentsFacade = studentFeePaymentsFacade;
        this.academicYearFacade = academicYearFacade;
    }

    public DashboardCountsDTO DashboardCounts() {
        Long totalEmployees = employeeMasterFacade.getTotalActiveEmployees();
        Map<String, Long> empByGender = employeeMasterFacade.getEmployeeCountByGender();
        return DashboardCountsDTO.builder()
                .totalEmployees(totalEmployees)
                .countByGender(empByGender).build();
    }

    ;

    public DashboardFinancialDTO DashboardFinancialCounts() {
        AcademicYearResponseDTO currentYear = academicYearFacade.getCurrentAcademicYear();

        Double totalAssigned = studentFeeAssignmentFacade.getTotalFeeAssigned(null);
        Double totalCollected = studentFeePaymentsFacade.getTotalFeeCollected(null);
        double outstanding = totalAssigned - totalCollected;

        Double totalCollectedMonthly = studentFeePaymentsFacade.getCollectedUpToCurrentMonth();

        double expectedMonthlyCollection = totalAssigned / currentYear.getTotalMonths();
        // Monthly outstanding = expected - collected
        double monthlyOutstanding = expectedMonthlyCollection - totalCollectedMonthly;
        LocalDate today = LocalDate.now();
        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("Current month: " + monthName); // e.g., "December"
        return DashboardFinancialDTO.builder()
                .academicYearName(currentYear.getName())
                .collectedYearlyFee(totalCollected)
                .outstandingYearlyFee(outstanding)
                .assignedYearlyFee(totalAssigned).
                collectedMonthlyFee(totalCollectedMonthly).
                assignedMonthlyFee(expectedMonthlyCollection).
                outstandingMonthlyFee(monthlyOutstanding)
                .monthName(monthName)
                .build();
    }

    ;
}
