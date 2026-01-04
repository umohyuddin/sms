package com.smartsolutions.eschool.Mocking;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class ExternalApiClientMock implements ExternalApiClient {
    @Override
    public CampusResponseDTO fetchOrder(String id) {
        // Simulate success
        return CampusResponseDTO.builder()
                .id((long) Integer.parseInt(id))
                .campusName("Mock Campus " + id)
                .isActive(true)
                .build();
    }
}
