package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.standardSubject.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.standardSubject.response.StandardSubjectResponseDTO;
import com.smartsolutions.eschool.sclass.facade.StandardSubjectFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standard-subjects")
@RequiredArgsConstructor
public class StandardSubjectController {

    private final StandardSubjectFacade facade;

    @PostMapping
    public StandardSubjectResponseDTO create(
            @RequestBody @Valid StandardSubjectRequestDTO dto) {
        return facade.create(dto);
    }

    @PutMapping("/{id}")
    public StandardSubjectResponseDTO update(
            @PathVariable Long id,
            @RequestBody @Valid StandardSubjectRequestDTO dto) {
        return facade.update(id, dto);
    }

    @GetMapping("/{id}")
    public StandardSubjectResponseDTO getById(@PathVariable Long id) {
        return facade.get(id);
    }

    @GetMapping("/by-standard/{standardId}")
    public List<StandardSubjectResponseDTO> getByStandard(
            @PathVariable Long standardId) {
        return facade.getByStandard(standardId);
    }

    @GetMapping("/by-subject/{subjectId}")
    public List<StandardSubjectResponseDTO> getBySubject(
            @PathVariable Long subjectId) {
        return facade.getBySubject(subjectId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.delete(id);
    }
}
