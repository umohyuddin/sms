package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.facade.FeeRateFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/fee/rates")
@Slf4j
public class FeeRateController {

    private final FeeRateFacade feeRateFacade;

    public FeeRateController(FeeRateFacade feeRateFacade) {
        this.feeRateFacade = feeRateFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/rates called");
        List<FeeRateDTO> resources = feeRateFacade.getAll();
        log.info("GET /api/fee/rates succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch Fee rate with id: {}", id);
        FeeRateDTO feeRateDTO = feeRateFacade.getById(id);
        log.info("Returning Fee rate: id={}", feeRateDTO.getId());
        return ResponseEntity.ok(feeRateDTO);
    }

    @GetMapping(value = "/search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSearch(@PathVariable String keyword) {
        log.info("GET /api/fee/rates by keyword called");
        List<FeeRateDTO> resources = feeRateFacade.searchFeeRates(keyword);
        log.info("GET /api/fee/rates by keyword succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/component/{componentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFeeComponentId(@PathVariable Long componentId) {
        log.info("GET /api/fee/rates by componentId called");
        List<FeeRateDTO> resources = feeRateFacade.getByFeeComponentId(componentId);
        log.info("GET /api/fee/rates by  succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }


//    @GetMapping(value = "/getbystudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject getByStudent(@PathVariable Long id) throws Exception {
//
//        return new MultiResourceSuccessResponseObject(
//                feeFacade.getByStudent(id)
//                        .stream()
//                        .map(entity -> {
//                            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//                            return new ResourceObject(
//                                    String.valueOf(entity.getStudentId()),
//                                    "Fee",
//                                    resourceAttributes
//                            );
//                        })
//                        .collect(Collectors.toList()));
//    }
//
//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject create(
//            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
//        if (!requestBody.containsKey("data")) {
//            throw new ValidationException("The request body did not contain a data attribute");
//        }
//        Map<String, Object> resourceMap = requestBody.get("data");
//        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
//        FeeEntity nFeeEntity = objectMapper.convertValue(attributes, FeeEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message", feeFacade.create(nFeeEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                String.valueOf(nFeeEntity.getId()),
//                "Fee",
//                resourceAttributes
//        ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject update(
//            @RequestBody Map<String, Map<String, Object>> requestBody) throws Exception {
//        if (!requestBody.containsKey("data")) {
//            throw new ValidationException("The request body did not contain a data attribute");
//        }
//        Map<String, Object> resourceMap = requestBody.get("data");
//        Map<String, Object> attributes = (Map<String, Object>) resourceMap.get("attributes");
//        FeeEntity nFeeEntity = objectMapper.convertValue(attributes, FeeEntity.class);
//        Map<String, Object> resourceAttributes = Map.of("message", feeFacade.update(nFeeEntity));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                String.valueOf(nFeeEntity.getId()),
//                "Fee",
//                resourceAttributes
//        ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
//    }
//
//    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public MultiResourceSuccessResponseObject delete(
//            @PathVariable Long id
//    ) throws Exception {
//        Map<String, Object> resourceAttributes = Map.of("message", feeFacade.delete(id));
//        List<ResourceObject> resourceObject = new ArrayList<>();
//        resourceObject.add(new ResourceObject(
//                String.valueOf(id),
//                "Fee",
//                resourceAttributes
//        ));
//        return new MultiResourceSuccessResponseObject(resourceObject);
    //}
}
