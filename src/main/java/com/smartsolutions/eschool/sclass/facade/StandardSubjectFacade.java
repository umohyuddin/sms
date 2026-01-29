package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.standardSubject.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.standardSubject.response.StandardSubjectResponseDTO;
import com.smartsolutions.eschool.sclass.service.StandardSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StandardSubjectFacade {

    private final StandardSubjectService service;

    public StandardSubjectResponseDTO create(StandardSubjectRequestDTO dto) {
        return service.create(dto);
    }

    public StandardSubjectResponseDTO update(Long id, StandardSubjectRequestDTO dto) {
        return service.update(id, dto);
    }

    public StandardSubjectResponseDTO get(Long id) {
        return service.getById(id);
    }

    public List<StandardSubjectResponseDTO> getByStandard(Long standardId) {
        return service.getByStandard(standardId);
    }


    public List<StandardSubjectResponseDTO> getBySubject(Long subjectId) {
        return service.getBySubject(subjectId);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
