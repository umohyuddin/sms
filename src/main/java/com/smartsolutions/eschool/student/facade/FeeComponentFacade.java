package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.service.FeeCatalogService;
import com.smartsolutions.eschool.student.service.FeeComponentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class FeeComponentFacade {
    private final FeeComponentService feeComponentService;

    public FeeComponentFacade(FeeComponentService feeComponentService) {
        this.feeComponentService = feeComponentService;
    }

    // ====================================
    // GET ALL COMPONENTS
    // ====================================
    public List<FeeComponentResponseDTO> getAll() {
        log.info("[Facade:FeeComponentFacade] getAll() called");
        return feeComponentService.getAll();
    }

    // ====================================
    // GET COMPONENT BY ID
    // ====================================
    public FeeComponentResponseDTO getById(Long id) {
        log.info("[Facade:FeeComponentFacade] getById() called - id: {}", id);
        return feeComponentService.getById(id);
    }

    // ====================================
    // GET COMPONENTS BY FEE CATALOG
    // ====================================
    public List<FeeComponentResponseDTO> getByFeeCatalogId(Long feeCatalogId) {
        log.info("[Facade:FeeComponentFacade] getByFeeCatalogId() called - catalogId: {}", feeCatalogId);
        return feeComponentService.getByCatalog(feeCatalogId);
    }

    // ====================================
    // SEARCH COMPONENTS
    // ====================================
    public List<FeeComponentResponseDTO> searchFeeCatalogComponents(Long feeCatalogId, String keyword) {
        log.info("[Facade:FeeComponentFacade] searchFeeCatalogComponents() called - catalogId: {}, keyword: {}", feeCatalogId, keyword);
        return feeComponentService.search(feeCatalogId, keyword);
    }

    // ====================================
    // CREATE COMPONENT
    // ====================================
    public FeeComponentResponseDTO create(@Valid FeeCatalogComponentRequestDTO requestDTO) {
        log.info("[Facade:FeeComponentFacade] create() called - catalogId: {}", requestDTO.getFeeCatalogId());
        return feeComponentService.create(requestDTO);
    }

    // ====================================
    // UPDATE COMPONENT
    // ====================================
    public FeeComponentResponseDTO updateFeeComponent(Long id, @Valid FeeCatalogComponentRequestDTO requestDTO) {
        log.info("[Facade:FeeComponentFacade] updateFeeComponent() called - id: {}", id);
        return feeComponentService.update(id, requestDTO);
    }

}
