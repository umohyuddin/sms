package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeAddressRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.model.EmployeeAddressEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeAddressRepository;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.lookups.repository.CityRepository;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class EmployeeAddressService {
    private final EmployeeAddressRepository employeeAddressRepository;
    private final CountryRepository countryRepository;
    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;
    private final EmployeeMasterRepository employeeMasterRepository;

    public EmployeeAddressService(EmployeeAddressRepository employeeRepository, CountryRepository countryRepository, ProvinceRepository provinceRepository, CityRepository cityRepository, EmployeeMasterRepository employeeMasterRepository) {
        this.employeeAddressRepository = employeeRepository;
        this.countryRepository = countryRepository;
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
        this.employeeMasterRepository = employeeMasterRepository;
    }

    public List<EmployeeAddressResponseDto> getByEmployeeId(Long employeeId) {
        try {
            log.info("Fetching addresses for employeeId={}", employeeId);
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            List<EmployeeAddressEntity> addresses = employeeAddressRepository.findEmployeeAddressesAndOrganizationId(employeeId, orgId);
            return MapperUtil.mapList(addresses, EmployeeAddressResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching addresses for employeeId={}", employeeId, e);
        }
        return Collections.emptyList();
    }

    public EmployeeAddressResponseDto getById(Long addressId) {
        try {
            log.info("Fetching address with id={}", addressId);
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            EmployeeAddressEntity address = employeeAddressRepository.findByAddressIdAndOrganizationId(addressId, orgId)
                    .orElseThrow(() -> new NoSuchElementException("Address not found with id: " + addressId));
            return MapperUtil.mapObject(address, EmployeeAddressResponseDto.class);
        } catch (Exception e) {
            log.error("Error fetching address with id={}", addressId, e);
            return null;
        }
    }

    public EmployeeAddressResponseDto create(EmployeeAddressRequestDto dto) {
        try {
            log.info("Creating address for employeeId={}", dto.getEmployeeId());

            EmployeeAddressEntity entity = new EmployeeAddressEntity();

            // Set basic fields
            entity.setAddressType(dto.getAddressType());
            entity.setLine1(dto.getLine1());
            entity.setLine2(dto.getLine2());
            entity.setPostalCode(dto.getPostalCode());

            // Set relations
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
            entity.setEmployee(employeeMasterRepository.findByIdAndOrganizationId(dto.getEmployeeId(), orgId)
                    .orElseThrow(() -> new NoSuchElementException("Employee not found")));
            entity.setCountry(countryRepository.findById(dto.getCountryId())
                    .orElseThrow(() -> new NoSuchElementException("Country not found")));
            if (dto.getProvinceId() != null) {
                entity.setProvince(provinceRepository.findById(dto.getProvinceId())
                        .orElseThrow(() -> new NoSuchElementException("Province not found")));
            }
            entity.setCity(cityRepository.findById(dto.getCityId())
                    .orElseThrow(() -> new NoSuchElementException("City not found")));

            // Save
            EmployeeAddressEntity saved = employeeAddressRepository.save(entity);

            return MapperUtil.mapObject(saved, EmployeeAddressResponseDto.class);
        } catch (Exception e) {
            log.error("Error creating address", e);
            return null;
        }
    }

    @Transactional
    public EmployeeAddressResponseDto update(Long addressId, EmployeeAddressRequestDto dto) {
        try {
            log.info("Updating address with id={}", addressId);
            Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();

            EmployeeAddressEntity entity = employeeAddressRepository.findByAddressIdAndOrganizationId(addressId, orgId)
                    .orElseThrow(() -> new NoSuchElementException("Address not found"));

            // Update basic fields
            entity.setAddressType(dto.getAddressType());
            entity.setLine1(dto.getLine1());
            entity.setLine2(dto.getLine2());
            entity.setPostalCode(dto.getPostalCode());

            // Update relations
            if (dto.getCountryId() != null) {
                entity.setCountry(countryRepository.findById(dto.getCountryId())
                        .orElseThrow(() -> new NoSuchElementException("Country not found")));
            }
            if (dto.getProvinceId() != null) {
                entity.setProvince(provinceRepository.findById(dto.getProvinceId())
                        .orElseThrow(() -> new NoSuchElementException("Province not found")));
            }
            if (dto.getCityId() != null) {
                entity.setCity(cityRepository.findById(dto.getCityId())
                        .orElseThrow(() -> new NoSuchElementException("City not found")));
            }

            // Save
            EmployeeAddressEntity updated = employeeAddressRepository.save(entity);
            EmployeeAddressResponseDto responseDto = new EmployeeAddressResponseDto();
            responseDto.setId(updated.getId());
            responseDto.setAddressType(updated.getAddressType());
            responseDto.setLine1(updated.getLine1());
            responseDto.setLine2(updated.getLine2());
            responseDto.setPostalCode(updated.getPostalCode());
            responseDto.setCountryId(updated.getCountry() != null ? updated.getCountry().getId() : null);
            responseDto.setProvinceId(updated.getProvince() != null ? updated.getProvince().getId() : null);
            responseDto.setCityId(updated.getCity() != null ? updated.getCity().getId() : null); // null-safe
            responseDto.setCountryName(updated.getCountry() != null ? updated.getCountry().getCountryName() : null);
            responseDto.setProvinceName(updated.getProvince() != null ? updated.getProvince().getName() : null);
            responseDto.setCityName(updated.getCity() != null ? updated.getCity().getName() : null); // null-safe
            return responseDto;
        } catch (Exception e) {
            log.error("Error updating address with id={}", addressId, e);
            return null;
        }
    }
}

