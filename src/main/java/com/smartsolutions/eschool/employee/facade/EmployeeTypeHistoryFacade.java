package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.request.EmployeeTypeHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.response.EmployeeTypeHistoryDTO;
import com.smartsolutions.eschool.employee.service.EmployeeTypeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeTypeHistoryFacade {

    private final EmployeeTypeHistoryService service;

    public EmployeeTypeHistoryDTO assignEmployeeType(EmployeeTypeHistoryRequestDTO request) {
        return service.assignEmployeeType(
                request.getEmployeeId(),
                request.getEmployeeTypeId(),
                request.getCreatedBy()
        );
    }
}
