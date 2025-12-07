package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.service.FeeRateService;
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

    public  List<FeeRatesResponseDTO> searchFeeRates(String keyword){
        return feeRateService.searchFeeRates(keyword);
    }

    public  List<FeeRatesResponseDTO> getByFeeComponentId(Long feeComponentId){
        return feeRateService.getByFeeComponentId(feeComponentId);
    }
}
