package com.smartsolutions.eschool.school.dtos.subjects.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SubjectResponse {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean isCore;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}