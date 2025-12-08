package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DiscountSubTypeService;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DiscountSubTypeFacade {

private final DiscountSubTypeService discountSubTypeService;

    public DiscountSubTypeFacade(DiscountSubTypeService discountSubTypeService) {
        this.discountSubTypeService = discountSubTypeService;
    }

    public DiscountSubTypeResponseDTO createSubDiscountType(@Valid DiscountSubTypeRequestDTO requestDTO) {
        return discountSubTypeService.createDiscountSubType(requestDTO);
    }

    public List<DiscountSubTypeResponseDTO> getAll() {
        return discountSubTypeService.getAll();
    }

    public DiscountSubTypeResponseDTO getById(Long discountSubTypeId) {
        return discountSubTypeService.getById(discountSubTypeId);
    }

    public List<DiscountSubTypeResponseDTO> getAllActive() {
        return discountSubTypeService.getAllActive();
    }

    public List<DiscountSubTypeResponseDTO> getAllInActive() {
        return discountSubTypeService.getAllInActive();
    }

    public int softDeleteById(Long discountSubTypeId) {
        return discountSubTypeService.softDeleteById(discountSubTypeId);
    }


    public List<DiscountSubTypeResponseDTO> searchByKeyword(String keyword) {
        return discountSubTypeService.searchByKeyword(keyword);
    }

    public int softDeleteAll() {
        return discountSubTypeService.softDeleteAll();
    }
    public int markAsActive(Long discountSubTypeId) {
        return discountSubTypeService.markAsActive(discountSubTypeId);
    }
    public int markAsInactive(Long discountSubTypeId) {
        return discountSubTypeService.markAsInactive(discountSubTypeId);
    }

    public List<DiscountSubTypeResponseDTO> searchDiscountComponents(Long discountTypeId, String keyword) {
        return discountSubTypeService.searchDiscountComponents(discountTypeId,keyword);
    }

    public DiscountSubTypeResponseDTO update(Long id, @Valid DiscountSubTypeRequestDTO requestDTO) {
        return discountSubTypeService.update(id,requestDTO);
    }
}
