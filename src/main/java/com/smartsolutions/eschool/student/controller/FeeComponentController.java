package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.facade.FeeCatelogFacade;
import com.smartsolutions.eschool.student.facade.FeeComponentFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/fee/components")
@Slf4j
public class FeeComponentController {

    private final FeeComponentFacade feeComponentFacade;

    public FeeComponentController(FeeComponentFacade feeComponentFacade) {
        this.feeComponentFacade = feeComponentFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/component called");
        List<FeeComponentDTO> resources = feeComponentFacade.getAll();
        log.info("GET /api/fee/component succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch Fee component with id: {}", id);
        FeeComponentDTO feeComponentDTO = feeComponentFacade.getById(id);
        log.info("Returning Fee component: id={}", feeComponentDTO.getId());
        return ResponseEntity.ok(feeComponentDTO);
    }


    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@RequestParam(required = false) Long feeCatalogId, @RequestParam(required = false) String keyword) {
        log.info("GET /api/fee/component/search by keyword called");
        List<FeeComponentResponseDTO> responseDTOS = feeComponentFacade.searchFeeCatalogComponents(feeCatalogId,keyword);
        log.info("GET /api/fee/component/search by keyword succeeded");
        return ResponseEntity.ok().body(responseDTOS);
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
