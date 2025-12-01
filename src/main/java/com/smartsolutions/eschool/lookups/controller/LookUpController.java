package com.smartsolutions.eschool.lookups.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.facade.EmployeeFacade;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CityFacade;
import com.smartsolutions.eschool.lookups.facade.ProvinceFacade;
import com.smartsolutions.eschool.lookups.service.CityService;
import com.smartsolutions.eschool.school.facade.DiscountTypeFacade;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/lookup")
@Slf4j
public class LookUpController {


    private final ProvinceFacade provinceFacade;
    private final CityFacade cityFacade;

    public LookUpController(ProvinceFacade provinceFacade, CityFacade cityFacade) {
        this.provinceFacade = provinceFacade;
        this.cityFacade = cityFacade;
    }

    // ---------------------- Province Endpoints ----------------------

    @GetMapping(value = "/provinces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProvinces() {
        log.info("GET /api/lookup/provinces called");
        List<ProvinceResponseDTO> resources = provinceFacade.getAll();
        log.info("GET /api/lookup/provinces succeeded, returned {} resources", resources.size());
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
    @GetMapping(value = "/provinces/{provinceId}/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCitiesByProvince(@PathVariable Long provinceId) {
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
}
