package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
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

        public String updateEmployeeProfile(Long employeeId, String file) {
            return employeeService.saveProfilePhoto(employeeId, file);
        }



        public void saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
            employeeService.saveEmployeeDocument(employeeId,docKey,file);
        }


        public List<EmployeeDocumentResponseDto> getEmployeeDocuments(Long employeeId) {
            return employeeService.getDocumentsByEmployeeId(employeeId);
        }
        public Map<String, List<EmployeeDocumentResponseDto>> getDocumentsByEmployeeId(Long employeeId) {
            return employeeService.getGroupedDocuments(employeeId);
        }

    public Resource getDocumentById(Long documentId, Long employeeId) {
            return employeeService.downloadDocument(documentId,employeeId);
    }

    public EmployeeMasterResponseDto updateEmployee(Long id, EmployeeMasterRequestDto requestDto) {
            return employeeService.updateEmployee(id,requestDto);
    }


}

