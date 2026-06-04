package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.student.error.GuardianErrors;
import com.smartsolutions.eschool.student.dtos.guardian.requestDto.GuardianCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.guardian.responseDto.GuardianResponseDTO;
import com.smartsolutions.eschool.student.model.GuardianEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GuardianMapper {

    private GuardianMapper() {
        // prevent instantiation
    }

    public static GuardianResponseDTO toResponseDTO(GuardianEntity entity) {
        if (entity == null) {
            return null;
        }

        GuardianResponseDTO dto = new GuardianResponseDTO();
        dto.setId(entity.getId());
        dto.setCampusId(entity.getCampusId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setFullName(entity.getFullName());
        dto.setRelationId(entity.getRelationId());
        dto.setCnic(entity.getCnic());
        dto.setPhone(entity.getPhone());
        dto.setAlternatePhone(entity.getAlternatePhone());
        dto.setEmail(entity.getEmail());
        dto.setOccupation(entity.getOccupation());
        dto.setOrganization(entity.getOrganization());
        dto.setAddress(entity.getAddress());
        dto.setIsActive(entity.getIsActive());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.isDeleted());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<GuardianResponseDTO> toResponseDTOList(List<GuardianEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(GuardianMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static GuardianEntity toEntity(GuardianCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getFirstName() == null || dto.getFirstName().trim().isEmpty()) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian first name is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getLastName() == null || dto.getLastName().trim().isEmpty()) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian last name is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getFullName() == null || dto.getFullName().trim().isEmpty()) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian full name is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getRelationId() == null) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian relation is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getCnic() == null || dto.getCnic().trim().isEmpty()) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian CNIC is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getPhone() == null || dto.getPhone().trim().isEmpty()) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian phone is required", HttpStatus.BAD_REQUEST);
        }

        if (dto.getStatus() != null && !(dto.getStatus().equals("ACTIVE") || dto.getStatus().equals("INACTIVE") || dto.getStatus().equals("BLOCKED"))) {
            throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Status must be ACTIVE, INACTIVE, or BLOCKED", HttpStatus.BAD_REQUEST);
        }

        GuardianEntity entity = new GuardianEntity();
        entity.setCampusId(dto.getCampusId());
        entity.setFirstName(dto.getFirstName().trim());
        entity.setMiddleName(dto.getMiddleName() != null ? dto.getMiddleName().trim() : null);
        entity.setLastName(dto.getLastName().trim());
        entity.setFullName(dto.getFullName().trim());
        entity.setRelationId(dto.getRelationId());
        entity.setCnic(dto.getCnic().trim());
        entity.setPhone(dto.getPhone().trim());
        entity.setAlternatePhone(dto.getAlternatePhone() != null ? dto.getAlternatePhone().trim() : null);
        entity.setEmail(dto.getEmail() != null ? dto.getEmail().trim() : null);
        entity.setOccupation(dto.getOccupation() != null ? dto.getOccupation().trim() : null);
        entity.setOrganization(dto.getOrganization() != null ? dto.getOrganization().trim() : null);
        entity.setAddress(dto.getAddress() != null ? dto.getAddress().trim() : null);
        
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setStatus(dto.getStatus() != null ? dto.getStatus() : "ACTIVE");
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(GuardianEntity entity, GuardianCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCampusId() != null) {
            entity.setCampusId(dto.getCampusId());
        }

        if (dto.getFirstName() != null) {
            if (dto.getFirstName().trim().isEmpty()) {
                throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian first name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setFirstName(dto.getFirstName().trim());
        }

        if (dto.getMiddleName() != null) {
            entity.setMiddleName(dto.getMiddleName().trim());
        }

        if (dto.getLastName() != null) {
            if (dto.getLastName().trim().isEmpty()) {
                throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian last name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setLastName(dto.getLastName().trim());
        }

        if (dto.getFullName() != null) {
            if (dto.getFullName().trim().isEmpty()) {
                throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian full name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setFullName(dto.getFullName().trim());
        }

        if (dto.getRelationId() != null) {
            entity.setRelationId(dto.getRelationId());
        }

        if (dto.getCnic() != null) {
            if (dto.getCnic().trim().isEmpty()) {
                throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian CNIC cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCnic(dto.getCnic().trim());
        }

        if (dto.getPhone() != null) {
            if (dto.getPhone().trim().isEmpty()) {
                throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Guardian phone cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setPhone(dto.getPhone().trim());
        }

        if (dto.getAlternatePhone() != null) {
            entity.setAlternatePhone(dto.getAlternatePhone().trim());
        }

        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail().trim());
        }

        if (dto.getOccupation() != null) {
            entity.setOccupation(dto.getOccupation().trim());
        }

        if (dto.getOrganization() != null) {
            entity.setOrganization(dto.getOrganization().trim());
        }

        if (dto.getAddress() != null) {
            entity.setAddress(dto.getAddress().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }

        if (dto.getStatus() != null) {
             if (!(dto.getStatus().equals("ACTIVE") || dto.getStatus().equals("INACTIVE") || dto.getStatus().equals("BLOCKED"))) {
                throw new ApiException(GuardianErrors.INVALID_GUARDIAN_DATA, "Status must be ACTIVE, INACTIVE, or BLOCKED", HttpStatus.BAD_REQUEST);
             }
             entity.setStatus(dto.getStatus());
        }
    }
}
