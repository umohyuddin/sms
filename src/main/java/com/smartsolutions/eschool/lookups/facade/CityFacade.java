package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CityFacade {


    private final CityService cityService;

    public CityFacade(CityService cityService) {
        this.cityService = cityService;
    }

    // Create or update city
    public CityResponseDTO createCity(@Valid CityRequestDTO requestDTO) {
        return cityService.createCity(requestDTO);
    }

    // Get all active cities
    public List<CityResponseDTO> getAllActive() {
        return cityService.getAllActive();
    }

    // Get city by ID
    public CityResponseDTO getById(Long cityId) {
        return cityService.getById(cityId);
    }

    // Search cities by keyword
    public List<CityResponseDTO> searchByKeyword(String keyword) {
        return cityService.searchByKeyword(keyword);
    }

    // Get cities by province
    public List<CityResponseDTO> getByProvince(Long provinceId) {
        return cityService.getByProvince(provinceId);
    }

    // Soft delete city by ID
    public int softDeleteById(Long cityId) {
        return cityService.softDeleteById(cityId);
    }

    // Activate / Deactivate city
    public int setActiveStatus(Long cityId, boolean status) {
        return cityService.setActiveStatus(cityId, status);
    }
}
