package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.facade.SClassFacade;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class/classes")
@Slf4j
public class SClassController {
    private final SClassFacade sClassFacade;

    public SClassController(SClassFacade sClassFacade) {
        this.sClassFacade = sClassFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SClassEntity>> getAll() {
        log.info("GET /api/class/classes called");
        List<SClassEntity> resources = sClassFacade.getAll();
        log.info("GET /api/class/classes succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SClassEntity> getById(@PathVariable Long id) {
        log.info("GET /api/class/classes/{} called", id);
        SClassEntity resource = sClassFacade.getById(id);
        log.info("GET /api/class/classes/{} succeeded", id);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/teacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SClassEntity>> getByTeacherId(@PathVariable Long id) {
        log.info("GET /api/class/classes/teacher/{} called", id);
        List<SClassEntity> resources = sClassFacade.getByTeacherId(id);
        log.info("GET /api/class/classes/teacher/{} succeeded, returned {} resources", id, resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SClassEntity>> getByCourseId(@PathVariable Long id) {
        log.info("GET /api/class/classes/course/{} called", id);
        List<SClassEntity> resources = sClassFacade.getByCourseId(id);
        log.info("GET /api/class/classes/course/{} succeeded, returned {} resources", id, resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SClassEntity>> getByStudentId(@PathVariable Long id) {
        log.info("GET /api/class/classes/student/{} called", id);
        List<SClassEntity> resources = sClassFacade.getByStudentId(id);
        log.info("GET /api/class/classes/student/{} succeeded, returned {} resources", id, resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SClassEntity>> searchByKeyword(@RequestParam String keyword) {
        log.info("GET /api/class/classes/search called with keyword='{}'", keyword);
        List<SClassEntity> resources = sClassFacade.searchByKeyword(keyword);
        log.info("GET /api/class/classes/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody SClassEntity sClassEntity) {
        log.info("POST /api/class/classes called for: {}", sClassEntity.getName());
        String result = sClassFacade.create(sClassEntity);
        log.info("POST /api/class/classes succeeded");
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody SClassEntity sClassEntity) {
        log.info("PUT /api/class/classes called for ID: {}", sClassEntity.getId());
        String result = sClassFacade.update(sClassEntity);
        log.info("PUT /api/class/classes succeeded");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("DELETE /api/class/classes/{} called", id);
        String result = sClassFacade.delete(id);
        log.info("DELETE /api/class/classes/{} succeeded", id);
        return ResponseEntity.ok(result);
    }
}
