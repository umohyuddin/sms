package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.responseMappers.RoleMapper;
import com.smartsolutions.eschool.institute.error.RoleErrors;
import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;
import com.smartsolutions.eschool.user.repository.PermissionRepository;
import com.smartsolutions.eschool.user.repository.RoleRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleService(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    public List<RoleResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:RoleService] getAll() called - Fetching all roles for organization: {}", organizationId);
        List<RoleEntity> result = roleRepository.findByOrganizationId(organizationId);
        List<RoleResponseDTO> responseDTOs = RoleMapper.toResponseDTOList(result);
        log.info("[Service:RoleService] getAll() succeeded - Found {} roles", responseDTOs.size());
        return responseDTOs;
    }

    public List<RoleResponseDTO> getAll(Long organizationId) {
        log.info("[Service:RoleService] getAll() called - Fetching all roles for organization: {}", organizationId);
        List<RoleEntity> result = roleRepository.findByOrganizationId(organizationId);
        List<RoleResponseDTO> responseDTOs = RoleMapper.toResponseDTOList(result);
        log.info("[Service:RoleService] getAll() succeeded - Found {} roles", responseDTOs.size());
        return responseDTOs;
    }

    public RoleResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:RoleService] getById() called - id: {}, organization: {}", id, organizationId);
        RoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(RoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));

        RoleResponseDTO responseDTO = RoleMapper.toResponseDTO(entity);
        log.info("[Service:RoleService] getById() succeeded - Found role: {}", id);
        return responseDTO;
    }

    public RoleResponseDTO getById(Long id, Long organizationId) {
        log.info("[Service:RoleService] getById() called - id: {}, organization: {}", id, organizationId);
        RoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(RoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));

        RoleResponseDTO responseDTO = RoleMapper.toResponseDTO(entity);
        log.info("[Service:RoleService] getById() succeeded - Found role: {}", id);
        return responseDTO;
    }

    public List<RoleResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:RoleService] searchByKeyword() called - keyword: {}, organization: {}", keyword,
                organizationId);
        List<RoleEntity> result = roleRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<RoleResponseDTO> responseDTOs = RoleMapper.toResponseDTOList(result);
        log.info("[Service:RoleService] searchByKeyword() succeeded - Found {} roles", responseDTOs.size());
        return responseDTOs;
    }

    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("[Service:RoleService] searchByKeyword() called - keyword: {}, organization: {}", keyword,
                organizationId);
        List<RoleEntity> result = roleRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<RoleResponseDTO> responseDTOs = RoleMapper.toResponseDTOList(result);
        log.info("[Service:RoleService] searchByKeyword() succeeded - Found {} roles", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:RoleService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = roleRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(RoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:RoleService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public void deleteById(Long id, Long organizationId) {
        log.info("[Service:RoleService] deleteById() called - id: {}, organization: {}", id, organizationId);

        int result = roleRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(RoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:RoleService] deleteById() succeeded - id: {}", id);
    }

    @Transactional
    public RoleResponseDTO createRole(RoleRequestDTO requestDTO) {
        Long organizationId = requestDTO.getOrganizationId();
        if (organizationId == null) {
            organizationId = SecurityUtils.getCurrentOrganizationId();
        }
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:RoleService] createRole() called - Creating role for organization: {}", organizationId);

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (roleRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
                throw new ApiException(RoleErrors.DUPLICATE_ROLE_CODE, HttpStatus.CONFLICT);
            }
        }

        RoleEntity entity = RoleMapper.toEntity(requestDTO);
        entity.setOrganizationId(organizationId);

        if (requestDTO.getPermissionIds() != null && !requestDTO.getPermissionIds().isEmpty()) {
            log.info("[Service:RoleService] createRole() - Assigning {} permissions", requestDTO.getPermissionIds().size());
            entity.setPermissions(
                    new HashSet<>(permissionRepository.findAllById(requestDTO.getPermissionIds())));
        }

        RoleEntity saved = roleRepository.save(entity);

        log.info("[Service:RoleService] createRole() succeeded - Role created with id: {}", saved.getId());
        return RoleMapper.toResponseDTO(saved);
    }

    @Transactional
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        return updateRoleInternal(id, organizationId, requestDTO);
    }

    @Transactional
    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        return updateRoleInternal(id, organizationId, requestDTO);
    }

    private RoleResponseDTO updateRoleInternal(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        log.info("[Service:RoleService] updateRole() called - id: {}, organization: {}", id, organizationId);

        RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(RoleErrors.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (roleRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId,
                    requestDTO.getCode().trim(), id)) {
                throw new ApiException(RoleErrors.DUPLICATE_ROLE_CODE, HttpStatus.CONFLICT);
            }
        }

        RoleMapper.updateEntityFromDTO(existing, requestDTO);

        if (requestDTO.getPermissionIds() != null) {
            log.info("[Service:RoleService] updateRole() - Updating permissions for role: {}", id);
            existing.setPermissions(
                    new HashSet<>(permissionRepository.findAllById(requestDTO.getPermissionIds())));
        }

        RoleEntity updated = roleRepository.save(existing);

        log.info("[Service:RoleService] updateRole() succeeded - id: {}", id);
        return RoleMapper.toResponseDTO(updated);
    }

    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        log.info("[Service:RoleService] getByOrganizationId() called - organization: {}", organizationId);
        return getAll(organizationId);
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(RoleErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:RoleService] getStatistics() called - organization: {}", organizationId);

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalRoles", roleRepository.countByOrganizationId(organizationId));
        stats.put("activeRoles", roleRepository.countByOrganizationIdAndActiveTrue(organizationId));
        stats.put("inactiveRoles", roleRepository.countByOrganizationIdAndActiveFalse(organizationId));

        log.info("[Service:RoleService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
