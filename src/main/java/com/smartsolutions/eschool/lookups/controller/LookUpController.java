package com.smartsolutions.eschool.lookups.controller;


import com.smartsolutions.eschool.Mocking.CampusServiceMocking;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.employee.facade.EmployeeTypeFacade;
import com.smartsolutions.eschool.global.configs.*;
import com.smartsolutions.eschool.lookups.dtos.DashboardCountsDTO;
import com.smartsolutions.eschool.lookups.dtos.DashboardFinancialDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CityFacade;
import com.smartsolutions.eschool.lookups.facade.CountryFacade;
import com.smartsolutions.eschool.lookups.facade.LookUpFacade;
import com.smartsolutions.eschool.lookups.facade.ProvinceFacade;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.facade.DashboardFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/lookup")
@Slf4j
public class LookUpController {

    private final CampusServiceMocking service;
    private final CountryFacade countryFacade;
    private final ReligionConfig religionConfig;
    private final FeeConfig feeConfig;
    private final BloodGroupConfig bloodGroupConfig;
    private final ProvinceFacade provinceFacade;
    private final CityFacade cityFacade;
    private final NationalityConfig nationalityConfig;
    private final GenderConfig genderConfig;
    private final EmployeeDocumentConfig employeeDocumentConfig;
    private final EmployeeMasterFacade employeeFacade;
    private final LookUpFacade lookUpFacade;
    private final EmployeeTypeFacade employeeTypeFacade;

    public LookUpController(CampusServiceMocking service, CountryFacade countryFacade, ReligionConfig religionConfig, FeeConfig feeConfig, BloodGroupConfig bloodGroupConfig, ProvinceFacade provinceFacade, CityFacade cityFacade, NationalityConfig nationalityConfig, GenderConfig genderConfig, EmployeeDocumentConfig employeeDocumentConfig, EmployeeMasterFacade employeeFacade, DashboardFacade dashboardFacade, LookUpFacade lookUpFacade, EmployeeTypeFacade employeeTypeFacade) {
        this.service = service;
        this.countryFacade = countryFacade;
        this.religionConfig = religionConfig;
        this.feeConfig = feeConfig;
        this.bloodGroupConfig = bloodGroupConfig;
        this.provinceFacade = provinceFacade;
        this.cityFacade = cityFacade;
        this.nationalityConfig = nationalityConfig;
        this.genderConfig = genderConfig;
        this.employeeDocumentConfig = employeeDocumentConfig;
        this.employeeFacade = employeeFacade;
        this.lookUpFacade = lookUpFacade;
        this.employeeTypeFacade = employeeTypeFacade;
    }


    @GetMapping("/dashboard/counts")
    public ResponseEntity<?> getDashboardCounts() {
        log.info("GET /api/lookup/dashboard/counts called");
        DashboardCountsDTO counts = lookUpFacade.DashboardCounts();
        log.info("Dashboard counts fetched successfully: {}", counts);
        return ResponseEntity.ok(counts);
    }

    @GetMapping("/dashboard/financials")
    public ResponseEntity<?> getDashboardFinancials() {
        log.info("GET /api/lookup/dashboard/financials called");
        DashboardFinancialDTO counts = lookUpFacade.DashboardFinancialCounts();
        log.info("Dashboard financials fetched successfully: {}", counts);
        return ResponseEntity.ok(counts);
    }
    // ---------------------- Province Endpoints ----------------------

    @GetMapping(value = "/provinces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProvinces() {
        log.info("GET /api/lookup/provinces called");
        List<ProvinceResponseDTO> resources = provinceFacade.getAll();
        log.info("GET /api/lookup/provinces succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCountries() {
        log.info("GET /api/lookup/Countries called");
        List<CountryResponseDTO> resources = countryFacade.getAll();
        log.info("GET /api/lookup/Countries succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ---------------------- City Endpoints ----------------------

    // Get all active cities
    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCities() {
        log.info("GET /api/lookup/cities called");
        List<CityResponseDTO> resources = cityFacade.getAllActive();
        log.info("GET /api/lookup/cities succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    // Get city by ID
    @GetMapping(value = "/cities/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCityById(@PathVariable Long cityId) {
        log.info("GET /api/lookup/cities/{} called", cityId);
        CityResponseDTO resource = cityFacade.getById(cityId);
        log.info("GET /api/lookup/cities/{} succeeded", cityId);
        return ResponseEntity.ok(resource);
    }

    // Get cities by province ID (for multi-level dropdown)
    @GetMapping(value = "/countries/{countryId}/provinces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCitiesByProvince(@PathVariable Long countryId) {
        log.info("GET /countries/{}/province called", countryId);
        List<ProvinceResponseDTO> resources = provinceFacade.getByProvinceByCountry(countryId);
        log.info("GET /countries/{}/province succeeded, returned {} cities", countryId, resources.size());
        return ResponseEntity.ok(resources);
    }


    @GetMapping(value = "/country/provinces/{provinceId}/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProvinceByCountry(@PathVariable Long provinceId) {
        log.info("GET /api/lookup/provinces/{}/cities called", provinceId);
        List<CityResponseDTO> resources = cityFacade.getByProvince(provinceId);
        log.info("GET /api/lookup/provinces/{}/cities succeeded, returned {} cities", provinceId, resources.size());
        return ResponseEntity.ok(resources);
    }

    // Search cities by keyword
    @GetMapping(value = "/cities/search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchCities(@PathVariable String keyword) {
        log.info("GET /api/lookup/cities/search/{} called", keyword);
        List<CityResponseDTO> resources = cityFacade.searchByKeyword(keyword);
        log.info("GET /api/lookup/cities/search/{} succeeded, returned {} results", keyword, resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/fee-catalog/metadata")
    public Map<String, Map<String, String>> getFeeMeta() {
        return Map.of("chargeTypes", feeConfig.getChargeTypes(), "recurrenceRules", feeConfig.getRecurrenceRules());
    }


    @GetMapping("/docs/metadata")
    public Map<String, Object> getDocsMeta() {
        List<CountryResponseDTO> countriesList = countryFacade.getAll();
        List<EmployeeTypeResponseDTO> employeeTypeResponseDTOS = employeeTypeFacade.getAll();

        Map<String, String> countries = countriesList.stream()
                .collect(Collectors.toMap(
                        item -> String.valueOf(item.getId()),
                        CountryResponseDTO::getCountryName
                ));

        Map<String, String> systemEmployeeType = employeeTypeResponseDTOS.stream()
                .collect(Collectors.toMap(
                        item -> String.valueOf(item.getId()),
                        EmployeeTypeResponseDTO::getName
                ));

        Map<String, Object> result = new HashMap<>();
        result.put("docs", employeeDocumentConfig.getDocumentTypes());
        result.put("addressType", employeeDocumentConfig.getAddressTypes());
        result.put("relationshipType", employeeDocumentConfig.getEmergencyContactRelationships());
        result.put("degree", employeeDocumentConfig.getQualificationDegrees());
        result.put("subjects", employeeDocumentConfig.getQualificationSubjects());
        result.put("gender", genderConfig.getList());
        result.put("maritalStatus", employeeDocumentConfig.getMaritalStatus());
        result.put("bloodGroup", bloodGroupConfig.getGroup());
        result.put("religions", religionConfig.getList());
        result.put("nationalities", nationalityConfig.getMap());
        result.put("countries", countries);
        //need to change this conflicting with employee type
        result.put("employmentType",employeeDocumentConfig.getEmploymentTypes());
        result.put("systemEmployeeType",systemEmployeeType);
        return result;
    }



    @GetMapping("/admission/metadata")
    public Map<String, Map<String, String>> getAdmissionMeta() {
        List<ProvinceResponseDTO> provincesList = provinceFacade.getAll();



        Map<String, String> provinces = provincesList.stream().collect(Collectors.toMap(province -> String.valueOf(province.getId()), // convert Long to String
                ProvinceResponseDTO::getName));

        return Map.of("bloodGroup", bloodGroupConfig.getGroup(),
                "religions", religionConfig.getList(),
                "nationalities", nationalityConfig.getMap(),
                "gender", genderConfig.getList(),
                "provinces", provinces, "docs", employeeDocumentConfig.getDocumentTypes());
    }

    @GetMapping("mocking/{id}")
    public CampusResponseDTO getCampus(@PathVariable String id) {
        return service.getCampus(id);
    }

}

