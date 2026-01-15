package com.smartsolutions.eschool.employee.facade;


import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.request.EmployeeDepartmentHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.response.EmployeeDepartmentHistoryResponseDTO;
import com.smartsolutions.eschool.employee.service.EmployeeDepartmentHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class EmployeeDepartmentHistoryFacade {
    private final EmployeeDepartmentHistoryService departmentHistoryService;

    /**
     * Assign a department to an employee
     */
    public EmployeeDepartmentHistoryResponseDTO assignDepartment(EmployeeDepartmentHistoryRequestDTO request) {
        return departmentHistoryService.assignDepartment(request);
    }

    /**
     * Get the current department for an employee
     */
    public EmployeeDepartmentHistoryResponseDTO getCurrentDepartment(Long employeeId) {
        return departmentHistoryService.getCurrentDepartment(employeeId);
    }

    /**
     * Get full department history for an employee
     */
    public List<EmployeeDepartmentHistoryResponseDTO> getDepartmentHistory(Long employeeId) {
        return departmentHistoryService.getDepartmentHistory(employeeId);
    }

    /**
     * Optional: soft delete a department assignment
     */
    public void deleteAssignment(Long historyId, Long deletedBy) {
        departmentHistoryService.deleteAssignment(historyId, deletedBy);
    }
}
