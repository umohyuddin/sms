package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.service.SchoolTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class SchoolTypeFacade {

    private final SchoolTypeService schoolTypeService;

    public SchoolTypeFacade(SchoolTypeService schoolTypeService) {
        this.schoolTypeService = schoolTypeService;
    }

    public SchoolTypeResponseDTO createSchoolType(SchoolTypeCreateRequestDTO requestDTO) {
        return schoolTypeService.createSchoolType(requestDTO);
    }

    public List<SchoolTypeResponseDTO> getAll() {
        return schoolTypeService.getAll();
    }

    public List<SchoolTypeResponseDTO> getAllActive() {
        return schoolTypeService.getAllActive();
    }

    public SchoolTypeResponseDTO getById(Long id) {
        return schoolTypeService.getById(id);
    }

    public SchoolTypeResponseDTO updateSchoolType(Long id, SchoolTypeUpdateRequestDTO requestDTO) {
        return schoolTypeService.updateSchoolType(id, requestDTO);
    }

    public void deleteById(Long id) {
        schoolTypeService.deleteById(id);
    }

    public List<SchoolTypeResponseDTO> searchByKeyword(String keyword) {
        return schoolTypeService.searchByKeyword(keyword);
    }

    public SchoolTypeResponseDTO activate(Long id) {
        return schoolTypeService.activate(id);
    }

    public SchoolTypeResponseDTO deactivate(Long id) {
        return schoolTypeService.deactivate(id);
    }
}
