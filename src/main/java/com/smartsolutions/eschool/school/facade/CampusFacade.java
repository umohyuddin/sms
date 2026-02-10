package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import com.smartsolutions.eschool.school.dtos.campuses.metaData.CampusMetaData;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.service.CampusService;

import java.util.List;

import com.smartsolutions.eschool.school.service.InstituteService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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

    public List<CampusResponseDTO> getAll(Long organizationId) {
        return nCampusService.getAll(organizationId);
    }

    public CampusResponseDTO getById(Long id, Long organizationId) {
        return nCampusService.getById(id, organizationId);
    }

    public List<CampusResponseDTO> findByInstituteId(Long id) {
        return nCampusService.findByInstituteId(id);
    }

    public List<CampusResponseDTO> findByCampusNameContaining(String name, Long organizationId) {
        return nCampusService.findByCampusNameContaining(name, organizationId);
    }

    public int softDeleteById(Long sectionId, Long organizationId) {
        return nCampusService.softDeleteById(sectionId, organizationId);
    }

    public CampusCreateRequestDTO createCampus(CampusCreateRequestDTO dto, Long organizationId) {
        return nCampusService.createCampus(dto, organizationId);
    }

    public CampusResponseDTO updateCampus(Long id, @Valid CampusCreateRequestDTO dto, Long organizationId) {
        return nCampusService.updateCampus(id, dto, organizationId);
    }

    public List<CampusResponseDTO> searchByKeyword(String keyword, Long organizationId) {
        return nCampusService.searchByKeyword(keyword, organizationId);
    }

    public Long getCampusCountByInstituteId(Long id) {
        return nCampusService.getCampusCountByInstituteId(id);
    }

    public CampusMetaData getCampusMetaData() {
        InstituteResponseDTO instituteResponseDTO = instituteService.getInstitute();
        List<ProvinceResponseDTO> provinceResponseDTOS = provinceService
                .getByProvinceByCountry(instituteService.getInstitute().getCountryId());
        CampusMetaData metaData = CampusMetaData.builder()
                .institute(instituteResponseDTO)
                .provinces(provinceResponseDTOS)
                .build();
        return metaData;
    }

    //
    // public String create(CampusEntity pCampusEntity) {
    // return nCampusService.create(pCampusEntity);
    // }
    //
    // public String update(CampusEntity pCampusEntity) {
    // return nCampusService.update(pCampusEntity);
    // }
    //
    // public String delete(Long id) {
    // return nCampusService.delete(id);
    // }
}
