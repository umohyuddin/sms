package com.smartsolutions.eschool.sclass.dtos.responseDto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SectionDTO {
    private Long id;
    private String sectionName;
    private String sectionCode;
    private StandardDTO standard;
    private boolean deleted = false;
    private LocalDateTime deletedAt;
}
