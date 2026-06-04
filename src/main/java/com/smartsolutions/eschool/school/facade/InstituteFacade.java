package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Slf4j
public class InstituteFacade {
    private final InstituteService instituteService;
    private final CampusFacade campusFacade;
    private final com.smartsolutions.eschool.lookups.service.CountryService countryService;
    private final com.smartsolutions.eschool.lookups.service.ProvinceService provinceService;
    private final com.smartsolutions.eschool.lookups.service.CityService cityService;

    public InstituteFacade(InstituteService instituteService, CampusFacade campusFacade,
                          com.smartsolutions.eschool.lookups.service.CountryService countryService,
                          com.smartsolutions.eschool.lookups.service.ProvinceService provinceService,
                          com.smartsolutions.eschool.lookups.service.CityService cityService) {
        this.instituteService = instituteService;
        this.campusFacade = campusFacade;
        this.countryService = countryService;
        this.provinceService = provinceService;
        this.cityService = cityService;
    }

    public InstituteResponseDTO getInstitute() {
        log.info("[Facade:InstituteFacade] getInstitute() called");
        InstituteResponseDTO responseDTO = instituteService.getInstitute();
        if (responseDTO != null) {
            responseDTO.setCampusCount(campusFacade.getCampusCountByInstituteId(responseDTO.getId()));
        }
        return responseDTO;
    }

    public InstituteResponseDTO getById(Long id) {
        log.info("[Facade:InstituteFacade] getById() called - id: {}", id);
        InstituteResponseDTO responseDTO = instituteService.getById(id);
        if (responseDTO != null) {
            responseDTO.setCampusCount(campusFacade.getCampusCountByInstituteId(responseDTO.getId()));
        }
        return responseDTO;
    }

    public InstituteResponseDTO updateInstitute(InstituteRequestDTO instituteRequestDTO) {
        log.info("[Facade:InstituteFacade] updateInstitute() called");
        InstituteResponseDTO responseDTO = instituteService.updateInstitute(instituteRequestDTO);
        if (responseDTO != null) {
            responseDTO.setCampusCount(campusFacade.getCampusCountByInstituteId(responseDTO.getId()));
        }
        return responseDTO;
    }

    public java.util.Map<String, Long> getStatistics() {
        log.info("[Facade:InstituteFacade] getStatistics() called");
        return instituteService.getStatistics();
    }

    public com.smartsolutions.eschool.school.dtos.institute.metaData.InstituteMetaData getInstituteMetaData() {
        log.info("[Facade:InstituteFacade] getInstituteMetaData() called");
        return com.smartsolutions.eschool.school.dtos.institute.metaData.InstituteMetaData.builder()
                .countries(countryService.getAll())
                .provinces(provinceService.getAll())
                .cities(cityService.getAll())
                .build();
    }
}
