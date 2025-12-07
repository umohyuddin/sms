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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeComponentFacade {


    private final FeeComponentService feeComponentService;

    public FeeComponentFacade(FeeComponentService feeComponentService) {
        this.feeComponentService = feeComponentService;
    }

    public List<FeeComponentDTO> getAll() {
        return feeComponentService.getAll();
    }
    public FeeComponentDTO getById(Long id) {
        return feeComponentService.getById(id);
    }

    public List<FeeComponentResponseDTO> searchFeeCatalogComponents(Long feeCatalogId, String keyword) {
        return feeComponentService.searchFeeCatalogComponents(feeCatalogId,keyword);
    }

    public FeeComponentResponseDTO create(@Valid FeeCatalogComponentRequestDTO requestDTO) {
    return feeComponentService.create(requestDTO);
    }

    public FeeComponentResponseDTO updateFeeComponent(Long id, @Valid FeeCatalogComponentRequestDTO dto) {
        return feeComponentService.updateFeeComponent(id, dto);
    }

    public List<FeeComponentResponseDTO> getByFeeCatalogId(Long feeCatalogId) {
        return feeComponentService.getByFeeCatalogId(feeCatalogId);
    }

}
