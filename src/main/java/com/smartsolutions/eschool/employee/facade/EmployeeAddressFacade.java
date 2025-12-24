package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeAddressRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.service.EmployeeAddressService;
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
public class EmployeeAddressFacade {

    private final EmployeeAddressService employeeAddressService;

    public EmployeeAddressFacade(EmployeeAddressService employeeAddressService) {
        this.employeeAddressService = employeeAddressService;
    }

    public List<EmployeeAddressResponseDto> getEmployeeAddresses(Long employeeId) {
        return employeeAddressService.getByEmployeeId(employeeId);
    }

    public EmployeeAddressResponseDto getAddressById(Long addressId) {
        return employeeAddressService.getById(addressId);
    }

    public EmployeeAddressResponseDto createAddress(EmployeeAddressRequestDto requestDto) {
        return employeeAddressService.create(requestDto);
    }


    public EmployeeAddressResponseDto updateAddress(Long addressId, EmployeeAddressRequestDto requestDto) {
        return employeeAddressService.update(addressId, requestDto);
    }
}

