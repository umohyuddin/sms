package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.configs.FeeConfig;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.student.repository.AdmissionTypeRepository;
import com.smartsolutions.eschool.student.repository.FeeCatalogRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdmissionTypeService {
    private final AdmissionTypeRepository admissionTypeRepository;

    public AdmissionTypeService(AdmissionTypeRepository admissionTypeRepository) {
        this.admissionTypeRepository = admissionTypeRepository;
    }
    public List<AdmissionTypeResponseDTO> getAll() {
        try {
            log.info("Fetching all Admission Types from database");
            List<AdmissionTypeEntity> result = admissionTypeRepository.getAllActiveAdmissionTypes();
            return MapperUtil.mapList(result, AdmissionTypeResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Admission Types", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Admission Types", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Admission Types", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }
}
