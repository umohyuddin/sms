package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.facade.DepartmentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> create(@RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("[Controller:DepartmentController] create() called - Request to create department: {}",
                requestDTO.getDepartmentName());
        DepartmentResponseDTO responseDTO = departmentFacade.createDepartment(requestDTO);
        log.info("[Controller:DepartmentController] create() succeeded - Created department with id: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAll() {
        log.info("[Controller:DepartmentController] getAll() called - Request to get all departments");
        List<DepartmentResponseDTO> departments = departmentFacade.getAll();
        log.info("[Controller:DepartmentController] getAll() succeeded - Found {} departments", departments.size());
        return ResponseEntity.ok(departments);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAllActive() {
        log.info("[Controller:DepartmentController] getAllActive() called - Request to get all active departments");
        List<DepartmentResponseDTO> departments = departmentFacade.getAllActive();
        log.info("[Controller:DepartmentController] getAllActive() succeeded - Found {} active departments",
                departments.size());
        return ResponseEntity.ok(departments);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:DepartmentController] getById() called - Request to fetch department with id: {}", id);
        DepartmentResponseDTO department = departmentFacade.getById(id);
        log.info("[Controller:DepartmentController] getById() succeeded - Found department: {}", id);
        return ResponseEntity.ok(department);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> update(@PathVariable Long id,
            @RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("[Controller:DepartmentController] update() called - Request to update department: {}", id);
        DepartmentResponseDTO updated = departmentFacade.updateDepartment(id, requestDTO);
        log.info("[Controller:DepartmentController] update() succeeded - Updated department: {}", id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:DepartmentController] delete() called - Request to delete department: {}", id);
        departmentFacade.deleteById(id);
        log.info("[Controller:DepartmentController] delete() succeeded - Deleted department: {}", id);
        return ResponseEntity.ok(Map.of("message", "Department deleted successfully"));
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:DepartmentController] search() called - Request to search departments with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<DepartmentResponseDTO> results = departmentFacade.searchDepartments(keyword.trim());
        log.info("[Controller:DepartmentController] search() succeeded - Found {} departments matching keyword: {}",
                results.size(), keyword);
        return ResponseEntity.ok(results);
    }
}
