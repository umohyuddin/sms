package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.responseDto.InstituteBillingResponseDTO;

import java.util.List;

public interface InstituteBillingService {
    InstituteBillingResponseDTO createBilling(InstituteBillingCreateRequestDTO requestDTO);

    InstituteBillingResponseDTO getById(Long id);

    InstituteBillingResponseDTO getByInstituteId(Long instituteId);

    InstituteBillingResponseDTO updateBilling(Long id, InstituteBillingUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteBillingResponseDTO> searchByKeyword(String keyword);
}
