package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.CampusDTO;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.CampusDao;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CampusService {

    @Autowired
    private CampusDao campusDao;


    @Autowired
    private CampusRepository campusRepository;

    public List<CampusDTO> getAll() {
        try {
            log.info("Fetching all Campuses from database");
            //List<CampusEntity> result = campusDao.findAll();
            List<CampusEntity> result = campusRepository.findByDeletedFalse();
            log.info("Successfully fetched {} Campuses", result.size());
            List<CampusDTO> campusDTOList = MapperUtil.mapList(result, CampusDTO.class);
            log.info("Successfully fetched {} Campuses", campusDTOList);
            return campusDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Campuses", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Campuses", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Campuses", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public CampusDTO getById(Long id) {
        log.info("Fetching Campus with id: {}", id);
        CampusEntity campusEntity = campusRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Campus with id: {}", id);
            return new ResourceNotFoundException("Campus not found with id: " + id);
        });
        CampusDTO campusDTO = MapperUtil.mapObject(campusEntity, CampusDTO.class);
        log.info("Successfully fetched Campus: id={}", campusDTO.getId());
        return campusDTO;
    }

    public List<CampusDTO> findByInstituteId(Long id) {
        log.info("Fetching campuses for institute ID: {}", id);
        if (id == null) {
            log.error("Institute ID is null");
            throw new IllegalArgumentException("Institute ID must not be null");
        }

        List<CampusEntity> campusEntities = campusRepository.findByInstituteIdAndDeletedFalse(id);
        if (campusEntities.isEmpty()) {
            log.warn("No campuses found for institute ID: {}", id);
            return List.of(); // safe empty list
        }
        List<CampusDTO> campusDTOList = MapperUtil.mapList(campusEntities, CampusDTO.class);
        log.info("Found {} campuses for institute ID: {}", campusDTOList.size(), id);
        return campusDTOList;
    }

    public List<CampusDTO> findByCampusNameContaining(String name) {
        log.info("Fetching campuses containing name: '{}'", name);
        if (name == null || name.trim().isEmpty()) {
            log.error("Campus name is null or empty");
            throw new IllegalArgumentException("Campus name must not be null or empty");
        }

        List<CampusEntity> campusEntities = campusRepository.findByCampusNameContainingAndDeletedFalse(name);
        if (campusEntities.isEmpty()) {
            log.warn("No campuses found for institute name: {}", name);
            return List.of(); // safe empty list
        }
        List<CampusDTO> campusDTOList = MapperUtil.mapList(campusEntities, CampusDTO.class);
        log.info("Found {} campuses containing name: '{}'", campusDTOList.size(), name);
        return campusDTOList;
    }


//
//    public String create(CampusEntity pCampusEntity) {
//        return nCampusDao.save(pCampusEntity) == 1 ? "Campus created" : "Error creating Campus";
//    }
//
//    public String update(CampusEntity pCampusEntity) {
//        return nCampusDao.update(pCampusEntity) == 1 ? "Campus updated" : "Error updating Campus";
//    }
//
//    public String delete(Long id) {
//        return nCampusDao.delete(id) == 1 ? "Campus deleted" : "Error deleting Campus";
//    }
}
