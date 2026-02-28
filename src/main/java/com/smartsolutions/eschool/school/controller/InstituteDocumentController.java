package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteDocumentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/documents")
@Slf4j
public class InstituteDocumentController {

        private final InstituteDocumentFacade instituteDocumentFacade;

        public InstituteDocumentController(InstituteDocumentFacade instituteDocumentFacade) {
                this.instituteDocumentFacade = instituteDocumentFacade;
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<InstituteDocumentResponseDTO> createDocument(
                        @Valid @RequestBody InstituteDocumentCreateRequestDTO requestDTO) {
                log.info("[Controller:InstituteDocumentController] createDocument() called - Request to create institute document");
                InstituteDocumentResponseDTO responseDTO = instituteDocumentFacade.createDocument(requestDTO);
                log.info("[Controller:InstituteDocumentController] createDocument() succeeded - Document created with id: {}",
                                responseDTO.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<InstituteDocumentResponseDTO>> getAll() {
                log.info("[Controller:InstituteDocumentController] getAll() called - Request to get all institute documents");
                List<InstituteDocumentResponseDTO> responseDTOs = instituteDocumentFacade.getAll();
                log.info("[Controller:InstituteDocumentController] getAll() succeeded - Found {} documents",
                                responseDTOs.size());
                return ResponseEntity.ok(responseDTOs);
        }

        @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<InstituteDocumentResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
                log.info("[Controller:InstituteDocumentController] getByInstituteId() called - Request to get documents for institute: {}",
                                instituteId);
                List<InstituteDocumentResponseDTO> responseDTOs = instituteDocumentFacade.getByInstituteId(instituteId);
                log.info("[Controller:InstituteDocumentController] getByInstituteId() succeeded - Found {} documents for institute: {}",
                                responseDTOs.size(), instituteId);
                return ResponseEntity.ok(responseDTOs);
        }

        @GetMapping(value = "/{documentId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<InstituteDocumentResponseDTO> getById(@PathVariable Long documentId) {
                log.info("[Controller:InstituteDocumentController] getById() called - Request to get document by id: {}",
                                documentId);
                InstituteDocumentResponseDTO responseDTO = instituteDocumentFacade.getById(documentId);
                log.info("[Controller:InstituteDocumentController] getById() succeeded - Found document: {}",
                                documentId);
                return ResponseEntity.ok(responseDTO);
        }

        @PutMapping(value = "/{documentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<InstituteDocumentResponseDTO> updateDocument(@PathVariable Long documentId,
                        @Valid @RequestBody InstituteDocumentUpdateRequestDTO requestDTO) {
                log.info("[Controller:InstituteDocumentController] updateDocument() called - Request to update document: {}",
                                documentId);
                InstituteDocumentResponseDTO responseDTO = instituteDocumentFacade.updateDocument(documentId,
                                requestDTO);
                log.info("[Controller:InstituteDocumentController] updateDocument() succeeded - Document: {} updated successfully",
                                documentId);
                return ResponseEntity.ok(responseDTO);
        }

        @DeleteMapping("/{documentId}")
        public ResponseEntity<?> deleteDocument(@PathVariable Long documentId) {
                log.info("[Controller:InstituteDocumentController] deleteDocument() called - Request to delete document: {}",
                                documentId);
                instituteDocumentFacade.deleteById(documentId);
                log.info("[Controller:InstituteDocumentController] deleteDocument() succeeded - Document: {} deleted successfully",
                                documentId);
                return ResponseEntity.ok(java.util.Map.of("message", "Institute document deleted successfully"));
        }

        @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<InstituteDocumentResponseDTO>> search(
                        @RequestParam(name = "keyword") String keyword) {
                log.info("[Controller:InstituteDocumentController] search() called - Request to search documents with keyword: {}",
                                keyword);
                if (keyword == null || keyword.trim().isEmpty()) {
                        return ResponseEntity.badRequest().build();
                }
                List<InstituteDocumentResponseDTO> responseDTOs = instituteDocumentFacade
                                .searchByKeyword(keyword.trim());
                log.info("[Controller:InstituteDocumentController] search() succeeded - Found {} documents matching keyword: {}",
                                responseDTOs.size(), keyword);
                return ResponseEntity.ok(responseDTOs);
        }

        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<InstituteDocumentResponseDTO> uploadDocument(
                        @RequestParam("instituteId") Long instituteId,
                        @RequestParam("documentType") String documentType,
                        @RequestParam(value = "expiryDate", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.time.LocalDate expiryDate,
                        @RequestPart("file") org.springframework.web.multipart.MultipartFile file) {
                log.info("[Controller:InstituteDocumentController] uploadDocument() called - Request to upload document for institute: {}, type: {}",
                                instituteId, documentType);
                InstituteDocumentResponseDTO responseDTO = instituteDocumentFacade.uploadDocument(instituteId,
                                documentType, expiryDate, file);
                log.info("[Controller:InstituteDocumentController] uploadDocument() succeeded - Document uploaded with id: {}",
                                responseDTO.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
}
