package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.student.dtos.guardian.requestDto.GuardianCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.guardian.responseDto.GuardianResponseDTO;
import com.smartsolutions.eschool.student.error.GuardianErrors;
import com.smartsolutions.eschool.student.mapper.GuardianMapper;
import com.smartsolutions.eschool.student.model.GuardianEntity;
import com.smartsolutions.eschool.student.model.StudentGuardianEntity;
import com.smartsolutions.eschool.student.repository.GuardianRepository;
import com.smartsolutions.eschool.student.repository.StudentGuardianRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GuardianService {

    private final GuardianRepository guardianRepository;
    private final StudentGuardianRepository studentGuardianRepository;

    public GuardianService(GuardianRepository guardianRepository, StudentGuardianRepository studentGuardianRepository) {
        this.guardianRepository = guardianRepository;
        this.studentGuardianRepository = studentGuardianRepository;
    }

    public List<GuardianResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] getAll() called - Fetching all for organization: {}", organizationId);
        List<GuardianEntity> result = guardianRepository.findAllByOrganizationId(organizationId);
        List<GuardianResponseDTO> responseDTOs = GuardianMapper.toResponseDTOList(result);
        log.info("[Service:GuardianService] getAll() succeeded - Found {} guardians", responseDTOs.size());
        return responseDTOs;
    }

    public List<GuardianResponseDTO> getActive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] getActive() called - organization: {}", organizationId);
        List<GuardianEntity> result = guardianRepository.findAllByOrganizationIdAndIsActiveTrue(organizationId);
        List<GuardianResponseDTO> responseDTOs = GuardianMapper.toResponseDTOList(result);
        log.info("[Service:GuardianService] getActive() succeeded - Found {} active guardians", responseDTOs.size());
        return responseDTOs;
    }

    public List<GuardianResponseDTO> getInactive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] getInactive() called - organization: {}", organizationId);
        List<GuardianEntity> result = guardianRepository.findAllByOrganizationIdAndIsActiveFalse(organizationId);
        List<GuardianResponseDTO> responseDTOs = GuardianMapper.toResponseDTOList(result);
        log.info("[Service:GuardianService] getInactive() succeeded - Found {} inactive guardians", responseDTOs.size());
        return responseDTOs;
    }

    public GuardianResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] getById() called - id: {}, organization: {}", id, organizationId);
        GuardianEntity entity = guardianRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GuardianErrors.GUARDIAN_NOT_FOUND, HttpStatus.NOT_FOUND));

        GuardianResponseDTO responseDTO = GuardianMapper.toResponseDTO(entity);
        log.info("[Service:GuardianService] getById() succeeded - Found guardian: {}", id);
        return responseDTO;
    }

    public List<GuardianResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] searchByKeyword() called - keyword: {}, organization: {}", keyword, organizationId);
        List<GuardianEntity> result = guardianRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<GuardianResponseDTO> responseDTOs = GuardianMapper.toResponseDTOList(result);
        log.info("[Service:GuardianService] searchByKeyword() succeeded - Found {} guardians", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = guardianRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GuardianErrors.GUARDIAN_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:GuardianService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public GuardianResponseDTO createGuardian(GuardianCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] createGuardian() called - Creating for organization: {}", organizationId);

        if (requestDTO.getCnic() != null && !requestDTO.getCnic().trim().isEmpty()) {
            if (guardianRepository.existsByOrganizationIdAndCnic(organizationId, requestDTO.getCnic().trim())) {
                throw new ApiException(GuardianErrors.DUPLICATE_GUARDIAN_CNIC, HttpStatus.CONFLICT);
            }
        }

        GuardianEntity entity = GuardianMapper.toEntity(requestDTO);

        GuardianEntity saved = guardianRepository.save(entity);

        // Save student-guardian mapping if studentId is provided
        if (requestDTO.getStudentId() != null) {
            if (studentGuardianRepository.existsByStudentIdAndGuardianIdAndOrganizationId(requestDTO.getStudentId(), saved.getId(), organizationId)) {
                log.warn("[Service:GuardianService] Mapping already exists for student {} and guardian {}", requestDTO.getStudentId(), saved.getId());
            } else {
                StudentGuardianEntity mapping = new StudentGuardianEntity();
                mapping.setOrganizationId(organizationId);
                mapping.setCampusId(requestDTO.getCampusId());
                mapping.setStudentId(requestDTO.getStudentId());
                mapping.setGuardianId(saved.getId());
                mapping.setIsPrimary(false); // Default to false, can be updated later
                mapping.setIsEmergencyContact(false);
                mapping.setStatus("ACTIVE");
                mapping.setDeleted(false);
                studentGuardianRepository.save(mapping);
                log.info("[Service:GuardianService] Student-guardian mapping created for student {} and guardian {}", requestDTO.getStudentId(), saved.getId());
            }
        }

        log.info("[Service:GuardianService] createGuardian() succeeded - created with id: {}", saved.getId());
        return GuardianMapper.toResponseDTO(saved);
    }

    @Transactional
    public GuardianResponseDTO updateGuardian(Long id, GuardianCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] updateGuardian() called - id: {}, organization: {}", id, organizationId);

        GuardianEntity existing = guardianRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GuardianErrors.GUARDIAN_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCnic() != null && !requestDTO.getCnic().trim().equals(existing.getCnic())) {
            if (guardianRepository.existsByOrganizationIdAndCnicAndIdNot(organizationId, requestDTO.getCnic().trim(), id)) {
                throw new ApiException(GuardianErrors.DUPLICATE_GUARDIAN_CNIC, HttpStatus.CONFLICT);
            }
        }

        GuardianMapper.updateEntityFromDTO(existing, requestDTO);

        GuardianEntity updated = guardianRepository.save(existing);

        log.info("[Service:GuardianService] updateGuardian() succeeded - id: {}", id);
        return GuardianMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] getStatistics() called - organization: {}", organizationId);

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalGuardians", guardianRepository.countByOrganizationId(organizationId));
        stats.put("activeGuardians", guardianRepository.countByOrganizationIdAndIsActiveTrue(organizationId));
        stats.put("inactiveGuardians", guardianRepository.countByOrganizationIdAndIsActiveFalse(organizationId));

        log.info("[Service:GuardianService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }

    public List<GuardianResponseDTO> getGuardiansByStudentId(Long studentId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianService] getGuardiansByStudentId() called - studentId: {}, organization: {}", studentId, organizationId);

        List<StudentGuardianEntity> mappings = studentGuardianRepository.findActiveByStudentIdAndOrganizationId(studentId, organizationId);
        List<Long> guardianIds = mappings.stream().map(StudentGuardianEntity::getGuardianId).collect(Collectors.toList());
        List<GuardianEntity> guardians = guardianRepository.findAllById(guardianIds);

        List<GuardianResponseDTO> responseDTOs = GuardianMapper.toResponseDTOList(guardians);
        log.info("[Service:GuardianService] getGuardiansByStudentId() succeeded - Found {} guardians for student {}", responseDTOs.size(), studentId);
        return responseDTOs;
    }
}
