package com.smartsolutions.eschool.sclass.facade;

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

    public StandardFacade(StandardService standardService) {
        this.standardService = standardService;
    }

    public List<StandardDTO> getAll() {
        log.info("[Facade:StandardFacade] getAll() called");
        return standardService.getAll();
    }

    public StandardDTO getById(Long id) {
        log.info("[Facade:StandardFacade] getById() called - id: {}", id);
        StandardDTO standardDTO = standardService.getById(id);
        log.info("[Facade:StandardFacade] getById() succeeded - id: {}", id);
        return standardDTO;
    }

    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO) {
        log.info("[Facade:StandardFacade] create() called");
        return standardService.create(standardDTO);
    }

    public int softDeleteById(Long standardId) {
        log.info("[Facade:StandardFacade] softDeleteById() called - id: {}", standardId);
        return standardService.softDeleteById(standardId);
    }

    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto) {
        log.info("[Facade:StandardFacade] updateStandard() called - id: {}", id);
        return standardService.updateStandard(id, dto);
    }

    public List<StandardDTO> searchByKeyword(String keyword) {
        log.info("[Facade:StandardFacade] searchByKeyword() called - keyword: {}", keyword);
        return standardService.searchByKeyword(keyword);
    }

    public List<StandardDTO> getByCampusId(Long id) {
        log.info("[Facade:StandardFacade] getByCampusId() called - campus id: {}", id);
        return standardService.findByCampusId(id);
    }

    public int softDeleteByCampusId(Long campusId) {
        log.info("[Facade:StandardFacade] softDeleteByCampusId() called - campus id: {}", campusId);
        return standardService.sofDeleteByCampusId(campusId);
    }

    public List<StandardDTO> getStandardsByFilter(Long campusId, String keyword) {
        log.info("[Facade:StandardFacade] getStandardsByFilter() called - campusId: {}, keyword: {}", campusId,
                keyword);
        return standardService.getStandardByFilter(campusId, keyword);
    }
}
