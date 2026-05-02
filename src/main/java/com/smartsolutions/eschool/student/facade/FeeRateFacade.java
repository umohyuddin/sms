package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.service.FeeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class FeeRateFacade {

    private final FeeRateService feeRateService;

    public FeeRateFacade(FeeRateService feeRateService) {
        this.feeRateService = feeRateService;
    }

    public List<FeeRatesResponseDTO> getAll() {
        log.info("[Facade:FeeRateFacade] getAll() called");
        List<FeeRatesResponseDTO> response = feeRateService.getAll();
        log.info("[Facade:FeeRateFacade] getAll() succeeded - Found {} rates", response.size());
        return response;
    }

    public FeeRatesResponseDTO getById(Long id) {
        log.info("[Facade:FeeRateFacade] getById() called - id: {}", id);
        FeeRatesResponseDTO response = feeRateService.getById(id);
        log.info("[Facade:FeeRateFacade] getById() succeeded - id: {}", id);
        return response;
    }

    public List<FeeRatesResponseDTO> getByFeeComponentId(Long feeComponentId) {
        log.info("[Facade:FeeRateFacade] getByFeeComponentId() called - component: {}", feeComponentId);
        List<FeeRatesResponseDTO> response = feeRateService.getByFeeComponentId(feeComponentId);
        log.info("[Facade:FeeRateFacade] getByFeeComponentId() succeeded - Found {} rates", response.size());
        return response;
    }

    public List<FeeRatesResponseDTO> findActiveFeeRates(Long campusId, Long standardId, Long academicYearId) {
        log.info("[Facade:FeeRateFacade] findActiveFeeRates() called - campus: {}, standard: {}, year: {}", campusId, standardId, academicYearId);
        List<FeeRatesResponseDTO> response = feeRateService.findActiveFeeRates(campusId, standardId, academicYearId);
        log.info("[Facade:FeeRateFacade] findActiveFeeRates() succeeded - Found {} rates", response.size());
        return response;
    }

    public FeeRatesResponseDTO create(FeeRateCreateRequestDTO requestDTO) {
        log.info("[Facade:FeeRateFacade] create() called");
        FeeRatesResponseDTO response = feeRateService.createFeeRate(requestDTO);
        log.info("[Facade:FeeRateFacade] create() succeeded - id: {}", response.getId());
        return response;
    }

    public FeeRatesResponseDTO update(Long id, FeeRateCreateRequestDTO dto) {
        log.info("[Facade:FeeRateFacade] update() called - id: {}", id);
        FeeRatesResponseDTO response = feeRateService.updateFeeRate(id, dto);
        log.info("[Facade:FeeRateFacade] update() succeeded - id: {}", id);
        return response;
    }

    public List<FeeRatesResponseDTO> searchFeeRates(Long feeCatalogId, Long feeComponentId, String keyword) {
        log.info("[Facade:FeeRateFacade] searchFeeRates() called - keyword: {}", keyword);
        List<FeeRatesResponseDTO> response = feeRateService.searchFeeRates(feeCatalogId, feeComponentId, keyword);
        log.info("[Facade:FeeRateFacade] searchFeeRates() succeeded - Found {} results", response.size());
        return response;
    }

    public void delete(Long id) {
        log.info("[Facade:FeeRateFacade] delete() called - id: {}", id);
        feeRateService.softDeleteById(id);
        log.info("[Facade:FeeRateFacade] delete() succeeded - id: {}", id);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:FeeRateFacade] getStatistics() called");
        Map<String, Long> stats = feeRateService.getStatistics();
        log.info("[Facade:FeeRateFacade] getStatistics() succeeded");
        return stats;
    }
}
