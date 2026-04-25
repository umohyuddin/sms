package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InstituteMapper {

    public static InstituteResponseDTO toResponseDTO(InstituteEntity entity) {
        if (entity == null) {
            return null;
        }

        InstituteResponseDTO dto = new InstituteResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setContactNumber(entity.getContactNumber());
        dto.setEmail(entity.getEmail());
        dto.setWebsite(entity.getWebsite());
        dto.setTagLine(entity.getTagLine());
        dto.setLogo(entity.getLogo());
        dto.setEstablishedDate(entity.getEstablishedDate());

        if (entity.getCountry() != null) {
            dto.setCountryId(entity.getCountry().getId());
            dto.setCountryName(entity.getCountry().getCountryName());
        }

        if (entity.getProvince() != null) {
            dto.setProvinceId(entity.getProvince().getId());
            dto.setProvinceName(entity.getProvince().getName());
        }

        if (entity.getCity() != null) {
            dto.setCityId(entity.getCity().getId());
            dto.setCityName(entity.getCity().getName());
        }

        if (entity.getCampuses() != null) {
            dto.setCampusCount((long) entity.getCampuses().size());
        } else {
            dto.setCampusCount(0L);
        }

        return dto;
    }

    public static List<InstituteResponseDTO> toResponseDTOList(List<InstituteEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(InstituteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static InstituteEntity toEntity(com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new com.smartsolutions.eschool.global.error.ApiException(
                    com.smartsolutions.eschool.institute.error.InstituteErrors.INVALID_INSTITUTE_DATA,
                    "Institute name is required",
                    org.springframework.http.HttpStatus.BAD_REQUEST);
        }

        InstituteEntity entity = new InstituteEntity();
        entity.setName(dto.getName().trim());
        entity.setAddress(dto.getAddress());
        entity.setContactNumber(dto.getContactNumber());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setTagLine(dto.getTagLine());
        entity.setLogo(dto.getLogo());
        entity.setEstablishedDate(dto.getEstablishedDate());
        
        return entity;
    }

    public static void updateEntityFromDTO(InstituteEntity entity, com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new com.smartsolutions.eschool.global.error.ApiException(
                        com.smartsolutions.eschool.institute.error.InstituteErrors.INVALID_INSTITUTE_DATA,
                        "Institute name cannot be empty",
                        org.springframework.http.HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getContactNumber() != null) entity.setContactNumber(dto.getContactNumber());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getWebsite() != null) entity.setWebsite(dto.getWebsite());
        if (dto.getTagLine() != null) entity.setTagLine(dto.getTagLine());
        if (dto.getLogo() != null) entity.setLogo(dto.getLogo());
        if (dto.getEstablishedDate() != null) entity.setEstablishedDate(dto.getEstablishedDate());
    }
}
