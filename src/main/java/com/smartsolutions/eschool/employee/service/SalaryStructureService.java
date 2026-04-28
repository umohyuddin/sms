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

    @Transactional
    public SalaryStructureResponseDTO create(SalaryStructureRequestDTO request) {
        log.info("Creating new SalaryStructure in database: for employeeType={}", request.getEmployeeTypeId());
        try {
            EmployeeTypeEntity employeeType = employeeTypeRepository.findById(request.getEmployeeTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("EmployeeType not found with id: " + request.getEmployeeTypeId()));

            // Close existing current salary structure
            salaryStructureRepository.findByEmployeeTypeId(employeeType.getId()).ifPresent(existing -> {
                log.info("Closing existing current SalaryStructure ID: {}", existing.getId());
                existing.setIsCurrent(false);
                existing.setEffectiveTo(request.getEffectiveFrom().minusDays(1));
                salaryStructureRepository.save(existing);
            });

            SalaryStructureEntity entity = new SalaryStructureEntity();
            entity.setEmployeeType(employeeType);
            entity.setBaseSalary(request.getBaseSalary());
            entity.setEffectiveFrom(request.getEffectiveFrom());
            entity.setEffectiveTo(null);
            entity.setIsCurrent(true);
            entity.setDeleted(false);

            SalaryStructureEntity saved = salaryStructureRepository.save(entity);
            log.info("Successfully created SalaryStructure: id={}", saved.getId());
            return toDto(saved);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while creating SalaryStructure", e);
            throw new CustomServiceException("Failed to create Salary Structure");
        }
    }

    public SalaryStructureResponseDTO getById(Long id) {
        log.info("Fetching SalaryStructure ID: {} from database", id);
        try {
            SalaryStructureEntity entity = salaryStructureRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with id: " + id));
            log.info("Successfully fetched SalaryStructure: id={}", entity.getId());
            return toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SalaryStructure ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Salary Structure");
        }
    }

    public List<SalaryStructureResponseDTO> getAllNonDeleted() {
        log.info("Fetching all non-deleted SalaryStructures from database");
        try {
            List<SalaryStructureEntity> entities = salaryStructureRepository.findAllNonDeleted();
            List<SalaryStructureResponseDTO> dtoList = entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryStructures", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SalaryStructures", e);
            throw new CustomServiceException("Failed to fetch Salary Structures");
        }
    }

    @Transactional
    public SalaryStructureResponseDTO update(Long id, @Valid SalaryStructureRequestDTO requestDTO) {
        log.info("Updating SalaryStructure ID: {} in database", id);
        try {
            SalaryStructureEntity existing = salaryStructureRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with id: " + id));

            EmployeeTypeEntity employeeType = employeeTypeRepository.findById(requestDTO.getEmployeeTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee Type not found with id: " + requestDTO.getEmployeeTypeId()));

            existing.setEmployeeType(employeeType);
            existing.setBaseSalary(requestDTO.getBaseSalary());
            existing.setEffectiveFrom(requestDTO.getEffectiveFrom());
            existing.setEffectiveTo(requestDTO.getEffectiveTo());

            SalaryStructureEntity updated = salaryStructureRepository.save(existing);
            log.info("Successfully updated SalaryStructure: id={}", updated.getId());
            return toDto(updated);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while updating SalaryStructure ID: {}", id, e);
            throw new CustomServiceException("Failed to update Salary Structure");
        }
    }

    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting SalaryStructure ID: {} from database", id);
        try {
            int affected = salaryStructureRepository.softDeleteById(id);
            if (affected == 0) {
                log.warn("SalaryStructure not found for deletion: id={}", id);
                throw new ResourceNotFoundException("Salary Structure not found with id: " + id);
            }
            log.info("Successfully soft deleted SalaryStructure: id={}", id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while deleting SalaryStructure ID: {}", id, e);
            throw new CustomServiceException("Failed to delete Salary Structure");
        }
    }

    @Transactional
    public SalaryStructureResponseDTO closeSalaryStructure(Long id) {
        log.info("Closing SalaryStructure ID: {}", id);
        try {
            SalaryStructureEntity existing = salaryStructureRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Salary Structure not found with id: " + id));

            if (!existing.getIsCurrent()) {
                log.warn("SalaryStructure ID: {} is already closed", id);
                throw new CustomServiceException("Salary Structure is already closed");
            }

            existing.setIsCurrent(false);
            existing.setEffectiveTo(LocalDate.now());

            SalaryStructureEntity closed = salaryStructureRepository.save(existing);
            log.info("Successfully closed SalaryStructure ID: {}", id);
            return toDto(closed);
        } catch (ResourceNotFoundException | CustomServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while closing SalaryStructure ID: {}", id, e);
            throw new CustomServiceException("Failed to close Salary Structure");
        }
    }

    public List<SalaryStructureResponseDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching SalaryStructures with keyword: '{}' in database", searchKey);
        try {
            List<SalaryStructureEntity> result = salaryStructureRepository.searchByKeyword(searchKey);
            List<SalaryStructureResponseDTO> dtoList = result.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryStructures based on search", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while searching SalaryStructures", e);
            throw new CustomServiceException("Failed to search Salary Structures");
        }
    }

    public List<SalaryStructureResponseDTO> searchComplex(Long employeeTypeId, String employeeTypeName, BigDecimal minSalary, BigDecimal maxSalary, LocalDate fromDate, LocalDate toDate, Boolean isCurrent) {
        log.info("Complex search for SalaryStructures: employeeTypeId={}, employeeTypeName={}, minSalary={}, maxSalary={}, fromDate={}, toDate={}, isCurrent={}",
                employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);
        try {
            List<SalaryStructureEntity> entities = salaryStructureRepository.searchSalaryStructures(employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);
            List<SalaryStructureResponseDTO> dtoList = entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryStructures based on complex search", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error during complex search for SalaryStructures", e);
            throw new CustomServiceException("Failed to search Salary Structures");
        }
    }

    public List<SalaryStructureDetailDTO> getAllSalaryStructures() {
        log.info("Fetching all SalaryStructures with details from database");
        try {
            List<SalaryStructureEntity> structures = salaryStructureRepository.findSalaryDetail();
            List<SalaryStructureDetailDTO> dtoList = structures.stream().map(this::toDetailDto).collect(Collectors.toList());
            log.info("Successfully fetched {} SalaryStructures with details", dtoList.size());
            return dtoList;
        } catch (Exception e) {
            log.error("Unexpected error while fetching SalaryStructures with details", e);
            throw new CustomServiceException("Failed to fetch Detailed Salary Structures");
        }
    }

    public SalaryStructureDetailDTO getSalaryStructureByEmployeeType(Long employeeTypeId) {
        log.info("Fetching current SalaryStructure with details for employeeTypeID: {}", employeeTypeId);
        try {
            SalaryStructureEntity ss = salaryStructureRepository.findCurrentSalaryByEmployeeType(employeeTypeId);
            if (ss == null) {
                log.warn("No current salary structure found for employee type ID: {}", employeeTypeId);
                throw new ResourceNotFoundException("No salary structure found for employee type ID: " + employeeTypeId);
            }
            SalaryStructureDetailDTO dto = toDetailDto(ss);
            log.info("Successfully fetched current SalaryStructure with details for employeeTypeID: {}", employeeTypeId);
            return dto;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching current SalaryStructure with details for employeeTypeID: {}", employeeTypeId, e);
            throw new CustomServiceException("Failed to fetch Salary Structure Details");
        }
    }

    public Long getTotalCount() {
        return salaryStructureRepository.count();
    }

    public Long countByEmployeeType(Long employeeTypeId) {
        try {
            EmployeeTypeEntity employeeType = employeeTypeRepository.findById(employeeTypeId)
                    .orElseThrow(() -> new ResourceNotFoundException("EmployeeType not found with id: " + employeeTypeId));
            return salaryStructureRepository.countByEmployeeType(employeeType);
        } catch (Exception e) {
            log.error("Error counting salary structures by employee type", e);
            return 0L;
        }
    }

    private SalaryStructureResponseDTO toDto(SalaryStructureEntity entity) {
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
    }

    private SalaryStructureDetailDTO toDetailDto(SalaryStructureEntity ss) {
        List<SalaryStructureComponentResponseDTO> componentDTOs = ss.getComponents().stream()
                .filter(c -> !c.getDeleted())
                .map(c -> SalaryStructureComponentResponseDTO.builder()
                        .id(c.getComponent().getId())
                        .salaryStructureId(ss.getId())
                        .componentId(c.getComponent().getId())
                        .componentName(c.getComponent().getName())
                        .componentType(c.getComponent().getType().toString())
                        .isPercentage(c.getComponent().getIsPercentage())
                        .value(c.getValue())
                        .build())
                .toList();

        BigDecimal totalEarnings = ss.getBaseSalary();
        BigDecimal totalDeductions = BigDecimal.ZERO;
        BigDecimal totalWithoutDeduction = ss.getBaseSalary();

        for (SalaryStructureComponentResponseDTO comp : componentDTOs) {
            BigDecimal compValue;
            if (Boolean.TRUE.equals(comp.getIsPercentage())) {
                compValue = ss.getBaseSalary().multiply(comp.getValue().divide(BigDecimal.valueOf(100)));
            } else {
                compValue = comp.getValue();
            }

            if ("EARNING".equalsIgnoreCase(comp.getComponentType())) {
                totalEarnings = totalEarnings.add(compValue);
                totalWithoutDeduction = totalWithoutDeduction.add(compValue);
            } else if ("DEDUCTION".equalsIgnoreCase(comp.getComponentType())) {
                totalDeductions = totalDeductions.add(compValue);
            }
        }

        BigDecimal netSalary = totalEarnings.subtract(totalDeductions);

        return SalaryStructureDetailDTO.builder()
                .id(ss.getId())
                .employeeTypeName(ss.getEmployeeType().getName())
                .baseSalary(ss.getBaseSalary())
                .effectiveFrom(ss.getEffectiveFrom())
                .effectiveTo(ss.getEffectiveTo())
                .components(componentDTOs)
                .totalEarnings(totalEarnings)
                .totalWithoutDeduction(totalWithoutDeduction)
                .totalDeductions(totalDeductions)
                .netSalary(netSalary)
                .build();
    }
}

