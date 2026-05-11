package com.smartsolutions.eschool.school.dtos.designations.response;

import com.smartsolutions.eschool.school.model.DesignationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesignationResponseDTO {
    private Long id;
    private String designationCode;
    private String designationName;
    private String description;
    private Boolean active;
    private Boolean deleted;

    public static DesignationResponseDTO fromEntity(DesignationEntity entity) {
        if (entity == null) return null;
        return DesignationResponseDTO.builder()
                .id(entity.getId())
                .designationCode(entity.getDesignationCode())
                .designationName(entity.getDesignationName())
                .description(entity.getDescription())
                .active(entity.getActive())
                .deleted(entity.isDeleted())
                .build();
    }
}
