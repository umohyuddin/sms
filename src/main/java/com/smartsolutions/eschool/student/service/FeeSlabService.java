package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabResponseDTO;
import com.smartsolutions.eschool.student.mapper.FeeSlabMapper;
import com.smartsolutions.eschool.student.model.FeeSlabEntity;
import com.smartsolutions.eschool.student.model.FeeSlabGroupEntity;
import com.smartsolutions.eschool.student.repository.FeeSlabGroupRepository;
import com.smartsolutions.eschool.student.repository.FeeSlabRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeeSlabService {

    private final FeeSlabRepository repository;
    private final FeeSlabGroupRepository groupRepository;

    public FeeSlabService(FeeSlabRepository repository, FeeSlabGroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    public List<FeeSlabResponseDTO> getAll() {
        return FeeSlabMapper.toResponseDTOList(repository.findByDeletedFalse());
    }

    public FeeSlabResponseDTO getById(Long id) {
        FeeSlabEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeSlab not found with id: " + id));
        return FeeSlabMapper.toResponseDTO(entity);
    }

    public List<FeeSlabResponseDTO> getByGroupId(Long groupId) {
        return FeeSlabMapper.toResponseDTOList(repository.findBySlabGroupId(groupId));
    }

    @Transactional
    public FeeSlabResponseDTO create(FeeSlabCreateRequestDTO dto) {
        FeeSlabGroupEntity group = groupRepository.findByIdAndDeletedFalse(dto.getSlabGroupId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("FeeSlabGroup not found with id: " + dto.getSlabGroupId()));

        if (dto.getMaxValue() != null && dto.getMaxValue().compareTo(dto.getMinValue()) < 0) {
            throw new IllegalArgumentException("max_value must be greater than or equal to min_value");
        }

        FeeSlabEntity entity = FeeSlabMapper.toEntity(dto);
        entity.setSlabGroup(group);

        FeeSlabEntity saved = repository.save(entity);
        return FeeSlabMapper.toResponseDTO(saved);
    }

    @Transactional
    public FeeSlabResponseDTO update(Long id, FeeSlabCreateRequestDTO dto) {
        FeeSlabEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeSlab not found with id: " + id));

        if (dto.getSlabGroupId() != null
                && (entity.getSlabGroup() == null || !entity.getSlabGroup().getId().equals(dto.getSlabGroupId()))) {
            FeeSlabGroupEntity group = groupRepository.findByIdAndDeletedFalse(dto.getSlabGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "FeeSlabGroup not found with id: " + dto.getSlabGroupId()));
            entity.setSlabGroup(group);
        }

        if (dto.getMaxValue() != null && dto.getMinValue() != null
                && dto.getMaxValue().compareTo(dto.getMinValue()) < 0) {
            throw new IllegalArgumentException("max_value must be greater than or equal to min_value");
        }

        FeeSlabMapper.updateEntityFromDTO(entity, dto);
        FeeSlabEntity saved = repository.save(entity);
        return FeeSlabMapper.toResponseDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        FeeSlabEntity entity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeSlab not found with id: " + id));

        repository.delete(entity);
    }
}
