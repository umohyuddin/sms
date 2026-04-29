package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.responseDto.InstituteBillingResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteBillingFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/billing")
@Slf4j
public class InstituteBillingController {

    private final InstituteBillingFacade instituteBillingFacade;

    public InstituteBillingController(InstituteBillingFacade instituteBillingFacade) {
        this.instituteBillingFacade = instituteBillingFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBillingResponseDTO> createBilling(@Valid @RequestBody InstituteBillingCreateRequestDTO requestDTO) {
        InstituteBillingResponseDTO responseDTO = instituteBillingFacade.createBilling(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(value = "/{billingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBillingResponseDTO> getById(@PathVariable Long billingId) {
        return ResponseEntity.ok(instituteBillingFacade.getById(billingId));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBillingResponseDTO> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteBillingFacade.getByInstituteId(instituteId));
    }

    @PutMapping(value = "/{billingId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBillingResponseDTO> updateBilling(@PathVariable Long billingId, @Valid @RequestBody InstituteBillingUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteBillingFacade.updateBilling(billingId, requestDTO));
    }

    @DeleteMapping("/{billingId}")
    public ResponseEntity<String> deleteBilling(@PathVariable Long billingId) {
        instituteBillingFacade.deleteById(billingId);
        return ResponseEntity.ok("Institute billing deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteBillingResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteBillingFacade.searchByKeyword(keyword.trim()));
    }
}
