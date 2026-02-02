package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteDocumentService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteDocumentFacade {

    private final InstituteDocumentService instituteDocumentService;

    public InstituteDocumentFacade(InstituteDocumentService instituteDocumentService) {
        this.instituteDocumentService = instituteDocumentService;
    }

    public InstituteDocumentResponseDTO createDocument(InstituteDocumentCreateRequestDTO requestDTO) {
        return instituteDocumentService.createDocument(requestDTO);
    }

    public Page<InstituteDocumentResponseDTO> getAll(Pageable pageable) {
        return instituteDocumentService.getAll(pageable);
    }

    public Page<InstituteDocumentResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteDocumentService.getByInstituteId(instituteId, pageable);
    }

    public InstituteDocumentResponseDTO getById(Long id) {
        return instituteDocumentService.getById(id);
    }

    public InstituteDocumentResponseDTO updateDocument(Long id, InstituteDocumentUpdateRequestDTO requestDTO) {
        return instituteDocumentService.updateDocument(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteDocumentService.deleteById(id);
    }

    public List<InstituteDocumentResponseDTO> searchByKeyword(String keyword) {
        return instituteDocumentService.searchByKeyword(keyword);
    }
}
