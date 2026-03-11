package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.facade.FeeRecurrenceRuleFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/fee-recurrence-rules")
@Slf4j
public class FeeRecurrenceRuleController {

    private final FeeRecurrenceRuleFacade feeRecurrenceRuleFacade;

    public FeeRecurrenceRuleController(FeeRecurrenceRuleFacade feeRecurrenceRuleFacade) {
        this.feeRecurrenceRuleFacade = feeRecurrenceRuleFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRecurrenceRuleResponseDTO>> getAll() {
        log.info("[Controller:FeeRecurrenceRuleController] getAll() called - Request to get all fee recurrence rules");
        List<FeeRecurrenceRuleResponseDTO> resources = feeRecurrenceRuleFacade.getAll();
        log.info("[Controller:FeeRecurrenceRuleController] getAll() succeeded - Found {} fee recurrence rules",
                resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRecurrenceRuleResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:FeeRecurrenceRuleController] getById() called - Request to fetch fee recurrence rule with id: {}",
                id);
        FeeRecurrenceRuleResponseDTO ruleDTO = feeRecurrenceRuleFacade.getById(id);
        log.info("[Controller:FeeRecurrenceRuleController] getById() succeeded - Found fee recurrence rule: {}", id);
        return ResponseEntity.ok(ruleDTO);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRecurrenceRuleResponseDTO>> search(
            @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:FeeRecurrenceRuleController] search() called - Request to search fee recurrence rules with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<FeeRecurrenceRuleResponseDTO> responseDTOs = feeRecurrenceRuleFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:FeeRecurrenceRuleController] search() succeeded - Found {} fee recurrence rules matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:FeeRecurrenceRuleController] delete() called - Request to delete fee recurrence rule: {}",
                id);
        feeRecurrenceRuleFacade.softDeleteById(id);
        log.info("[Controller:FeeRecurrenceRuleController] delete() succeeded - Fee recurrence rule: {} deleted successfully",
                id);
        return ResponseEntity.ok(Map.of("message", "Fee recurrence rule deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRecurrenceRuleResponseDTO> create(
            @Valid @RequestBody FeeRecurrenceRuleRequestDTO requestDTO) {
        log.info("[Controller:FeeRecurrenceRuleController] create() called - Request to create fee recurrence rule: {}",
                requestDTO.getName());
        FeeRecurrenceRuleResponseDTO responseDTO = feeRecurrenceRuleFacade.createFeeRecurrenceRule(requestDTO);
        log.info("[Controller:FeeRecurrenceRuleController] create() succeeded - Fee recurrence rule created with id: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRecurrenceRuleResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeRecurrenceRuleRequestDTO requestDTO) {
        log.info("[Controller:FeeRecurrenceRuleController] update() called - Request to update fee recurrence rule: {}",
                id);
        FeeRecurrenceRuleResponseDTO responseDTO = feeRecurrenceRuleFacade.updateFeeRecurrenceRule(id, requestDTO);
        log.info("[Controller:FeeRecurrenceRuleController] update() succeeded - Fee recurrence rule: {} updated successfully",
                id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:FeeRecurrenceRuleController] getStatistics() called");
        Map<String, Long> statistics = feeRecurrenceRuleFacade.getStatistics();
        log.info("[Controller:FeeRecurrenceRuleController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
