package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.boardMembers.request.InstituteBoardMemberRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMembers.response.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteBoardMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class InstituteBoardMemberFacade {

    private final InstituteBoardMemberService memberService;

    public InstituteBoardMemberFacade(InstituteBoardMemberService memberService) {
        this.memberService = memberService;
    }

    public List<InstituteBoardMemberResponseDTO> getAll() {
        log.info("[Facade:InstituteBoardMemberFacade] getAll() called");
        return memberService.getAll();
    }

    public InstituteBoardMemberResponseDTO getById(Long id) {
        log.info("[Facade:InstituteBoardMemberFacade] getById() called - id: {}", id);
        return memberService.getById(id);
    }

    public InstituteBoardMemberResponseDTO create(InstituteBoardMemberRequestDTO dto) {
        log.info("[Facade:InstituteBoardMemberFacade] create() called");
        return memberService.create(dto);
    }

    public InstituteBoardMemberResponseDTO update(Long id, InstituteBoardMemberRequestDTO dto) {
        log.info("[Facade:InstituteBoardMemberFacade] update() called - id: {}", id);
        return memberService.update(id, dto);
    }

    public void delete(Long id) {
        log.info("[Facade:InstituteBoardMemberFacade] delete() called - id: {}", id);
        memberService.delete(id);
    }

    public List<InstituteBoardMemberResponseDTO> search(String keyword) {
        log.info("[Facade:InstituteBoardMemberFacade] search() called - keyword: {}", keyword);
        return memberService.search(keyword);
    }
}
