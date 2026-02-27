package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteSocialLinkErrors;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteSocialLinkEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

public class InstituteSocialLinkMapper {

    private InstituteSocialLinkMapper() {
        // prevent instantiation
    }

    public static InstituteSocialLinkResponseDTO toResponseDTO(InstituteSocialLinkEntity entity) {
        if (entity == null) {
            return null;
        }

        if (entity.getInstitute() == null) {
            throw new ApiException(InstituteSocialLinkErrors.INSTITUTE_NOT_FOUND,
                    "Institute relationship is missing in Social Link entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (entity.getPlatform() == null || entity.getPlatform().trim().isEmpty()) {
            throw new ApiException(InstituteSocialLinkErrors.DATABASE_ERROR,
                    "Platform field is null or empty in database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (entity.getUrl() == null || entity.getUrl().trim().isEmpty()) {
            throw new ApiException(InstituteSocialLinkErrors.DATABASE_ERROR, "URL field is null or empty in database",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        InstituteSocialLinkResponseDTO dto = new InstituteSocialLinkResponseDTO();
        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstitute().getId());
        dto.setPlatform(entity.getPlatform().trim());
        dto.setUrl(entity.getUrl().trim());

        return dto;
    }

    public static List<InstituteSocialLinkResponseDTO> toResponseDTOList(List<InstituteSocialLinkEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(InstituteSocialLinkMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static InstituteSocialLinkEntity toEntity(InstituteSocialLinkCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getPlatform() == null || dto.getPlatform().trim().isEmpty()) {
            throw new ApiException(InstituteSocialLinkErrors.INVALID_PLATFORM, "Platform name is required",
                    HttpStatus.BAD_REQUEST);
        }
        if (dto.getUrl() == null || dto.getUrl().trim().isEmpty()) {
            throw new ApiException(InstituteSocialLinkErrors.INVALID_URL, "Social link URL is required",
                    HttpStatus.BAD_REQUEST);
        }

        InstituteSocialLinkEntity entity = new InstituteSocialLinkEntity();
        entity.setPlatform(dto.getPlatform().trim());
        entity.setUrl(dto.getUrl().trim());

        return entity;
    }

    public static void updateEntityFromDTO(InstituteSocialLinkEntity entity, InstituteSocialLinkUpdateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getPlatform() != null) {
            if (dto.getPlatform().trim().isEmpty()) {
                throw new ApiException(InstituteSocialLinkErrors.INVALID_PLATFORM, "Platform name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setPlatform(dto.getPlatform().trim());
        }
        if (dto.getUrl() != null) {
            if (dto.getUrl().trim().isEmpty()) {
                throw new ApiException(InstituteSocialLinkErrors.INVALID_URL, "URL cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setUrl(dto.getUrl().trim());
        }
    }
}
