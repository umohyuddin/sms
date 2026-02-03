package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.responseDto.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteBoardMemberService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteBoardMemberFacade {

    private final InstituteBoardMemberService instituteBoardMemberService;

    public InstituteBoardMemberFacade(InstituteBoardMemberService instituteBoardMemberService) {
        this.instituteBoardMemberService = instituteBoardMemberService;
    }

    public InstituteBoardMemberResponseDTO createBoardMember(InstituteBoardMemberCreateRequestDTO requestDTO) {
        return instituteBoardMemberService.createBoardMember(requestDTO);
    }

    public List<InstituteBoardMemberResponseDTO> getAll() {
        return instituteBoardMemberService.getAll();
    }

    public List<InstituteBoardMemberResponseDTO> getByInstituteId(Long instituteId) {
        return instituteBoardMemberService.getByInstituteId(instituteId);
    }

    public List<InstituteBoardMemberResponseDTO> getAllActive() {
        return instituteBoardMemberService.getAllActive();
    }

    public InstituteBoardMemberResponseDTO getById(Long id) {
        return instituteBoardMemberService.getById(id);
    }

    public InstituteBoardMemberResponseDTO updateBoardMember(Long id, InstituteBoardMemberUpdateRequestDTO requestDTO) {
        return instituteBoardMemberService.updateBoardMember(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteBoardMemberService.deleteById(id);
    }

    public List<InstituteBoardMemberResponseDTO> searchByKeyword(String keyword) {
        return instituteBoardMemberService.searchByKeyword(keyword);
    }

    public InstituteBoardMemberResponseDTO activate(Long id) {
        return instituteBoardMemberService.activate(id);
    }

    public InstituteBoardMemberResponseDTO deactivate(Long id) {
        return instituteBoardMemberService.deactivate(id);
    }
}
