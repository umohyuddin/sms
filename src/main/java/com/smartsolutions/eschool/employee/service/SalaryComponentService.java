package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.SalaryComponentErrors;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.mapper.SalaryComponentMapper;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.employee.repository.SalaryComponentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SalaryComponentService {
    private final SalaryComponentRepository salaryComponentRepository;

    public SalaryComponentService(SalaryComponentRepository salaryComponentRepository) {
        this.salaryComponentRepository = salaryComponentRepository;
    }

    public List<SalaryComponentResponseDTO> getAll() {
        log.info("[Service:SalaryComponentService] getAll() called - Fetching all salary components");
        List<SalaryComponentEntity> result = salaryComponentRepository.findAllNotDeleted();
        List<SalaryComponentResponseDTO> responseDTOs = SalaryComponentMapper.toResponseDTOList(result);
        log.info("[Service:SalaryComponentService] getAll() succeeded - Found {} salary components", responseDTOs.size());
        return responseDTOs;
    }

    public List<SalaryComponentResponseDTO> getByOrganizationId(Long organizationId) {
        log.info("[Service:SalaryComponentService] getByOrganizationId() called - Fetching salary components for organization: {}", organizationId);
        List<SalaryComponentEntity> result = salaryComponentRepository.findByOrganizationId(organizationId);
        List<SalaryComponentResponseDTO> responseDTOs = SalaryComponentMapper.toResponseDTOList(result);
        log.info("[Service:SalaryComponentService] getByOrganizationId() succeeded - Found {} active salary components", responseDTOs.size());
        return responseDTOs;
    }

    public SalaryComponentResponseDTO getById(Long id) {
        log.info("[Service:SalaryComponentService] getById() called - id: {}", id);
        SalaryComponentEntity entity = salaryComponentRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(SalaryComponentErrors.SALARY_COMPONENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        SalaryComponentResponseDTO responseDTO = SalaryComponentMapper.toResponseDTO(entity);
        log.info("[Service:SalaryComponentService] getById() succeeded - Found salary component: {}", id);
        return responseDTO;
    }

    public List<SalaryComponentResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:SalaryComponentService] searchByKeyword() called - keyword: {}", keyword);
        List<SalaryComponentEntity> result = salaryComponentRepository.searchByKeyword(keyword);
        List<SalaryComponentResponseDTO> responseDTOs = SalaryComponentMapper.toResponseDTOList(result);
        log.info("[Service:SalaryComponentService] searchByKeyword() succeeded - Found {} salary components", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:SalaryComponentService] softDeleteById() called - id: {}", id);

        int result = salaryComponentRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(SalaryComponentErrors.SALARY_COMPONENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:SalaryComponentService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public SalaryComponentResponseDTO create(SalaryComponentRequestDTO requestDTO) {
        log.info("[Service:SalaryComponentService] create() called - Creating: {}", requestDTO.getName());

        // Organization ID would technically be fed strictly from context since it's a ScopeAuditableEntity field mechanism in production.
        // Assuming context populates entity.setOrganizationId(currentOrgId) behind the scenes in AuditableEntity hooks,
        // we will proceed to just mock a standard context organizationId or let the JPA auditor handle it.
        // For the sake of validation logic in create, if you need explicit cross-checking by org ID:
        
        // This is a placeholder representing how you'd get the contextual Org ID
        Long currentOrganizationId = 1L; // Replace with your actual ContextHolder mechanism

        if (requestDTO.getName() != null && !requestDTO.getName().trim().isEmpty()) {
            if (salaryComponentRepository.existsByNameAndOrganizationId(requestDTO.getName().trim(), currentOrganizationId)) {
                throw new ApiException(SalaryComponentErrors.DUPLICATE_SALARY_COMPONENT_NAME, "Salary component name already exists in this organization", HttpStatus.CONFLICT);
            }
        }

        SalaryComponentEntity entity = SalaryComponentMapper.toEntity(requestDTO);
        SalaryComponentEntity saved = salaryComponentRepository.save(entity);

        log.info("[Service:SalaryComponentService] create() succeeded - Created with id: {}", saved.getId());
        return SalaryComponentMapper.toResponseDTO(saved);
    }

    @Transactional
    public SalaryComponentResponseDTO update(Long id, SalaryComponentRequestDTO requestDTO) {
        log.info("[Service:SalaryComponentService] update() called - id: {}", id);

        SalaryComponentEntity existing = salaryComponentRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(SalaryComponentErrors.SALARY_COMPONENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getName() != null && !requestDTO.getName().trim().equals(existing.getName())) {
            if (salaryComponentRepository.existsByNameAndOrganizationIdAndIdNot(requestDTO.getName().trim(), existing.getOrganizationId(), id)) {
                throw new ApiException(SalaryComponentErrors.DUPLICATE_SALARY_COMPONENT_NAME, "Salary component name already exists in this organization", HttpStatus.CONFLICT);
            }
        }

        SalaryComponentMapper.updateEntityFromDTO(existing, requestDTO);
        SalaryComponentEntity updated = salaryComponentRepository.save(existing);

        log.info("[Service:SalaryComponentService] update() succeeded - id: {}", id);
        return SalaryComponentMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:SalaryComponentService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalSalaryComponents", salaryComponentRepository.countAllNotDeleted());

        log.info("[Service:SalaryComponentService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
