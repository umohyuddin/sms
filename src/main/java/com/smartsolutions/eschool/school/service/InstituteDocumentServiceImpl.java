package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.InstituteDocumentErrors;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.mapper.InstituteDocumentMapper;
import com.smartsolutions.eschool.school.model.InstituteDocumentEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteDocumentRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class InstituteDocumentServiceImpl implements InstituteDocumentService {

        private final InstituteDocumentRepository instituteDocumentRepository;
        private final InstituteRepository instituteRepository;

        public InstituteDocumentServiceImpl(InstituteDocumentRepository instituteDocumentRepository,
                        InstituteRepository instituteRepository) {
                this.instituteDocumentRepository = instituteDocumentRepository;
                this.instituteRepository = instituteRepository;
        }

        @Override
        @Transactional
        public InstituteDocumentResponseDTO createDocument(InstituteDocumentCreateRequestDTO requestDTO) {
                log.info("[Service:InstituteDocumentServiceImpl] createDocument() called - Creating document for institute: {}",
                                requestDTO.getInstituteId());

                InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                                .orElseThrow(() -> new ApiException(InstituteDocumentErrors.INSTITUTE_NOT_FOUND,
                                                "Institute not found with id: " + requestDTO.getInstituteId(),
                                                HttpStatus.NOT_FOUND));

                InstituteDocumentEntity entity = InstituteDocumentMapper.toEntity(requestDTO, institute);
                InstituteDocumentEntity saved = instituteDocumentRepository.save(entity);

                log.info("[Service:InstituteDocumentServiceImpl] createDocument() succeeded - Document created with id: {}",
                                saved.getId());
                return InstituteDocumentMapper.toResponseDTO(saved);
        }

        @Override
        public List<InstituteDocumentResponseDTO> getAll() {
                Long orgId = SecurityUtils.getCurrentOrganizationId();
                log.info("[Service:InstituteDocumentServiceImpl] getAll() called - Fetching all documents for institute: {}",
                                orgId);

                List<InstituteDocumentEntity> entities = instituteDocumentRepository.findAllByInstituteIdJpql(orgId);

                log.info("[Service:InstituteDocumentServiceImpl] getAll() succeeded - Found {} documents",
                                entities.size());
                return InstituteDocumentMapper.toResponseDTOList(entities);
        }

        @Override
        @Transactional
        public InstituteDocumentResponseDTO uploadDocument(Long instituteId, String documentType,
                        java.time.LocalDate expiryDate,
                        MultipartFile file) {
                log.info("[Service:InstituteDocumentServiceImpl] uploadDocument() called - Uploading document for institute: {}",
                                instituteId);

                if (file.isEmpty()) {
                        throw new ApiException(InstituteDocumentErrors.INVALID_DOCUMENT_DATA, "File is empty",
                                        HttpStatus.BAD_REQUEST);
                }

                try {
                        InstituteEntity institute = instituteRepository.findById(instituteId)
                                        .orElseThrow(() -> new ApiException(InstituteDocumentErrors.INSTITUTE_NOT_FOUND,
                                                        "Institute not found with id: " + instituteId,
                                                        HttpStatus.NOT_FOUND));

                        // Save file to disk
                        String filePath = com.smartsolutions.eschool.global.utils.UploadUtil
                                        .saveInstituteDocument(instituteId, documentType, file);

                        // Create and save entity
                        InstituteDocumentEntity entity = new InstituteDocumentEntity();
                        entity.setInstitute(institute);
                        entity.setDocumentType(documentType);
                        entity.setFileName(file.getOriginalFilename());
                        entity.setFileUrl(filePath);
                        entity.setExpiryDate(expiryDate);
                        entity.setIsDeleted(false);

                        InstituteDocumentEntity saved = instituteDocumentRepository.save(entity);

                        log.info("[Service:InstituteDocumentServiceImpl] uploadDocument() succeeded - Document uploaded with id: {}",
                                        saved.getId());
                        return InstituteDocumentMapper.toResponseDTO(saved);

                } catch (IOException e) {
                        log.error("Failed to save institute document file", e);
                        throw new ApiException(InstituteDocumentErrors.INVALID_DOCUMENT_DATA,
                                        "Failed to save file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }

        @Override
        public List<InstituteDocumentResponseDTO> getByInstituteId(Long instituteId) {
                log.info(
                                "[Service:InstituteDocumentServiceImpl] getByInstituteId() called - Fetching documents for institute: {}",
                                instituteId);

                List<InstituteDocumentEntity> entities = instituteDocumentRepository
                                .findAllByInstituteIdJpql(instituteId);

                log.info("[Service:InstituteDocumentServiceImpl] getByInstituteId() succeeded - Found {} documents",
                                entities.size());
                return InstituteDocumentMapper.toResponseDTOList(entities);
        }

        @Override
        public InstituteDocumentResponseDTO getById(Long id) {
                Long orgId = SecurityUtils.getCurrentOrganizationId();
                log.info("[Service:InstituteDocumentServiceImpl] getById() called - Fetching document: {} for institute: {}",
                                id, orgId);

                InstituteDocumentEntity entity = instituteDocumentRepository.findByIdAndInstituteIdJpql(id, orgId)
                                .orElseThrow(() -> new ApiException(
                                                InstituteDocumentErrors.INSTITUTE_DOCUMENT_NOT_FOUND,
                                                "Institute document not found with id: " + id, HttpStatus.NOT_FOUND));

                log.info("[Service:InstituteDocumentServiceImpl] getById() succeeded - Found document: {}", id);
                return InstituteDocumentMapper.toResponseDTO(entity);
        }

        @Override
        @Transactional
        public InstituteDocumentResponseDTO updateDocument(Long id, InstituteDocumentUpdateRequestDTO requestDTO) {
                Long orgId = SecurityUtils.getCurrentOrganizationId();
                log.info(
                                "[Service:InstituteDocumentServiceImpl] updateDocument() called - Updating document: {} for institute: {}",
                                id, orgId);

                InstituteDocumentEntity existing = instituteDocumentRepository.findByIdAndInstituteIdJpql(id, orgId)
                                .orElseThrow(() -> new ApiException(
                                                InstituteDocumentErrors.INSTITUTE_DOCUMENT_NOT_FOUND,
                                                "Institute document not found with id: " + id, HttpStatus.NOT_FOUND));

                InstituteDocumentMapper.updateEntityFromDTO(existing, requestDTO);
                InstituteDocumentEntity updated = instituteDocumentRepository.save(existing);

                log.info("[Service:InstituteDocumentServiceImpl] updateDocument() succeeded - Document: {} updated",
                                id);
                return InstituteDocumentMapper.toResponseDTO(updated);
        }

        @Override
        @Transactional
        public void deleteById(Long id) {
                Long orgId = SecurityUtils.getCurrentOrganizationId();
                log.info("[Service:InstituteDocumentServiceImpl] deleteById() called - Deleting document: {} for institute: {}",
                                id, orgId);

                InstituteDocumentEntity existing = instituteDocumentRepository.findByIdAndInstituteIdJpql(id, orgId)
                                .orElseThrow(() -> new ApiException(
                                                InstituteDocumentErrors.INSTITUTE_DOCUMENT_NOT_FOUND,
                                                "Institute document not found with id: " + id, HttpStatus.NOT_FOUND));

                instituteDocumentRepository.delete(existing);
                log.info("[Service:InstituteDocumentServiceImpl] deleteById() succeeded - Document: {} deleted", id);
        }

        @Override
        public List<InstituteDocumentResponseDTO> searchByKeyword(String keyword) {
                Long orgId = SecurityUtils.getCurrentOrganizationId();
                String searchKey = keyword == null ? "" : keyword.trim();
                log.info(
                                "[Service:InstituteDocumentServiceImpl] searchByKeyword() called - Searching documents for institute: {} with keyword: '{}'",
                                orgId, searchKey);

                List<InstituteDocumentEntity> entities = instituteDocumentRepository
                                .searchByKeywordAndInstituteIdJpql(searchKey, orgId);

                log.info("[Service:InstituteDocumentServiceImpl] searchByKeyword() succeeded - Found {} documents",
                                entities.size());
                return InstituteDocumentMapper.toResponseDTOList(entities);
        }
}
