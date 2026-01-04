package com.smartsolutions.eschool.Mocking;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("!mock")
public class ExternalApiClientImpl implements ExternalApiClient{
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public ExternalApiClientImpl(RestTemplate restTemplate,
                                 @Value("${external.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public CampusResponseDTO fetchOrder(String id) {
        return restTemplate.getForObject(
                baseUrl + "/external/orders/{id}",
                CampusResponseDTO.class,
                id
        );
    }
}
