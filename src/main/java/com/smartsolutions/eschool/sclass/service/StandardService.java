package com.smartsolutions.eschool.sclass.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.CampusDTO;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.CampusDao;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SClassDao;
import com.smartsolutions.eschool.sclass.repository.StandardDao;
import com.smartsolutions.eschool.sclass.repository.StandardDaoImp;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.ResourceObject;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StandardService {
    @Autowired
    private StandardDao standardDao;

    @Autowired
    private ObjectMapper objectMapper; //

//    public List<ResourceObject> getAll() {
//        log.info("Fetching all standards from database");
//        List<StandardEntity> result = standardDao.findAll();
//        log.info("Successfully fetched {} standards", result.size());
//        return result.stream().map(entity -> {
//            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
//            return new ResourceObject(String.valueOf(entity.getId()), "standards",
//                    resourceAttributes);
//        }).collect(Collectors.toList());
//    }


    @Autowired
    private CampusDao campusDao;


    @Autowired
    private StandardRepository standardRepository;

    public List<StandardDTO> getAll() {
        try {
            log.info("Fetching all Standards from database");
            //List<CampusEntity> result = campusDao.findAll();
            List<StandardEntity> result = standardRepository.findByDeletedFalse();
            log.info("Successfully fetched {} Standards", result.size());
            List<StandardDTO> campusDTOList = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards", campusDTOList);
            return campusDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Standards", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Standards", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standards", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public StandardDTO getById(Long id) {
        log.info("Fetching Standard with id: {}", id);
        StandardEntity standardEntity = standardRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Standard with id: {}", id);
            return new ResourceNotFoundException("Standard not found with id: " + id);
        });
        StandardDTO standardDTO = MapperUtil.mapObject(standardEntity, StandardDTO.class);
        log.info("Successfully fetched Standard: id={}", standardDTO.getId());
        return standardDTO;
    }

    public List<StandardDTO> findByCampusId(Long id) {
        log.info("Fetching Standard by campus ID: {}", id);
        if (id == null) {
            log.error("Campus ID is null");
            throw new IllegalArgumentException("Campus ID must not be null");
        }

        List<StandardEntity> standardEntities = standardRepository.findByCampusIdAndDeletedFalse(id);
        if (standardEntities.isEmpty()) {
            log.warn("No Standard found for Campus ID: {}", id);
            return List.of(); // safe empty list
        }
        List<StandardDTO> standardDTOList = MapperUtil.mapList(standardEntities, StandardDTO.class);
        log.info("Found {} standards for campus ID: {}", standardDTOList.size(), id);
        return standardDTOList;
    }

    public List<StandardDTO> findByCampusNameContaining(String name) {
        log.info("Fetching standard containing name: '{}'", name);
        if (name == null || name.trim().isEmpty()) {
            log.error("Standard name is null or empty");
            throw new IllegalArgumentException("Standard name must not be null or empty");
        }

        List<StandardEntity> standardEntities = standardRepository.findByStandardNameContainingAndDeletedFalse(name);
        if (standardEntities.isEmpty()) {
            log.warn("No standards found for campus name: {}", name);
            return List.of(); // safe empty list
        }
        List<StandardDTO> standardDTOList = MapperUtil.mapList(standardEntities,StandardDTO.class);
        log.info("Found {} campuses containing name: '{}'", standardDTOList.size(), name);
        return standardDTOList;
    }

//    public SClassEntity getById(Long id) {
//        return SClassDao.findById(id);
//    }
//
//    public List<SClassEntity> getByTeacherId(Long id) {
//        return SClassDao.findByTeacherId(id);
//    }
//
//    public List<SClassEntity> getByCourseId(Long id) {
//        return SClassDao.findByCourseId(id);
//    }
//
//    public List<SClassEntity> getByStudentId(Long id) {
//        return SClassDao.findByStudentId(id);
//    }
//
//    public String create(SClassEntity pSClassEntity) {
//        return SClassDao.save(pSClassEntity) == 1 ? "class created" : "Error creating class";
//    }
//
//    public String update(SClassEntity pSClassEntity) {
//        return SClassDao.update(pSClassEntity) == 1 ? "class updated" : "Error updating class";
//    }
//
//    public String delete(Long id) {
//        return SClassDao.delete(id) == 1 ? "class deleted" : "Error deleting class";
//    }
}
