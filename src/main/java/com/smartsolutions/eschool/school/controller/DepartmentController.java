package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DepartmentFacade;
import com.smartsolutions.eschool.school.facade.DiscountTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/institute/departments")
@Slf4j
@RestController
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    /* ================= CREATE ================= */

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("Received request to create Department");
        DepartmentResponseDTO responseDTO = departmentFacade.createDepartment(requestDTO);
        log.info("Department created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /* ================= READ ================= */

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {
        log.info("GET /api/school/departments called");
        List<DepartmentResponseDTO> departments = departmentFacade.getAll();
        log.info("Returned {} departments", departments.size());
        return ResponseEntity.ok(departments);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAllActiveDepartments() {
        log.info("GET /api/school/departments/active called");
        List<DepartmentResponseDTO> departments = departmentFacade.getAllActive();
        log.info("Returned {} active departments", departments.size());
        return ResponseEntity.ok(departments);
    }

    @GetMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long departmentId) {
        log.info("GET /api/school/departments/{} called", departmentId);
        DepartmentResponseDTO department = departmentFacade.getById(departmentId);
        return ResponseEntity.ok(department);
    }

    /* ================= UPDATE ================= */

    @PutMapping(value = "/{departmentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable Long departmentId, @RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("Received request to update Department with id: {}", departmentId);
        DepartmentResponseDTO updated = departmentFacade.updateDepartment(departmentId, requestDTO);
        log.info("Department updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    /* ================= DELETE (SOFT) ================= */

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
        log.info("DELETE /api/school/departments/{} called", departmentId);
        departmentFacade.deleteById(departmentId);
        log.info("Department soft deleted successfully with id: {}", departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }
}