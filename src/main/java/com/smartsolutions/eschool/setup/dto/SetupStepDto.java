package com.smartsolutions.eschool.setup.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO representing an individual setup step and its status.
 */
@Data
@Builder
public class SetupStepDto {
    private String code;
    private String title;
    private SetupStepStatus status;
    private String route;
}
