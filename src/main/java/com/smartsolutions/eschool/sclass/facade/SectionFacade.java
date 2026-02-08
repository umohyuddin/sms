package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.service.SectionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SectionFacade {
    private final SectionService nSectionService;

    public SectionFacade(SectionService nSectionService) {
        this.nSectionService = nSectionService;
    }

    public List<SectionDTO> getAll() {
        log.info("Facade: Request to fetch all sections");
        List<SectionDTO> result = nSectionService.getAll();
        log.info("Facade: Successfully fetched {} sections", result.size());
        return result;
    }

    public SectionDTO getById(Long id) {
        log.info("Facade: Request to fetch section by id: {}", id);
        SectionDTO result = nSectionService.getById(id);
        log.info("Facade: Successfully fetched section: id={}", id);
        return result;
    }

    public List<SectionDTO> getByStandardId(Long id) {
        log.info("Facade: Request to fetch sections by standard id: {}", id);
        List<SectionDTO> result = nSectionService.getByStandardId(id);
        log.info("Facade: Successfully fetched {} sections for standard id: {}", result.size(), id);
        return result;
    }

    public int softDeleteById(Long sectionId){
        log.info("Facade: Request to delete section by id: {}", sectionId);
        int result = nSectionService.softDeleteById(sectionId);
        log.info("Facade: Delete result for id {}: {}", sectionId, result);
        return result;
    }
    public int softDeleteByStandardId(Long standardId){
        log.info("Facade: Request to delete sections for standard id: {}", standardId);
        int result = nSectionService.softDeleteByStandardId(standardId);
        log.info("Facade: Delete result for standard id {}: {}", standardId, result);
        return result;
    }
    public int softDeleteAll(){
        log.info("Facade: Request to delete all sections");
        int result = nSectionService.softDeleteAll();
        log.info("Facade: Delete result for all sections: {}", result);
        return result;
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword) {
        log.info("Facade: Request to search sections with campusId={}, standardId={}, keyword='{}'", campusId, standardId, keyword);
        List<SectionDTO> result = nSectionService.searchSections(campusId,standardId,keyword);
        log.info("Facade: Search completed, found {} sections", result.size());
        return result;
    }

    public SectionCreateRequestDTO createSection(@Valid SectionCreateRequestDTO dto) {
        log.info("Facade: Request to create section: {}", dto.getSectionName());
        SectionCreateRequestDTO result = nSectionService.createSection(dto);
        log.info("Facade: Successfully created section with id: {}", result.getId());
        return result;
    }

    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto) {
        log.info("Facade: Request to update section id: {}", id);
        SectionDTO result = nSectionService.updateSection(id,dto);
        log.info("Facade: Successfully updated section: id={}", result.getId());
        return result;
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
