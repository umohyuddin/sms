package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.service.StandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class StandardFacade {

    private final StandardService standardService;
    private final ProvinceService provinceService;
    private final CityService cityService;

    public StandardFacade(StandardService standardService, ProvinceService provinceService, CityService cityService) {
        this.standardService = standardService;
        this.provinceService = provinceService;
        this.cityService = cityService;
    }

    public List<StandardDTO> getAll(Long organizationId) {
        log.info("Facade: Request to fetch all Standards for organization: {}", organizationId);
        List<StandardDTO> result = standardService.getAll(organizationId);
        log.info("Facade: Successfully fetched {} Standards for organization: {}", result.size(), organizationId);
        return result;
    }

    public StandardDTO getById(Long id, Long organizationId) {
        log.info("Facade: Request to fetch Standard by id: {} for organization: {}", id, organizationId);
        StandardDTO standardDTO = standardService.getById(id, organizationId);
        if (standardDTO.getCampus() != null) {
            if (standardDTO.getCampus().getProvinceId() != null) {
                ProvinceResponseDTO provinceResponseDTO = provinceService
                        .getById(standardDTO.getCampus().getProvinceId());
                standardDTO.getCampus().setProvince(provinceResponseDTO);
            }
            if (standardDTO.getCampus().getCityId() != null) {
                CityResponseDTO cityResponseDTO = cityService.getById(standardDTO.getCampus().getCityId());
                standardDTO.getCampus().setCity(cityResponseDTO);
            }
        }
        log.info("Facade: Successfully fetched Standard: id={} for organization: {}", id, organizationId);
        return standardDTO;
    }

    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO, Long organizationId) {
        log.info("Facade: Request to create Standard: {} for organization: {}", standardDTO.getStandardName(),
                organizationId);
        StandardCreateRequestDTO result = standardService.create(standardDTO, organizationId);
        log.info("Facade: Successfully created Standard with id: {} for organization: {}", result.getId(),
                organizationId);
        return result;
    }

    public int softDeleteById(Long standardId, Long organizationId) {
        log.info("Facade: Request to soft delete Standard by id: {} for organization: {}", standardId, organizationId);
        int result = standardService.softDeleteById(standardId, organizationId);
        log.info("Facade: Soft delete result for id {} and organization {}: {}", standardId, organizationId, result);
        return result;
    }

    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto, Long organizationId) {
        log.info("Facade: Request to update Standard id: {} for organization: {}", id, organizationId);
        StandardDTO result = standardService.updateStandard(id, dto, organizationId);
        log.info("Facade: Successfully updated Standard: id={} for organization: {}", result.getId(), organizationId);
        return result;
    }

    public List<StandardDTO> searchByKeyword(String keyword, Long organizationId) {
        log.info("Facade: Request to search Standards by keyword: '{}' for organization: {}", keyword, organizationId);
        List<StandardDTO> result = standardService.searchByKeyword(keyword, organizationId);
        log.info("Facade: Search completed, found {} Standards for organization: {}", result.size(), organizationId);
        return result;
    }

    public List<StandardDTO> getByCampusId(Long id, Long organizationId) {
        log.info("Facade: Request to fetch Standards by campus id: {} for organization: {}", id, organizationId);
        List<StandardDTO> result = standardService.findByCampusId(id, organizationId);
        log.info("Facade: Successfully fetched {} Standards for campus id: {} and organization: {}", result.size(), id,
                organizationId);
        return result;
    }

    public int softDeleteByCampusId(Long campusId, Long organizationId) {
        log.info("Facade: Request to soft delete Standards by campus id: {} for organization: {}", campusId,
                organizationId);
        int result = standardService.sofDeleteByCampusId(campusId, organizationId);
        log.info("Facade: Soft deleted {} Standards for campus id: {} and organization: {}", result, campusId,
                organizationId);
        return result;
    }

    public List<StandardDTO> getStandardsByFilter(Long campusId, String keyword, Long organizationId) {
        log.info("Facade: Request to search Standards with campusId: {}, keyword: '{}' and organization: {}", campusId,
                keyword, organizationId);
        List<StandardDTO> result = standardService.getStandardByFilter(campusId, keyword, organizationId);
        log.info("Facade: Search completed, found {} Standards for organization: {}", result.size(), organizationId);
        return result;
    }
}
