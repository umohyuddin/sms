package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.service.FeeRecurrenceRuleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeeRecurrenceRuleFacade {
    
    private final FeeRecurrenceRuleService service;

    public FeeRecurrenceRuleFacade(FeeRecurrenceRuleService service) {
        this.service = service;
    }

    public FeeRecurrenceRuleResponseDTO create(@Valid FeeRecurrenceRuleRequestDTO dto) {
        return service.create(dto);
    }

    public List<FeeRecurrenceRuleResponseDTO> getAllActive() {
        return service.getAllActive();
    }

    public FeeRecurrenceRuleResponseDTO getById(Long id) {
        return service.getById(id);
    }

    public FeeRecurrenceRuleResponseDTO update(Long id, @Valid FeeRecurrenceRuleRequestDTO dto) {
        return service.update(id, dto);
    }

    public int softDeleteById(Long id) {
        return service.softDeleteById(id);
    }
}
