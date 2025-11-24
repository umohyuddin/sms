package com.smartsolutions.eschool.sclass.dtos.requestDto;

import com.smartsolutions.eschool.school.dtos.CampusDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StandardCreateRequestDTO {
    private Long id;
    @NotBlank(message = "Standard name is required")
    private String standardName;
    private String standardCode;
    private String description;
    @NotNull(message = "Campus ID must not be null")
    private Long campusId;
}
