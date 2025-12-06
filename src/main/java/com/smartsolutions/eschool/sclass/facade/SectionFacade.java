package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.service.SectionService;
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
public class SectionFacade {
    private static final Log LOG = LogFactory.getLog(SectionFacade.class);
    @Autowired
    @Lazy
    private SectionService nSectionService;

    public List<SectionDTO> getAll() {
        return nSectionService.getAll();
    }

    public SectionDTO getById(Long id) {
        return nSectionService.getById(id);
    }

    public List<SectionDTO> getByStandardId(Long id) {
        return nSectionService.getByStandardId(id);
    }

    public int softDeleteById(Long sectionId){
        return nSectionService.softDeleteById(sectionId);
    }
    public int softDeleteByStandardId(Long sectionId){
       return nSectionService.softDeleteByStandardId(sectionId);
    }
    public int softDeleteAll(){
        return nSectionService.softDeleteAll();
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword) {
        return nSectionService.searchSections(campusId,standardId,keyword);
    }

    public SectionCreateRequestDTO createSection(@Valid SectionCreateRequestDTO dto) {
       return nSectionService.createSection(dto);
    }

    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto) {
    return nSectionService.updateSection(id,dto);
    }


//    public List<SectionEntity> getByInstituteId(Long id) {
//        return nSectionService.getByInstituteId(id);
//    }
//
//    public List<SectionEntity> getByCampusId(Long id) {
//        return nSectionService.getByCampusId(id);
//    }
//
//    public List<SectionEntity> getByClassId(Long id) {
//        return nSectionService.getByClassId(id);
//    }
//
//    public String create(SectionEntity pSectionEntity) {
//        return nSectionService.create(pSectionEntity);
//    }
//
//    public String update(SectionEntity pSectionEntity) {
//        return nSectionService.update(pSectionEntity);
//    }
//
//    public String delete(Long id) {
//        return nSectionService.delete(id);
//    }
}
