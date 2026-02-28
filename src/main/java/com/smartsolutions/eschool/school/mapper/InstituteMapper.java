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
}
