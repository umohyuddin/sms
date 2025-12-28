package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.lookups.repository.CityRepository;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteDao;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
public class InstituteService {

    private final InstituteRepository instituteRepository;
    private final CountryRepository countryRepository;

    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;

    public InstituteService(InstituteRepository instituteRepository, CountryRepository countryRepository, ProvinceRepository provinceRepository, CityRepository cityRepository) {
        this.instituteRepository = instituteRepository;
        this.countryRepository = countryRepository;
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
    }

    // Fetch the institute
    public InstituteResponseDTO getInstitute() {
        InstituteEntity instituteEntity = instituteRepository.getSingletonInstitute().orElse(null);
        if (instituteEntity == null) {
            return null; // no record found
        }
        return MapperUtil.mapObject(instituteEntity, InstituteResponseDTO.class);
    }

    @Transactional
    public InstituteResponseDTO updateInstitute(InstituteRequestDTO dto) {
        InstituteEntity institute = instituteRepository.getSingletonInstitute().orElseGet(InstituteEntity::new); // create new if none exists

        // Set/update basic fields

        institute.setName(dto.getName());
        institute.setAddress(dto.getAddress());
        institute.setContactNumber(dto.getContactNumber());
        institute.setEmail(dto.getEmail());
        institute.setWebsite(dto.getWebsite());
        institute.setTagLine(dto.getTagLine());
        institute.setLogo(dto.getLogo());

        // Only set establishedDate if this is a new record
        if (institute.getId() == null) {
            // New record: use date from DTO if provided, else current date
            institute.setEstablishedDate(dto.getEstablishedDate() != null ? dto.getEstablishedDate() : LocalDate.now());
        } else {
            // Existing record: keep current date, or fallback to now if somehow null
            if (institute.getEstablishedDate() == null) {
                institute.setEstablishedDate(LocalDate.now());
            }
        }

        // Optional: assign relations if IDs are provided
        if (dto.getCountryId() != null) {
            institute.setCountry(countryRepository.findById(dto.getCountryId()).orElseThrow(() -> new IllegalArgumentException("Invalid country ID")));
        }
        if (dto.getProvinceId() != null) {
            institute.setProvince(provinceRepository.findById(dto.getProvinceId()).orElseThrow(() -> new IllegalArgumentException("Invalid province ID")));
        }
        if (dto.getCityId() != null) {
            institute.setCity(cityRepository.findById(dto.getCityId()).orElseThrow(() -> new IllegalArgumentException("Invalid city ID")));
        }

        institute.setId(1L);
        // Save and return
        return MapperUtil.mapObject(instituteRepository.save(institute), InstituteResponseDTO.class);
    }
}