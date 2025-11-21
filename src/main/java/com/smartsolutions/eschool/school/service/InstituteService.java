package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteDao;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
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
public class InstituteService {
    @Autowired
    private InstituteDao instituteDao;


    public List<InstituteDTO> getAll() {
        try {
            log.info("Fetching all Ins from database");
            List<InstituteEntity> result = instituteDao.findAll();
            log.info("Successfully fetched {} Ins", result.size());
            List<InstituteDTO> instituteDTOList = MapperUtil.mapList(result, InstituteDTO.class);
            log.info("Successfully fetched {} Ins", instituteDTOList);
            return instituteDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Ins", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Ins", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Ins", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

//    public InstituteEntity getById(Long id) {
//        return nInstituteDao.findById(id);
//    }
//
//    public String create(InstituteEntity pInstituteEntity) {
//        return nInstituteDao.save(pInstituteEntity) == 1 ? "Institute created" : "Error creating Institute";
//    }
//
//    public String update(InstituteEntity pInstituteEntity) {
//        return nInstituteDao.update(pInstituteEntity) == 1 ? "Institute updated" : "Error updating Institute";
//    }
//
//    public String delete(Long id) {
//        return nInstituteDao.delete(id) == 1 ? "Institute deleted" : "Error deleting Institute";
//    }
}
