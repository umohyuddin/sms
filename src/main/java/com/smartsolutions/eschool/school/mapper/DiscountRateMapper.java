package com.smartsolutions.eschool.school.mapper;



import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountRateEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountRateMapper {

    private DiscountRateMapper() {
    }

    public static DiscountRateResponseDTO toDto(DiscountRateEntity entity) {
        if (entity == null)
            return null;

        DiscountRateResponseDTO dto = new DiscountRateResponseDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        dto.setIsPercentage(entity.getIsPercentage());
        dto.setEffectiveFrom(entity.getEffectiveFrom());
        dto.setEffectiveTo(entity.getEffectiveTo());
        dto.setIsActive(entity.getIsActive());

        if (entity.getDiscountSubType() != null) {
            dto.setDiscountSubType(DiscountSubTypeMapper.toDto(entity.getDiscountSubType()));
        }

        if (entity.getCampus() != null) {
            CampusResponseDTO campus = new CampusResponseDTO();
            campus.setId(entity.getCampus().getId());
            campus.setCampusName(entity.getCampus().getCampusName());
            campus.setCampusCode(entity.getCampus().getCampusCode());
            campus.setActive(entity.getCampus().isActive());
            dto.setCampus(campus);
        }

        if (entity.getAcademicYear() != null) {
            AcademicYearResponseDTO ay = new AcademicYearResponseDTO();
            ay.setId(entity.getAcademicYear().getId());
            ay.setName(entity.getAcademicYear().getName());
            dto.setAcademicYear(ay);
        }

        return dto;
    }

    public static List<DiscountRateResponseDTO> toDtoList(List<DiscountRateEntity> entities) {
        if (entities == null || entities.isEmpty())
            return Collections.emptyList();
        return entities.stream().map(DiscountRateMapper::toDto).collect(Collectors.toList());
    }

    public static DiscountRateEntity toEntity(DiscountRateRequestDTO dto) {
        if (dto == null)
            return null;
        DiscountRateEntity entity = new DiscountRateEntity();
        entity.setValue(dto.getValue());
        entity.setIsPercentage(dto.getIsPercentage() != null ? dto.getIsPercentage() : false);
        entity.setEffectiveFrom(dto.getEffectiveFrom());
        entity.setEffectiveTo(dto.getEffectiveTo());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);
        return entity;
    }
}
