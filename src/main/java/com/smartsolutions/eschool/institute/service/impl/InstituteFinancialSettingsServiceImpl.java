package com.smartsolutions.eschool.institute.service.impl;


import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.entity.InstituteFinancialSettings;
import com.smartsolutions.eschool.institute.mapper.FinancialSettingsMapper;
import com.smartsolutions.eschool.institute.repository.InstituteFinancialSettingsRepository;
import com.smartsolutions.eschool.institute.service.InstituteFinancialSettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstituteFinancialSettingsServiceImpl implements InstituteFinancialSettingsService {

    private final InstituteFinancialSettingsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public FinancialSettingsResponseDTO getByInstituteAndAcademicYear(Long instituteId, Long academicYearId) {
        log.info("Fetching financial settings for institute: {} and academic year: {}", instituteId, academicYearId);
        
        InstituteFinancialSettings settings = repository
                .findByInstituteIdAndAcademicYearIdAndIsDeletedFalse(instituteId, academicYearId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Financial settings not found for institute: " + instituteId + " and academic year: " + academicYearId));
        
        return FinancialSettingsMapper.toDTO(settings);
    }

    @Override
    @Transactional
    public FinancialSettingsResponseDTO create(FinancialSettingsRequestDTO requestDTO) {
        log.info("Creating financial settings for institute: {} and academic year: {}", 
                requestDTO.getInstituteId(), requestDTO.getAcademicYearId());
        
        // Check if settings already exist for this institute and academic year
        repository.findByInstituteIdAndAcademicYearIdAndIsDeletedFalse(
                requestDTO.getInstituteId(), requestDTO.getAcademicYearId())
                .ifPresent(existing -> {
                    throw new IllegalStateException(
                            "Financial settings already exist for institute: " + requestDTO.getInstituteId() + 
                            " and academic year: " + requestDTO.getAcademicYearId());
                });
        
        InstituteFinancialSettings entity = FinancialSettingsMapper.toEntity(requestDTO);
        InstituteFinancialSettings saved = repository.save(entity);
        
        log.info("Financial settings created with ID: {}", saved.getId());
        return FinancialSettingsMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public FinancialSettingsResponseDTO update(Long id, FinancialSettingsRequestDTO requestDTO) {
        log.info("Updating financial settings with ID: {}", id);
        
        InstituteFinancialSettings existing = repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Financial settings not found with ID: " + id));
        
        FinancialSettingsMapper.updateEntityFromDTO(requestDTO, existing);
        InstituteFinancialSettings updated = repository.save(existing);
        
        log.info("Financial settings updated successfully with ID: {}", id);
        return FinancialSettingsMapper.toDTO(updated);
    }

    @Override
    @Transactional
    public void softDeleteById(Long id) {
        log.info("Soft deleting financial settings with ID: {}", id);
        
        InstituteFinancialSettings settings = repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Financial settings not found with ID: " + id));
        
        settings.setIsDeleted(true);
        repository.save(settings);
        
        log.info("Financial settings soft deleted successfully with ID: {}", id);
    }
}
