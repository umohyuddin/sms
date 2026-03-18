package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateResponseDTO;
import com.smartsolutions.eschool.school.service.DiscountRateService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DiscountRateFacade {

    private final DiscountRateService discountRateService;

    public DiscountRateFacade(DiscountRateService discountRateService) {
        this.discountRateService = discountRateService;
    }

    public DiscountRateResponseDTO create(@Valid DiscountRateRequestDTO requestDTO) {
        return discountRateService.create(requestDTO);
    }

    public List<DiscountRateResponseDTO> getAll() {
        return discountRateService.getAll();
    }

    public DiscountRateResponseDTO getById(Long id) {
        return discountRateService.getById(id);
    }

    public List<DiscountRateResponseDTO> getAllByCampus(Long campusId) {
        return discountRateService.getAllByCampus(campusId);
    }

    public List<DiscountRateResponseDTO> getAllByAcademicYear(Long academicYearId) {
        return discountRateService.getAllByAcademicYear(academicYearId);
    }

    public List<DiscountRateResponseDTO> getDiscountRatesByCampusAndAcademicYear(Long campusId, Long academicYearId) {
        return discountRateService.getDiscountRatesByCampusAndAcademicYear(campusId, academicYearId);
    }

    public int softDeleteById(Long id) {
        return discountRateService.softDeleteById(id);
    }

    public int markAsActive(Long id) {
        return discountRateService.markAsActive(id);
    }

    public int markAsInactive(Long id) {
        return discountRateService.markAsInactive(id);
    }

    public DiscountRateResponseDTO update(Long id, @Valid DiscountRateRequestDTO requestDTO) {
        return discountRateService.update(id, requestDTO);
    }

    public int softDeleteAll() {
        return discountRateService.softDeleteAll();
    }

    public List<DiscountRateResponseDTO> search(Long discountTypeId, Long discountSubTypeId,
            Long recurrenceRuleId, String keyword) {
        return discountRateService.search(discountTypeId, discountSubTypeId, recurrenceRuleId, keyword);
    }
}
