package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto.FeeCatalogRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.service.FeeCatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class FeeCatalogFacade {

    private final FeeCatalogService feeCatalogService;

    public FeeCatalogFacade(FeeCatalogService feeCatalogService) {
        this.feeCatalogService = feeCatalogService;
    }

    public List<FeeCatalogDTO> getAll() {
        log.info("[Facade:FeeCatalogFacade] getAll() called");
        return feeCatalogService.getAll();
    }

    public FeeCatalogDTO getById(Long id) {
        log.info("[Facade:FeeCatalogFacade] getById() called - id: {}", id);
        return feeCatalogService.getById(id);
    }

    public List<FeeCatalogDTO> searchByKeyword(String keyword) {
        log.info("[Facade:FeeCatalogFacade] searchByKeyword() called - keyword: {}", keyword);
        return feeCatalogService.searchByKeyword(keyword);
    }

    public List<FeeCatalogDTO> getByChargeType(Long chargeTypeId) {
        log.info("[Facade:FeeCatalogFacade] getByChargeType() called - chargeTypeId: {}", chargeTypeId);
        return feeCatalogService.getByChargeType(chargeTypeId);
    }

    public List<FeeCatalogDTO> getByRecurrenceRule(Long recurrenceRuleId) {
        log.info("[Facade:FeeCatalogFacade] getByRecurrenceRule() called - recurrenceRuleId: {}", recurrenceRuleId);
        return feeCatalogService.getByRecurrenceRule(recurrenceRuleId);
    }

    public FeeCatalogDTO createFeeCatalog(FeeCatalogRequestDTO dto) {
        log.info("[Facade:FeeCatalogFacade] createFeeCatalog() called");
        return feeCatalogService.createFeeCatalog(dto);
    }

    public FeeCatalogDTO updateFeeCatalog(Long id, FeeCatalogRequestDTO dto) {
        log.info("[Facade:FeeCatalogFacade] updateFeeCatalog() called - id: {}", id);
        return feeCatalogService.updateFeeCatalog(id, dto);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:FeeCatalogFacade] softDeleteById() called - id: {}", id);
        feeCatalogService.softDeleteById(id);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:FeeCatalogFacade] getStatistics() called");
        return feeCatalogService.getStatistics();
    }
}
