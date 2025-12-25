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
        log.info("Creating EmployeeType: {}", requestDTO.getName());

        try {
            if (employeeTypeRepository.existsByNameIgnoreCaseAndDeletedFalse(requestDTO.getName())) {
                throw new CustomServiceException("Employee Type already exists with name: " + requestDTO.getName());
            }

            EmployeeTypeEntity entity = MapperUtil.mapObject(requestDTO, EmployeeTypeEntity.class);
            entity.setId(null);

            EmployeeTypeEntity saved = employeeTypeRepository.save(entity);
            log.info("EmployeeType created with id={}", saved.getId());

            return MapperUtil.mapObject(saved, EmployeeTypeResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while creating EmployeeType", dae);
            throw new CustomServiceException("Failed to create Employee Type", dae);
        }
    }

    /* ================= READ ================= */

    public List<EmployeeTypeResponseDTO> getAll() {
        try {
            log.info("Fetching all Employee Types");
            return MapperUtil.mapList(employeeTypeRepository.findAllNonDeleted(), EmployeeTypeResponseDTO.class);
        } catch (MappingException | DataAccessException e) {
            log.error("Error fetching Employee Types", e);
            throw new CustomServiceException("Unable to fetch Employee Types", e);
        }
    }

    public EmployeeTypeResponseDTO getById(Long id) {
        log.info("Fetching EmployeeType with id={}", id);

        EmployeeTypeEntity entity = employeeTypeRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Employee Type not found with id: " + id));

        return MapperUtil.mapObject(entity, EmployeeTypeResponseDTO.class);
    }

    public List<EmployeeTypeResponseDTO> getAllActive() {
        return MapperUtil.mapList(employeeTypeRepository.findAllActive(), EmployeeTypeResponseDTO.class);
    }

    public List<EmployeeTypeResponseDTO> getAllInactive() {
        return MapperUtil.mapList(employeeTypeRepository.findAllInactive(), EmployeeTypeResponseDTO.class);
    }

    /* ================= UPDATE ================= */

    @Transactional
    public EmployeeTypeResponseDTO update(Long id, @Valid EmployeeTypeRequestDTO requestDTO) {
        log.info("Updating EmployeeType with id={}", id);

        EmployeeTypeEntity entity = employeeTypeRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Employee Type not found with id: " + id));

        entity.setName(requestDTO.getName());
        entity.setDescription(requestDTO.getDescription());
        entity.setActive(requestDTO.getActive());

        EmployeeTypeEntity updated = employeeTypeRepository.save(entity);
        log.info("EmployeeType updated successfully with id={}", updated.getId());

        return MapperUtil.mapObject(updated, EmployeeTypeResponseDTO.class);
    }

    /* ================= DELETE (SOFT) ================= */

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting EmployeeType with id={}", id);

        int affected = employeeTypeRepository.softDeleteById(id);
        if (affected == 0) {
            throw new ResourceNotFoundException("Employee Type not found with id: " + id);
        }
    }

    /* ================= SEARCH ================= */

    public List<EmployeeTypeResponseDTO> search(String keyword) {
        return MapperUtil.mapList(employeeTypeRepository.searchByKeyword(keyword), EmployeeTypeResponseDTO.class);
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
        employeeTypeRepository.activateById(id);
    }

    @Transactional
    public void deactivate(Long id) {
        employeeTypeRepository.deactivateById(id);
    }
}
