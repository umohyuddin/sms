package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.campuses.metaData.CampusMetaData;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.facade.CampusFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/campuses")
@Slf4j
public class CampusController {

    private final CampusFacade nCampusFacade;

    public CampusController(CampusFacade nCampusFacade) {
        this.nCampusFacade = nCampusFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampusResponseDTO>> getAll() {
        log.info("[Controller:CampusController] getAll() called - Request to get all campuses");
        List<CampusResponseDTO> resources = nCampusFacade.getAll();
        log.info("[Controller:CampusController] getAll() succeeded - Found {} campuses", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:CampusController] getById() called - Request to fetch campus with id: {}", id);
        CampusResponseDTO campus = nCampusFacade.getById(id);
        log.info("[Controller:CampusController] getById() succeeded - Found campus: {}", id);
        return ResponseEntity.ok(campus);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampusResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CampusController] search() called - Request to search campuses with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CampusResponseDTO> responseDTOs = nCampusFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CampusController] search() succeeded - Found {} campuses matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{campusId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long campusId) {
        log.info("[Controller:CampusController] delete() called - Request to delete campus: {}", campusId);
        nCampusFacade.softDeleteById(campusId);
        log.info("[Controller:CampusController] delete() succeeded - Campus: {} deleted successfully", campusId);
        return ResponseEntity.ok(Map.of("message", "Campus deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> create(@Valid @RequestBody CampusCreateRequestDTO requestDTO) {
        log.info("[Controller:CampusController] create() called - Request to create campus: {}",
                requestDTO.getCampusName());
        CampusResponseDTO responseDTO = nCampusFacade.createCampus(requestDTO);
        log.info("[Controller:CampusController] create() succeeded - Campus created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody CampusCreateRequestDTO requestDTO) {
        log.info("[Controller:CampusController] update() called - Request to update campus: {}", id);
        CampusResponseDTO responseDTO = nCampusFacade.updateCampus(id, requestDTO);
        log.info("[Controller:CampusController] update() succeeded - Campus: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

//    @GetMapping(value = "/meta", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CampusMetaData> getMetaData() {
//        log.info("[Controller:CampusController] getMetaData() called");
//        CampusMetaData resources = nCampusFacade.getCampusMetaData();
//        log.info("[Controller:CampusController] getMetaData() succeeded");
//        return ResponseEntity.ok(resources);
//    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.Map<String, Long>> getStatistics() {
        log.info("[Controller:CampusController] getStatistics() called");
        java.util.Map<String, Long> statistics = nCampusFacade.getStatistics();
        log.info("[Controller:CampusController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
