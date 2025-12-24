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
public class DepartmentFacade {

private final DiscountTypeService discountTypeService;

    public DepartmentFacade(DiscountTypeService discountTypeService) {
        this.discountTypeService = discountTypeService;
    }

    public DiscountTypeResponseDTO createDiscountType(@Valid DiscountTypeRequestDTO requestDTO) {
        return discountTypeService.createDiscountType(requestDTO);
    }

    public List<DiscountTypeResponseDTO> getAll() {
        return discountTypeService.getAll();
    }

    public DiscountTypeResponseDTO getById(Long discountTypeId) {
        return discountTypeService.getById(discountTypeId);
    }

    public List<DiscountTypeResponseDTO> getAllActive() {
        return discountTypeService.getAllActive();
    }

    public List<DiscountTypeResponseDTO> getAllInActive() {
        return discountTypeService.getAllInActive();
    }

    public int softDeleteById(Long discountTypeId) {
        return discountTypeService.softDeleteById(discountTypeId);
    }


    public List<DiscountTypeResponseDTO> searchByKeyword(String keyword) {
        return discountTypeService.searchByKeyword(keyword);
    }

    public DiscountTypeResponseDTO updateDiscountType(Long discountTypeId, @Valid DiscountTypeRequestDTO requestDTO) {
        return discountTypeService.updateDiscountType(discountTypeId,requestDTO);
    }
}
