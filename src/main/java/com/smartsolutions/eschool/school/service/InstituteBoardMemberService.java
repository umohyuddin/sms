package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.responseDto.InstituteBoardMemberResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteBoardMemberService {
    InstituteBoardMemberResponseDTO createBoardMember(InstituteBoardMemberCreateRequestDTO requestDTO);

    Page<InstituteBoardMemberResponseDTO> getAll(Pageable pageable);

    Page<InstituteBoardMemberResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    List<InstituteBoardMemberResponseDTO> getAllActive();

    InstituteBoardMemberResponseDTO getById(Long id);

    InstituteBoardMemberResponseDTO updateBoardMember(Long id, InstituteBoardMemberUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteBoardMemberResponseDTO> searchByKeyword(String keyword);

    InstituteBoardMemberResponseDTO activate(Long id);

    InstituteBoardMemberResponseDTO deactivate(Long id);
}
