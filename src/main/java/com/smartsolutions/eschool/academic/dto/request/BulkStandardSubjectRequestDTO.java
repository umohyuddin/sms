package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkStandardSubjectRequestDTO {
    @NotEmpty
    @Valid
    private List<StandardSubjectRequestDTO> assignments;
}
