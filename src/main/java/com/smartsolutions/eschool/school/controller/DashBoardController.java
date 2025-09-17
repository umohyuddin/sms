package com.smartsolutions.eschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.facade.DashboardFacade;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@RestController
@RequestMapping("/api/schools/dashboard")
public class DashBoardController {
    private DashboardFacade nDashboardFacade;
    private ObjectMapper objectMapper;
    @Autowired
    public DashBoardController(DashboardFacade pDashboardFacade, ObjectMapper objectMapper) {
        this.nDashboardFacade = pDashboardFacade;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/getdashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiResourceSuccessResponseObject getDashboard(@RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {

        if (!requestBody.containsKey("data")) {
            throw new ValidationException("The request body did not contain a data attribute");
        }
        Map<String, Object> resourceMap = requestBody.get("data");
        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
        String category = attributes.get("category").toString();
        Long  id = Long.parseLong(attributes.get("id").toString());
        String type = attributes.get("type").toString();
        int year = Integer.parseInt(attributes.get("year").toString());
        int month = Integer.parseInt(attributes.get("month").toString());

        Map<String, Object> resourceAttributes = objectMapper.convertValue(nDashboardFacade.getDashboard(category, id, type, year, month), Map.class);
        List<ResourceObject> resourceObject = new ArrayList<>();
        resourceObject.add( new ResourceObject(
                String.valueOf(id),
                "Dashboard",
                resourceAttributes
        ));
        return new MultiResourceSuccessResponseObject(resourceObject);
    }

}
