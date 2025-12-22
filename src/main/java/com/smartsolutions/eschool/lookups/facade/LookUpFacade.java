package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.lookups.dtos.DashboardCountsDTO;
import com.smartsolutions.eschool.lookups.dtos.DashboardFinancialDTO;
import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
import com.smartsolutions.eschool.student.facade.StudentFeeAssignmentFacade;
import com.smartsolutions.eschool.student.facade.StudentFeePaymentsFacade;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class LookUpFacade {

    private EmployeeMasterFacade employeeMasterFacade;
    private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;
    private final StudentFeePaymentsFacade studentFeePaymentsFacade;


    public LookUpFacade(EmployeeMasterFacade employeeMasterFacade, StudentFeeAssignmentFacade studentFeeAssignmentFacade, StudentFeePaymentsFacade studentFeePaymentsFacade) {
        this.employeeMasterFacade = employeeMasterFacade;
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
        this.studentFeePaymentsFacade = studentFeePaymentsFacade;
    }

    public DashboardCountsDTO DashboardCounts() {
        Long totalEmployees = employeeMasterFacade.countAll();
        Map<String, Long> empByGender = employeeMasterFacade.getEmployeeCountByGender();
        return DashboardCountsDTO.builder()
                .totalEmployees(totalEmployees)
                .countByGender(empByGender).build();
    }

    ;

    public DashboardFinancialDTO DashboardFinancialCounts() {
        Double totalAssigned = studentFeeAssignmentFacade.getTotalFeeAssigned(null);
        Double totalCollected = studentFeePaymentsFacade.getTotalFeeCollected(null);
        double outstanding = totalAssigned - totalCollected;

        return DashboardFinancialDTO.builder()
                .collectedYearlyFee(totalCollected)
                .outstandingYearlyFee(outstanding)
                .assignedYearlyFee(totalAssigned).build();
    }

    ;
}
