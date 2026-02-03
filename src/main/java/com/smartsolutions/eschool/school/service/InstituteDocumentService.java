package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import java.util.List;

public interface InstituteDocumentService {
    InstituteDocumentResponseDTO createDocument(InstituteDocumentCreateRequestDTO requestDTO);

    List<InstituteDocumentResponseDTO> getAll();

    List<InstituteDocumentResponseDTO> getByInstituteId(Long instituteId);

    InstituteDocumentResponseDTO getById(Long id);

    InstituteDocumentResponseDTO updateDocument(Long id, InstituteDocumentUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteDocumentResponseDTO> searchByKeyword(String keyword);
}
