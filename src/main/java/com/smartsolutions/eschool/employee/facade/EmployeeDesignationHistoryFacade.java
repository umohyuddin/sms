package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.request.EmployeeDesignationHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.response.EmployeeDesignationHistoryResponseDTO;
import com.smartsolutions.eschool.employee.service.EmployeeDesignationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeDesignationHistoryFacade {

    private final EmployeeDesignationHistoryService service;

    public EmployeeDesignationHistoryResponseDTO assignDesignation(EmployeeDesignationHistoryRequestDTO request) {
        return service.assignDesignation(request);
    }
}