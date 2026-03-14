package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.error.FeeComponentErrors;
import com.smartsolutions.eschool.student.mapper.FeeComponentMapper;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.repository.FeeCatalogRepository;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FeeComponentService {

    private final FeeComponentRepository feeComponentRepository;
    private final FeeCatalogRepository feeCatalogRepository;

    public FeeComponentService(
            FeeComponentRepository feeComponentRepository,
            FeeCatalogRepository feeCatalogRepository
    ) {
        this.feeComponentRepository = feeComponentRepository;
        this.feeCatalogRepository = feeCatalogRepository;
    }

    // ====================================
    // GET ALL COMPONENTS
    // ====================================

    public List<FeeComponentResponseDTO> getAll() throws ApiException {

        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        if (organizationId == null) {
            throw new ApiException(
                    FeeComponentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:FeeComponentService] getAll() called - institute: {}", organizationId);

        List<FeeComponentEntity> result =
                feeComponentRepository.findByOrganization(organizationId);

        List<FeeComponentResponseDTO> response =
                FeeComponentMapper.toDtoList(result);

        log.info("[Service:FeeComponentService] getAll() succeeded - Found {} components", response.size());

        return response;
    }

    // ====================================
    // GET COMPONENT BY ID
    // ====================================

    public FeeComponentResponseDTO getById(Long id) {

        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        if (organizationId == null) {
            throw new ApiException(
                    FeeComponentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:FeeComponentService] getById() called - id: {}, institute: {}", id, organizationId);

        FeeComponentEntity entity =
                feeComponentRepository.findByIdWithDetails(id)
                        .orElseThrow(() ->
                                new ApiException(
                                        FeeComponentErrors.FEE_COMPONENT_NOT_FOUND,
                                        HttpStatus.NOT_FOUND
                                ));

        FeeComponentResponseDTO response =
                FeeComponentMapper.toDto(entity);

        log.info("[Service:FeeComponentService] getById() succeeded - id: {}", id);

        return response;
    }

    // ====================================
    // GET BY CATALOG
    // ====================================

    public List<FeeComponentResponseDTO> getByCatalog(Long catalogId) {

        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        if (organizationId == null) {
            throw new ApiException(
                    FeeComponentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:FeeComponentService] getByCatalog() called - catalogId: {}", catalogId);

        List<FeeComponentEntity> result =
                feeComponentRepository.findByCatalogIdWithDetails(catalogId);

        List<FeeComponentResponseDTO> response =
                FeeComponentMapper.toDtoList(result);

        log.info("[Service:FeeComponentService] getByCatalog() succeeded - Found {} components", response.size());

        return response;
    }

    // ====================================
    // SEARCH COMPONENTS
    // ====================================

    public List<FeeComponentResponseDTO> search(Long catalogId, String keyword) {

        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        if (organizationId == null) {
            throw new ApiException(
                    FeeComponentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:FeeComponentService] search() called - catalogId: {}, keyword: {}", catalogId, keyword);

        List<FeeComponentEntity> result =
                feeComponentRepository.searchComponents(catalogId, keyword);

        List<FeeComponentResponseDTO> response =
                FeeComponentMapper.toDtoList(result);

        log.info("[Service:FeeComponentService] search() succeeded - Found {} components", response.size());

        return response;
    }

    // ====================================
    // CREATE COMPONENT
    // ====================================

    @Transactional
    public FeeComponentResponseDTO create(FeeCatalogComponentRequestDTO requestDTO) {

        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        if (organizationId == null) {
            throw new ApiException(
                    FeeComponentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:FeeComponentService] create() called - catalogId: {}", requestDTO.getFeeCatalogId());

        FeeCatalogEntity catalog =
                feeCatalogRepository.findById(requestDTO.getFeeCatalogId())
                        .orElseThrow(() ->
                                new ApiException(
                                        FeeComponentErrors.FEE_CATALOG_NOT_FOUND,
                                        HttpStatus.NOT_FOUND
                                ));

        Optional<FeeComponentEntity> duplicate =
                feeComponentRepository.findByComponentCodeAndCatalogId(
                        requestDTO.getComponentCode(),
                        catalog.getId()
                );

        if (duplicate.isPresent()) {
            throw new ApiException(
                    FeeComponentErrors.DUPLICATE_FEE_COMPONENT_CODE,
                    HttpStatus.CONFLICT
            );
        }

        FeeComponentEntity entity =
                FeeComponentMapper.toEntity(requestDTO);

        entity.setFeeCatalog(catalog);

        FeeComponentEntity saved =
                feeComponentRepository.save(entity);

        log.info("[Service:FeeComponentService] create() succeeded - id: {}", saved.getId());

        return FeeComponentMapper.toDto(saved);
    }

    // ====================================
    // UPDATE COMPONENT
    // ====================================

    @Transactional
    public FeeComponentResponseDTO update(Long id, FeeCatalogComponentRequestDTO requestDTO) {

        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        if (organizationId == null) {
            throw new ApiException(
                    FeeComponentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:FeeComponentService] update() called - id: {}", id);

        FeeComponentEntity existing =
                feeComponentRepository.findById(id)
                        .orElseThrow(() ->
                                new ApiException(
                                        FeeComponentErrors.FEE_COMPONENT_NOT_FOUND,
                                        HttpStatus.NOT_FOUND
                                ));

        if (requestDTO.getFeeCatalogId() != null) {

            FeeCatalogEntity catalog =
                    feeCatalogRepository.findById(requestDTO.getFeeCatalogId())
                            .orElseThrow(() ->
                                    new ApiException(
                                            FeeComponentErrors.FEE_CATALOG_NOT_FOUND,
                                            HttpStatus.NOT_FOUND
                                    ));

            existing.setFeeCatalog(catalog);
        }

        FeeComponentMapper.updateEntityFromDto(existing, requestDTO);

        FeeComponentEntity updated =
                feeComponentRepository.save(existing);

        log.info("[Service:FeeComponentService] update() succeeded - id: {}", id);

        return FeeComponentMapper.toDto(updated);
    }

}