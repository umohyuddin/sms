package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import com.smartsolutions.eschool.school.dtos.campuses.metaData.CampusMetaData;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.service.CampusService;
import com.smartsolutions.eschool.school.service.InstituteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class CampusFacade {

    private final CampusService nCampusService;
    private final InstituteService instituteService;
    private final ProvinceService provinceService;

    public CampusFacade(CampusService nCampusService, InstituteService instituteService,
            ProvinceService provinceService) {
        this.nCampusService = nCampusService;
        this.instituteService = instituteService;
        this.provinceService = provinceService;
    }

    public List<CampusResponseDTO> getAll() {
        log.info("[Facade:CampusFacade] getAll() called");
        return nCampusService.getAll();
    }

    public CampusResponseDTO getById(Long id) {
        log.info("[Facade:CampusFacade] getById() called - id: {}", id);
        return nCampusService.getById(id);
    }

    public List<CampusResponseDTO> findByInstituteId(Long id) {
        log.info("[Facade:CampusFacade] findByInstituteId() called - institute: {}", id);
        return nCampusService.findByInstituteId(id);
    }

    public List<CampusResponseDTO> findByCampusNameContaining(String name) {
        log.info("[Facade:CampusFacade] findByCampusNameContaining() called - name: {}", name);
        return nCampusService.findByCampusNameContaining(name);
    }

    public void softDeleteById(Long campusId) {
        log.info("[Facade:CampusFacade] softDeleteById() called - id: {}", campusId);
        nCampusService.softDeleteById(campusId);
    }

    public CampusResponseDTO createCampus(CampusCreateRequestDTO dto) {
        log.info("[Facade:CampusFacade] createCampus() called");
        return nCampusService.createCampus(dto);
    }

    public CampusResponseDTO updateCampus(Long id, CampusCreateRequestDTO dto) {
        log.info("[Facade:CampusFacade] updateCampus() called - id: {}", id);
        return nCampusService.updateCampus(id, dto);
    }

    public List<CampusResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:CampusFacade] searchByKeyword() called - keyword: {}", keyword);
        return nCampusService.searchByKeyword(keyword);
    }

    public Long getCampusCountByInstituteId(Long id) {
        log.info("[Facade:CampusFacade] getCampusCountByInstituteId() called - institute: {}", id);
        return nCampusService.getCampusCountByInstituteId(id);
    }

    public CampusMetaData getCampusMetaData() {
        log.info("[Facade:CampusFacade] getCampusMetaData() called");
        InstituteResponseDTO instituteResponseDTO = instituteService.getInstitute();

        List<ProvinceResponseDTO> provinceResponseDTOS = java.util.Collections.emptyList();
        if (instituteResponseDTO != null && instituteResponseDTO.getCountryId() != null) {
            provinceResponseDTOS = provinceService.getByCountryId(instituteResponseDTO.getCountryId());
        }

        return CampusMetaData.builder()
                .institute(instituteResponseDTO)
                .provinces(provinceResponseDTOS)
                .build();
    }

    public java.util.Map<String, Long> getStatistics() {
        log.info("[Facade:CampusFacade] getStatistics() called");
        return nCampusService.getStatistics();
    }
}
