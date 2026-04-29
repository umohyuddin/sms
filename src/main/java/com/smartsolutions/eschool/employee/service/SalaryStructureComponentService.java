package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request.SalaryComponentMappingRequestDto;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request.SalaryStructureComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.employee.model.SalaryStructureComponentEntity;
import com.smartsolutions.eschool.employee.model.SalaryStructureEntity;
import com.smartsolutions.eschool.employee.repository.SalaryComponentRepository;
import com.smartsolutions.eschool.employee.repository.SalaryStructureComponentRepository;
import com.smartsolutions.eschool.employee.repository.SalaryStructureRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class SalaryStructureComponentService {

    private final SalaryStructureComponentRepository componentRepository;
    private final SalaryStructureRepository salaryStructureRepository;

    private final SalaryComponentRepository salaryComponentRepository;
    public SalaryStructureComponentService(SalaryStructureComponentRepository componentRepository, SalaryStructureRepository salaryStructureRepository, SalaryComponentRepository salaryComponentRepository) {
        this.componentRepository = componentRepository;
        this.salaryStructureRepository = salaryStructureRepository;

        this.salaryComponentRepository = salaryComponentRepository;
    }

    // -------------------------
    // CREATE
    // -------------------------
    @Transactional
    public List<SalaryStructureComponentResponseDTO> create(SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Creating SalaryStructureComponents for salaryStructureId={}", requestDTO.getSalaryStructureId());
        try {
            SalaryStructureEntity salaryStructure = salaryStructureRepository
                    .findById(requestDTO.getSalaryStructureId())
                    .orElseThrow(() -> new ResourceNotFoundException("Salary structure not found with id: " + requestDTO.getSalaryStructureId()));

            List<SalaryStructureComponentEntity> entitiesToSave = requestDTO.getComponents()
                    .stream()
                    .map(compDto -> {
                        SalaryComponentEntity componentEntity = salaryComponentRepository
                                .findById(compDto.getComponentId())
                                .orElseThrow(() -> new ResourceNotFoundException("Salary component not found for id=" + compDto.getComponentId()));

                        SalaryStructureComponentEntity entity = new SalaryStructureComponentEntity();
                        entity.setSalaryStructure(salaryStructure);
                        entity.setComponent(componentEntity);
                        entity.setValue(compDto.getValue());
                        entity.setDeleted(false);
                        return entity;
                    })
                    .toList();

            List<SalaryStructureComponentEntity> savedEntities = componentRepository.saveAll(entitiesToSave);
            log.info("Successfully created {} salary structure components", savedEntities.size());

            return savedEntities.stream().map(this::toDto).toList();
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while creating components", e);
            throw new CustomServiceException("Failed to create components");
        }
    }

    public SalaryStructureComponentResponseDTO getById(Long id) {
        log.info("Fetching SalaryStructureComponent ID: {} from database", id);
        try {
            SalaryStructureComponentEntity entity = componentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Structure Component not found with id: " + id));
            log.info("Successfully fetched SalaryStructureComponent: id={}", entity.getId());
            return toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching component ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch component");
        }
    }

    public List<SalaryStructureComponentResponseDTO> getAllNonDeleted() {
        log.info("Fetching all non-deleted SalaryStructureComponents from database");
        try {
            List<SalaryStructureComponentEntity> entities = componentRepository.findAllNonDeleted();
            List<SalaryStructureComponentResponseDTO> dtoList = entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryStructureComponents", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching components", e);
            throw new CustomServiceException("Failed to fetch components");
        }
    }

    public List<SalaryStructureComponentResponseDTO> getBySalaryStructureId(Long salaryStructureId) {
        log.info("Fetching components for salaryStructureId: {} from database", salaryStructureId);
        try {
            List<SalaryStructureComponentEntity> entities = componentRepository.findBySalaryStructureId(salaryStructureId);
            List<SalaryStructureComponentResponseDTO> dtoList = entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} components for salaryStructureId: {}", dtoList.size(), salaryStructureId);
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching components for salaryStructureId: {}", salaryStructureId, e);
            throw new CustomServiceException("Failed to fetch components by salary structure");
        }
    }

    public List<SalaryStructureComponentResponseDTO> searchByKeyword(Long salaryStructureId, String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching components in salaryStructureId={} with keyword='{}' in database", salaryStructureId, searchKey);
        try {
            List<SalaryStructureComponentEntity> entities = componentRepository.searchByKeyword(salaryStructureId, searchKey);
            List<SalaryStructureComponentResponseDTO> dtoList = entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} components based on search", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while searching components", e);
            throw new CustomServiceException("Failed to search components");
        }
    }

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting SalaryStructureComponent ID: {} from database", id);
        try {
            int affected = componentRepository.softDeleteById(id);
            if (affected == 0) {
                log.warn("SalaryStructureComponent not found for deletion: id={}", id);
                throw new ResourceNotFoundException("Salary Structure Component not found with id: " + id);
            }
            log.info("Successfully soft deleted SalaryStructureComponent: id={}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting component ID: {}", id, e);
            throw new CustomServiceException("Failed to delete component");
        }
    }

    @Transactional
    public List<SalaryStructureComponentResponseDTO> updateComponentsByEmployeeType(Long employeeTypeId, SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Updating SalaryStructureComponents for employeeTypeId: {} in database", employeeTypeId);
        try {
            SalaryStructureEntity salaryStructure = salaryStructureRepository.findByEmployeeTypeId(employeeTypeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary structure not found for employeeTypeId=" + employeeTypeId));

            Long salaryStructureId = salaryStructure.getId();
            List<SalaryStructureComponentEntity> existingMappings = componentRepository.findBySalaryStructureId(salaryStructureId);
            Map<Long, SalaryStructureComponentEntity> existingMap = existingMappings.stream().collect(Collectors.toMap(e -> e.getComponent().getId(), e -> e));

            List<SalaryStructureComponentEntity> entitiesToSave = new ArrayList<>();
            for (SalaryComponentMappingRequestDto compDto : requestDTO.getComponents()) {
                SalaryComponentEntity componentEntity = salaryComponentRepository.findById(compDto.getComponentId())
                        .orElseThrow(() -> new ResourceNotFoundException("Salary component not found for id=" + compDto.getComponentId()));

                SalaryStructureComponentEntity entity = existingMap.get(compDto.getComponentId());
                if (entity != null) {
                    entity.setValue(compDto.getValue());
                    entity.setDeleted(false);
                } else {
                    entity = new SalaryStructureComponentEntity();
                    entity.setSalaryStructure(salaryStructure);
                    entity.setComponent(componentEntity);
                    entity.setValue(compDto.getValue());
                    entity.setDeleted(false);
                }
                entitiesToSave.add(entity);
            }

            Set<Long> incomingComponentIds = requestDTO.getComponents().stream().map(SalaryComponentMappingRequestDto::getComponentId).collect(Collectors.toSet());
            existingMappings.stream().filter(e -> !incomingComponentIds.contains(e.getComponent().getId())).forEach(e -> e.setDeleted(true));

            List<SalaryStructureComponentEntity> resultEntities = componentRepository.saveAll(
                    Stream.concat(entitiesToSave.stream(), existingMappings.stream().filter(SalaryStructureComponentEntity::getDeleted)).toList()
            );

            log.info("Successfully updated salary structure components for employeeTypeId={}", employeeTypeId);
            return resultEntities.stream().filter(e -> !e.getDeleted()).map(this::toDto).toList();
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating salary structure components", e);
            throw new CustomServiceException("Failed to update salary structure components");
        }
    }

    public Long countBySalaryStructureId(Long salaryStructureId) {
        log.info("Counting components for salaryStructureId: {}", salaryStructureId);
        return componentRepository.countBySalaryStructureId(salaryStructureId);
    }

    public Long getTotalCount() {
        return componentRepository.count();
    }

    private SalaryStructureComponentResponseDTO toDto(SalaryStructureComponentEntity entity) {
        return SalaryStructureComponentResponseDTO.builder()
                .id(entity.getId())
                .salaryStructureId(entity.getSalaryStructure().getId())
                .componentId(entity.getComponent().getId())
                .componentName(entity.getComponent().getName())
                .componentType(entity.getComponent().getType().toString())
                .isPercentage(entity.getComponent().getIsPercentage())
                .value(entity.getValue())
                .build();
    }
}




