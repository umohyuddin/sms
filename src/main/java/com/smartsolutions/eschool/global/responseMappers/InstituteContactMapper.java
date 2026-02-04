package com.smartsolutions.eschool.global.responseMappers;

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
}
