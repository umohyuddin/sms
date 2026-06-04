package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteContactService;
import org.springframework.context.annotation.Scope;
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

    public List<InstituteContactResponseDTO> getAll() {
        return instituteContactService.getAll();
    }

    public List<InstituteContactResponseDTO> getByInstituteId(Long instituteId) {
        return instituteContactService.getByInstituteId(instituteId);
    }

    public InstituteContactResponseDTO updateContact(Long contactId, Long instituteId, InstituteContactUpdateRequestDTO requestDTO) {
        return instituteContactService.updateContact(contactId, instituteId, requestDTO);
    }

//    public InstituteContactResponseDTO updateContact(Long id, InstituteContactUpdateRequestDTO requestDTO) {
//        return instituteContactService.updateContact(id, requestDTO);
//    }

    public void deleteById(Long contactId, Long organizationId) {
        instituteContactService.deleteById(contactId, organizationId);
    }

    public List<InstituteContactResponseDTO> searchByKeyword(Long instituteId,String keyword) {
        return instituteContactService.searchByKeyword(instituteId,keyword);
    }

    public InstituteContactResponseDTO getById(Long contactId, Long instituteId) {
      return   instituteContactService.getById(contactId,instituteId);
    }
}
