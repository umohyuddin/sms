package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.school.model.AcademicSubjectEntity;
import com.smartsolutions.eschool.school.repository.SubjectRepository_;
import com.smartsolutions.eschool.sclass.dtos.standardSubject.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.standardSubject.response.StandardSubjectResponseDTO;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.model.StandardSubjectEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.sclass.repository.StandardSubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StandardSubjectService {


    private final StandardSubjectRepository repository;
    private final StandardRepository standardRepository;
    private final SubjectRepository_ subjectRepository;


    public StandardSubjectResponseDTO create(StandardSubjectRequestDTO dto) {

        if (repository.existsByStandard_IdAndSubject_Id(
                dto.getStandardId(), dto.getSubjectId())) {
            throw new IllegalStateException("Subject already assigned to this standard");
        }

        StandardEntity standard = standardRepository.findById(dto.getStandardId())
                .orElseThrow(() -> new EntityNotFoundException("Standard not found"));

        AcademicSubjectEntity subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        StandardSubjectEntity entity = StandardSubjectEntity.builder()
                .standard(standard)
                .subject(subject)
                .isOptional(dto.getIsOptional())
                .build();

        return mapToDTO(repository.save(entity));
    }

    public StandardSubjectResponseDTO update(Long id, StandardSubjectRequestDTO dto) {

        StandardSubjectEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mapping not found"));

        entity.setIsOptional(dto.getIsOptional());

        return mapToDTO(repository.save(entity));
    }

    public StandardSubjectResponseDTO getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Mapping not found"));
    }

    public List<StandardSubjectResponseDTO> getByStandard(Long standardId) {
        return repository.findByStandard_Id(standardId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public List<StandardSubjectResponseDTO> getBySubject(Long subjectId) {
        return repository.findBySubject_Id(subjectId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Mapping not found");
        }
        repository.deleteById(id);
    }

    private StandardSubjectResponseDTO mapToDTO(StandardSubjectEntity entity) {
        return StandardSubjectResponseDTO.builder()
                .id(entity.getId())
                .standardId(entity.getStandard().getId())
                .standardName(entity.getStandard().getStandardName())
                .subjectId(entity.getSubject().getId())
                .subjectName(entity.getSubject().getName())
                .isOptional(entity.getIsOptional())
                .build();
    }
}
