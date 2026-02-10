package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.request.EmployeeDepartmentHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.response.EmployeeDepartmentHistoryResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeDepartmentHistoryEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeDepartmentHistoryRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import org.springframework.transaction.annotation.Transactional;
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
     * Assigns a department to an employee, ending any previous assignment.
     */
    @Transactional
    public EmployeeDepartmentHistoryResponseDTO assignDepartment(EmployeeDepartmentHistoryRequestDTO request) {
        log.info("Assigning Department ID {} to Employee ID {}", request.getDepartmentId(), request.getEmployeeId());

        // End previous assignment
        historyRepository.findCurrentByEmployeeId(request.getEmployeeId()).ifPresent(prev -> {
            prev.setEndDate(LocalDateTime.now());
            prev.setIsCurrent(false);
            historyRepository.save(prev);
        });

        // Fetch employee and department
        EmployeeMasterEntity employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + request.getEmployeeId()));

        DepartmentEntity department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + request.getDepartmentId()));

        // Create new assignment
        EmployeeDepartmentHistoryEntity newAssignment = new EmployeeDepartmentHistoryEntity();
        newAssignment.setEmployee(employee);
        newAssignment.setDepartment(department);
        newAssignment.setStartDate(LocalDateTime.now());
        newAssignment.setIsCurrent(true);
        newAssignment.setCreatedBy(request.getCreatedBy());

        EmployeeDepartmentHistoryEntity saved = historyRepository.save(newAssignment);
        return mapToResponseDTO(saved);
    }

    /**
     * Get current department assignment for an employee
     */
    @Transactional(readOnly = true)
    public EmployeeDepartmentHistoryResponseDTO getCurrentDepartment(Long employeeId) {
        return historyRepository.findCurrentByEmployeeId(employeeId)
                .map(this::mapToResponseDTO)
                .orElse(null);
    }

    /**
     * Get all department assignments for an employee (history)
     */
    @Transactional(readOnly = true)
    public List<EmployeeDepartmentHistoryResponseDTO> getDepartmentHistory(Long employeeId) {
        return historyRepository.findByEmployeeId(employeeId)
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    /**
     * Optional: Soft delete a department assignment
     */
    @Transactional
    public void deleteAssignment(Long historyId, Long deletedBy) {
        EmployeeDepartmentHistoryEntity assignment = historyRepository.findById(historyId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with ID: " + historyId));

        assignment.setDeletedAt(LocalDateTime.now());
        assignment.setDeletedBy(deletedBy);
        assignment.setIsCurrent(false);

        historyRepository.save(assignment);
    }

    /**
     * Mapper: Entity → Response DTO
     */
    private EmployeeDepartmentHistoryResponseDTO mapToResponseDTO(EmployeeDepartmentHistoryEntity entity) {
        EmployeeDepartmentHistoryResponseDTO dto = new EmployeeDepartmentHistoryResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployee().getId());
        //dto.setEmployeeFullName(entity.getEmployee().getFullName());
        dto.setDepartmentId(entity.getDepartment().getId());
        dto.setDepartmentName(entity.getDepartment().getDepartmentName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setIsCurrent(entity.getIsCurrent());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedAt(entity.getCreatedAt());
        //dto.setDeletedBy(entity.getDeletedBy());
        //dto.setDeletedAt(entity.getDeletedAt());
        return dto;
    }
}
