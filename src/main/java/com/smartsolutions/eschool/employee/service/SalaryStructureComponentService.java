package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request.SalaryStructureComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.SalaryStructureComponentEntity;
import com.smartsolutions.eschool.employee.repository.SalaryStructureComponentRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SalaryStructureComponentService {

    private final SalaryStructureComponentRepository componentRepository;

    public SalaryStructureComponentService(SalaryStructureComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    // -------------------------
    // CREATE
    // -------------------------
    public SalaryStructureComponentResponseDTO createComponent(SalaryStructureComponentRequestDTO requestDTO) {
        log.info("Creating SalaryStructureComponent: {}", requestDTO);
        try {
            SalaryStructureComponentEntity entity = MapperUtil.mapObject(requestDTO, SalaryStructureComponentEntity.class);
            componentRepository.save(entity);
            log.info("Component saved with id={}", entity.getId());
            return MapperUtil.mapObject(entity, SalaryStructureComponentResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating component", dae);
            throw new CustomServiceException("Failed to create component due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating component", e);
            throw new CustomServiceException("Failed to create component");
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
            existing.setValue(requestDTO.getValue());
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

}
