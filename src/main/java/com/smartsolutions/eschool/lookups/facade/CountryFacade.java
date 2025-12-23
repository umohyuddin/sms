package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.CountryService;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CountryFacade {

    private final CountryService countryService;

    public CountryFacade(CountryService countryService) {
        this.countryService = countryService;
    }


    public List<CountryResponseDTO> getAll() {
        return countryService.getAll();
    }


}
