package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteDocumentErrors;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteDocumentEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for InstituteDocumentEntity to DTOs and vice versa.
 */
public class InstituteDocumentMapper {

    private InstituteDocumentMapper() {
        // prevent instantiation
    }

    public static InstituteDocumentResponseDTO toResponseDTO(InstituteDocumentEntity entity) {
        if (entity == null) {
            return null;
        }

        if (entity.getInstitute() == null) {
            throw new ApiException(InstituteDocumentErrors.INSTITUTE_NOT_FOUND,
                    "Institute relationship is missing in Document entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        InstituteDocumentResponseDTO dto = new InstituteDocumentResponseDTO();
        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstitute().getId());
        dto.setDocumentType(entity.getDocumentType());
        dto.setFileName(entity.getFileName());
        dto.setFileUrl(entity.getFileUrl());
        dto.setExpiryDate(entity.getExpiryDate());

        return dto;
    }

    public static List<InstituteDocumentResponseDTO> toResponseDTOList(List<InstituteDocumentEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(InstituteDocumentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static InstituteDocumentEntity toEntity(InstituteDocumentCreateRequestDTO requestDTO,
            InstituteEntity institute) {
        if (requestDTO == null) {
            return null;
        }

        if (institute == null) {
            throw new ApiException(InstituteDocumentErrors.INSTITUTE_NOT_FOUND, "Institute is required",
                    HttpStatus.BAD_REQUEST);
        }

        InstituteDocumentEntity entity = new InstituteDocumentEntity();
        entity.setInstitute(institute);
        entity.setDocumentType(requestDTO.getDocumentType());
        entity.setFileName(requestDTO.getFileName());
        entity.setFileUrl(requestDTO.getFileUrl());
        entity.setExpiryDate(requestDTO.getExpiryDate());
        entity.setIsDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(InstituteDocumentEntity entity, InstituteDocumentUpdateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getDocumentType() != null) {
            entity.setDocumentType(dto.getDocumentType());
        }

        if (dto.getFileName() != null) {
            entity.setFileName(dto.getFileName());
        }

        if (dto.getFileUrl() != null) {
            entity.setFileUrl(dto.getFileUrl());
        }

        if (dto.getExpiryDate() != null) {
            entity.setExpiryDate(dto.getExpiryDate());
        }
    }
}
