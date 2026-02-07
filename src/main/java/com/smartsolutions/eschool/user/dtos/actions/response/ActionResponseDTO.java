package com.smartsolutions.eschool.user.dtos.actions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean active;
    private Boolean deleted;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
