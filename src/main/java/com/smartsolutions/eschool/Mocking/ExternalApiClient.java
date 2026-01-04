package com.smartsolutions.eschool.Mocking;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public interface ExternalApiClient {

    CampusResponseDTO fetchOrder(String id);
}
