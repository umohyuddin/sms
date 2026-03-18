package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DiscountSubTypeService;
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

    public DiscountSubTypeResponseDTO create(@Valid DiscountSubTypeRequestDTO requestDTO) {
        return discountSubTypeService.create(requestDTO);
    }

    public List<DiscountSubTypeResponseDTO> getAll() {
        return discountSubTypeService.getAll();
    }

    public DiscountSubTypeResponseDTO getById(Long id) {
        return discountSubTypeService.getById(id);
    }

    public List<DiscountSubTypeResponseDTO> getAllActive() {
        return discountSubTypeService.getAllActive();
    }

    public List<DiscountSubTypeResponseDTO> getAllInActive() {
        return discountSubTypeService.getAllInActive();
    }

    public int softDeleteById(Long id) {
        return discountSubTypeService.softDeleteById(id);
    }

    public List<DiscountSubTypeResponseDTO> searchByKeyword(String keyword) {
        return discountSubTypeService.searchByKeyword(keyword);
    }

    public int softDeleteAll() {
        return discountSubTypeService.softDeleteAll();
    }

    public int markAsActive(Long id) {
        return discountSubTypeService.markAsActive(id);
    }

    public int markAsInactive(Long id) {
        return discountSubTypeService.markAsInactive(id);
    }

    public List<DiscountSubTypeResponseDTO> searchDiscountComponents(Long discountTypeId, String keyword) {
        return discountSubTypeService.searchDiscountComponents(discountTypeId, keyword);
    }

    public DiscountSubTypeResponseDTO update(Long id, @Valid DiscountSubTypeRequestDTO requestDTO) {
        return discountSubTypeService.update(id, requestDTO);
    }

    public List<DiscountSubTypeResponseDTO> getActiveByDiscountTypeId(Long discountTypeId) {
        return discountSubTypeService.getActiveByDiscountTypeId(discountTypeId);
    }
}
