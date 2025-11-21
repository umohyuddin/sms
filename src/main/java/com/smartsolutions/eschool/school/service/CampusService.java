package com.smartsolutions.eschool.school.service;
import com.smartsolutions.eschool.school.dtos.CampusDTO;
import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.CampusDao;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CampusService {

    @Autowired
    private CampusDao campusDao;



    public List<CampusDTO> getAll() {
        try {
            log.info("Fetching all Campuses from database");
            List<CampusEntity> result = campusDao.findAll();
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

//    public CampusEntity getById(Long id) {
//        return nCampusDao.findById(id);
//    }
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
