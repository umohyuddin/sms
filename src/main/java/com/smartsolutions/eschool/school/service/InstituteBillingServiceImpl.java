package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.requestDto.InstituteBillingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBilling.responseDto.InstituteBillingResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteBillingEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteBillingRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstituteBillingServiceImpl implements InstituteBillingService {

    private final InstituteBillingRepository instituteBillingRepository;
    private final InstituteRepository instituteRepository;

    public InstituteBillingServiceImpl(InstituteBillingRepository instituteBillingRepository, InstituteRepository instituteRepository) {
        this.instituteBillingRepository = instituteBillingRepository;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteBillingResponseDTO createBilling(InstituteBillingCreateRequestDTO requestDTO) {
        try {
            InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
            InstituteBillingEntity entity = MapperUtil.mapObject(requestDTO, InstituteBillingEntity.class);
            entity.setId(null);
            entity.setInstitute(institute);
            InstituteBillingEntity saved = instituteBillingRepository.save(entity);
            InstituteBillingResponseDTO dto = MapperUtil.mapObject(saved, InstituteBillingResponseDTO.class);
            dto.setInstituteId(institute.getId());
            return dto;
        } catch (DataAccessException dae) {
            log.error("Database error while creating InstituteBilling", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating InstituteBilling", ex);
            throw ex;
        }
    }

    @Override
    public InstituteBillingResponseDTO getById(Long id) {
        InstituteBillingEntity entity = instituteBillingRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBilling not found with id: " + id));
        InstituteBillingResponseDTO dto = MapperUtil.mapObject(entity, InstituteBillingResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteBillingResponseDTO getByInstituteId(Long instituteId) {
        InstituteBillingEntity entity = instituteBillingRepository.findByInstituteId(instituteId)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBilling not found for institute id: " + instituteId));
        InstituteBillingResponseDTO dto = MapperUtil.mapObject(entity, InstituteBillingResponseDTO.class);
        dto.setInstituteId(entity.getInstitute().getId());
        return dto;
    }

    @Override
    public InstituteBillingResponseDTO updateBilling(Long id, InstituteBillingUpdateRequestDTO requestDTO) {
        InstituteBillingEntity existing = instituteBillingRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteBilling not found with id: " + id));

        if (requestDTO.getBillingEmail() != null) {
            existing.setBillingEmail(requestDTO.getBillingEmail());
        }
        if (requestDTO.getTaxNumber() != null) {
            existing.setTaxNumber(requestDTO.getTaxNumber());
        }
        if (requestDTO.getCurrency() != null) {
            existing.setCurrency(requestDTO.getCurrency());
        }
        if (requestDTO.getSubscriptionPlan() != null) {
            existing.setSubscriptionPlan(requestDTO.getSubscriptionPlan());
        }
        if (requestDTO.getPaymentCycle() != null) {
            existing.setPaymentCycle(requestDTO.getPaymentCycle());
        }
        if (requestDTO.getSubscriptionStart() != null) {
            existing.setSubscriptionStart(requestDTO.getSubscriptionStart());
        }
        if (requestDTO.getSubscriptionEnd() != null) {
            existing.setSubscriptionEnd(requestDTO.getSubscriptionEnd());
        }

        InstituteBillingEntity updated = instituteBillingRepository.save(existing);
        InstituteBillingResponseDTO dto = MapperUtil.mapObject(updated, InstituteBillingResponseDTO.class);
        dto.setInstituteId(updated.getInstitute().getId());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        if (instituteBillingRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("InstituteBilling not found with id: " + id);
        }
        instituteBillingRepository.deleteById(id);
    }

    @Override
    public List<InstituteBillingResponseDTO> searchByKeyword(String keyword) {
        List<InstituteBillingEntity> result = instituteBillingRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return result.stream().map(entity -> {
            InstituteBillingResponseDTO dto = MapperUtil.mapObject(entity, InstituteBillingResponseDTO.class);
            dto.setInstituteId(entity.getInstitute().getId());
            return dto;
        }).toList();
    }
}
