package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.service.StandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
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

    public List<StandardDTO> getAll() {
        log.info("Facade: Request to fetch all Standards");
        List<StandardDTO> result = standardService.getAll();
        log.info("Facade: Successfully fetched {} Standards", result.size());
        return result;
    }

    public StandardDTO getById(Long id) {
        log.info("Facade: Request to fetch Standard by id: {}", id);
        StandardDTO standardDTO = standardService.getById(id);
        if (standardDTO.getCampus() != null) {
            if (standardDTO.getCampus().getProvinceId() != null) {
                ProvinceResponseDTO provinceResponseDTO = provinceService.getById(standardDTO.getCampus().getProvinceId());
                standardDTO.getCampus().setProvince(provinceResponseDTO);
            }
            if (standardDTO.getCampus().getCityId() != null) {
                CityResponseDTO cityResponseDTO = cityService.getById(standardDTO.getCampus().getCityId());
                standardDTO.getCampus().setCity(cityResponseDTO);
            }
        }
        log.info("Facade: Successfully fetched Standard: id={}", id);
        return standardDTO;
    }

    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO) {
        log.info("Facade: Request to create Standard: {}", standardDTO.getStandardName());
        StandardCreateRequestDTO result = standardService.create(standardDTO);
        log.info("Facade: Successfully created Standard with id: {}", result.getId());
        return result;
    }

    public int softDeleteById(Long standardId) {
        log.info("Facade: Request to soft delete Standard by id: {}", standardId);
        int result = standardService.softDeleteById(standardId);
        log.info("Facade: Soft delete result for id {}: {}", standardId, result);
        return result;
    }

    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto) {
        log.info("Facade: Request to update Standard id: {}", id);
        StandardDTO result = standardService.updateStandard(id, dto);
        log.info("Facade: Successfully updated Standard: id={}", result.getId());
        return result;
    }

    public List<StandardDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Standards by keyword: '{}'", keyword);
        List<StandardDTO> result = standardService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Standards", result.size());
        return result;
    }

    public List<StandardDTO> getByCampusId(Long id) {
        log.info("Facade: Request to fetch Standards by campus id: {}", id);
        List<StandardDTO> result = standardService.findByCampusId(id);
        log.info("Facade: Successfully fetched {} Standards for campus id: {}", result.size(), id);
        return result;
    }

    public int softDeleteByCampusId(Long campusId) {
        log.info("Facade: Request to soft delete Standards by campus id: {}", campusId);
        int result = standardService.sofDeleteByCampusId(campusId);
        log.info("Facade: Soft deleted {} Standards for campus id: {}", result, campusId);
        return result;
    }

    public List<StandardDTO> getStandardsByFilter(Long campusId, String keyword) {
        log.info("Facade: Request to search Standards with campusId: {} and keyword: '{}'", campusId, keyword);
        List<StandardDTO> result = standardService.getStandardByFilter(campusId, keyword);
        log.info("Facade: Search completed, found {} Standards", result.size());
        return result;
    }
}
