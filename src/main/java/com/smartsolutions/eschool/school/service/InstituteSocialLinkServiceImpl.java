package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;

import com.smartsolutions.eschool.institute.error.InstituteSocialLinkErrors;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteSocialLinkEntity;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.school.repository.InstituteSocialLinkRepository;
import com.smartsolutions.eschool.global.responseMappers.InstituteSocialLinkMapper;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteSocialLinkServiceImpl implements InstituteSocialLinkService {

        private final InstituteSocialLinkRepository instituteSocialLinkRepository;
        private final InstituteRepository instituteRepository;

        public InstituteSocialLinkServiceImpl(InstituteSocialLinkRepository instituteSocialLinkRepository,
                        InstituteRepository instituteRepository) {
                this.instituteSocialLinkRepository = instituteSocialLinkRepository;
                this.instituteRepository = instituteRepository;
        }

        @Override
        public InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO) {
                Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
                if (contextInstituteId == null) {
                        throw new ApiException(InstituteSocialLinkErrors.ORGANIZATION_ACCESS_DENIED,
                                        "Unable to identify your organization. Please ensure you are properly logged in.",
                                        HttpStatus.FORBIDDEN);
                }
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] createSocialLink() called - Creating social link for institute: {}",
                                contextInstituteId);

                if (instituteSocialLinkRepository.existsByInstituteIdAndPlatformOrUrl(contextInstituteId,
                                requestDTO.getPlatform(), requestDTO.getUrl())) {
                        throw new ApiException(InstituteSocialLinkErrors.DUPLICATE_LINK,
                                        "A social link with this platform or URL already exists for your institute.",
                                        HttpStatus.CONFLICT);
                }

                InstituteEntity institute = instituteRepository.findById(contextInstituteId)
                                .orElseThrow(() -> new ApiException(
                                                InstituteSocialLinkErrors.INSTITUTE_NOT_FOUND,
                                                HttpStatus.NOT_FOUND));

                InstituteSocialLinkEntity entity = InstituteSocialLinkMapper.toEntity(requestDTO);
                entity.setId(null);
                entity.setInstitute(institute);
                InstituteSocialLinkEntity saved = instituteSocialLinkRepository.save(entity);
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] createSocialLink() succeeded - Social link created successfully with id: {} for institute: {}",
                                saved.getId(),
                                institute.getId());
                return InstituteSocialLinkMapper.toResponseDTO(saved);
        }

        @Override
        public List<InstituteSocialLinkResponseDTO> getAll() {
                Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
                if (contextInstituteId == null) {
                        throw new ApiException(InstituteSocialLinkErrors.ORGANIZATION_ACCESS_DENIED,
                                        HttpStatus.FORBIDDEN);
                }
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] getAll() called - Getting all social links for institute: {}",
                                contextInstituteId);
                List<InstituteSocialLinkEntity> result = instituteSocialLinkRepository
                                .findByInstituteId(contextInstituteId);
                List<InstituteSocialLinkResponseDTO> responseDTOs = InstituteSocialLinkMapper.toResponseDTOList(result);
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] getAll() succeeded - Successfully fetched {} social links for institute: {}",
                                responseDTOs.size(),
                                contextInstituteId);
                return responseDTOs;
        }

        @Override
        public List<InstituteSocialLinkResponseDTO> getByInstituteId() {
                log.info("[Service:InstituteSocialLinkServiceImpl] getByInstituteId() called - Redirecting to getAll()");
                return getAll();
        }

        @Override
        public InstituteSocialLinkResponseDTO getById(Long id) {
                Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
                if (contextInstituteId == null) {
                        throw new ApiException(InstituteSocialLinkErrors.ORGANIZATION_ACCESS_DENIED,
                                        HttpStatus.FORBIDDEN);
                }
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] getById() called - Getting social link by id: {} and institute id: {}",
                                id, contextInstituteId);
                return instituteSocialLinkRepository.findByIdAndInstituteId(id, contextInstituteId)
                                .map(InstituteSocialLinkMapper::toResponseDTO)
                                .orElseThrow(() -> new ApiException(InstituteSocialLinkErrors.LINK_NOT_FOUND,
                                                HttpStatus.NOT_FOUND));
        }

        @Override
        public InstituteSocialLinkResponseDTO updateSocialLink(Long id,
                        InstituteSocialLinkUpdateRequestDTO requestDTO) {
                Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
                if (contextInstituteId == null) {
                        throw new ApiException(InstituteSocialLinkErrors.ORGANIZATION_ACCESS_DENIED,
                                        "Unable to identify your organization context.", HttpStatus.FORBIDDEN);
                }
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] updateSocialLink() called - Updating social link by id: {} for institute id: {}",
                                id, contextInstituteId);

                InstituteSocialLinkEntity existing = instituteSocialLinkRepository
                                .findByIdAndInstituteId(id, contextInstituteId)
                                .orElseThrow(() -> new ApiException(InstituteSocialLinkErrors.LINK_NOT_FOUND,
                                                "Social link not found or access denied.", HttpStatus.NOT_FOUND));

                // Edge case: check if updated platform/url conflicts with another existing
                // record
                if (requestDTO.getPlatform() != null || requestDTO.getUrl() != null) {
                        String newPlatform = requestDTO.getPlatform() != null ? requestDTO.getPlatform()
                                        : existing.getPlatform();
                        String newUrl = requestDTO.getUrl() != null ? requestDTO.getUrl() : existing.getUrl();

                        if (instituteSocialLinkRepository.existsByInstituteIdAndPlatformOrUrlAndIdNot(
                                        contextInstituteId,
                                        newPlatform, newUrl, id)) {
                                throw new ApiException(InstituteSocialLinkErrors.DUPLICATE_LINK,
                                                "Another social link with this platform or URL already exists.",
                                                HttpStatus.CONFLICT);
                        }
                }

                InstituteSocialLinkMapper.updateEntityFromDTO(existing, requestDTO);

                InstituteSocialLinkEntity updated = instituteSocialLinkRepository.save(existing);
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] updateSocialLink() succeeded - Social link with id: {} updated successfully",
                                id);
                return InstituteSocialLinkMapper.toResponseDTO(updated);
        }

        @Override
        public void deleteById(Long id) {
                Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
                if (contextInstituteId == null) {
                        throw new ApiException(InstituteSocialLinkErrors.ORGANIZATION_ACCESS_DENIED,
                                        "Unable to identify your organization context for deletion.",
                                        HttpStatus.FORBIDDEN);
                }
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] deleteById() called - Deleting social link by id: {} and institute id: {}",
                                id, contextInstituteId);
                if (!instituteSocialLinkRepository.existsByIdAndInstituteId(id, contextInstituteId)) {
                        throw new ApiException(InstituteSocialLinkErrors.LINK_NOT_FOUND,
                                        "Social link not found or you don't have permission to delete it.",
                                        HttpStatus.NOT_FOUND);
                }
                instituteSocialLinkRepository.deleteById(id);
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] deleteById() succeeded - Social link with id: {} deleted successfully",
                                id);
        }

        @Override
        public List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword) {
                Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
                if (contextInstituteId == null) {
                        throw new ApiException(InstituteSocialLinkErrors.ORGANIZATION_ACCESS_DENIED,
                                        HttpStatus.FORBIDDEN);
                }
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] searchByKeyword() called - Searching social links with keyword: '{}' for institute id: {}",
                                keyword,
                                contextInstituteId);
                List<InstituteSocialLinkEntity> result = instituteSocialLinkRepository
                                .searchByKeywordAndInstituteId(keyword == null ? "" : keyword.trim(),
                                                contextInstituteId);
                List<InstituteSocialLinkResponseDTO> responseDTOs = InstituteSocialLinkMapper.toResponseDTOList(result);
                log.info(
                                "[Service:InstituteSocialLinkServiceImpl] searchByKeyword() succeeded - Found {} matches for search keyword: '{}' in institute id: {}",
                                responseDTOs.size(), keyword,
                                contextInstituteId);
                return responseDTOs;
        }
}
