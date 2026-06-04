package com.smartsolutions.eschool.dashboard.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {
    private String user;
    private String action;
    private String details;
    private LocalDateTime timestamp;
}
