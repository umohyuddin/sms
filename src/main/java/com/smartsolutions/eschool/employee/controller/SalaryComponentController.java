package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureResponseDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.SalaryComponentSearchDto;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.facade.SalaryComponentFacade;
import com.smartsolutions.eschool.employee.facade.SalaryStructureFacade;
import com.smartsolutions.eschool.employee.model.SalaryComponentEntity;
import com.smartsolutions.eschool.global.enums.ComponentType;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/salary-components")
@Slf4j
public class SalaryComponentController {

    private final SalaryComponentFacade salaryComponentFacade;

    public SalaryComponentController(SalaryComponentFacade salaryComponentFacade) {
        this.salaryComponentFacade = salaryComponentFacade;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> getAllComponents() {
        log.info("GET /api/institute/salary-components/list called");
        List<SalaryComponentResponseDTO> list = salaryComponentFacade.getAllNonDeleted();
        log.info("GET /api/institute/salary-components/list succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> getComponentById(@PathVariable Long id) {
        log.info("GET /api/institute/salary-components/{} called", id);
        SalaryComponentResponseDTO component = salaryComponentFacade.getById(id);
        log.info("GET /api/institute/salary-components/{} succeeded", id);
        return ResponseEntity.ok(component);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> search(@RequestParam String keyword) {
        log.info("GET /api/institute/salary-components/search called with keyword='{}'", keyword);
        List<SalaryComponentResponseDTO> list = salaryComponentFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/salary-components/search succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/search/complex", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> complexSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ComponentType type,
            @RequestParam(required = false) Boolean isPercentage) {
        log.info("GET /api/institute/salary-components/search/complex called with name='{}', type='{}', isPercentage={}", name, type, isPercentage);
        SalaryComponentSearchDto searchDto = new SalaryComponentSearchDto(name, type, isPercentage);
        List<SalaryComponentResponseDTO> list = salaryComponentFacade.searchComplex(searchDto);
        log.info("GET /api/institute/salary-components/search/complex succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> createComponent(@Valid @RequestBody SalaryComponentRequestDTO requestDTO) {
        log.info("POST /api/institute/salary-components/create called with name='{}'", requestDTO.getName());
        SalaryComponentResponseDTO created = salaryComponentFacade.createComponent(requestDTO);
        log.info("POST /api/institute/salary-components/create succeeded, created resource with id={}", created.getId());
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> updateComponent(@PathVariable Long id, @Valid @RequestBody SalaryComponentRequestDTO requestDTO) {
        log.info("PUT /api/institute/salary-components/{} called", id);
        SalaryComponentResponseDTO updated = salaryComponentFacade.updateComponent(id, requestDTO);
        log.info("PUT /api/institute/salary-components/{} succeeded", id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/institute/salary-components/{} called", id);
        salaryComponentFacade.delete(id);
        log.info("DELETE /api/institute/salary-components/{} succeeded", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalCount() {
        log.info("GET /api/institute/salary-components/count called");
        Long count = salaryComponentFacade.getTotalCount();
        log.info("GET /api/institute/salary-components/count succeeded, total={}", count);
        return ResponseEntity.ok(count);
    }
}

//    @GetMapping("/salary-components")
//    public List<SalaryComponentResponseDTO> search(@RequestParam(required = false) String name, @RequestParam(required = false) ComponentType type, @RequestParam(required = false) Boolean isPercentage) {
//        return salaryComponentFacade.searchComponents(new SalaryComponentSearchDto(name, type, isPercentage));
//    }
