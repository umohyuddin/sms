package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.global.configs.FeeConfig;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DesignationEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
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

    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    /* =========================
       CREATE
       ========================= */
    public DesignationResponseDTO createDesignation(@Valid DesignationRequestDTO requestDTO) {
        log.info("Creating new Designation: {}", requestDTO.getDesignationName());
        try {
            DesignationEntity entity = MapperUtil.mapObject(requestDTO, DesignationEntity.class);
            designationRepository.save(entity);
            log.info("Designation saved with id: {}", entity.getId());
            return MapperUtil.mapObject(entity, DesignationResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Designation", dae);
            throw new CustomServiceException("Failed to create Designation due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Designation", e);
            throw new CustomServiceException("Failed to create Designation");
        }
    }

    /* =========================
       GET BY ID
       ========================= */
    public DesignationResponseDTO getById(Long id) {
        log.info("Fetching Designation by ID: {}", id);
        try {
            DesignationEntity entity = designationRepository.findByIdActive(id)
                    .orElseThrow(() -> {
                        log.warn("Designation not found for id={}", id);
                        return new ResourceNotFoundException("Designation not found with id: " + id);
                    });
            return toDto(entity);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Designation", dae);
            throw new CustomServiceException("Unable to fetch Designation from database", dae);
        }
    }

    /* =========================
       GET ALL
       ========================= */
    public List<DesignationResponseDTO> getAll() {
        log.info("Fetching all Designations");
        try {
            List<DesignationEntity> entities = designationRepository.findAllActive();
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Designations", dae);
            throw new CustomServiceException("Unable to fetch Designations", dae);
        } catch (MappingException me) {
            log.error("Error mapping Designation Entity to DTO", me);
            throw new CustomServiceException("Error converting Designation data", me);
        }
    }

    /* =========================
       GET ALL ACTIVE / INACTIVE
       ========================= */
    public List<DesignationResponseDTO> getAllActive() {
        log.info("Fetching all active Designations");
        try {
            List<DesignationEntity> entities = designationRepository.findAllActive();
            return MapperUtil.mapList(entities, DesignationResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching active Designations", dae);
            throw new CustomServiceException("Unable to fetch active Designations", dae);
        }
    }

//    public List<DesignationResponseDTO> getAllInactive() {
//        log.info("Fetching all inactive Designations");
//        try {
//            List<DesignationEntity> entities = designationRepository.findAllNonActive();
//            return MapperUtil.mapList(entities, DesignationResponseDTO.class);
//        } catch (DataAccessException dae) {
//            log.error("Database error while fetching inactive Designations", dae);
//            throw new CustomServiceException("Unable to fetch inactive Designations", dae);
//        }
//    }

    /* =========================
       UPDATE
       ========================= */
//    public DesignationResponseDTO updateDesignation(Long id, @Valid DesignationRequestDTO requestDTO) {
//        log.info("Updating Designation with ID: {}", id);
//        try {
//            DesignationEntity existing = designationRepository.findByIdAndIsDeletedFalse(id)
//                    .orElseThrow(() -> new ResourceNotFoundException("Designation not found with id: " + id));
//
//            existing.setDesignationName(requestDTO.getDesignationName());
//            existing.setDesignationCode(requestDTO.getDesignationCode());
//            existing.setDescription(requestDTO.getDescription());
//            existing.setActive(requestDTO.getIsActive());
//            existing.setEmployeeType(requestDTO.getEmployeeType());
//            existing.setDepartment(requestDTO.getDepartment());
//
//            designationRepository.save(existing);
//            log.info("Designation updated successfully with ID: {}", existing.getId());
//            return toDto(existing);
//        } catch (DataAccessException dae) {
//            log.error("Database error while updating Designation", dae);
//            throw new CustomServiceException("Failed to update Designation due to database error", dae);
//        }
//    }

    /* =========================
       SOFT DELETE
       ========================= */
//    @Transactional
//    public int softDeleteById(Long id) {
//        log.info("Soft delete request received for Designation ID: {}", id);
//        try {
//            return designationRepository.softDeleteById(id);
//        } catch (DataAccessException dae) {
//            log.error("Database error while deleting Designation with ID {}", id, dae);
//            throw new CustomServiceException("Failed to delete Designation due to database error", dae);
//        }
//    }

    /* =========================
       SEARCH
       ========================= */
    public List<DesignationResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Designations by keyword: {}", keyword);
        try {
            List<DesignationEntity> entities = designationRepository.search(keyword);
            return MapperUtil.mapList(entities, DesignationResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while searching Designations", dae);
            throw new CustomServiceException("Unable to search Designations", dae);
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