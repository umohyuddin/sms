package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.repository.SClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SClassService {
    private final SClassRepository sClassRepository;

    public SClassService(SClassRepository sClassRepository) {
        this.sClassRepository = sClassRepository;
    }

    public List<SClassEntity> getAll() {
        log.info("SClassService: Fetching all SClasses");
        try {
            List<SClassEntity> result = sClassRepository.findAll();
            log.info("SClassService: Successfully fetched {} SClasses", result.size());
            return result;
        } catch (Exception e) {
            log.error("SClassService: Error fetching SClasses", e);
            throw new CustomServiceException("Failed to fetch all SClasses");
        }
    }

    public SClassEntity getById(Long id) {
        log.info("SClassService: Fetching SClass by ID: {}", id);
        try {
            return sClassRepository.findById(id.intValue())
                    .orElseThrow(() -> new ResourceNotFoundException("SClass not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("SClassService: Error fetching SClass ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch SClass by ID");
        }
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        log.info("SClassService: Fetching SClasses for teacher ID: {}", id);
        try {
            return sClassRepository.findByTeacherId(id);
        } catch (Exception e) {
            log.error("SClassService: Error fetching SClasses for teacher ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch SClasses by teacher ID");
        }
    }

    public List<SClassEntity> getByCourseId(Long id) {
        log.info("SClassService: Fetching SClasses for course ID: {}", id);
        try {
            return sClassRepository.findByCourseId(id);
        } catch (Exception e) {
            log.error("SClassService: Error fetching SClasses for course ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch SClasses by course ID");
        }
    }

    public List<SClassEntity> getByStudentId(Long id) {
        log.info("SClassService: Fetching SClasses for student ID: {}", id);
        try {
            return sClassRepository.findByStudentId(id);
        } catch (Exception e) {
            log.error("SClassService: Error fetching SClasses for student ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch SClasses by student ID");
        }
    }

    @Transactional
    public String create(SClassEntity entity) {
        log.info("SClassService: Creating new SClass: {}", entity.getName());
        try {
            sClassRepository.save(entity);
            log.info("SClassService: Successfully created SClass: {}", entity.getName());
            return "class created";
        } catch (Exception e) {
            log.error("SClassService: Error creating SClass: {}", entity.getName(), e);
            throw new CustomServiceException("Failed to create SClass");
        }
    }

    @Transactional
    public String update(SClassEntity entity) {
        log.info("SClassService: Updating SClass ID: {}", entity.getId());
        try {
            if (!sClassRepository.existsById(entity.getId())) {
                throw new ResourceNotFoundException("SClass not found with id: " + entity.getId());
            }
            sClassRepository.save(entity);
            log.info("SClassService: Successfully updated SClass ID: {}", entity.getId());
            return "class updated";
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("SClassService: Error updating SClass ID: {}", entity.getId(), e);
            throw new CustomServiceException("Failed to update SClass");
        }
    }

    @Transactional
    public String delete(Long id) {
        log.info("SClassService: Deleting SClass ID: {}", id);
        try {
            if (!sClassRepository.existsById(id.intValue())) {
                throw new ResourceNotFoundException("SClass not found with id: " + id);
            }
            sClassRepository.deleteById(id.intValue());
            log.info("SClassService: Successfully deleted SClass ID: {}", id);
            return "class deleted";
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("SClassService: Error deleting SClass ID: {}", id, e);
            throw new CustomServiceException("Failed to delete SClass");
        }
    }

    public List<SClassEntity> searchByKeyword(String keyword) {
        log.info("SClassService: Searching SClasses with keyword: '{}'", keyword);
        try {
            List<SClassEntity> result = sClassRepository.searchByKeyword(keyword);
            log.info("SClassService: Found {} results", result.size());
            return result;
        } catch (Exception e) {
            log.error("SClassService: Error searching SClasses", e);
            throw new CustomServiceException("Failed to search SClasses");
        }
    }
}
