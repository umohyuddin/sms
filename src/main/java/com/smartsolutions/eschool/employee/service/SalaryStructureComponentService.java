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
//    public SalaryStructureComponentResponseDTO createComponent(SalaryStructureComponentRequestDTO requestDTO) {
//        log.info("Creating SalaryStructureComponent: {}", requestDTO);
//        try {
//            SalaryStructureComponentEntity entity = MapperUtil.mapObject(requestDTO, SalaryStructureComponentEntity.class);
//            componentRepository.save(entity);
//            log.info("Component saved with id={}", entity.getId());
//            return MapperUtil.mapObject(entity, SalaryStructureComponentResponseDTO.class);
//        } catch (DataAccessException dae) {
//            log.error("Database error while creating component", dae);
//            throw new CustomServiceException("Failed to create component due to database error");
//        } catch (Exception e) {
//            log.error("Unexpected error while creating component", e);
//            throw new CustomServiceException("Failed to create component");
//        }
//    }
    @Transactional
    public List<SalaryStructureComponentResponseDTO> createComponents(SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Creating SalaryStructureComponents for salaryStructureId={}", requestDTO.getSalaryStructureId());

        try {
            // Fetch SalaryStructure entity
            SalaryStructureEntity salaryStructure = salaryStructureRepository
                    .findById(requestDTO.getSalaryStructureId())
                    .orElseThrow(() -> new CustomServiceException("Salary structure not found"));

            List<SalaryStructureComponentEntity> entitiesToSave = requestDTO.getComponents()
                    .stream()
                    .map(compDto -> {
                        // Fetch component entity
                        SalaryComponentEntity componentEntity = salaryComponentRepository
                                .findById(compDto.getComponentId())
                                .orElseThrow(() -> new CustomServiceException(
                                        "Salary component not found for id=" + compDto.getComponentId()));

                        // Create mapping entity
                        SalaryStructureComponentEntity entity = new SalaryStructureComponentEntity();
                        entity.setSalaryStructure(salaryStructure);
                        entity.setComponent(componentEntity);
                        entity.setValue(compDto.getValue());
                        entity.setDeleted(false);
                        return entity;
                    })
                    .toList();

            // Save all mappings at once
            List<SalaryStructureComponentEntity> savedEntities = componentRepository.saveAll(entitiesToSave);

            log.info("Saved {} salary structure components", savedEntities.size());

            // Map to response DTO
            return savedEntities.stream()
                    .map(saved -> SalaryStructureComponentResponseDTO.builder()
                            .id(saved.getId())                           // SalaryStructureComponent ID
                            .salaryStructureId(saved.getSalaryStructure().getId())
                            .componentId(saved.getComponent().getId())
                            .componentName(saved.getComponent().getName())
                            .componentType(saved.getComponent().getType().toString())  // enum as string
                            .isPercentage(saved.getComponent().getIsPercentage())
                            .value(saved.getValue())
                            .build()
                    )
                    .toList();

        } catch (DataAccessException dae) {
            log.error("Database error while creating components", dae);
            throw new CustomServiceException("Failed to create components due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating components", e);
            throw new CustomServiceException("Failed to create components");
        }
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    public SalaryStructureComponentResponseDTO getById(Long id) {
        log.info("Fetching SalaryStructureComponent by ID={}", id);
        SalaryStructureComponentEntity entity = componentRepository.findByIdActive(id)
                .orElseThrow(() -> new ResourceNotFoundException("Component not found with id: " + id));
        return MapperUtil.mapObject(entity, SalaryStructureComponentResponseDTO.class);
    }

    // -------------------------
    // GET ALL ACTIVE
    // -------------------------
    @Transactional
    public List<SalaryStructureComponentResponseDTO> getAllActive() {
        log.info("Fetching all active SalaryStructureComponents");
        List<SalaryStructureComponentEntity> entities = componentRepository.findAllActive();
        return entities.stream()
                .map(entity -> MapperUtil.mapObject(entity, SalaryStructureComponentResponseDTO.class))
                .collect(Collectors.toList());
    }

    // -------------------------
    // GET BY SALARY STRUCTURE
    // -------------------------
    public List<SalaryStructureComponentResponseDTO> getBySalaryStructureId(Long salaryStructureId) {
        log.info("Fetching components for salaryStructureId={}", salaryStructureId);
        List<SalaryStructureComponentEntity> entities = componentRepository.findBySalaryStructureId(salaryStructureId);
        return entities.stream()
                .map(entity -> MapperUtil.mapObject(entity, SalaryStructureComponentResponseDTO.class))
                .collect(Collectors.toList());
    }

    // -------------------------
    // SEARCH BY COMPONENT NAME
    // -------------------------
    public List<SalaryStructureComponentResponseDTO> searchByName(Long salaryStructureId, String keyword) {
        log.info("Searching components in salaryStructureId={} with keyword={}", salaryStructureId, keyword);
        List<SalaryStructureComponentEntity> entities = componentRepository.searchByComponentName(salaryStructureId, keyword);
        return entities.stream()
                .map(entity -> MapperUtil.mapObject(entity, SalaryStructureComponentResponseDTO.class))
                .collect(Collectors.toList());
    }

    // -------------------------
    // UPDATE
    // -------------------------
    public SalaryStructureComponentResponseDTO updateComponent(Long id, SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Updating SalaryStructureComponent id={}", id);
        SalaryStructureComponentEntity existing = componentRepository.findByIdActive(id)
                .orElseThrow(() -> new ResourceNotFoundException("Component not found with id: " + id));
        try {
            //existing.setValue(requestDTO.getValue());
            // Optionally update salaryStructure or component if allowed
            // existing.setSalaryStructure(requestDTO.getSalaryStructure());
            // existing.setComponent(requestDTO.getComponent());

            componentRepository.save(existing);
            log.info("Component updated successfully with id={}", existing.getId());
            return MapperUtil.mapObject(existing, SalaryStructureComponentResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while updating component", dae);
            throw new CustomServiceException("Failed to update component due to database error");
        }
    }

    // -------------------------
    // SOFT DELETE
    // -------------------------
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft deleting SalaryStructureComponent id={}", id);
        int updated = componentRepository.softDeleteById(id);
        if (updated == 0) {
            throw new ResourceNotFoundException("Component not found with id: " + id);
        }
        log.info("Component soft deleted id={}", id);
    }

    // -------------------------
    // COUNT ACTIVE BY SALARY STRUCTURE
    // -------------------------
    public Long countActiveBySalaryStructureId(Long salaryStructureId) {
        return componentRepository.countActiveBySalaryStructureId(salaryStructureId);
    }


    @Transactional
    public List<SalaryStructureComponentResponseDTO> updateComponentsByEmployeeType(
            Long employeeTypeId,
            SalaryStructureComponentRequestDTO requestDTO
    ) {
        log.info("Updating SalaryStructureComponents for employeeTypeId={}", employeeTypeId);

        try {
            // 1️⃣ Fetch SalaryStructure using employeeTypeId
            SalaryStructureEntity salaryStructure = salaryStructureRepository
                    .findByEmployeeTypeId(employeeTypeId)
                    .orElseThrow(() ->
                            new CustomServiceException(
                                    "Salary structure not found for employeeTypeId=" + employeeTypeId
                            ));

            Long salaryStructureId = salaryStructure.getId();

            // 2️⃣ Fetch existing component mappings (non-deleted)
            List<SalaryStructureComponentEntity> existingMappings =
                    componentRepository.findActiveBySalaryStructureId(salaryStructureId);

            // Map existing mappings by componentId
            Map<Long, SalaryStructureComponentEntity> existingMap =
                    existingMappings.stream()
                            .collect(Collectors.toMap(
                                    e -> e.getComponent().getId(),
                                    e -> e
                            ));

            List<SalaryStructureComponentEntity> entitiesToSave = new ArrayList<>();

            // 3️⃣ Create or Update component mappings
            for (SalaryComponentMappingRequestDto compDto : requestDTO.getComponents()) {

                SalaryComponentEntity componentEntity = salaryComponentRepository
                        .findById(compDto.getComponentId())
                        .orElseThrow(() ->
                                new CustomServiceException(
                                        "Salary component not found for id=" + compDto.getComponentId()
                                ));

                SalaryStructureComponentEntity entity =
                        existingMap.get(compDto.getComponentId());

                if (entity != null) {
                    // 🔄 Update existing mapping
                    entity.setValue(compDto.getValue());
                    entity.setDeleted(false);
                } else {
                    // ➕ Create new mapping
                    entity = new SalaryStructureComponentEntity();
                    entity.setSalaryStructure(salaryStructure);
                    entity.setComponent(componentEntity);
                    entity.setValue(compDto.getValue());
                    entity.setDeleted(false);
                }

                entitiesToSave.add(entity);
            }

            // 4️⃣ Soft-delete removed components
            Set<Long> incomingComponentIds = requestDTO.getComponents()
                    .stream()
                    .map(SalaryComponentMappingRequestDto::getComponentId)
                    .collect(Collectors.toSet());

            existingMappings.stream()
                    .filter(e -> !incomingComponentIds.contains(e.getComponent().getId()))
                    .forEach(e -> e.setDeleted(true));

            // 5️⃣ Save all changes (insert + update + soft-delete)
            List<SalaryStructureComponentEntity> savedEntities =
                    componentRepository.saveAll(
                            Stream.concat(
                                    entitiesToSave.stream(),
                                    existingMappings.stream()
                                            .filter(SalaryStructureComponentEntity::getDeleted)
                            ).toList()
                    );

            log.info("Successfully updated salary structure components for employeeTypeId={}", employeeTypeId);

            // 6️⃣ Map response DTO (exclude deleted)
            return savedEntities.stream()
                    .filter(e -> !e.getDeleted())
                    .map(saved -> SalaryStructureComponentResponseDTO.builder()
                            .id(saved.getId())
                            .salaryStructureId(saved.getSalaryStructure().getId())
                            .componentId(saved.getComponent().getId())
                            .componentName(saved.getComponent().getName())
                            .componentType(saved.getComponent().getType().toString())
                            .isPercentage(saved.getComponent().getIsPercentage())
                            .value(saved.getValue())
                            .build()
                    )
                    .toList();

        } catch (DataAccessException dae) {
            log.error("Database error while updating salary structure components", dae);
            throw new CustomServiceException(
                    "Failed to update salary structure components due to database error"
            );
        } catch (Exception e) {
            log.error("Unexpected error while updating salary structure components", e);
            throw new CustomServiceException(
                    "Failed to update salary structure components"
            );
        }
    }



}
