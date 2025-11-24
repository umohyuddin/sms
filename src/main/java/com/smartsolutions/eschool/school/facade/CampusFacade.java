package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.CampusDTO;
import com.smartsolutions.eschool.school.dtos.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.service.CampusService;

import java.util.List;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CampusFacade {

    @Autowired
    @Lazy
    private CampusService nCampusService;

    public List<CampusDTO> getAll() {
        return nCampusService.getAll();
    }

    public CampusDTO getById(Long id) {
        return nCampusService.getById(id);
    }

    public List<CampusDTO> findByInstituteId(Long id) {
        return nCampusService.findByInstituteId(id);
    }
    public List<CampusDTO> findByCampusNameContaining(String name) {
        return nCampusService.findByCampusNameContaining(name);
    }
    public int softDeleteById(Long sectionId){
        return nCampusService.softDeleteById(sectionId);
    }

    public CampusCreateRequestDTO createCampus(CampusCreateRequestDTO dto) {
    return nCampusService.createCampus(dto);
    }

    public CampusDTO updateStandard(Long id, @Valid CampusCreateRequestDTO dto) {
        return nCampusService.updateSection(id,dto);
    }

//
//    public String create(CampusEntity pCampusEntity) {
//        return nCampusService.create(pCampusEntity);
//    }
//
//    public String update(CampusEntity pCampusEntity) {
//        return nCampusService.update(pCampusEntity);
//    }
//
//    public String delete(Long id) {
//        return nCampusService.delete(id);
//    }
}
