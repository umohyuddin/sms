package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.responseDto.InstituteBillingResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteBillingService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteBillingFacade {

    private final InstituteBillingService instituteBillingService;

    public InstituteBillingFacade(InstituteBillingService instituteBillingService) {
        this.instituteBillingService = instituteBillingService;
    }

    public InstituteBillingResponseDTO createBilling(InstituteBillingCreateRequestDTO requestDTO) {
        return instituteBillingService.createBilling(requestDTO);
    }

    public InstituteBillingResponseDTO getById(Long id) {
        return instituteBillingService.getById(id);
    }

    public InstituteBillingResponseDTO getByInstituteId(Long instituteId) {
        return instituteBillingService.getByInstituteId(instituteId);
    }

    public InstituteBillingResponseDTO updateBilling(Long id, InstituteBillingUpdateRequestDTO requestDTO) {
        return instituteBillingService.updateBilling(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteBillingService.deleteById(id);
    }

    public List<InstituteBillingResponseDTO> searchByKeyword(String keyword) {
        return instituteBillingService.searchByKeyword(keyword);
    }
}
