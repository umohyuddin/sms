package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabResponseDTO;
import com.smartsolutions.eschool.student.service.FeeSlabService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeSlabFacade {

    private final FeeSlabService service;

    public FeeSlabFacade(FeeSlabService service) {
        this.service = service;
    }

    public List<FeeSlabResponseDTO> getAll() {
        return service.getAll();
    }

    public FeeSlabResponseDTO getById(Long id) {
        return service.getById(id);
    }

    public List<FeeSlabResponseDTO> getByGroupId(Long groupId) {
        return service.getByGroupId(groupId);
    }

    public FeeSlabResponseDTO create(FeeSlabCreateRequestDTO dto) {
        return service.create(dto);
    }

    public FeeSlabResponseDTO update(Long id, FeeSlabCreateRequestDTO dto) {
        return service.update(id, dto);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
