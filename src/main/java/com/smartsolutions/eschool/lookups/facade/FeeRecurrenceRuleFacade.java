package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.service.FeeRecurrenceRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class FeeRecurrenceRuleFacade {

    private final FeeRecurrenceRuleService feeRecurrenceRuleService;

    public FeeRecurrenceRuleFacade(FeeRecurrenceRuleService feeRecurrenceRuleService) {
        this.feeRecurrenceRuleService = feeRecurrenceRuleService;
    }

    public List<FeeRecurrenceRuleResponseDTO> getAll() {
        log.info("[Facade:FeeRecurrenceRuleFacade] getAll() called");
        return feeRecurrenceRuleService.getAll();
    }

    public FeeRecurrenceRuleResponseDTO getById(Long id) {
        log.info("[Facade:FeeRecurrenceRuleFacade] getById() called - id: {}", id);
        return feeRecurrenceRuleService.getById(id);
    }

    public List<FeeRecurrenceRuleResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:FeeRecurrenceRuleFacade] searchByKeyword() called - keyword: {}", keyword);
        return feeRecurrenceRuleService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:FeeRecurrenceRuleFacade] softDeleteById() called - id: {}", id);
        feeRecurrenceRuleService.softDeleteById(id);
    }

    public FeeRecurrenceRuleResponseDTO createFeeRecurrenceRule(FeeRecurrenceRuleRequestDTO dto) {
        log.info("[Facade:FeeRecurrenceRuleFacade] createFeeRecurrenceRule() called");
        return feeRecurrenceRuleService.createFeeRecurrenceRule(dto);
    }

    public FeeRecurrenceRuleResponseDTO updateFeeRecurrenceRule(Long id, FeeRecurrenceRuleRequestDTO dto) {
        log.info("[Facade:FeeRecurrenceRuleFacade] updateFeeRecurrenceRule() called - id: {}", id);
        return feeRecurrenceRuleService.updateFeeRecurrenceRule(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:FeeRecurrenceRuleFacade] getStatistics() called");
        return feeRecurrenceRuleService.getStatistics();
    }
}
