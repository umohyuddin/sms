package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.model.EmployeeDepartmentHistoryEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeDepartmentHistoryRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeDepartmentHistoryService {

    private final EmployeeDepartmentHistoryRepository historyRepository;
    private final EmployeeMasterRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    /**
     * Assigns a department to an employee, ends previous assignment if exists.
     */
    @Transactional
    public EmployeeDepartmentHistoryEntity assignDepartment(Long employeeId, Long departmentId, Long createdBy) {

        log.info("Assigning Department ID {} to Employee ID {}", departmentId, employeeId);

        // End previous assignment if exists
        historyRepository.findCurrentByEmployeeId(employeeId).ifPresent(prev -> {
            prev.setEndDate(LocalDateTime.now());
            prev.setIsCurrent(false);
            historyRepository.save(prev);
        });

        // Fetch employee and department entities
        EmployeeMasterEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + employeeId));

        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + departmentId));

        // Create new assignment
        EmployeeDepartmentHistoryEntity newAssignment = new EmployeeDepartmentHistoryEntity();
        newAssignment.setEmployee(employee);
        newAssignment.setDepartment(department);
        newAssignment.setStartDate(LocalDateTime.now());
        newAssignment.setIsCurrent(true);
        newAssignment.setCreatedBy(createdBy);

        return historyRepository.save(newAssignment);
    }

    /**
     * Retrieves current department for an employee
     */
    @Transactional(readOnly = true)
    public Optional<EmployeeDepartmentHistoryEntity> getCurrentDepartment(Long employeeId) {
        return historyRepository.findCurrentByEmployeeId(employeeId);
    }

    /**
     * Retrieves all department history for an employee
     */
//    @Transactional(readOnly = true)
//    public List<EmployeeDepartmentHistoryEntity> getDepartmentHistory(Long employeeId) {
//        return historyRepository.findByEmployeeIdOrderByStartDateDesc(employeeId);
//    }

    /**
     * Soft delete a department assignment
     */
    @Transactional
    public void deleteAssignment(Long historyId, Long deletedBy) {
        EmployeeDepartmentHistoryEntity assignment = historyRepository.findById(historyId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with ID: " + historyId));

        assignment.setDeleted(true);
        assignment.setDeletedAt(LocalDateTime.now());
        assignment.setDeletedBy(deletedBy);

        historyRepository.save(assignment);
    }
}