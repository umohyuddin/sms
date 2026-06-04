package com.smartsolutions.eschool.gl.mapper;

import com.smartsolutions.eschool.gl.dtos.postingKey.request.PostingKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.postingKey.response.PostingKeyResponseDTO;
import com.smartsolutions.eschool.gl.model.PostingKeyEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PostingKeyMapper {

    public static PostingKeyEntity toEntity(PostingKeyRequestDTO dto) {
        if (dto == null) return null;
        return PostingKeyEntity.builder()
                .code(dto.getCode().trim())
                .name(dto.getName().trim())
                .accountSide(dto.getAccountSide())
                .description(dto.getDescription())
                .isActive(dto.isActive())
                .build();
    }

    public static PostingKeyResponseDTO toResponseDTO(PostingKeyEntity entity) {
        if (entity == null) return null;
        return PostingKeyResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .accountSide(entity.getAccountSide())
                .description(entity.getDescription())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static void updateEntityFromDTO(PostingKeyEntity entity, PostingKeyRequestDTO dto) {
        if (dto == null) return;
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setAccountSide(dto.getAccountSide());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
    }

    public static List<PostingKeyResponseDTO> toResponseDTOList(List<PostingKeyEntity> entities) {
        return entities.stream().map(PostingKeyMapper::toResponseDTO).collect(Collectors.toList());
    }
}
