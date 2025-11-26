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

    public DiscountTypeRequestDTO createDiscountType(@Valid DiscountTypeRequestDTO requestDTO) {
        return discountTypeService.createDiscountType(requestDTO);
    }

    public List<DiscountTypeResponseDTO> getAll() {
        return discountTypeService.getAll();
    }
}
