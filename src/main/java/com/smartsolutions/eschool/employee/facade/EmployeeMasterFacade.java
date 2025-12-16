package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


    @Component
    @Scope("prototype")
    public class EmployeeMasterFacade {

        private final EmployeeMasterService employeeService;

        public EmployeeMasterFacade(EmployeeMasterService employeeService) {
            this.employeeService = employeeService;
        }

        // -------------------------
        // Basic fetch operations
        // -------------------------
        public List<EmployeeMasterResponseDto> getAllEmployees() {
            return employeeService.getAll();
        }

        public EmployeeMasterResponseDto getEmployeeById(Long id) {
            return employeeService.getById(id);
        }

        public EmployeeMasterResponseDto getEmployeeByCode(String code) {
            return employeeService.getByEmployeeCode(code);
        }

        public List<EmployeeMasterResponseDto> searchEmployeesByName(String name) {
            return employeeService.searchByName(name);
        }

        public List<EmployeeMasterResponseDto> getEmployeesByGender(String gender) {
            return employeeService.getByGender(gender);
        }

        public List<EmployeeMasterResponseDto> getEmployeesByActiveStatus(Boolean status) {
            return employeeService.getByActiveStatus(status);
        }

        public List<EmployeeMasterResponseDto> getEmployeesWithProbationEndedBefore(Date date) {
            return employeeService.getProbationEndedBefore(date);
        }

        // -------------------------
        // Create / update operations
        // -------------------------
        public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto requestDto) {
            return employeeService.createEmployee(requestDto);
        }

        // -------------------------
        // Metrics / counts
        // -------------------------
        public long getTotalEmployees() {
            return employeeService.countAllEmployees();
        }

        public long getTotalActiveEmployees() {
            return employeeService.countActiveEmployees();
        }

        public long getTotalInactiveEmployees() {
            return employeeService.countInactiveEmployees();
        }
    }

