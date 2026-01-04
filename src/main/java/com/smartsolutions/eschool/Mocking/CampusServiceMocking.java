package com.smartsolutions.eschool.Mocking;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CampusServiceMocking {
    private final ExternalApiClient client;

    public CampusServiceMocking(ExternalApiClient client) {
        this.client = client;
    }

    public CampusResponseDTO getCampus(String id) {
        CampusResponseDTO dto = client.fetchOrder(id);
        dto.setCampusName(dto.getCampusName() + " [Processed]");
        return dto;
    }
}
