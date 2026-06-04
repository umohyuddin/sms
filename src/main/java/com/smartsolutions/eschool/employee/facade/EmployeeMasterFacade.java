package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeCreateRequestDto;
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

    private final EmployeeMasterService nEmployeeMasterService;

    public EmployeeMasterFacade(EmployeeMasterService nEmployeeMasterService) {
        this.nEmployeeMasterService = nEmployeeMasterService;
    }

    public List<EmployeeMasterResponseDto> getAllEmployees() {
        log.info("[Facade:EmployeeMasterFacade] getAllEmployees() called");
        return nEmployeeMasterService.getAll();
    }

    public EmployeeMasterResponseDto getEmployeeById(Long id) {
        log.info("[Facade:EmployeeMasterFacade] getEmployeeById() called - id: {}", id);
        return nEmployeeMasterService.getById(id);
    }

    public EmployeeMasterResponseDto getEmployeeByCode(String code) {
        log.info("[Facade:EmployeeMasterFacade] getEmployeeByCode() called - code: {}", code);
        return nEmployeeMasterService.getByEmployeeCode(code);
    }

    public List<EmployeeMasterResponseDto> searchByKeyword(String keyword) {
        log.info("[Facade:EmployeeMasterFacade] searchByKeyword() called - keyword: {}", keyword);
        return nEmployeeMasterService.searchByKeyword(keyword);
    }

    public List<EmployeeMasterResponseDto> getEmployeesByGender(String gender) {
        log.info("[Facade:EmployeeMasterFacade] getEmployeesByGender() called - gender: {}", gender);
        return nEmployeeMasterService.getByGender(gender);
    }

    public List<EmployeeMasterResponseDto> getEmployeesByActiveStatus(Boolean status) {
        log.info("[Facade:EmployeeMasterFacade] getEmployeesByActiveStatus() called - status: {}", status);
        return nEmployeeMasterService.getByActiveStatus(status);
    }

    public List<EmployeeMasterResponseDto> getEmployeesWithProbationEndedBefore(Date date) {
        log.info("[Facade:EmployeeMasterFacade] getEmployeesWithProbationEndedBefore() called - date: {}", date);
        return nEmployeeMasterService.getProbationEndedBefore(date);
    }

    public EmployeeMasterResponseDto createEmployee(EmployeeCreateRequestDto requestDto) {
        log.info("[Facade:EmployeeMasterFacade] createEmployee(create) called");
        return nEmployeeMasterService.createEmployee(requestDto);
    }

    public EmployeeMasterResponseDto createEmployee(EmployeeMasterRequestDto requestDto) {
        log.info("[Facade:EmployeeMasterFacade] createEmployee(master) called");
        return nEmployeeMasterService.createEmployee(requestDto);
    }

    public long getTotalEmployees() {
        log.info("[Facade:EmployeeMasterFacade] getTotalEmployees() called");
        return nEmployeeMasterService.countAllEmployees();
    }

    public long getTotalActiveEmployees() {
        log.info("[Facade:EmployeeMasterFacade] getTotalActiveEmployees() called");
        return nEmployeeMasterService.countActiveEmployees();
    }

    public long getTotalInactiveEmployees() {
        log.info("[Facade:EmployeeMasterFacade] getTotalInactiveEmployees() called");
        return nEmployeeMasterService.countInactiveEmployees();
    }

    public String updateEmployeeProfile(Long employeeId, String file) {
        log.info("[Facade:EmployeeMasterFacade] updateEmployeeProfile() called - employeeId: {}", employeeId);
        return nEmployeeMasterService.saveProfilePhoto(employeeId, file);
    }

    public void saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        log.info("[Facade:EmployeeMasterFacade] saveEmployeeDocument() called - employeeId: {}", employeeId);
        nEmployeeMasterService.saveEmployeeDocument(employeeId, docKey, file);
    }

    public List<EmployeeDocumentResponseDto> getEmployeeDocuments(Long employeeId) {
        log.info("[Facade:EmployeeMasterFacade] getEmployeeDocuments() called - employeeId: {}", employeeId);
        return nEmployeeMasterService.getDocumentsByEmployeeId(employeeId);
    }

    public Map<String, List<EmployeeDocumentResponseDto>> getDocumentsByEmployeeId(Long employeeId) {
        log.info("[Facade:EmployeeMasterFacade] getDocumentsByEmployeeId() called - employeeId: {}", employeeId);
        return nEmployeeMasterService.getGroupedDocuments(employeeId);
    }

    public Resource getDocumentById(Long documentId, Long employeeId) {
        log.info("[Facade:EmployeeMasterFacade] getDocumentById() called - documentId: {}, employeeId: {}", documentId, employeeId);
        return nEmployeeMasterService.downloadDocument(documentId, employeeId);
    }

    public EmployeeMasterResponseDto updateEmployee(Long id, EmployeeMasterRequestDto requestDto) {
        log.info("[Facade:EmployeeMasterFacade] updateEmployee() called - id: {}", id);
        return nEmployeeMasterService.updateEmployee(id, requestDto);
    }

    public void deleteEmployee(Long id) {
        log.info("[Facade:EmployeeMasterFacade] deleteEmployee() called - id: {}", id);
        nEmployeeMasterService.delete(id);
    }

    public Map<String, Long> getEmployeeCountByGender() {
        log.info("[Facade:EmployeeMasterFacade] getEmployeeCountByGender() called");
        return nEmployeeMasterService.getEmployeeCountByGender();
    }

    public List<EmployeeTypeCountDTO> getEmployeeCountByType() {
        log.info("[Facade:EmployeeMasterFacade] getEmployeeCountByType() called");
        return nEmployeeMasterService.getEmployeeCountByType();
    }
}
