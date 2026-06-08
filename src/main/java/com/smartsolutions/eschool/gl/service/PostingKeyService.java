package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.dtos.postingKey.request.PostingKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.postingKey.response.PostingKeyResponseDTO;
import com.smartsolutions.eschool.gl.mapper.PostingKeyMapper;
import com.smartsolutions.eschool.gl.model.PostingKeyEntity;
import com.smartsolutions.eschool.gl.repository.PostingKeyRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.gl.error.GLAccountErrors;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostingKeyService {

    private final PostingKeyRepository postingKeyRepository;
    private final com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public List<PostingKeyResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:PostingKeyService] getAll() called - Organization: {}", organizationId);
        List<PostingKeyEntity> entities = postingKeyRepository.findAllByOrganizationId(organizationId);
        return PostingKeyMapper.toResponseDTOList(entities);
    }

    public PostingKeyResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:PostingKeyService] getById() called - ID: {}, Org: {}", id, organizationId);
        PostingKeyEntity entity = postingKeyRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
        return PostingKeyMapper.toResponseDTO(entity);
    }

    @Transactional
    public PostingKeyResponseDTO create(PostingKeyRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:PostingKeyService] create() called - Code: {}", requestDTO.getCode());

        if (postingKeyRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
            throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
        }

        PostingKeyEntity entity = PostingKeyMapper.toEntity(requestDTO);
        entity.setOrganizationId(organizationId);
        PostingKeyEntity saved = postingKeyRepository.save(entity);
        return PostingKeyMapper.toResponseDTO(saved);
    }

    @Transactional
    public PostingKeyResponseDTO update(Long id, PostingKeyRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:PostingKeyService] update() called - ID: {}", id);

        PostingKeyEntity existing = postingKeyRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!existing.getCode().equals(requestDTO.getCode().trim())) {
            if (postingKeyRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId, requestDTO.getCode().trim(), id)) {
                throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
            }
        }

        PostingKeyMapper.updateEntityFromDTO(existing, requestDTO);
        PostingKeyEntity updated = postingKeyRepository.save(existing);
        return PostingKeyMapper.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        entityReferenceValidator.ensureNotReferenced(PostingKeyEntity.class, id);
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:PostingKeyService] delete() called - ID: {}", id);
        int result = postingKeyRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public List<PostingKeyResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:PostingKeyService] search() called - Keyword: {}", keyword);
        List<PostingKeyEntity> entities = postingKeyRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        return PostingKeyMapper.toResponseDTOList(entities);
    }
}
