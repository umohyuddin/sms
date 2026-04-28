package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;

import com.smartsolutions.eschool.student.service.FeeRateService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeRateFacade {

    private final FeeRateService feeRateService;

    public FeeRateFacade(FeeRateService feeRateService) {
        this.feeRateService = feeRateService;
    }

    public List<FeeRatesResponseDTO> getAll() {
        return feeRateService.getAll();
    }

    public FeeRatesResponseDTO getById(Long id) {
        return feeRateService.getById(id);
    }

    // public List<FeeRatesResponseDTO> searchFeeRates(String keyword){
    // return feeRateService.searchFeeRates(keyword);
    // }

    public List<FeeRatesResponseDTO> getByFeeComponentId(Long feeComponentId) {
        return feeRateService.getByFeeComponentId(feeComponentId);
    }

    public List<FeeRatesResponseDTO> findActiveFeeRates(Long campusId, Long standardId, Long academicYearId) {
        return feeRateService.findActiveFeeRates(campusId, standardId, academicYearId);
    }

    public FeeRatesResponseDTO create(FeeRateCreateRequestDTO requestDTO) {
        return feeRateService.createFeeRate(requestDTO);
    }

    public FeeRatesResponseDTO update(Long id, @Valid FeeRateCreateRequestDTO dto) {
        return feeRateService.updateFeeRate(id, dto);
    }

    public List<FeeRatesResponseDTO> searchFeeRates(Long feeCatalogId, Long feeComponentId, String keyword) {
        return feeRateService.searchFeeRates(feeCatalogId, feeComponentId, keyword);
    }
}
