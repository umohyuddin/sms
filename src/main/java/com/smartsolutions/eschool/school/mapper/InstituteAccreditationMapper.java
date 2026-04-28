package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteAccreditationErrors;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteAccreditationEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for InstituteAccreditationEntity to DTOs and vice versa.
 */
public class InstituteAccreditationMapper {

    private InstituteAccreditationMapper() {
        // prevent instantiation
    }

    public static InstituteAccreditationResponseDTO toResponseDTO(InstituteAccreditationEntity entity) {
        if (entity == null) {
            return null;
        }

        InstituteAccreditationResponseDTO dto = new InstituteAccreditationResponseDTO();
        dto.setId(entity.getId());
        if (entity.getInstitute() != null) {
            dto.setInstituteId(entity.getInstitute().getId());
        }
        dto.setAuthorityName(entity.getAuthorityName());
        dto.setLicenseNumber(entity.getLicenseNumber());
        dto.setValidFrom(entity.getValidFrom());
        dto.setValidTo(entity.getValidTo());
        dto.setIsActive(entity.getIsActive());

        return dto;
    }

    public static List<InstituteAccreditationResponseDTO> toResponseDTOList(
            List<InstituteAccreditationEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(InstituteAccreditationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static InstituteAccreditationEntity toEntity(InstituteAccreditationCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getAuthorityName() == null || dto.getAuthorityName().trim().isEmpty()) {
            throw new ApiException(InstituteAccreditationErrors.INVALID_AUTHORITY, "Authority name is required",
                    HttpStatus.BAD_REQUEST);
        }
        if (dto.getLicenseNumber() == null || dto.getLicenseNumber().trim().isEmpty()) {
            throw new ApiException(InstituteAccreditationErrors.INVALID_LICENSE, "License number is required",
                    HttpStatus.BAD_REQUEST);
        }

        InstituteAccreditationEntity entity = new InstituteAccreditationEntity();
        entity.setAuthorityName(dto.getAuthorityName().trim());
        entity.setLicenseNumber(dto.getLicenseNumber().trim());
        entity.setValidFrom(dto.getValidFrom());
        entity.setValidTo(dto.getValidTo());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(InstituteAccreditationEntity entity,
            InstituteAccreditationUpdateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getAuthorityName() != null) {
            if (dto.getAuthorityName().trim().isEmpty()) {
                throw new ApiException(InstituteAccreditationErrors.INVALID_AUTHORITY, "Authority name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setAuthorityName(dto.getAuthorityName().trim());
        }
        if (dto.getLicenseNumber() != null) {
            if (dto.getLicenseNumber().trim().isEmpty()) {
                throw new ApiException(InstituteAccreditationErrors.INVALID_LICENSE, "License number cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setLicenseNumber(dto.getLicenseNumber().trim());
        }
        if (dto.getValidFrom() != null) {
            entity.setValidFrom(dto.getValidFrom());
        }
        if (dto.getValidTo() != null) {
            entity.setValidTo(dto.getValidTo());
        }
        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
