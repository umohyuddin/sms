package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class InstituteDocumentFacade {

    private final InstituteDocumentService instituteDocumentService;

    public InstituteDocumentFacade(InstituteDocumentService instituteDocumentService) {
        this.instituteDocumentService = instituteDocumentService;
    }

    public InstituteDocumentResponseDTO createDocument(InstituteDocumentCreateRequestDTO requestDTO) {
        log.info("[Facade:InstituteDocumentFacade] createDocument() called");
        return instituteDocumentService.createDocument(requestDTO);
    }

    public List<InstituteDocumentResponseDTO> getAll() {
        log.info("[Facade:InstituteDocumentFacade] getAll() called");
        return instituteDocumentService.getAll();
    }

    public List<InstituteDocumentResponseDTO> getByInstituteId(Long instituteId) {
        log.info("[Facade:InstituteDocumentFacade] getByInstituteId() called - instituteId: {}", instituteId);
        return instituteDocumentService.getByInstituteId(instituteId);
    }

    public InstituteDocumentResponseDTO getById(Long id) {
        log.info("[Facade:InstituteDocumentFacade] getById() called - id: {}", id);
        return instituteDocumentService.getById(id);
    }

    public InstituteDocumentResponseDTO updateDocument(Long id, InstituteDocumentUpdateRequestDTO requestDTO) {
        log.info("[Facade:InstituteDocumentFacade] updateDocument() called - id: {}", id);
        return instituteDocumentService.updateDocument(id, requestDTO);
    }

    public void deleteById(Long id) {
        log.info("[Facade:InstituteDocumentFacade] deleteById() called - id: {}", id);
        instituteDocumentService.deleteById(id);
    }

    public List<InstituteDocumentResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:InstituteDocumentFacade] searchByKeyword() called - keyword: {}", keyword);
        return instituteDocumentService.searchByKeyword(keyword);
    }

    public InstituteDocumentResponseDTO uploadDocument(Long instituteId, String documentType,
            java.time.LocalDate expiryDate, org.springframework.web.multipart.MultipartFile file) {
        log.info(
                "[Facade:InstituteDocumentFacade] uploadDocument() called - instituteId: {}, documentType: {}, expiryDate: {}",
                instituteId, documentType, expiryDate);
        return instituteDocumentService.uploadDocument(instituteId, documentType, expiryDate, file);
    }
}
