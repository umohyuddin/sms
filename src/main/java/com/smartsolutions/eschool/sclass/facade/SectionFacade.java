package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.service.SectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class SectionFacade {
    private final SectionService sectionService;

    public SectionFacade(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public List<SectionDTO> getAll() {
        log.info("[Facade:SectionFacade] getAll() called");
        return sectionService.getAll();
    }

    public SectionDTO getById(Long id) {
        log.info("[Facade:SectionFacade] getById() called - id: {}", id);
        return sectionService.getById(id);
    }

    public List<SectionDTO> getByStandardId(Long id) {
        log.info("[Facade:SectionFacade] getByStandardId() called - standardId: {}", id);
        return sectionService.getByStandardId(id);
    }

    public int softDeleteById(Long sectionId) {
        log.info("[Facade:SectionFacade] softDeleteById() called - id: {}", sectionId);
        return sectionService.softDeleteById(sectionId);
    }

    public int softDeleteByStandardId(Long standardId) {
        log.info("[Facade:SectionFacade] softDeleteByStandardId() called - standardId: {}", standardId);
        return sectionService.softDeleteByStandardId(standardId);
    }

    public int softDeleteAll() {
        log.info("[Facade:SectionFacade] softDeleteAll() called");
        return sectionService.softDeleteAll();
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword) {
        log.info("[Facade:SectionFacade] searchSections() called - campusId: {}, standardId: {}, keyword: {}", campusId,
                standardId, keyword);
        return sectionService.searchSections(campusId, standardId, keyword);
    }

    public SectionCreateRequestDTO createSection(SectionCreateRequestDTO dto) {
        log.info("[Facade:SectionFacade] createSection() called");
        return sectionService.createSection(dto);
    }

    public SectionDTO updateSection(Long id, SectionCreateRequestDTO dto) {
        log.info("[Facade:SectionFacade] updateSection() called - id: {}", id);
        return sectionService.updateSection(id, dto);
    }
}
