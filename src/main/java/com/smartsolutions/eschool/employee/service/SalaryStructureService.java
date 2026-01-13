package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureDetailDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureResponseDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.model.SalaryStructureEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import com.smartsolutions.eschool.employee.repository.SalaryStructureRepository;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SalaryStructureService {

    private final SalaryStructureRepository salaryStructureRepository;
    private final EmployeeTypeRepository employeeTypeRepository;

    public SalaryStructureService(SalaryStructureRepository salaryStructureRepository, EmployeeTypeRepository employeeTypeRepository) {
        this.salaryStructureRepository = salaryStructureRepository;
        this.employeeTypeRepository = employeeTypeRepository;
    }

    /* =========================
       CREATE
       ========================= */
    public SalaryStructureResponseDTO createSalaryStructure(SalaryStructureRequestDTO request) {

        EmployeeTypeEntity employeeType = employeeTypeRepository.findById(request.getEmployeeTypeId()).orElseThrow(() -> new IllegalArgumentException("Invalid employee type"));

        salaryStructureRepository.findByEmployeeTypeIdAndIsCurrentTrue(employeeType.getId()).ifPresent(existing -> {
            existing.setIsCurrent(false);
            existing.setEffectiveTo(request.getEffectiveFrom().minusDays(1));
        });

        SalaryStructureEntity entity = new SalaryStructureEntity();
        entity.setEmployeeType(employeeType);
        entity.setBaseSalary(request.getBaseSalary());
        entity.setEffectiveFrom(request.getEffectiveFrom());
        entity.setEffectiveTo(null);
        entity.setIsCurrent(true);

        entity = salaryStructureRepository.save(entity);
        return MapperUtil.mapObject(entity, SalaryStructureResponseDTO.class);

    }

//    public SalaryStructureResponseDTO createSalaryStructure(@Valid SalaryStructureRequestDTO requestDTO) {
//        log.info("Creating Salary Structure for Employee Type ID: {}", requestDTO.getEmployeeTypeId());
//        try {
//            EmployeeTypeEntity employeeType = employeeTypeRepository.findById(requestDTO.getEmployeeTypeId())
//                    .orElseThrow(() -> new ResourceNotFoundException(
//                            "Employee Type not found with id: " + requestDTO.getEmployeeTypeId()
//                    ));
//
//            SalaryStructureEntity entity = MapperUtil.mapObject(requestDTO, SalaryStructureEntity.class);
//            entity.setEmployeeType(employeeType);
//            salaryStructureRepository.save(entity);
//
//            log.info("Salary Structure saved with ID: {}", entity.getId());
//            return MapperUtil.mapObject(entity, SalaryStructureResponseDTO.class);
//        } catch (DataAccessException dae) {
//            log.error("Database error while creating Salary Structure", dae);
//            throw new CustomServiceException("Failed to create Salary Structure due to database error");
//        } catch (Exception e) {
//            log.error("Unexpected error while creating Salary Structure", e);
//            throw new CustomServiceException("Failed to create Salary Structure");
//        }
//    }

    /* =========================
       GET BY ID
       ========================= */
    public SalaryStructureResponseDTO getById(Long id) {
        log.info("Fetching Salary Structure by ID: {}", id);
        try {
            SalaryStructureEntity entity = salaryStructureRepository.findActiveById(id).orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with id: " + id));
            return MapperUtil.mapObject(entity, SalaryStructureResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Salary Structure", dae);
            throw new CustomServiceException("Unable to fetch Salary Structure", dae);
        } catch (MappingException me) {
            log.error("Mapping error while fetching Salary Structure", me);
            throw new CustomServiceException("Error converting Salary Structure data", me);
        }
    }

    /* =========================
       GET ALL ACTIVE
       ========================= */
    @Transactional(readOnly = true)
    public List<SalaryStructureResponseDTO> getAllActive() {
        log.info("Fetching all active Salary Structures");
        try {
            List<SalaryStructureEntity> entities = salaryStructureRepository.findAllActive();
            return entities.stream().map(entity -> MapperUtil.mapObject(entity, SalaryStructureResponseDTO.class)).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Salary Structures", dae);
            throw new CustomServiceException("Unable to fetch Salary Structures", dae);
        }
    }

    /* =========================
       UPDATE
       ========================= */
    @Transactional
    public SalaryStructureResponseDTO updateSalaryStructure(Long id, @Valid SalaryStructureRequestDTO requestDTO) {
        log.info("Updating Salary Structure with ID: {}", id);
        try {
            SalaryStructureEntity existing = salaryStructureRepository.findActiveById(id).orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with id: " + id));

            EmployeeTypeEntity employeeType = employeeTypeRepository.findById(requestDTO.getEmployeeTypeId()).orElseThrow(() -> new ResourceNotFoundException("Employee Type not found with id: " + requestDTO.getEmployeeTypeId()));

            existing.setEmployeeType(employeeType);
            existing.setBaseSalary(requestDTO.getBaseSalary());
            existing.setEffectiveFrom(requestDTO.getEffectiveFrom());
            existing.setEffectiveTo(requestDTO.getEffectiveTo());

            salaryStructureRepository.save(existing);

            log.info("Salary Structure updated successfully with ID: {}", existing.getId());
            return MapperUtil.mapObject(existing, SalaryStructureResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while updating Salary Structure", dae);
            throw new CustomServiceException("Failed to update Salary Structure due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating Salary Structure", e);
            throw new CustomServiceException("Failed to update Salary Structure", e);
        }
    }

    /* =========================
       SOFT DELETE
       ========================= */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft delete Salary Structure ID: {}", id);
        try {
            salaryStructureRepository.softDeleteById(id);
        } catch (DataAccessException dae) {
            log.error("Database error while soft deleting Salary Structure with ID {}", id, dae);
            throw new CustomServiceException("Failed to delete Salary Structure due to database error", dae);
        }
    }

    @Transactional
    public SalaryStructureResponseDTO closeSalaryStructure(Long id) {
        SalaryStructureEntity existing = salaryStructureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with id: " + id));

        if (!existing.getIsCurrent()) {
            throw new CustomServiceException("Salary Structure is already closed");
        }

        existing.setIsCurrent(false); // mark as closed
        existing.setEffectiveTo(LocalDate.now()); // optional: set today's date as end

        salaryStructureRepository.save(existing);

        return MapperUtil.mapObject(existing, SalaryStructureResponseDTO.class);
    }

    public List<SalaryStructureResponseDTO> searchSalaryStructures(Long employeeTypeId, String employeeTypeName, BigDecimal minSalary, BigDecimal maxSalary, LocalDate fromDate, LocalDate toDate, Boolean isCurrent) {
        // Fetch entities from repository
        List<SalaryStructureEntity> entities = salaryStructureRepository.searchSalaryStructures(employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);

        // Convert to DTOs
        return entities.stream().map(entity -> {
            SalaryStructureResponseDTO dto = new SalaryStructureResponseDTO();
            dto.setId(entity.getId());
            dto.setEmployeeTypeId(entity.getEmployeeType().getId());
            dto.setEmployeeTypeName(entity.getEmployeeType().getName());
            dto.setBaseSalary(entity.getBaseSalary());
            dto.setEffectiveFrom(entity.getEffectiveFrom());
            dto.setEffectiveTo(entity.getEffectiveTo());
            dto.setIsCurrent(entity.getIsCurrent());
            dto.setDeleted(entity.getDeleted());
            return dto;
        }).collect(Collectors.toList());
    }


    public List<SalaryStructureDetailDTO> getAllSalaryStructures() {
        List<SalaryStructureEntity> structures = salaryStructureRepository.findSalaryDetail();

        List<SalaryStructureDetailDTO> dtos = structures.
                stream().
                map(ss -> SalaryStructureDetailDTO.builder()
                        .id(ss.getId()).
                        employeeTypeName(ss.getEmployeeType().getName()).
                        baseSalary(ss.getBaseSalary()).
                        effectiveFrom(ss.getEffectiveFrom()).
                        effectiveTo(ss.getEffectiveTo()).
                        components(ss.getComponents().stream().map(c -> SalaryStructureComponentResponseDTO.builder().
                                id(c.getComponent().getId()).
                                salaryStructureId(ss.getId()).
                                componentName(c.getComponent().getName()).
                                componentType(c.getComponent().getType().toString())       // ComponentType enum
                .isPercentage(c.getComponent().getIsPercentage()).value(c.getValue()).build()).toList()).build()).toList();

        return dtos;
    }

    public SalaryStructureDetailDTO getSalaryStructureByEmployeeType(Long employeeTypeId) {

        SalaryStructureEntity ss =
                salaryStructureRepository.findCurrentSalaryByEmployeeType(employeeTypeId);

        return SalaryStructureDetailDTO.builder()
                .id(ss.getId())
                .employeeTypeName(ss.getEmployeeType().getName())
                .baseSalary(ss.getBaseSalary())
                .effectiveFrom(ss.getEffectiveFrom())
                .effectiveTo(ss.getEffectiveTo())
                .components(
                        ss.getComponents().stream()
                                .map(c -> SalaryStructureComponentResponseDTO.builder()
                                        .id(c.getComponent().getId())
                                        .salaryStructureId(ss.getId())
                                        .componentId(c.getComponent().getId())
                                        .componentName(c.getComponent().getName())
                                        .componentType(c.getComponent().getType().toString())
                                        .isPercentage(c.getComponent().getIsPercentage())
                                        .value(c.getValue())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }



}

