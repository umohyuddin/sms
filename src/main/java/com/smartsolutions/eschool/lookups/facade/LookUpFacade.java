package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.lookups.dtos.DashboardCountsDTO;
import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
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


    public LookUpFacade(EmployeeMasterFacade employeeMasterFacade) {
        this.employeeMasterFacade = employeeMasterFacade;
    }

    public DashboardCountsDTO DashboardCounts(){
      Long totalEmployees = employeeMasterFacade.countAll();
      Map<String,Long> empByGender = employeeMasterFacade.getEmployeeCountByGender();
        return DashboardCountsDTO.builder()
                .totalEmployees(totalEmployees)
                .countByGender(empByGender).build();
    };
}
