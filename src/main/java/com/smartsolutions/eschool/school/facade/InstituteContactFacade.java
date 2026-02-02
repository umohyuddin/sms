package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteContactService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteContactFacade {

    private final InstituteContactService instituteContactService;

    public InstituteContactFacade(InstituteContactService instituteContactService) {
        this.instituteContactService = instituteContactService;
    }

    public InstituteContactResponseDTO createContact(InstituteContactCreateRequestDTO requestDTO) {
        return instituteContactService.createContact(requestDTO);
    }

    public Page<InstituteContactResponseDTO> getAll(Pageable pageable) {
        return instituteContactService.getAll(pageable);
    }

    public Page<InstituteContactResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteContactService.getByInstituteId(instituteId, pageable);
    }

    public InstituteContactResponseDTO getById(Long id) {
        return instituteContactService.getById(id);
    }

    public InstituteContactResponseDTO updateContact(Long id, InstituteContactUpdateRequestDTO requestDTO) {
        return instituteContactService.updateContact(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteContactService.deleteById(id);
    }

    public List<InstituteContactResponseDTO> searchByKeyword(String keyword) {
        return instituteContactService.searchByKeyword(keyword);
    }
}
