package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.request.EmployeeDesignationHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.response.EmployeeDesignationHistoryResponseDTO;
import com.smartsolutions.eschool.employee.model.*;
import com.smartsolutions.eschool.employee.repository.EmployeeDesignationHistoryRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeHistoryRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.school.repository.DesignationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmployeeDesignationHistoryService {

    private final EmployeeDesignationHistoryRepository repository;
    private final EmployeeMasterRepository employeeMasterRepository;
    private final DesignationRepository designationRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeTypeRepository employeeTypeRepository;
    private final EmployeeTypeHistoryRepository employeeTypeHistoryRepository;

    @Transactional
    public EmployeeDesignationHistoryResponseDTO assignDesignation(EmployeeDesignationHistoryRequestDTO request) {

        // 1️⃣ Fetch Employee
        EmployeeMasterEntity employee = employeeMasterRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + request.getEmployeeId()));

        // 2️⃣ Fetch Designation
        DesignationEntity designation = designationRepository.findById(request.getDesignationId())
                .orElseThrow(() -> new RuntimeException("Designation not found with ID: " + request.getDesignationId()));

        // 3️⃣ Fetch Department (if provided)
        DepartmentEntity department = null;
        if (request.getDepartmentId() != null) {
            department = departmentRepository.findById(request.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with ID: " + request.getDepartmentId()));
        }

        LocalDateTime now = LocalDateTime.now();

        // 4️⃣ End previous current designation
        repository.findByEmployeeIdAndIsCurrentTrue(employee.getId())
                .ifPresent(prev -> {
                    prev.setEndDate(now);
                    prev.setIsCurrent(false);
                    repository.save(prev);
                });

        // 5️⃣ Create new designation assignment
        EmployeeDesignationHistoryEntity newAssignment = new EmployeeDesignationHistoryEntity();
        newAssignment.setEmployee(employee);
        newAssignment.setDesignation(designation);
        newAssignment.setDepartment(department);
        newAssignment.setStartDate(now);
        newAssignment.setIsCurrent(true);
        EmployeeDesignationHistoryEntity savedAssignment = repository.save(newAssignment);

        // 6️⃣ Assign employee type automatically from designation
        EmployeeTypeEntity employeeType = designation.getEmployeeType();
        if (employeeType != null) {

            // 6a️⃣ End previous current type
            employeeTypeHistoryRepository.findByEmployeeIdAndIsCurrentTrue(employee.getId())
                    .ifPresent(prevType -> {
                        prevType.setEndDate(now);
                        prevType.setIsCurrent(false);
                        employeeTypeHistoryRepository.save(prevType);
                    });

            // 6b️⃣ Create new type history
            EmployeeTypeHistoryEntity typeHistory = new EmployeeTypeHistoryEntity();
            typeHistory.setEmployee(employee);
            typeHistory.setEmployeeType(employeeType);
            typeHistory.setStartDate(now);
            typeHistory.setIsCurrent(true);
            employeeTypeHistoryRepository.save(typeHistory);

            // 6c️⃣ Update employee master
            employee.setEmployeeType(employeeType);
            employeeMasterRepository.save(employee);
        }

        // 7️⃣ Build response DTO
        EmployeeDesignationHistoryResponseDTO response = new EmployeeDesignationHistoryResponseDTO();
        response.setId(savedAssignment.getId());
        response.setEmployeeId(employee.getId());
        response.setDesignationId(designation.getId());
        response.setDesignationName(designation.getDesignationName());
        response.setDepartmentId(department != null ? department.getId() : null);
        response.setIsCurrent(savedAssignment.getIsCurrent());
        //response.setEmployeeTypeId(employeeType != null ? employeeType.getId() : null);
        //response.setEmployeeTypeName(employeeType != null ? employeeType.getName() : null);

        return response;
    }
}