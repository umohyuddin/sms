package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.repository.SectionDao;
import com.smartsolutions.eschool.util.MapperUtil;
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
    private SectionDao sectionDao;


    public List<SectionDTO> getAll() {
        log.info("Fetching all sections from database");
        List<SectionEntity> result = sectionDao.findAll();

        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched {} sections", sectionDTO);
        return sectionDTO;

    }


    public SectionDTO getById(Long id) {
        try {
            log.info("Fetching section with id {} from database", id);
            SectionEntity result = sectionDao.findById(id);
            if (result == null) {
                log.warn("Section with id {} not found", id);
                throw new NotFoundException("Section not found with id: " + id);
            }
            SectionDTO sectionDTO = MapperUtil.mapObject(result, SectionDTO.class);
            log.info("Successfully fetched section with id {}", id);
            return sectionDTO;
        } catch (Exception e) {
            log.error("Error while fetching section with id {}: {}", id, e.getMessage(), e);
            throw new ServiceException("Failed to fetch section with id: " + id, e);
        }
    }
//
//    public List<SectionEntity> getByInstituteId(Long id) {
//        return nSectionDao.findByInstituteId(id);
//    }
//
//    public List<SectionEntity> getByCampusId(Long id) {
//        return nSectionDao.findByCampusId(id);
//    }
//
//    public List<SectionEntity> getByClassId(Long id) {
//        return nSectionDao.findByClassId(id);
//    }
//
//    public String create(SectionEntity pSectionEntity) {
//        return nSectionDao.save(pSectionEntity) == 1 ? "Section created" : "Error creating Section";
//    }
//
//    public String update(SectionEntity pSectionEntity) {
//        return nSectionDao.update(pSectionEntity) == 1 ? "Section updated" : "Error updating Section";
//    }
//
//    public String delete(Long id) {
//        return nSectionDao.delete(id) == 1 ? "Section deleted" : "Error deleting Section";
//    }
}
