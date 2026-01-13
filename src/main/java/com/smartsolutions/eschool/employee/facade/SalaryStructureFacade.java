package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureDetailDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.employee.service.SalaryStructureService;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@Scope("prototype")
public class SalaryStructureFacade {

    private final SalaryStructureService salaryStructureService;

    public SalaryStructureFacade(SalaryStructureService salaryStructureService) {
        this.salaryStructureService = salaryStructureService;
    }

    // -------------------------
    // Basic fetch operations
    // -------------------------
    public SalaryStructureResponseDTO getById(Long id) {
        return salaryStructureService.getById(id);
    }

    public List<SalaryStructureResponseDTO> getAllActive() {
        return salaryStructureService.getAllActive();
    }

//    public List<SalaryStructureResponseDTO> getEffectiveOn(LocalDate date) {
//        return salaryStructureService.getEffectiveOn(date);
//    }

    // -------------------------
    // Create / update operations
    // -------------------------
    public SalaryStructureResponseDTO createSalaryStructure(SalaryStructureRequestDTO requestDTO) {
        return salaryStructureService.createSalaryStructure(requestDTO);
    }

    public SalaryStructureResponseDTO updateSalaryStructure(Long id, SalaryStructureRequestDTO requestDTO) {
        return salaryStructureService.updateSalaryStructure(id, requestDTO);
    }

    public SalaryStructureResponseDTO closeSalaryStructure(Long id) {
        return salaryStructureService.closeSalaryStructure(id);
    }

    // -------------------------
    // Soft delete
    // -------------------------
    public void softDelete(Long id) {
        salaryStructureService.softDelete(id);
    }

    // -------------------------
    // Metrics / counts
    // -------------------------
//    public Long countByEmployeeType(Long employeeTypeId) {
//        // Optionally implement in service to count by employee type
//        return salaryStructureService.countByEmployeeType(employeeTypeId);
//    }

    // -------------------------
    // Date range queries
    // -------------------------
//    public List<SalaryStructureResponseDTO> getWithinDateRange(LocalDate startDate, LocalDate endDate) {
//        return salaryStructureService.getWithinDateRange(startDate, endDate);
//    }

    public List<SalaryStructureResponseDTO> searchSalaryStructures(Long employeeTypeId, String employeeTypeName, BigDecimal minSalary, BigDecimal maxSalary, LocalDate fromDate, LocalDate toDate, Boolean isCurrent) {
        return salaryStructureService.searchSalaryStructures(employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);
    }

    public List<SalaryStructureDetailDTO> findSalaryDetail() {
        return salaryStructureService.getAllSalaryStructures();


    }

    public SalaryStructureDetailDTO getSalaryStructureByEmployeeType(Long employeeTypeId) {
        return salaryStructureService.getSalaryStructureByEmployeeType(employeeTypeId);
    }
}
