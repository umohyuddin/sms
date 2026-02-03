package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.responseDto.InstituteExecutiveResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteExecutiveService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteExecutiveFacade {

    private final InstituteExecutiveService instituteExecutiveService;

    public InstituteExecutiveFacade(InstituteExecutiveService instituteExecutiveService) {
        this.instituteExecutiveService = instituteExecutiveService;
    }

    public InstituteExecutiveResponseDTO createExecutive(InstituteExecutiveCreateRequestDTO requestDTO) {
        return instituteExecutiveService.createExecutive(requestDTO);
    }

    public List<InstituteExecutiveResponseDTO> getAll() {
        return instituteExecutiveService.getAll();
    }

    public List<InstituteExecutiveResponseDTO> getByInstituteId(Long instituteId) {
        return instituteExecutiveService.getByInstituteId(instituteId);
    }

    public InstituteExecutiveResponseDTO getById(Long id) {
        return instituteExecutiveService.getById(id);
    }

    public InstituteExecutiveResponseDTO updateExecutive(Long id, InstituteExecutiveUpdateRequestDTO requestDTO) {
        return instituteExecutiveService.updateExecutive(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteExecutiveService.deleteById(id);
    }

    public List<InstituteExecutiveResponseDTO> searchByKeyword(String keyword) {
        return instituteExecutiveService.searchByKeyword(keyword);
    }
}
