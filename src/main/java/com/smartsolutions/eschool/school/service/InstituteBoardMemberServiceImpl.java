package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.responseDto.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteBoardMemberEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteBoardMemberRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteBoardMemberServiceImpl implements InstituteBoardMemberService {

    private final InstituteBoardMemberRepository instituteBoardMemberRepository;
    private final InstituteRepository instituteRepository;

    public InstituteBoardMemberServiceImpl(InstituteBoardMemberRepository instituteBoardMemberRepository, InstituteRepository instituteRepository) {
        this.instituteBoardMemberRepository = instituteBoardMemberRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteBoardMemberResponseDTO createBoardMember(InstituteBoardMemberCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteBoardMemberEntity entity = MapperUtil.mapObject(requestDTO, InstituteBoardMemberEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteBoardMemberEntity saved = instituteBoardMemberRepository.save(entity);
            InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(saved, InstituteBoardMemberResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteBoardMember", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteBoardMember", ex);
            throw ex;
        }
    }

    @Override
    public Page<InstituteBoardMemberResponseDTO> getAll(Pageable pageable) {
        try {
            Page<InstituteBoardMemberEntity> result = instituteBoardMemberRepository.findAllJpql(pageable);
            return result.map(entity -> {
                InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(entity, InstituteBoardMemberResponseDTO.class);
                dto.setInstituteId(entity.getInstitute().getId());
                return dto;
            });
        } catch (DataAccessException dae) {
            log.error("Database error while fetching InstituteBoardMembers", dae);
        } catch (MappingException me) {
            log.error("Error mapping InstituteBoardMemberEntity", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching InstituteBoardMembers", e);
        }
        return Page.empty();
    }

    @Override
    public Page<InstituteBoardMemberResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        Page<InstituteBoardMemberEntity> result = instituteBoardMemberRepository.findByInstituteId(instituteId, pageable);
        return result.map(entity -> {
            InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(entity, InstituteBoardMemberResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        });
    }

    @Override
    public List<InstituteBoardMemberResponseDTO> getAllActive() {
        return instituteBoardMemberRepository.findAllActive().stream().map(entity -> {
            InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(entity, InstituteBoardMemberResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteBoardMemberResponseDTO getById(Long id) {
        InstituteBoardMemberEntity entity = instituteBoardMemberRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBoardMember not found with id: " + id));
        InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(entity, InstituteBoardMemberResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteBoardMemberResponseDTO updateBoardMember(Long id, InstituteBoardMemberUpdateRequestDTO requestDTO) {
        InstituteBoardMemberEntity existing = instituteBoardMemberRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBoardMember not found with id: " + id));

        if (requestDTO.getFullName() != null) {
            existing.setFullName(requestDTO.getFullName());
        }
        if (requestDTO.getRole() != null) {
            existing.setRole(requestDTO.getRole());
        }
        if (requestDTO.getEmail() != null) {
            existing.setEmail(requestDTO.getEmail());
        }
        if (requestDTO.getContactNumber() != null) {
            existing.setContactNumber(requestDTO.getContactNumber());
        }
        if (requestDTO.getTermStart() != null) {
            existing.setTermStart(requestDTO.getTermStart());
        }
        if (requestDTO.getTermEnd() != null) {
            existing.setTermEnd(requestDTO.getTermEnd());
        }
        if (requestDTO.getIsActive() != null) {
            existing.setIsActive(requestDTO.getIsActive());
        }

        InstituteBoardMemberEntity updated = instituteBoardMemberRepository.save(existing);
        InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(updated, InstituteBoardMemberResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteBoardMemberRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteBoardMember not found with id: " + id);
        }
        instituteBoardMemberRepository.deleteById(id);
    }

    @Override
    public List<InstituteBoardMemberResponseDTO> searchByKeyword(String keyword) {
        List<InstituteBoardMemberEntity> result = instituteBoardMemberRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(entity, InstituteBoardMemberResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }

    @Override
    public InstituteBoardMemberResponseDTO activate(Long id) {
        InstituteBoardMemberEntity entity = instituteBoardMemberRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBoardMember not found with id: " + id));
        entity.setIsActive(true);
        InstituteBoardMemberEntity updated = instituteBoardMemberRepository.save(entity);
        InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(updated, InstituteBoardMemberResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteBoardMemberResponseDTO deactivate(Long id) {
        InstituteBoardMemberEntity entity = instituteBoardMemberRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBoardMember not found with id: " + id));
        entity.setIsActive(false);
        InstituteBoardMemberEntity updated = instituteBoardMemberRepository.save(entity);
        InstituteBoardMemberResponseDTO dto = MapperUtil.mapObject(updated, InstituteBoardMemberResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }
}
