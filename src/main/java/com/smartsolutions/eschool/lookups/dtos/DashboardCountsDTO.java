package com.smartsolutions.eschool.lookups.dtos;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardCountsDTO {
    private Long totalEmployees;
    private Map<String, Long> countByGender;
}
