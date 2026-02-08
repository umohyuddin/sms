package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeTypeRepository;
import com.smartsolutions.eschool.global.configs.FeeConfig;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.DepartmentRepository;
import com.smartsolutions.eschool.school.repository.DesignationRepository;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DesignationService {

    private final DesignationRepository designationRepository;
    private final EmployeeTypeRepository employeeTypeRepository;
    private  final DepartmentRepository departmentRepository;

    public DesignationService(DesignationRepository designationRepository, EmployeeTypeRepository employeeTypeRepository, DepartmentRepository departmentRepository) {
        this.designationRepository = designationRepository;
        this.employeeTypeRepository = employeeTypeRepository;
        this.departmentRepository = departmentRepository;
    }

    /* =========================
       CREATE
       ========================= */
    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        log.info("Creating new Designation in database: {}", requestDTO.getDesignationName());
        try {
            DesignationEntity entity = MapperUtil.mapObject(requestDTO, DesignationEntity.class);
            if (requestDTO.getDepartmentId() != null && requestDTO.getDepartmentId() > 0) {
                DepartmentEntity dept = departmentRepository.findById(requestDTO.getDepartmentId())
                        .orElseThrow(() -> {
                            log.warn("Department not found with ID: {}", requestDTO.getDepartmentId());
                            return new ResourceNotFoundException("Department not found");
                        });
                entity.setDepartment(dept);
            } else {
                entity.setDepartment(null); // optional department
            }

            DesignationEntity saved = designationRepository.save(entity);
            log.info("Designation saved successfully with ID: {}", saved.getId());
            return MapperUtil.mapObject(saved, DesignationResponseDTO.class);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while creating Designation", e);
            throw new CustomServiceException("Failed to create Designation");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public DesignationResponseDTO getById(Long id) {
        log.info("Fetching Designation with ID: {} from database", id);
        try {
            DesignationEntity entity = designationRepository.findByIdWithDetails(id)
                    .orElseThrow(() -> {
                        log.warn("Designation not found for ID: {}", id);
                        return new ResourceNotFoundException("Designation not found with id: " + id);
                    });
            log.info("Successfully fetched Designation: id={}", entity.getId());
            return toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Designation ID: {}", id, e);
            throw new CustomServiceException("Unable to fetch Designation from database", e);
        }
    }

    /* =========================
       GET ALL
       ========================= */
    public List<DesignationResponseDTO> getAll() {
        log.info("Fetching all active Designations from database");
        try {
            List<DesignationEntity> entities = designationRepository.findAllActive();
            log.info("Successfully fetched {} active Designations", entities.size());
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Unexpected error while fetching Designations", e);
            throw new CustomServiceException("Unexpected error occurred while fetching designations", e);
        }
    }

    /* =========================
       GET ALL ACTIVE / INACTIVE
       ========================= */
    public List<DesignationResponseDTO> getAllActive() {
        log.info("Fetching all enabled Designations from database");
        try {
            List<DesignationEntity> entities = designationRepository.findAllEnabled();
            log.info("Successfully fetched {} enabled Designations", entities.size());
            return MapperUtil.mapList(entities, DesignationResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while fetching enabled Designations", e);
            throw new CustomServiceException("Unable to fetch enabled Designations", e);
        }
    }

    /* =========================
       UPDATE
       ========================= */
    @Transactional
    public DesignationResponseDTO updateDesignation(Long id, @Valid DesignationRequestDTO requestDTO) {
        log.info("Updating Designation with ID: {} in database", id);

        try {
            // Validate ID
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("Invalid designation ID");
            }

            //  Fetch existing designation
            DesignationEntity existing = designationRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> {
                        log.warn("Designation not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Designation not found with ID: " + id);
                    });

            //  Validate mandatory fields
            if (requestDTO.getDesignationName() == null || requestDTO.getDesignationName().trim().isEmpty()) {
                throw new CustomServiceException("Designation name is required");
            }

            if (requestDTO.getEmployeeTypeId() == null) {
                throw new CustomServiceException("Employee Type is required");
            }

            //  Fetch associated EmployeeType entity
            EmployeeTypeEntity employeeType = employeeTypeRepository.findById(requestDTO.getEmployeeTypeId())
                    .orElseThrow(() -> {
                        log.warn("Employee Type not found with ID: {}", requestDTO.getEmployeeTypeId());
                        return new ResourceNotFoundException("Employee Type not found with ID: " + requestDTO.getEmployeeTypeId());
                    });

            // Fetch Department if provided
            DepartmentEntity department = null;
            if (requestDTO.getDepartmentId() != null && requestDTO.getDepartmentId() > 0) {
                 department = departmentRepository.findById(requestDTO.getDepartmentId())
                        .orElseThrow(() -> {
                            log.warn("Department not found with ID: {}", requestDTO.getDepartmentId());
                            return new ResourceNotFoundException("Department not found");
                        });
                existing.setDepartment(department);
            } else {
                existing.setDepartment(null); // optional department
            }

            // Update fields
            existing.setDesignationName(requestDTO.getDesignationName().trim());
            existing.setDesignationCode(requestDTO.getDesignationCode() != null ? requestDTO.getDesignationCode().trim() : null);
            existing.setDescription(requestDTO.getDescription() != null ? requestDTO.getDescription().trim() : null);
            existing.setActive(requestDTO.getActive() != null ? requestDTO.getActive() : true);
            existing.setEmployeeType(employeeType);
            existing.setDepartment(department);

            // 7️⃣ Save updated entity
            DesignationEntity saved = designationRepository.save(existing);
            log.info("Designation updated successfully with ID: {}", saved.getId());

            return toDto(saved);

        } catch (ResourceNotFoundException | IllegalArgumentException | CustomServiceException ex) {
            throw ex;
        } catch (Exception e) {
            log.error("Unexpected error while updating Designation ID: {}", id, e);
            throw new CustomServiceException("Unexpected error while updating Designation", e);
        }
    }

    /* =========================
       SEARCH
       ========================= */
    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Designations based on search from database with keyword: '{}'", searchKey);
            List<DesignationEntity> entities = designationRepository.search(searchKey);
            log.info("Successfully fetched {} Designations based on search", entities.size());
            return MapperUtil.mapList(entities, DesignationResponseDTO.class);
        } catch (Exception e) {
            log.error("Unexpected error while searching Designations", e);
            throw new CustomServiceException("Unable to search Designations", e);
        }
    }

    /* =========================
   GET BY DEPARTMENT
   ========================= */
    public List<DesignationResponseDTO> getByDepartmentId(Long departmentId) {
        log.info("Fetching Designations for Department ID: {} from database", departmentId);

        try {
            List<DesignationEntity> entities =
                    designationRepository.findActiveByDepartmentOrGlobal(departmentId);

            log.info("Successfully fetched {} Designations for Department ID: {}", entities.size(), departmentId);

            return entities.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Unexpected error while fetching Designations by Department ID: {}", departmentId, e);
            throw new CustomServiceException(
                    "Unable to fetch Designations for department id: " + departmentId,
                    e
            );
        }
    }


    /* =========================
       HELPER MAPPER
       ========================= */
    private DesignationResponseDTO toDto(DesignationEntity entity) {
        DesignationResponseDTO dto = new DesignationResponseDTO();
        dto.setId(entity.getId());
        dto.setDesignationCode(entity.getDesignationCode());
        dto.setDesignationName(entity.getDesignationName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        if (entity.getEmployeeType() != null) {
            dto.setEmployeeTypeId(entity.getEmployeeType().getId());
            dto.setEmployeeTypeName(entity.getEmployeeType().getName());
        }
        if (entity.getDepartment() != null) {
            dto.setDepartmentId(entity.getDepartment().getId());
            dto.setDepartmentName(entity.getDepartment().getDepartmentName());
        }
        return dto;
    }
}