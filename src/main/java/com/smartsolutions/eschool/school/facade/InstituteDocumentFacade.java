package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteDocumentService;
import org.springframework.context.annotation.Scope;
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

    public List<InstituteDocumentResponseDTO> getAll() {
        return instituteDocumentService.getAll();
    }

    public List<InstituteDocumentResponseDTO> getByInstituteId(Long instituteId) {
        return instituteDocumentService.getByInstituteId(instituteId);
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
