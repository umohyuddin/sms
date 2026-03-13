package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.chargetype.request.ChargeTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.school.model.ChargeTypeEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChargeTypeMapper {

    public static ChargeTypeResponseDTO toResponseDTO(ChargeTypeEntity entity) {
        if (entity == null)
            return null;
        return ChargeTypeResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .active(entity.getActive())
                .build();
    }

    public static List<ChargeTypeResponseDTO> toResponseDTOList(List<ChargeTypeEntity> entities) {
        if (entities == null || entities.isEmpty())
            return Collections.emptyList();
        return entities.stream()
                .map(ChargeTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static ChargeTypeEntity toEntity(ChargeTypeRequestDTO dto) {
        if (dto == null)
            return null;
        ChargeTypeEntity entity = new ChargeTypeEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        return entity;
    }

    public static void updateEntityFromDTO(ChargeTypeEntity entity, ChargeTypeRequestDTO dto) {
        if (entity == null || dto == null)
            return;

        if (dto.getCode() != null)
            entity.setCode(dto.getCode());
        if (dto.getName() != null)
            entity.setName(dto.getName());
        if (dto.getDescription() != null)
            entity.setDescription(dto.getDescription());
        if (dto.getActive() != null)
            entity.setActive(dto.getActive());
    }
}
