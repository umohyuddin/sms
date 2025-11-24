package com.smartsolutions.eschool.sclass.dtos.responseDto;

import com.smartsolutions.eschool.school.dtos.CampusDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StandardDTO {
    private Long id;
    private String standardName;
    private String standardCode;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
    private LocalDateTime deletedAt;
    private Long campusId;
    private CampusDTO campus;
}
