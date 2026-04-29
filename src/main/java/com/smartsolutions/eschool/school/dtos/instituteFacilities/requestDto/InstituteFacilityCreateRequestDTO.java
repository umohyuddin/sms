package com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFacilityCreateRequestDTO {
    @NotNull
    private Long instituteId;

    @NotEmpty
    @Valid
    private List<FacilitySelectionDTO> selections;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FacilitySelectionDTO {
        @NotNull
        private Long facilityTypeId;
        private String description;
        private Integer capacity;
    }
}
