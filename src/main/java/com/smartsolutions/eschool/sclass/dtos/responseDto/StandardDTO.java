package com.smartsolutions.eschool.sclass.dtos.responseDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StandardDTO {
    private Long id;
    private String standardName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
