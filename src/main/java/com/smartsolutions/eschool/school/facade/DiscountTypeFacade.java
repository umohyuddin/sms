package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DiscountTypeService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DiscountTypeFacade {

    private final DiscountTypeService discountTypeService;

    public DiscountTypeFacade(DiscountTypeService discountTypeService) {
        this.discountTypeService = discountTypeService;
    }

    public DiscountTypeResponseDTO create(@Valid DiscountTypeRequestDTO requestDTO) {
        return discountTypeService.create(requestDTO);
    }

    public List<DiscountTypeResponseDTO> getAll() {
        return discountTypeService.getAll();
    }

    public DiscountTypeResponseDTO getById(Long id) {
        return discountTypeService.getById(id);
    }

    public List<DiscountTypeResponseDTO> getAllActive() {
        return discountTypeService.getAllActive();
    }

    public List<DiscountTypeResponseDTO> getAllInActive() {
        return discountTypeService.getAllInActive();
    }

    public int softDeleteById(Long id) {
        return discountTypeService.softDeleteById(id);
    }

    public List<DiscountTypeResponseDTO> searchByKeyword(String keyword) {
        return discountTypeService.searchByKeyword(keyword);
    }

    public DiscountTypeResponseDTO update(Long id, @Valid DiscountTypeRequestDTO requestDTO) {
        return discountTypeService.update(id, requestDTO);
    }
}
