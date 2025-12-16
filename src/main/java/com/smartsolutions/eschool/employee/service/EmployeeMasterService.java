package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmployeeMasterService {
    private final EmployeeMasterRepository employeeRepository;


    public EmployeeMasterService(EmployeeMasterRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // -------------------------
    // Get all employees
    // -------------------------
    public List<EmployeeMasterResponseDto> getAll() {
        try {
            log.info("Fetching all Employees from database");
            List<EmployeeMasterEntity> result = employeeRepository.findAll();
            log.info("Successfully fetched {} Employees", result.size());
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Employees", dae);
        } catch (MappingException me) {
            log.error("Error mapping EmployeeEntity to DTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Employees", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Get employee by ID
    // -------------------------
    public EmployeeMasterResponseDto getById(Long id) {
        log.info("Fetching Employee with id: {}", id);
        EmployeeMasterEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return MapperUtil.mapObject(employee, EmployeeMasterResponseDto.class);
    }

    // -------------------------
    // Get employee by employee code
    // -------------------------
    public EmployeeMasterResponseDto getByEmployeeCode(String code) {
        log.info("Fetching Employee with employeeCode: {}", code);
        EmployeeMasterEntity employee = employeeRepository.findByEmployeeCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with code: " + code));
        return MapperUtil.mapObject(employee, EmployeeMasterResponseDto.class);
    }

    // -------------------------
    // Search employees by name
    // -------------------------
    public List<EmployeeMasterResponseDto> searchByName(String name) {
        try {
            log.info("Searching Employees by name: {}", name);
            List<EmployeeMasterEntity> result = employeeRepository.searchByName(name);
            log.info("Found {} Employees matching name: {}", result.size(), name);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error searching employees by name", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Filter by gender
    // -------------------------
    public List<EmployeeMasterResponseDto> getByGender(String gender) {
        try {
            log.info("Fetching Employees by gender: {}", gender);
            List<EmployeeMasterEntity> result = employeeRepository.findByGender(gender);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching Employees by gender", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Filter by active status
    // -------------------------
    public List<EmployeeMasterResponseDto> getByActiveStatus(Boolean status) {
        try {
            log.info("Fetching Employees by active status: {}", status);
            List<EmployeeMasterEntity> result = employeeRepository.findByActiveStatus(status);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching Employees by active status", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Filter by probation end date
    // -------------------------
    public List<EmployeeMasterResponseDto> getProbationEndedBefore(Date date) {
        try {
            log.info("Fetching Employees whose probation ended before: {}", date);
            List<EmployeeMasterEntity> result = employeeRepository.findProbationEndedBefore(date);
            return MapperUtil.mapList(result, EmployeeMasterResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching Employees by probation end date", e);
        }
        return Collections.emptyList();
    }

    // -------------------------
    // Create new Employee
    // -------------------------
    @Transactional
    public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto employeeDTO) {
        log.info("Creating new Employee: {}", employeeDTO);

        EmployeeMasterEntity employeeEntity = MapperUtil.mapObject(employeeDTO, EmployeeMasterEntity.class);

        employeeEntity.setId(null);
        EmployeeMasterEntity savedEmployee = employeeRepository.save(employeeEntity);

        EmployeeMasterResponseDto responseDTO = MapperUtil.mapObject(savedEmployee, EmployeeMasterResponseDto.class);
        log.info("Successfully created Employee: {}", responseDTO);
        return responseDTO;
    }

    // -------------------------
    // Count / Metrics
    // -------------------------
    public long countAllEmployees() {
        return employeeRepository.countAllEmployees();
    }

    public long countActiveEmployees() {
        return employeeRepository.countActiveEmployees();
    }

    public long countInactiveEmployees() {
        return employeeRepository.countInactiveEmployees();
    }
}

