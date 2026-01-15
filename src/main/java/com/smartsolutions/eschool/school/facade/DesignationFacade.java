package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DesignationService;
import com.smartsolutions.eschool.school.service.DiscountTypeService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DesignationFacade {
    private final DesignationService designationService;

    public DesignationFacade(DesignationService designationService) {
        this.designationService = designationService;
    }

    /* =========================
       CREATE
       ========================= */
    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        return designationService.createDesignation(requestDTO);
    }

    /* =========================
       GET BY ID
       ========================= */
    public DesignationResponseDTO getById(Long designationId) {
        return designationService.getById(designationId);
    }

    /* =========================
       GET ALL
       ========================= */
    public List<DesignationResponseDTO> getAll() {
        return designationService.getAll();
    }

    public List<DesignationResponseDTO> getAllActive() {
        return designationService.getAllActive();
    }

//    public List<DesignationResponseDTO> getAllInactive() {
//        return designationService.getAllInactive();
//    }

    /* =========================
       UPDATE
       ========================= */
//    public DesignationResponseDTO updateDesignation(Long designationId, @Valid DesignationRequestDTO requestDTO) {
//        return designationService.updateDesignation(designationId, requestDTO);
//    }

    /* =========================
       SOFT DELETE
       ========================= */
//    public int softDeleteById(Long designationId) {
//        return designationService.softDeleteById(designationId);
//    }

    /* =========================
       SEARCH
       ========================= */
    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        return designationService.searchByKeyword(keyword);
    }

    public List<DesignationResponseDTO> getByDepartmentId(Long departmentId) {
        return designationService.getByDepartmentId(departmentId);
    }
}