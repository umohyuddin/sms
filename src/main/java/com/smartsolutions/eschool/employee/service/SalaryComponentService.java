package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import com.smartsolutions.eschool.employee.repository.SalaryComponentRepository;
import com.smartsolutions.eschool.global.enums.ComponentType;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SalaryComponentService {

    private final SalaryComponentRepository salaryComponentRepository;

    public SalaryComponentService(SalaryComponentRepository salaryComponentRepository) {
        this.salaryComponentRepository = salaryComponentRepository;
    }

    @Transactional
    public SalaryComponentResponseDTO createComponent(@Valid SalaryComponentRequestDTO requestDTO) {
        log.info("Creating new SalaryComponent in database: {}", requestDTO.getName());
        try {
            SalaryComponentEntity entity = MapperUtil.mapObject(requestDTO, SalaryComponentEntity.class);
            entity.setDeleted(false);
            SalaryComponentEntity saved = salaryComponentRepository.save(entity);
            log.info("Successfully created SalaryComponent: id={}", saved.getId());
            return MapperUtil.mapObject(saved, SalaryComponentResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while creating SalaryComponent", e);
            throw new CustomServiceException("Failed to create Salary Component");
        }
    }

    public SalaryComponentResponseDTO getById(Long id) {
        log.info("Fetching SalaryComponent ID: {} from database", id);
        try {
            SalaryComponentEntity entity = salaryComponentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Component not found with id: " + id));
            log.info("Successfully fetched SalaryComponent: id={}", entity.getId());
            return toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SalaryComponent ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Salary Component");
        }
    }

    public List<SalaryComponentResponseDTO> getAllNonDeleted() {
        log.info("Fetching all non-deleted SalaryComponents from database");
        try {
            List<SalaryComponentEntity> entities = salaryComponentRepository.findAllNonDeleted();
            List<SalaryComponentResponseDTO> dtoList = entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryComponents", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SalaryComponents", e);
            throw new CustomServiceException("Failed to fetch Salary Components");
        }
    }

    public List<SalaryComponentResponseDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching SalaryComponents with keyword: '{}' in database", searchKey);
        try {
            List<SalaryComponentEntity> result = salaryComponentRepository.searchByKeyword(searchKey);
            List<SalaryComponentResponseDTO> dtoList = result.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryComponents based on search", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while searching SalaryComponents", e);
            throw new CustomServiceException("Failed to search Salary Components");
        }
    }

    @Transactional
    public SalaryComponentResponseDTO updateComponent(Long id, @Valid SalaryComponentRequestDTO requestDTO) {
        log.info("Updating SalaryComponent ID: {} in database", id);
        try {
            SalaryComponentEntity existing = salaryComponentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Component not found with id: " + id));

            existing.setName(requestDTO.getName());
            existing.setType(requestDTO.getType());
            existing.setIsPercentage(requestDTO.getIsPercentage());

            SalaryComponentEntity updated = salaryComponentRepository.save(existing);
            log.info("Successfully updated SalaryComponent: id={}", updated.getId());
            return toDto(updated);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating SalaryComponent ID: {}", id, e);
            throw new CustomServiceException("Failed to update Salary Component");
        }
    }

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting SalaryComponent ID: {} from database", id);
        try {
            int affected = salaryComponentRepository.softDeleteById(id);
            if (affected == 0) {
                log.warn("SalaryComponent not found for deletion: id={}", id);
                throw new ResourceNotFoundException("Salary Component not found with id: " + id);
            }
            log.info("Successfully soft deleted SalaryComponent: id={}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting SalaryComponent ID: {}", id, e);
            throw new CustomServiceException("Failed to delete Salary Component");
        }
    }

    public Long getTotalCount() {
        return salaryComponentRepository.countAll();
    }

    private SalaryComponentResponseDTO toDto(SalaryComponentEntity entity) {
        SalaryComponentResponseDTO dto = new SalaryComponentResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setIsPercentage(entity.getIsPercentage());
        return dto;
    }

    public List<SalaryComponentResponseDTO> searchComplex(String name, ComponentType type, Boolean isPercentage) {
        String normalizedName = (name != null && !name.trim().isEmpty()) ? name.trim() : null;
        log.info("Complex search for SalaryComponents: name={}, type={}, isPercentage={}", normalizedName, type, isPercentage);
        try {
            List<SalaryComponentEntity> entities = salaryComponentRepository.search(normalizedName, type, isPercentage);
            log.info("Successfully fetched {} SalaryComponents based on complex search", entities.size());
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error during complex search for SalaryComponents", e);
            throw new CustomServiceException("Failed to search Salary Components");
        }
    }
}
