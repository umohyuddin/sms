package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.subjects.request.SubjectRequest;
import com.smartsolutions.eschool.school.dtos.subjects.response.SubjectResponse;
import com.smartsolutions.eschool.school.model.AcademicSubjectEntity;
import com.smartsolutions.eschool.school.repository.SubjectRepository_;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class AcademicSubjectService {

    private final SubjectRepository_ subjectRepository;

    public AcademicSubjectService(SubjectRepository_ subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectResponse> getAll() {
        try {
            log.info("Fetching all Subjects from database");
            List<AcademicSubjectEntity> result = subjectRepository.findByDeletedFalse();
            log.info("Successfully fetched {} Subjects", result.size());
            List<SubjectResponse> responseList = MapperUtil.mapList(result, SubjectResponse.class);
            log.info("Mapped {} Subjects to DTOs", responseList.size());
            return responseList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Subjects", dae);
        } catch (MappingException me) {
            log.error("Error mapping SubjectEntity to SubjectResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Subjects", e);
        }
        return Collections.emptyList();
    }

    public SubjectResponse getById(Long id) {
        log.info("Fetching Subject with id: {}", id);
        try {
            AcademicSubjectEntity subjectEntity = subjectRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> {
                        log.warn("Subject not found with id: {}", id);
                        return new ResourceNotFoundException("Subject not found with id: " + id);
                    });

            SubjectResponse responseDTO = MapperUtil.mapObject(subjectEntity, SubjectResponse.class);
            log.info("Successfully fetched Subject: id={}", responseDTO.getId());
            return responseDTO;

        } catch (ResourceNotFoundException rnfe) {
            throw rnfe;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Subject with id {}", id, dae);
            throw new CustomServiceException("Database error while fetching Subject", dae);
        } catch (MappingException me) {
            log.error("Mapping error while converting SubjectEntity to DTO", me);
            throw new CustomServiceException("Error mapping Subject data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Subject with id {}", id, e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public List<SubjectResponse> searchByKeyword(String keyword) {
        log.info("Searching Subjects by keyword: '{}'", keyword);
        try {
            List<AcademicSubjectEntity> result = subjectRepository.searchByKeyword(keyword);
            List<SubjectResponse> responseList = MapperUtil.mapList(result, SubjectResponse.class);
            log.info("Found {} Subjects matching keyword '{}'", responseList.size(), keyword);
            return responseList;
        } catch (DataAccessException dae) {
            log.error("Database error while searching Subjects", dae);
            throw new CustomServiceException("Unable to search Subjects from database", dae);
        } catch (MappingException me) {
            log.error("Mapping error while converting SubjectEntity to DTO during search", me);
            throw new CustomServiceException("Error converting Subject data during search", me);
        } catch (Exception e) {
            log.error("Unexpected error while searching Subjects with keyword '{}'", keyword, e);
            throw new CustomServiceException("Unexpected error occurred during search", e);
        }
    }

    public int softDeleteById(Long id) {
        log.info("Soft delete request received for Subject ID: {}", id);
        try {
            int result = subjectRepository.softDeleteById(id);
            if (result == 0) {
                log.warn("Subject not found or already deleted: {}", id);
            } else {
                log.info("Subject soft deleted successfully: {}", id);
            }
            return result;
        } catch (Exception e) {
            log.error("Error while soft deleting Subject with ID {}", id, e);
            throw new CustomServiceException("Failed to soft delete Subject", e);
        }
    }

    public SubjectResponse createSubject(SubjectRequest requestDTO) {
        log.info("Creating new Subject: {}", requestDTO);
        try {
            AcademicSubjectEntity entity = MapperUtil.mapObject(requestDTO, AcademicSubjectEntity.class);
            entity.setId(null); // Ensure ID is null for new record

            AcademicSubjectEntity saved = subjectRepository.save(entity);
            SubjectResponse responseDTO = MapperUtil.mapObject(saved, SubjectResponse.class);
            log.info("Subject created successfully with ID: {}", responseDTO.getId());
            return responseDTO;

        } catch (DataAccessException dae) {
            log.error("Database error while creating Subject", dae);
            throw new CustomServiceException("Unable to create Subject in database", dae);
        } catch (MappingException me) {
            log.error("Error mapping SubjectEntity to DTO while creating Subject", me);
            throw new CustomServiceException("Error converting Subject data", me);
        } catch (Exception e) {
            log.error("Unexpected error creating Subject", e);
            throw new CustomServiceException("Unexpected error occurred while creating Subject", e);
        }
    }

    public SubjectResponse updateSubject(Long id, @Valid SubjectRequest requestDTO) {
        log.info("Updating Subject with id {} using DTO {}", id, requestDTO);
        try {
            AcademicSubjectEntity entity = subjectRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));

            if (requestDTO.getCode() != null) entity.setCode(requestDTO.getCode());
            if (requestDTO.getName() != null) entity.setName(requestDTO.getName());
            if (requestDTO.getDescription() != null) entity.setDescription(requestDTO.getDescription());
            if (requestDTO.getIsCore() != null) entity.setIsCore(requestDTO.getIsCore());
            if (requestDTO.getActive() != null) entity.setActive(requestDTO.getActive());

            AcademicSubjectEntity updated = subjectRepository.save(entity);
            SubjectResponse responseDTO = MapperUtil.mapObject(updated, SubjectResponse.class);
            log.info("Subject updated successfully: id={}", responseDTO.getId());
            return responseDTO;

        } catch (ResourceNotFoundException rnfe) {
            throw rnfe;
        } catch (DataAccessException dae) {
            log.error("Database error while updating Subject with id {}", id, dae);
            throw new CustomServiceException("Unable to update Subject in database", dae);
        } catch (MappingException me) {
            log.error("Error mapping SubjectEntity to DTO while updating", me);
            throw new CustomServiceException("Error converting Subject data", me);
        } catch (Exception e) {
            log.error("Unexpected error while updating Subject with id {}", id, e);
            throw new CustomServiceException("Unexpected error occurred while updating Subject", e);
        }
    }
}
