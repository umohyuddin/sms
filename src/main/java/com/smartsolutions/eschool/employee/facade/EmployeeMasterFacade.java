package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeTypeCountDTO;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@Scope("prototype")
@Slf4j
public class EmployeeMasterFacade {

    private final EmployeeMasterService employeeService;

    public EmployeeMasterFacade(EmployeeMasterService employeeService) {
        this.employeeService = employeeService;
    }

    public List<EmployeeMasterResponseDto> getAllEmployees() {
        log.info("Facade: Request to fetch all Employees");
        List<EmployeeMasterResponseDto> result = employeeService.getAll();
        log.info("Facade: Successfully fetched {} Employees", result.size());
        return result;
    }

    public EmployeeMasterResponseDto getEmployeeById(Long id) {
        log.info("Facade: Request to fetch Employee by id: {}", id);
        EmployeeMasterResponseDto result = employeeService.getById(id);
        log.info("Facade: Successfully fetched Employee: id={}", id);
        return result;
    }

    public EmployeeMasterResponseDto getEmployeeByCode(String code) {
        log.info("Facade: Request to fetch Employee by code: {}", code);
        EmployeeMasterResponseDto result = employeeService.getByEmployeeCode(code);
        log.info("Facade: Successfully fetched Employee: code={}", code);
        return result;
    }

    public List<EmployeeMasterResponseDto> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Employees by keyword: '{}'", keyword);
        List<EmployeeMasterResponseDto> result = employeeService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Employees", result.size());
        return result;
    }

    public List<EmployeeMasterResponseDto> getEmployeesByGender(String gender) {
        log.info("Facade: Request to fetch Employees by gender: '{}'", gender);
        List<EmployeeMasterResponseDto> result = employeeService.getByGender(gender);
        log.info("Facade: Successfully fetched {} Employees", result.size());
        return result;
    }

    public List<EmployeeMasterResponseDto> getEmployeesByActiveStatus(Boolean status) {
        log.info("Facade: Request to fetch Employees by active status: {}", status);
        List<EmployeeMasterResponseDto> result = employeeService.getByActiveStatus(status);
        log.info("Facade: Successfully fetched {} Employees", result.size());
        return result;
    }

    public List<EmployeeMasterResponseDto> getEmployeesWithProbationEndedBefore(Date date) {
        log.info("Facade: Request to fetch Employees with probation ended before: {}", date);
        List<EmployeeMasterResponseDto> result = employeeService.getProbationEndedBefore(date);
        log.info("Facade: Successfully fetched {} Employees", result.size());
        return result;
    }

    public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto requestDto) {
        log.info("Facade: Request to create new Employee: {} {}", requestDto.getFirstName(), requestDto.getLastName());
        EmployeeMasterResponseDto result = employeeService.createEmployee(requestDto);
        log.info("Facade: Successfully created Employee: id={}", result.getId());
        return result;
    }

    public long getTotalEmployees() {
        return employeeService.countAllEmployees();
    }

    public long getTotalActiveEmployees() {
        return employeeService.countActiveEmployees();
    }

    public long getTotalInactiveEmployees() {
        return employeeService.countInactiveEmployees();
    }

    public String updateEmployeeProfile(Long employeeId, String file) {
        log.info("Facade: Request to update profile photo for Employee ID: {}", employeeId);
        String result = employeeService.saveProfilePhoto(employeeId, file);
        log.info("Facade: Successfully updated profile photo");
        return result;
    }

    public void saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        log.info("Facade: Request to save document for Employee ID: {}", employeeId);
        employeeService.saveEmployeeDocument(employeeId, docKey, file);
        log.info("Facade: Document saved successfully");
    }

    public List<EmployeeDocumentResponseDto> getEmployeeDocuments(Long employeeId) {
        log.info("Facade: Request to fetch documents for Employee ID: {}", employeeId);
        List<EmployeeDocumentResponseDto> result = employeeService.getDocumentsByEmployeeId(employeeId);
        log.info("Facade: Successfully fetched {} documents", result.size());
        return result;
    }

    public Map<String, List<EmployeeDocumentResponseDto>> getDocumentsByEmployeeId(Long employeeId) {
        log.info("Facade: Request to fetch grouped documents for Employee ID: {}", employeeId);
        return employeeService.getGroupedDocuments(employeeId);
    }

    public Resource getDocumentById(Long documentId, Long employeeId) {
        log.info("Facade: Request to download document ID {} for Employee ID {}", documentId, employeeId);
        return employeeService.downloadDocument(documentId, employeeId);
    }

    public EmployeeMasterResponseDto updateEmployee(Long id, EmployeeMasterRequestDto requestDto) {
        log.info("Facade: Request to update Employee ID: {}", id);
        EmployeeMasterResponseDto result = employeeService.updateEmployee(id, requestDto);
        log.info("Facade: Successfully updated Employee: id={}", id);
        return result;
    }

    public void deleteEmployee(Long id) {
        log.info("Facade: Request to delete Employee ID: {}", id);
        employeeService.delete(id);
        log.info("Facade: Successfully deleted Employee: id={}", id);
    }

    public Map<String, Long> getEmployeeCountByGender() {
        return employeeService.getEmployeeCountByGender();
    }

    public List<EmployeeTypeCountDTO> getEmployeeCountByType() {
        return employeeService.getEmployeeCountByType();
    }
}

