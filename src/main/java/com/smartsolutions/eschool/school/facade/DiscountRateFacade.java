package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateFullResponseDTO;
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

    // ---------------- Create ----------------
    public DiscountRateResponseDTO createDiscountRate(@Valid DiscountRateRequestDTO requestDTO) {
        return discountRateService.createDiscountRate(requestDTO);
    }

    // ---------------- Get All ----------------
    public List<DiscountRateResponseDTO> getAll() {
        return discountRateService.getAll();
    }

    public List<DiscountRateFullResponseDTO> getDiscountRatesByCampusAndAcademicYear(Long campusId, Long academicYearId) {
        return discountRateService.getDiscountRatesByCampusAndAcademicYear(campusId,academicYearId);
    }

    // ---------------- Get by ID ----------------
    public DiscountRateResponseDTO getById(Long id) {
        return discountRateService.getById(id);
    }

    // ---------------- Get All by Campus ----------------
    public List<DiscountRateResponseDTO> getAllByCampus(Long campusId) {
        return discountRateService.getAllByCampus(campusId);
    }

    // ---------------- Get All by Academic Year ----------------
    public List<DiscountRateResponseDTO> getAllByAcademicYear(Long academicYearId) {
        return discountRateService.getAllByAcademicYear(academicYearId);
    }

    // ---------------- Soft Delete by ID ----------------
    public int softDeleteById(Long id) {
        return discountRateService.softDeleteById(id);
    }

    // ---------------- Soft Delete All ----------------
    public int softDeleteAll() {
        return discountRateService.softDeleteAll();
    }

    // ---------------- Mark as Active ----------------
    public int markAsActive(Long id) {
        return discountRateService.markAsActive(id);
    }

    // ---------------- Mark as Inactive ----------------
    public int markAsInactive(Long id) {
        return discountRateService.markAsInactive(id);
    }

    public List<DiscountRateResponseDTO> search(Long discountTypeId, Long discountSubTypeId, String chargeTypeId, String recurrenceRuleId, String keyword) {
        return discountRateService.search(discountTypeId,discountSubTypeId,chargeTypeId,recurrenceRuleId,keyword);
    }
}
