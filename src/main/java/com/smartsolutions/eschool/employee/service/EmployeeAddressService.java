package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.model.EmployeeAddressEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeAddressRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class EmployeeAddressService {
    private final EmployeeAddressRepository employeeAddressRepository;

    public EmployeeAddressService(EmployeeAddressRepository employeeRepository) {
        this.employeeAddressRepository = employeeRepository;
    }

    public List<EmployeeAddressResponseDto> getByEmployeeId(Long employeeId) {
        try {
            log.info("Fetching addresses for employeeId={}", employeeId);
            List<EmployeeAddressEntity> addresses = employeeAddressRepository.findByEmployeeId(employeeId);
            return MapperUtil.mapList(addresses, EmployeeAddressResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching addresses for employeeId={}", employeeId, e);
        }
        return Collections.emptyList();
    }

    public EmployeeAddressResponseDto getById(Long addressId) {
        try {
            log.info("Fetching address with id={}", addressId);
            EmployeeAddressEntity address = employeeAddressRepository.findById(addressId).orElseThrow(() -> new NoSuchElementException("Address not found with id: " + addressId));
            return MapperUtil.mapObject(address, EmployeeAddressResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching address with id={}", addressId, e);
            return null;
        }
    }
}

