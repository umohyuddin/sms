package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.service.DepartmentService;
import com.smartsolutions.eschool.school.service.DiscountTypeService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DepartmentFacade {

    private final DepartmentService departmentService;

    public DepartmentFacade(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO requestDTO) {
        return departmentService.createDepartment(requestDTO);
    }

    public List<DepartmentResponseDTO> getAll() {
        return departmentService.getAllDepartments();
    }

    public DepartmentResponseDTO getById(Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    public List<DepartmentResponseDTO> getAllActive() {
        return departmentService.getAllActiveDepartments();
    }

    public DepartmentResponseDTO updateDepartment(
            Long departmentId,
            @Valid DepartmentRequestDTO requestDTO
    ) {
        return departmentService.updateDepartment(departmentId, requestDTO);
    }

    public void deleteById(Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}