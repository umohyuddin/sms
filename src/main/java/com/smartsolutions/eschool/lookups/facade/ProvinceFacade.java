package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.employee.service.EmployeeService;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ProvinceFacade {

    private final ProvinceService provinceService;

    public ProvinceFacade(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    public ProvinceResponseDTO createProvince(@Valid ProvinceRequestDTO requestDTO) {
        return provinceService.createProvince(requestDTO);
    }

    public List<ProvinceResponseDTO> getAll() {
        return provinceService.getAll();
    }

    public ProvinceResponseDTO getById(Long provinceId) {
        return provinceService.getById(provinceId);
    }

    public List<ProvinceResponseDTO> getAllActive() {
        return provinceService.getAllActive();
    }

//    public List<ProvinceResponseDTO> getAllInActive() {
//        return provinceService.getAllInActive();
//    }

    public int softDeleteById(Long provinceId) {
        return provinceService.softDeleteById(provinceId);
    }

    public List<ProvinceResponseDTO> searchByKeyword(String keyword) {
        return provinceService.searchByKeyword(keyword);
    }
}
