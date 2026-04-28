package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupResponseDTO;
import com.smartsolutions.eschool.student.mapper.FeeSlabGroupMapper;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.student.model.FeeSlabGroupEntity;
import com.smartsolutions.eschool.student.repository.FeeComponentRepository;
import com.smartsolutions.eschool.student.repository.FeeSlabGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeeSlabGroupService {

    private final FeeSlabGroupRepository repository;
    private final FeeComponentRepository feeComponentRepository;

    public FeeSlabGroupService(FeeSlabGroupRepository repository, FeeComponentRepository feeComponentRepository) {
        this.repository = repository;
        this.feeComponentRepository = feeComponentRepository;
    }

    public List<FeeSlabGroupResponseDTO> getAll() {
        return FeeSlabGroupMapper.toResponseDTOList(repository.findByDeletedFalse());
    }

    public FeeSlabGroupResponseDTO getById(Long id) {
        FeeSlabGroupEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeSlabGroup not found with id: " + id));
        return FeeSlabGroupMapper.toResponseDTO(entity);
    }

    public List<FeeSlabGroupResponseDTO> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getAll();
        }
        return FeeSlabGroupMapper.toResponseDTOList(repository.searchFeeSlabGroups(keyword.trim()));
    }

    @Transactional
    public FeeSlabGroupResponseDTO create(FeeSlabGroupCreateRequestDTO dto) {
        FeeComponentEntity feeComponent = feeComponentRepository.findById(dto.getFeeComponentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "FeeComponent not found with id: " + dto.getFeeComponentId()));

        FeeSlabGroupEntity entity = FeeSlabGroupMapper.toEntity(dto);
        entity.setFeeComponent(feeComponent);

        FeeSlabGroupEntity saved = repository.save(entity);
        return FeeSlabGroupMapper.toResponseDTO(saved);
    }

    @Transactional
    public FeeSlabGroupResponseDTO update(Long id, FeeSlabGroupCreateRequestDTO dto) {
        FeeSlabGroupEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeSlabGroup not found with id: " + id));

        if (dto.getFeeComponentId() != null && (entity.getFeeComponent() == null
                || !entity.getFeeComponent().getId().equals(dto.getFeeComponentId()))) {
            FeeComponentEntity feeComponent = feeComponentRepository.findById(dto.getFeeComponentId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "FeeComponent not found with id: " + dto.getFeeComponentId()));
            entity.setFeeComponent(feeComponent);
        }

        FeeSlabGroupMapper.updateEntityFromDTO(entity, dto);
        FeeSlabGroupEntity saved = repository.save(entity);
        return FeeSlabGroupMapper.toResponseDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        FeeSlabGroupEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeSlabGroup not found with id: " + id));

        repository.delete(entity);
    }
}
