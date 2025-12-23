package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    // ----------------------------------------
    // GET ALL
    // ----------------------------------------
    public List<CountryResponseDTO> getAll() {
        try {
            log.info("Fetching all countries");
            List<CountryEntity> result = countryRepository.findAllCountries();
            return MapperUtil.mapList(result, CountryResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching countries", dae);
            throw new CustomServiceException("Unable to fetch countries", dae);
        } catch (MappingException me) {
            log.error("Error mapping CountryEntity to CountryResponseDTO", me);
            throw new CustomServiceException("Error converting country data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching countries", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }
}
