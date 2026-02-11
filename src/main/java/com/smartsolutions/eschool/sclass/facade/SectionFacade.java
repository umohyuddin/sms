package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.service.SectionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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

    public List<SectionDTO> getAll(Long organizationId) {
        log.info("Facade: Request to fetch all sections for organization: {}", organizationId);
        List<SectionDTO> result = nSectionService.getAll(organizationId);
        log.info("Facade: Successfully fetched {} sections for organization: {}", result.size(), organizationId);
        return result;
    }

    public SectionDTO getById(Long id, Long organizationId) {
        log.info("Facade: Request to fetch section by id: {} for organization: {}", id, organizationId);
        SectionDTO result = nSectionService.getById(id, organizationId);
        log.info("Facade: Successfully fetched section: id={} for organization: {}", id, organizationId);
        return result;
    }

    public List<SectionDTO> getByStandardId(Long id, Long organizationId) {
        log.info("Facade: Request to fetch sections by standard id: {} for organization: {}", id, organizationId);
        List<SectionDTO> result = nSectionService.getByStandardId(id, organizationId);
        log.info("Facade: Successfully fetched {} sections for standard id: {} and organization: {}", result.size(), id,
                organizationId);
        return result;
    }

    public int softDeleteById(Long sectionId, Long organizationId) {
        log.info("Facade: Request to delete section by id: {} for organization: {}", sectionId, organizationId);
        int result = nSectionService.softDeleteById(sectionId, organizationId);
        log.info("Facade: Delete result for id {} and organization {}: {}", sectionId, organizationId, result);
        return result;
    }

    public int softDeleteByStandardId(Long standardId, Long organizationId) {
        log.info("Facade: Request to delete sections for standard id: {} and organization: {}", standardId,
                organizationId);
        int result = nSectionService.softDeleteByStandardId(standardId, organizationId);
        log.info("Facade: Delete result for standard id {} and organization {}: {}", standardId, organizationId,
                result);
        return result;
    }

    public int softDeleteAll(Long organizationId) {
        log.info("Facade: Request to delete all sections for organization: {}", organizationId);
        int result = nSectionService.softDeleteAll(organizationId);
        log.info("Facade: Delete result for all sections for organization {}: {}", organizationId, result);
        return result;
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword, Long organizationId) {
        log.info("Facade: Request to search sections with campusId={}, standardId={}, keyword='{}' and organization={}",
                campusId, standardId, keyword, organizationId);
        List<SectionDTO> result = nSectionService.searchSections(campusId, standardId, keyword, organizationId);
        log.info("Facade: Search completed, found {} sections for organization: {}", result.size(), organizationId);
        return result;
    }

    public SectionCreateRequestDTO createSection(@Valid SectionCreateRequestDTO dto, Long organizationId) {
        log.info("Facade: Request to create section: {} for organization: {}", dto.getSectionName(), organizationId);
        SectionCreateRequestDTO result = nSectionService.createSection(dto, organizationId);
        log.info("Facade: Successfully created section with id: {} for organization: {}", result.getId(),
                organizationId);
        return result;
    }

    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto, Long organizationId) {
        log.info("Facade: Request to update section id: {} for organization: {}", id, organizationId);
        SectionDTO result = nSectionService.updateSection(id, dto, organizationId);
        log.info("Facade: Successfully updated section: id={} for organization: {}", result.getId(), organizationId);
        return result;
    }

    // public List<SectionEntity> getByInstituteId(Long id) {
    // return nSectionService.getByInstituteId(id);
    // }
    //
    // public List<SectionEntity> getByCampusId(Long id) {
    // return nSectionService.getByCampusId(id);
    // }
    //
    // public List<SectionEntity> getByClassId(Long id) {
    // return nSectionService.getByClassId(id);
    // }
    //
    // public String create(SectionEntity pSectionEntity) {
    // return nSectionService.create(pSectionEntity);
    // }
    //
    // public String update(SectionEntity pSectionEntity) {
    // return nSectionService.update(pSectionEntity);
    // }
    //
    // public String delete(Long id) {
    // return nSectionService.delete(id);
    // }
}
