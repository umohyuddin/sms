
package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.request.EmployeeSalaryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryFullResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryResponseDTO;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.employee.service.EmployeeMasterSalaryService;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import com.smartsolutions.eschool.global.enums.SalaryStatus;
import com.smartsolutions.eschool.school.service.DepartmentService;
import com.smartsolutions.eschool.school.service.DesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
@Scope("prototype")
@RequiredArgsConstructor
public class EmployeeMasterSalaryFacade {

    private final EmployeeMasterSalaryService salaryService;
    private final EmployeeMasterService employeeMasterService;
    private final DesignationService designationService;
    private final DepartmentService departmentService;

//    public EmployeeMasterSalaryFacade(EmployeeMasterSalaryService salaryService) {
//        this.salaryService = salaryService;
//    }

    /* =========================
       CREATE / UPDATE
       ========================= */
    public EmployeeSalaryResponseDTO createSalary(EmployeeSalaryRequestDTO requestDTO) {
        return salaryService.createSalary(requestDTO);
    }

    public EmployeeSalaryResponseDTO updateSalary(Long id, EmployeeSalaryRequestDTO requestDTO) {
        return salaryService.updateSalary(id, requestDTO);
    }

    /* =========================
       GET / FETCH
       ========================= */
    public EmployeeSalaryResponseDTO getSalaryById(Long id) {
        return salaryService.getSalaryById(id);
    }

    public List<EmployeeSalaryResponseDTO> getAllSalariesForEmployee(Long employeeId) {
        return salaryService.getAllSalariesForEmployee(employeeId);
    }

    public List<EmployeeSalaryFullResponseDTO> getEmployeeSalaryList() {
        return salaryService.getEmployeeSalaryList();
    }
//    public List<EmployeeSalaryResponseDTO> getSalariesByStatus(SalaryStatus status) {
//        return salaryService.getSalariesByStatus(status);
//    }

//    public Optional<EmployeeSalaryResponseDTO> getSalaryByEmployeeAndMonth(Long employeeId, Integer year, Integer month) {
//        return salaryService.getSalaryByEmployeeAndMonth(employeeId, year, month);
//    }

    /* =========================
       SOFT DELETE
       ========================= */
    public void softDeleteSalary(Long id) {
        salaryService.softDeleteSalary(id);
    }

    public EmployeeSalaryFullResponseDTO getSalaryDetail(Long employeeId) {
        return salaryService.getEmployeeSalaryDetail(employeeId);
    }
}
