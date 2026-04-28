package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.response.EmployeeTypeHistoryDTO;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.model.EmployeeTypeHistoryEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeHistoryRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmployeeTypeHistoryService {

    private final EmployeeTypeHistoryRepository historyRepository;
    private final EmployeeMasterRepository employeeMasterRepository;
    private final EmployeeTypeRepository employeeTypeRepository;

    @Transactional
    public EmployeeTypeHistoryDTO assignEmployeeType(Long employeeId, Long typeId, Long createdBy) {

        // Fetch Employee
        EmployeeMasterEntity employee = employeeMasterRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        // Fetch Employee Type
        EmployeeTypeEntity type = employeeTypeRepository.findById(typeId)
                .orElseThrow(() -> new RuntimeException("Employee Type not found with ID: " + typeId));

        // End previous current type assignment
        historyRepository.findByEmployeeIdAndIsCurrentTrue(employeeId).ifPresent(prev -> {
            prev.setEndDate(LocalDateTime.now());
            prev.setIsCurrent(false);
            historyRepository.save(prev);
        });

        // 4️⃣ Create new type assignment
        EmployeeTypeHistoryEntity newHistory = new EmployeeTypeHistoryEntity();
        newHistory.setEmployee(employee);
        newHistory.setEmployeeType(type);
        newHistory.setStartDate(LocalDateTime.now());
        newHistory.setIsCurrent(true);
        newHistory.setCreatedAt(LocalDateTime.now());
        newHistory.setCreatedBy(createdBy);

        EmployeeTypeHistoryEntity saved = historyRepository.save(newHistory);

        // 5️⃣ Update employee_master reference
        employee.setEmployeeType(type);
        employeeMasterRepository.save(employee);

        // 6️⃣ Return DTO
        return new EmployeeTypeHistoryDTO(saved.getId(), employee.getId(), type.getId(), type.getName(), saved.getIsCurrent());
    }
}
