package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupResponseDTO;
import com.smartsolutions.eschool.student.service.FeeSlabGroupService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeSlabGroupFacade {

    private final FeeSlabGroupService service;

    public FeeSlabGroupFacade(FeeSlabGroupService service) {
        this.service = service;
    }

    public List<FeeSlabGroupResponseDTO> getAll() {
        return service.getAll();
    }

    public FeeSlabGroupResponseDTO getById(Long id) {
        return service.getById(id);
    }

    public List<FeeSlabGroupResponseDTO> search(String keyword) {
        return service.search(keyword);
    }

    public FeeSlabGroupResponseDTO create(FeeSlabGroupCreateRequestDTO dto) {
        return service.create(dto);
    }

    public FeeSlabGroupResponseDTO update(Long id, FeeSlabGroupCreateRequestDTO dto) {
        return service.update(id, dto);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
