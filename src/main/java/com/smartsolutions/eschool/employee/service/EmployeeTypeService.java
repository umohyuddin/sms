package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeService(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    /* ================= CREATE ================= */

    @Transactional
    public EmployeeTypeResponseDTO create(@Valid EmployeeTypeRequestDTO requestDTO) {
        log.info("Creating new EmployeeType: {} in database", requestDTO.getName());
        try {
            if (employeeTypeRepository.existsByNameIgnoreCaseAndDeletedFalse(requestDTO.getName())) {
                log.warn("EmployeeType already exists with name: {}", requestDTO.getName());
                throw new CustomServiceException("Employee Type already exists with name: " + requestDTO.getName());
            }

            EmployeeTypeEntity entity = MapperUtil.mapObject(requestDTO, EmployeeTypeEntity.class);
            entity.setId(null);

            EmployeeTypeEntity saved = employeeTypeRepository.save(entity);
            log.info("Successfully created EmployeeType: id={}", saved.getId());

            return MapperUtil.mapObject(saved, EmployeeTypeResponseDTO.class);
        } catch (CustomServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while creating EmployeeType: {}", requestDTO.getName(), e);
            throw new CustomServiceException("Failed to create Employee Type");
        }
    }

    /* ================= READ ================= */

    public List<EmployeeTypeResponseDTO> getAll() {
        log.info("Fetching all non-deleted EmployeeTypes from database");
        try {
            List<EmployeeTypeEntity> entities = employeeTypeRepository.findAllNonDeleted();
            List<EmployeeTypeResponseDTO> response = MapperUtil.mapList(entities, EmployeeTypeResponseDTO.class);
            log.info("Successfully fetched {} EmployeeTypes", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching EmployeeTypes", e);
            throw new CustomServiceException("Unable to fetch Employee Types");
        }
    }

    public EmployeeTypeResponseDTO getById(Long id) {
        log.info("Fetching EmployeeType with id {} from database", id);
        try {
            EmployeeTypeEntity entity = employeeTypeRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee Type not found with id: " + id));
            log.info("Successfully fetched EmployeeType: id={}", entity.getId());
            return MapperUtil.mapObject(entity, EmployeeTypeResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching EmployeeType ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Employee Type by ID");
        }
    }

    public List<EmployeeTypeResponseDTO> getAllActive() {
        log.info("Fetching all active EmployeeTypes from database");
        try {
            List<EmployeeTypeEntity> entities = employeeTypeRepository.findAllActive();
            log.info("Successfully fetched {} active EmployeeTypes", entities.size());
            return MapperUtil.mapList(entities, EmployeeTypeResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while fetching active EmployeeTypes", e);
            throw new CustomServiceException("Failed to fetch active Employee Types");
        }
    }

    public List<EmployeeTypeResponseDTO> getAllInactive() {
        log.info("Fetching all inactive EmployeeTypes from database");
        try {
            List<EmployeeTypeEntity> entities = employeeTypeRepository.findAllInactive();
            log.info("Successfully fetched {} inactive EmployeeTypes", entities.size());
            return MapperUtil.mapList(entities, EmployeeTypeResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while fetching inactive EmployeeTypes", e);
            throw new CustomServiceException("Failed to fetch inactive Employee Types");
        }
    }

    /* ================= UPDATE ================= */

    @Transactional
    public EmployeeTypeResponseDTO update(Long id, @Valid EmployeeTypeRequestDTO requestDTO) {
        log.info("Updating EmployeeType ID: {} in database", id);
        try {
            EmployeeTypeEntity entity = employeeTypeRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee Type not found with id: " + id));

            entity.setName(requestDTO.getName());
            entity.setDescription(requestDTO.getDescription());
            entity.setActive(requestDTO.getActive());

            EmployeeTypeEntity updated = employeeTypeRepository.save(entity);
            log.info("Successfully updated EmployeeType: id={}", updated.getId());

            return MapperUtil.mapObject(updated, EmployeeTypeResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating EmployeeType ID: {}", id, e);
            throw new CustomServiceException("Failed to update Employee Type");
        }
    }

    /* ================= DELETE (SOFT) ================= */

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting EmployeeType ID: {} from database", id);
        try {
            int affected = employeeTypeRepository.softDeleteById(id);
            if (affected == 0) {
                log.warn("EmployeeType not found for deletion: id={}", id);
                throw new ResourceNotFoundException("Employee Type not found with id: " + id);
            }
            log.info("Successfully soft deleted EmployeeType: id={}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting EmployeeType ID: {}", id, e);
            throw new CustomServiceException("Failed to delete Employee Type");
        }
    }

    /* ================= SEARCH ================= */

    public List<EmployeeTypeResponseDTO> search(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching EmployeeTypes with keyword: '{}' in database", searchKey);
        try {
            List<EmployeeTypeEntity> result = employeeTypeRepository.searchByKeyword(searchKey);
            List<EmployeeTypeResponseDTO> response = MapperUtil.mapList(result, EmployeeTypeResponseDTO.class);
            log.info("Successfully fetched {} EmployeeTypes based on search", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching EmployeeTypes", e);
            throw new CustomServiceException("Failed to search Employee Types");
        }
    }

    /* ================= METRICS ================= */

    public long countAll() {
        return employeeTypeRepository.countAll();
    }

    public long countActive() {
        return employeeTypeRepository.countActive();
    }

    public long countInactive() {
        return employeeTypeRepository.countInactive();
    }

    /* ================= STATUS ================= */

    @Transactional
    public void activate(Long id) {
        log.info("Activating EmployeeType ID: {}", id);
        employeeTypeRepository.activateById(id);
    }

    @Transactional
    public void deactivate(Long id) {
        log.info("Deactivating EmployeeType ID: {}", id);
        employeeTypeRepository.deactivateById(id);
    }
}
