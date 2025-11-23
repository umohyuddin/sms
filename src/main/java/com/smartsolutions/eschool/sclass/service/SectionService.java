package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.repository.SectionDao;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Slf4j
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;


    public List<SectionDTO> getAll() {
        log.info("Fetching all sections from database");
        List<SectionEntity> result = sectionRepository.findByDeletedFalse();
        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched sections");
        return sectionDTO;
    }

    public SectionDTO getById(Long id) {
        log.info("Fetching Section with id: {}", id);
        SectionEntity sectionEntity = sectionRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Section with id: {}", id);
            return new ResourceNotFoundException("Section not found with id: " + id);
        });
        SectionDTO sectionDTO = MapperUtil.mapObject(sectionEntity, SectionDTO.class);
        log.info("Successfully fetched Section: id={}", sectionDTO.getId());
        return sectionDTO;
    }

    public List<SectionDTO> getByStandardId(Long standardId) {
        log.info("Fetching all sections by standard id {} from database", standardId);
        List<SectionEntity> result = sectionRepository.findByStandardIdAndDeletedFalse(standardId);
        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched sections by standard id {}", standardId);
        return sectionDTO;
    }

    public int softDeleteById(Long id) {
        log.info("Soft delete request received for Section ID: {}", id);
        try {
            return sectionRepository.softDeleteById(id);
        } catch (Exception e) {
            log.error("Error while soft deleting section with ID {}", id, e);
            throw e;
        }
    }

    public int softDeleteByStandardId(Long standardId) {
        log.info("Soft delete requested for sections under Standard ID: {}", standardId);
        try {
            int rows = sectionRepository.softDeleteByStandardId(standardId);
            if (rows == 0) {
                log.warn("No sections found for Standard ID {}. Nothing was updated.", standardId);
            } else {
                log.info("Soft delete succeeded. {} sections deleted for Standard ID {}", rows, standardId);
            }
            return rows;
        } catch (Exception e) {
            log.error("Error while soft deleting sections for Standard ID {}", standardId, e);
            throw e;
        }
    }

    public int softDeleteAll() {
        log.info("Soft delete ALL sections requested.");
        try {
            int rows = sectionRepository.softDeleteAll();
            if (rows == 0) {
                log.warn("Soft delete completed but no sections were updated.");
            } else {
                log.info("Successfully soft deleted ALL sections. Total affected: {}", rows);
            }
            return rows;
        } catch (Exception e) {
            log.error("Error occurred while soft deleting ALL sections", e);
            throw e;
        }
    }

    public List<SectionDTO> searchByKeyword(String keyword) {
        log.info("Fetching all sections by keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            log.error("Keyword is null or empty");
            throw new ValidationException("Keyword must not be empty");
        }
        List<SectionEntity> result = sectionRepository.searchByKeyword(keyword);
        if (result.isEmpty()) {
            log.warn("No sections found for keyword: {}", keyword);
            throw new ResourceNotFoundException("No sections found matching: " + keyword);
        }
        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched {} sections", sectionDTO.size());
        return sectionDTO;
    }

}

