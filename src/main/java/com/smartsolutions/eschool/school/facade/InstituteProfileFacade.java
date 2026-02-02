package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.responseDto.InstituteProfileResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteProfileService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteProfileFacade {

    private final InstituteProfileService instituteProfileService;

    public InstituteProfileFacade(InstituteProfileService instituteProfileService) {
        this.instituteProfileService = instituteProfileService;
    }

    public InstituteProfileResponseDTO createProfile(InstituteProfileCreateRequestDTO requestDTO) {
        return instituteProfileService.createProfile(requestDTO);
    }

    public InstituteProfileResponseDTO getById(Long id) {
        return instituteProfileService.getById(id);
    }

    public InstituteProfileResponseDTO getByInstituteId(Long instituteId) {
        return instituteProfileService.getByInstituteId(instituteId);
    }

    public InstituteProfileResponseDTO updateProfile(Long id, InstituteProfileUpdateRequestDTO requestDTO) {
        return instituteProfileService.updateProfile(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteProfileService.deleteById(id);
    }

    public List<InstituteProfileResponseDTO> searchByKeyword(String keyword) {
        return instituteProfileService.searchByKeyword(keyword);
    }
}
