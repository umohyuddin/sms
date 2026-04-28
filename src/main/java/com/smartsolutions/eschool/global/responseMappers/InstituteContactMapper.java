package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteContactEntity;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;

public class InstituteContactMapper {
    private InstituteContactMapper() {
        // prevent instantiation
    }

    //Entity → Response DTO
    public static InstituteContactResponseDTO toResponseDTO(InstituteContactEntity entity) {

        if (entity == null) {
            return null;
        }

        InstituteContactResponseDTO dto = new InstituteContactResponseDTO();

        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstitute().getId());
        dto.setContactPersonName(entity.getContactPersonName());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setIsPrimary(entity.getIsPrimary());

        // Role mapping
        if (entity.getRole() != null) {
            RoleResponseDTO roleDTO = new RoleResponseDTO();
            roleDTO.setId(entity.getRole().getId());
            roleDTO.setCode(entity.getRole().getCode());
            roleDTO.setName(entity.getRole().getName());
            dto.setRole(roleDTO);
        }

        return dto;
    }

    public static InstituteContactEntity toEntity(InstituteContactCreateRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        InstituteContactEntity entity = new InstituteContactEntity();
        entity.setContactPersonName(requestDTO.getContactPersonName());
        entity.setPhone(requestDTO.getPhone());
        entity.setEmail(requestDTO.getEmail());
        entity.setIsPrimary(requestDTO.getIsPrimary());
        // institute and role are set manually in service to avoid mapping conflicts
        return entity;
    }

    public static void updateEntity(InstituteContactEntity entity, InstituteContactUpdateRequestDTO requestDTO) {
        if (entity == null || requestDTO == null) {
            return;
        }

        if (requestDTO.getContactPersonName() != null) entity.setContactPersonName(requestDTO.getContactPersonName());
        if (requestDTO.getPhone() != null) entity.setPhone(requestDTO.getPhone());
        if (requestDTO.getEmail() != null) entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getIsPrimary() != null) entity.setIsPrimary(requestDTO.getIsPrimary());
        // role and institute should be updated separately in the service
    }
}

