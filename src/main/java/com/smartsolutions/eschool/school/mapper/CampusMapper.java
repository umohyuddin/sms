package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CampusErrors;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.model.CampusEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for CampusEntity to DTOs and vice versa.
 */
public class CampusMapper {

    private CampusMapper() {
        // prevent instantiation
    }

    public static CampusResponseDTO toResponseDTO(CampusEntity entity) {
        if (entity == null) {
            return null;
        }

        CampusResponseDTO dto = new CampusResponseDTO();
        dto.setId(entity.getId());
        if (entity.getInstitute() != null) {
            dto.setInstituteId(entity.getInstitute().getId());
            dto.setInstituteName(entity.getInstitute().getName());
            if (entity.getInstitute().getCountry() != null) {
                dto.setCountryId(entity.getInstitute().getCountry().getId());
                dto.setCountryName(entity.getInstitute().getCountry().getCountryName());
            }
        }
        dto.setCampusName(entity.getCampusName());
        dto.setCampusCode(entity.getCampusCode());
        dto.setContactNumber(entity.getContactNumber());
        dto.setEmail(entity.getEmail());
        dto.setWebsite(entity.getWebsite());
        dto.setAddress(entity.getAddress());
        dto.setActive(entity.isActive());
        dto.setLogo(entity.getLogo());
        if (entity.getProvince() != null) {
            dto.setProvinceId(entity.getProvince().getId());
            dto.setProvince(com.smartsolutions.eschool.util.MapperUtil.mapObject(entity.getProvince(),
                    com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO.class));
        }
        if (entity.getCity() != null) {
            dto.setCityId(entity.getCity().getId());
            dto.setCity(com.smartsolutions.eschool.util.MapperUtil.mapObject(entity.getCity(),
                    com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO.class));
        }

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDeleted(entity.isDeleted());

        return dto;
    }

    public static List<CampusResponseDTO> toResponseDTOList(List<CampusEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(CampusMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static CampusEntity toEntity(CampusCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getCampusName() == null || dto.getCampusName().trim().isEmpty()) {
            throw new ApiException(CampusErrors.INVALID_CAMPUS_DATA, "Campus name is required",
                    HttpStatus.BAD_REQUEST);
        }

        CampusEntity entity = new CampusEntity();
        entity.setCampusName(dto.getCampusName().trim());
        entity.setCampusCode(dto.getCampusCode() != null ? dto.getCampusCode().trim() : null);
        entity.setContactNumber(dto.getContactNumber());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setAddress(dto.getAddress());
        entity.setActive(dto.isActive());
        entity.setLogo(dto.getLogo());
        // Province and City entities should be set by the service
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(CampusEntity entity, CampusCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCampusName() != null) {
            if (dto.getCampusName().trim().isEmpty()) {
                throw new ApiException(CampusErrors.INVALID_CAMPUS_DATA, "Campus name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setCampusName(dto.getCampusName().trim());
        }

        if (dto.getCampusCode() != null) {
            entity.setCampusCode(dto.getCampusCode().trim());
        }

        if (dto.getContactNumber() != null) {
            entity.setContactNumber(dto.getContactNumber());
        }

        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }

        if (dto.getWebsite() != null) {
            entity.setWebsite(dto.getWebsite());
        }

        if (dto.getAddress() != null) {
            entity.setAddress(dto.getAddress());
        }

        entity.setActive(dto.isActive());

        if (dto.getLogo() != null) {
            entity.setLogo(dto.getLogo());
        }

        // Province and City entities should be updated by the service
    }
}
