package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteBoardMemberErrors;
import com.smartsolutions.eschool.school.dtos.boardMembers.request.InstituteBoardMemberRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMembers.response.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.mapper.InstituteBoardMemberMapper;
import com.smartsolutions.eschool.school.model.BoardMemberRoleEntity;
import com.smartsolutions.eschool.school.model.InstituteBoardMemberEntity;
import com.smartsolutions.eschool.school.repository.BoardMemberRoleRepository;
import com.smartsolutions.eschool.school.repository.InstituteBoardMemberRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class InstituteBoardMemberService {

    private final InstituteBoardMemberRepository memberRepository;
    private final BoardMemberRoleRepository roleRepository;
    private final com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public InstituteBoardMemberService(InstituteBoardMemberRepository memberRepository,
                                       BoardMemberRoleRepository roleRepository, com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator) {
        this.entityReferenceValidator = entityReferenceValidator;
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public List<InstituteBoardMemberResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(InstituteBoardMemberErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteBoardMemberService] getAll() called - Organization: {}", organizationId);
        List<InstituteBoardMemberEntity> result = memberRepository.findByOrganizationId(organizationId);
        return InstituteBoardMemberMapper.toResponseDTOList(result);
    }

    @Transactional(readOnly = true)
    public InstituteBoardMemberResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(InstituteBoardMemberErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteBoardMemberService] getById() called - id: {}, Organization: {}", id, organizationId);
        InstituteBoardMemberEntity entity = memberRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(InstituteBoardMemberErrors.MEMBER_NOT_FOUND, HttpStatus.NOT_FOUND));
        return InstituteBoardMemberMapper.toResponseDTO(entity);
    }

    @Transactional
    public InstituteBoardMemberResponseDTO create(InstituteBoardMemberRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(InstituteBoardMemberErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteBoardMemberService] create() called - Organization: {}", organizationId);

        BoardMemberRoleEntity role = null;
        if (requestDTO.getRoleId() != null) {
            role = roleRepository.findByIdAndOrganizationId(requestDTO.getRoleId(), organizationId)
                    .orElseThrow(() -> new ApiException(InstituteBoardMemberErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        InstituteBoardMemberEntity entity = InstituteBoardMemberMapper.toEntity(requestDTO, role);
        InstituteBoardMemberEntity saved = memberRepository.save(entity);

        log.info("[Service:InstituteBoardMemberService] create() succeeded - Member created with id: {}", saved.getId());
        return InstituteBoardMemberMapper.toResponseDTO(saved);
    }

    @Transactional
    public InstituteBoardMemberResponseDTO update(Long id, InstituteBoardMemberRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(InstituteBoardMemberErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteBoardMemberService] update() called - id: {}, Organization: {}", id, organizationId);

        InstituteBoardMemberEntity existing = memberRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(InstituteBoardMemberErrors.MEMBER_NOT_FOUND, HttpStatus.NOT_FOUND));

        BoardMemberRoleEntity role = null;
        if (requestDTO.getRoleId() != null) {
            role = roleRepository.findByIdAndOrganizationId(requestDTO.getRoleId(), organizationId)
                    .orElseThrow(() -> new ApiException(InstituteBoardMemberErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));
        }

        InstituteBoardMemberMapper.updateEntity(existing, requestDTO, role);
        InstituteBoardMemberEntity updated = memberRepository.save(existing);

        log.info("[Service:InstituteBoardMemberService] update() succeeded - id: {}", id);
        return InstituteBoardMemberMapper.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(InstituteBoardMemberErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }

        log.info("[Service:InstituteBoardMemberService] delete() called - id: {}, Organization: {}", id, organizationId);

        InstituteBoardMemberEntity entity = memberRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(InstituteBoardMemberErrors.MEMBER_NOT_FOUND, HttpStatus.NOT_FOUND));
        this.entityReferenceValidator.ensureNotReferenced(InstituteBoardMemberEntity.class, id);
        log.info("This Entity Already Are User in Other Entity");

        entity.setDeleted(true);
        memberRepository.save(entity);
        log.info("[Service:InstituteBoardMemberService] delete() succeeded - id: {}", id);
    }

    @Transactional(readOnly = true)
    public List<InstituteBoardMemberResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(InstituteBoardMemberErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:InstituteBoardMemberService] search() called - keyword: {}, Organization: {}", keyword, organizationId);
        List<InstituteBoardMemberEntity> result = memberRepository.searchByKeyword(organizationId, keyword);
        return InstituteBoardMemberMapper.toResponseDTOList(result);
    }
}
