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
public class AlertResponse {
    private String type; // CRITICAL, WARNING, INFO
    private String message;
    private String category; // FINANCE, ACADEMIC, HR
}
