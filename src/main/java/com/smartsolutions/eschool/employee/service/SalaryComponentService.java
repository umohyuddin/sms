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

    /* =========================
       CREATE
       ========================= */
    public SalaryComponentResponseDTO createComponent(@Valid SalaryComponentRequestDTO requestDTO) {
        log.info("Creating Salary Component: {}", requestDTO.getName());
        try {
            SalaryComponentEntity entity = MapperUtil.mapObject(requestDTO, SalaryComponentEntity.class);
            salaryComponentRepository.save(entity);
            log.info("Salary Component saved with id={}", entity.getId());
            return MapperUtil.mapObject(entity, SalaryComponentResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Salary Component", dae);
            throw new CustomServiceException("Failed to create Salary Component due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Salary Component", e);
            throw new CustomServiceException("Failed to create Salary Component");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public SalaryComponentResponseDTO getById(Long id) {
        log.info("Fetching Salary Component by ID={}", id);
        try {
            SalaryComponentEntity entity = salaryComponentRepository.findByIdActive(id)
                    .orElseThrow(() -> {
                        log.warn("Salary Component not found for id={}", id);
                        return new ResourceNotFoundException("Salary Component not found with id: " + id);
                    });
            return toDto(entity);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Salary Component", dae);
            throw new CustomServiceException("Unable to fetch Salary Component from database", dae);
        }
    }

    /* =========================
       GET ALL ACTIVE
       ========================= */
    public List<SalaryComponentResponseDTO> getAllActive() {
        log.info("Fetching all active Salary Components");
        try {
            List<SalaryComponentEntity> entities = salaryComponentRepository.findAllActive();
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Salary Components", dae);
            throw new CustomServiceException("Unable to fetch Salary Components", dae);
        }
    }

    /* =========================
       GET ALL INACTIVE
       ========================= */
    public List<SalaryComponentResponseDTO> getAllInactive() {
        log.info("Fetching all inactive Salary Components");
        try {
            List<SalaryComponentEntity> entities = salaryComponentRepository.findAllInactive();
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching inactive Salary Components", dae);
            throw new CustomServiceException("Unable to fetch inactive Salary Components", dae);
        }
    }

    /* =========================
       SEARCH BY NAME
       ========================= */
    public List<SalaryComponentResponseDTO> searchByName(String keyword) {
        log.info("Searching Salary Components with keyword={}", keyword);
        try {
            List<SalaryComponentEntity> entities = salaryComponentRepository.searchByName(keyword);
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while searching Salary Components", dae);
            throw new CustomServiceException("Unable to search Salary Components", dae);
        }
    }

    /* =========================
       GET BY TYPE
       ========================= */
//    public List<SalaryComponentResponseDTO> getByType(ComponentType type) {
//        log.info("Fetching Salary Components of type={}", type);
//        try {
//            List<SalaryComponentEntity> entities = salaryComponentRepository.findByType(type);
//            return entities.stream().map(this::toDto).collect(Collectors.toList());
//        } catch (DataAccessException dae) {
//            log.error("Database error while fetching Salary Components by type", dae);
//            throw new CustomServiceException("Unable to fetch Salary Components by type", dae);
//        }
//    }

    /* =========================
       UPDATE
       ========================= */
    public SalaryComponentResponseDTO updateComponent(Long id, @Valid SalaryComponentRequestDTO requestDTO) {
        log.info("Updating Salary Component with ID={}", id);
        try {
            SalaryComponentEntity existing = salaryComponentRepository.findByIdActive(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Component not found with id: " + id));

            existing.setName(requestDTO.getName());
            //existing.setType(requestDTO.getType());
            existing.setIsPercentage(requestDTO.getIsPercentage());

            salaryComponentRepository.save(existing);
            log.info("Salary Component updated successfully with ID={}", existing.getId());
            return toDto(existing);
        } catch (DataAccessException dae) {
            log.error("Database error while updating Salary Component", dae);
            throw new CustomServiceException("Failed to update Salary Component due to database error", dae);
        }
    }

    /* =========================
       SOFT DELETE
       ========================= */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft delete request for Salary Component ID={}", id);
        try {
            int updated = salaryComponentRepository.softDeleteById(id);
            if (updated == 0) {
                log.warn("Salary Component not found or already deleted with ID={}", id);
                throw new ResourceNotFoundException("Salary Component not found with id: " + id);
            }
            log.info("Salary Component soft deleted with ID={}", id);
        } catch (DataAccessException dae) {
            log.error("Database error while soft deleting Salary Component", dae);
            throw new CustomServiceException("Failed to delete Salary Component due to database error", dae);
        }
    }

    /* =========================
       COUNT ACTIVE / INACTIVE
       ========================= */
    public Long countActive() {
        return salaryComponentRepository.countActive();
    }

    public Long countInactive() {
        return salaryComponentRepository.countInactive();
    }

    /* =========================
       HELPER: ENTITY -> DTO
       ========================= */
    private SalaryComponentResponseDTO toDto(SalaryComponentEntity entity) {
        SalaryComponentResponseDTO dto = new SalaryComponentResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        //dto.setType(entity.getType());
        dto.setIsPercentage(entity.getIsPercentage());
        return dto;
    }
}