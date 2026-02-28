package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteFacilityErrors;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteFacilityEntity;
import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for InstituteFacilityEntity to DTOs and vice versa.
 */
public class InstituteFacilityMapper {

    private InstituteFacilityMapper() {
        // prevent instantiation
    }

    public static InstituteFacilityResponseDTO toResponseDTO(InstituteFacilityEntity entity) {
        if (entity == null) {
            return null;
        }

        if (entity.getInstitute() == null) {
            throw new ApiException(InstituteFacilityErrors.INSTITUTE_NOT_FOUND,
                    "Institute relationship is missing in Facility entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (entity.getFacilityType() == null) {
            throw new ApiException(InstituteFacilityErrors.FACILITY_TYPE_NOT_FOUND,
                    "Facility Type relationship is missing in Facility entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        InstituteFacilityResponseDTO dto = new InstituteFacilityResponseDTO();
        dto.setId(entity.getId());
        dto.setInstituteId(entity.getInstitute().getId());
        dto.setFacilityTypeId(entity.getFacilityType().getId());
        dto.setFacilityTypeCode(entity.getFacilityType().getCode());
        dto.setFacilityTypeName(entity.getFacilityType().getName());
        dto.setDescription(entity.getDescription());
        dto.setCapacity(entity.getCapacity());

        return dto;
    }

    public static List<InstituteFacilityResponseDTO> toResponseDTOList(List<InstituteFacilityEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(InstituteFacilityMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static InstituteFacilityEntity toEntity(InstituteFacilityCreateRequestDTO.FacilitySelectionDTO selectionDTO,
            InstituteEntity institute, FacilityTypeEntity facilityType) {
        if (selectionDTO == null) {
            return null;
        }

        if (institute == null) {
            throw new ApiException(InstituteFacilityErrors.INSTITUTE_NOT_FOUND, "Institute is required",
                    HttpStatus.BAD_REQUEST);
        }
        if (facilityType == null) {
            throw new ApiException(InstituteFacilityErrors.FACILITY_TYPE_NOT_FOUND, "Facility Type is required",
                    HttpStatus.BAD_REQUEST);
        }

        InstituteFacilityEntity entity = new InstituteFacilityEntity();
        entity.setInstitute(institute);
        entity.setFacilityType(facilityType);
        entity.setDescription(selectionDTO.getDescription());
        entity.setCapacity(selectionDTO.getCapacity());

        return entity;
    }

    public static void updateEntityFromDTO(InstituteFacilityEntity entity, InstituteFacilityUpdateRequestDTO dto,
            FacilityTypeEntity newFacilityType) {
        if (entity == null || dto == null) {
            return;
        }

        if (newFacilityType != null) {
            entity.setFacilityType(newFacilityType);
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getCapacity() != null) {
            entity.setCapacity(dto.getCapacity());
        }
    }
}
